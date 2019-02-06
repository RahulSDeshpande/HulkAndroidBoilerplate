package example.com.presentation.ui.main

import example.com.presentation.di.ConfigPersistent
import javax.inject.Inject

import example.com.presentation.mapper.GitRepositoryModelMapper
import example.com.presentation.ui.base.BasePresenter
import hulkdx.com.domain.interactor.GetGithubRepositoryList
import io.reactivex.functions.Consumer

/**
 * Created by Mohammad Jafarzadeh Rezvan on 10/11/2018.
 */
@ConfigPersistent
class MainPresenter @Inject constructor(
        private val mGetGithubRepositoryList: GetGithubRepositoryList,
        private val mGitRepositoryModelMapper: GitRepositoryModelMapper

): MainContract.Presenter<MainContract.View>, BasePresenter<MainContract.View>() {

    override fun detach() {
        super.detach()
        mGetGithubRepositoryList.dispose()
    }

    fun loadData() {
        mGetGithubRepositoryList.execute(
                Consumer { gitHubRepositories ->
                    view?.githubRepositoriesLoaded(
                            mGitRepositoryModelMapper.convert(gitHubRepositories))
                },
                Consumer { throwable ->
                    view?.githubRepositoriesFailed(throwable)
                })
    }
}
