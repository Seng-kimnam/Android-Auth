package com.kimnam.hotelappclone.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.kimnam.hotelappclone.R;
import com.kimnam.hotelappclone.data.local.UserLocalData;
import com.kimnam.hotelappclone.data.remote.models.response.LoginResponse;
import com.kimnam.hotelappclone.data.remote.repository.AuthRepository;
import com.kimnam.hotelappclone.data.remote.repository.LoginCallback;
import com.kimnam.hotelappclone.utils.Message;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsername , etPassword;
    private Button btnLogin;
    private LinearLayout llSignUp;
    private ProgressBar progressBar;
    private AuthRepository authRepository;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        initViews();
        setupClickListeners();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        authRepository = new AuthRepository();
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        progressBar = findViewById(R.id.progressBar);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }
    private void login(){
        String username = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        if(username.isEmpty() && password.isEmpty()){
            Message.showMessage("Username and Password are empty" , this);
            return;
        }
        authRepository.login(username, password, new LoginCallback() {
            @Override
            public void onLoading() {
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onError(String message) {
                Message.showMessage(message , LoginActivity.this);
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onSuccess(LoginResponse loginResponse) {
                progressBar.setVisibility(View.GONE);
                UserLocalData.saveUserData(loginResponse , LoginActivity.this);
                Intent intent = new Intent(LoginActivity.this , MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    private void initViews(){
        llSignUp = findViewById(R.id.llSignUp);
        progressBar = findViewById(R.id.progress_bar);
    }
    private void navigateToRegister() {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);

        // Optional: Pass some data to register activity
        intent.putExtra("from_login", true);

        startActivity(intent);

        // Optional: Add custom transition animation
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);

        // Optional: If you don't want users to go back to login after clicking register
        // finish();
    }
    private void handleSignUpClick() {
        try {
            // Optional: Show loading and disable button to prevent double clicks
            if (progressBar != null) {
                progressBar.setVisibility(View.VISIBLE);
            }
            llSignUp.setEnabled(false);

            // Add small delay for better UX (optional)
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    navigateToRegister();

                    // Re-enable button and hide loading
                    if (progressBar != null) {
                        progressBar.setVisibility(View.GONE);
                    }
                    llSignUp.setEnabled(true);
                }
            }, 300); // 300ms delay

        } catch (Exception e) {
            Toast.makeText(LoginActivity.this, "Unable to open registration", Toast.LENGTH_SHORT).show();
            if (progressBar != null) {
                progressBar.setVisibility(View.GONE);
            }
            llSignUp.setEnabled(true);
        }
    }
    private void setupClickListeners() {
        llSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleSignUpClick();
            }
        });
    }
}
