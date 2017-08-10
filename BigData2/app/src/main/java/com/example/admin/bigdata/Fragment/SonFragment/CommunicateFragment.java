package com.example.admin.bigdata.Fragment.SonFragment;

import com.example.admin.bigdata.Fragment.ParentFragment;
import com.example.admin.bigdata.R;

/**
 * Created by admin on 2017/8/2.
 */

public class CommunicateFragment extends ParentFragment {
    @Override
    public int getLayoutID() {
        return R.layout.fragment_communicate;
    }

    @Override
    public void initView() {

    }

    public static CommunicateFragment getInstance() {
        CommunicateFragment mf=new CommunicateFragment();
        return mf;
    }
}
