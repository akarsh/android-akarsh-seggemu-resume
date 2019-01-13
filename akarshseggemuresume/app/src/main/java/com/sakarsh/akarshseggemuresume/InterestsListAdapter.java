package com.sakarsh.akarshseggemuresume;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class InterestsListAdapter extends ArrayAdapter<Interest> {
    private final Activity activity;
    private final List<Interest> interestArrayList;

    public InterestsListAdapter(Activity activity, List<Interest> interestArrayList) {
        super(activity, R.layout.activity_linear_layout_skills, interestArrayList);
        this.activity = activity;
        this.interestArrayList = interestArrayList;
    }

    public View getView(int position, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = activity.getLayoutInflater();
        View rowView = layoutInflater.inflate(R.layout.activity_linear_layout_skills, null, true);

        TextView textViewName = rowView.findViewById(R.id.textViewSkillName);
        TextView textViewKeywords = rowView.findViewById(R.id.textViewKeywords);

        if (interestArrayList.get(position).getName() != null) {
            textViewName.setText(interestArrayList.get(position).getName());
        }
        if (interestArrayList.get(position).getKeywords() != null) {
            textViewKeywords.setText(TextUtils.join(", ", interestArrayList.get(position).getKeywords()));
        }

        return rowView;
    }
}
