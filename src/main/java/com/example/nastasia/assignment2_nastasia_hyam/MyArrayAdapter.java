package com.example.nastasia.assignment2_nastasia_hyam;

/**
 *  Created by Nastasia on 2016-02-27.
 */

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


/*Create an array adapter that using a Province as its data type*/
public class MyArrayAdapter extends ArrayAdapter<Province> {

    private List<Province> provinces;
    private int resourceId;
    private Context context;


    public MyArrayAdapter(Context context, int resourceId, List<Province> provinces) {
        super(context, resourceId, provinces);

        this.context = context;
        this.resourceId = resourceId;
        this.provinces = provinces;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //inflater allows Views accessibility (xml)
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        //inflate convertView if it is null
        if(convertView == null){
            convertView = inflater.inflate(resourceId,parent,false);
        }
        ImageView imgArms = (ImageView)convertView.findViewById(R.id.imgArms);
        int armsResourceId = provinces.get(position).getArmId();

        imgArms.setImageResource(armsResourceId);

        TextView txtProvince = (TextView) convertView.findViewById(R.id.txtProvince);
        //set the text of this view, position is array index
        txtProvince.setText(provinces.get(position).getName());

        TextView txtCapital = (TextView) convertView.findViewById(R.id.txtCapital);
        txtCapital.setText(context.getString(R.string.txtCapital_text) + provinces.get(position).getCapital());

        //in order to display listed row: need to return modified view
        return convertView;
    }
}
