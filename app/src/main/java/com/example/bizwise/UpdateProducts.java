package com.example.bizwise;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UpdateProducts extends AppCompatActivity
{

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    Spinner spinner;
    TextInputEditText addquantities;
    AppCompatButton addproduct;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_products);
        Toolbar toolbar= findViewById(R.id.toolbarup);
        setSupportActionBar(toolbar);
        FirebaseUtil.openFbReference("products");
        firebaseDatabase =FirebaseUtil.firebaseDatabase;
        databaseReference = FirebaseUtil.databaseReference;







    }
}
