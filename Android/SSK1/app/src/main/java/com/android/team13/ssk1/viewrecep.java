package com.android.team13.ssk1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class viewrecep extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    Spinner spinner;
    TextView t1;
    TextView t2;
    TextView t3;
    TextView t4;
    TextView t5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewrecep);

        t1=(TextView)findViewById(R.id.textView9);
        t2=(TextView)findViewById(R.id.textView10);
        t3=(TextView)findViewById(R.id.textView11);
        t4=(TextView)findViewById(R.id.textView12);
        t5=(TextView)findViewById(R.id.textView13);

        // Spinner element
        spinner = (Spinner) findViewById(R.id.spinner7);
        // Spinner click listener
        spinner.setOnItemSelectedListener(this);
        List<String> labels = new ArrayList<String>();

        String se="select r.reg_no,r.nam from app,register r where app.reg_no=r.reg_no";

        try{
            Statement stmt = new Connect().getCon().createStatement();
            ResultSet rs = stmt.executeQuery(se);

            while (rs.next()){
                labels.add(rs.getString(1)+" "+rs.getString(2));
            }}catch (Exception e){e.printStackTrace();}
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, labels);

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
        String se="select dat,sl_no,doc_id from app where reg_no="+label.split(" ")[0];
        System.out.println(se);
        try{
            Statement stmt = new Connect().getCon().createStatement();
            ResultSet rs = stmt.executeQuery(se);
            int i=0;String s;
            while (rs.next() && i<5){
                s=rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3);
                switch (i){
                    case 0:t1.setText(s);break;
                    case 1:t2.setText(s);break;
                    case 2:t3.setText(s);break;
                    case 3:t4.setText(s);break;
                    case 4:t5.setText(s);break;

                }
                i++;
            }

        i=0;}catch (Exception e){e.printStackTrace();}

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "You selected: " + label,
                Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }
}
