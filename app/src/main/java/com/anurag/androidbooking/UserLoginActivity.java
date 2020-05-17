package com.anurag.androidbooking;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class UserLoginActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    EditText passwordEditText;
    EditText mailEditText;
    String email;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
    }

    public void userLoginPressed(View view) {
        passwordEditText = findViewById(R.id.passwordTextField);
        mailEditText = findViewById(R.id.emailTextField);
        email = mailEditText.getText().toString();
        password = passwordEditText.getText().toString();

        doLogin();
    }

    public void doLogin() {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d("UserLogin", "signInWithEmail:success");
                            Toast.makeText(UserLoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                            //start new Intent

                        } else {
                            Log.w("UserLogin", "signInWithEmail:failure", task.getException());
                            Toast.makeText(UserLoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
