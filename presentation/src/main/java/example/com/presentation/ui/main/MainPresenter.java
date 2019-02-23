package example.com.presentation.ui.main;

import java.util.List;

import javax.inject.Inject;

import example.com.presentation.di.annotations.ConfigPersistent;
import example.com.presentation.mapper.GitRepositoryModelMapper;
import example.com.presentation.models.GithubRepositoryModel;
import example.com.presentation.ui.base.BasePresenter;
import example.com.presentation.util.PresenterCache;
import hulkdx.com.domain.interactor.GetGithubRepositoryList;

/**
 * Created by Mohammad Jafarzadeh Rezvan on 10/11/2018.
 */
@SuppressWarnings({"Convert2MethodRef", "CodeBlock2Expr"})
@ConfigPersistent
public class MainPresenter extends BasePresenter<MainContract.View> {

    private final GetGithubRepositoryList mGetGithubRepositoryList;

    @Inject
    public MainPresenter(PresenterCache presenterCache, GetGithubRepositoryList getGithubRepositoryList) {
        super(presenterCache);
        mGetGithubRepositoryList = getGithubRepositoryList;
    }

    @Override
    public void destroy() {
        super.destroy();
        mGetGithubRepositoryList.dispose();
    }

    public void loadData() {
        mGetGithubRepositoryList.execute(
                gitHubRepositories -> {
                    List<GithubRepositoryModel> data =
                            GitRepositoryModelMapper.convert(gitHubRepositories);

                    mPresenterCache.store(() -> {
                        getView().githubRepositoriesLoaded(data);
                    });
                },
                throwable -> {
                    mPresenterCache.store(() -> {
                        getView().githubRepositoriesFailed(throwable);
                    });
                });
    }
}
