package com.example.loginpagevekitapuyg;

public class Kitaplar {
    private String kitap_ismi,sayfa_sayisi,yazar_ismi;
    private int kitap_foto;

    public String getKitap_ismi() {
        return kitap_ismi;
    }

    public void setKitap_ismi(String kitap_ismi) {
        this.kitap_ismi = kitap_ismi;
    }

    public String getSayfa_sayisi() {
        return sayfa_sayisi;
    }

    public void setSayfa_sayisi(String sayfa_sayisi) {
        this.sayfa_sayisi = sayfa_sayisi;
    }

    public String getYazar_ismi() {
        return yazar_ismi;
    }

    public void setYazar_ismi(String yazar_ismi) {
        this.yazar_ismi = yazar_ismi;
    }

    public int getKitap_foto() {
        return kitap_foto;
    }

    public void setKitap_foto(int kitap_foto) {
        this.kitap_foto = kitap_foto;
    }

    public Kitaplar(String kitap_ismi, String sayfa_sayisi, String yazar_ismi, int kitap_foto) {
        this.kitap_ismi = kitap_ismi;
        this.sayfa_sayisi = sayfa_sayisi;
        this.yazar_ismi = yazar_ismi;
        this.kitap_foto = kitap_foto;
    }
}
