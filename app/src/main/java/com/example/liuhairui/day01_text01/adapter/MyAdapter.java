package com.example.liuhairui.day01_text01.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.liuhairui.day01_text01.R;
import com.example.liuhairui.day01_text01.bean.MainData;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

public class MyAdapter extends XRecyclerView.Adapter<MyAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<MainData.DataBean.DatasBean> mList;

    public MyAdapter(Context context, ArrayList<MainData.DataBean.DatasBean> list) {
        mContext = context;
        mList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //加载布局
        View view = View.inflate(mContext, R.layout.item_layout, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //加载数据
        MainData.DataBean.DatasBean datasBean = mList.get(position);
        //内容
        holder.tv.setText(datasBean.getTitle());
        //图片
        RequestOptions options = new RequestOptions()
                .transform(new RoundedCorners(20))//内置图片设置圆角
                .placeholder(R.mipmap.ic_launcher);//占位图
        Glide.with(mContext)
                .load(datasBean.getEnvelopePic())
                .apply(options)
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView tv;
        public ViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            tv = itemView.findViewById(R.id.tv);
        }
    }
}
