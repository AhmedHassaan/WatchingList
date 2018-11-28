package com.example.lenovo.watchinglist;

import android.database.Cursor;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.lenovo.watchinglist.data.DBHelper;
import com.example.lenovo.watchinglist.data.Item;
import com.example.lenovo.watchinglist.data.watchingnowAdapter;
import com.example.lenovo.watchinglist.databinding.ActivityWatchingNowBinding;

import java.util.ArrayList;

public class WatchingNow extends AppCompatActivity {
    ActivityWatchingNowBinding binding;
    watchingnowAdapter adapter;
    DBHelper helper;
    ArrayList<Item> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_watching_now);
        helper = new DBHelper(getApplicationContext());
        Cursor cursor = helper.getWatchingNow();
        items = new ArrayList<>();
        if(cursor != null){
            while (!cursor.isAfterLast()){
                Item item = new Item(cursor.getString(0),cursor.getString(1));
                item.setEp(cursor.getInt(2));
                items.add(item);
                cursor.moveToNext();
            }
            adapter = new watchingnowAdapter(items,getApplicationContext(),R.layout.watchingnowlistview);
            binding.wnList.setAdapter(adapter);
            binding.wnList.setEnabled(true);
            binding.wnList.setVisibility(View.VISIBLE);
        }
        else
            binding.wnList.setEnabled(false);
    }

}
