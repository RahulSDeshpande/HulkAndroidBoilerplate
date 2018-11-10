package example.com.presentation;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;

import example.com.presentation.di.components.ApplicationComponent;
import example.com.presentation.di.components.DaggerApplicationComponent;
import example.com.presentation.di.modules.ApplicationModule;
import timber.log.Timber;

/**
 * Created by Mohammad Jafarzadeh Rezvan on 09/11/2018.
 */
public class MyApplication extends Application {

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initDagger();
        initLeakDetection();
        initTimberLog();
    }

    private void initDagger() {
        mApplicationComponent =
                DaggerApplicationComponent.builder()
                                          .applicationModule(new ApplicationModule(this))
                                          .build();
    }

    private void initLeakDetection() {
        if (BuildConfig.DEBUG) {
            LeakCanary.install(this);
        }
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

    public static MyApplication get(Context context) {
        return (MyApplication) context.getApplicationContext();
    }

    private void initTimberLog() {
        // This will initialise Timber
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }
}
