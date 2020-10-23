package com.movieapp.movieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.movieapp.movieapp.databinding.ActivityHelpPageBinding;

public class HelpPage extends AppCompatActivity {

    private ActivityHelpPageBinding binding;
    private HelpPageClickHandler clickHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_help_page);

        clickHandler = new HelpPageClickHandler();
        binding.setClickHandler(clickHandler);
    }

    public class HelpPageClickHandler {
        public void onBackClick(View view) {
            Intent intent = new Intent(HelpPage.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    }
}