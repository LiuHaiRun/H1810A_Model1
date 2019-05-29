package com.example.liuhairui.day01_text01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.example.liuhairui.day01_text01.adapter.MyAdapter;
import com.example.liuhairui.day01_text01.bean.MainData;
import com.example.liuhairui.day01_text01.p.MyPrsenter;
import com.example.liuhairui.day01_text01.v.IView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IView {


    private XRecyclerView mXrv;
    private ArrayList<MainData.DataBean.DatasBean> mList;
    private MyAdapter mAdapter;
    private static final String TAG = "MainActivity";
    private int cid = 294;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();

    }

    private void initData() {
        ///获取p层对象，调用P层方法获取数据
        MyPrsenter prsenter = new MyPrsenter(this);
        prsenter.getPrsenterData(cid);
    }

    private void initView() {
        mXrv = (XRecyclerView) findViewById(R.id.xrv);
        //容器
        mList = new ArrayList<>();
        //布局管理器
        mXrv.setLayoutManager(new LinearLayoutManager(this));
        //适配器
        mAdapter = new MyAdapter(this, mList);
        mXrv.setAdapter(mAdapter);
    }

    @Override
    public void onSuccess(List<MainData.DataBean.DatasBean> list) {
        //将数据添加到集合，刷新适配器
        mList.addAll(list);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onError(String mag) {
        //失败原因
        Log.d(TAG, "网络请求失败onError: "+mag);
    }
}
