package com.sakarsh.akarshseggemuresume;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class ExperienceActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experience);

        Bundle bundle = getIntent().getExtras();
        String jsonString = bundle.getString("experience");
        Gson gson = new Gson();
        Type listOfExperience = new TypeToken<List<Work>>() {}.getType();
        List<Work> experienceArrayList = gson.fromJson(jsonString, listOfExperience);

        ExperienceListAdapter experienceListAdapter = new ExperienceListAdapter(this, experienceArrayList);
        listView = findViewById(R.id.listView);
        listView.setAdapter(experienceListAdapter);
    }
}
