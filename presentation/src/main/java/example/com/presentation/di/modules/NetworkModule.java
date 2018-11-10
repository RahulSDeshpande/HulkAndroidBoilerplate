package example.com.presentation.di.modules;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import example.com.presentation.di.annotations.ApplicationContext;
import example.com.presentation.executor.UiThread;
import hulkdx.com.data.executor.CustomThreadExecutor;
import hulkdx.com.data.executor.PostExecutionThread;
import hulkdx.com.data.executor.ThreadExecutor;
import hulkdx.com.data.remote.RemoteService;
import hulkdx.com.data.repository.GithubRepoRepository;
import hulkdx.com.data.repository.GithubRepoRepositoryImpl;

/**
 * Created by Mohammad Jafarzadeh Rezvan on 09/11/2018.
 */
@Module
public class NetworkModule {

    @Provides
    @Singleton
    RemoteService provideRemoteService() {
        return RemoteService.Factory.create();
    }
}
