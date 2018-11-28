package com.example.lenovo.watchinglist;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.lenovo.watchinglist.databinding.ActivityNeedToWatchBinding;

public class NeedToWatch extends AppCompatActivity {
    ActivityNeedToWatchBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_need_to_watch);
    }
}
