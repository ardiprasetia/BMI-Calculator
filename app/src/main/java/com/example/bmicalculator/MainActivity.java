package com.example.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Deklarasi variabel penampung
    EditText edtWeight, edtHeight;
    TextView ttvResultNumber, ttvResultSentence;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Sambungkan widget dari XML ke JAVA
        //ttv untuk JAV
        edtWeight = findViewById(R.id.etWeight);
        edtHeight = findViewById(R.id.etHeight);
        ttvResultNumber = findViewById(R.id.tvResultNumber);
        ttvResultSentence = findViewById(R.id.tvResultSentence);


    }

    public void calculateBMI(View view) {

        //Dapatkan input user di etHeight
        String sHeight =  edtHeight.getText().toString();
        //Menghandel error jika belom di isi sama sekali
        if (sHeight.length()==0){
            sHeight = "0";
        }
        String sWeight = edtWeight.getText().toString();
        if (sWeight.length()==0){
            sWeight = "0";
        }
        //Konersi inputan user dari string menjadi double
        double dHeight = (Double.parseDouble(sHeight))/100; //m
        double dWeight = Double.parseDouble(sWeight); // Kg

        double dBMI = dWeight /(dHeight*dHeight); //Kg/m2 ideal 18.5-25

        //Membulatkan nilai yg berkoma dengan 2 angka di belakang koma
        // misal angka 23,769234
        dBMI = dBMI*100; //2376,9234
        dBMI = Math.round(dBMI); //2376
        dBMI = dBMI/100; //23,76
        //Munculin Di result
        ttvResultNumber.setText(""+dBMI);
        if (dBMI>= 18.5 && dBMI <=25 ){
            ttvResultSentence.setText("BMI anda ideal");

        }
        else if(dBMI > 25 ){
            ttvResultSentence.setText("BMI lebih dari ideal");
        }
        else    {
            ttvResultSentence.setText("BMI Kurang dari ideal");
        }


        Toast.makeText(this, "" + dBMI,
                Toast.LENGTH_SHORT).show();


    }
}
