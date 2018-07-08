package com.android.team13.ssk1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class request extends AppCompatActivity {

    Spinner q1,q2,q3,r4;
    TextView t1;
    TextView t2;
    TextView t3;
    TextView t4;
    String a1,a2,a3,a4,a5;
    Button br;
    String ty;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);
        q1 = (Spinner)findViewById(R.id.spinner9);
        q2 = (Spinner)findViewById(R.id.spinner10);
        q3 = (Spinner)findViewById(R.id.spinner11);
        r4 = (Spinner)findViewById(R.id.spinner12);
        t1 = (TextView)findViewById(R.id.textView14);
        t2 = (TextView)findViewById(R.id.textView15);
        t3 = (TextView)findViewById(R.id.textView16);
        t4 = (TextView)findViewById(R.id.textView17);
        //r5=(Spinner)findViewById(R.id.spinner13) ;
        Bundle b=getIntent().getExtras();
        ty=b.getString("type");
        br=(Button)findViewById(R.id.button11);
        q1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                a1=adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        q2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                a2=adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        q3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                a3=adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        r4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                a4=adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        load();

        br.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Connection con=new Connect().getCon();

                ResultSet r= null;
                try {
                    r = con.prepareStatement("select app_id from app where doc_id="+a2+" and dat='"+a3+"' and sl_no="+a4).executeQuery();

                ResultSet r1=con.prepareStatement("select app_id from app where reg_no="+a1+" and dat='"+a3+"' and sl_no="+a4).executeQuery();

                if(r.next() || r1.next())
                    Toast.makeText(request.this, "Cannot book", Toast.LENGTH_LONG).show();
                else
                {
                    if (ty.equals("fss"))
                        con.prepareStatement("insert into app values("+a2+",'"+a3+"',"+a1+","+a4+",'A','B','A')");
                    else
                        con.prepareStatement("insert into app values("+a2+",'"+a3+"',"+a1+","+a4+",'P','NB','P')");
                }} catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });


    }

    private void load(){
        List<String> lables[] = new ArrayList[5];
        Connection con = new Connect().getCon();
        String qq1="select reg_no from register",qq2="select id from staff",qq3="select dat from ava",qq4="select sl_no from slot";
        //System.out.println(q);
        ResultSet rs1;
        for (int j=0;j<4;j++)
            lables[j]=new ArrayList<>();
        try {
        rs1=con.prepareStatement(qq1).executeQuery();
        while (rs1.next()){
            lables[0].add(""+rs1.getInt(1));
        }
        rs1=con.prepareStatement(qq2).executeQuery();
        while (rs1.next()){
            lables[1].add(""+rs1.getInt(1));
        }
        rs1=con.prepareStatement(qq3).executeQuery();
        while (rs1.next()){
            lables[2].add(""+rs1.getInt(1));
        }
        rs1=con.prepareStatement(qq4).executeQuery();
        while (rs1.next()){
            lables[3].add(""+rs1.getInt(1));
        }
        //List<String> label=new ArrayList<>();



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
                case 0:q1.setAdapter(dataAdapter);break;
                case 1:q2.setAdapter(dataAdapter);break;
                case 2:q3.setAdapter(dataAdapter);break;
                case 3:r4.setAdapter(dataAdapter);break;

            }
            i++;
        }
    }
}
