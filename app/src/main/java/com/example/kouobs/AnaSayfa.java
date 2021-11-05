package com.example.kouobs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AnaSayfa extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ana_sayfa);

        TextView uid = (TextView) findViewById(R.id.userid);
        Button pdf = (Button) findViewById(R.id.pdf);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("userId");
            Log.d("getuserid",value);
           uid.setText(value);
        }

        pdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AnaSayfa.this,pdfactivity.class);
                startActivity(intent);
            }
        });

    }
}