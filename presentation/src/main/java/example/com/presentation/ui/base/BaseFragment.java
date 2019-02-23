package example.com.presentation.ui.base;

import android.os.Bundle;
import android.view.View;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import example.com.presentation.di.components.ActivityComponent;

/**
 * Created by Mohammad Jafarzadeh Rezvan on 10/11/2018.
 */
public abstract class BaseFragment<PRESENTER extends BasePresenter, ACTIVITY extends BaseActivity>
        extends Fragment implements IView {

    @Inject protected PRESENTER mPresenter;

    public BaseFragment() {
        setRetainInstance(true);
    }

    //---------------------------------------------------------------
    // Lifecycle
    //---------------------------------------------------------------

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onStart() {
        super.onStart();
        // noinspection unchecked
        mPresenter.attach(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        mPresenter.detach();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        FragmentActivity activity = getActivity();
        boolean isChangingConfigurations = activity != null && activity.isChangingConfigurations();
        if (!isChangingConfigurations) mPresenter.destroy();
    }

    //---------------------------------------------------------------
    // Getters or Setters
    //---------------------------------------------------------------

    @NonNull
    @SuppressWarnings({"unchecked"})
    protected ACTIVITY getCastedActivity() {
        ACTIVITY activity = (ACTIVITY) this.getActivity();
        if (activity == null) {
            throw new RuntimeException("cannot cast activity");
        }
        return activity;
    }

    protected ActivityComponent getActivityComponent() {
        return getCastedActivity().getActivityComponent();
    }
}
