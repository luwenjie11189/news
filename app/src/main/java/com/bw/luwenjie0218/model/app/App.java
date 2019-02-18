package com.bw.luwenjie0218.model.app;

import android.app.Application;
import android.graphics.Bitmap;
import android.os.Environment;

import com.bw.luwenjie0218.R;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;

import java.io.File;

/**
 * @Auther: 努力
 * @Date: 2019/2/18 09:31:${卢文杰}
 * @Description:
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        String path = Environment.getExternalStorageDirectory().getPath() + "/RiKao15";
        File file = new File(path);
        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(this)
                .memoryCacheExtraOptions(200, 200)
                .memoryCacheSize(2 * 1024 * 1024)
                .threadPoolSize(3)
                .threadPriority(1000)
                .diskCache(new UnlimitedDiskCache(file))
                .diskCacheFileCount(50)
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                .diskCacheSize(50 * 1024 * 1024)
                .build();

        ImageLoader imageLoader = ImageLoader.getInstance();
        ImageLoader.getInstance().init(configuration);
    }

    public static DisplayImageOptions displayImageOptions() {
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.mipmap.zhan)
                .showImageForEmptyUri(R.mipmap.zhaobudao)
                .showImageOnFail(R.mipmap.shibai)
                .displayer(new SimpleBitmapDisplayer())
                .bitmapConfig(Bitmap.Config.ARGB_8888)
                .build();
        return options;
    }

}
