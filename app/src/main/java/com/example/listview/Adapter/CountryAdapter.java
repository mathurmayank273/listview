package com.example.listview.Adapter;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.listview.Models.Row;
import com.example.listview.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CountryAdapter extends BaseAdapter {
    Context mContext;
    private List<Row> mData = new ArrayList<Row>();


    public CountryAdapter(Context mContext, ArrayList<Row> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }


    public void setData1(List<Row> mListData) {
        this.mData = mListData;
        notifyDataSetChanged();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View row = convertView;
        final ViewHolder holder;


        if (row == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            row = inflater.inflate(R.layout.country_details_layout, parent, false);
            holder = new ViewHolder();
            holder.textview_tittle = (TextView) row.findViewById(R.id.textview_tittle);
            holder.textview_discription = (TextView) row.findViewById(R.id.textview_discription);

            holder.imageview_logo = (ImageView) row.findViewById(R.id.imageview_logo);



            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }

        final Row item = mData.get(position);

        if (item.getTitle() != null)
            holder.textview_tittle.setText(item.getTitle());
        else {
            holder.textview_tittle.setText("No data available");
        }

        if (item.getDescription() != null)
            holder.textview_discription.setText(item.getDescription());
        else {
            holder.textview_discription.setText("No data available");
        }

        if(item.getImageHref()==null)
            holder.imageview_logo.setImageResource(R.mipmap.ic_launcher);
        else {

            //Picasso.with(mContext).load(item.getImageHref()).into(holder.imageview_logo);

            Picasso.get().load(item.getImageHref()).into(holder.imageview_logo);
        }

        return row;
    }


    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    class ViewHolder {
        TextView textview_tittle,textview_discription;
        ImageView imageview_logo;

    }
}