package com.bw.luwenjie0218.presenter;

import com.bw.luwenjie0218.view.interfaces.IBaseView;

/**
 * @Auther: 努力
 * @Date: 2019/2/18 08:47:${卢文杰}
 * @Description:
 */
public class BasePresenter<V extends IBaseView> {

    private V view;

    public V getView(){
        return view;
    }

    public void setView(V view){
        this.view = view;
    }

    public void dettachView(){
        this.view = null;
    }

}
