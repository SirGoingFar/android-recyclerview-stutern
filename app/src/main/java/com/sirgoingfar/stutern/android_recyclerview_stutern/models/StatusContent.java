package com.sirgoingfar.stutern.android_recyclerview_stutern.models;

public class StatusContent {

    private String caption;
    private String mediaUrl;
    private int viewCount;
    private boolean isDownloadable;
    private StatusType type;

    public StatusContent(String caption, String mediaUrl, int viewCount, boolean isDownloadable, StatusType type) {
        this.caption = caption;
        this.mediaUrl = mediaUrl;
        this.viewCount = viewCount;
        this.isDownloadable = isDownloadable;
        this.type = type;
    }

    public String getCaption() {
        return caption;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public int getViewCount() {
        return viewCount;
    }

    public boolean isDownloadable() {
        return isDownloadable;
    }

    public StatusType getType() {
        return type;
    }
}
