package com.bw.luwenjie0218.presenter;

import com.bw.luwenjie0218.model.bean.NewsBean;
import com.bw.luwenjie0218.model.utils.HttpUtils;
import com.bw.luwenjie0218.view.interfaces.IMainView;

/**
 * @Auther: 努力
 * @Date: 2019/2/18 08:48:${卢文杰}
 * @Description:
 */
public class MainPresenter extends BasePresenter<IMainView> implements HttpUtils.CallBackData<NewsBean> {

    private HttpUtils httpUtils;

    public MainPresenter() {
        httpUtils = HttpUtils.getInstance();
        httpUtils.setCallBackData(this);
    }

    public void getHomeData(String path) {
        httpUtils.getData(path, NewsBean.class);
    }

    @Override
    public void onSuccess(NewsBean t) {
        getView().callBackData(t);
    }

    @Override
    public void onErr(Exception e) {

    }


}
