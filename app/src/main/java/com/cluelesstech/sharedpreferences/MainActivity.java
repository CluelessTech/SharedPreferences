package com.cluelesstech.sharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button submit;
    private EditText enterValue;
    private TextView result;
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterValue = findViewById(R.id.enterValue);
        result = findViewById(R.id.result);
        submit = findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences = getSharedPreferences("myPreference", 0);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("message", enterValue.getText().toString());
                editor.commit();
                result.setText("Message: " + enterValue.getText().toString());
            }
        });

        //Get Data Back

        SharedPreferences preferences = getSharedPreferences("myPreference",0);
        if(preferences.contains("message")){
            String message = preferences.getString("message", "Not Found");
            result.setText("Message : " + message);
        }


    }
}