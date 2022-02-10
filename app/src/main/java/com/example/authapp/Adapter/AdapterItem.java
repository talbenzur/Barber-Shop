package com.example.authapp.Adapter;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.authapp.R;
import com.example.authapp.activities.dataUser;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

@RequiresApi(api = Build.VERSION_CODES.N)
public class AdapterItem extends RecyclerView.Adapter<AdapterItem.ItemViewHolder> {
    Context context;
    ArrayList<dataUser> dataUserArrayList;
    Locale id = new Locale("in","ID");
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMMM-yyyy",id);

    public AdapterItem(Context context, ArrayList<dataUser> dataUserArrayList) {
        this.context = context;
        this.dataUserArrayList = dataUserArrayList;
    }

    @NonNull
    @Override
    public AdapterItem.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterItem.ItemViewHolder holder, int position) {
        holder.viewBind(dataUserArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataUserArrayList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView tv_nama,
                tv_jk,
                tv_jurusan,
                tv_tanggal_pendaftaran;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_nama = itemView.findViewById(R.id.tv_name);
            tv_jk = itemView.findViewById(R.id.tv_gender);
            tv_jurusan = itemView.findViewById(R.id.tv_city);
            tv_tanggal_pendaftaran = itemView.findViewById(R.id.tv_date);
        }

        public void viewBind(dataUser dataUser) {
            tv_nama.setText(dataUser.getName());
            tv_jk.setText(dataUser.getGender());
            tv_jurusan.setText(dataUser.getCity());
            tv_tanggal_pendaftaran.setText(simpleDateFormat.format(dataUser.getDate()));
        }
    }
}
