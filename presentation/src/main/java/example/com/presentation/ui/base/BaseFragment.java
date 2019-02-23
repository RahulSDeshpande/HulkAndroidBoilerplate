package example.com.presentation.ui.base;

import android.os.Bundle;
import android.view.View;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import example.com.presentation.di.components.ActivityComponent;
import example.com.presentation.ui.main.MainContract;
import example.com.presentation.ui.main.MainPresenter;

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
        // noinspection unchecked
        mPresenter.attach(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.detach();
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
