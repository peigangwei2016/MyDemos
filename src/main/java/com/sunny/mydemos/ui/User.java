package com.sunny.mydemos.ui;

/**
 * Created by Administrator on 2016/9/9.
 */
public class User {
    private int mIconId;

    private String mName;

    private String mAddress;

    public int getIconId() {
        return mIconId;
    }

    public void setIconId(int mIconId) {
        this.mIconId = mIconId;
    }

    public User(String mName, String mAddress) {
        this.mName = mName;
        this.mAddress = mAddress;
    }

    public User(int iconId,String mName, String mAddress) {
        this.mIconId=iconId;
        this.mName = mName;
        this.mAddress = mAddress;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }


    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String mAddress) {
        this.mAddress = mAddress;
    }

}
