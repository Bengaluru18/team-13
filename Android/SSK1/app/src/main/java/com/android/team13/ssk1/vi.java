package com.android.team13.ssk1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class vi extends AppCompatActivity {
    TextView t1;
    TextView t2;
    TextView t3;
    TextView t4;
    TextView t5;
    TextView t6;
    TextView t7;
    TextView t8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vi);
        t1= (TextView)findViewById(R.id.textView);
        t2= (TextView)findViewById(R.id.textView);
        t3= (TextView)findViewById(R.id.textView);
        t4= (TextView)findViewById(R.id.textView);
        t5= (TextView)findViewById(R.id.textView);
        t6= (TextView)findViewById(R.id.textView);
        t7= (TextView)findViewById(R.id.textView);
        t8= (TextView)findViewById(R.id.textView);
    }
}
