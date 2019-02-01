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

public class SkillsActivity extends BaseActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skills);

        Bundle bundle = getIntent().getExtras();
        String jsonString = bundle.getString("skills");
        Gson gson = new Gson();
        Type listOfSkills = new TypeToken<List<Skill>>() {}.getType();
        List<Skill> skillsArrayList = gson.fromJson(jsonString, listOfSkills);

        SkillsListAdapter skillsListAdapter = new SkillsListAdapter(this, skillsArrayList);
        listView = findViewById(R.id.listView);
        listView.setAdapter(skillsListAdapter);

        //        activates the back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //            setting the title of the action bar
        getSupportActionBar().setTitle(R.string.skills);
    }
}
