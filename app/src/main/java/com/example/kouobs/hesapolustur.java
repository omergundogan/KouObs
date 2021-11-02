package com.example.kouobs;

import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class hesapolustur extends AppCompatActivity {


    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    private FirebaseUser currentUser;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hesapolustur);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolBarLayout.setTitle(" ");

        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.app_bar);
        appBarLayout.setVisibility(View.INVISIBLE);


        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();



        EditText dogum = (EditText) findViewById(R.id.dogumtarihi);
        EditText email = (EditText) findViewById(R.id.emailsignup);
        EditText sifre = (EditText) findViewById(R.id.signuppassword);
        EditText sifreTekrar = (EditText) findViewById(R.id.signuppasswordagain);
        EditText ogrenciNo =(EditText) findViewById(R.id.ogrencino);
        EditText ogrenciAd = (EditText) findViewById(R.id.ogrenciad);
        EditText ogrenciSoyad = (EditText) findViewById(R.id.ogrencisoyad);
        EditText adress = (EditText) findViewById(R.id.adres);
        EditText telefonNo = (EditText) findViewById(R.id.telefonno);
        EditText dogumTarihi = (EditText) findViewById(R.id.dogumtarihi);
        EditText okull = (EditText) findViewById(R.id.universitesi);
        EditText bolumm = (EditText) findViewById(R.id.bolumu);
        Button devam = (Button) findViewById(R.id.kayit);

        //arif enemesdfdf


        //buray if koşulları eklenecek. Ör: şifreler eşit mi ? veya bütün inputlr dolu mu





        devam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String eposta = email.getText().toString();
                String password = sifre.getText().toString();
                String ogrencino = ogrenciNo.getText().toString();
                String ogrenciad = ogrenciAd.getText().toString();
                String ogrencisoyad = ogrenciSoyad.getText().toString();
                String adres = adress.getText().toString();
                String telefonno = telefonNo.getText().toString();
                String dogumtarihi = dogumTarihi.getText().toString();
                String okul = okull.getText().toString();
                String bolum = bolumm.getText().toString();


                kullaniciolustur(eposta,password);
                kullanicibilgileri( eposta,  password, ogrencino,  ogrenciad,
                         ogrencisoyad, adres, telefonno, dogumtarihi,
                         okul, bolum);


            }
        });





}
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            currentUser.reload();
        }
    }

    private void kullaniciolustur(String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("girisdurumu", "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(hesapolustur.this, "Kayıt Başarılı",
                                    Toast.LENGTH_SHORT).show();

                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("girisdurumu", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(hesapolustur.this, "Kayıt Başarısız",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }

                    private void updateUI(FirebaseUser user) {
                    }
                });
    }


    private void kullanicibilgileri(String email,String sifre,String ogrencino, String ogrenciad,
                                     String ogrencisoyad,String adres,String telefonNo,String dogumtarihi,
                                        String okul,String bolum){

       // currentUser = firebaseAuth.getCurrentUser();
        /*assert currentUser != null;
        final String currentUserId = currentUser.getUid();*/

         FirebaseFirestore db = FirebaseFirestore.getInstance();


         CollectionReference collectionReference = db.collection("kullanicilar");

         Map<String, String> kullanici = new HashMap<>();

        kullanici.put("email", email);
        kullanici.put("sifre", sifre);
        kullanici.put("OgrenciNo", ogrencino);
        kullanici.put("OgrenciAd", ogrenciad);
        kullanici.put("OgrenciSoyad", ogrencisoyad);
        kullanici.put("Adres", adres);
        kullanici.put("TelefonNo", telefonNo);
        kullanici.put("DogumTarihi", dogumtarihi);
        kullanici.put("Okul", okul);
        kullanici.put("Bolum", bolum);


        db.collection("kullanici")
                .add(kullanici)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d("bilgidurumu", "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("bilgidurumu", "Error adding document", e);
                    }
                });



}
}