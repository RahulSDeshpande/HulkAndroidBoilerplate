package example.com.presentation.ui.base;

import android.os.Build;

import androidx.appcompat.app.AppCompatActivity;
import example.com.presentation.MyApplication;
import example.com.presentation.di.components.ApplicationComponent;

/**
 * Created by Mohammad Jafarzadeh Rezvan on 09/11/2018.
 */
public abstract class BaseActivity extends AppCompatActivity {

    //---------------------------------------------------------------
    // Getters or Setters
    //---------------------------------------------------------------

    private ApplicationComponent getApplicationComponent() {
        return MyApplication.get(this).getApplicationComponent();
    }

    //---------------------------------------------------------------
    // Lifecycle
    //---------------------------------------------------------------

    // Update UI elements on this function:
    protected void onBindUI() {

    }

    // Stop updating UI elements on this function:
    protected void onUnbindUI() {

    }

    @Override
    protected void onStart() {
        super.onStart();
        onBindUI();
    }

    @Override
    protected void onStop() {
        super.onStop();
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
    }
}
