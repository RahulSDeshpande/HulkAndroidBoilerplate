package example.com.presentation.di.components


import dagger.Subcomponent
import example.com.presentation.di.PerActivity
import example.com.presentation.di.modules.ActivityModule
import example.com.presentation.ui.main.MainActivity
import example.com.presentation.ui.main.MainFragment

/**
 * Created by Mohammad Jafarzadeh Rezvan on 09/11/2018.
 */
@PerActivity
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(activity: MainActivity)
    fun inject(mainFragment: MainFragment)
}
