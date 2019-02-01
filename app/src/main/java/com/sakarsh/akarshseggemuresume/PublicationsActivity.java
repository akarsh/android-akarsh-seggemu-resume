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

public class PublicationsActivity extends BaseActivity {

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

        //        activates the back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //            setting the title of the action bar
        getSupportActionBar().setTitle(R.string.profiles);
    }
}
