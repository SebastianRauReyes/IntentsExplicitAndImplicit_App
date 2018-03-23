package com.rau.sebastian.intentsexplicitandimplicit_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PantallaBActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_b);


    }

    public void closeActivity(View view){

        Intent intent = new Intent();
        intent.putExtra("valor", "Dato adicional de retorno.");

        setResult(RESULT_OK, intent);   // Set ResultCode and DataIntent

        finish();
    }

}
