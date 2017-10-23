package com.example.lenovopc.gudhang.adapter;

public class ListItem extends AbstractItem {

    public ListItem(String nama, String harga, String lokasi, String grosir, int fotoProduk) {
        super(nama, harga, lokasi, grosir, fotoProduk);

    }

    @Override
    public int getType() {
        return 0;
    }

}
