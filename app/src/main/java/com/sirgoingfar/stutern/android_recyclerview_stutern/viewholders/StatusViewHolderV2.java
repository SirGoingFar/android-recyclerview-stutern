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

public class StatusViewHolderV2 extends RecyclerView.ViewHolder {

    private final Context context;

    private TextView tvName;
    private TextView tvCreatedAt;
    private ImageView ivMore;
    private ImageView ivAvatar;

    public StatusViewHolderV2(@NonNull View itemView) {
        super(itemView);

        this.context = itemView.getContext();
        tvName = itemView.findViewById(R.id.tv_contact_name);
        tvCreatedAt = itemView.findViewById(R.id.tv_created_at);
        ivMore = itemView.findViewById(R.id.iv_more);
        ivAvatar = itemView.findViewById(R.id.civ_avatar);
    }


    public void bindData(Status status) {
        ivAvatar.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_person));
        tvName.setText(status.getContactName());
        tvCreatedAt.setText(status.getCreatedAt());
        ivMore.setVisibility(View.GONE);
    }
}
