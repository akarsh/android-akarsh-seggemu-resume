package com.sakarsh.akarshseggemuresume;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class SkillsListAdapter extends ArrayAdapter<Skill> {
    private final Activity activity;
    private final List<Skill> skillsArrayList;

    public SkillsListAdapter(Activity activity, List<Skill> skillsArrayList) {
        super(activity, R.layout.activity_linear_layout_skills, skillsArrayList);
        this.activity = activity;
        this.skillsArrayList = skillsArrayList;
    }

    public View getView(int position, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = activity.getLayoutInflater();
        View rowView = layoutInflater.inflate(R.layout.activity_linear_layout_skills, null, true);

        TextView textViewSkillName = rowView.findViewById(R.id.textViewSkillName);
        TextView textViewKeywords = rowView.findViewById(R.id.textViewKeywords);

        if (skillsArrayList.get(position).getName() != null) {
            textViewSkillName.setText(skillsArrayList.get(position).getName());
        } else {
            textViewSkillName.setVisibility(View.GONE);
        }
        if (skillsArrayList.get(position).getKeywords() != null) {
            textViewKeywords.setText(TextUtils.join(", ", skillsArrayList.get(position).getKeywords()));
        } else {
            textViewKeywords.setVisibility(View.GONE);
        }
        return rowView;
    }
}
