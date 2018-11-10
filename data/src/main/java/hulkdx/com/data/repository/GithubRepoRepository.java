package hulkdx.com.data.repository;

import java.util.List;

import hulkdx.com.data.model.GitHubRepositoryEntity;
import io.reactivex.Flowable;

/**
 * Created by Mohammad Jafarzadeh Rezvan on 10/11/2018.
 */
public interface GithubRepoRepository {
    Flowable<List<GitHubRepositoryEntity>> getGithubRepos();
}
