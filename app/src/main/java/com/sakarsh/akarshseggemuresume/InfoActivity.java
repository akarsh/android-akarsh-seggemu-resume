package com.sakarsh.akarshseggemuresume;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class InfoActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        TextView textViewNationality = findViewById(R.id.textViewNationality);
        TextView textViewWorkPermit = findViewById(R.id.textViewWorkPermit);
        TextView textViewDateOfBirth = findViewById(R.id.textViewDateOfBirth);
        TextView textViewPlaceOfBirth = findViewById(R.id.textViewPlaceOfBirth);

        if (getIntent().getStringExtra("nationality") != null) {
            textViewNationality.setText(getIntent().getStringExtra("nationality"));
        } else {
            textViewNationality.setVisibility(View.GONE);
        }
        if (getIntent().getStringExtra("workPermit") != null) {
            textViewWorkPermit.setText(getIntent().getStringExtra("workPermit"));
        } else {
            textViewWorkPermit.setVisibility(View.GONE);
        }
        if (getIntent().getStringExtra("dateOfBirth") != null) {
            textViewDateOfBirth.setText(getIntent().getStringExtra("dateOfBirth"));
        } else {
            textViewDateOfBirth.setVisibility(View.GONE);
        }
        if (getIntent().getStringExtra("placeOfBirth") != null) {
            textViewPlaceOfBirth.setText(getIntent().getStringExtra("placeOfBirth"));
        } else {
            textViewPlaceOfBirth.setVisibility(View.GONE);
        }

//        activates the back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//            setting the title of the action bar
        getSupportActionBar().setTitle(R.string.info);
//        Log.i("Info", "Locale: "+getResources().getConfiguration().locale);
    }
}
