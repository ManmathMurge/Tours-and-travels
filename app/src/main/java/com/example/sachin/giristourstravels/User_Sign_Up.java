package com.example.sachin.giristourstravels;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.Calendar;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class User_Sign_Up extends AppCompatActivity implements View.OnClickListener{


    EditText UserName,UserEmail,UserContact,UserPassword,UserCPAssword;
    Button UserSubmit;

    android.support.v7.widget.Toolbar toolbar;
    private static final String TAG="User_Sign_Up";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__sign__up);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("TravelGiri");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_back);


        UserName=findViewById(R.id.user_Name);
        UserEmail=findViewById(R.id.user_Email);
        UserContact=findViewById(R.id.user_Contact);
        UserPassword=findViewById(R.id.user_Password);
        UserCPAssword=findViewById(R.id.confirm_Password);
        UserSubmit=findViewById(R.id.user_Submit);

        UserSubmit.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        if (validate()) {


            Retrofit retrofit = RetrofitApi.getRetrofitApi();
            final CustomerApi customerApi = retrofit.create(CustomerApi.class);
            Call<String> call = customerApi.getAllCustomers(UserName.getText().toString(), UserEmail.getText().toString(), UserContact.getText().toString(), UserPassword.getText().toString());
            call.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {


                    if (response.isSuccessful()) {

                        Toast.makeText(getApplicationContext(), "Registration Successful.....", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(User_Sign_Up.this, Login_Activity.class);
                        startActivity(i);
                        finish();
                        UserSubmit.setText("code:" +response.code());
                        return;
                    }


                }


                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    // Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });

        }
    }

    private Boolean validate() {

        if (!UserName.getText().toString().isEmpty()){

            if (!UserEmail.getText().toString().isEmpty()){

                if (!UserContact.getText().toString().isEmpty()){

                    if (!UserPassword.getText().toString().isEmpty()){

                        if (UserPassword.getText().toString().equals(UserCPAssword.getText().toString())){
                            return true;
                        }else {
                            UserCPAssword.setError("Password missmatch");
                            return false;
                        }
                    }else {
                        UserPassword.setError("password");
                        return false;
                    }
                }else {
                    UserContact.setError("contact");
                    return false;
                }

            }else {
                UserEmail.setError("email");
                return false;
            }
        }else {
            UserName.setError("name");
            return false;
        }

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        onBackPressed();
        finish();
        return true;
    }
}