package com.example.sachin.giristourstravels;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Fedback extends AppCompatActivity {
    android.support.v7.widget.Toolbar toolbar;
    EditText Feedback_Email,Feedback_text;
    Button Feedback_Button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fedback);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_back);

        Feedback_Email=findViewById(R.id.feedback_email);
        Feedback_text=findViewById(R.id.feedback_text);

        Feedback_Button =findViewById(R.id.feedback_button);
        Feedback_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Retrofit retrofit = RetrofitApi.getRetrofitApi();
                final CustomerApi customerApi = retrofit.create(CustomerApi.class);
                Call<String> call=customerApi.feedbackAllCustomers(Feedback_Email.getText().toString(),Feedback_text.getText().toString());
                call.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        Feedback_Email.setText("");
                        Feedback_text.setText("");

                        if (response.isSuccessful()) {

                           // Toast.makeText(getApplicationContext(),"Thannk You.....",Toast.LENGTH_SHORT).show();
                            Intent i=new Intent(Fedback.this,Home_Activity.class);
                            startActivity(i);
                            finish();
                            Feedback_Button.setText("code:" +response.code());
                            return;
                        }
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {

                    }
                });
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        onBackPressed();
        finish();
        return true;
    }

}
