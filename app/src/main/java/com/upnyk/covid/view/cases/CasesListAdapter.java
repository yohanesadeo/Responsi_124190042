package com.upnyk.covid.view.cases;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.upnyk.covid.R;
import com.upnyk.covid.service.cases.ContentItem;

import java.util.List;

public class CasesListAdapter extends RecyclerView.Adapter<CasesListAdapter.ViewHolder> {

    private Context context;
    private List<ContentItem> contentItems;

    public CasesListAdapter(Context context, List<ContentItem> contentItems) {
        this.context = context;
        this.contentItems = contentItems;
    }

    public void setContentItems(List<ContentItem> contentItems) {
        this.contentItems = contentItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_cases, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CasesListAdapter.ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return contentItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvDate, tvConfirmed, tvRecover, tvDied;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvDate = itemView.findViewById(R.id.tv_list_item_cases_date);
            tvConfirmed = itemView.findViewById(R.id.tv_list_item_cases_confirmed);
            tvRecover = itemView.findViewById(R.id.tv_list_item_cases_recover);
            tvDied = itemView.findViewById(R.id.tv_list_item_cases_died);

        }

        public void bind(int position) {
            tvDate.setText(contentItems.get(position).getTanggal());
            tvConfirmed.setText(String.valueOf(contentItems.get(position).getConfirmationDiisolasi()));
            tvRecover.setText(String.valueOf(contentItems.get(position).getConfirmationSelesai()));
            tvDied.setText(String.valueOf(contentItems.get(position).getConfirmationMeninggal()));

        }
    }
}
