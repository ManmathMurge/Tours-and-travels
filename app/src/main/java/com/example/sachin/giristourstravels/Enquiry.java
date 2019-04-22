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

public class Enquiry extends AppCompatActivity {
    EditText Enquiry_Name,Enquiry_Email,Enquiry_Contact,Enquiry_Text;
    Button Enuiry_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enquiry);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_back);

        Enquiry_Name=findViewById(R.id.enquiry_name);
        Enquiry_Email=findViewById(R.id.enquiry_email);
        Enquiry_Contact=findViewById(R.id.enquiry_contact);
        Enquiry_Text=findViewById(R.id.enquiry_text);

        Enuiry_Button=findViewById(R.id.enqiry_button);
        Enuiry_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Retrofit retrofit = RetrofitApi.getRetrofitApi();
                final CustomerApi customerApi = retrofit.create(CustomerApi.class);
                Call<String> call=customerApi.enquiryAllCustomers(Enquiry_Name.getText().toString(),Enquiry_Email.getText().toString(),Enquiry_Contact.getText().toString(), Enquiry_Text.getText().toString());
                call.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {


                        Enquiry_Name.setText("");
                        Enquiry_Email.setText("");
                        Enquiry_Contact.setText("");
                        Enquiry_Text.setText("");

                        if (response.isSuccessful()) {

                           // Toast.makeText(getApplicationContext(),"Send Enquiry.....",Toast.LENGTH_SHORT).show();
                            Intent i=new Intent(Enquiry.this,Home_Activity.class);
                            startActivity(i);
                            finish();
                            Enuiry_Button.setText("code:" +response.code());
                            return;
                        }
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {

                        Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
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
