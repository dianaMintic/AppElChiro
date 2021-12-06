package com.example.elchirostore.listViews;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.elchirostore.R;

import java.util.ArrayList;

public class MarcaListViewAdapter extends ArrayAdapter<String> {

    ArrayList<String> List;
    Context context;

    public MarcaListViewAdapter(@NonNull Context context, ArrayList<String> items) {
        super(context, R.layout.marca_list_row, items);
        this.context=context;
        List =items;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null){
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.marca_list_row, null);
            TextView marcaName= convertView.findViewById(R.id.marcaName);
            marcaName.setText(List.get(1));

        }
        return convertView;
    }


}
