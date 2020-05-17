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
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {
    FirebaseAuth auth;
    String username;
    String uID;
    String email;
    String password;
    EditText nameEditText;
    EditText uidEditText;
    EditText mailEditText;
    EditText passwordEditText;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        auth = FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        nameEditText = findViewById(R.id.nameEditText);
        uidEditText = findViewById(R.id.idEditText);
        mailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
    }

    public void registerClick(View view) {
        //Create user from details that are entered
        username = nameEditText.getText().toString();
        uID = uidEditText.getText().toString();
        email = mailEditText.getText().toString();
        password = passwordEditText.getText().toString();
        if (username.isEmpty() || uID.isEmpty() || email.isEmpty() || password.isEmpty()) {
            Toast.makeText(RegisterActivity.this, "Please fill out form", Toast.LENGTH_SHORT).show();
        } else {
            user = new User();
            user.setEmail(email);
            user.setName(username);
            user.setuID(uID);

            //TODO: Check if valid uID
            createUser();
        }
    }

    private void createUser() {
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("register", "createUserWithEmail:success");
                            Toast.makeText(RegisterActivity.this, "Authentication success", Toast.LENGTH_SHORT).show();
                            //FirebaseUser user = auth.getCurrentUser();

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.d("register", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
