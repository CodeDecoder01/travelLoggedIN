package com.example.travelloggedin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class signup extends AppCompatActivity {
    Button b,create;
    Intent i;
    private FirebaseAuth mAuth;
    EditText mEmailField,mPasswordField;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mEmailField=findViewById(R.id.email);
        mPasswordField=findViewById(R.id.password);
        create=findViewById(R.id.button);
        mAuth = FirebaseAuth.getInstance();

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAccount(mEmailField.getText().toString(), mPasswordField.getText().toString());


//                Intent j ;
//                j=new Intent(getApplicationContext(),dashboard.class);
//                startActivity(j);

            }
        });
        b=findViewById(R.id.signup);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i ;
                i=new Intent(getApplicationContext(),signup.class);
                startActivity(i);

            }
        });
    }

    private void createAccount(String email, String password) {
        //Log.d(TAG, "createAccount:" + email);
       // if (!validateForm()) {
         //   return;
        //}

        //showProgressBar();

        // [START create_user_with_email]
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                             //Sign in success, update UI with the signed-in user's information
                            //Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent i;
                            i=new Intent(getApplicationContext(),dashboard.class);
                            startActivity(i);
                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                          //  Log.w(TAG, "createUserWithEmail:failure", task.getException());
                           Toast.makeText(signup.this, "Authentication failed !", Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }

                        // [START_EXCLUDE]
                        //hideProgressBar();
                        // [END_EXCLUDE]

//                        i=new Intent(getApplicationContext(),dashboard.class);
//                        startActivity(i);
                    }

                });
        // [END create_user_with_email]
    }

}
