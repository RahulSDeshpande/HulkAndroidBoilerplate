package hulkdx.com.data.repository;

import javax.inject.Inject;
import javax.inject.Singleton;

import hulkdx.com.data.model.GitHubRepositoryEntity;
import io.reactivex.Flowable;

/**
 * Created by Mohammad Jafarzadeh Rezvan on 10/11/2018.
 */

@Singleton
public class GithubRepoRepositoryImpl implements GithubRepoRepository {

    @Inject
    public GithubRepoRepositoryImpl() {
    }

    @Override
    public Flowable<GitHubRepositoryEntity> getGithubRepos() {
        return null;
    }
}
