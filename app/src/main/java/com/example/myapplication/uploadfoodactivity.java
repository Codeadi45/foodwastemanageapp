package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class uploadfoodactivity extends AppCompatActivity {
    EditText name,location,food,phoneno;
    TextView Mesg;
    ImageView upload;
    FloatingActionButton back;

    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uploadfoodactivity);
        name = (EditText) findViewById(R.id.naam);
        name.setBackgroundResource(R.drawable.backtext);
        location = (EditText) findViewById(R.id.locate);
        location.setBackgroundResource(R.drawable.backtext);
        Mesg = (TextView) findViewById(R.id.message) ;
        food = (EditText) findViewById(R.id.describe);
        back = (FloatingActionButton) findViewById(R.id.Back);
        food.setBackgroundResource(R.drawable.backtext);
        phoneno = (EditText) findViewById(R.id.mobile);
        phoneno.setBackgroundResource(R.drawable.backtext);
        upload = (ImageView) findViewById(R.id.donate);


        databaseReference = FirebaseDatabase.getInstance().getReference("delivery");
        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Mesg.setText("");

            }
        });
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Mesg.setText("");

            }
        });
        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Mesg.setText("");

            }
        });
        phoneno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Mesg.setText("");

            }
        });
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Validate()){
                    food items = new food(name.getText().toString(), food.getText().toString(), location.getText().toString(),phoneno.getText().toString());
                    databaseReference.child(databaseReference.push().getKey()).setValue(items);
                    Toast.makeText(uploadfoodactivity.this, "Item Added Successfully", Toast.LENGTH_LONG).show();
                }
                name.setText("");
                location.setText("");
                phoneno.setText("");
                food.setText("");
            }

        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(uploadfoodactivity.this,MainActivity.class));

            }
        });
    }
    private Boolean Validate(){
        Boolean result = false;
        String Name = name.getText().toString();
        String Location = location.getText().toString();
        String Food = food.getText().toString();
        String contact = phoneno.getText().toString();

        if(Name.isEmpty() || Location.isEmpty() || Food.isEmpty() || contact.isEmpty()){
            Mesg.setText("Please enter all details carefully!");
        }else{
            result = true;
        }
        return result;
    }
}