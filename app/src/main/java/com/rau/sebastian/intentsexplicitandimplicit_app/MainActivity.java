package com.rau.sebastian.intentsexplicitandimplicit_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private EditText codeInput;
    private EditText fullnameInput;
    private EditText amountInput;

    private Button implicitButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        codeInput = findViewById(R.id.codeInput);
        fullnameInput = findViewById(R.id.fullnameInput);
        amountInput = findViewById(R.id.amountInput);


        implicitButton = findViewById(R.id.implicitButton);

        implicitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "sendImplicit");

                String code = codeInput.getText().toString();
                String fullname = fullnameInput.getText().toString();
                String amount = amountInput.getText().toString();

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, "code: "+code+"\nfullname: "+fullname+"\namount: "+amount);
                intent.setType("text/plain");
                startActivity(intent);

            }
        });



    }

    public void sendExplicit(View view){

        Log.d(TAG, "sendExplicit");


        String code = codeInput.getText().toString();
        String fullname = fullnameInput.getText().toString();
        String amount = amountInput.getText().toString();

        if("".equals(code) || "".equals(fullname) || "".equals(amount)){
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("code", Integer.parseInt(code));
        intent.putExtra("fullname", fullname);
        intent.putExtra("amount", Double.parseDouble(amount));
        startActivity(intent);
    }

    public void sendImplicit(View view){

        String code = codeInput.getText().toString();
        String fullname = fullnameInput.getText().toString();
        String amount = amountInput.getText().toString();

        if("".equals(code) || "".equals(fullname) || "".equals(amount)){
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, "code: "+code+"\nfullname: "+fullname+"\namount: "+amount);
        intent.setType("text/plain");
        startActivity(intent);
    }
    public void callActivityA(View view){
        Log.d(TAG, "callActivityA");
        startActivityForResult(new Intent(this, PantallaAActivity.class), 1);
    }

    public void callActivityB(View view){
        Log.d(TAG, "callActivityB");
        startActivityForResult(new Intent(this, PantallaBActivity.class), 2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "onActivityResult");
        Log.d(TAG, "requestCode:"+requestCode);
        Log.d(TAG, "resultCode:"+resultCode);
        Log.d(TAG, "data:"+data);

        switch (requestCode){
            case 1:
                Log.d(TAG, "Regresamos del Activity A");
                break;
            case 2:
                Log.d(TAG, "Regresamos del Activity B");

                if(resultCode == RESULT_OK){
                    String valor = data.getExtras().getString("valor");
                    Log.d(TAG, "valor: " + valor);
                }

                break;
        }

    }

}
