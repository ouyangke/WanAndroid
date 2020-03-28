package com.oyke.wanandroid.net;


import com.oyke.wanandroid.net.cookie.CookieJarImpl;
import com.oyke.wanandroid.net.cookie.store.PersistentCookieStore;
import com.oyke.wanandroid.net.interceptor.CacheInterceptor;
import com.oyke.wanandroid.net.interceptor.HeaderInterceptor;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author oyke
 * @date 2019/12/12
 */
public class RetrofitClient {
    public static final String TAG = "RetrofitClient";
    private static final int DEFAULT_TIMEOUT = 30;
    private static volatile RetrofitClient sRetrofitClient;

    public static RetrofitClient getInstance() {
        if (sRetrofitClient == null) {
            synchronized (RetrofitClient.class) {
                if (sRetrofitClient == null) {
                    sRetrofitClient = new RetrofitClient();
                }
            }
        }
        return sRetrofitClient;
    }

    private RetrofitClient() {
    }

    private Map<String, String> getHeads() {
        return null;
    }


    private HttpLoggingInterceptor getHttpLoggingInterceptor() {
        // Log信息拦截器
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        //设置日志打印级别
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return loggingInterceptor;
    }

    private OkHttpClient getOkHttpClient() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .cookieJar(new CookieJarImpl(new PersistentCookieStore()))
                .addInterceptor(new HeaderInterceptor(getHeads()))
                .addInterceptor(new CacheInterceptor())
                .addInterceptor(getHttpLoggingInterceptor())
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .connectionPool(new ConnectionPool())
                .build();
        return okHttpClient;
    }

    private Retrofit.Builder getBuilder(String apiUrl) {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(apiUrl);
        builder.addConverterFactory(GsonConverterFactory.create());
        builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());
        builder.client(getOkHttpClient());
        return builder;
    }

    public <T> T create(final Class<T> service, String url) {
        if (service == null) {
            throw new RuntimeException("Api service is null!");
        }
        return getBuilder(url).build().create(service);
    }
}
