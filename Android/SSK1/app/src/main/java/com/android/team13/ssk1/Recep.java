package com.android.team13.ssk1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Recep extends AppCompatActivity {
    Button b1;
    Button b2,ba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recep);
        setTitle("Receptionist Portal");
        b1=(Button)findViewById(R.id.button6);
        b2=(Button)findViewById(R.id.button8);
        ba=(Button)findViewById(R.id.button10) ;
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Recep.this,viewrecep.class);
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Recep.this,Reg.class);
                startActivity(i);
            }
        });
        ba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Recep.this,request.class);
                startActivity(i);
            }
        });
    }
}
