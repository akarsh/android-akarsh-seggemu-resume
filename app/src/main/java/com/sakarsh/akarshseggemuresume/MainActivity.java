package com.sakarsh.akarshseggemuresume;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Integer[] resumeNameArrays = new Integer[]{
            R.string.english_resume,
            R.string.deutsch_lebenslauf
    };

    Integer[] imagesOfLanguagesArrays = new Integer[]{
            R.drawable.flag_for_united_kingdom_1f1ec_1f1e7,
            R.drawable.flag_for_germany_1f1e9_1f1ea
    };

    private final String loadEnglishLanguage = "en";
    private final String loadDeutschLanguage = "de";

    ListView listView;

    private static final String englishJSONURL = "https://raw.githubusercontent.com/akarsh/akarsh.github.io/main/json/en/resume.json";
    private static final String deutschJSONURL = "https://raw.githubusercontent.com/akarsh/akarsh.github.io/main/json/de/resume.json";
    public static final String mainURL = "https://raw.githubusercontent.com/akarsh/akarsh.github.io/main/json/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        downloadResumes();

        MainListAdapter adapter = new MainListAdapter(this, resumeNameArrays, imagesOfLanguagesArrays);
        listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(view.getContext(), ResumeSchemaActivity.class);
                    intent.putExtra("languageToLoad", loadEnglishLanguage);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    LocaleHelper.setLocale( getApplicationContext(), loadEnglishLanguage);
                    startActivity(intent);
                }

                if (position == 1) {
                    Intent intent = new Intent(view.getContext(), ResumeSchemaActivity.class);
                    intent.putExtra("languageToLoad", loadDeutschLanguage);
                    LocaleHelper.setLocale(getApplicationContext(), loadDeutschLanguage);
                    startActivity(intent);
                }
            }
        });
    }

    private boolean checkInternetConnection() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    public void downloadResumes() {
        if (checkInternetConnection()) {
            new DownloadTask(MainActivity.this, englishJSONURL);
            new DownloadTask(MainActivity.this, deutschJSONURL);
        } else {
            Toast.makeText(MainActivity.this, "There is no internet connection", Toast.LENGTH_SHORT).show();
        }
    }
}
