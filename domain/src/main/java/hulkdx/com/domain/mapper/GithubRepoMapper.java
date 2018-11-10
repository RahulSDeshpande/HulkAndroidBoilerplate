package hulkdx.com.domain.mapper;

import hulkdx.com.data.model.GitHubRepositoryEntity;
import hulkdx.com.domain.models.GitHubRepository;
import io.reactivex.functions.Function;

/**
 * Created by Mohammad Jafarzadeh Rezvan on 10/11/2018.
 */
public class GithubRepoMapper implements Function<GitHubRepositoryEntity, GitHubRepository> {
    @Override
    public GitHubRepository apply(GitHubRepositoryEntity entity) throws Exception {
        // TODO 
        GitHubRepository model = new GitHubRepository();
        return model;
    }
}
