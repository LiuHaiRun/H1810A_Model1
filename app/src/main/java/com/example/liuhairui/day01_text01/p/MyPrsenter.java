package com.example.liuhairui.day01_text01.p;

import com.example.liuhairui.day01_text01.bean.MainData;
import com.example.liuhairui.day01_text01.callback.ICallBack;
import com.example.liuhairui.day01_text01.m.IModel;
import com.example.liuhairui.day01_text01.m.MyModel;
import com.example.liuhairui.day01_text01.v.IView;

import java.util.List;

public class MyPrsenter implements IPrsenter, ICallBack {

    private IModel mIModel;
    private IView mView;

    public MyPrsenter(IView view) {
        mIModel = new MyModel();
        mView = view;
    }

    @Override
    public void getPrsenterData(int cid) {
        //调用M层方法，传递数据
        mIModel.getModelData(cid,this);
    }

    @Override
    public void onSuccess(List<MainData.DataBean.DatasBean> list) {
        //成功将数据传递到主界面
        mView.onSuccess(list);
    }

    @Override
    public void onError(String mag) {
        //失败将原因到主界面
        mView.onError(mag);
    }
}
