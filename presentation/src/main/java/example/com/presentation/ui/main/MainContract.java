package example.com.presentation.ui.main;

import java.util.Collection;

import example.com.presentation.models.GithubRepositoryModel;
import example.com.presentation.ui.base.IView;

/**
 * Created by Mohammad Jafarzadeh Rezvan on 10/11/2018.
 */
public interface MainContract {

    interface View extends IView {
        void githubRepositoriesLoaded(Collection<GithubRepositoryModel> githubRepositoryModels);
        void githubRepositoriesFailed(Throwable t);
    }

}
