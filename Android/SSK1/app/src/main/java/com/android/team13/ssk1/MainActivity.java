package com.android.team13.ssk1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button b1;
   // Button b2;
    Button b3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("FSS Portal");
        b1 = (Button)findViewById(R.id.button2);
        //b2 = (Button)findViewById(R.id.button3);
        b3 = (Button)findViewById(R.id.button4);
        final Bundle bundle = getIntent().getExtras();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, appoint.class);

                startActivity(i);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(MainActivity.this, request.class);
                i3.putExtras(bundle);
                startActivity(i3);
            }
        });
    }
}
