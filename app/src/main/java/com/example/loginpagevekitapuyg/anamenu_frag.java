package com.example.loginpagevekitapuyg;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class anamenu_frag extends Fragment {
    TextView kullaniciadi;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_anamenu_frag, container, false);
        kullaniciadi=view.findViewById(R.id.degistir);

        Bundle bundle2=this.getArguments();
        kullaniciadi.setText(bundle2.getString("adkeey"));


        return view;
    }
}