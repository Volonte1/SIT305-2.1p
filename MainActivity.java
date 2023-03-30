package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Spinner fromUnitSpinner;
    private Spinner toUnitSpinner;
    private EditText fromValueEditText;
    private TextView toValueTextView;
    //Declaration of all assets that are used in the XML
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fromUnitSpinner = findViewById(R.id.fromUnitSpinner);
        toUnitSpinner = findViewById(R.id.toUnitSpinner);
        fromValueEditText = findViewById(R.id.fromValueEditText);
        toValueTextView = findViewById(R.id.toValueTextView);

        // Set up the spinners for both the source and destination
        ArrayAdapter<CharSequence> unitAdapter = ArrayAdapter.createFromResource(this, R.array.To, android.R.layout.simple_spinner_item);
        unitAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fromUnitSpinner.setAdapter(unitAdapter);
        toUnitSpinner.setAdapter(unitAdapter);

        // Setting up the button to perform the conversion
        Button convertButton = findViewById(R.id.convertButton);
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fromUnit = fromUnitSpinner.getSelectedItem().toString();
                String toUnit = toUnitSpinner.getSelectedItem().toString();
                double fromValue = Double.parseDouble(fromValueEditText.getText().toString());
                //double parse converts it into a string format with more accuracy
                double toValue = convert(fromValue, fromUnit, toUnit);

                toValueTextView.setText(String.format("%.2f", toValue));
            }
        });
    }

    private double convert(double fromValue, String fromUnit, String toUnit) {
        double toValue = 0.0;

        // Perform the conversion using if statements THERES A LOT OF THEM!!
        if (fromUnit.equals("Inch") && toUnit.equals("Foot")) {
            toValue = fromValue / 12.0;
        } else if (fromUnit.equals("Inch") && toUnit.equals("Yard")) {
            toValue = fromValue / 36.0;
        } else if (fromUnit.equals("Inch") && toUnit.equals("Mile")) {
            toValue = fromValue / 63360.0;
        } else if (fromUnit.equals("Foot") && toUnit.equals("Inch")) {
            toValue = fromValue * 12.0;
        } else if (fromUnit.equals("Foot") && toUnit.equals("Yard")) {
            toValue = fromValue / 3.0;
        } else if (fromUnit.equals("Foot") && toUnit.equals("Mile")) {
            toValue = fromValue / 5280.0;
        } else if (fromUnit.equals("Yard") && toUnit.equals("Inch")) {
            toValue = fromValue * 36.0;
        } else if (fromUnit.equals("Yard") && toUnit.equals("Foot")) {
            toValue = fromValue * 3.0;
        } else if (fromUnit.equals("Yard") && toUnit.equals("Mile")) {
            toValue = fromValue / 1760.0;
        } else if (fromUnit.equals("Mile") && toUnit.equals("Inch")) {
            toValue = fromValue * 63360.0;
        } else if (fromUnit.equals("Mile") && toUnit.equals("Foot")) {
            toValue = fromValue ;
        }   else if (fromUnit.equals("Pound") && toUnit.equals("Ounce")) {
            toValue = fromValue * 16.0;
        }   else if (fromUnit.equals("Pound") && toUnit.equals("Ton")) {
            toValue = fromValue * 0.0005;
        }   else if (fromUnit.equals("Ounce") && toUnit.equals("Ton")) {
            toValue = fromValue * 0.00003125;
        }   else if (fromUnit.equals("Ounce") && toUnit.equals("Pound")) {
            toValue = fromValue / 16;
        }   else if (fromUnit.equals("Ton") && toUnit.equals("Pound")) {
            toValue = fromValue * 2000;
        }   else if (fromUnit.equals("Ton") && toUnit.equals("Ounce")) {
            toValue = fromValue * 32000;
        }   else if (fromUnit.equals("Celsius") && toUnit.equals("Fahrenheit")) {
            toValue = (fromValue * 1.8) + 32;
        }   else if (fromUnit.equals("Celsius") && toUnit.equals("Kelvin")) {
            toValue = fromValue + 273.15;
        }   else if (fromUnit.equals("Fahrenheit") && toUnit.equals("Celsius")) {
            toValue = (fromValue -32) / 1.8;
        }   else if (fromUnit.equals("Fahrenheit") && toUnit.equals("Kelvin")) {
            toValue = (fromValue + 459.67) / 0.55;
        }   else if (fromUnit.equals("Kelvin") && toUnit.equals("Celsius")) {
            toValue = fromValue -273.15;
        }   else if (fromUnit.equals("Kelvin") && toUnit.equals("Fahrenheit")) {
            toValue = (fromValue -273.15) * 1.8 +32;

        }
        return toValue;
}}
