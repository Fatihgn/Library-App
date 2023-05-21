package com.example.loginpagevekitapuyg;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.loginpagevekitapuyg.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DatabaseHelper(this);

        binding.btnGiris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String kullaniciadi = binding.etKullaniciadi.getText().toString();
                String sifre = binding.etSifre.getText().toString();


                if(kullaniciadi.equals("") || sifre.equals("")){
                    Toast.makeText(MainActivity.this, "Tüm alanları doldurmak zorunludur.", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean checkCredentials = databaseHelper.checkKullaniciadiSifre(kullaniciadi,sifre);

                    if(checkCredentials == true){
                        Toast.makeText(MainActivity.this, "Giriş başarılı.", Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(getApplicationContext(),AnaEkran.class);
                        intent1.putExtra("adkey",kullaniciadi);
                        intent1.putExtra("sifrekey",sifre);
                        String eposta=databaseHelper.getemail(kullaniciadi,sifre);
                        String telno = databaseHelper.gettelno(kullaniciadi,sifre);
                        intent1.putExtra("emailkey",eposta);
                        intent1.putExtra("telnokey",telno);
                        startActivity(intent1);
                    }else{
                        Toast.makeText(MainActivity.this, "Geçersiz bilgiler.", Toast.LENGTH_SHORT).show();
                    }
                }



            }
        });

        binding.btnKayitol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(MainActivity.this,KayitOl.class);
                startActivity(intent2);
            }
        });





    }
}