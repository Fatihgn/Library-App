package com.example.loginpagevekitapuyg;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String databaseName = "Uyeolmak.db";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "Uyeolmak.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDatabase) {
        MyDatabase.execSQL("create Table kullanicilar(kullaniciadi TEXT,sifre TEXT,email TEXT primary key,telno TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDatabase, int i, int i1) {
        MyDatabase.execSQL("drop Table if exists kullanicilar");
    }

    public Boolean insertData(String kullaniciadi,String sifre,String email,String telno){
        SQLiteDatabase MyDatabase =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("kullaniciadi",kullaniciadi);
        contentValues.put("sifre",sifre);
        contentValues.put("email",email);
        contentValues.put("telno",telno);
        long result = MyDatabase.insert("kullanicilar",null,contentValues);

        if(result == -1){
            return false;
        }else{
            return true;
        }
    }
    public Boolean checkEmail(String email){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from kullanicilar where email = ?",new String[]{email});

        if(cursor.getCount() > 0){
            return true;
        }else{
            return false;
        }
    }

    public Boolean checkKullaniciadiSifre(String kullaniciadi,String sifre){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from kullanicilar where kullaniciadi = ? and sifre = ?",new String[]{kullaniciadi,sifre});

        if(cursor.getCount() > 0){
            return true;
        }else{
            return false;
        }
    }
    public String getemail(String kullaniciadi,String sifre){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from kullanicilar where kullaniciadi = ? and sifre = ?",new String[]{kullaniciadi,sifre});
        if(cursor.moveToFirst()) {
            int emailid = cursor.getColumnIndex("email");
            return cursor.getString(emailid);
        }
        return "false";

    }
    public String gettelno(String kullaniciadi,String sifre){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from kullanicilar where kullaniciadi = ? and sifre = ?",new String[]{kullaniciadi,sifre});
        if(cursor.moveToFirst()) {
            int telid = cursor.getColumnIndex("telno");
            return cursor.getString(telid);
        }
        return "false";

    }





}
