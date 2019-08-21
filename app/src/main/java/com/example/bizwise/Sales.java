package com.example.bizwise;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.service.autofill.SaveInfo;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.widget.Toolbar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class Sales extends AppCompatActivity
{
    Button viewSales;
    Button add_debt;
    Button clear_debt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales);
        Toolbar toolbar = findViewById(R.id.toolbarsales);
        setSupportActionBar(toolbar);

        viewSales = findViewById(R.id.viewSales);
        viewSales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sales.this, PaidSale.class);
                startActivity(intent);
            }
        });
        add_debt = findViewById(R.id.debt);
        add_debt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(Sales.this, AddDebt.class);
                startActivity(intent2);
            }
        });
        clear_debt = findViewById(R.id.clearDebt);
        clear_debt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(Sales.this, ClearDebt.class);
                startActivity(intent3);
            }
        });
    }



}
