package com.example.travelloggedin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Mycontacts extends AppCompatActivity {

    SQLiteDatabase myDb;
    EditText email;
    EditText mobile;
    private RecyclerView contactRV;
    private ArrayList<ContactModel> contactModelArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mycontacts);

        email= findViewById(R.id.emaildetail);
        mobile= findViewById(R.id.mobile);
        email.setText("");
        mobile.setText("");
        myDb=openOrCreateDatabase("travellog", MODE_PRIVATE, null);
        contactModelArrayList = new ArrayList<>();

        //table creation
        myDb.execSQL("CREATE TABLE IF NOT EXISTS contacts(email VARCHAR UNIQUE,mobile VARCHAR);");
          //myDb.close();
        Cursor c=myDb.rawQuery("SELECT * FROM contacts ", null);

        while(c!=null && c.moveToNext())
        {
//            email.setText(c.getString(0));
//            mobile.setText(c.getString(1));
            contactModelArrayList.add(new ContactModel(c.getString(0), c.getString(1)));

        }
        c.close();


        contactRV = findViewById(R.id.idRVCourse);

        // here we have created new array list and added data to it.

        // we are initializing our adapter class and passing our arraylist to it.
        ContactAdapter contactAdapter = new ContactAdapter(this, contactModelArrayList);

        // below line is for setting a layout manager for our recycler view.
        // here we are creating vertical list so we will provide orientation as vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        contactRV.setLayoutManager(linearLayoutManager);
        contactRV.setAdapter(contactAdapter);

    }
    public void ins(View v){
        String emailtext= email.getText().toString();
        String mobiletext=mobile.getText().toString();
        //database creation
        //Toast.makeText(MainActivity.this, roll, Toast.LENGTH_SHORT).show();
        myDb=openOrCreateDatabase("travellog", MODE_PRIVATE, null);
        myDb.execSQL("INSERT INTO contacts VALUES('" + emailtext + "','" + mobiletext + "');");
        contactModelArrayList.add(new ContactModel(emailtext, mobiletext));
        email.setText("");
        mobile.setText("");
    }
    public void show(View v){
        myDb=openOrCreateDatabase("travellog", MODE_PRIVATE, null);
        Cursor c=myDb.rawQuery("SELECT * FROM contacts ", null);
        if(c!=null&&c.moveToFirst())
        {
            email.setText(c.getString(0));
            mobile.setText(c.getString(1));

            c.close();
        }
        else
        {
            Toast.makeText(Mycontacts.this, "No values", Toast.LENGTH_SHORT).show();
        }
    }
    public void delete(View v){
        try {
            myDb=openOrCreateDatabase("travellog", MODE_PRIVATE, null);
            myDb.delete("contacts","email=?",new String[]{email.getText().toString()});
            Toast.makeText(Mycontacts.this, "Contact Deleted", Toast.LENGTH_SHORT).show();
            email.setText("");
            mobile.setText("");
        }
        catch (Exception d){
            Toast.makeText(Mycontacts.this, "No values", Toast.LENGTH_SHORT).show();
        }

    }



}