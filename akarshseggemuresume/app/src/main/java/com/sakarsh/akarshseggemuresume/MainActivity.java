package com.sakarsh.akarshseggemuresume;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String[] resumeNameArrays = new String[]{
            "English resume",
            "Deutsch Lebenslauf"
    };

    Integer[] imagesOfLanguagesArrays = new Integer[]{
            R.drawable.flag_for_united_kingdom_1f1ec_1f1e7,
            R.drawable.flag_for_germany_1f1e9_1f1ea
    };

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainListAdapter adapter = new MainListAdapter(this, resumeNameArrays, imagesOfLanguagesArrays);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }
}
