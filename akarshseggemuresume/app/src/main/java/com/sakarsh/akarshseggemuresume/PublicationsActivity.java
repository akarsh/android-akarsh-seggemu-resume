package com.sakarsh.akarshseggemuresume;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class PublicationsActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publications);

        Bundle bundle = getIntent().getExtras();
        String jsonString = bundle.getString("publications");
        Gson gson = new Gson();
        Type listOfAwards = new TypeToken<List<Publication>>() {}.getType();
        List<Publication> publicationArrayList = gson.fromJson(jsonString, listOfAwards);

        PublicationsListAdapter publicationsListAdapter = new PublicationsListAdapter(this, publicationArrayList);
        listView = findViewById(R.id.listView);
        listView.setAdapter(publicationsListAdapter);
    }
}
