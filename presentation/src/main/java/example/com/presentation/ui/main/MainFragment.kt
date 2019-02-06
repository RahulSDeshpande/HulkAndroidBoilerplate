package example.com.presentation.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import example.com.presentation.R
import example.com.presentation.models.GithubRepositoryModel
import example.com.presentation.ui.base.BaseFragment
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by Mohammad Jafarzadeh Rezvan on 10/11/2018.
 *
 */
class MainFragment : BaseFragment(), MainContract.View {

    @Inject internal lateinit var mAdapter: ExampleAdapter
    @Inject internal lateinit var mMainPresenter: MainPresenter

    private lateinit var mRecyclerView: RecyclerView

    private val mainActivity: MainActivity
        get() = this.activity as MainActivity? ?: throw RuntimeException("cannot cast activity")

    //---------------------------------------------------------------
    // Lifecycle
    //---------------------------------------------------------------

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivity.activityComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View?
    {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        mRecyclerView = view.findViewById(R.id.recycler_view)
        mRecyclerView.adapter = mAdapter
        mRecyclerView.layoutManager = LinearLayoutManager(activity)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mMainPresenter.attach(this)
        mMainPresenter.loadData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mMainPresenter.detach()
    }

    //---------------------------------------------------------------
    // MVP callbacks
    //---------------------------------------------------------------

    override fun githubRepositoriesLoaded(githubRepositoryModels: List<GithubRepositoryModel>) {
        Timber.i("data loaded")
        mAdapter.setData(githubRepositoryModels)
        mAdapter.notifyDataSetChanged()
    }

    override fun githubRepositoriesFailed(t: Throwable) {

    }
}
