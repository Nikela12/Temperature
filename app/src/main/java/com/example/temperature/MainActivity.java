package com.example.temperature;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.QuickContactBadge;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText etNumber;
    RadioButton radioButton;
    RadioGroup radioGroup;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btnCal);
        etNumber = findViewById(R.id.etNumber);
        radioGroup= findViewById(R.id.radioGroup);
        result = findViewById(R.id.textView);

    }

    @Override
    protected void onResume() {
        super.onResume();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateAnswer();

            }
        });
    }

    private void calculateAnswer() {
        if(etNumber.getText().toString().isEmpty()){
            Toast.makeText(this, "Please add a value",
                    Toast.LENGTH_LONG).show();
        }
         else{
             int id = radioGroup.getCheckedRadioButtonId();
             radioButton = findViewById(id);
                    if(radioButton.getText().toString().equals("Fahrenhite")){
                        // convert it into Fahrenheit and display the answer
                        Float res=Calculation.convertCelciusToFahrenheit(Float.valueOf(etNumber.getText().toString()));
                        result.setText(String.valueOf(res));

        }
                    else if(radioButton.getText().toString().equals("Celcius")){
        // convert it into Celcius and display the answer
                        Float res=Calculation.convertFahrenheitToCelcius(Float.valueOf(etNumber.getText().toString()));
                        result.setText(String.valueOf(res));

                    }
                }

    }
}