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
import com.example.petscareapp.validator.InputErrorHandler;
import com.example.petscareapp.validator.InputValidator;


public class SignUpActivity extends AppCompatActivity {

    private EditText fullName;
    private EditText userNickName;
    private EditText userEmail;
    private EditText userPassword;
    private EditText userConfirmPassword;
    private Button buttonSignUp;
    public InputValidator validator;
    public InputErrorHandler toastMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        validator = new InputValidator();
        toastMessage = new InputErrorHandler();

        fullName = findViewById(R.id.edit_text_enter_fullname);
        userNickName = findViewById(R.id.edit_text_enter_username);
        userEmail = findViewById(R.id.edit_text_enter_email);
        userPassword = findViewById(R.id.edit_text_enter_password);
        userConfirmPassword = findViewById(R.id.edit_text_confirm_password);
        buttonSignUp = findViewById(R.id.button_signUp);

        fullName.addTextChangedListener(signUpTextWatcher);
        userNickName.addTextChangedListener(signUpTextWatcher);
        userEmail.addTextChangedListener(signUpTextWatcher);
        userPassword.addTextChangedListener(signUpTextWatcher);
        userConfirmPassword.addTextChangedListener(signUpTextWatcher);

    }

    private final TextWatcher signUpTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String fullNameInput = fullName.getText().toString().trim();
            String usernameInput = userNickName.getText().toString().trim();
            String emailInput = userEmail.getText().toString().trim();
            String passwordInput = userPassword.getText().toString().trim();
            String confirmPasswordInput = userConfirmPassword.getText().toString().trim();

            buttonSignUp.setEnabled(!fullNameInput.isEmpty() && !usernameInput.isEmpty() && !emailInput.isEmpty() && !passwordInput.isEmpty() && !confirmPasswordInput.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    public void button_signUp(View view) {

        String enteredEmail = userEmail.getText().toString();
        String enteredPassword = userPassword.getText().toString();
        String enteredConfirmPassword = userConfirmPassword.getText().toString();

        boolean isEmailValid = validator.validateEnteredEmail(enteredEmail);
        boolean isPasswordValid = validator.validateEnteredPassword(enteredPassword);
        boolean isConfirmedPasswordValid = validator.validateEnteredAndConfirmedPassword(enteredPassword, enteredConfirmPassword);

        if (isEmailValid && isPasswordValid && isConfirmedPasswordValid) {

            final UserEntity userEntity = new UserEntity();
            userEntity.setUserFullName(fullName.getText().toString());
            userEntity.setUserNickName(userNickName.getText().toString());
            userEntity.setUserEmail(userEmail.getText().toString());
            userEntity.setPassword(userPassword.getText().toString());
            if (validateInput(userEntity)) {
                UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
                final UserDao userDao = userDatabase.userDao();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        userDao.registerUser(userEntity);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(), "User registration passed successfully", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
                startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
            } else {
                Toast.makeText(getApplicationContext(), "oops something went wrong", Toast.LENGTH_SHORT).show();
            }

        } else if (!isEmailValid) {
            String errorEmail = toastMessage.showEmailError(enteredEmail);
            Toast.makeText(getApplicationContext(), errorEmail, Toast.LENGTH_SHORT).show();
        } else {
            String errorPassword = toastMessage.showPasswordError(enteredPassword, enteredConfirmPassword);
            Toast.makeText(getApplicationContext(), errorPassword, Toast.LENGTH_SHORT).show();

        }
    }

    private Boolean validateInput(UserEntity userEntity) {
        return !userEntity.getUserFullName().isEmpty() &&
                !userEntity.getUserNickName().isEmpty() &&
                !userEntity.getUserEmail().isEmpty() &&
                !userEntity.getPassword().isEmpty();
    }
}



