package example.com.presentation.ui.main;

import java.util.Collection;

import javax.inject.Inject;

import example.com.presentation.di.annotations.ConfigPersistent;
import example.com.presentation.mapper.GitRepositoryModelMapper;
import example.com.presentation.ui.base.BasePresenter;
import hulkdx.com.domain.interactor.GetGihubRepositoryList;
import hulkdx.com.domain.models.GitHubRepository;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import timber.log.Timber;

/**
 * Created by Mohammad Jafarzadeh Rezvan on 10/11/2018.
 */
@SuppressWarnings({"Convert2MethodRef", "CodeBlock2Expr"})
@ConfigPersistent
public class MainPresenter extends BasePresenter<MainContract.View> {

    private final GetGihubRepositoryList mGetGihubRepositoryList;

    @Inject
    public MainPresenter(GetGihubRepositoryList getGihubRepositoryList) {
        mGetGihubRepositoryList = getGihubRepositoryList;
    }

    @Override
    public void detach() {
        super.detach();
        mGetGihubRepositoryList.dispose();
    }

    public void loadData() {
            mGetGihubRepositoryList.execute(
                    gitHubRepositories -> {
                        getView().githubRepositoriesLoaded(GitRepositoryModelMapper.convert(gitHubRepositories));
                    },
                    throwable -> {
                        commonErrorHandling(throwable);
                        getView().githubRepositoriesFailed(throwable);
                    });
    }


    private void commonErrorHandling(Throwable throwable) {

    }

    private void commonSuccessHandling() {

    }
}
