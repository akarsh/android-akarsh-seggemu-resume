package com.sakarsh.akarshseggemuresume;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class ResumeSchemaActivity extends BaseActivity {

    ArrayList<ResumeSchema> resumeSchemaArrayList = new ArrayList<>();
    ListView listView;
    Gson gson = new Gson();

    private String languageToLoad, resumeFileName;
    private Resume resume;

    // Adding list objects with their corresponding name, image, class and intent names to the object
    ResumeSchema contact = new ResumeSchema(R.string.contact, R.drawable.card_index_1f4c7, ContactActivity.class, "contact");
    ResumeSchema info = new ResumeSchema(R.string.info, R.drawable.information_source_2139, InfoActivity.class, "info");
    ResumeSchema summary = new ResumeSchema(R.string.summary,  R.drawable.speech_balloon_1f4ac, SummaryActivity.class, "summary");
    ResumeSchema profiles = new ResumeSchema(R.string.profiles, R.drawable.bust_in_silhouette_1f464, ProfilesActivity.class, "profiles");
    ResumeSchema skills = new ResumeSchema(R.string.skills, R.drawable.hammer_and_wrench_1f6e0, SkillsActivity.class, "skills");
    ResumeSchema languages = new ResumeSchema(R.string.languages, R.drawable.globe_with_meridians_1f310, LanguagesActivity.class, "languages");
    ResumeSchema education = new ResumeSchema(R.string.education,R.drawable.graduation_cap_1f393, EducationActivity.class, "education");
    ResumeSchema experience = new ResumeSchema(R.string.experience, R.drawable.hourglass_with_flowing_sand_23f3, ExperienceActivity.class,"experience");
    ResumeSchema volunteer = new ResumeSchema(R.string.volunteer, R.drawable.rosette_1f3f5, VolunteerActivity.class, "volunteer");
    ResumeSchema awards = new ResumeSchema(R.string.awards, R.drawable.trophy_1f3c6, AwardsActivity.class, "awards");
    ResumeSchema publications = new ResumeSchema(R.string.publications, R.drawable.books_1f4da, PublicationsActivity.class, "publications");
    ResumeSchema interests = new ResumeSchema(R.string.interests, R.drawable.black_heart_suit_2665, InterestsActivity.class, "interests");
    ResumeSchema references = new ResumeSchema(R.string.references, R.drawable.memo_1f4dd, ReferencesActivity.class, "references");

    // Array of resume schema to store object names
    ResumeSchema[] resumeSchemaData = new ResumeSchema[] {
            contact,
            info,
            summary,
            profiles,
            skills,
            languages,
            education,
            experience,
            volunteer,
            awards,
            publications,
            interests,
            references
    };

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

        // using enhanced for loop to loop the array of resume schema data
        for (ResumeSchema dataValue : resumeSchemaData) {
            // Adding the object to the array list
            resumeSchemaArrayList.add(dataValue);
        }
    }

    private void setContentsForListView() {
        ResumeSchemaListAdapter adapter = new ResumeSchemaListAdapter(this, resumeSchemaArrayList);

        listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (resume != null) {
//                    setting the Locale for the new activity
                    LocaleHelper.setLocale(getApplicationContext(), languageToLoad);
                    Intent intent = new Intent(view.getContext(), resumeSchemaArrayList.get(position).getClassName());
//                0 means Contact
                    if (position == 0) {
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
                    }
//                1 means Info
                    if (position == 1) {
                        intent.putExtra("nationality", resume.getBasics().getInfo().getNationality());
                        intent.putExtra("workPermit", resume.getBasics().getInfo().getWorkPermit());
                        intent.putExtra("dateOfBirth", resume.getBasics().getInfo().getDateOfBirth());
                        intent.putExtra("placeOfBirth", resume.getBasics().getInfo().getPlaceOfBirth());
                    }
//                2 means Summary
                    if (position == 2) {
                        intent.putExtra(resumeSchemaArrayList.get(position).getIntentName(), resume.getBasics().getSummary());
                    }
//                3 means Profiles
                    if (position == 3) {
                        String JSONString = gson.toJson(resume.getBasics().getProfiles());
                        intent.putExtra(resumeSchemaArrayList.get(position).getIntentName(), JSONString);
                    }
//                4 means Skills
                    if (position == 4) {
                        String JSONString = gson.toJson(resume.getSkills());
                        intent.putExtra(resumeSchemaArrayList.get(position).getIntentName(), JSONString);
                    }
//                5 means Languages
                    if (position == 5) {
                        String JSONString = gson.toJson(resume.getLanguages());
                        intent.putExtra(resumeSchemaArrayList.get(position).getIntentName(), JSONString);
                    }
//                6 means Education
                    if (position == 6) {
                        String JSONString = gson.toJson(resume.getEducation());
                        intent.putExtra(resumeSchemaArrayList.get(position).getIntentName(), JSONString);
                    }
//                7 means Experience
                    if (position == 7) {
                        String JSONString = gson.toJson(resume.getWork());
                        intent.putExtra(resumeSchemaArrayList.get(position).getIntentName(), JSONString);
                    }
//                8 means Volunteer
                    if (position == 8) {
                        String JSONString = gson.toJson(resume.getVolunteer());
                        intent.putExtra(resumeSchemaArrayList.get(position).getIntentName(), JSONString);
                    }
//                9 means Awards
                    if (position == 9) {
                        String JSONString = gson.toJson(resume.getAwards());
                        intent.putExtra(resumeSchemaArrayList.get(position).getIntentName(), JSONString);
                    }
//                10 means Publications
                    if (position == 10) {
                        String JSONString = gson.toJson(resume.getPublications());
                        intent.putExtra(resumeSchemaArrayList.get(position).getIntentName(), JSONString);
                    }
//                11 means Interests
                    if (position == 11) {
                        String JSONString = gson.toJson(resume.getInterests());
                        intent.putExtra(resumeSchemaArrayList.get(position).getIntentName(), JSONString);
                    }
//                12 means References
                    if (position == 12) {
                        String JSONString = gson.toJson(resume.getReferences());
                        intent.putExtra(resumeSchemaArrayList.get(position).getIntentName(), JSONString);
                    }
                    startActivity(intent);
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
