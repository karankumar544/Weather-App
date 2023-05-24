package com.example.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weather.Database;
public class LoginActivity extends AppCompatActivity {
private EditText UserEmail,UserPassword;
Button btnloginSubmit;
    TextView btnSingup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnSingup = findViewById(R.id.btnSignup);
        btnloginSubmit = findViewById(R.id.btnloginSubmit);
        UserEmail = findViewById(R.id.UserEmail);
        UserPassword = findViewById(R.id.UserPassword);
        btnSingup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextIn = new Intent(LoginActivity.this,SignUp.class);
                startActivity(nextIn);
            }
        });

        btnloginSubmit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
               boolean result =   CheckCredentials();
             if(result)
             {
                 SharedPreferences pref = getSharedPreferences("Login",MODE_PRIVATE);
                 SharedPreferences.Editor editor = pref.edit();
                 editor.putBoolean("flag",true);
                 editor.apply();
//                if(isAnyAccount())
//                {
                Intent nextIn = new Intent(LoginActivity.this, HomeActivity.class);
                  startActivity(nextIn);
                  finishAffinity();
//                }
//                else{
//                    Toast.makeText(LoginActivity.this,"Not found any account",Toast.LENGTH_SHORT).show();
//                }
             }
            }

        });
    }

//    private boolean isAnyAccount() {
//          String userEmail = UserEmail.getText().toString();
//        String userPassword = UserPassword.getText().toString();
//        Database D = new Database();
//          D.UserCredentials.put("karan@gamil","1234567");
//        if(userPassword.equals(D.UserCredentials.get(userEmail))) return true;
//        return false;
//    }

    private boolean CheckCredentials() {
        boolean flag=true;
        String userEmail = UserEmail.getText().toString();
        String userPassword = UserPassword.getText().toString();
        if(userEmail.isEmpty() || !userEmail.contains("@")) {
            showError(UserEmail, "Invalid Email");
            flag = false;
        }
        if(userPassword.isEmpty() || userPassword.length()<7) {
            showError(UserPassword, "at least 7 character");
            flag = false;
        }
      return flag;
    }

    private void showError(EditText type, String error) {
        type.setError(error);
        type.requestFocus();
    }
}