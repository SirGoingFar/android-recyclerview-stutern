package com.sirgoingfar.stutern.android_recyclerview_stutern.models;

import java.util.List;

public class Status {

    private String contactName;
    private String createdAt;
    private boolean hasExpired;
    private boolean isUserStatus;
    private List<StatusContent> statusContents;

    public Status(String contactName, String createdAt, boolean hasExpired, boolean isUserStatus, List<StatusContent> statusContents) {
        this.contactName = contactName;
        this.createdAt = createdAt;
        this.hasExpired = hasExpired;
        this.isUserStatus = isUserStatus;
        this.statusContents = statusContents;
    }

    public String getContactName() {
        return contactName;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public boolean isHasExpired() {
        return hasExpired;
    }

    public boolean isUserStatus() {
        return isUserStatus;
    }

    public List<StatusContent> getStatusContents() {
        return statusContents;
    }

}
