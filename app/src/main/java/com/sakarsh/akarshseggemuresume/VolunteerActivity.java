package com.sakarsh.akarshseggemuresume;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class VolunteerActivity extends BaseActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer);

        Bundle bundle = getIntent().getExtras();
        String jsonString = bundle.getString("volunteer");
        Gson gson = new Gson();
        Type listOfVolunteer = new TypeToken<List<Volunteer>>() {}.getType();
        List<Volunteer> volunteerArrayList = gson.fromJson(jsonString, listOfVolunteer);

        VolunteerListAdapter volunteerListAdapter = new VolunteerListAdapter(this, volunteerArrayList);
        listView = findViewById(R.id.listView);
        listView.setAdapter(volunteerListAdapter);
        //            setting the title of the action bar
        getSupportActionBar().setTitle(R.string.volunteer);
    }
}
