package com.oyke.baselibrary.base;

import android.app.Activity;
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;
import com.oyke.baselibrary.BuildConfig;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Description:     基类application
 * Author:         oyke
 * CreateDate:     2020/1/1 8:12
 */
public abstract class BaseApplication<AVM extends BaseViewModel> extends Application implements ViewModelStoreOwner {

    private ViewModelStore mAppViewModelStore;
    private ViewModelProvider.Factory mFactory;
    protected AVM mAppViewModel;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppViewModelStore = new ViewModelStore();

        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(false)  // (Optional) Whether to show thread info or not. Default true
                .methodCount(0)         // (Optional) How many method line to show. Default 2
                .methodOffset(7)        // (Optional) Hides internal method calls up to offset. Default 5
                .tag("WanAndroid")   // (Optional) Global tag for every log. Default PRETTY_LOGGER
                .build();

        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy){
            @Override
            public boolean isLoggable(int priority, @Nullable String tag) {
                return BuildConfig.DEBUG;
            }
        });

    }


    @NonNull
    @Override
    public ViewModelStore getViewModelStore() {
        return mAppViewModelStore;
    }

    public AVM getAppViewModel(Activity activity) {
        ViewModelProvider viewModelProvider = new ViewModelProvider((BaseApplication) activity.getApplicationContext(),
                ((BaseApplication) activity.getApplicationContext()).getAppFactory(activity));
        return (AVM) viewModelProvider.get(getAppViewModelClass());
    }

    private Class getAppViewModelClass() {
        Class modelClass = null;
        Type type = getClass().getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            modelClass = (Class) ((ParameterizedType) type).getActualTypeArguments()[0];
        }
        return modelClass;
    }

    private ViewModelProvider.Factory getAppFactory(Activity activity) {
        Application application = checkApplication(activity);
        if (mFactory == null) {
            mFactory = ViewModelProvider.AndroidViewModelFactory.getInstance(application);
        }
        return mFactory;
    }

    private Application checkApplication(Activity activity) {
        Application application = activity.getApplication();
        if (application == null) {
            throw new IllegalStateException("Your activity/fragment is not yet attached to "
                    + "Application. You can't request ViewModel before onCreate call.");
        }
        return application;
    }

    private Activity checkActivity(Fragment fragment) {
        Activity activity = fragment.getActivity();
        if (activity == null) {
            throw new IllegalStateException("Can't create ViewModelProvider for detached fragment");
        }
        return activity;
    }
}
