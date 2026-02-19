package q0;

import android.app.job.JobInfo.Builder;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import android.util.Base64;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import j0.o;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.zip.Adler32;
import n0.a;

public class d implements x {
    private final Context a;
    private final r0.d b;
    private final f c;

    public d(Context context0, r0.d d0, f f0) {
        this.a = context0;
        this.b = d0;
        this.c = f0;
    }

    @Override  // q0.x
    public void a(o o0, int v) {
        this.b(o0, v, false);
    }

    @Override  // q0.x
    public void b(o o0, int v, boolean z) {
        ComponentName componentName0 = new ComponentName(this.a, JobInfoSchedulerService.class);
        JobScheduler jobScheduler0 = (JobScheduler)this.a.getSystemService("jobscheduler");
        int v1 = this.c(o0);
        if(!z && this.d(jobScheduler0, v1, v)) {
            a.b("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", o0);
            return;
        }
        long v2 = this.b.U(o0);
        JobInfo.Builder jobInfo$Builder0 = new JobInfo.Builder(v1, componentName0);
        h0.d d0 = o0.d();
        JobInfo.Builder jobInfo$Builder1 = this.c.c(jobInfo$Builder0, d0, v2, v);
        PersistableBundle persistableBundle0 = new PersistableBundle();
        persistableBundle0.putInt("attemptNumber", v);
        persistableBundle0.putString("backendName", o0.b());
        persistableBundle0.putInt("priority", u0.a.a(o0.d()));
        if(o0.c() != null) {
            persistableBundle0.putString("extras", Base64.encodeToString(o0.c(), 0));
        }
        jobInfo$Builder1.setExtras(persistableBundle0);
        Object[] arr_object = new Object[5];
        arr_object[0] = o0;
        arr_object[1] = v1;
        h0.d d1 = o0.d();
        arr_object[2] = this.c.g(d1, v2, v);
        arr_object[3] = v2;
        arr_object[4] = v;
        a.c("JobInfoScheduler", "Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", arr_object);
        jobScheduler0.schedule(jobInfo$Builder1.build());
    }

    int c(o o0) {
        Adler32 adler320 = new Adler32();
        adler320.update("com.playstack.balatro.android".getBytes(Charset.forName("UTF-8")));
        adler320.update(o0.b().getBytes(Charset.forName("UTF-8")));
        adler320.update(ByteBuffer.allocate(4).putInt(u0.a.a(o0.d())).array());
        if(o0.c() != null) {
            adler320.update(o0.c());
        }
        return (int)adler320.getValue();
    }

    private boolean d(JobScheduler jobScheduler0, int v, int v1) {
        for(Object object0: jobScheduler0.getAllPendingJobs()) {
            int v2 = ((JobInfo)object0).getExtras().getInt("attemptNumber");
            if(((JobInfo)object0).getId() == v) {
                return v2 >= v1;
            }
            if(false) {
                break;
            }
        }
        return false;
    }
}

