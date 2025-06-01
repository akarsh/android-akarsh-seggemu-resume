package com.sakarsh.akarshseggemuresume;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class InterestsActivity extends BaseActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interests);

        Bundle bundle = getIntent().getExtras();
        String jsonString = bundle.getString("interests");
        Gson gson = new Gson();
        Type listOfInterest = new TypeToken<List<Interest>>() {}.getType();
        List<Interest> interestArrayList = gson.fromJson(jsonString, listOfInterest);

        InterestsListAdapter interestsListAdapter = new InterestsListAdapter(this, interestArrayList);
        listView = findViewById(R.id.listView);
        listView.setAdapter(interestsListAdapter);
        //            setting the title of the action bar
        getSupportActionBar().setTitle(R.string.interests);
    }
}
