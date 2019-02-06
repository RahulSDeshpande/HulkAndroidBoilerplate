package example.com.presentation.di.modules

import android.app.Activity
import android.content.Context

import dagger.Module
import dagger.Provides
import example.com.presentation.di.ActivityContext

/**
 * Created by Mohammad Jafarzadeh Rezvan on 09/11/2018.
 */

@Module
class ActivityModule(private val mActivity: Activity) {

    @Provides
    fun provideActivity(): Activity = mActivity

    @Provides
    @ActivityContext
    fun providesContext(): Context = mActivity
}
