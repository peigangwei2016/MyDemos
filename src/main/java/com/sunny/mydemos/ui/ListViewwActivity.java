package com.sunny.mydemos.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.sunny.mydemos.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/9/11.
 */
public class ListViewwActivity extends Activity {
    private android.widget.ListView listView;
    private android.widget.EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_containers);
        this.editText2 = (EditText) findViewById(R.id.editText2);
        this.listView = (ListView) findViewById(R.id.listView);
        showListView();


    }

    /**
     * 显示ListView
     */
    private void showListView() {
        //        准备数据源
        final ArrayList<String> list = new ArrayList<String>();

//        建立Adapter并且和数据源绑定
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);

//        将Adapter和UI绑定
        listView.setAdapter(adapter);
//        给ListView添加数据
        editText2.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                String value = editText2.getText().toString();
                editText2.setText(null);
                adapter.add(value);
//                list.add(value);
//                    listView.setAdapter(adapter);
//                adapter.notifyDataSetChanged();
                return false;
            }
        });

//        点击删除ListView中的数据
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                list.remove(position);
//                adapter.notifyDataSetChanged();
                adapter.remove(list.get(position));
            }
        });

//        editText2.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_UP){
//                    String value = editText2.getText().toString();
//                    editText2.setText("");
//                    list.add(value);
////                    listView.setAdapter(adapter);
//                    adapter.notifyDataSetChanged();
//                }
//                return false;
//            }
//        });
    }

}
