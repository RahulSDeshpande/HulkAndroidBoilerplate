package example.com.presentation.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
public class MainFragment extends BaseFragment implements MainContract.View {

    @Inject ExampleAdapter mAdapter;
    @Inject MainPresenter  mMainPresenter;

    private RecyclerView mRecyclerView;

    //---------------------------------------------------------------
    // Lifecycle
    //---------------------------------------------------------------


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (!(getActivity() instanceof MainActivity)) {
            throw new RuntimeException();
        }
        // Add activity listener here:
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getMainActivity().getActivityComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_main, container, false);
        mRecyclerView = view.findViewById(R.id.recycler_view);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mMainPresenter.attach(this);
        mMainPresenter.loadData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mMainPresenter.detach();
    }

    //---------------------------------------------------------------
    // Getters or Setters
    //---------------------------------------------------------------

    @NonNull
    private MainActivity getMainActivity() {
        MainActivity activity = (MainActivity) this.getActivity();
        if (activity == null) {
            throw new RuntimeException("cannot cast activity");
        }
        return activity;
    }

    //---------------------------------------------------------------
    // MVP callbacks
    //---------------------------------------------------------------

    @Override
    public void githubRepositoriesLoaded(Collection<GithubRepositoryModel> githubRepositoryModels) {
        Timber.i("data loaded");
        mAdapter.setData(githubRepositoryModels);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void githubRepositoriesFailed(Throwable t) {

    }
}
