package hulkdx.com.data.repository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import hulkdx.com.data.mapper.GithubRepoMapper;
import hulkdx.com.data.remote.RemoteService;
import hulkdx.com.domain.models.GitHubRepository;
import hulkdx.com.domain.repository.GithubRepoRepository;
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
    public Flowable<List<GitHubRepository>> getGithubRepos() {
        return mRemoteService.getRepos().map(new GithubRepoMapper());
    }
}
