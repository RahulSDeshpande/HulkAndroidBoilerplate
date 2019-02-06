package hulkdx.com.domain.interactor;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import hulkdx.com.domain.executor.PostExecutionThread;
import hulkdx.com.domain.executor.ThreadExecutor;
import hulkdx.com.domain.models.GitHubRepository;
import hulkdx.com.domain.repository.GithubRepoRepository;
import io.reactivex.Flowable;

/**
 * Created by Mohammad Jafarzadeh Rezvan on 10/11/2018.
 */
@Singleton
public class GetGithubRepositoryList extends UseCase.FlowableUseCase<List<GitHubRepository>> {

    private final GithubRepoRepository mRepository;

    @Inject
    public GetGithubRepositoryList(GithubRepoRepository repository,
                                   ThreadExecutor mThreadExecutor,
                                   PostExecutionThread mPostExecutionThread) {
        super(mThreadExecutor, mPostExecutionThread);
        mRepository = repository;
    }

    @Override
    Flowable<List<GitHubRepository>> createFlowable() {
        return mRepository.getGithubRepos();
    }
}
