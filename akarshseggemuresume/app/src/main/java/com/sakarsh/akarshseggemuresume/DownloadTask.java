package com.sakarsh.akarshseggemuresume;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
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
                            if (!outputFile.exists()) {
                                outputFile.createNewFile();
//                                Log.i(TAG, downloadFileName + " file is created");
                            }

                            FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
                            InputStream inputStream = httpsURLConnection.getInputStream();
                            byte[] buffer = new byte[1024];
                            int initialLength;
                            while ((initialLength = inputStream.read(buffer)) != -1) {
                                fileOutputStream.write(buffer, 0, initialLength);
                            }
//                            Log.i(TAG, downloadFileName + " file has been written");
                            fileOutputStream.close();
                            inputStream.close();
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

        private void downloadInInternalStorage(HttpsURLConnection httpsURLConnection) {
            FileOutputStream fileOutputStream;

            try {
                fileOutputStream = context.openFileOutput(downloadFileName, Context.MODE_PRIVATE);
                InputStream inputStream = httpsURLConnection.getInputStream();
                byte[] buffer = new byte[1024];
                int initialLength;
                while ((initialLength = inputStream.read(buffer)) != -1) {
                    fileOutputStream.write(buffer, 0, initialLength);
                }
//                Log.i(TAG, downloadFileName + " file has been written");
                fileOutputStream.close();
                inputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}
