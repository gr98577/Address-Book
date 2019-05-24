package com.example.addressbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.Attributes;

import static java.lang.Double.parseDouble;



public class ListActivity extends android.app.ListActivity {


    public static ArrayList<String> listData = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the activity layout xml file.
        setContentView(R.layout.activity_list);

        // Create a list data which will be displayed in inner ListView.

        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseDatabase mMyDB = FirebaseDatabase.getInstance();
        DatabaseReference mDBRef = mMyDB.getReference();




        // Create the ArrayAdapter use the item row layout and the list data.
        ArrayAdapter<String> listDataAdapter = new ArrayAdapter<String>(this, R.layout.list_activity_item, R.id.listRowTextView, listData);


        // Set this adapter to inner ListView object.
        this.setListAdapter(listDataAdapter);
    }

    // When user click list item, this method will be invoked.
    @Override
    protected void onListItemClick(ListView listView, View v, int position, long id) {
        // Get the list data adapter.
        ListAdapter listAdapter = listView.getAdapter();
        // Get user selected item object.
        Object selectItemObj = listAdapter.getItem(position);
        String itemText = (String)selectItemObj;

        // Create an AlertDialog to show.
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setMessage(itemText);
        alertDialog.show();
    }
}