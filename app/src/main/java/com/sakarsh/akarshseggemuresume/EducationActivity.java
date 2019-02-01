package com.sakarsh.akarshseggemuresume;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class EducationActivity extends BaseActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);

        Bundle bundle = getIntent().getExtras();
        String jsonString = bundle.getString("education");
        Gson gson = new Gson();
        Type listOfEducation = new TypeToken<List<Education>>() {}.getType();
        List<Education> educationArrayList = gson.fromJson(jsonString, listOfEducation);

        EducationListAdapter educationListAdapter = new EducationListAdapter(this, educationArrayList);
        listView = findViewById(R.id.listView);
        listView.setAdapter(educationListAdapter);
        //            setting the title of the action bar
        getSupportActionBar().setTitle(R.string.education);
    }
}
