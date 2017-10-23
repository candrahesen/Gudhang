package com.example.lenovopc.gudhang.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovopc.gudhang.R;


public class ProdukDisimpanFragment extends Fragment {

    public ProdukDisimpanFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_produk_disimpan, container, false);

        return view;
    }

    
}
