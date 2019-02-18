package com.bw.luwenjie0218.model.utils;

import android.os.Handler;
import android.os.Message;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @Auther: 努力
 * @Date: 2019/2/18 08:49:${卢文杰}
 * @Description:
 */
public class HttpUtils<T> {

    private static HttpUtils httpUtils;

    private HttpUtils() {
    }

    public static HttpUtils getInstance() {
        if (httpUtils == null) {
            httpUtils = new HttpUtils();
            return httpUtils;
        } else {
            return httpUtils;
        }
    }

    public void getData(String path, final Class<T> tClass) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request.Builder builder = new Request.Builder();
        Request request = builder.url(path).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callBackData.onErr(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson = new Gson();
                T t = gson.fromJson(string, tClass);
                Message message = handler.obtainMessage();
                message.obj = t;
                handler.sendMessage(message);
            }
        });
    }

    private CallBackData callBackData;

    public void setCallBackData(CallBackData callBackData) {
        this.callBackData = callBackData;
    }

    public interface CallBackData<D> {
        void onSuccess(D t);

        void onErr(Exception e);
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            T t = (T) msg.obj;
            callBackData.onSuccess(t);
        }
    };

}
