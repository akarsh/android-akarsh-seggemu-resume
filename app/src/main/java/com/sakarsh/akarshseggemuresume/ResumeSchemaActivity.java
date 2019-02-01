package com.sakarsh.akarshseggemuresume;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class ResumeSchemaActivity extends BaseActivity {

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
    Gson gson = new Gson();
    private String languageToLoad, resumeFileName;
    private Resume resume;

    private static final String downloadDirectory = "ResumeJSONDownloads";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume_schema);

//        Get values from Intent
        languageToLoad = getIntent().getStringExtra("languageToLoad");
//        Log.i(TAG, "Language: "+languageToLoad);
//        Log.i(TAG, "Locale default language " + Locale.getDefault().getLanguage());

//        set the resume file to chosen language
        setResumeFileToChosenLanguage();

        setContentsForListView();

//        activates the back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setContentsForListView() {
        ResumeSchemaListAdapter adapter = new ResumeSchemaListAdapter(this, resumeSchemaArrays, imagesOfResumeSchemaArrays);

        listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (resume != null) {
//                    setting the Locale for the new activity
                    LocaleHelper.setLocale(getApplicationContext(), languageToLoad);
//                0 means Contact
                    if (position == 0) {
                        Intent intent = new Intent(view.getContext(), ContactActivity.class);
                        intent.putExtra("name", resume.getBasics().getName());
                        intent.putExtra("label", resume.getBasics().getLabel());
                        intent.putExtra("email", resume.getBasics().getEmail());
                        intent.putExtra("phone", resume.getBasics().getPhone());
                        intent.putExtra("website", resume.getBasics().getWebsite());
                        intent.putExtra("location", resume.getBasics().getLocation().getAddress());
                        intent.putExtra("postalCode", resume.getBasics().getLocation().getPostalCode());
                        intent.putExtra("region", resume.getBasics().getLocation().getRegion());
                        intent.putExtra("city", resume.getBasics().getLocation().getCity());
                        intent.putExtra("countryCode", resume.getBasics().getLocation().getCountryCode());
                        intent.putExtra("imageURL", resume.getBasics().getPicture());
                        startActivity(intent);
                    }
//                1 means Info
                    if (position == 1) {
                        Intent intent = new Intent(view.getContext(), InfoActivity.class);
                        intent.putExtra("nationality", resume.getBasics().getInfo().getNationality());
                        intent.putExtra("workPermit", resume.getBasics().getInfo().getWorkPermit());
                        intent.putExtra("dateOfBirth", resume.getBasics().getInfo().getDateOfBirth());
                        intent.putExtra("placeOfBirth", resume.getBasics().getInfo().getPlaceOfBirth());

                        startActivity(intent);
                    }
//                2 means Summary
                    if (position == 2) {
                        Intent intent = new Intent(view.getContext(), SummaryActivity.class);
                        intent.putExtra("summary", resume.getBasics().getSummary());
                        startActivity(intent);
                    }
//                3 means Profiles
                    if (position == 3) {
                        Intent intent = new Intent(view.getContext(), ProfilesActivity.class);
                        String JSONString = gson.toJson(resume.getBasics().getProfiles());
                        intent.putExtra("profiles", JSONString);
                        startActivity(intent);
                    }
//                4 means Skills
                    if (position == 4) {
                        Intent intent = new Intent(view.getContext(), SkillsActivity.class);
                        String JSONString = gson.toJson(resume.getSkills());
                        intent.putExtra("skills", JSONString);
                        startActivity(intent);
                    }
//                5 means Languages
                    if (position == 5) {
                        Intent intent = new Intent(view.getContext(), LanguagesActivity.class);
                        String JSONString = gson.toJson(resume.getLanguages());
                        intent.putExtra("languages", JSONString);
                        startActivity(intent);
                    }
//                6 means Education
                    if (position == 6) {
                        Intent intent = new Intent(view.getContext(), EducationActivity.class);
                        String JSONString = gson.toJson(resume.getEducation());
                        intent.putExtra("education", JSONString);
                        startActivity(intent);
                    }
//                7 means Experience
                    if (position == 7) {
                        Intent intent = new Intent(view.getContext(), ExperienceActivity.class);
                        String JSONString = gson.toJson(resume.getWork());
                        intent.putExtra("experience", JSONString);
                        startActivity(intent);
                    }
//                8 means Volunteer
                    if (position == 8) {
                        Intent intent = new Intent(view.getContext(), VolunteerActivity.class);
                        String JSONString = gson.toJson(resume.getVolunteer());
                        intent.putExtra("volunteer", JSONString);
                        startActivity(intent);
                    }
//                9 means Awards
                    if (position == 9) {
                        Intent intent = new Intent(view.getContext(), AwardsActivity.class);
                        String JSONString = gson.toJson(resume.getAwards());
                        intent.putExtra("awards", JSONString);
                        startActivity(intent);
                    }
//                10 means Publications
                    if (position == 10) {
                        Intent intent = new Intent(view.getContext(), PublicationsActivity.class);
                        String JSONString = gson.toJson(resume.getPublications());
                        intent.putExtra("publications", JSONString);
                        startActivity(intent);
                    }
//                11 means Interests
                    if (position == 11) {
                        Intent intent = new Intent(view.getContext(), InterestsActivity.class);
                        String JSONString = gson.toJson(resume.getInterests());
                        intent.putExtra("interests", JSONString);
                        startActivity(intent);
                    }
//                12 means References
                    if (position == 12) {
                        Intent intent = new Intent(view.getContext(), ReferencesActivity.class);
                        String JSONString = gson.toJson(resume.getReferences());
                        intent.putExtra("references", JSONString);
                        startActivity(intent);
                    }
                }
            }
        });
    }

    private void setResumeFileToChosenLanguage() {
//        setting the title of the action bar to the resume selected
        resumeFileName = (languageToLoad.equals("en")) ? "EnglishResume.json" : "DeutschResume.json" ;
        getSupportActionBar().setTitle(R.string.resume_title);
        openFileFromStorage();
    }

    private void openFileFromStorage() {
        if (new CheckEmulator().isEmulator()) {
            openFileFromInternalStorage();
        } else {
            if (new CheckExternalStorage().isExternalStoragePresent() && (new CheckExternalStorage().isExternalStorageRemovable())) {
                openFileFromExternalStorage();
            } else {
                openFileFromInternalStorage();
            }
        }
    }

    private void openFileFromExternalStorage() {
        try {
            File externalStorage = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/" + downloadDirectory);
            File filePath = new File(externalStorage, resumeFileName);
            FileInputStream fileInputStream = new FileInputStream(filePath);
            readFile(fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void openFileFromInternalStorage() {
        try {
            FileInputStream fileInputStream = openFileInput(resumeFileName);
            readFile(fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readFile(FileInputStream fileInputStream) {
        try {
            Reader reader = new InputStreamReader(fileInputStream);
            resume = gson.fromJson(reader, Resume.class);

            downloadImageFromURL();

            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private boolean checkInternetConnection() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    public void downloadImageFromURL() {
        if (checkInternetConnection()) {
            new DownloadTask(ResumeSchemaActivity.this, resume.getBasics().getPicture());
        } else {
            Toast.makeText(ResumeSchemaActivity.this, "There is no internet connection", Toast.LENGTH_SHORT).show();
        }
    }


}
