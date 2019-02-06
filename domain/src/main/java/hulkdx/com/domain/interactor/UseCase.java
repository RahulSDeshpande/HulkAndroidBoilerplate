package hulkdx.com.domain.interactor;


import hulkdx.com.domain.executor.PostExecutionThread;
import hulkdx.com.domain.executor.ThreadExecutor;
import io.reactivex.Flowable;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Mohammad Jafarzadeh Rezvan on 10/11/2018.
 */
abstract class UseCase {

    final ThreadExecutor mThreadExecutor;
    final PostExecutionThread mPostExecutionThread;

    UseCase(ThreadExecutor mThreadExecutor, PostExecutionThread mPostExecutionThread) {
        this.mThreadExecutor      = mThreadExecutor;
        this.mPostExecutionThread = mPostExecutionThread;
    }

    abstract static class FlowableUseCase<T> extends UseCase {

        final CompositeDisposable mDisposables = new CompositeDisposable();

        FlowableUseCase(ThreadExecutor mThreadExecutor, PostExecutionThread mPostExecutionThread) {
            super(mThreadExecutor, mPostExecutionThread);
        }

        abstract Flowable<T> createFlowable();

        public void execute(Consumer<? super T> onNext, Consumer<? super Throwable> onError) {
            execute(onNext, onError, null);
        }

        void execute(Consumer<? super T> onNext,
                     Consumer<? super Throwable> onError,
                     @Nullable Action onComplete)
        {
            final Flowable<T> flowable = this.createFlowable()
                                             .subscribeOn(Schedulers.from(mThreadExecutor))
                                             .observeOn(mPostExecutionThread.getScheduler());
            Disposable disposable;
            if (onComplete == null) {
                disposable = flowable.subscribe(onNext, onError);
            } else {
                disposable = flowable.subscribe(onNext, onError, onComplete);
            }

            mDisposables.add(disposable);
        }

        public void dispose() {
            if (!mDisposables.isDisposed()) {
                mDisposables.dispose();
            }
        }
    }

    // Add Single and Completable:
}
