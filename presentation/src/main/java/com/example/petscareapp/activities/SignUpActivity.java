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
import com.example.petscareapp.validator.InputErrorHandler;
import com.example.petscareapp.validator.InputValidator;


public class SignUpActivity extends AppCompatActivity {

    private EditText editTextFullName;
    private EditText editTextUsername;
    private EditText editTextEnterEmail;
    private EditText editTextEnterPassword;
    private EditText editTextConfirmPassword;
    private Button buttonSignUp;
    private InputValidator validator;
    private InputErrorHandler toastMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        validator = new InputValidator();
        toastMessage = new InputErrorHandler();

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

    private final TextWatcher signUpTextWatcher = new TextWatcher() {
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


    public void button_signUp(View view) {

        String enteredEmail = editTextEnterEmail.getText().toString();
        String enteredPassword = editTextEnterPassword.getText().toString();
        String enteredConfirmPassword = editTextConfirmPassword.getText().toString();

        boolean isEmailValid = validator.validateEnteredEmail(enteredEmail);
        boolean isPasswordValid = validator.validateEnteredPassword(enteredPassword);
        boolean isConfirmedPasswordValid = validator.validateEnteredAndConfirmedPassword(enteredPassword, enteredConfirmPassword);

        if (isEmailValid && isPasswordValid && isConfirmedPasswordValid) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        } else if (!isEmailValid) {
            String errorEmail = toastMessage.showEmailError(enteredEmail);
            Toast.makeText(this, errorEmail, Toast.LENGTH_SHORT).show();
        } else {
            String errorPassword = toastMessage.showPasswordError(enteredPassword, enteredConfirmPassword);
            Toast.makeText(this, errorPassword, Toast.LENGTH_SHORT).show();
        }
    }

}




