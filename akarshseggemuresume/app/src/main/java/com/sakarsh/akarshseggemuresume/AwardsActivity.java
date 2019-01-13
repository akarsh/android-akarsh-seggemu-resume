package com.sakarsh.akarshseggemuresume;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class AwardsActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_awards);

        Bundle bundle = getIntent().getExtras();
        String jsonString = bundle.getString("awards");
        Gson gson = new Gson();
        Type listOfAwards = new TypeToken<List<Award>>() {}.getType();
        List<Award> awardsArrayList = gson.fromJson(jsonString, listOfAwards);

        AwardsListAdapter awardsListAdapter = new AwardsListAdapter(this, awardsArrayList);
        listView = findViewById(R.id.listView);
        listView.setAdapter(awardsListAdapter);
    }
}
