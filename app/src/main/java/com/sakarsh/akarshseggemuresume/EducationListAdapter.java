package com.sakarsh.akarshseggemuresume;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class EducationListAdapter extends ArrayAdapter<Education> {
    private final Activity activity;
    private final List<Education> educationArrayList;

    public EducationListAdapter(Activity activity, List<Education> educationArrayList) {
        super(activity, R.layout.activity_linear_layout_education, educationArrayList);
        this.activity = activity;
        this.educationArrayList = educationArrayList;
    }

    public View getView(int position, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = activity.getLayoutInflater();
        View rowView = layoutInflater.inflate(R.layout.activity_linear_layout_education, null, true);

        TextView textViewInstitution = rowView.findViewById(R.id.textViewInstitution);
        TextView textViewArea = rowView.findViewById(R.id.textViewArea);
        TextView textViewStudyType = rowView.findViewById(R.id.textViewStudyType);
        TextView textViewEducationStartDate = rowView.findViewById(R.id.textViewEducationStartDate);
        TextView textViewEducationEndDate = rowView.findViewById(R.id.textViewEducationEndDate);
        TextView textViewGPA = rowView.findViewById(R.id.textViewGPA);

        if (educationArrayList.get(position).getInstitution() != null) {
            textViewInstitution.setText(educationArrayList.get(position).getInstitution());
        } else {
            textViewInstitution.setVisibility(View.GONE);
        }
        if (educationArrayList.get(position).getArea() != null) {
            textViewArea.setText(educationArrayList.get(position).getArea());
        } else {
            textViewArea.setVisibility(View.GONE);
        }
        if (educationArrayList.get(position).getStudyType() != null) {
            textViewStudyType.setText(educationArrayList.get(position).getStudyType());
        } else {
            textViewStudyType.setVisibility(View.GONE);
        }
        if (educationArrayList.get(position).getStartDate() != null) {
            textViewEducationStartDate.setText(educationArrayList.get(position).getStartDate());
        } else {
            textViewEducationStartDate.setVisibility(View.GONE);
        }
        if (educationArrayList.get(position).getEndDate() != null) {
            textViewEducationEndDate.setText(educationArrayList.get(position).getEndDate());
        } else {
            textViewEducationEndDate.setVisibility(View.GONE);
        }
        if (educationArrayList.get(position).getGpa() != null) {
            textViewGPA.setText(educationArrayList.get(position).getGpa());
        } else {
            textViewGPA.setVisibility(View.GONE);
        }







        return rowView;
    }
}
