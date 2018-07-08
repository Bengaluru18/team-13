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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class appoint extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner s1;
    Spinner s2;
    Spinner s3;
    Spinner s4,s5;
    String a4,a1,a2,a3,a5;
    Button b,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appoint);
        s1 = (Spinner)findViewById(R.id.spinner3);
        s2 = (Spinner)findViewById(R.id.spinner4);
        s3 = (Spinner)findViewById(R.id.spinner5);
        s4 = (Spinner)findViewById(R.id.spinner6);
        s5=(Spinner)findViewById(R.id.spinner8) ;
        b=(Button)findViewById(R.id.button) ;
        b2=(Button)findViewById(R.id.button9);
        //s1.setOnItemSelectedListener(this);
        //s2.setOnItemSelectedListener(this);
        //s3.setOnItemSelectedListener(this);
        //s4.setOnItemSelectedListener(this);

        s5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                a5=adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                a1 = parent.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                a2=adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        s3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                a3=adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        s4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                a4=adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Connection con = new Connect().getCon();
                String q="update app set approve='A',stat='A' where app_id="+a5;
                System.out.println(q);
                try {
                    con.prepareStatement(q).execute();
                    Toast.makeText(appoint.this, "Approved Successfully", Toast.LENGTH_LONG).show();
                    //startActivity(new Intent(appoint.this,Recep.class));
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Connection con = new Connect().getCon();
                String q="delete from app where app_id="+a5;
                System.out.println(q);
                try {
                    con.prepareStatement(q).execute();
                    Toast.makeText(appoint.this, "Rejected Successfully", Toast.LENGTH_LONG).show();
                    //startActivity(new Intent(appoint.this,Recep.class));
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        load();
    }

    private void load(){
        //DatabaseHandler db = new DatabaseHandler(0);

        // Spinner Drop down elements
        List<String> lables[] = new ArrayList[5];
        Connection con = new Connect().getCon();
        String q="select * from app where approve='P'";
        System.out.println(q);
        ResultSet rs;
        for (int j=0;j<5;j++)
            lables[j]=new ArrayList<>();
        //List<String> label=new ArrayList<>();
        try {
            rs=con.prepareStatement(q).executeQuery();
            while (rs.next()){
                lables[0].add(""+rs.getInt(1));
                lables[1].add(""+rs.getInt(4));
                lables[2].add(""+rs.getInt(2));
                lables[3].add(""+rs.getString(3));
                lables[4].add(""+rs.getInt(5));
            }
            //Toast.makeText(.this, "Registered Successful", Toast.LENGTH_LONG).show();
            //startActivity(new Intent(Reg.this,Recep.class));
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        int i=0;
        // Creating adapter for spinner
        for(List<String> a : lables){
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, a);
            dataAdapter
                    .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            switch (i){
                case 0:s5.setAdapter(dataAdapter);break;
                case 1:s1.setAdapter(dataAdapter);break;
                case 2:s2.setAdapter(dataAdapter);break;
                case 3:s3.setAdapter(dataAdapter);break;
                case 4:s4.setAdapter(dataAdapter);break;
            }
            i++;
        }

        /*List<String> labels=new ArrayList<>();
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

        s1.setAdapter(dataAdapter);*/
    }
    static int i=0;

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position,
                               long id) {
        // On selecting a spinner item
        String label = parent.getItemAtPosition(position).toString();

        /*switch (i){
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
        }*/


        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "You selected: " + label,
                Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }

}
