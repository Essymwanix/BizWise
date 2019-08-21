package com.example.bizwise;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class FirebaseUtil
{
    public static FirebaseDatabase firebaseDatabase;
    public static DatabaseReference databaseReference;
    private static FirebaseUtil firebaseUtil;
    public static ArrayList<Products> mProducts;

    private FirebaseUtil(){}

    public static void openFbReference(String ref){
        if (firebaseUtil == null){
            firebaseUtil = new FirebaseUtil();
            firebaseDatabase = FirebaseDatabase.getInstance();
            mProducts = new ArrayList<Products>();
        }
        databaseReference = firebaseDatabase.getReference().child(ref);
    }
}
