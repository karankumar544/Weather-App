package com.example.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {
    EditText fullname,mobilenumber,signuseremail,signupPassword,confirmPassword;
Button SignUpBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        SignUpBtn = findViewById(R.id.SignUpBtn);
        fullname = findViewById(R.id.fullname);
        mobilenumber = findViewById(R.id.mobilenumber);
        signuseremail = findViewById(R.id.signuseremail);
        signupPassword = findViewById(R.id.signupPassword);
        confirmPassword = findViewById(R.id.confirmPassword);
        SignUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean result = Checkcredentials();
                if(result)
                {
                    if(IsAccount())
                    {
                        Intent nextIn = new Intent(SignUp.this,HomeActivity.class);
                        startActivity(nextIn);
                    }
                }
            }
        });
    }

    private boolean IsAccount() {
        boolean flag = true;
        String fullName = fullname.getText().toString();
        String MobileNumber = mobilenumber.getText().toString();
        String signUserEmail = signuseremail.getText().toString();
        String SignupPassword = signupPassword.getText().toString();
        Database D = new Database();
        if(D.UserCredentials.containsKey(signUserEmail))
        {
            Toast.makeText(SignUp.this,"Email has already used",Toast.LENGTH_SHORT);
            flag = false;
        }
        else {
            D.UserCredentials.put(signUserEmail,SignupPassword);
            D.UserSignUpCredentials.put(fullName,MobileNumber);
        }
        return flag;
    }

    private boolean Checkcredentials() {
           boolean flag = true;
          String fullName = fullname.getText().toString();
            String signUserEmail = signuseremail.getText().toString();
            String SignupPassword = signupPassword.getText().toString();
            String ConfirmPassword = confirmPassword.getText().toString();
            String MobileNumber = mobilenumber.getText().toString();
            if(fullName.isEmpty())
            {
                ShowError(fullname,"please enter name");
                flag = false;
            }
            if(MobileNumber.isEmpty() || MobileNumber.length()<10)
            {
                ShowError(mobilenumber,"Invalid mobile");
                flag = false;
            }
            if(signUserEmail.isEmpty() || !signUserEmail.contains("@"))
            {
                ShowError(signuseremail,"Invalid Email");
                flag = false;
            }
            if(SignupPassword.isEmpty() || SignupPassword.length()<7)
            {
                ShowError(signupPassword,"at least 7 character");
                flag = false;
            }
            else if(ConfirmPassword.isEmpty() || !ConfirmPassword.equals(SignupPassword)) {
                ShowError(confirmPassword, "Password not match");
                flag = false;
            }
                return flag;
    }

    private void ShowError(EditText type, String error) {
        type.setError(error);
        type.requestFocus();
    }
}