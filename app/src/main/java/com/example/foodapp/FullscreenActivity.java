package com.example.foodapp;

import android.annotation.SuppressLint;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FullscreenActivity extends AppCompatActivity {
    private EditText mAccount, mPassword;
    private Button Sign_in;
    private TextView sign_up, forgot, fb_signin, gg_signin;
    private FrameLayout frame1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);
        mAccount = findViewById(R.id.user_login);
        mPassword = findViewById(R.id.password_text);
        Sign_in =findViewById(R.id.sign_in);
        sign_up = findViewById(R.id.sign_up);
        forgot = findViewById(R.id.forgot);
        fb_signin = findViewById(R.id.signin_fb);
        gg_signin = findViewById(R.id.sign_gg);
        
    }

    public static final String EXTRA_MESSAGE = "com.example.foodapp.extra.MESSAGE";

    public void displayToast(String message){
        Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG);
        toast.show();
    }

    public void SignIn(View view) {
        String account = mAccount.getText().toString();
        String password = mPassword.getText().toString();
        if(account.length() < 8){
            displayToast(getString(R.string.invalid_username));
        }
        else if(password.length() < 8){
            displayToast(getString(R.string.invalid_password));
        }
        else{
            Intent intent_signin = new Intent(this, MainActivity.class);
            startActivity(intent_signin);
            displayToast(getString(R.string.welcome));
        }
    }
}