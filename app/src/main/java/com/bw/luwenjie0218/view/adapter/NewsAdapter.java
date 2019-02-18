package com.bw.luwenjie0218.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.luwenjie0218.R;
import com.bw.luwenjie0218.model.app.App;
import com.bw.luwenjie0218.model.bean.NewsBean;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

/**
 * @Auther: 努力
 * @Date: 2019/2/18 09:18:${卢文杰}
 * @Description:
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {

    private Context context;

    private ArrayList<NewsBean.DataBean> arrayList = new ArrayList<>();

    public NewsAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, null);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.textView.setText(arrayList.get(i).getTitle());
        DisplayImageOptions options = App.displayImageOptions();
        ImageLoader.getInstance().displayImage(arrayList.get(i).getImage_url(), myViewHolder.imageView, options);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public void setData(ArrayList<NewsBean.DataBean> data) {
        if (data != null) {
            arrayList.addAll(data);
            notifyDataSetChanged();
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imageView;
        private final TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.m1);
            textView = itemView.findViewById(R.id.t1);
        }
    }

}
