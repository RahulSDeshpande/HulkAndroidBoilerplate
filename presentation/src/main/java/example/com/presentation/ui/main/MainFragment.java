package example.com.presentation.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Collection;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import example.com.presentation.R;
import example.com.presentation.models.GithubRepositoryModel;
import example.com.presentation.ui.base.BaseFragment;
import timber.log.Timber;

/**
 * Created by Mohammad Jafarzadeh Rezvan on 10/11/2018.
 */
public class MainFragment extends BaseFragment<MainPresenter, MainActivity>
        implements MainContract.View {

    @Inject ExampleAdapter mAdapter;

    private RecyclerView mRecyclerView;

    //---------------------------------------------------------------
    // Lifecycle
    //---------------------------------------------------------------

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivityComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_main, container, false);
        mRecyclerView = view.findViewById(R.id.recycler_view);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.loadData();
    }

    //---------------------------------------------------------------
    // MVP callbacks
    //---------------------------------------------------------------

    @Override
    public void githubRepositoriesLoaded(Collection<GithubRepositoryModel> githubRepositoryModels) {
        Timber.i("data loaded");
        mAdapter.setData(githubRepositoryModels);
    }

    @Override
    public void githubRepositoriesFailed(Throwable t) {

    }
}
