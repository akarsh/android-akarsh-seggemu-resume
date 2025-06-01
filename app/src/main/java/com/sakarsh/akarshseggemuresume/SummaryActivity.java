package com.sakarsh.akarshseggemuresume;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

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
        //            setting the title of the action bar
        getSupportActionBar().setTitle(R.string.summary);
    }
}
