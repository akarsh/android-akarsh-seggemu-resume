package com.sakarsh.akarshseggemuresume;

import android.app.ListActivity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] resumeNameArrays = new String[]{
            "English resume",
            "Deutsch Lebenslauf"
    };

    Integer[] imagesOfLanguagesArrays = new Integer[]{
            R.drawable.flag_for_united_kingdom_1f1ec_1f1e7,
            R.drawable.flag_for_germany_1f1e9_1f1ea
    };

    ListView listView;

    private static final String englishJSONURL = "https://raw.githubusercontent.com/akarsh/akarsh.github.io/master/json/en/resume.json";
    private static final String deutschJSONURL = "https://raw.githubusercontent.com/akarsh/akarsh.github.io/master/json/de/resume.json";
    public static final String mainURL = "https://raw.githubusercontent.com/akarsh/akarsh.github.io/master/json/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        downloadResumes();

        MainListAdapter adapter = new MainListAdapter(this, resumeNameArrays, imagesOfLanguagesArrays);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }

    private boolean checkInternetConnection() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        } else {
            return false;
        }
    }

    public void downloadResumes() {
        if (checkInternetConnection()) {
            new DownloadTask(MainActivity.this, englishJSONURL);
            new DownloadTask(MainActivity.this, deutschJSONURL);
        } else {
            Toast.makeText(MainActivity.this, "There is no internet connection", Toast.LENGTH_SHORT).show();
        }
    }

//    TODO: read the JSON file

}
