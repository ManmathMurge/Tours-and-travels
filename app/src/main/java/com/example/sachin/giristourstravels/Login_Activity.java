package com.example.sachin.giristourstravels;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sachin.giristourstravels.comman.Commans;
import com.example.sachin.giristourstravels.comman.SharedPreferencesUtility;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Login_Activity extends AppCompatActivity implements View.OnClickListener {

    EditText userName, Password;
    TextView signup, forgotpassword;
    ImageView imgusername, imgpassword;
    Toolbar toolbar;
    Button signin;
    SharedPreferences sharedPreferences;
    public static final String MyPREFERENCES = "MyPrefs";
    public static final String useremail = "useremail";
    public static final String pass = "pass";
    public static final String isLogin = "LoggedOut";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);

        userName = findViewById(R.id.username);
        Password = findViewById(R.id.password);
        signup = findViewById(R.id.sign_up);
        forgotpassword = findViewById(R.id.forgot_passsword);
        imgusername = findViewById(R.id.img_username);
        imgpassword = findViewById(R.id.img_password);
        signin = findViewById(R.id.sign_in);

        signin.setOnClickListener(this);
        signup.setOnClickListener(this);
        forgotpassword.setOnClickListener(this);

        userName.addTextChangedListener(username);
        Password.addTextChangedListener(username);

    }

    @Override
    public void onClick(View v) {


        if (v.getId() == R.id.sign_in) {

            if (validate()) {

                Log.d("sign_in", "sign_in");

                final Retrofit retrofit = RetrofitApi.getRetrofitApi();
                final CustomerApi customerApi = retrofit.create(CustomerApi.class);
                Call<String> call = customerApi.loginAllCustomers(userName.getText().toString(), Password.getText().toString());
                call.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {

                        userName.setText("");
                        Password.setText("");

                        if (response.isSuccessful()) {
                           SharedPreferencesUtility.savePrefBoolean(Login_Activity.this, Commans.LOGIN_STATUS, true);
                            Intent i = new Intent(Login_Activity.this, Home_Activity.class);
                            SharedPreferences sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
                            String email = userName.getText().toString();
                            String password = Password.getText().toString();
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString(email, email);
                            editor.putString(password, password);
                            editor.commit();

                            startActivity(i);
                            finish();
                            signin.setText("code:" +response.code());


                            return;
                        }
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {

                        Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }

        } else if (v.getId() == R.id.sign_up) {
            Intent i = new Intent(Login_Activity.this, User_Sign_Up.class);
            startActivity(i);

        } else if (v.getId() == R.id.forgot_passsword) {
            Intent i = new Intent(Login_Activity.this, Forgot_Password.class);
            startActivity(i);

        }


    }
    private TextWatcher username  = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            String username = userName.getText().toString().trim();
            String password = Password.getText().toString().trim();

            signin.setEnabled(!username.isEmpty() && !password.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private Boolean validate() {

        if (!userName.getText().toString().isEmpty()) {

            if (!Password.getText().toString().isEmpty()) {
                return true;
            } else {
                Password.setError("password");
                return false;

            }
        } else {
            //  Toast.makeText(getBaseContext(),"Please enter username and password",Toast.LENGTH_SHORT).show();
            userName.setError("user name");
            return false;
        }


    }
}
