package com.example.bizwise;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ProductsOffered extends AppCompatActivity
{
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private ProductsAdapter mAdapter;
    public ArrayList<Products> mProducts = new ArrayList<>();
    RecyclerView mRecyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_offered);
        Toolbar toolbar = findViewById(R.id.toolbarpo);
        setSupportActionBar(toolbar);
        mRecyclerView = findViewById(R.id.recycler);

       // firebaseDatabase = FirebaseUtil.firebaseDatabase;
        //databaseReference = FirebaseUtil.databaseReference;
        run();
    }

    public void run(){
        FirebaseUtil.openFbReference("products");
        firebaseDatabase = FirebaseUtil.firebaseDatabase;
        databaseReference = FirebaseUtil.databaseReference;
        mAdapter = new ProductsAdapter(getApplicationContext(), mProducts);
        mRecyclerView.setAdapter(mAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ProductsOffered.this, RecyclerView.VERTICAL,false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_product,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_product:
                Intent intent = new Intent(ProductsOffered.this, BackupData.class);
                startActivity(intent);
                return true;
            case R.id.update:
                Intent intent1 = new Intent(ProductsOffered.this, UpdateProducts.class);
                startActivity(intent1);
                return true;
            case R.id.log_out:
                Intent intent2 = new Intent(ProductsOffered.this, SignIn.class);
                startActivity(intent2);
        }
        return super.onOptionsItemSelected(item);
    }
}
