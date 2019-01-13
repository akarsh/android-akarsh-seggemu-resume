package com.sakarsh.akarshseggemuresume;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class LanguagesActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_languages);

        Bundle bundle = getIntent().getExtras();
        String jsonString = bundle.getString("languages");
        Gson gson = new Gson();
        Type listOfLanguages = new TypeToken<List<Language>>() {}.getType();
        List<Language> languagesArrayList = gson.fromJson(jsonString, listOfLanguages);

        LanguagesListAdapter languagesListAdapter = new LanguagesListAdapter(this, languagesArrayList);
        listView = findViewById(R.id.listView);
        listView.setAdapter(languagesListAdapter);
    }
}
