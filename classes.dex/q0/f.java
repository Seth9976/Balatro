package q0;

import android.app.job.JobInfo.Builder;
import h0.d;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class f {
    public static class a {
        private t0.a a;
        private Map b;

        public a() {
            this.b = new HashMap();
        }

        public a a(d d0, b f$b0) {
            this.b.put(d0, f$b0);
            return this;
        }

        public f b() {
            if(this.a == null) {
                throw new NullPointerException("missing required property: clock");
            }
            if(this.b.keySet().size() < d.values().length) {
                throw new IllegalStateException("Not all priorities have been configured");
            }
            Map map0 = this.b;
            this.b = new HashMap();
            return f.d(this.a, map0);
        }

        public a c(t0.a a0) {
            this.a = a0;
            return this;
        }
    }

    public static abstract class b {
        public static abstract class q0.f.b.a {
            public abstract b a();

            public abstract q0.f.b.a b(long arg1);

            public abstract q0.f.b.a c(Set arg1);

            public abstract q0.f.b.a d(long arg1);
        }

        public static q0.f.b.a a() {
            return new q0.c.b().c(Collections.emptySet());
        }

        abstract long b();

        abstract Set c();

        abstract long d();
    }

    public static enum c {
        NETWORK_UNMETERED,
        DEVICE_IDLE,
        DEVICE_CHARGING;

    }

    private long a(int v, long v1) {
        return v1 <= 1L ? ((long)(Math.pow(3.0, v - 1) * ((double)v1) * Math.max(1.0, 9.21034 / Math.log(2L * ((long)(v - 1)))))) : ((long)(Math.pow(3.0, v - 1) * ((double)v1) * Math.max(1.0, 9.21034 / Math.log(v1 * ((long)(v - 1))))));
    }

    public static a b() {
        return new a();
    }

    public JobInfo.Builder c(JobInfo.Builder jobInfo$Builder0, d d0, long v, int v1) {
        jobInfo$Builder0.setMinimumLatency(this.g(d0, v, v1));
        this.j(jobInfo$Builder0, ((b)this.h().get(d0)).c());
        return jobInfo$Builder0;
    }

    static f d(t0.a a0, Map map0) {
        return new q0.b(a0, map0);
    }

    abstract t0.a e();

    public static f f(t0.a a0) {
        a f$a0 = f.b();
        b f$b0 = b.a().b(30000L).d(86400000L).a();
        a f$a1 = f$a0.a(d.e, f$b0);
        b f$b1 = b.a().b(1000L).d(86400000L).a();
        a f$a2 = f$a1.a(d.g, f$b1);
        b f$b2 = b.a().b(86400000L).d(86400000L).c(f.i(new c[]{c.f})).a();
        return f$a2.a(d.f, f$b2).c(a0).b();
    }

    public long g(d d0, long v, int v1) {
        long v2 = this.e().a();
        b f$b0 = (b)this.h().get(d0);
        return Math.min(Math.max(this.a(v1, f$b0.b()), v - v2), f$b0.d());
    }

    abstract Map h();

    private static Set i(Object[] arr_object) {
        return Collections.unmodifiableSet(new HashSet(Arrays.asList(arr_object)));
    }

    private void j(JobInfo.Builder jobInfo$Builder0, Set set0) {
        if(set0.contains(c.e)) {
            jobInfo$Builder0.setRequiredNetworkType(2);
        }
        else {
            jobInfo$Builder0.setRequiredNetworkType(1);
        }
        if(set0.contains(c.g)) {
            jobInfo$Builder0.setRequiresCharging(true);
        }
        if(set0.contains(c.f)) {
            jobInfo$Builder0.setRequiresDeviceIdle(true);
        }
    }
}

