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

public class DownloadImage {
    private static final String TAG = "DownloadImage";
    private static final String downloadDirectory = "ResumeJSONDownloads";
    private static final String downloadFileName = "profile.jpg";

    private String downloadURL;
    private Context context;

    public DownloadImage(Context context, String downloadURL) {
        this.context = context;
        this.downloadURL = downloadURL;
        new DownloadingImage().execute();
    }

    private class DownloadingImage extends AsyncTask<Void, Void, Void> {
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
//              Log.i(TAG, downloadFileName + " file is created");
            }

            FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
            InputStream inputStream = httpsURLConnection.getInputStream();
            Bitmap bitmap = null;
            try {
                bitmap = BitmapFactory.decodeStream(inputStream);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
//                Log.i(TAG, downloadFileName + " file has been written");
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
                bitmap = BitmapFactory.decodeStream(inputStream);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
//                Log.i(TAG, downloadFileName + " file has been written");
                fileOutputStream.close();
                inputStream.close();
                httpsURLConnection.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
