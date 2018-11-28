package com.example.lenovo.watchinglist.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.lenovo.watchinglist.R;

import java.util.ArrayList;

public class watchingnowAdapter extends BaseAdapter {

    ArrayList<Item> items;
    Context context;
    int resource;
    LayoutInflater inflater;
    DBHelper helper;

    public watchingnowAdapter(ArrayList<Item> items, Context context, int resource){
        this.context = context;
        this.items = items;
        this.resource = resource;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        helper = new DBHelper(context);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;

        if (convertView == null){
            convertView = inflater.inflate(resource,null);
            holder = new ViewHolder();
            holder.nameTxt = convertView.findViewById(R.id.wnName);
            holder.catTxt = convertView.findViewById(R.id.wnType);
            holder.epTxt = convertView.findViewById(R.id.wnEp);
            holder.minus = convertView.findViewById(R.id.wnMinus);
            holder.plus = convertView.findViewById(R.id.wnPlus);
            convertView.setTag(holder);
        }
        else
            holder = (ViewHolder)convertView.getTag();
        final Item i = items.get(position);
        holder.epTxt.setText(String.valueOf(i.getEp()));
        holder.nameTxt.setText(i.getName());
        holder.catTxt.setText(i.getType());

        holder.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i.getEp() > 1){
                    i.setEp(i.getEp()-1);
                    helper.updateEp(i.getName(),i.getEp());
                    holder.epTxt.setText(String.valueOf(i.getEp()));
                }
            }
        });

        holder.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.setEp(i.getEp()+1);
                helper.updateEp(i.getName(),i.getEp());
                holder.epTxt.setText(String.valueOf(i.getEp()));
            }
        });


        return convertView;
    }

    static class ViewHolder {
        public TextView nameTxt,catTxt,epTxt;
        public Button minus,plus;
    }
}
