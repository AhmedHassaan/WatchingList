package com.example.lenovo.watchinglist;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.lenovo.watchinglist.databinding.ActivityNeedToWatchBinding;

public class NeedToWatch extends AppCompatActivity {
    ActivityNeedToWatchBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_need_to_watch);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.watchedmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(getApplicationContext(),addNewMovie.class);
        intent.putExtra("type","NeedToWatch");
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
}
