package com.movieapp.movieapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.movieapp.movieapp.ViewModel.UsersViewModel;
import com.movieapp.movieapp.databinding.ActivityLoginBinding;
import com.movieapp.movieapp.models.UsersModel;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;
    private LoginClickHandler handler;
    private UsersModel usersModel;

    private UsersViewModel usersViewModel;
    private List<UsersModel> usersModelList;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        auth = FirebaseAuth.getInstance();

        handler = new LoginClickHandler();
        usersModel = new UsersModel();
        usersModelList = new ArrayList<>();

        binding.setClickHandler(handler);
        binding.setUserModel(usersModel);
    }

    public class LoginClickHandler {
        public void onBackClick(View view) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }

        public void onLoginClick(View view) {
//            usersViewModel = ViewModelProviders.of(LoginActivity.this).get(UsersViewModel.class);
//            usersViewModel.initialization();
//            usersViewModel.getUsersLiveData().observe(LoginActivity.this, response -> {
//                usersModelList = response.getUsersModels();
//                new ShareClass().showLog("LoginActivity", "onLoginClick", response.getUsersModels().get(0).getUsername());
//
//                if (usersModelList.get(0).getResponse() == 0)
//                    new ShareClass(LoginActivity.this).showSnackbar(binding.container, "You didn't have an account! Sign Up first", false);
//                else
//                    Toast.makeText(LoginActivity.this, "success", Toast.LENGTH_SHORT).show();
////                    Intent intent = new Intent(LoginActivity.this, );
//
//
//            });
            if ((!TextUtils.isEmpty(usersModel.getUsername()) && !TextUtils.isEmpty(usersModel.getPassword())))
                auth.signInWithEmailAndPassword(usersModel.getUsername(), usersModel.getPassword())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    FirebaseUser user = auth.getCurrentUser();
                                    new ShareClass(LoginActivity.this).showSnackbar(binding.container, getString(R.string.authentication_success), true);

                                } else
                                    new ShareClass(LoginActivity.this).showSnackbar(binding.container, getString(R.string.authentication_failed), false);

                            }
                        });
            else
                Toast.makeText(LoginActivity.this, R.string.all_fields_are_required, Toast.LENGTH_SHORT).show();
        }
    }
}