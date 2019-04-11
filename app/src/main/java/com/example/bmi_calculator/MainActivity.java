package com.example.bmi_calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText height, weight, bmi;
    Button btn_cal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_cal=(Button)findViewById(R.id.Calculate_btn);
        height=(EditText)findViewById(R.id.Height_EditText);
        weight=(EditText)findViewById(R.id.Weight_EditText);
        bmi=(EditText)findViewById(R.id.Result_EditText);

        btn_cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();

            }
        });
    }
    private void calculateBMI(){
        String heightStr= height.getText().toString();
        String weightStr= weight.getText().toString();

        if (heightStr !=null && !"".equals(heightStr) && weightStr !=null && !"".equals(weightStr)){
            float heightValue = Float.parseFloat(heightStr)/100;
            float weightValue = Float.parseFloat(weightStr);

            float bmi = weightValue / (heightValue * 2);
            displayBMI(bmi);
        }
    }
    private void displayBMI(float BMI){
        String bmiLabel;

        if (Float.compare(BMI, 18.5f) < 0){
            bmiLabel ="Under Weight";
        }
        else if (Float.compare(BMI, 18.5f) > 0 && Float.compare(BMI, 24.9f) <= 0){
            bmiLabel = "Normal";
        }
        else if (Float.compare(BMI, 25f) > 0 && Float.compare(BMI, 29.9f) <= 0){
            bmiLabel = "Over Weight";
        }
        else{
            bmiLabel="Obesity";
        }
        bmiLabel= BMI + "\n" +bmiLabel;
        bmi.setText(bmiLabel);

    }
}

























