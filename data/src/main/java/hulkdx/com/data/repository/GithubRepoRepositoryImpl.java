package hulkdx.com.data.repository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import hulkdx.com.data.model.GitHubRepositoryEntity;
import hulkdx.com.data.remote.RemoteService;
import io.reactivex.Flowable;

/**
 * Created by Mohammad Jafarzadeh Rezvan on 10/11/2018.
 */

@Singleton
public class GithubRepoRepositoryImpl implements GithubRepoRepository {

    private final RemoteService mRemoteService;

    @Inject
    public GithubRepoRepositoryImpl(RemoteService remoteService) {
        mRemoteService = remoteService;
    }

    @Override
    public Flowable<List<GitHubRepositoryEntity>> getGithubRepos() {
        return mRemoteService.getRepos();
    }
}
