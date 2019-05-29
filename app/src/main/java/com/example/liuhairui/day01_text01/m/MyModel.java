package com.example.liuhairui.day01_text01.m;

import com.example.liuhairui.day01_text01.api.IMyService;
import com.example.liuhairui.day01_text01.bean.MainData;
import com.example.liuhairui.day01_text01.callback.ICallBack;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyModel implements IModel {
    @Override
    public void getModelData(int cid, final ICallBack callBack) {
        //获取网络数据

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(IMyService.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        retrofit.create(IMyService.class)
                .getData(cid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MainData>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MainData mainData) {
                        //成功
                         if (callBack != null){
                             List<MainData.DataBean.DatasBean> datas = mainData.getData().getDatas();
                             callBack.onSuccess(datas);
                         }
                    }

                    @Override
                    public void onError(Throwable e) {
                        //失败
                        if (callBack != null){
                            callBack.onError(e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
