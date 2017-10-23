package com.example.lenovopc.gudhang.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public abstract class AbstractItem {
/*
    public static final int LIST_TYPE_PERTANIAN = 0;
    public static final int LIST_TYPE_PETERNAKAN = 1;
    public static final int LIST_TYPE_KERAJINAN = 2;
*/
    private String nama, harga, lokasi, grosir;
    private int fotoProduk;

    public AbstractItem(String dataSet, String dataSet2, String dataSet3, String dataSet4, int dataSet5) {
       // this.label = label;
        this.nama = dataSet;
        this.harga = dataSet2;
        this.lokasi = dataSet3;
        this.grosir = dataSet4;
        this.fotoProduk = dataSet5;
    }
/*
    public TextView getNama() {
        return nama;
    }
    public TextView getHarga() {
        return harga;
    }
    public TextView getLokasi() {
        return lokasi;
    }
    public TextView getGrosir() {
        return grosir;
    }
    public ImageView getFotoProduk() {
        return fotoProduk;
    }
*/
    public String getNama() {
        return nama;
    }
    public String getHarga() {
        return harga;
    }
    public String getLokasi() {
        return lokasi;
    }
    public String getGrosir() {
        return grosir;
    }
    public int getFotoProduk() {
        return fotoProduk;
    }

    public void setNama(String dataSet) {
        this.nama = dataSet;
    }
    public void setHarga(String dataSet2) {
        this.harga = dataSet2;
    }
    public void setLokasi(String dataSet3) {
        this.lokasi = dataSet3;
    }
    public void setGrosir(String dataSet4) {
        this.grosir = dataSet4;
    }
    public void setFotoProduk(int dataSet5) {
        this.fotoProduk = dataSet5;
    }

    abstract public int getType();
/*
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    abstract public int getType();
*/
}