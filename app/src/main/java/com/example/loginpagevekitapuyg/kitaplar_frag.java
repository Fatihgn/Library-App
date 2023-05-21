package com.example.loginpagevekitapuyg;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class kitaplar_frag extends Fragment {

    ListView listem;
    private ArrayAdapter<String> adapter;
    private String [] kitapturleri = {"Dünya Klasikleri","Roman","Psikoloji","Korku-Gerilim","Macera-Aksiyon","Şiir","Fantastik","Bilim-Kurgu","Türk Klasikleri","Halk Edebiyatı"
            ,"Tiyatro"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kitaplar_frag, container, false);

        listem=view.findViewById(R.id.listem);
        adapter=new ArrayAdapter<>(view.getContext(), android.R.layout.simple_expandable_list_item_1,kitapturleri);
        listem.setAdapter(adapter);
        listem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle bundle = new Bundle();
                String kitap = kitapturleri[i];
                bundle.putString("arg1",kitap);
                kitaplar_frag_2 fragment2 = new kitaplar_frag_2();
                fragment2.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentler,fragment2).commit();
            }
        });
        return view;

    }
}