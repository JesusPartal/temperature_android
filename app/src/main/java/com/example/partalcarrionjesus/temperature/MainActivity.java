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
    // function that return boolean true if a radio button is checked
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


        // This is executed when the user clicks on bt_convert button
        bt_convert.setOnClickListener(new View.OnClickListener() {



            public void onClick(View v) {
                // Take the value of the EditText view 'inputTemp' and stored into a String variable
                String inputTemperature = inputTemp.getText().toString();
                String messageResult;
                //If input is empty, alert dialog is displayed
                if (inputTemperature.matches("")) {
                    new AlertDialog.Builder(MainActivity.this).setTitle("Error")
                            .setMessage("Temperature is empty")
                            .setPositiveButton("OK", null).show();
                } else {
                    try {
                        //set the temperature into the 'temperature' instance
                        temperature.setTemperature(Double.parseDouble(inputTemperature));
                        //if rb_Fahrenheit button is clicked; then temperature is converted to Celsius
                        // and messageResult is setup accordingly
                        if (onRadioButtonClicked(rb_Fahrenheit)) {
                            String celsius = temperature.toCelsius();
                            messageResult = inputTemperature + " °Fahrenheit is " + celsius + " °Celsius";
                        // otherwise, temperature is converted to Fahrenheit and messageResult is setup
                        } else {
                            String fahrenheit = temperature.toFahrenheit();
                            messageResult = inputTemperature + " °Celsius is \n" + fahrenheit + " °Fahrenheit";
                        }

                        //Create the intent to open the ResultsActivity
                        Intent intent = new Intent(MainActivity.this, ResultsActivity.class);
                        // passing the message to ResultsActivity
                        intent.putExtra("message", messageResult);
                        // the activity is started
                        startActivity(intent);
                    }
                    // if the inputTemp format is invalid, it will throw an error; catch and show alert dialog
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
