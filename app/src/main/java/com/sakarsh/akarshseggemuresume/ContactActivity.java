package com.sakarsh.akarshseggemuresume;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;

public class ContactActivity extends BaseActivity {

    ImageView imageView;

    private String imageURL;

    private static final String imageFileName = "profile.jpg";
    private static final String downloadDirectory = "ResumeJSONDownloads";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        TextView textViewName = findViewById(R.id.textViewName);
        TextView textViewLabel = findViewById(R.id.textViewLabel);
        TextView textViewEmail = findViewById(R.id.textViewEmail);
        TextView textViewPhone = findViewById(R.id.textViewPhone);
        TextView textViewWebsite = findViewById(R.id.textViewWebsite);
        TextView textViewLocation = findViewById(R.id.textViewLocation);
        TextView textViewPostalCode = findViewById(R.id.textViewPostalCode);
        TextView textViewRegion = findViewById(R.id.textViewRegion);
        TextView textViewCity = findViewById(R.id.textViewCity);
        TextView textViewCountryCode = findViewById(R.id.textViewCountryCode);

        imageView = findViewById(R.id.imageView);

        textViewName.setText(getIntent().getStringExtra("name"));
        textViewLabel.setText(getIntent().getStringExtra("label"));
        textViewEmail.setText(getIntent().getStringExtra("email"));
        textViewPhone.setText(getIntent().getStringExtra("phone"));
        textViewWebsite.setText(getIntent().getStringExtra("website"));
        textViewLocation.setText(getIntent().getStringExtra("location"));
        textViewPostalCode.setText(getIntent().getStringExtra("postalCode"));
        textViewRegion.setText(getIntent().getStringExtra("region"));
        textViewCity.setText(getIntent().getStringExtra("city"));
        textViewCountryCode.setText(getIntent().getStringExtra("countryCode"));

        imageURL = getIntent().getStringExtra("imageURL");

        openFileFromStorage();
        //            setting the title of the action bar
        getSupportActionBar().setTitle(R.string.contact);
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

    private void openFileFromInternalStorage() {
        try {
            FileInputStream fileInputStream = openFileInput(imageFileName);
            readFile(fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void openFileFromExternalStorage() {
        try {
            File externalStorage = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/" + downloadDirectory);
            File filePath = new File(externalStorage, imageFileName);
            FileInputStream fileInputStream = new FileInputStream(filePath);
            readFile(fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readFile(FileInputStream fileInputStream) {
        Bitmap bitmap = null;
        try {
            bitmap = BitmapFactory.decodeStream(fileInputStream);
            imageView.setImageBitmap(bitmap);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
