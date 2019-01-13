package com.sakarsh.akarshseggemuresume;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

        textViewNationality.setText(getIntent().getStringExtra("nationality"));
        textViewWorkPermit.setText(getIntent().getStringExtra("workPermit"));
        textViewDateOfBirth.setText(getIntent().getStringExtra("dateOfBirth"));
        textViewPlaceOfBirth.setText(getIntent().getStringExtra("placeOfBirth"));
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.onAttach(base));
    }
}
