package com.sakarsh.akarshseggemuresume;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class SummaryActivity extends BaseActivity {

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

        //        activates the back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //            setting the title of the action bar
        getSupportActionBar().setTitle(R.string.summary);
    }
}
