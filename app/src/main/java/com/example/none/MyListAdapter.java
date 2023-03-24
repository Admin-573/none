package com.example.none;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyListAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] maintitle;
    private final String[] subtitle;
    private final Integer[] imgid;

    public MyListAdapter(Activity context,String[] maintitle,String[] subtitle,Integer[] imgid){
        super(context,R.layout.mylist,maintitle);

        this.context = context;
        this.maintitle = maintitle;
        this.subtitle = subtitle;
        this.imgid = imgid;
    }

    public MyListAdapter(Context context, int resource, Activity context1, String[] maintitle, String[] subtitle, Integer[] imgid) {
        super(context, resource);
        this.context = context1;
        this.maintitle = maintitle;
        this.subtitle = subtitle;
        this.imgid = imgid;
    }

    public View getView(int position,  View View,  ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.mylist,null,true);

        TextView titletext = (TextView) rowView.findViewById(R.id.MainTitle);
        TextView subtext = (TextView) rowView.findViewById(R.id.SubTitle);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);

        titletext.setText(maintitle[position]);
        subtext.setText(subtitle[position]);
        imageView.setImageResource(imgid[position]);

        return rowView;
    }
}
