package example.com.presentation.ui.main

import example.com.presentation.R
import example.com.presentation.ui.base.BaseActivity
import timber.log.Timber

import android.os.Bundle
import android.util.Log
import example.com.presentation.ViewModelProviderFactory

import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject lateinit var mViewModelProviderFactory: ViewModelProviderFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityComponent.inject(this)

        if (savedInstanceState == null) {
            addFragment(R.id.fragmentContainer, MainFragment())
        }
    }
}
