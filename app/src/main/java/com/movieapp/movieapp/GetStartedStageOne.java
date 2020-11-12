package com.movieapp.movieapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.PagerAdapter;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.SignInMethodQueryResult;
import com.movieapp.movieapp.ViewModel.PlansViewModel;
import com.movieapp.movieapp.databinding.ActivityGetStartedStageOneBinding;
import com.movieapp.movieapp.models.PlansModel;
import com.movieapp.movieapp.models.UsersModel;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetStartedStageOne extends AppCompatActivity {//implements RecyclerClickItems {

    private ActivityGetStartedStageOneBinding binding;
    private GetStartedStageOneClickHandler handler;
    private PlansViewModel plansViewModel;
    private List<PlansModel> plansModels = new ArrayList<>();
    private int requestResponse = 0;
    private ProgressDialog progressDialog;
    private PlansModel plansModel;
    private UsersModel usersModel;
    private FirebaseAuth auth;
    private boolean change = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_get_started_stage_one);

        plansModel = new PlansModel();
        binding.setPlansModel(plansModel);
        usersModel = new UsersModel();
        binding.setUserModel(usersModel);

        auth = FirebaseAuth.getInstance();
        handler = new GetStartedStageOneClickHandler();
        binding.setClickHandler(handler);

        binding.stageOnePage1Linear.setVisibility(View.VISIBLE);
        binding.stageOnePage2Linear.setVisibility(View.GONE);
        binding.stageOnePage3Linear.setVisibility(View.GONE);
        binding.stageTwoPage1Linear.setVisibility(View.GONE);
        binding.stageTwoPage2Linear.setVisibility(View.GONE);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please waiting..");
        binding.stageTwoPage1Password.setTransformationMethod(PasswordTransformationMethod.getInstance());

    }

//    @Override
//    public void onPlanChooseClick(PlansModel model) {
//        Log.e("planclick", model.getOfferType());
//        if (model != null) {
//            plansModel.setOfferMessage(model.getOfferMessage());
//            plansModel.setDuration(model.getDuration());
//            if (!TextUtils.isEmpty(plansModel.getPriceAfter())) {
//                binding.stageOnePage3PriceBefore.setBackgroundResource(R.drawable.horizontal_line);
//                binding.stageOnePage3PriceBefore.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
//                plansModel.setPriceBefore(model.getPriceBefore());
//                plansModel.setPriceAfter(model.getPriceAfter());
//            } else
//                plansModel.setPriceAfter("");
//            plansModel.setOfferType(model.getOfferType());
//
//
//        }
//
//    }

    public class GetStartedStageOneClickHandler {
        public void onHelpClick(View view) {
            Intent intent = new Intent(GetStartedStageOne.this, HelpPage.class);
            startActivity(intent);

        }

        public void onSignInClick(View view) {
            Intent intent = new Intent(GetStartedStageOne.this, LoginActivity.class);
            startActivity(intent);

        }

        public void onSeeThePlansClick(View view) {
            progressDialog.show();
            binding.stageOnePage1Linear.setVisibility(View.GONE);
            binding.stageOnePage2Linear.setVisibility(View.VISIBLE);

            plansViewModel = ViewModelProviders.of(GetStartedStageOne.this).get(PlansViewModel.class);
            plansViewModel.initialization();
            plansViewModel.getPlansMutableLiveData().observe(GetStartedStageOne.this, response -> {
                progressDialog.dismiss();
                if (response != null) {
                    requestResponse = response.getResponse();
                    if (requestResponse == 200) {
                        plansModels = response.getModelList();
                        binding.stageOnePage2RecyclerView.setLayoutManager(new LinearLayoutManager(GetStartedStageOne.this));
                        PlansAdapter plansAdapter = new PlansAdapter(plansModels, new RecyclerClickItems() {
                            @Override
                            public void onPlanChooseClick(PlansModel model) {
                                if (model != null) {
                                    binding.stageOnePage2Linear.setVisibility(View.GONE);
                                    plansModel.setOfferMessage(model.getOfferMessage());
                                    plansModel.setPriceBefore(model.getPriceBefore());
                                    plansModel.setOfferType(model.getOfferType());

                                    if (model.getPriceAfter() != null) {
                                        binding.stageOnePage3Linear.setVisibility(View.VISIBLE);
                                        Log.e("planclick", model.getPriceBefore());

                                        plansModel.setDuration(model.getDuration());
                                        plansModel.setPriceAfter(model.getPriceAfter());

                                        binding.stageOnePage3PriceBefore.setBackgroundResource(R.drawable.horizontal_line);
                                        binding.stageOnePage3PriceBefore.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
                                    } else {
                                        plansModel.setPriceAfter(null);
                                        if (change)
                                            binding.stageTwoPage2Linear.setVisibility(View.VISIBLE);
                                        else
                                            binding.stageTwoPage1Linear.setVisibility(View.VISIBLE);
                                    }


                                }
                            }
                        });
                        binding.stageOnePage2RecyclerView.setAdapter(plansAdapter);

                        Log.e("plans2", requestResponse + "   " + plansModels.size());
                    }
                } else
                    Toast.makeText(GetStartedStageOne.this, R.string.error_in_the_service, Toast.LENGTH_SHORT).show();

            });
        }

        public void onStageOnePage3OkClick(View view) {
            binding.stageOnePage3Linear.setVisibility(View.GONE);
            if (change)
                binding.stageTwoPage2Linear.setVisibility(View.VISIBLE);
            else
                binding.stageTwoPage1Linear.setVisibility(View.VISIBLE);
        }

        public void onSignupClick(View view) {
            if (!TextUtils.isEmpty(usersModel.getUsername()) && isEmailValid(usersModel.getUsername()))
                if (!TextUtils.isEmpty(usersModel.getPassword())) {

                    auth.fetchSignInMethodsForEmail(usersModel.getUsername())
                            .addOnCompleteListener(new OnCompleteListener<SignInMethodQueryResult>() {
                                @Override
                                public void onComplete(@NonNull Task<SignInMethodQueryResult> task) {
                                    boolean isNotExist = task.getResult().getSignInMethods().isEmpty();
                                    if (isNotExist) {
                                        auth.createUserWithEmailAndPassword(usersModel.getUsername(), usersModel.getPassword()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                            @Override
                                            public void onComplete(@NonNull Task<AuthResult> task) {
                                                if (task.isSuccessful()) {
                                                    ShareClass.getInstance().showSnackbar(GetStartedStageOne.this, binding.getStartedContainer, getString(R.string.registered_successfully), true);
                                                    binding.stageTwoPage1Linear.setVisibility(View.GONE);
                                                    binding.stageTwoPage2Linear.setVisibility(View.VISIBLE);
                                                } else
                                                    ShareClass.getInstance().showSnackbar(GetStartedStageOne.this, binding.getStartedContainer, getString(R.string.register_failed), false);
                                            }
                                        });
                                    } else {
                                        ShareClass.getInstance().showSnackbar(GetStartedStageOne.this, binding.getStartedContainer, getString(R.string.you_already_registered), false);

                                    }
                                }
                            });


                } else
                    binding.stageTwoPage1Password.setError(getString(R.string.required));
            else
                binding.stageTwoPage1Username.setError(getString(R.string.required));

        }

        public void onEyeClick(View view) {
            if (binding.stageTwoPage1Password.getTransformationMethod() == PasswordTransformationMethod.getInstance()) {
                binding.stageTwoPage1Password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                binding.loginEye.setImageResource(R.drawable.invisiblee);
            } else {
                binding.stageTwoPage1Password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                binding.loginEye.setImageResource(R.drawable.ic_baseline_eye);

            }

        }

        public void onCreditCrdClick(View view) {
            binding.stageTwoPage2Linear.setVisibility(View.GONE);
            binding.stageTwoPage3Linear.setVisibility(View.VISIBLE);


        }

        public void onPayPalClick(View view) {
            binding.stageTwoPage2Linear.setVisibility(View.GONE);
            binding.stageTwoPage3PaypalLinear.setVisibility(View.VISIBLE);

        }

        public void onStartMembershipClick(View view) {
            Intent intent = new Intent(GetStartedStageOne.this, MoviesActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }

        public void onChangePlanClick(View view) {
            change = true;
            binding.stageTwoPage3Linear.setVisibility(View.GONE);
            binding.stageOnePage2Linear.setVisibility(View.VISIBLE);

        }

        public void onBackClick(View view) {
            if (binding.stageTwoPage3PaypalLinear.getVisibility() == View.VISIBLE) {
                binding.stageTwoPage3PaypalLinear.setVisibility(View.GONE);
                binding.stageTwoPage2Linear.setVisibility(View.VISIBLE);

            } else if (binding.stageTwoPage3Linear.getVisibility() == View.VISIBLE) {
                binding.stageTwoPage3Linear.setVisibility(View.GONE);
                binding.stageTwoPage2Linear.setVisibility(View.VISIBLE);

            } else if (binding.stageTwoPage2Linear.getVisibility() == View.VISIBLE) {
                binding.stageTwoPage2Linear.setVisibility(View.GONE);
                binding.stageTwoPage1Linear.setVisibility(View.VISIBLE);

            } else if (binding.stageTwoPage1Linear.getVisibility() == View.VISIBLE) {
                binding.stageTwoPage1Linear.setVisibility(View.GONE);
                if (plansModel.getPriceAfter().equals(null))
                    binding.stageOnePage2Linear.setVisibility(View.VISIBLE);
                else
                    binding.stageOnePage3Linear.setVisibility(View.VISIBLE);

            } else if (binding.stageOnePage3Linear.getVisibility() == View.VISIBLE) {
                binding.stageOnePage3Linear.setVisibility(View.GONE);
                binding.stageOnePage2Linear.setVisibility(View.VISIBLE);

            } else if (binding.stageOnePage2Linear.getVisibility() == View.VISIBLE) {
                binding.stageOnePage2Linear.setVisibility(View.GONE);
                binding.stageOnePage1Linear.setVisibility(View.VISIBLE);

            } else if (binding.stageOnePage1Linear.getVisibility() == View.VISIBLE) {
                onBackPressed();
            }


        }
    }

    public static boolean isEmailValid(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}