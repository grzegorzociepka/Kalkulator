package com.example.grzesiek.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

import static java.lang.Integer.valueOf;

public class MainActivity extends AppCompatActivity {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.m_button);
        button.setOnClickListener(btnListener);


    }
    //button listener
    public void getData(View view){
        SharedPreferences sp = getSharedPreferences("Save",Context.MODE_PRIVATE);
        String data = sp.getString("Data","");
        EditText et = (EditText) findViewById(R.id.et);
        et.setText(data);
    }
    private View.OnClickListener btnListener = new View.OnClickListener() {

        public void onClick (View view) {

            EditText et = (EditText) findViewById(R.id.et);
            String str = et.getText().toString();

            SharedPreferences sp = getSharedPreferences("Save", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.putString("Data", str);
            editor.commit();
            //Toast.makeText(this,"saved",Toast.LENGTH_LONG).show();

            String[] parts = str.split("\\n");

            Double [] a = new Double[parts.length];
            for(int i =0; i<a.length;i++)
            {
                a[i]= Double.parseDouble(parts[i]);// Parsing from string to int
            }

            double sum = 0;
            for( double num : a) {
                sum = sum+num;
            }

            TextView tv = (TextView) findViewById(R.id.tv);
            tv.setText(Double.toString(sum));
        }
    };

}