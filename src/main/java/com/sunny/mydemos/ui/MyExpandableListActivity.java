package com.sunny.mydemos.ui;

import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.widget.SimpleExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/9/11.
 */
public class MyExpandableListActivity extends ExpandableListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        建立数据源

//组的数据
        List<Map<String, String>> groupData = new ArrayList<Map<String, String>>();
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "Home");
        groupData.add(map);
        map = new HashMap<String, String>();
        map.put("name", "Work");
        groupData.add(map);

        String[] groupFrom = {"name"};
        int[] groupTo = {android.R.id.text1};

        List<List<Map<String, String>>> chilidData = new ArrayList<List<Map<String, String>>>();
        List<Map<String, String>> items = new ArrayList<Map<String, String>>();
        map = new HashMap<String, String>();
        map.put("name", "Sunny");
        map.put("address", "ShangHai");
        items.add(map);
        map = new HashMap<String, String>();
        map.put("name", "Tom");
        map.put("address", "ShenZhen");
        items.add(map);

        chilidData.add(items);
        chilidData.add(items);
        chilidData.add(items);
        String[] childFrom = {"name", "address"};
        int[] childTO = {android.R.id.text1, android.R.id.text2};

//        建立Adapter绑定数据源
        SimpleExpandableListAdapter adapter = new SimpleExpandableListAdapter(this,
                groupData, android.R.layout.simple_expandable_list_item_1, groupFrom, groupTo,
                chilidData, android.R.layout.simple_expandable_list_item_2, childFrom, childTO);
//        设置Adapter
        setListAdapter(adapter);
    }
}
