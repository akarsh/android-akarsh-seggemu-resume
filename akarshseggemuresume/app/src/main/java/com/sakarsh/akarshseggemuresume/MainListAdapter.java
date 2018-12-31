package com.sakarsh.akarshseggemuresume;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MainListAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] resumeNameArrays;
    private final Integer[] imagesOfLanguagesArrays;

    public MainListAdapter(Activity context, String[] resumeNameArrays, Integer[] imagesOfLanguagesArrays) {
        super(context, R.layout.activity_linear_layout_main, resumeNameArrays);

        this.context = context;
        this.resumeNameArrays = resumeNameArrays;
        this.imagesOfLanguagesArrays = imagesOfLanguagesArrays;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.activity_linear_layout_main, null, true);

        TextView textTitle = rowView.findViewById(R.id.textView);
        ImageView imageView = rowView.findViewById(R.id.imageView);

        textTitle.setText(resumeNameArrays[position]);
        imageView.setImageResource(imagesOfLanguagesArrays[position]);
        return rowView;
    }
}
