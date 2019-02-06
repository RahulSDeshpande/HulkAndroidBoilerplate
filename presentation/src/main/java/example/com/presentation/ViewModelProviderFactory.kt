package example.com.presentation

import javax.inject.Inject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import example.com.presentation.di.PerActivity
import example.com.presentation.ui.main.MainViewModel
import java.lang.RuntimeException

/**
 * Created by Mohammad Jafarzadeh Rezvan on 06/02/2019.
 */
@PerActivity
class ViewModelProviderFactory @Inject constructor() : ViewModelProvider.Factory {

    @Inject lateinit var mMainViewModel: MainViewModel

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass == MainViewModel::class.java) {
            return mMainViewModel as T
        }

        throw RuntimeException("Please add other ViewModels")
    }
}
