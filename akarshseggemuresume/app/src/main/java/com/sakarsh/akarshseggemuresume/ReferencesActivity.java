package com.sakarsh.akarshseggemuresume;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class ReferencesActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_references);

        Bundle bundle = getIntent().getExtras();
        String jsonString = bundle.getString("references");
        Gson gson = new Gson();
        Type listOfReferences = new TypeToken<List<Reference>>() {}.getType();
        List<Reference> referencesArrayList = gson.fromJson(jsonString, listOfReferences);

        ReferencesListAdapter referencesListAdapter = new ReferencesListAdapter(this, referencesArrayList);
        listView = findViewById(R.id.listView);
        listView.setAdapter(referencesListAdapter);
    }
}
