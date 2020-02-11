package com.sirgoingfar.stutern.android_recyclerview_stutern.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sirgoingfar.stutern.android_recyclerview_stutern.R;
import com.sirgoingfar.stutern.android_recyclerview_stutern.models.Status;
import com.sirgoingfar.stutern.android_recyclerview_stutern.viewholders.StatusViewHolderV2;

import java.util.List;

public class StatusAdapterV2 extends RecyclerView.Adapter<StatusViewHolderV2> {

    private List<Status> statusList;

    public StatusAdapterV2(List<Status> statusList) {
        this.statusList = statusList;
    }

    @NonNull
    @Override
    public StatusViewHolderV2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_status_item, parent, false);
        return new StatusViewHolderV2(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StatusViewHolderV2 holder, int position) {
        holder.bindData(statusList.get(holder.getAdapterPosition()));
    }

    @Override
    public int getItemCount() {
        return statusList.size();
    }
}
