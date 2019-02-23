package example.com.presentation.ui.base;

import example.com.presentation.util.PresenterCache;

/**
 * Created by Mohammad Jafarzadeh Rezvan on 09/11/2018.
 */
public abstract class BasePresenter<T extends IView> implements IPresenter<T> {

    protected final PresenterCache mPresenterCache;
    private T mView;

    public BasePresenter(PresenterCache presenterCache) {
        mPresenterCache = presenterCache;
    }

    @Override
    public void attach(T view) {
        mView = view;
        mPresenterCache.attach();
    }

    @Override
    public void detach() {
        mView = null;
        mPresenterCache.detach();
    }

    @Override
    public void destroy() {
        mPresenterCache.destroy();
    }

    public T getView() {
        return mView;
    }
}
