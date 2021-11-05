package com.example.kouobs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
// şifremi unuttum için şifre yolla kontrol et

public class sifrenimiunuttun extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sifrenimiunuttun);

        TextView afterText = (TextView) findViewById(R.id.aftertext);
        Button reset = (Button) findViewById(R.id.reset);
        EditText resetpassword = (EditText) findViewById(R.id.emailsignup);
        ProgressBar pb = (ProgressBar) findViewById(R.id.progressBar);
        //eklendi
        TextView sifre = (TextView) findViewById(R.id.password);

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

                 FirebaseAuth mAuth;


                FirebaseAuth.getInstance().sendPasswordResetEmail(sifre.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Log.d("EmailGonderildiMi", "Email sent.");
                                }
                                else{

                                    Log.d("EmailGonderildiMi", "Email gönderilmedi");
                                    afterText.setText("Böyle bir e-posta bulunamadı");
                                }
                            }
                        });

            }
        });
    }
}