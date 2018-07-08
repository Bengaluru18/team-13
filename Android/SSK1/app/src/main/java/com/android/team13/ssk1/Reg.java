package com.android.team13.ssk1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.SQLException;

public class Reg extends AppCompatActivity {
    EditText e;
    EditText e2;
    EditText e3;
    EditText e4;

    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        e=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText2);
        e3=(EditText)findViewById(R.id.editText3);
        e4=(EditText)findViewById(R.id.editText4);

        b=(Button)findViewById(R.id.button7);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Connection con = new Connect().getCon();
                String q="insert into register values('"+e.getText().toString()+"',"+e2.getText().toString()+",'"+e3.getText().toString()+"','"+e4.getText().toString()+"','NULL',0,'P');";
               System.out.println(q);
                try {
                    con.prepareStatement(q).execute();
                    Toast.makeText(Reg.this, "Registered Successful", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Reg.this,Recep.class));
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

            }
        });


    }
}
