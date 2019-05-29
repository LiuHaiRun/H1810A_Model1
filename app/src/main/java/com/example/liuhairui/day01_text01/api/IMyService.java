package com.example.liuhairui.day01_text01.api;

import com.example.liuhairui.day01_text01.bean.MainData;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IMyService {

    //  http://www.wanandroid.com/project/list/1/json?cid=294

    public  String url = " http://www.wanandroid.com/";

    @GET("project/list/1/json?")
    Observable<MainData> getData(@Query("cid") int cid);

}
