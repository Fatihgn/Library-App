package com.example.loginpagevekitapuyg;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class kitaplar_frag_2 extends Fragment {

    TextView tv;
    private RecyclerView benimrecyc;
    private ArrayList<Kitaplar> kitap;
    private MyrecycAdaptor myadaptor;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kitaplar_frag_2, container, false);
        tv=view.findViewById(R.id.kitapturu);
        benimrecyc=view.findViewById(R.id.myrecyc);
        Bundle bundle = this.getArguments();
        if(bundle!=null){
            String name = getArguments().getString("arg1");
            tv.setText(name);
        }
        kitap=new ArrayList<>();
        myadaptor=new MyrecycAdaptor(kitap);
        benimrecyc.setAdapter(myadaptor);
        benimrecyc.setLayoutManager(new LinearLayoutManager(getContext()));
        if(tv.getText().equals("Dünya Klasikleri"))
        {
            kitap.add(new Kitaplar("HOMEROS'UN KIZI","248 sayfa","Robert Graves",R.drawable.homerosunkizi));
            kitap.add(new Kitaplar("KÖLELER ADASI","64 sayfa","Pierre de Marivaux",R.drawable.koleleradasi));
            kitap.add(new Kitaplar("CAHİL FİLOZOF","88 sayfa","Voltaire",R.drawable.cahilfilozof));
        }
        if(tv.getText().equals("Roman"))
        {
            kitap.add(new Kitaplar("SUÇ VE CEZA","687 sayfa","Dostoyevski",R.drawable.sucveceza));
            kitap.add(new Kitaplar("KÜÇÜK PRENS","112 sayfa","Antoine de Saint-Exupéry",R.drawable.kucukprens));
        }
        if(tv.getText().equals("Psikoloji"))
        {
            kitap.add(new Kitaplar("NİETZSCHE AĞLADIĞINDA","415 sayfa","Irvin D. Yalom",R.drawable.nietzshe));

        }
        if(tv.getText().equals("Korku-Gerilim"))
        {
            kitap.add(new Kitaplar("KIZIL NEHİRLER","328 sayfa","Jean-Christophe Grangé",R.drawable.kizilnehirler));
        }
        if(tv.getText().equals("Macera-Aksiyon"))
        {
            kitap.add(new Kitaplar("HOBBİT","312 sayfa","J. R. R. Tolkien",R.drawable.hobbit));
            kitap.add(new Kitaplar("AÇLIK OYUNLARI","420 sayfa","Suzanne Collins",R.drawable.aclikoyunlari));
        }
        if(tv.getText().equals("Şiir"))
        {
            kitap.add(new Kitaplar("ÇİLE","512 sayfa","Necip Fazıl Kısakürek",R.drawable.cile));
        }
        if(tv.getText().equals("Fantastik"))
        {
            kitap.add(new Kitaplar("BEN, KİRKE","408 sayfa","Madeline Miller",R.drawable.kirke));
        }
        if(tv.getText().equals("Bilim-Kurgu"))
        {
            kitap.add(new Kitaplar("ZAMAN MAKİNESİ","120 sayfa","H. G. Wells",R.drawable.zaman));
        }
        if(tv.getText().equals("Türk Klasikleri"))
        {
            kitap.add(new Kitaplar("ÇALIKUŞU","544 sayfa","Reşat Nuri Güntekin",R.drawable.calikusu));
        }
        if(tv.getText().equals("Halk Edebiyatı"))
        {
            kitap.add(new Kitaplar("DEDE KORKUT HİKAYELERİ","160 sayfa", "Bilgin Cilasun",R.drawable.dede));
        }
        if(tv.getText().equals("Tiyatro"))
        {
            kitap.add(new Kitaplar("REİS BEY","152 sayfa", "Necip Fazıl Kısakürek",R.drawable.reis));
            kitap.add(new Kitaplar("KAPILARIN DIŞINDA","120 sayfa", "Wolfgang Borchert",R.drawable.kapi));
            kitap.add(new Kitaplar("ROMEO VE JULIET","133 sayfa", "William Shakespeare",R.drawable.romeo));
        }







        myadaptor.notifyDataSetChanged();

        return view;
    }
}