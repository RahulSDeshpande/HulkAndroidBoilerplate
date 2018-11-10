package hulkdx.com.domain.interactor;


import hulkdx.com.data.executor.PostExecutionThread;
import hulkdx.com.data.executor.ThreadExecutor;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by Mohammad Jafarzadeh Rezvan on 10/11/2018.
 */
abstract class UseCase<T> {

    final ThreadExecutor mThreadExecutor;
    final PostExecutionThread mPostExecutionThread;
    final CompositeDisposable mDisposables = new CompositeDisposable();


    UseCase(ThreadExecutor mThreadExecutor, PostExecutionThread mPostExecutionThread) {
        this.mThreadExecutor      = mThreadExecutor;
        this.mPostExecutionThread = mPostExecutionThread;
    }

    public void dispose() {
        if (!mDisposables.isDisposed()) {
            mDisposables.dispose();
        }
    }

    abstract static class FlowableUseCase<T> extends UseCase<T> {

        public FlowableUseCase(ThreadExecutor mThreadExecutor, PostExecutionThread mPostExecutionThread) {
            super(mThreadExecutor, mPostExecutionThread);
        }

        abstract Flowable<T> createFlowable();

        public void execute(DisposableSubscriber<T> observer) {
            final Flowable<T> flowable = this.createFlowable()
                                             .subscribeOn(Schedulers.from(mThreadExecutor))
                                             .observeOn(mPostExecutionThread.getScheduler());

            mDisposables.add(flowable.subscribeWith(observer));
        }
    }

    // Add Single and Completable:
}
