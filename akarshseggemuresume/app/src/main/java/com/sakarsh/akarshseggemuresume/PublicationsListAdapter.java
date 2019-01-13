package com.sakarsh.akarshseggemuresume;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class PublicationsListAdapter extends ArrayAdapter<Publication> {
    private final Activity activity;
    private final List<Publication> publicationArrayList;

    public PublicationsListAdapter(Activity activity, List<Publication> publicationArrayList) {
        super(activity, R.layout.activity_linear_layout_publications, publicationArrayList);
        this.activity = activity;
        this.publicationArrayList = publicationArrayList;
    }

    public View getView(int position, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = activity.getLayoutInflater();
        View rowView = layoutInflater.inflate(R.layout.activity_linear_layout_publications, null, true);

        TextView textViewName = rowView.findViewById(R.id.textViewName);
        TextView textViewPublisher = rowView.findViewById(R.id.textViewPublisher);
        TextView textViewWebsite = rowView.findViewById(R.id.textViewWebsite);
        TextView textViewReleaseDate = rowView.findViewById(R.id.textViewReleaseDate);
        TextView textViewSummary = rowView.findViewById(R.id.textViewSummary);

        textViewName.setText(publicationArrayList.get(position).getName());
        textViewPublisher.setText(publicationArrayList.get(position).getPublisher());
        textViewWebsite.setText(publicationArrayList.get(position).getWebsite());
        textViewReleaseDate.setText(publicationArrayList.get(position).getReleaseDate());
        textViewSummary.setText(publicationArrayList.get(position).getSummary());

        return rowView;
    }
}
