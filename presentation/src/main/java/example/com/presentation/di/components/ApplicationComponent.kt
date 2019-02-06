package example.com.presentation.di.components


import android.app.Application
import android.content.Context
import javax.inject.Singleton

import dagger.Component
import example.com.presentation.di.ApplicationContext
import example.com.presentation.di.modules.ApplicationModule
import example.com.presentation.di.modules.NetworkModule
import example.com.presentation.mapper.GitRepositoryModelMapper
import hulkdx.com.domain.interactor.GetGithubRepositoryList

/**
 * Created by Mohammad Jafarzadeh Rezvan on 09/11/2018.
 */
@Singleton
@Component(modules = [ApplicationModule::class, NetworkModule::class])
interface ApplicationComponent {

    @ApplicationContext
    fun context(): Context

    fun application(): Application

    fun getGithubRepositoryList(): GetGithubRepositoryList
    fun GitRepositoryModelMapper(): GitRepositoryModelMapper
}
