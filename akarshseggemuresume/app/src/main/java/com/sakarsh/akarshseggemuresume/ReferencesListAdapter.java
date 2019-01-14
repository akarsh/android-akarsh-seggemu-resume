package com.sakarsh.akarshseggemuresume;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ReferencesListAdapter extends ArrayAdapter<Reference> {
    private final Activity activity;
    private final List<Reference> referencesArrayList;

    public ReferencesListAdapter(Activity activity, List<Reference> referencesArrayList) {
        super(activity, R.layout.activity_linear_layout_skills, referencesArrayList);
        this.activity = activity;
        this.referencesArrayList = referencesArrayList;
    }

    public View getView(int position, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = activity.getLayoutInflater();
        View rowView = layoutInflater.inflate(R.layout.activity_linear_layout_skills, null, true);

        TextView textViewName = rowView.findViewById(R.id.textViewSkillName);
        TextView textViewKeywords = rowView.findViewById(R.id.textViewKeywords);

        if (referencesArrayList.get(position).getName() != null) {
            textViewName.setText(referencesArrayList.get(position).getName());
        } else {
            textViewName.setVisibility(View.GONE);
        }
        if (referencesArrayList.get(position).getReference() != null) {
            textViewKeywords.setText(referencesArrayList.get(position).getReference());
        } else {
            textViewKeywords.setVisibility(View.GONE);
        }

        return rowView;
    }
}
