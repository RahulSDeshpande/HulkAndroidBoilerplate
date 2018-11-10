/**
 * Created by Mohammad Jafarzadeh Rezvan on 7/6/2017.
 */

package example.com.presentation.di.components;

import dagger.Component;
import example.com.presentation.di.annotations.ConfigPersistent;
import example.com.presentation.di.modules.ActivityModule;

/**
 * Created by Mohammad Jafarzadeh Rezvan on 09/11/2018.
 */

@ConfigPersistent
@Component(dependencies = ApplicationComponent.class)
public interface ConfigPersistentComponent {

    ActivityComponent activityComponent(ActivityModule activityModule);

}