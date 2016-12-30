package com.example.user.mycouponcodes;

import android.app.Activity;
import android.graphics.Color;
import android.media.Image;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;

import java.util.List;

/**
 * Created by User on 12/26/2016.
 */

public class ListViewAdapter extends ArrayAdapter<String> {
    private MainActivity activity;
    private List<String> friendList;

    public ListViewAdapter(MainActivity context, int resource, List<String> objects){
        super(context, resource, objects);
        this.activity = context;
        this.friendList = objects;
    }

    @Override
    public int getCount(){
        return friendList.size();
    }

    @Override
    public String getItem(int position){
        return friendList.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder;
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if(convertView == null){
            //inflate UI from XML File
            convertView = inflater.inflate(R.layout.item_listview, parent, false);
            //get all UI view
            holder = new ViewHolder(convertView);
            //set tag for holder
            convertView.setTag(holder);

            }else{
            //if holder created, get tag from view
            holder = (ViewHolder) convertView.getTag();
            }
        holder.friendName.setText(getItem(position));
        //get first letter of each string item
        String firstLetter = String .valueOf(getItem(position).charAt(0));

        TextDrawable drawable = TextDrawable.builder().buildRound(firstLetter, Color.RED);
        holder.imageView.setImageDrawable(drawable);
        return convertView;
        }

    private class ViewHolder {
        private ImageView imageView;
        private TextView friendName;
        public ViewHolder(View v){
            imageView = (ImageView) v.findViewById(R.id.image_view);
            friendName = (TextView) v.findViewById(R.id.text);
        }
    }

}

