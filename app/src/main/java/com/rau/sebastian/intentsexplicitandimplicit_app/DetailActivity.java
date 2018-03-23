package com.rau.sebastian.intentsexplicitandimplicit_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private TextView codeText;
    private TextView fullnameText;
    private TextView amountText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        codeText = (TextView)findViewById(R.id.codeText);
        fullnameText = (TextView)findViewById(R.id.fullnameText);
        amountText = (TextView)findViewById(R.id.amountText);

        // Loading previus extras from intent
        if(this.getIntent().getExtras() != null) {

            if(this.getIntent().getExtras().get("code") != null) {
                int code = this.getIntent().getExtras().getInt("code");
                codeText.setText(String.valueOf(code));
            }

            if(this.getIntent().getExtras().get("fullname") != null) {
                String fullname = this.getIntent().getExtras().getString("fullname");
                fullnameText.setText(fullname);
            }

            if(this.getIntent().getExtras().get("amount") != null) {
                double amount = this.getIntent().getExtras().getDouble("amount");
                amountText.setText(String.valueOf(amount));
            }

        }



    }
}
