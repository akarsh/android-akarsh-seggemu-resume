package com.sakarsh.akarshseggemuresume;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class ProfilesActivity extends BaseActivity {

    Integer[] imagesOfProfilesArrays = new Integer[]{
            R.drawable.twitter,
            R.drawable.linkedin,
            R.drawable.github,
            R.drawable.stackoverflow,
            R.drawable.duolingo,
            R.drawable.xing
    };

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profiles);

        Bundle bundle = getIntent().getExtras();
        String jsonString = bundle.getString("profiles");
        Gson gson = new Gson();
        Type listOfProfiles = new TypeToken<List<Profile>>() {}.getType();
        final List<Profile> profileArrayList = gson.fromJson(jsonString, listOfProfiles);
//        Log.i("Profiles", "profiles array: "+profileArrayList);

        ProfilesListAdapter profilesListAdapter = new ProfilesListAdapter(this, profileArrayList, imagesOfProfilesArrays);
        listView = findViewById(R.id.listView);
        listView.setAdapter(profilesListAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                URL is being parsed and set to uri
                Uri uri = Uri.parse(profileArrayList.get(position).getUrl());
//                Intent is declared
                Intent intent = new Intent(Intent.ACTION_VIEW);
//                parsed URL is set to the intent
                intent.setData(uri);
//                Using string resource to show the text.
                String title = (String) getResources().getText(R.string.chooser_title);
//                Create and start chooser to show list of all browser apps installed on the device
                Intent chooser = Intent.createChooser(intent, title);
                startActivity(chooser);
            }
        });
        //            setting the title of the action bar
        getSupportActionBar().setTitle(R.string.profiles);
    }
}
