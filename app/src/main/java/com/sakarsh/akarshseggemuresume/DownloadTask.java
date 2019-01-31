package com.sakarsh.akarshseggemuresume;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class DownloadTask {

    private static final String TAG = "DownloadTask";
    private static final String downloadDirectory = "ResumeJSONDownloads";
    private String downloadURL;
    private Context context;
    private String downloadFileName;

    public DownloadTask(Context context, String downloadURL) {
        this.context = context;
        this.downloadURL = downloadURL;

        // Create a file name based on the downloadURL
        this.downloadFileName = downloadURL.replace(MainActivity.mainURL, "");
        if (downloadFileName.equals("de/resume.json")) this.downloadFileName = "DeutschResume.json";
        else if (downloadFileName.equals("en/resume.json"))
            this.downloadFileName = "EnglishResume.json";
        else
            this.downloadFileName = "profile.jpg";

        // execute downloading task
        new DownloadingTask().execute();
    }

    private class DownloadingTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... arg0) {

            try {
                URL url = new URL(downloadURL);
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
                httpsURLConnection.setRequestMethod("GET");
                httpsURLConnection.connect();

//                If the connection response is not OK then print log
                if (httpsURLConnection.getResponseCode() != HttpsURLConnection.HTTP_OK) {
                    Log.e(TAG, "Server returned HTTP " + httpsURLConnection.getResponseCode() + " " + httpsURLConnection.getResponseMessage());
                }

//                Checks if the application is running on an Emulator or not
                if (new CheckEmulator().isEmulator()) {
//                    Log.i(TAG, "On Emulator");
                    downloadInInternalStorage(httpsURLConnection);
                } else {
//                    Log.i(TAG, "Not on Emulator");
//                    Log.i(TAG, "Storage removable: " + new CheckExternalStorage().isExternalStorageRemovable());
//                    Checking if external storage is present and it is removable
                    if (new CheckExternalStorage().isExternalStoragePresent() && (new CheckExternalStorage().isExternalStorageRemovable())) {

                        File externalStorage = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/" + downloadDirectory);
                        if (!externalStorage.exists()) {
                            externalStorage.mkdirs();
//                            Log.i(TAG, downloadDirectory + " directory is created");
                            File outputFile = new File(externalStorage, downloadFileName);
//                            Log.i(TAG, outputFile + " file path");
                            downloadInExternalStorage(httpsURLConnection, outputFile);
                        } else {
                            File outputFile = new File(externalStorage, downloadFileName);
                            downloadInExternalStorage(httpsURLConnection, outputFile);
                        }
                    } else {
                        downloadInInternalStorage(httpsURLConnection);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        private void downloadInExternalStorage(HttpsURLConnection httpsURLConnection, File outputFile) throws IOException {
            if (!outputFile.exists()) {
                outputFile.createNewFile();
            }

            FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
            InputStream inputStream = httpsURLConnection.getInputStream();
            Bitmap bitmap = null;
            try {
                if (downloadFileName.equals("EnglishResume.json") || downloadFileName.equals("DeutschResume.json")) {
                    byte[] buffer = new byte[1024];
                    int initialLength;
                    while ((initialLength = inputStream.read(buffer)) != -1) {
                        fileOutputStream.write(buffer, 0, initialLength);
                    }
                } else if (downloadFileName.equals("profile.jpg")) {
                    bitmap = BitmapFactory.decodeStream(inputStream);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                }

                fileOutputStream.close();
                inputStream.close();
                httpsURLConnection.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void downloadInInternalStorage(HttpsURLConnection httpsURLConnection) {
            FileOutputStream fileOutputStream;
            Bitmap bitmap = null;
            try {
                fileOutputStream = context.openFileOutput(downloadFileName, Context.MODE_PRIVATE);
                InputStream inputStream = httpsURLConnection.getInputStream();
                if (downloadFileName.equals("EnglishResume.json") || downloadFileName.equals("DeutschResume.json")) {
                    byte[] buffer = new byte[1024];
                    int initialLength;
                    while ((initialLength = inputStream.read(buffer)) != -1) {
                        fileOutputStream.write(buffer, 0, initialLength);
                    }
                } else if (downloadFileName.equals("profile.jpg")) {
                    bitmap = BitmapFactory.decodeStream(inputStream);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                }
                fileOutputStream.close();
                inputStream.close();
                httpsURLConnection.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}
