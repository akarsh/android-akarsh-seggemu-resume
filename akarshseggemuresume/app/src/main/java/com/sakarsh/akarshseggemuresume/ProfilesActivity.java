package com.sakarsh.akarshseggemuresume;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ProfilesActivity extends AppCompatActivity {

    Integer[] imagesOfProfilesArrays = new Integer[]{
            R.drawable.twitter,
            R.drawable.linkedin,
            R.drawable.github,
            R.drawable.stackoverflow,
            R.drawable.duolingo,
            R.drawable.xing
    };

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profiles);

        Bundle bundle = getIntent().getExtras();
        String jsonString = bundle.getString("profiles");
        Gson gson = new Gson();
        Type listOfProfiles = new TypeToken<List<Profile>>() {}.getType();
        List<Profile> profileArrayList = gson.fromJson(jsonString, listOfProfiles);
//        Log.i("Profiles", "profiles array: "+profileArrayList);

        ProfilesListAdapter profilesListAdapter = new ProfilesListAdapter(this, profileArrayList, imagesOfProfilesArrays);
        listView = findViewById(R.id.listView);
        listView.setAdapter(profilesListAdapter);
    }
}
