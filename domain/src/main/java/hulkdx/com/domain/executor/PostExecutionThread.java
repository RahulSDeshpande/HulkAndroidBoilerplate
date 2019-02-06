package hulkdx.com.domain.executor;

import io.reactivex.Scheduler;

/**
 * Created by Mohammad Jafarzadeh Rezvan on 10/11/2018.
 */

public interface PostExecutionThread {
  Scheduler getScheduler();
}
