package example.com.presentation.ui.main;

import javax.inject.Inject;

import example.com.presentation.di.annotations.ConfigPersistent;
import example.com.presentation.ui.base.BasePresenter;

/**
 * Created by Mohammad Jafarzadeh Rezvan on 10/11/2018.
 */
@ConfigPersistent
public class MainPresenter extends BasePresenter<MainContract.View> {

    @Inject
    public MainPresenter() {
    }

    @Override
    public void detach() {
        super.detach();
    }

    public void loadData() {

    }
}
