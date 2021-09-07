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

import com.example.petscareapp.R;
import com.example.petscareapp.validator.InputValidator;


public class LoginActivity extends AppCompatActivity {

    private EditText editTextUserEmail;
    private EditText editTextUserPassword;
    private Button buttonLogin;
    private InputValidator validator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        validator = new InputValidator();

        editTextUserEmail = findViewById(R.id.edit_text_login_email);
        editTextUserPassword = findViewById(R.id.edit_text_login_password);
        buttonLogin = findViewById(R.id.button_login);

        editTextUserEmail.addTextChangedListener(loginTextWatcher);
        editTextUserPassword.addTextChangedListener(loginTextWatcher);
    }

    private final TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String emailInput = editTextUserEmail.getText().toString().trim();
            String passwordInput = editTextUserPassword.getText().toString().trim();
            buttonLogin.setEnabled(!emailInput.isEmpty() && !passwordInput.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {
        }
    };

    public void button_signupForm(View view) {
        startActivity(new Intent(getApplicationContext(), SignUpActivity.class));
    }

    public void button_login(View view) {
        String enteredEmail = editTextUserEmail.getText().toString();
        String enteredPassword = editTextUserPassword.getText().toString();

        boolean isEmailValid = validator.validateEnteredEmail(enteredEmail);
        boolean isPasswordValid = validator.validateEnteredPassword(enteredPassword);

        if (isEmailValid && isPasswordValid) {
            String input = "Email: " + editTextUserEmail.getEditableText().toString();
            input += "\n";
            input += "\n";
            input += "Password: " + editTextUserPassword.getEditableText().toString();

            Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
        } else {
            String error = "An error occurred, please check email and/or password";
            Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
        }
    }

    public void img_btn_google_login(View view) {
    }
}