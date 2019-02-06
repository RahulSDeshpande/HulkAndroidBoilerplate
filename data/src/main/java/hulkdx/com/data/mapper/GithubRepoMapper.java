package hulkdx.com.data.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import hulkdx.com.data.model.GitHubRepositoryEntity;
import hulkdx.com.domain.models.GitHubRepository;
import io.reactivex.functions.Function;

/**
 * Created by Mohammad Jafarzadeh Rezvan on 10/11/2018.
 */
public class GithubRepoMapper implements Function<List<GitHubRepositoryEntity>, List<GitHubRepository>> {
    @Override
    public List<GitHubRepository> apply(List<GitHubRepositoryEntity> listEntity) throws Exception {
        List<GitHubRepository> list = new ArrayList<>();
        for (GitHubRepositoryEntity entity: listEntity) {
            list.add(convert(entity));
        }
        return list;
    }

    public static GitHubRepository convert(GitHubRepositoryEntity entity) {
        GitHubRepository model = new GitHubRepository();
        model.setName(entity.getName());
        model.setUrl(entity.getUrl());
        return model;
    }
}
