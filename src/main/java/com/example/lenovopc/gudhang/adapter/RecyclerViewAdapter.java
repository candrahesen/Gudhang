package com.example.lenovopc.gudhang.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovopc.gudhang.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

  /*  private static class DataViewHolder extends RecyclerViewAdapter.ViewHolder {
      //  private final 
        TextView nama, harga, lokasi, grosir;
      //  private final 
        ImageView fotoProduk;
      //  TextView txt_label;

        public DataViewHolder(View itemView) {
            super(itemView);

            nama = (TextView) itemView.findViewById(R.id.namaProduk);
            harga = (TextView) itemView.findViewById(R.id.harga);
            lokasi = (TextView) itemView.findViewById(R.id.lokasi);
            grosir = (TextView) itemView.findViewById(R.id.grosir);
            fotoProduk = (ImageView) itemView.findViewById(R.id.fotoProduk);
         //   txt_label = (TextView) itemView.findViewById(R.id.txt_label);
        }

    }*/

    private Activity activity;
    private List<AbstractItem> data;
 //   private String[] strings;

    public RecyclerViewAdapter(Activity activity, List<AbstractItem> data) {
        this.activity = activity;
        this.data = data;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        return data.get(position).getType();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.item_recycler_view, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        ListItem item = (ListItem) data.get(position);
        ViewHolder holder = (ViewHolder) viewHolder;
        
        holder.nama.setText(item.getNama());
        holder.harga.setText(item.getHarga());
        holder.lokasi.setText(item.getLokasi());
        holder.grosir.setText(item.getGrosir());
        holder.fotoProduk.setImageResource(item.getFotoProduk());
        
        //viewHolder.textView.setText(strings[position]);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nama, harga, lokasi, grosir;
        private ImageView fotoProduk;

        public ViewHolder(View view) {
            super(view);
            nama = (TextView) view.findViewById(R.id.namaProduk);
            harga = (TextView) view.findViewById(R.id.harga);
            lokasi = (TextView) view.findViewById(R.id.lokasi);
            grosir = (TextView) view.findViewById(R.id.grosir);
            fotoProduk = (ImageView) view.findViewById(R.id.fotoProduk);
           // textView = (TextView) view.findViewById(R.id.text);
        }
    }
}