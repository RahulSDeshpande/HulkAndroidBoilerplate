package hulkdx.com.domain.models;

/**
 * Created by Mohammad Jafarzadeh Rezvan on 10/11/2018.
 */
public class GitHubRepository {

    private String name;
    private String url;

    //---------------------------------------------------------------
    // Getters/Setters
    //---------------------------------------------------------------

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
