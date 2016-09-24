package com.sunny.mydemos;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private android.support.v4.view.ViewPager viewPager;
    private PagerAdapter adapter;
//    创建数据源
    private int images[]={

        R.drawable.sample_0,
        R.drawable.sample_1,
        R.drawable.sample_2,
        R.drawable.sample_3,
        R.drawable.sample_4,
        R.drawable.sample_5,
        R.drawable.sample_6,
        R.drawable.sample_7
    };
    private List<ImageView> mImageList=new ArrayList<ImageView>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.viewPager = (ViewPager) findViewById(R.id.viewPager);
        initData();

        adapter=new PagerAdapter() {
            @Override
            public int getCount() {
                return images.length;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(mImageList.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(mImageList.get(position));
                return mImageList.get(position);
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }
        };

//        设置适配器
        viewPager.setAdapter(adapter);


    }

    private void initData() {
        for (int i = 0; i < images.length; i++) {
            ImageView imageView =new ImageView(MainActivity.this);
            imageView.setImageResource(images[i]);
            mImageList.add(imageView);
        }
    }
}
