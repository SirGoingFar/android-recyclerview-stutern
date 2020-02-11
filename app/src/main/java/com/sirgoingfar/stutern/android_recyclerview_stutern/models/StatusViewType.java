package com.sirgoingfar.stutern.android_recyclerview_stutern.models;

public enum StatusViewType {

    STATUS("", false, false),
    USER_STATUS("", true, false),
    RECENT_UPDATE("Recent updates", false, false),
    VIEWED_UPDATES("Viewed updates", false, false),
    MUTED_UPDATES("Muted updates", false, true);

    private String textLabel;
    private boolean hasMoreOption;
    private boolean isCollapsible;

    StatusViewType(String textLabel, boolean hasMoreOption, boolean isCollapsible) {
        this.textLabel = textLabel;
        this.hasMoreOption = hasMoreOption;
        this.isCollapsible = isCollapsible;
    }

    public String getTextLabel() {
        return textLabel;
    }

    public boolean isHasMoreOption() {
        return hasMoreOption;
    }

    public boolean isCollapsible() {
        return isCollapsible;
    }

}
