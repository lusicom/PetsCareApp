package com.example.petscareapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.petscareapp.R;

import java.util.regex.Pattern;

public class SignUpActivity extends AppCompatActivity {


    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[0-9])" +
                    "(?=.*[a-z])" +
                    "(?=.*[A-Z])" +
                    "(?=\\S+$)" +
                    ".{8,}" +
                    "$");

    private EditText editTextFullName;
    private EditText editTextUsername;
    private EditText editTextEnterEmail;
    private EditText editTextEnterPassword;
    private EditText editTextConfirmPassword;
    private Button buttonSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        editTextFullName = findViewById(R.id.edit_text_enter_fullname);
        editTextUsername = findViewById(R.id.edit_text_enter_username);
        editTextEnterEmail = findViewById(R.id.edit_text_enter_email);
        editTextEnterPassword = findViewById(R.id.edit_text_enter_password);
        editTextConfirmPassword = findViewById(R.id.edit_text_confirm_password);
        buttonSignUp = findViewById(R.id.button_signup);

        editTextFullName.addTextChangedListener(signUpTextWatcher);
        editTextUsername.addTextChangedListener(signUpTextWatcher);
        editTextEnterEmail.addTextChangedListener(signUpTextWatcher);
        editTextEnterPassword.addTextChangedListener(signUpTextWatcher);
        editTextConfirmPassword.addTextChangedListener(signUpTextWatcher);
    }

    private TextWatcher signUpTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String fullNameInput = editTextFullName.getText().toString().trim();
            String usernameInput = editTextUsername.getText().toString().trim();
            String emailInput = editTextEnterEmail.getText().toString().trim();
            String passwordInput = editTextEnterPassword.getText().toString().trim();
            String confirmPasswordInput = editTextConfirmPassword.getText().toString().trim();

            buttonSignUp.setEnabled(!fullNameInput.isEmpty() && !usernameInput.isEmpty() && !emailInput.isEmpty() && !passwordInput.isEmpty() && !confirmPasswordInput.isEmpty());

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    private boolean validateEmail() {
        String emailEntered = editTextEnterEmail.getEditableText().toString().trim();
        if (emailEntered.isEmpty()) {
            editTextEnterEmail.setError("Field can't be empty");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailEntered).matches()) {
            editTextEnterEmail.setError("Please enter a valid email address");
            return false;
        } else {
            editTextEnterEmail.setError(null);
            return true;
        }
    }

    private boolean validatePassword() {
        String passwordEntered = editTextEnterPassword.getEditableText().toString().trim();
        String passwordEnteredToConfirm = editTextConfirmPassword.getEditableText().toString().trim();
        if (passwordEntered.isEmpty()) {
            editTextConfirmPassword.setError("Field can't be empty");
            return false;
        } else if (!PASSWORD_PATTERN.matcher(passwordEntered).matches()) {
            editTextEnterPassword.setError("Password should contain at least one letter and one digit number");
            return false;
        } else if (!passwordEntered.equals(passwordEnteredToConfirm)) {
            editTextConfirmPassword.setError("The password does not match the one entered earlier");
            return false;
        } else {
            editTextEnterPassword.setError(null);
            return true;
        }
    }

    public void button_signUp(View view) {
        if (validateEmail() | validatePassword()) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));

        }
    }
}