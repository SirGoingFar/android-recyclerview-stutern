package com.sirgoingfar.stutern.android_recyclerview_stutern.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Chat implements Parcelable {

    private String contactName;
    private String contactAvatarUrl;
    private String message;
    private int msgCount;
    private String time;
    private MessageType msgType = MessageType.TEXT;
    private boolean isRead;
    private boolean isGroup;

    public Chat(String contactName, String contactAvatarUrl, String message, int msgCount,
                String time, MessageType msgType, boolean isRead, boolean isGroup) {
        this.contactName = contactName;
        this.contactAvatarUrl = contactAvatarUrl;
        this.message = message;
        this.msgCount = msgCount;
        this.time = time;
        this.msgType = msgType;
        this.isRead = isRead;
        this.isGroup = isGroup;
    }

    protected Chat(Parcel in) {
        contactName = in.readString();
        contactAvatarUrl = in.readString();
        message = in.readString();
        msgCount = in.readInt();
        time = in.readString();
        isRead = in.readByte() != 0;
        isGroup = in.readByte() != 0;
        msgType = MessageType.values()[in.readInt()];
    }

    public static final Creator<Chat> CREATOR = new Creator<Chat>() {
        @Override
        public Chat createFromParcel(Parcel in) {
            return new Chat(in);
        }

        @Override
        public Chat[] newArray(int size) {
            return new Chat[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(contactName);
        dest.writeString(contactAvatarUrl);
        dest.writeString(message);
        dest.writeInt(msgCount);
        dest.writeString(time);
        dest.writeByte((byte) (isRead ? 1 : 0));
        dest.writeByte((byte) (isGroup ? 1 : 0));
        dest.writeInt(msgType.ordinal());
    }

    public void markAsRead() {
        isRead = true;
    }

    public String getContactName() {
        return contactName;
    }

    public String getContactAvatarUrl() {
        return contactAvatarUrl;
    }

    public String getMessage() {
        return message;
    }

    public int getMsgCount() {
        return msgCount;
    }

    public String getTime() {
        return time;
    }

    public MessageType getMsgType() {
        return msgType;
    }

    public boolean isRead() {
        return isRead;
    }

    public boolean isGroup() {
        return isGroup;
    }
}
