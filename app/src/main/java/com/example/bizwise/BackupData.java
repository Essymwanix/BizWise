package com.example.bizwise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BackupData extends AppCompatActivity
{
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    TextInputEditText name;
    TextInputEditText quantity;
    TextInputEditText price;
    TextView calc;
    Button calculate;
    Button save;
    Products products;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backup_data);
        Toolbar toolbar = findViewById(R.id.toolbarbd);
        setSupportActionBar(toolbar);

        FirebaseUtil.openFbReference("products");
        firebaseDatabase = FirebaseUtil.firebaseDatabase;
        databaseReference = FirebaseUtil.databaseReference;

        calculate = findViewById(R.id.buttonCalc);
        calc = findViewById(R.id.calc);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeCalculations();
            }
        });

        name = findViewById(R.id.editTextName);
        quantity = findViewById(R.id.editTextQuantity);
        price = findViewById(R.id.editTextProductPrice);
        save = findViewById(R.id.buttonSave);
        Intent intent = getIntent();
        Products products1 = (Products) intent.getSerializableExtra("products");
        if (products1 == null){
            products1 =  new Products();
        }
        this.products = products1;
        name.setText(products1.getProductname());
        quantity.setText(products1.getQuantity());
        price.setText(products1.getPrice());
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveProduct();
                Toast.makeText(BackupData.this,"Product Saved", Toast.LENGTH_SHORT).show();
                clean();
            }
        });

    }

    private void makeCalculations()
    {
        double q = Double.valueOf(quantity.getText().toString());
        double p = Double.valueOf(price.getText().toString());
        double result = p*q;
        calc.setText("Your Expected Total is: " + result);

    }

    private void clean()
    {
        name.setText("");
        quantity.setText("");
        price.setText("");
        calc.setText("");
        name.requestFocus();
    }

    private void saveProduct()
    {
        products.setProductname(name.getText().toString());
        products.setQuantity(quantity.getText().toString());
        products.setPrice(price.getText().toString());
        if (products.getId() == null){
            databaseReference.push().setValue(products);

        } else {
            databaseReference.child(products.getId()).setValue(products);
        }
    }
}
