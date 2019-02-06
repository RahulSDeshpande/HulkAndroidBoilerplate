/**
 * Created by Mohammad Jafarzadeh Rezvan on 7/6/2017.
 */

package example.com.presentation.di.components

import dagger.Component
import example.com.presentation.di.ConfigPersistent
import example.com.presentation.di.modules.ActivityModule

/**
 * Created by Mohammad Jafarzadeh Rezvan on 09/11/2018.
 */

@ConfigPersistent
@Component(dependencies = [ApplicationComponent::class])
interface ConfigPersistentComponent {

    fun activityComponent(activityModule: ActivityModule): ActivityComponent

}