package com.example.kouobs;

import android.os.Bundle;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

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

        //Scrolling activity ile gelen button gerkesiz olduğu için görülmez hale getirir

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


}


}