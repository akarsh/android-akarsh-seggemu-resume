package com.sakarsh.akarshseggemuresume;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class ResumeSchemaListAdapter extends ArrayAdapter<Integer> {
    private final Activity context;
    private final Integer[] resumeSchemaArrays;
    private final Integer[] imagesOfResumeSchemaArrays;

    public ResumeSchemaListAdapter(Activity context, Integer[] resumeSchemaArrays, Integer[] imagesOfResumeSchemaArrays) {
        super(context, R.layout.activity_linear_layout_main, resumeSchemaArrays);

        this.context = context;
        this.resumeSchemaArrays = resumeSchemaArrays;
        this.imagesOfResumeSchemaArrays = imagesOfResumeSchemaArrays;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.activity_linear_layout_main, null, true);
        TextView textTitle = rowView.findViewById(R.id.textView);
        ImageView imageView = rowView.findViewById(R.id.imageView);

        textTitle.setText(resumeSchemaArrays[position]);
        imageView.setImageResource(imagesOfResumeSchemaArrays[position]);

        return rowView;
    }
}
