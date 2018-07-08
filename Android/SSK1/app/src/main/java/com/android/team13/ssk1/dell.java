package com.android.team13.ssk1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class dell extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    Spinner s1;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dell);
        setTitle("Delete View");
        s1=(Spinner)findViewById(R.id.spinner);
        b=(Button)findViewById(R.id.button5);
        s1.setOnItemSelectedListener(this);
        loadSpinnerData();

    }



    private void loadSpinnerData() {
        // database handler
        DatabaseHandler db = new DatabaseHandler("del");

        // Spinner Drop down elements
        List<String> lables = db.getAllLabels();

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, lables);

        // Drop down layout style - list view with radio button
        dataAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        s1.setAdapter(dataAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position,
                               long id) {
        // On selecting a spinner item
        final String label = parent.getItemAtPosition(position).toString();
        final Connection con = new Connect().getCon();
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    con.prepareStatement("delete from app where app_id="+label).execute();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "You selected: " + label,
                Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }
}
