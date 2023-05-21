package com.example.loginpagevekitapuyg;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class bilgiler_frag extends Fragment {
    TextView kullanad,sifre,eposta,telno;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_bilgiler_frag, container, false);

        kullanad=view.findViewById(R.id.kullan_ad);
        sifre=view.findViewById(R.id.kullan_sifre);
        eposta=view.findViewById(R.id.kullan_email);
        telno=view.findViewById(R.id.kullan_telno);

        Bundle bundle=this.getArguments();
        kullanad.setText(bundle.getString("adkeey"));
        sifre.setText(bundle.getString("sifrekeey"));
        eposta.setText(bundle.getString("epostakeey"));
        telno.setText(bundle.getString("telnokeey"));
        return view;
    }
}