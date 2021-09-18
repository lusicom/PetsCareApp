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
import com.example.petscareapp.validator.InputErrorHandler;
import com.example.petscareapp.validator.InputValidator;

public class SignUpFragment extends Fragment {

    View view;

    private EditText editTextFullName;
    private EditText editTextUsername;
    private EditText editTextEnterEmail;
    private EditText editTextEnterPassword;
    private EditText editTextConfirmPassword;
    private Button buttonSignUp;
    private InputValidator validator;
    public InputErrorHandler toastMessage;

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

            buttonSignUp.setEnabled(!fullNameInput.isEmpty()
                    && !usernameInput.isEmpty()
                    && !emailInput.isEmpty()
                    && !passwordInput.isEmpty()
                    && !confirmPasswordInput.isEmpty());
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.sign_up_fragment, container, false);
        validator = new InputValidator();
        toastMessage = new InputErrorHandler();

        editTextFullName = view.findViewById(R.id.edit_text_enter_fullname);
        editTextUsername = view.findViewById(R.id.edit_text_enter_username);
        editTextEnterEmail = view.findViewById(R.id.edit_text_enter_email);
        editTextEnterPassword = view.findViewById(R.id.edit_text_enter_password);
        editTextConfirmPassword = view.findViewById(R.id.edit_text_confirm_password);
        buttonSignUp = view.findViewById(R.id.button_signup);

        editTextFullName.addTextChangedListener(signUpTextWatcher);
        editTextUsername.addTextChangedListener(signUpTextWatcher);
        editTextEnterEmail.addTextChangedListener(signUpTextWatcher);
        editTextEnterPassword.addTextChangedListener(signUpTextWatcher);
        editTextConfirmPassword.addTextChangedListener(signUpTextWatcher);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String enteredEmail = editTextEnterEmail.getText().toString();
                String enteredPassword = editTextEnterPassword.getText().toString();
                String enteredConfirmPassword = editTextConfirmPassword.getText().toString();

                performScreenValidation(enteredEmail, enteredPassword, enteredConfirmPassword);
            }
        });

    }

    private void performScreenValidation(String enteredEmail, String enteredPassword, String enteredConfirmPassword) {
        boolean isEmailValid = validator.validateEnteredEmail(enteredEmail);
        boolean isPasswordValid = validator.validateEnteredPassword(enteredPassword);
        boolean isConfirmedPasswordValid = validator.validateEnteredAndConfirmedPassword
                (enteredPassword, enteredConfirmPassword);

        if (isEmailValid && isPasswordValid && isConfirmedPasswordValid) {
            String validInfo = "Thank you for SignUp your info is valid";
            Toast.makeText(getActivity(), validInfo, Toast.LENGTH_SHORT).show();
            replaceSignUpFragment(new LoginFragment());
        } else if (!isEmailValid) {
            String errorEmail = toastMessage.showEmailError(enteredEmail);
            Toast.makeText(getActivity(), errorEmail, Toast.LENGTH_SHORT).show();
        } else {
            String errorPassword = toastMessage.showPasswordError(enteredPassword, enteredConfirmPassword);
            Toast.makeText(getActivity(), errorPassword, Toast.LENGTH_SHORT).show();
        }
    }

    private void replaceSignUpFragment(Fragment fragment) {
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
