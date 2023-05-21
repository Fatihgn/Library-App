package com.example.loginpagevekitapuyg;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AnaEkran extends AppCompatActivity {
    String kullaniciadi,sifre,eposta,telno;
    BottomNavigationView bottom_navim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ana_ekran);
        bottom_navim=findViewById(R.id.bnavim);
        kullaniciadi=getIntent().getStringExtra("adkey");
        sifre=getIntent().getStringExtra("sifrekey");
        eposta=getIntent().getStringExtra("emailkey");
        telno=getIntent().getStringExtra("telnokey");
        Fragment frag2 = new anamenu_frag();
        Bundle bundle2=new Bundle();
        bundle2.putString("adkeey",kullaniciadi);
        frag2.setArguments(bundle2);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentler,frag2).commit();
        bottom_navim.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.anamenü:
                        Fragment frag2 = new anamenu_frag();
                        Bundle bundle2=new Bundle();
                        bundle2.putString("adkeey",kullaniciadi);
                        frag2.setArguments(bundle2);
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentler,frag2).commit();
                        break;

                    case R.id.kitaplar:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentler,new kitaplar_frag()).commit();
                        break;

                    case R.id.bilgiler:
                        Fragment frag = new bilgiler_frag();
                        Bundle bundle=new Bundle();
                        bundle.putString("adkeey",kullaniciadi);
                        bundle.putString("sifrekeey",sifre);
                        bundle.putString("epostakeey",eposta);
                        bundle.putString("telnokeey",telno);
                        frag.setArguments(bundle);
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentler,frag).commit();
                        break;

                }
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent geriIntent = new Intent(AnaEkran.this,MainActivity.class);
        finish();
        startActivity(geriIntent);
    }
}