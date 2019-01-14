package com.sakarsh.akarshseggemuresume;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

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
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.onAttach(base));
    }
}
