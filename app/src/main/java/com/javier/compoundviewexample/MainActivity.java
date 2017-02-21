package com.javier.compoundviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SidesSpinner fruitSpinner;
        fruitSpinner = (SidesSpinner)this .findViewById(R.id.sidespinner_fruits);

        CharSequence fruitList[] = {"Apple", "Orange", "Pear", "Grapes"};

        fruitSpinner.setValues(fruitList);
        fruitSpinner.setSelectedIndex(1);
    }
}
