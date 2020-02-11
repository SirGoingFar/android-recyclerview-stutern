package com.sirgoingfar.stutern.android_recyclerview_stutern.models;

import androidx.annotation.DrawableRes;

import com.sirgoingfar.stutern.android_recyclerview_stutern.R;

public enum MessageType {

    TEXT(0),
    IMAGE(R.drawable.ic_camera),
    AUDIO(R.drawable.ic_voice),
    VIDEO(R.drawable.ic_video);

    @DrawableRes
    private int iconId;

    MessageType(int iconId) {
        this.iconId = iconId;
    }

    public int getIconId() {
        return iconId;
    }

}
