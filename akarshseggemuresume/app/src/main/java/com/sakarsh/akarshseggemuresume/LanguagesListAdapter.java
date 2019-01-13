package com.sakarsh.akarshseggemuresume;

import android.app.Activity;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class LanguagesListAdapter extends ArrayAdapter<Language> {
    private final Activity activity;
    private final List<Language> languagesArrayList;

    public LanguagesListAdapter(Activity activity, List<Language> languagesArrayList) {
        super(activity, R.layout.activity_linear_layout_languages, languagesArrayList);

        this.activity = activity;
        this.languagesArrayList = languagesArrayList;
    }

    public View getView(int position, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = activity.getLayoutInflater();
        View rowView = layoutInflater.inflate(R.layout.activity_linear_layout_languages, null, true);

        TextView textViewLanguage = rowView.findViewById(R.id.textViewLanguage);
        TextView textViewFluency = rowView.findViewById(R.id.textViewFluency);

        if (languagesArrayList.get(position).getLanguage() != null) {
            textViewLanguage.setText(languagesArrayList.get(position).getLanguage());
        }
        if (languagesArrayList.get(position).getFluency() != null) {
            textViewFluency.setText(languagesArrayList.get(position).getFluency());
        }

        return  rowView;
    }
}
