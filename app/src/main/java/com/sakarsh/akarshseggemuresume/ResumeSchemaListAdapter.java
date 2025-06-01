package com.sakarsh.akarshseggemuresume;

import android.app.Activity;
import androidx.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ResumeSchemaListAdapter extends ArrayAdapter<ResumeSchema> {
    private final Activity activity;
    private List<ResumeSchema> resumeSchemaList = new ArrayList<>();


    public ResumeSchemaListAdapter(Activity activity, ArrayList<ResumeSchema> resumeSchemaList) {
        super(activity, R.layout.activity_linear_layout_main, resumeSchemaList);

        this.activity = activity;
        this.resumeSchemaList = resumeSchemaList;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.activity_linear_layout_main, null, true);
        TextView textTitle = rowView.findViewById(R.id.textView);
        ImageView imageView = rowView.findViewById(R.id.imageView);

        ResumeSchema resumeSchema = resumeSchemaList.get(position);

        if (resumeSchema != null) {
            textTitle.setText(resumeSchema.getName());
            imageView.setImageResource(resumeSchema.getImage());
        } else {
            textTitle.setVisibility(View.GONE);
            imageView.setVisibility(View.GONE);
        }

        return rowView;
    }
}
