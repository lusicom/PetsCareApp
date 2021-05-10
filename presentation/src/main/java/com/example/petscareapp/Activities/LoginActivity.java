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
import android.widget.Toast;

import com.example.petscareapp.R;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    private static final Pattern PASSWORD_PATTERN =
    Pattern.compile("^" +
            "(?=.*[0-9])" +
            "(?=.*[a-z])" +
            "(?=.*[A-Z])" +
            "(?=\\S+$)" +
            ".{8,}" +
            "$");

    private EditText editTextUserEmail;
    private EditText editTextUserPassword;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUserEmail = findViewById(R.id.edit_text_login_email);
        editTextUserPassword = findViewById(R.id.edit_text_login_password);
        buttonLogin = findViewById(R.id.button_login);

      editTextUserEmail.addTextChangedListener(loginTextWatcher);
      editTextUserPassword.addTextChangedListener(loginTextWatcher);
    }

    private boolean validateEmail(){
        String emailEntered = editTextUserEmail.getEditableText().toString().trim();
        if (emailEntered.isEmpty()){
            editTextUserEmail.setError("Field can't be empty");
            return false;
        } else if(!Patterns.EMAIL_ADDRESS.matcher(emailEntered).matches()) {
            editTextUserEmail.setError("Please enter a valid email address");
            return false;
        }
        else {
            editTextUserEmail.setError(null);
            return true;
        }
    }

    private boolean validatePassword(){
        String passwordEntered = editTextUserPassword.getEditableText().toString().trim();
        if (passwordEntered.isEmpty()){
            editTextUserPassword.setError("Field can't be empty");
            return false;
        } else if (!PASSWORD_PATTERN.matcher(passwordEntered).matches()){
            editTextUserPassword.setError("Password should contain at least one letter and one digit number");
            return false;
        }else {
            editTextUserPassword.setError(null);
            return true;
        }
    }

  private TextWatcher loginTextWatcher = new TextWatcher() {
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
        if (!validateEmail() | !validatePassword()) {
            return;
        }
        String input = "Email: " + editTextUserEmail.getEditableText().toString();
        input += "\n";
        input += "\n";
        input += "Password: " + editTextUserPassword.getEditableText().toString();

        Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
    }

    public void img_btn_google_login(View view) {
    }
}