package com.example.loginpagevekitapuyg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.loginpagevekitapuyg.databinding.ActivityKayitOlBinding;

public class KayitOl extends AppCompatActivity {

    ActivityKayitOlBinding binding;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityKayitOlBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        databaseHelper = new DatabaseHelper(this);

        binding.btnYenikayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = binding.etYenimail.getText().toString();
                String kullaniciadi = binding.etYenikullaniciadi.getText().toString();
                String sifre = binding.etYenisifre.getText().toString();
                String telno = binding.etYenitelefon.getText().toString();

                if(email.equals("") || kullaniciadi.equals("") || sifre.equals("") || telno.equals("")){
                    Toast.makeText(KayitOl.this, "Tüm alanları doldurmak zorunludur.", Toast.LENGTH_SHORT).show();
                }else{
                    Boolean checkUserEmail = databaseHelper.checkEmail(email);
                    if(checkUserEmail == false){
                        Boolean insert = databaseHelper.insertData(kullaniciadi,sifre,email,telno);
                        if (insert == true){
                            Toast.makeText(KayitOl.this, "Kayıt başarılı.", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(KayitOl.this, "Kayıt başarısız.", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(KayitOl.this, "Kullanıcı zaten kayıtlı.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }
}