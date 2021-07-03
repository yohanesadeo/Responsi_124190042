package com.upnyk.covid.view.hospital;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.upnyk.covid.R;
import com.upnyk.covid.service.hospital.DataItem;

import java.util.List;

public class HospitalListAdapter extends RecyclerView.Adapter<HospitalListAdapter.ViewHolder> {

    private Context context;
    private List<DataItem> dataItems;

    public HospitalListAdapter(Context context, List<DataItem> dataItems) {
        this.context = context;
        this.dataItems = dataItems;
    }

    public void setDataItems(List<DataItem> dataItems) {
        this.dataItems = dataItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list_hospital, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HospitalListAdapter.ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return dataItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName, tvAddress;
        private Button btnMaps;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_list_item_hospital_name);
            tvAddress = itemView.findViewById(R.id.tv_list_item_hospital_address);
            btnMaps = itemView.findViewById(R.id.btn_maps);
        }

        public void bind(int position) {
            tvName.setText(dataItems.get(position).getNama());
            tvAddress.setText(dataItems.get(position).getAlamat());
            btnMaps.setOnClickListener(v -> {
                String address = String.format("geo: 0, 0?q= %s", dataItems.get(position).getNama());
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(address));
                intent.setPackage("com.google.android.apps.maps");
                context.startActivity(intent);
            });
        }
    }
}
