package com.example.partalcarrionjesus.temperature;

import android.content.Intent;
import android.content.RestrictionEntry;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextClock;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public boolean onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        return checked;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText inputTemp = (EditText) findViewById(R.id.et_inputTemp);
        Button bt_convert = (Button) findViewById(R.id.bt_convert);
        final Temperature temperature = new Temperature();
        final RadioButton rb_Celsius = (RadioButton) findViewById(R.id.rb_Celsius);
        final RadioButton rb_Fahrenheit = (RadioButton) findViewById(R.id.rb_Fahrenheit);



        bt_convert.setOnClickListener(new View.OnClickListener() {



            public void onClick(View v) {
                String inputTemperature = inputTemp.getText().toString();
                String messageResult;
                if (inputTemperature.matches("")) {
                    new AlertDialog.Builder(MainActivity.this).setTitle("Error")
                            .setMessage("Temperature is empty")
                            .setPositiveButton("OK", null).show();
                } else {
                    try {
                        temperature.setTemperature(Double.parseDouble(inputTemperature));

                        if (onRadioButtonClicked(rb_Fahrenheit)) {
                            String celsius = temperature.toCelsius();
                            messageResult = inputTemperature + " Fahrenheit is " + celsius + " Celsius";

                        } else {
                            String fahrenheit = temperature.toFahrenheit();
                            messageResult = inputTemperature + " Celsius is \n" + fahrenheit + " Fahrenheit";
                        }


                        Intent intent = new Intent(MainActivity.this, ResultsActivity.class);
                        intent.putExtra("message", messageResult);
                        startActivity(intent);
                    }
                    catch (NumberFormatException e){
                        new AlertDialog.Builder(MainActivity.this).setTitle("Error")
                                .setMessage("Not a valid temperature")
                                .setPositiveButton("OK", null).show();
                    }

                }
            }
        });
    }
}
