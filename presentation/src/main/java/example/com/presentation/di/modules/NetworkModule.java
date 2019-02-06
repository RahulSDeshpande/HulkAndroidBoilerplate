package example.com.presentation.di.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hulkdx.com.data.remote.RemoteService;

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
