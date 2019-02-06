package example.com.presentation.ui.main

import example.com.presentation.models.GithubRepositoryModel
import example.com.presentation.ui.base.BaseContract

/**
 * Created by Mohammad Jafarzadeh Rezvan on 10/11/2018.
 */
interface MainContract {

    interface View : BaseContract.View {
        fun githubRepositoriesLoaded(githubRepositoryModels: List<GithubRepositoryModel>)
        fun githubRepositoriesFailed(t: Throwable)
    }

    interface Presenter<T: View>: BaseContract.Presenter<T>
}
