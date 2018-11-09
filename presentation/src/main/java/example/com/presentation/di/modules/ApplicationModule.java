package example.com.presentation.di.modules;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import example.com.presentation.di.annotations.ApplicationContext;

/**
 * Created by Mohammad Jafarzadeh Rezvan on 09/11/2018.
 */
@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }
}
