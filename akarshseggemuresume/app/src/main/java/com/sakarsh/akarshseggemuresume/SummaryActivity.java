package com.sakarsh.akarshseggemuresume;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        TextView textViewSummary = findViewById(R.id.textViewSummary);

        if (getIntent().getStringExtra("summary") != null) {
            textViewSummary.setText(getIntent().getStringExtra("summary"));
        } else {
            textViewSummary.setVisibility(View.GONE);
        }
    }
}
