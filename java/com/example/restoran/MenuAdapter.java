package com.example.restoran;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MyViewHolder> {

    List<Menu> menuList;

    public MenuAdapter(List<Menu> menuList) {
        this.menuList = menuList;
    }

    @NonNull
    @Override
    public MenuAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View menuView = layoutInflater.inflate(R.layout.acitivty_layout, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(menuView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Menu menu = menuList.get(position);

        holder.judul.setText(menu.getNamaMenu());
        holder.deskripsi.setText(menu.getDeskripsiMenu());
        holder.harga.setText(String.valueOf(menu.getHargaMenu()));
    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView judul, deskripsi, harga;
        ImageView gambar;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            judul = itemView.findViewById(R.id.namaMenu);
            deskripsi = itemView.findViewById(R.id.deskripsi);
            harga = itemView.findViewById(R.id.harga);
            gambar = itemView.findViewById(R.id.imageMenu);
        }
    }
}
