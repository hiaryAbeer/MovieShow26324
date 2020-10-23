package com.movieapp.movieapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.movieapp.movieapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity{

    private ActivityMainBinding binding;
    private MainClickHandler clickHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        clickHandler = new MainClickHandler();
        binding.setClickHandler(clickHandler);
        binding.mainViewPager.setAdapter(new StartingPagerAdapter(this));

        TabLayoutMediator mediator = new TabLayoutMediator(binding.mainTabLayout, binding.mainViewPager
                , new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
            }
        });
        mediator.attach();
    }

    public class MainClickHandler{
        public void onPrivacyClick(View view){

        }

        public void onHelpClick(View view){
            Intent intent = new Intent(MainActivity.this, HelpPage.class);
            startActivity(intent);

        }

        public void onSignInClick(View view){
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);

        }

        public void onGetStartedClick(View view){
            Intent intent = new Intent(MainActivity.this, GetStartedStageOne.class);
            startActivity(intent);

        }
    }

}