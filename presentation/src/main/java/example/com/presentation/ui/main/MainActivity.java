package example.com.presentation.ui.main;

import example.com.presentation.R;
import example.com.presentation.ui.base.BaseActivity;
import timber.log.Timber;

import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            addFragment(R.id.fragmentContainer, new MainFragment());
        }
    }
}
