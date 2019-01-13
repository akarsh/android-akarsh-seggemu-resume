package com.sakarsh.akarshseggemuresume;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class VolunteerListAdapter extends ArrayAdapter<Volunteer> {
    private final Activity activity;
    private final List<Volunteer> volunteerArrayList;

    public VolunteerListAdapter(Activity activity, List<Volunteer> volunteerArrayList) {
        super(activity, R.layout.activity_linear_layout_education, volunteerArrayList);
        this.activity = activity;
        this.volunteerArrayList = volunteerArrayList;
    }

    public View getView(int position, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = activity.getLayoutInflater();
        View rowView = layoutInflater.inflate(R.layout.activity_linear_layout_education, null, true);

        TextView textViewOrganization = rowView.findViewById(R.id.textViewInstitution);
        TextView textViewPosition = rowView.findViewById(R.id.textViewArea);
        TextView textViewWebsite = rowView.findViewById(R.id.textViewStudyType);
        TextView textViewVolunteerStartDate = rowView.findViewById(R.id.textViewEducationStartDate);
        TextView textViewVolunteerEndDate = rowView.findViewById(R.id.textViewEducationEndDate);
        TextView textViewSummary = rowView.findViewById(R.id.textViewGPA);

        textViewOrganization.setText(volunteerArrayList.get(position).getOrganization());
        textViewPosition.setText(volunteerArrayList.get(position).getPosition());
        textViewWebsite.setText(volunteerArrayList.get(position).getWebsite());
        textViewVolunteerStartDate.setText(volunteerArrayList.get(position).getStartDate());
        textViewVolunteerEndDate.setText(volunteerArrayList.get(position).getEndDate());
        textViewSummary.setText(volunteerArrayList.get(position).getSummary());

        return rowView;
    }
}
