package com.example.kouobs;

import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

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
import java.util.List;


public class hesapolustur extends AppCompatActivity {


    private FirebaseAuth mAuth;

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


        EditText dogum = (EditText) findViewById(R.id.dogumtarihi);
        EditText email = (EditText) findViewById(R.id.emailsignup);
        EditText sifre = (EditText) findViewById(R.id.signuppassword);
        EditText sifreTekrar = (EditText) findViewById(R.id.signuppasswordagain);
        EditText ogrenciNo =(EditText) findViewById(R.id.ogrencino);
        EditText ogrenciAd = (EditText) findViewById(R.id.ogrenciad);
        EditText ogrenciSoyad = (EditText) findViewById(R.id.ogrencisoyad);
        EditText adres = (EditText) findViewById(R.id.adres);
        EditText telefonNo = (EditText) findViewById(R.id.telefonno);
        EditText dogumTarihi = (EditText) findViewById(R.id.dogumtarihi);
        EditText okul = (EditText) findViewById(R.id.universitesi);
        EditText bolum = (EditText) findViewById(R.id.bolumu);
        Button devam = (Button) findViewById(R.id.kayit);

        //arif enemesdfdf


        //buray if koşulları eklenecek. Ör: şifreler eşit mi ? veya bütün inputlr dolu mu




        devam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String eposta = email.getText().toString();
                String password = sifre.getText().toString();

                Log.d("eposta", eposta);
                Log.d("password", password);
              //  kullaniciolustur(eposta,password);
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
                            Toast.makeText(hesapolustur.this, "Giriş Başarılı",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("girisdurumu", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(hesapolustur.this, "Giriş Başarısız",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }

                    private void updateUI(FirebaseUser user) {
                    }
                });
    }


    private void kullanicibilgileri(){
        //burda kullanıcının bilgileri veritabanına eklenecek
    }




}