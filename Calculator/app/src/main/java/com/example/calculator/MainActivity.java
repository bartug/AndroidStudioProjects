package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView resultText;
    EditText    editText1;
    EditText    editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText);
         editText2 = findViewById(R.id.editText2);
         resultText = findViewById(R.id.textView);
    }
    public void toplama(View view)
    {
        if (editText1.getText().toString().matches("") || editText2.getText().toString().matches(""))
        {
            resultText.setText("Lütfen sayı giriniz!!");
        }
        else {
            int a = Integer.parseInt(editText1.getText().toString()); //edittexti gettext ile aldım tostring ile stringe çevirdim. İnt almam lazımdı bu yöntemle çevirdi
            int b = Integer.parseInt(editText2.getText().toString());
            int resultint = a + b;
            resultText.setText("Result: " + resultint);
        }
    }
    public void cikarma(View view)
    { if (editText1.getText().toString().matches("") || editText2.getText().toString().matches(""))
    {
        resultText.setText("Lütfen sayı giriniz!!");
    }
    else {
        int a = Integer.parseInt(editText1.getText().toString()); //edittexti gettext ile aldım tostring ile stringe çevirdim. İnt almam lazımdı bu yöntemle çevirdi
        int b = Integer.parseInt(editText2.getText().toString());
        int resultint = a - b;
        resultText.setText("Result: " + resultint);
    }

    }
    public void carpim(View view)
    {
        if (editText1.getText().toString().matches("") || editText2.getText().toString().matches(""))
        {
            resultText.setText("Lütfen sayı giriniz!!");
        }
        else {
            int a = Integer.parseInt(editText1.getText().toString()); //edittexti gettext ile aldım tostring ile stringe çevirdim. İnt almam lazımdı bu yöntemle çevirdi
            int b = Integer.parseInt(editText2.getText().toString());
            int resultint = a * b;
            resultText.setText("Result: " + resultint);
        }
    }
    public void bolme(View view)
    {
        if (editText1.getText().toString().matches("") || editText2.getText().toString().matches(""))
        {
            resultText.setText("Lütfen sayı giriniz!!");
        }
        else {
            int a = Integer.parseInt(editText1.getText().toString()); //edittexti gettext ile aldım tostring ile stringe çevirdim. İnt almam lazımdı bu yöntemle çevirdi
            int b = Integer.parseInt(editText2.getText().toString());
            int resultint = a / b;
            resultText.setText("Result: " + resultint);
        }
    }
}
