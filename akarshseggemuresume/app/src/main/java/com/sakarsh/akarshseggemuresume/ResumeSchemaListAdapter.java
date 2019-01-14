package com.sakarsh.akarshseggemuresume;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ResumeSchemaListAdapter extends ArrayAdapter<Integer> {
    private final Activity activity;
    private final Integer[] resumeSchemaArrays;
    private final Integer[] imagesOfResumeSchemaArrays;

    public ResumeSchemaListAdapter(Activity activity, Integer[] resumeSchemaArrays, Integer[] imagesOfResumeSchemaArrays) {
        super(activity, R.layout.activity_linear_layout_main, resumeSchemaArrays);

        this.activity = activity;
        this.resumeSchemaArrays = resumeSchemaArrays;
        this.imagesOfResumeSchemaArrays = imagesOfResumeSchemaArrays;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.activity_linear_layout_main, null, true);
        TextView textTitle = rowView.findViewById(R.id.textView);
        ImageView imageView = rowView.findViewById(R.id.imageView);

        if (resumeSchemaArrays[position] != null) {
            textTitle.setText(resumeSchemaArrays[position]);
        } else {
            textTitle.setVisibility(View.GONE);
        }
        if (imagesOfResumeSchemaArrays[position] != null) {
            imageView.setImageResource(imagesOfResumeSchemaArrays[position]);
        } else {
            imageView.setVisibility(View.GONE);
        }
        return rowView;
    }
}
