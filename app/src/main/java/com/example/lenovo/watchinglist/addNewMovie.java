package com.example.lenovo.watchinglist;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.lenovo.watchinglist.databinding.ActivityAddNewMovieBinding;

public class addNewMovie extends AppCompatActivity {
    ActivityAddNewMovieBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_add_new_movie);

    }
}
