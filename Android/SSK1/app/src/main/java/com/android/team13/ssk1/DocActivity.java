package com.android.team13.ssk1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DocActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    // Spinner element
    Spinner spinner;
    TextView t;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc);
        setTitle("Doctor View");
        t=(TextView)findViewById(R.id.textView23) ;
        // Spinner element
        spinner = (Spinner) findViewById(R.id.spinner);
        // Spinner click listener
        spinner.setOnItemSelectedListener(this);
        Bundle bundle = getIntent().getExtras();
        spinner.setPrompt("Dates");
        id = bundle.getInt("id");
        // Loading spinner data from database
        loadSpinnerData();
    }
    private void loadSpinnerData() {
        // database handler
        DatabaseHandler db = new DatabaseHandler(id);

        // Spinner Drop down elements
        List<String> lables = db.getAllLabels();

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, lables);

        // Drop down layout style - list view with radio button
        dataAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position,
                               long id) {
        // On selecting a spinner item
        String label = parent.getItemAtPosition(position).toString();

        Connection con = new Connect().getCon();
        String q="select sl_no from app where doc_id="+id+" and dat='"+label+"'";
        String s="Booked slots : ";
        ResultSet r;
        System.out.println(q);
        try {
           r= con.prepareStatement(q).executeQuery();
            while (r.next()){
                s=s+r.getString(1);

            }
            t.setText(s);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "You selected: " + label,
                Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }

}
