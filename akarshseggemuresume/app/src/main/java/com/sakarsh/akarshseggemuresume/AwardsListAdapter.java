package com.sakarsh.akarshseggemuresume;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class AwardsListAdapter extends ArrayAdapter<Award> {
    private final Activity activity;
    private final List<Award> awardsArrayList;

    public AwardsListAdapter(Activity activity, List<Award> awardsArrayList) {
        super(activity, R.layout.activity_linear_layout_awards, awardsArrayList);
        this.activity = activity;
        this.awardsArrayList = awardsArrayList;
    }

    public View getView(int position, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = activity.getLayoutInflater();
        View rowView = layoutInflater.inflate(R.layout.activity_linear_layout_awards, null, true);

        TextView textViewTitle = rowView.findViewById(R.id.textViewTitle);
        TextView textViewAwarder = rowView.findViewById(R.id.textViewAwarder);
        TextView textViewDate = rowView.findViewById(R.id.textViewDate);
        TextView textViewSummary = rowView.findViewById(R.id.textViewSummary);

        if (awardsArrayList.get(position).getTitle() != null) {
            textViewTitle.setText(awardsArrayList.get(position).getTitle());
        } else {
            textViewTitle.setVisibility(View.GONE);
        }
        if (awardsArrayList.get(position).getAwarder() != null) {
            textViewAwarder.setText(awardsArrayList.get(position).getAwarder());
        } else {
            textViewAwarder.setVisibility(View.GONE);
        }
        if (awardsArrayList.get(position).getDate() != null) {
            textViewDate.setText(awardsArrayList.get(position).getDate());
        } else {
            textViewDate.setVisibility(View.GONE);
        }
        if (awardsArrayList.get(position).getSummary() != null) {
            textViewSummary.setText(awardsArrayList.get(position).getSummary());
        } else {
            textViewSummary.setVisibility(View.GONE);
        }

        return rowView;
    }
}
