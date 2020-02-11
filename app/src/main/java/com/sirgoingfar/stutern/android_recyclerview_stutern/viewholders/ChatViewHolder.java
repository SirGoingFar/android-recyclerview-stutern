package com.sirgoingfar.stutern.android_recyclerview_stutern.viewholders;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.sirgoingfar.stutern.android_recyclerview_stutern.R;
import com.sirgoingfar.stutern.android_recyclerview_stutern.models.Chat;
import com.sirgoingfar.stutern.android_recyclerview_stutern.models.MessageType;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChatViewHolder extends RecyclerView.ViewHolder {

    private Context context;

    private TextView name;
    private TextView msg;
    private TextView count;
    private TextView time;
    private CircleImageView avatar;

    private Animation animation = null;

    public ChatViewHolder(@NonNull View itemView) {
        super(itemView);

        context = itemView.getContext();

        name = itemView.findViewById(R.id.tv_contact_name);
        msg = itemView.findViewById(R.id.tv_msg_preview);
        count = itemView.findViewById(R.id.tv_msg_count);
        time = itemView.findViewById(R.id.tv_time);
        avatar = itemView.findViewById(R.id.civ_avatar);
    }

    public void bindData(Chat chat) {

        name.setText(chat.getContactName());
        msg.setText(chat.getMessage());
        time.setText(chat.getTime());

        if (chat.isRead()) {
            count.setVisibility(View.GONE);
            time.setTextColor(ContextCompat.getColor(context, android.R.color.tab_indicator_text));
        } else {
            count.setVisibility(View.VISIBLE);
            count.setText(String.valueOf(chat.getMsgCount()));
            time.setTextColor(ContextCompat.getColor(context, R.color.colorAccent));
        }

        if (chat.getMsgType() == MessageType.TEXT) {
            msg.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        } else {
            msg.setCompoundDrawablesWithIntrinsicBounds(chat.getMsgType().getIconId(), 0, 0, 0);
        }

        if (chat.getContactAvatarUrl() == null || chat.getContactAvatarUrl().isEmpty())
            if (chat.isGroup())
                avatar.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_group));
            else
                avatar.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_person));
        else
            Picasso.get().load(chat.getContactAvatarUrl())
                    .error(chat.isGroup() ? R.drawable.ic_group : R.drawable.ic_person)
                    .placeholder(chat.isGroup() ? R.drawable.ic_group : R.drawable.ic_person)
                    .networkPolicy(NetworkPolicy.OFFLINE).into(avatar);

        //Set Animation
        setAnimation(itemView);
    }

    public void setAnimation(View viewToAnimate) {

        if(animation == null)
        animation = AnimationUtils.loadAnimation(context, android.R.anim
                .slide_in_left);

        viewToAnimate.startAnimation(animation);
    }

}
