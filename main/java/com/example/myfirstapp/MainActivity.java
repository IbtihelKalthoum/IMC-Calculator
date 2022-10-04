package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button calculate_button;
    EditText height_value;
    EditText weight_value;
    TextView result ;
    float height, weight,imc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculate_button=(Button) findViewById(R.id.button);
        height_value = (EditText) findViewById(R.id.taille);
        weight_value = (EditText) findViewById(R.id.poids);
        result = (TextView) findViewById(R.id.result);

        calculate_button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {

                if (height_value.getText().length() > 0 && weight_value.getText().length() > 0) {
                    height= Float.parseFloat(height_value.getText().toString());
                    weight = Float.parseFloat(weight_value.getText().toString());
                    imc = CalcIMC(weight, height);
                    System.out.println(imc+"height"+height);
                    if (imc < 16) {
                        result.setText("Votre IMC est: " + imc + " Vous êtes trop maigre");
                    } else if (imc < 18.5) {
                        result.setText("Votre IMC est: " + imc + " vous êtes maigre");
                    } else if (imc < 25) {
                        result.setText("Votre IMC est: " + imc + " vous êtes normal");
                    } else if (imc < 30) {
                        result.setText("Votre IMC est: " + imc + " vous êtes Gros(se)");
                    } else {
                        result.setText("Votre IMC est : " + imc + "vous êtes Obése");
                    }
                }
            }
        });
    }

    public float CalcIMC(float weight, float height) {
        height = (height/100);
        return (float)(weight/(height*height));
    }
}