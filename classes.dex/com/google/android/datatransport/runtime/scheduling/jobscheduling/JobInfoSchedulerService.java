package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Base64;
import j0.o.a;
import j0.o;
import j0.t;

public class JobInfoSchedulerService extends JobService {
    // 检测为 Lambda 实现
    private void b(JobParameters jobParameters0) [...]

    @Override  // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters0) {
        String s = jobParameters0.getExtras().getString("backendName");
        String s1 = jobParameters0.getExtras().getString("extras");
        int v = jobParameters0.getExtras().getInt("priority");
        int v1 = jobParameters0.getExtras().getInt("attemptNumber");
        t.f(this.getApplicationContext());
        a o$a0 = o.a().b(s).d(u0.a.b(v));
        if(s1 != null) {
            o$a0.c(Base64.decode(s1, 0));
        }
        t.c().e().v(o$a0.a(), v1, () -> this.jobFinished(jobParameters0, false));
        return true;
    }

    @Override  // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters0) {
        return true;
    }
}

