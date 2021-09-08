package com.example.petscareapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.data.UserDao;
import com.example.data.UserDatabase;
import com.example.data.UserEntity;
import com.example.petscareapp.R;
import com.example.petscareapp.validator.InputValidator;


public class LoginActivity extends AppCompatActivity {

    private EditText loginUserEmail;
    private EditText loginUserPassword;
    private Button buttonLogin;
    private InputValidator validator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        validator = new InputValidator();

        loginUserEmail = findViewById(R.id.edit_text_login_email);
        loginUserPassword = findViewById(R.id.edit_text_login_password);
        buttonLogin = findViewById(R.id.button_login);

        loginUserEmail.addTextChangedListener(loginTextWatcher);
        loginUserPassword.addTextChangedListener(loginTextWatcher);
    }

    private final TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String emailInput = loginUserEmail.getText().toString().trim();
            String passwordInput = loginUserPassword.getText().toString().trim();
            buttonLogin.setEnabled(!emailInput.isEmpty() && !passwordInput.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {
        }
    };

    public void button_JoinSignupForm(View view) {
        startActivity(new Intent(getApplicationContext(), SignUpActivity.class));
    }

    public void button_login(View view) {
       String enteredEmail = loginUserEmail.getText().toString();
       String enteredPassword = loginUserPassword.getText().toString();

        boolean isEmailValid = validator.validateEnteredEmail(enteredEmail);
        boolean isPasswordValid = validator.validateEnteredPassword(enteredPassword);

        if (isEmailValid && isPasswordValid) {
            UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
           final UserDao userDao = userDatabase.userDao();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    UserEntity userEntity= userDao.login(enteredEmail,enteredPassword);
                    if (userEntity == null){
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(), "Invalid Credentials", Toast.LENGTH_SHORT).show();
                            }
                        });
                    } else{
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    }
                }
            }).start();
        } else {
            String error = "An error occurred, please check email and/or password";
            Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
        }
    }

    public void img_btn_google_login(View view) {
    }
}