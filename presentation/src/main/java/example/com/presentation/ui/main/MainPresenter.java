package example.com.presentation.ui.main;

import javax.inject.Inject;

import example.com.presentation.di.annotations.ConfigPersistent;
import example.com.presentation.mapper.GitRepositoryModelMapper;
import example.com.presentation.ui.base.BasePresenter;
import hulkdx.com.domain.interactor.GetGithubRepositoryList;

/**
 * Created by Mohammad Jafarzadeh Rezvan on 10/11/2018.
 */
@SuppressWarnings({"Convert2MethodRef", "CodeBlock2Expr"})
@ConfigPersistent
public class MainPresenter extends BasePresenter<MainContract.View> {

    private final GetGithubRepositoryList mGetGithubRepositoryList;

    @Inject
    public MainPresenter(GetGithubRepositoryList getGithubRepositoryList) {
        mGetGithubRepositoryList = getGithubRepositoryList;
    }

    @Override
    public void detach() {
        super.detach();
        mGetGithubRepositoryList.dispose();
    }

    public void loadData() {
        mGetGithubRepositoryList.execute(
                gitHubRepositories -> {
                    getView().githubRepositoriesLoaded(GitRepositoryModelMapper.convert(gitHubRepositories));
                },
                throwable -> {
                    getView().githubRepositoriesFailed(throwable);
                });
    }
}
