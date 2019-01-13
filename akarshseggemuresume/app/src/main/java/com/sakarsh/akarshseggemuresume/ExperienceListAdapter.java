package com.sakarsh.akarshseggemuresume;

import android.app.Activity;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.BulletSpan;
import android.text.style.LeadingMarginSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ExperienceListAdapter extends ArrayAdapter<Work> {
    private final Activity activity;
    private final List<Work> experienceArrayList;

    public ExperienceListAdapter(Activity activity, List<Work> experienceArrayList) {
        super(activity, R.layout.activity_linear_layout_education, experienceArrayList);
        this.activity = activity;
        this.experienceArrayList = experienceArrayList;
    }

    public View getView(int position, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = activity.getLayoutInflater();
        View rowView = layoutInflater.inflate(R.layout.activity_linear_layout_education, null, true);

        TextView textViewCompany = rowView.findViewById(R.id.textViewInstitution);
        TextView textViewPosition = rowView.findViewById(R.id.textViewArea);
        TextView textViewWebsite = rowView.findViewById(R.id.textViewStudyType);
        TextView textViewExperienceStartDate = rowView.findViewById(R.id.textViewEducationStartDate);
        TextView textViewExperienceEndDate = rowView.findViewById(R.id.textViewEducationEndDate);
        TextView textViewHighlights = rowView.findViewById(R.id.textViewGPA);

        textViewCompany.setText(experienceArrayList.get(position).getCompany());
        textViewPosition.setText(experienceArrayList.get(position).getPosition());
        textViewWebsite.setText(experienceArrayList.get(position).getWebsite());
        textViewExperienceStartDate.setText(experienceArrayList.get(position).getStartDate());
        textViewExperienceEndDate.setText(experienceArrayList.get(position).getEndDate());

        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (String string : experienceArrayList.get(position).getHighlights()) {
            int contentStart = spannableStringBuilder.length();

            spannableStringBuilder.append(string+"\n");

            int contentEnd = spannableStringBuilder.length();
            spannableStringBuilder.setSpan(
                    new BulletSpan(10),
                    contentStart,
                    contentEnd,
                    Spannable.SPAN_INCLUSIVE_EXCLUSIVE
            );
        }
        textViewHighlights.setText(spannableStringBuilder);

        return rowView;
    }

}
