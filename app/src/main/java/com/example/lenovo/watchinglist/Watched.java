package com.example.lenovo.watchinglist;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

import com.example.lenovo.watchinglist.databinding.ActivityWatchedBinding;

public class Watched extends AppCompatActivity {
    ActivityWatchedBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_watched);

//        Log.e("error",id);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.watchedmenu,menu);

        return super.onCreateOptionsMenu(menu);
    }
}
