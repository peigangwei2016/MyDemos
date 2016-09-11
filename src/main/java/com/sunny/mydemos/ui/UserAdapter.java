package com.sunny.mydemos.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sunny.mydemos.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/9/9.
 */
public class UserAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<User> users;

    public UserAdapter(Context mContext, ArrayList<User> users) {
        this.mContext = mContext;
        this.users = users;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
         view = LayoutInflater.from(mContext).inflate(R.layout.spinner_item,null);
        User user = users.get(position);
        TextView nameView= (TextView) view.findViewById(R.id.name);
        TextView addressView= (TextView) view.findViewById(R.id.address);
        nameView.setText(user.getName());
        addressView.setText(user.getAddress());
        if (user.getIconId() != 0){
            Drawable icon = mContext.getResources().getDrawable(user.getIconId());
            icon.setBounds(0,0,icon.getIntrinsicWidth(),icon.getIntrinsicHeight());
            nameView.setCompoundDrawables(icon,null,null,null);

        }


        return view;
    }
}
