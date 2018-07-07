package com.android.team13.ssk1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class appoint extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner s1;
    Spinner s2;
    Spinner s3;
    Spinner s4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appoint);
        s1 = (Spinner)findViewById(R.id.spinner3);
        s2 = (Spinner)findViewById(R.id.spinner4);
        s3 = (Spinner)findViewById(R.id.spinner5);
        s4 = (Spinner)findViewById(R.id.spinner6);
        s1.setOnItemSelectedListener(this);
        s2.setOnItemSelectedListener(this);
        s3.setOnItemSelectedListener(this);
        s4.setOnItemSelectedListener(this);

        load();
    }

    private void load(){
        //DatabaseHandler db = new DatabaseHandler(0);

        // Spinner Drop down elements
       // List<String> lables[] = db.getAllLabels1();
        //int i=0;
        // Creating adapter for spinner
       /* for(List<String> a : lables){
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, a);
            dataAdapter
                    .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            switch (i){
                case 0:s1.setAdapter(dataAdapter);break;
                case 1:s2.setAdapter(dataAdapter);break;
                case 2:s3.setAdapter(dataAdapter);break;
                case 3:s4.setAdapter(dataAdapter);break;
            }
        }*/

        List<String> labels=new ArrayList<>();
        String se="select reg_no from register";
        try{ Statement stmt = new Connect().getCon().createStatement();
            ResultSet rs = stmt.executeQuery(se);

            while (rs.next()){
                labels.add(rs.getString(1));
            }}catch (Exception e){e.printStackTrace();}
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, labels);
        dataAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        s1.setAdapter(dataAdapter);
    }
    static int i=0;

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position,
                               long id) {
        // On selecting a spinner item
        String label = parent.getItemAtPosition(position).toString();

        switch (i){
            case 0:{List<String> labels=new ArrayList<>();
                String se="select ava.dat from ava,register r,app where r.reg_no=app.reg_no and ";
                try{ Statement stmt = new Connect().getCon().createStatement();
                    ResultSet rs = stmt.executeQuery(se);

                    while (rs.next()){
                        labels.add(rs.getString(1));
                    }}catch (Exception e){e.printStackTrace();}
                ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_item, labels);
                dataAdapter
                        .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                s2.setAdapter(dataAdapter);}break;
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
