package example.com.presentation.util;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import example.com.presentation.di.annotations.ConfigPersistent;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Emitter;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.ReplaySubject;
import timber.log.Timber;

/**
 * Created by Mohammad Jafarzadeh Rezvan on 23/02/2019.
 *
 * Cache the data loaded from presenters.
 * And
 * Only display the cache to view once the view (e.g. Fragment) is in foreground.
 *
 * This class combine with Presenter simulating LiveData behaviour.
 */
@SuppressWarnings({"Convert2MethodRef", "CodeBlock2Expr"})
@ConfigPersistent
public class PresenterCache {

    // private ReplaySubject<Runnable> mObservable = ReplaySubject.create();
    // private Disposable mDisposable;

    private List<Runnable> mCacheData = new ArrayList<>();
    private boolean isAttached = false;

    @Inject
    public PresenterCache() {
    }

    public void store(Runnable runnable) {
        if (isAttached) {
            runnable.run();
        }
        else {
            mCacheData.add(runnable);
        }
    }

    public void attach() {
        isAttached = true;
        for (Runnable runnable: mCacheData) {
            runnable.run();
        }
    }

    public void detach() {
        isAttached = false;
    }

    public void destroy() {
        mCacheData.clear();
    }

}
