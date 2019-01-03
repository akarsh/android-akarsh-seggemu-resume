package com.sakarsh.akarshseggemuresume;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class DownloadTask {

    private static final String TAG = "Download Task";
    private static final String downloadDirectory = "Resume JSON Downloads";
    private String downloadURL = "";
    private Context context;
    private String downloadFileName = "";

    public DownloadTask(Context context, String downloadURL) {
        this.context = context;
        this.downloadURL = downloadURL;

        // Create a file name based on the downloadURL
        downloadFileName = downloadURL.replace(MainActivity.mainURL, "");
        if (downloadURL.replace(MainActivity.mainURL, "") == "de/resume.json") {
            downloadFileName = "EnglishResume.json";
        } else if (downloadURL.replace(MainActivity.mainURL, "") == "en/resume.json") {
            downloadFileName = "DeutschResume.json";
        }

        // execute downloading task
        new DownloadingTask().execute();
    }

    private class DownloadingTask extends AsyncTask<Void, Void, Void> {
        File externalStorage = null;
        File outputFile = null;


        @Override
        protected Void doInBackground(Void... arg0) {
            try {
                URL url = new URL(downloadURL);
                HttpsURLConnection httpsURLConnection= (HttpsURLConnection) url.openConnection();
                httpsURLConnection.setRequestMethod("GET");
                httpsURLConnection.connect();

//                If the connection response is not OK then print log
                if (httpsURLConnection.getResponseCode() != HttpsURLConnection.HTTP_OK) {
                    Log.e(TAG, "Server returned HTTP " + httpsURLConnection.getResponseCode() + " " + httpsURLConnection.getResponseMessage());
                }

                if (new checkExternalStorage().isExternalStoragePresent()) {
                    externalStorage = new File(Environment.getExternalStorageDirectory() + "/" + downloadDirectory);
                    if (!externalStorage.exists()) {
                        externalStorage.mkdir();
                        Log.i(TAG, downloadDirectory + " directory is created");
                    } else {
                        outputFile = new File(externalStorage, downloadFileName);
                        if (!outputFile.exists()) {
                            outputFile.createNewFile();
                            Log.i(TAG, downloadFileName + " file is created");
                        }
                    }
                } else {
                    Toast.makeText(context, "There is no SD Card", Toast.LENGTH_SHORT).show();
                }


                FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
                InputStream inputStream = httpsURLConnection.getInputStream();
                byte[] buffer = new byte[1024];
                int initialLength = 0;
                while ((initialLength = inputStream.read(buffer)) != -1) {
                    fileOutputStream.write(buffer, 0, initialLength);
                }
                fileOutputStream.close();
                inputStream.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }

}
