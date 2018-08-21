package com.example.hp.firstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "Main_Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        Log.v(TAG, "onCreate: ");
        setContentView(R.layout.activity_main);
        ArrayList<word> names = new ArrayList<word>();
        names.add(new word("zero", "shunya",R.raw.zero));
        names.add(new word("one", "ek",R.raw.one));
        names.add(new word("two", "do",R.raw.two));
        names.add(new word("three", "teen",R.raw.three));
        names.add(new word("four", "chaar",R.raw.four));
        names.add(new word("five", "paanch",R.raw.five));
        names.add(new word("six", "che",R.raw.six));
        names.add(new word("seven", "saat",R.raw.seven));
        names.add(new word("eight", "aath",R.raw.eight));
        names.add(new word("nine", "nau",R.raw.nine));
        customadapt adapter = new customadapt(this, names);
        ListView listView = (ListView) findViewById(R.id.lay);
        listView.setAdapter(adapter);

    }


    public void fancyclick(View view) {
        Intent i = new Intent(this,Main2Activity.class);
        startActivity(i);
    }
}
