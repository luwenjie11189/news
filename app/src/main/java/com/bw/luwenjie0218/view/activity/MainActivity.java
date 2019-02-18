package com.bw.luwenjie0218.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bw.luwenjie0218.R;
import com.bw.luwenjie0218.model.bean.NewsBean;
import com.bw.luwenjie0218.presenter.MainPresenter;
import com.bw.luwenjie0218.view.adapter.NewsAdapter;
import com.bw.luwenjie0218.view.interfaces.IMainView;

public class MainActivity extends AppCompatActivity implements IMainView {

    private RecyclerView recyclerView;
    private String path = "http://result.eolinker.com/iYXEPGn4e9c6dafce6e5cdd23287d2bb136ee7e9194d3e9?uri=one";
    private MainPresenter mainPresenter;
    private NewsAdapter newsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        loadDataFromNet();
    }

    private void initView() {
        recyclerView = findViewById(R.id.view);
    }

    private void initData() {
        mainPresenter = new MainPresenter();
        mainPresenter.setView(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(gridLayoutManager);
        newsAdapter = new NewsAdapter(this);
        recyclerView.setAdapter(newsAdapter);
    }

    private void loadDataFromNet() {
        mainPresenter.getHomeData(path);
    }

    @Override
    public void callBackData(NewsBean data) {
        newsAdapter.setData(data.getData());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.dettachView();
    }
}
