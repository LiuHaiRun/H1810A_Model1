package com.example.liuhairui.day01_text01.v;

import com.example.liuhairui.day01_text01.bean.MainData;

import java.util.List;

public interface IView {

    //成功
    void onSuccess(List<MainData.DataBean.DatasBean> list);
    //失败
    void onError(String mag);
}
