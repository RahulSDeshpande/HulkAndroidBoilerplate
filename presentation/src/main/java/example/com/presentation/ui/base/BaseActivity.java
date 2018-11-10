package example.com.presentation.ui.base;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.LongSparseArray;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import example.com.presentation.MyApplication;
import example.com.presentation.di.components.ActivityComponent;
import example.com.presentation.di.components.ApplicationComponent;
import example.com.presentation.di.components.ConfigPersistentComponent;
import example.com.presentation.di.components.DaggerConfigPersistentComponent;
import example.com.presentation.di.modules.ActivityModule;
import timber.log.Timber;

/**
 * Created by Mohammad Jafarzadeh Rezvan on 09/11/2018.
 */
public abstract class BaseActivity extends AppCompatActivity {

    private static final String ACTIVITY_ID = "ACTIVITY_ID";

    private ActivityComponent mActivityComponent;
    private static int                                        sActivityId    = 0;
    private static LongSparseArray<ConfigPersistentComponent> sComponentsMap = new LongSparseArray<>();

    //---------------------------------------------------------------
    // Lifecycle
    //---------------------------------------------------------------

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        createConfigPersistentActivityComponent(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        onBindUI();
    }

    @Override
    protected void onStop() {
        super.onStop();
        //
        // onStop is lazy on Nougat+
        // https://www.bignerdranch.com/blog/android-activity-lifecycle-onStop/
        //
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
            onUnbindUI();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.M) {
            onUnbindUI();
        }
        if (isFinishing()) {
            removeConfigPersistentComponent();
        }
    }

    @Override
    protected void onDestroy() {
        if (!isChangingConfigurations()) {
            removeConfigPersistentComponent();
        }
        super.onDestroy();
    }

    // Update UI elements on this function:
    protected void onBindUI() {}

    // Stop updating UI elements on this function:
    protected void onUnbindUI() {}

    //---------------------------------------------------------------
    // Config Persistent Component
    //---------------------------------------------------------------

    /**
     *  Create ActivityComponent that can survive a configuration using a static HashMap. (In memory)
     */
    private void createConfigPersistentActivityComponent(@Nullable Bundle savedInstanceState) {
        sActivityId = savedInstanceState == null ? sActivityId + 1
                                                 : savedInstanceState.getInt(ACTIVITY_ID);

        ConfigPersistentComponent configPersistentComponent = sComponentsMap.get(sActivityId, null);
        if (configPersistentComponent == null) {
            Timber.v("Creating new component");
            configPersistentComponent =
                    DaggerConfigPersistentComponent.builder()
                                                   .applicationComponent(getApplicationComponent())
                                                   .build();
            sComponentsMap.put(sActivityId, configPersistentComponent);
        }
        mActivityComponent = configPersistentComponent.activityComponent(new ActivityModule(this));
    }

    private void removeConfigPersistentComponent() {
        Timber.v("Clearing Component id=%d", sActivityId);
        sComponentsMap.remove(sActivityId);
    }

    //---------------------------------------------------------------
    // Fragments
    //---------------------------------------------------------------

    protected void addFragment(int containerViewId, Fragment fragment) {
        getSupportFragmentManager().beginTransaction().add(containerViewId, fragment).commit();
    }

    //---------------------------------------------------------------
    // Getters or Setters
    //---------------------------------------------------------------

    private ApplicationComponent getApplicationComponent() {
        return MyApplication.get(this).getApplicationComponent();
    }

    public ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }
}
