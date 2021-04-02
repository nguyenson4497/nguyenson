package com.example.task1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class SpinnerAdapter extends ArrayAdapter<Spinner> {
    public SpinnerAdapter(@NonNull Context context, int resource, @NonNull List<Spinner> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_selected, parent, false);
        TextView tvSelected = convertView.findViewById(R.id.tv_selected);

        Spinner spinner = this.getItem(position);
        //Xet du lieu
        if (spinner != null) {
            tvSelected.setText(spinner.getLevel());
        }
        return convertView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_spinner, parent, false);
        TextView tvSpinner = convertView.findViewById(R.id.tv_spinner);

        Spinner spinner = this.getItem(position);
        if (spinner != null) {
            tvSpinner.setText(spinner.getLevel());
        }
        return convertView;
    }
}
