package com.example.kouobs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class sifrenimiunuttun extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sifrenimiunuttun);

        TextView afterText = (TextView) findViewById(R.id.aftertext);
        Button reset = (Button) findViewById(R.id.reset);
        EditText resetpassword = (EditText) findViewById(R.id.emailsignup);
        ProgressBar pb = (ProgressBar) findViewById(R.id.progressBar);

        pb.setVisibility(View.INVISIBLE);
        afterText.setVisibility(View.INVISIBLE);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pb.setVisibility(View.VISIBLE);
                resetpassword.setVisibility(View.INVISIBLE);
                reset.setEnabled(false);
                afterText.setVisibility(View.VISIBLE);
                pb.setVisibility(View.INVISIBLE);

            }
        });
    }
}