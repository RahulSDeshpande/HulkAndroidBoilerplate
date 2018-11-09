package example.com.presentation.di.components;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import example.com.presentation.di.annotations.ApplicationContext;
import example.com.presentation.di.modules.ApplicationModule;

/**
 * Created by Mohammad Jafarzadeh Rezvan on 09/11/2018.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    @ApplicationContext Context context();
    Application application();
}
