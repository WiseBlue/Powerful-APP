package com.example.admin.bigdata.Activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.admin.bigdata.Fragment.SonFragment.ActivityFragment;
import com.example.admin.bigdata.Fragment.ParentFragment;
import com.example.admin.bigdata.Fragment.SonFragment.AnnounceFragment;
import com.example.admin.bigdata.Fragment.SonFragment.CommunicateFragment;
import com.example.admin.bigdata.Fragment.SonFragment.MyOwnFragment;
import com.example.admin.bigdata.Fragment.SonFragment.NewsFragment;
import com.example.admin.bigdata.R;
import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private SlidingTabLayout tabLayout;
    private ViewPager viewPager;
    private FragmentPagerAdapter adapter;
    private ArrayList<ParentFragment> fragments=new ArrayList<>();
    private String[] titles={"新闻","公告","活动","交流","我的"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initId();
        initView();
    }

    private void initView() {
        fragments.add(NewsFragment.getInstance());
        fragments.add(AnnounceFragment.getInstance());
        fragments.add(ActivityFragment.getInstance());
        fragments.add(CommunicateFragment.getInstance());
        fragments.add(MyOwnFragment.getInstance());

        adapter=new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        };

        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(5);

        tabLayout.setViewPager(viewPager,titles);
    }

    private void initId() {
        tabLayout= (SlidingTabLayout) findViewById(R.id.tablayout);
        viewPager= (ViewPager) findViewById(R.id.view_pager);

    }
}
