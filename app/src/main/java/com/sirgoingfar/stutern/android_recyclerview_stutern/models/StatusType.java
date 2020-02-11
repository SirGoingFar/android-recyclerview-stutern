package com.sirgoingfar.stutern.android_recyclerview_stutern.models;

public enum  StatusType {

    TEXT(30), IMAGE(20), AUDIO(30), VIDEO(30);

    private int maxDuration;

    //Add other properties

    StatusType(int maxDuration) {
        this.maxDuration = maxDuration;
    }

    public int getMaxDuration() {
        return maxDuration;
    }
}
