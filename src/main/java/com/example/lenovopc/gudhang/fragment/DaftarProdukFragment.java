package com.example.lenovopc.gudhang.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

// com.example.lenovopc.gudhang.adapter.AbstractItem;
//import com.example.lenovopc.gudhang.adapter.ListItem;
//import com.example.lenovopc.gudhang.adapter.RecyclerViewAdapter;
import com.example.lenovopc.gudhang.adapter.CustomAdapter;

import com.example.lenovopc.gudhang.R;

//import java.util.ArrayList;
//import java.util.List;


public class DaftarProdukFragment extends Fragment {

    private static final String TAG = "RecyclerViewFragment";
    private static final String KEY_LAYOUT_MANAGER = "layoutManager";
    private static final int SPAN_COUNT = 2;
    private static final int DATASET_COUNT = 60; // menampilkan data sebanyak value

    private enum LayoutManagerType {
        GRID_LAYOUT_MANAGER,
        LINEAR_LAYOUT_MANAGER
    }

    protected LayoutManagerType mCurrentLayoutManagerType;

    protected RecyclerView pertanianRecyclerView, peternakanRecyclerView, kerajinanRecyclerView;
    protected CustomAdapter pertanianAdapter, peternakanAdapter, kerajinanAdapter;
    protected RecyclerView.LayoutManager pertanianLayoutManager, peternakanLayoutManager, kerajinanLayoutManager;
    protected String[] mDataset, mDataset2, mDataset3, mDataset4;
    protected int[] mDataset5;

    int [] fotoProduk = {R.drawable.dummy_foto_produk, R.drawable.dummy_foto_produk,R.drawable.dummy_foto_produk};
    String [] namaProduk = {"Kampus","Kampus","Kampus"};
    String [] harga = {"belajar","belajar","belajar"};
    String [] lokasi = {"programming","programming","programming"};
    String [] grosir = {"belajar","belajar","belajar"};

    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize dataset, this data would usually come from a local content provider or
        // remote server.
        initDataset();
    }
/*
    public DaftarProdukFragment() {
        // Required empty public constructor
    }
*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_daftar_produk, container, false);
        rootView.setTag(TAG);

        // BEGIN_INCLUDE(initializeRecyclerView)
        pertanianRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerViewPertanian);
        peternakanRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerViewPeternakan);
        kerajinanRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerViewKerajinan);

        // LinearLayoutManager is used here, this will layout the elements in a similar fashion
        // to the way ListView would layout elements. The RecyclerView.LayoutManager defines how
        // elements are laid out.
        pertanianLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        peternakanLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        kerajinanLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);

        mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;

        if (savedInstanceState != null) {
            // Restore saved layout manager type.
            mCurrentLayoutManagerType = (LayoutManagerType) savedInstanceState
                    .getSerializable(KEY_LAYOUT_MANAGER);
        }
        setRecyclerViewLayoutManager(mCurrentLayoutManagerType);

        pertanianAdapter = new CustomAdapter(mDataset,mDataset2,mDataset3,mDataset4,mDataset5);
        peternakanAdapter = new CustomAdapter(mDataset,mDataset2,mDataset3,mDataset4,mDataset5);
        kerajinanAdapter = new CustomAdapter(mDataset,mDataset2,mDataset3,mDataset4,mDataset5);
        // Set CustomAdapter as the adapter for RecyclerView.
        pertanianRecyclerView.setAdapter(pertanianAdapter);
        peternakanRecyclerView.setAdapter(peternakanAdapter);
        kerajinanRecyclerView.setAdapter(kerajinanAdapter);
        // END_INCLUDE(initializeRecyclerView)

        return rootView;
    }

    /**
     * Set RecyclerView's LayoutManager to the one given.
     *
     * @param layoutManagerType Type of layout manager to switch to.
     */
    public void setRecyclerViewLayoutManager(LayoutManagerType layoutManagerType) {
        int scrollPositionPertanian = 0;
        int scrollPositionPeternakan = 0;
        int scrollPositionKerajinan = 0;

        // If a layout manager has already been set, get current scroll position.
        if (pertanianRecyclerView.getLayoutManager() != null) {
            scrollPositionPertanian = ((LinearLayoutManager) pertanianRecyclerView.getLayoutManager())
                    .findFirstCompletelyVisibleItemPosition();
        }

        if (peternakanRecyclerView.getLayoutManager() != null) {
            scrollPositionPeternakan = ((LinearLayoutManager) peternakanRecyclerView.getLayoutManager())
                    .findFirstCompletelyVisibleItemPosition();
        }

        if (kerajinanRecyclerView.getLayoutManager() != null) {
            scrollPositionKerajinan = ((LinearLayoutManager) kerajinanRecyclerView.getLayoutManager())
                    .findFirstCompletelyVisibleItemPosition();
        }

        switch (layoutManagerType) {
            case GRID_LAYOUT_MANAGER:
                pertanianLayoutManager = new GridLayoutManager(getActivity(), SPAN_COUNT);
                peternakanLayoutManager = new GridLayoutManager(getActivity(), SPAN_COUNT);
                kerajinanLayoutManager = new GridLayoutManager(getActivity(), SPAN_COUNT);
                mCurrentLayoutManagerType = LayoutManagerType.GRID_LAYOUT_MANAGER;
                break;
            case LINEAR_LAYOUT_MANAGER:
                pertanianLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
                peternakanLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
                kerajinanLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
                mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
                break;
            default:
                pertanianLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
                peternakanLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
                kerajinanLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
                mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
        }

        pertanianRecyclerView.setLayoutManager(pertanianLayoutManager);
        peternakanRecyclerView.setLayoutManager(peternakanLayoutManager);
        kerajinanRecyclerView.setLayoutManager(kerajinanLayoutManager);

        pertanianRecyclerView.scrollToPosition(scrollPositionPertanian);
        peternakanRecyclerView.scrollToPosition(scrollPositionPeternakan);
        kerajinanRecyclerView.scrollToPosition(scrollPositionKerajinan);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save currently selected layout manager.
        savedInstanceState.putSerializable(KEY_LAYOUT_MANAGER, mCurrentLayoutManagerType);
        super.onSaveInstanceState(savedInstanceState);
    }
    /**
     * Generates Strings for RecyclerView's adapter. This data would usually come
     * from a local content provider or remote server.
     */
    private void initDataset() {
        mDataset = new String[namaProduk.length];
        mDataset2 = new String[harga.length];
        mDataset3 = new String[lokasi.length];
        mDataset4 = new String[grosir.length];
        mDataset5 = new int[fotoProduk.length];
        for (int i = 0; i < namaProduk.length; i++) {
            mDataset[i] = namaProduk[i];
            mDataset2[i] = harga[i];
            mDataset3[i] = lokasi[i];
            mDataset4[i] = grosir[i];
            mDataset5[i] = fotoProduk[i];
        }
    }
}
