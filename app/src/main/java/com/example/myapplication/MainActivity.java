package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    protected static String TAG = "TAG";
    protected EditText editText;
    protected EditText editText2;
    protected TextView textView;
    protected Button button;
    protected TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate");

        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);
        result = (TextView) findViewById(R.id.result);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a,b,c;

                //Считаем с editText и editText2 текстовые значения
                String S1 = editText.getText().toString();
                String S2 = editText2.getText().toString();

                //Преобразуем текстовые переменные в числовые значения
                a = Double.parseDouble(S1);
                b = Double.parseDouble(S2);

                //Проведем с числовыми переменными нужные действия
                c = a + b;

                //Преобразуем ответ в число
                String S = Double.toString(c);

                result.setText(S);
            }
        });
    }



    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }



    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String stateSaved = savedInstanceState.getString("saved_state");
        if (stateSaved == null){
            Toast.makeText(MainActivity.this,
                    "onRestoreInstanceState:\n" +
                                "NO state saved",
                        Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(MainActivity.this,
                    "onRestoreInstanceState:\n" +
                                "state saved = " + stateSaved,
                        Toast.LENGTH_LONG).show();
            result.setText(stateSaved);

        }
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String stateToSave = result.getText().toString();
        outState.putString("saved_state", stateToSave);
        Toast.makeText(MainActivity.this,
                "onSaveInstanceState:\n" +
                "saved_state = " + stateToSave,
                Toast.LENGTH_LONG).show();
    }
}
