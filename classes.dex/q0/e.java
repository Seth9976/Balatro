package q0;

import android.app.job.JobParameters;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;

public final class e implements Runnable {
    public final JobInfoSchedulerService e;
    public final JobParameters f;

    public e(JobInfoSchedulerService jobInfoSchedulerService0, JobParameters jobParameters0) {
        this.e = jobInfoSchedulerService0;
        this.f = jobParameters0;
    }

    @Override
    public final void run() {
        this.e.b(this.f);
    }
}

