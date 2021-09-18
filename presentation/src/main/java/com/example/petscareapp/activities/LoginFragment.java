package com.example.petscareapp.activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.petscareapp.R;
import com.example.petscareapp.validator.InputValidator;

public class LoginFragment extends Fragment {

    private Button btnOpenSignUpForm;
    private EditText editTextUserEmail;
    private EditText editTextUserPassword;
    private Button buttonLogin;
    private InputValidator validator;

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

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_fragment, container, false);

        validator = new InputValidator();

        btnOpenSignUpForm = view.findViewById(R.id.button_signupForm);
        editTextUserEmail = view.findViewById(R.id.edit_text_login_email);
        editTextUserPassword = view.findViewById(R.id.edit_text_login_password);
        buttonLogin = view.findViewById(R.id.button_login);

        editTextUserEmail.addTextChangedListener(loginTextWatcher);
        editTextUserPassword.addTextChangedListener(loginTextWatcher);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredEmail = editTextUserEmail.getText().toString();
                String enteredPassword = editTextUserPassword.getText().toString();

                performLoginValidation(enteredEmail, enteredPassword);
            }
        });

        btnOpenSignUpForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new SignUpFragment());
            }
        });
    }

    private void performLoginValidation(String enteredEmail, String enteredPassword) {
        boolean isEmailValid = validator.validateEnteredEmail(enteredEmail);
        boolean isPasswordValid = validator.validateEnteredPassword(enteredPassword);

        if (isEmailValid && isPasswordValid) {
            String input = "Email: " + editTextUserEmail.getEditableText().toString();
            input += "\n";
            input += "\n";
            input += "Password: " + editTextUserPassword.getEditableText().toString();

            Toast.makeText(getActivity(), input, Toast.LENGTH_SHORT).show();
        } else {
            String error = "An error occurred, please check email and/or password";
            Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onStart() {
        super.onStart();
    }
}
