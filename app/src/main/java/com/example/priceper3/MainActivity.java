package com.example.priceper3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView r1, r2;
    EditText p1, p2, q1, q2;
    Button c;

    double p_1, p_2, q_1, q_2;
    double r_1, r_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r1 = (TextView)findViewById(R.id.r1);
        r2 = (TextView)findViewById(R.id.r2);

        p1 = (EditText)findViewById(R.id.p1);
        p2 = (EditText)findViewById(R.id.p2);
        q1 = (EditText)findViewById(R.id.q1);
        q2 = (EditText)findViewById(R.id.q2);

        c = (Button)findViewById(R.id.c);

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                p_1 = Double.parseDouble(p1.getText().toString());
                p_2 = Double.parseDouble(p2.getText().toString());
                q_1 = Double.parseDouble(q1.getText().toString());
                q_2 = Double.parseDouble(q2.getText().toString());

                r_1 = p_1 / q_1;
                r_2 = p_2 / q_2;



                r1.setText(String.format("%.4g%n",r_1));
                r2.setText(String.format("%.4g%n",r_2));




            }
        });


    }
}
