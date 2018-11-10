package example.com.presentation.di.components;


import dagger.Subcomponent;
import example.com.presentation.di.annotations.PerActivity;
import example.com.presentation.di.modules.ActivityModule;
import example.com.presentation.ui.main.MainActivity;
import example.com.presentation.ui.main.MainFragment;

/**
 * Created by Mohammad Jafarzadeh Rezvan on 09/11/2018.
 */
@PerActivity
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity activity);
    void inject(MainFragment mainFragment);
}
