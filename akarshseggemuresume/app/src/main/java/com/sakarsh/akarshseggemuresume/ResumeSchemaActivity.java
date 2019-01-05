package com.sakarsh.akarshseggemuresume;

import android.content.res.Configuration;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.Locale;

public class ResumeSchemaActivity extends AppCompatActivity {

    Integer[] resumeSchemaArrays = new Integer[] {
            R.string.contact,
            R.string.info,
            R.string.summary,
            R.string.profiles,
            R.string.skills,
            R.string.languages,
            R.string.education,
            R.string.experience,
            R.string.volunteer,
            R.string.awards,
            R.string.publications,
            R.string.interests,
            R.string.references
    };
    Integer[] imagesOfResumeSchemaArrays = new Integer[]{
            R.drawable.card_index_1f4c7,
            R.drawable.information_source_2139,
            R.drawable.speech_balloon_1f4ac,
            R.drawable.bust_in_silhouette_1f464,
            R.drawable.hammer_and_wrench_1f6e0,
            R.drawable.globe_with_meridians_1f310,
            R.drawable.graduation_cap_1f393,
            R.drawable.hourglass_with_flowing_sand_23f3,
            R.drawable.rosette_1f3f5,
            R.drawable.trophy_1f3c6,
            R.drawable.books_1f4da,
            R.drawable.black_heart_suit_2665,
            R.drawable.memo_1f4dd
    };

    ListView listView;

    private static final String TAG = "ResumeSchema";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume_schema);

//        Get values from Intent
        String languageToLoad = getIntent().getStringExtra("languageToLoad");
//        Log.i(TAG, "Language: "+languageToLoad);
        Log.i(TAG, "Locale default language " + Locale.getDefault().getDisplayLanguage());
        ResumeSchemaListAdapter adapter = new ResumeSchemaListAdapter(this, resumeSchemaArrays, imagesOfResumeSchemaArrays);

        listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

    }
}
