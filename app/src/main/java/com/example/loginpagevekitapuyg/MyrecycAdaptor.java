package com.example.loginpagevekitapuyg;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyrecycAdaptor extends RecyclerView.Adapter<MyrecycAdaptor.Myholder> {
    private ArrayList<Kitaplar> kitap;

    public MyrecycAdaptor(ArrayList<Kitaplar> kitap) {
        this.kitap=kitap;
    }

    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kitaplar,parent,false);
        return new Myholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myholder holder, int position) {
        holder.kitap.setText(kitap.get(position).getKitap_ismi());
        holder.sayfa.setText(kitap.get(position).getSayfa_sayisi());
        holder.yazar.setText(kitap.get(position).getYazar_ismi());
        holder.kitap_foto.setImageResource(kitap.get(position).getKitap_foto());

    }

    @Override
    public int getItemCount() {
        return kitap.size();
    }

    public class Myholder extends RecyclerView.ViewHolder{
        TextView yazar,kitap,sayfa;
        ImageView kitap_foto;

        public Myholder(@NonNull View itemView) {
            super(itemView);
            kitap_foto=itemView.findViewById(R.id.fotoid);
            yazar=itemView.findViewById(R.id.yazarid);
            kitap=itemView.findViewById(R.id.kitapid);
            sayfa=itemView.findViewById(R.id.sayfaid);




        }

    }
}
