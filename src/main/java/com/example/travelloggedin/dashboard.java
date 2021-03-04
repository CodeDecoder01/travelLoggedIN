package com.example.travelloggedin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class dashboard extends AppCompatActivity {
    private FirebaseAuth mAuth;
    Button b,emergency,logout,mycontacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        TextView use = findViewById(R.id.textView5);
        String email = user.getEmail();

        use.setText("Welcome "+email);
        b=findViewById(R.id.button4);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i=new Intent(getApplicationContext(),track.class);
                startActivity(i);
            }
        });

        emergency = findViewById(R.id.button2);
        emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Alert sent to immediate contacts",Toast.LENGTH_LONG).show();
            }
        });


        logout = findViewById(R.id.button5);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });

        mycontacts = findViewById(R.id.button3);
        mycontacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i=new Intent(getApplicationContext(),Mycontacts.class);
                startActivity(i);
            }
        });

    }
}
