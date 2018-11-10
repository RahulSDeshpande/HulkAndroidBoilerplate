package example.com.presentation.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import example.com.presentation.models.GithubRepositoryModel;
import hulkdx.com.domain.models.GitHubRepository;

/**
 * Created by Mohammad Jafarzadeh Rezvan on 10/11/2018.
 */

public class GitRepositoryModelMapper {

    public static GithubRepositoryModel convert(GitHubRepository repository) {
        GithubRepositoryModel model = new GithubRepositoryModel();
        model.name = repository.getName();
        model.url  = repository.getUrl();
        return model;
    }

    public static Collection<GithubRepositoryModel> convert(Collection<GitHubRepository> gitHubRepositories) {
        List<GithubRepositoryModel> list = new ArrayList<>();
        for (GitHubRepository repository: gitHubRepositories) {
            list.add(convert(repository));
        }
        return list;
    }
}
