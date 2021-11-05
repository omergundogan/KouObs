package com.example.kouobs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kouobs.ui.login.LoginActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class AnaSayfa extends AppCompatActivity {


    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference debtref = db.collection("kullanici");
    private String debtonoref = db.collection("kullanici").document().getPath();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ana_sayfa);

        TextView ogno = (TextView) findViewById(R.id.ogno);
        TextView ogad = (TextView) findViewById(R.id.ogad);
        TextView ogsoyad = (TextView) findViewById(R.id.ogsoyad);
        Button pdf = (Button) findViewById(R.id.pdf);

        Bundle extras = getIntent().getExtras();

            String userid = extras.getString("userId");
            Log.d("getuserid",userid);


        DocumentReference docRef = db.collection("kullanicilarcollection").document("SF");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d("sorgula", "DocumentSnapshot data: " + document.getData());

                        ogno.setText("Öğrenci Numarası: " + document.getString("OgrenciNo"));
                        ogad.setText("Öğrenci Adı: " +document.getString("OgrenciAd"));
                        ogsoyad.setText("Öğrenci Soyadı: " +document.getString("OgrenciSoyad"));
                    } else {
                        Log.d("sorgula", "No such document");
                    }
                } else {
                    Log.d("sorgula", "get failed with ", task.getException());
                }
            }
        });

        pdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AnaSayfa.this,pdfactivity.class);
                startActivity(intent);
            }
        });

    }


}