package hulkdx.com.domain.interactor;

import java.util.Collection;

import javax.inject.Inject;
import javax.inject.Singleton;

import hulkdx.com.data.executor.PostExecutionThread;
import hulkdx.com.data.executor.ThreadExecutor;
import hulkdx.com.data.model.GitHubRepositoryEntity;
import hulkdx.com.data.repository.GithubRepoRepository;
import hulkdx.com.domain.mapper.GithubRepoMapper;
import hulkdx.com.domain.models.GitHubRepository;
import io.reactivex.Flowable;

/**
 * Created by Mohammad Jafarzadeh Rezvan on 10/11/2018.
 */
@Singleton
public class GetGihubRepositoryList extends UseCase.FlowableUseCase<Collection<GitHubRepository>> {

    private final GithubRepoRepository mRepository;

    @Inject
    public GetGihubRepositoryList(GithubRepoRepository repository,
                                  ThreadExecutor mThreadExecutor,
                                  PostExecutionThread mPostExecutionThread) {
        super(mThreadExecutor, mPostExecutionThread);
        mRepository = repository;
    }

    @Override
    Flowable<Collection<GitHubRepository>> createFlowable() {
        return mRepository.getGithubRepos().map(new GithubRepoMapper());
    }
}
