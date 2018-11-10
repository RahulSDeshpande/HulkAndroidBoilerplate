package example.com.presentation.ui.base;

/**
 * Created by Mohammad Jafarzadeh Rezvan on 09/11/2018.
 */
public class BasePresenter<T extends IView> implements IPresenter<T> {

    private T mView;

    @Override
    public void attach(T view) {
        mView = view;
    }

    @Override
    public void detach() {
        mView = null;
    }

    protected boolean isViewAttached() {
        return mView != null;
    }

    public T getView() {
        return mView;
    }
}
