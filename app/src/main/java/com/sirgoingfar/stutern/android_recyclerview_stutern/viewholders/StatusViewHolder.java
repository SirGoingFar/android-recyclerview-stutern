package com.sirgoingfar.stutern.android_recyclerview_stutern.viewholders;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.sirgoingfar.stutern.android_recyclerview_stutern.R;
import com.sirgoingfar.stutern.android_recyclerview_stutern.models.Status;
import com.sirgoingfar.stutern.android_recyclerview_stutern.models.StatusViewType;

public class StatusViewHolder extends RecyclerView.ViewHolder {

    private Context context;

    private StatusViewType viewType;

    private TextView tvName;
    private TextView tvCreatedAt;
    private ImageView ivMore;
    private ImageView ivAvatar;

    private TextView tvHeader;
    private ImageView ivCollapse;

    public StatusViewHolder(@NonNull View itemView, StatusViewType viewType) {
        super(itemView);

        this.context = itemView.getContext();
        this.viewType = viewType;

        if (viewType == StatusViewType.STATUS || viewType == StatusViewType.USER_STATUS) {
            tvName = itemView.findViewById(R.id.tv_contact_name);
            tvCreatedAt = itemView.findViewById(R.id.tv_created_at);
            ivMore = itemView.findViewById(R.id.iv_more);
            ivAvatar = itemView.findViewById(R.id.civ_avatar);
        } else {
            tvHeader = itemView.findViewById(R.id.tv_header_label);
            ivCollapse = itemView.findViewById(R.id.iv_collapse);
        }
    }

    public void bindData(Status status) {

        if (viewType == StatusViewType.USER_STATUS) {
            tvName.setText(status.getContactName());
            tvCreatedAt.setText(status.getCreatedAt());
            ivMore.setVisibility(View.VISIBLE);
            ivAvatar.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_person));
        } else if (viewType == StatusViewType.STATUS) {
            ivAvatar.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_person));
            tvName.setText(status.getContactName());
            tvCreatedAt.setText(status.getCreatedAt());
            ivMore.setVisibility(View.GONE);
        } else if (viewType == StatusViewType.RECENT_UPDATE || viewType == StatusViewType.VIEWED_UPDATES) {
            tvHeader.setText(viewType.getTextLabel());
            ivCollapse.setVisibility(View.GONE);
        } else if (viewType == StatusViewType.MUTED_UPDATES) {
            tvHeader.setText(viewType.getTextLabel());
            ivCollapse.setVisibility(View.VISIBLE);
        }

    }

}
