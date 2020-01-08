package com.example.priceper;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Variables Declared
    View item1house;
    View item2house;
    EditText price1view;
    EditText price2view;
    double p1;
    double p2;
    EditText quantity1view;
    EditText quantity2view;
    double q1;
    double q2;
    TextView priceper1;
    TextView priceper2;
    double pp1;
    double pp2;
    Button clearbutton;
    Button comparebutton;
    TextView bd1;
    TextView bd2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Point to values in app
        price1view = findViewById(R.id.price1view);
        price2view = findViewById(R.id.price2view);
        quantity1view = findViewById(R.id.quantity1view);
        quantity2view = findViewById(R.id.quantity2view);
        priceper1 = findViewById(R.id.priceper1);
        priceper2 = findViewById(R.id.priceper2);
        clearbutton = findViewById(R.id.clearbutton);
        comparebutton = findViewById(R.id.comparebutton);


        //COMPARE BUTTON
        comparebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Get values of variables on button click
                try {
                    p1 = Double.parseDouble(price1view.getText().toString());
                }catch (Exception e){
                    p1 = 1;
                }
                try {
                    p2 = Double.parseDouble(price2view.getText().toString());
                }catch (Exception e){
                    p2 = 1;
                }
                try {
                    q1 = Double.parseDouble(quantity1view.getText().toString());
                }catch (Exception e){
                    q1 = 1;
                }
                try {
                    q2 = Double.parseDouble(quantity2view.getText().toString());
                }catch (Exception e){
                    q2 = 1;
                }
                try{
                    pp1 = p1 / q1;
                    pp2 = p2 / q2;
                }catch (Exception e){
                    System.out.println("Error");
                }

                //Display answer on button click
                priceper1.setText(String.format("%.4g%n", pp1));
                priceper2.setText(String.format("%.4g%n", pp2));

                //Make green & display best deal text
                try {
                    if (pp1 < pp2) {
                        (findViewById(R.id.item1house)).setBackgroundColor(Color.rgb(139,195,74));
                        (findViewById(R.id.item2house)).setBackgroundColor(Color.rgb(255,255,255));
                        ((TextView)findViewById(R.id.bd1)).setText(R.string.bd1);
                        ((TextView)findViewById(R.id.bd2)).setText(R.string.blank);
                    } else if (pp2 < pp1) {
                        (findViewById(R.id.item2house)).setBackgroundColor(Color.rgb(139,195,74));
                        (findViewById(R.id.item1house)).setBackgroundColor(Color.rgb(255,255,255));
                        ((TextView)findViewById(R.id.bd2)).setText(R.string.bd2);
                        ((TextView)findViewById(R.id.bd1)).setText(R.string.blank);
                    } else {
                        (findViewById(R.id.item1house)).setBackgroundColor(Color.rgb(139,195,74));
                        (findViewById(R.id.item2house)).setBackgroundColor(Color.rgb(139,195,74));
                        ((TextView)findViewById(R.id.bd1)).setText(R.string.sd);
                        ((TextView)findViewById(R.id.bd2)).setText(R.string.sd);
                    }
                } catch(Exception e){
                    System.out.println("Error");
                }
            }
        });

        //CLEAR BUTTON

        clearbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                (findViewById(R.id.item1house)).setBackgroundColor(Color.rgb(255,255,255));
                (findViewById(R.id.item2house)).setBackgroundColor(Color.rgb(255,255,255));
                ((TextView)findViewById(R.id.bd1)).setText(R.string.blank);
                ((TextView)findViewById(R.id.bd2)).setText(R.string.blank);
                p1 = 1;
                p2 = 1;
                q1 = 1;
                q2 = 1;
                pp1 = 1;
                pp2 = 1;
                price1view.setText(R.string.blank);
                price2view.setText(R.string.blank);
                quantity1view.setText(R.string.blank);
                quantity2view.setText(R.string.blank);
                priceper1.setText(R.string.priceper1);
                priceper2.setText(R.string.priceper2);
            }
        });





    }
}
