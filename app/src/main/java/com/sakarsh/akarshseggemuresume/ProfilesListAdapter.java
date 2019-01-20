package com.sakarsh.akarshseggemuresume;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ProfilesListAdapter extends ArrayAdapter<Integer> {
    private final Activity activity;
    private final List<Profile> profileArrayList;
    private final  Integer[] imagesOfProfilesArrays;

    public ProfilesListAdapter(Activity activity, List<Profile> profileArrayList, Integer[] imagesOfProfilesArrays) {
        super(activity, R.layout.activity_linear_layout_main, imagesOfProfilesArrays);

        this.activity = activity;
        this.profileArrayList = profileArrayList;
        this.imagesOfProfilesArrays = imagesOfProfilesArrays;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater layoutInflater = activity.getLayoutInflater();
        View rowView = layoutInflater.inflate(R.layout.activity_linear_layout_main, null, true);

        TextView textTitle = rowView.findViewById(R.id.textView);
        ImageView imageView = rowView.findViewById(R.id.imageView);

        if (profileArrayList.get(position).getUsername() != null) {
            textTitle.setText(profileArrayList.get(position).getUsername());
        } else {
            textTitle.setVisibility(View.GONE);
        }

        if (imagesOfProfilesArrays[position] != null) {
            imageView.setImageResource(imagesOfProfilesArrays[position]);
        } else {
            imageView.setVisibility(View.GONE);
        }


        return rowView;
    }

}
