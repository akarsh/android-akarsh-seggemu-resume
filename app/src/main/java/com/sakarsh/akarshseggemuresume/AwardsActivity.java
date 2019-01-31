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

        //        activates the back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //            setting the title of the action bar
        getSupportActionBar().setTitle(R.string.awards);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.onAttach(base));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
//            handles the click for back button
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
