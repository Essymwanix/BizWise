package com.example.bizwise;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class UserActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FloatingActionButton fab_plus,fab_client,fab_product,fab_debt;
    TextView add_product,add_debt,add_client;
    Animation FabOpen,FabClose,FabClockwise,FabAntiClockwise;
    boolean isOpen = false;


    Button viewClients,clients,sales,products,transactionss, sync, delete_client, addUser;




    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_user);
        viewClients = findViewById(R.id.viewClients);
        clients = findViewById(R.id.clients);
        sales = findViewById(R.id.sales);
        products = findViewById(R.id.products);
        transactionss = findViewById(R.id.transactionss);
        sync = findViewById(R.id.sync);
        add_client= findViewById(R.id.add_client_text);
        add_debt= findViewById(R.id.add_debt_text);
        add_product= findViewById(R.id.add_product_text);
        fab_plus = findViewById(R.id.add);
        fab_client =findViewById(R.id.addClient);
        fab_debt =  findViewById(R.id.addDebt);
        fab_product= findViewById(R.id.addProduct);
        delete_client = findViewById(R.id.delete_client);
        addUser = findViewById(R.id.addClientButton);
        FabOpen = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_open);
        FabClose = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_close);
        FabClockwise = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_clockwise);
        FabAntiClockwise = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_anticlockwise);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        fab_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOpen)
                {
                    fab_client.startAnimation(FabClose);
                    add_client.startAnimation(FabClose);
                    fab_debt.startAnimation(FabClose);
                    add_debt.startAnimation(FabClose);
                    fab_product.startAnimation(FabClose);
                    add_product.startAnimation(FabClose);
                    fab_plus.startAnimation(FabAntiClockwise);
                    fab_debt.setClickable(false);
                    fab_client.setClickable(false);
                    fab_product.setClickable(false);
                    isOpen= false;
                }

                else {
                    fab_client.startAnimation(FabOpen);
                    add_client.startAnimation(FabOpen);
                    fab_debt.startAnimation(FabOpen);
                    add_debt.startAnimation(FabOpen);
                    fab_product.startAnimation(FabOpen);
                    add_product.startAnimation(FabOpen);
                    fab_plus.startAnimation(FabClockwise);
                    fab_client.setClickable(true);
                    fab_debt.setClickable(true);
                    fab_product.setClickable(true);
                    isOpen= true;
                    fab_client.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(UserActivity.this, ClientsDetails.class);
                            startActivity(intent);
                        }
                    });
                    fab_debt.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(UserActivity.this, AddDebt.class);
                            startActivity(intent);
                        }
                    });
                    fab_product.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(UserActivity.this, BackupData.class);
                            startActivity(intent);
                        }
                    });
                }
            }});


        clients.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this, AllClients.class);
                startActivity(intent);
            }
        });
        sales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this, Sales.class);
                startActivity(intent);
            }
        });
        products.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this, ProductsOffered.class);
                startActivity(intent);
            }
        });
        transactionss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this, Transactions.class);
                startActivity(intent);
            }
        });
        /*sync.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(UserActivity.this, Main.class);
                startActivity(intent);
            }
        });*/
        viewClients.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this, ViewClient.class);
                startActivity(intent);
            }
        });
        delete_client.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this, DeleteClient.class);
                startActivity(intent);
            }

        });
        addUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this, RegisterUsers.class);
                startActivity(intent);
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawerlayout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawerlayout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }




    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent intent = new Intent(UserActivity.this, UserActivity.class);
            startActivity(intent);
            // Handle the camera action
        } else if (id == R.id.nav_clients) {
            Intent intent = new Intent(UserActivity.this, AllClients.class);
            startActivity(intent);

        } else if (id == R.id.nav_mpesa_logs) {
            Intent intent = new Intent(UserActivity.this, MpesaLogs.class);
            startActivity(intent);

        } else if (id == R.id.nav_mpesa) {
            Intent intent = new Intent(UserActivity.this, Mpesa.class);
            startActivity(intent);

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawerlayout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.log_out, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.log_out) {
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(this, SignIn.class);
            startActivity(intent);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }






}

