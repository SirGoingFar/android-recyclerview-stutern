package com.sirgoingfar.stutern.android_recyclerview_stutern.models;

import com.sirgoingfar.stutern.android_recyclerview_stutern.utils.DataFactory;

import java.util.List;

public class StatusData {

    private List<Status> userStatusList = DataFactory.getUserStatusList();

    private List<Status> recentStatusList = DataFactory.getRecentStatusList();

    private List<Status> viewedStatusList = DataFactory.getViewedStatusList();

    private List<Status> mutedStatusList = DataFactory.getMutedStatusList();

    public List<Status> getUserStatusList() {
        return userStatusList;
    }

    public void setUserStatusList(List<Status> userStatusList) {
        this.userStatusList = userStatusList;
    }

    public List<Status> getRecentStatusList() {
        return recentStatusList;
    }

    public void setRecentStatusList(List<Status> recentStatusList) {
        this.recentStatusList = recentStatusList;
    }

    public List<Status> getViewedStatusList() {
        return viewedStatusList;
    }

    public void setViewedStatusList(List<Status> viewedStatusList) {
        this.viewedStatusList = viewedStatusList;
    }

    public List<Status> getMutedStatusList() {
        return mutedStatusList;
    }

    public void setMutedStatusList(List<Status> mutedStatusList) {
        this.mutedStatusList = mutedStatusList;
    }

    public int getSize() {
        return (userStatusList.size() + recentStatusList.size()
                + viewedStatusList.size() + mutedStatusList.size());
    }
}
