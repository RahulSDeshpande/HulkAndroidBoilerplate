package example.com.presentation.ui.base;

/**
 * Created by Mohammad Jafarzadeh Rezvan on 09/11/2018.
 */
public interface IPresenter<T extends IView> {
    void attach(T view);
    void detach();
    void destroy();
}
