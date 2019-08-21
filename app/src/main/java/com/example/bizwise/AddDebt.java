package com.example.bizwise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;

import com.google.android.material.textfield.TextInputEditText;

public class AddDebt extends AppCompatActivity {
    TextInputEditText quantity;
    Spinner prod_name;
    Spinner client_name;
    Button view, update, products;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_debt);
        quantity = findViewById(R.id.quantity);
        prod_name = findViewById(R.id.prod_name);
        client_name = findViewById(R.id.client_name);
        view = findViewById(R.id.clientsv);
        update = findViewById(R.id.updatedebt);
        products = findViewById(R.id.prodview);
    }
}
