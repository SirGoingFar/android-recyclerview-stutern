package com.sirgoingfar.stutern.android_recyclerview_stutern.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sirgoingfar.stutern.android_recyclerview_stutern.R;
import com.sirgoingfar.stutern.android_recyclerview_stutern.models.Status;
import com.sirgoingfar.stutern.android_recyclerview_stutern.models.StatusData;
import com.sirgoingfar.stutern.android_recyclerview_stutern.models.StatusViewType;
import com.sirgoingfar.stutern.android_recyclerview_stutern.viewholders.StatusViewHolder;

import java.util.ArrayList;
import java.util.List;

public class StatusAdapter extends RecyclerView.Adapter<StatusViewHolder> {

    private StatusData statusData;

    private int recentUpdateHeaderPos = 0;
    private int viewedUpdateHeaderPos = 0;
    private int mutedUpdateHeaderPos = 0;

    private List<Status> allStatusUpdates = new ArrayList<>();

    public StatusAdapter(StatusData statusData) {
        this.statusData = statusData;
        setPositionIndex();
        prepareParentList();
    }

    @NonNull
    @Override
    public StatusViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View view = LayoutInflater.from(parent.getContext()).inflate(getPositionLayout(position), parent, false);
        return new StatusViewHolder(view, reduceToType(position));
    }

    @Override
    public void onBindViewHolder(@NonNull StatusViewHolder holder, int position) {
        holder.bindData(getStatusDataWith(holder.getAdapterPosition()));
    }

    @Override
    public int getItemCount() {
        return statusData.getSize();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    private void setPositionIndex() {
        recentUpdateHeaderPos = statusData.getUserStatusList().size();
        viewedUpdateHeaderPos = recentUpdateHeaderPos + statusData.getRecentStatusList().size();
        mutedUpdateHeaderPos = viewedUpdateHeaderPos + statusData.getViewedStatusList().size();
    }

    private StatusViewType reduceToType(@LayoutRes int position) {
        StatusViewType viewType = StatusViewType.STATUS;

        if (position == 0)
            viewType = StatusViewType.USER_STATUS;
        else if (position == recentUpdateHeaderPos)
            viewType = StatusViewType.RECENT_UPDATE;
        else if (position == viewedUpdateHeaderPos)
            viewType = StatusViewType.VIEWED_UPDATES;
        else if (position == mutedUpdateHeaderPos)
            viewType = StatusViewType.MUTED_UPDATES;

        return viewType;
    }

    private int getPositionLayout(int position) {
        @LayoutRes int itemViewLayout = R.layout.layout_status_item;

        if (position == recentUpdateHeaderPos ||
                position == viewedUpdateHeaderPos || position == mutedUpdateHeaderPos)
            itemViewLayout = R.layout.layout_status_divider;

        return itemViewLayout;
    }

    private Status getStatusDataWith(int position) {

        Status status = null;

        if (position != recentUpdateHeaderPos
                && position != viewedUpdateHeaderPos
                && position != mutedUpdateHeaderPos) {

            int statusPosition = position;

            if (position > recentUpdateHeaderPos)
                statusPosition = position - 1;
            else if (position > viewedUpdateHeaderPos)
                statusPosition = position - 2;
            else if (position > mutedUpdateHeaderPos)
                statusPosition = position - 3;

            status = allStatusUpdates.get(statusPosition);
        }

        return status;
    }

    private void prepareParentList() {
        allStatusUpdates.clear();

        allStatusUpdates.addAll(statusData.getUserStatusList());
        allStatusUpdates.addAll(statusData.getRecentStatusList());
        allStatusUpdates.addAll(statusData.getViewedStatusList());
        allStatusUpdates.addAll(statusData.getMutedStatusList());
    }
}
