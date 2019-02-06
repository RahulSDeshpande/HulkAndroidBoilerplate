package example.com.presentation.di.modules;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import example.com.presentation.di.annotations.ApplicationContext;
import example.com.presentation.executor.UiThread;
import hulkdx.com.domain.executor.CustomThreadExecutor;
import hulkdx.com.domain.executor.PostExecutionThread;
import hulkdx.com.domain.executor.ThreadExecutor;
import hulkdx.com.domain.repository.GithubRepoRepository;
import hulkdx.com.data.repository.GithubRepoRepositoryImpl;

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

    @Provides
    PostExecutionThread providePostExecutionThread(UiThread uiThread) {
        return uiThread;
    }

    @Provides
    ThreadExecutor provideThreadExecutor(CustomThreadExecutor customThreadExecutor) {
        return customThreadExecutor;
    }

    @Provides
    GithubRepoRepository provideGithubRepoRepository(GithubRepoRepositoryImpl impl) {
        return impl;
    }
}
