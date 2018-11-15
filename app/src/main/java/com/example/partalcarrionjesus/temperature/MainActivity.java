package com.example.partalcarrionjesus.temperature;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText inputTemp = (EditText) findViewById(R.id.et_inputTemp);
        Button bt_toCelsius = (Button) findViewById(R.id.bt_toCelsius);
        Button bt_toFanreheit = (Button) findViewById(R.id.bt_toFarenheit);
        final Temperature temperature = new Temperature();

        bt_toCelsius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
