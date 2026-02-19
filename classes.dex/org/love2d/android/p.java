package org.love2d.android;

import android.os.AsyncTask;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import d1.k;
import g2.d;
import g2.h;
import g2.i;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import p1.r;
import v1.g;

public class p {
    class f {
        private final CountDownLatch a;
        private boolean b;
        private final Status c;
        private final Status d;
        final p e;

        public f(CountDownLatch countDownLatch0) {
            this.c = new Status(0);
            this.d = new Status(16);
            this.a = countDownLatch0;
            this.b = false;
        }

        public k d() {
            class a implements k {
                final f e;

                @Override  // d1.k
                public Status g0() {
                    return f.this.d;
                }
            }


            class b implements k {
                final f e;

                // 去混淆评级： 低(20)
                @Override  // d1.k
                public Status g0() {
                    return f.this.b ? f.this.d : f.this.c;
                }
            }

            if(!this.b) {
                CountDownLatch countDownLatch0 = this.a;
                if(countDownLatch0 != null) {
                    try {
                        countDownLatch0.await();
                        return new b(this);
                    }
                    catch(InterruptedException unused_ex) {
                        return new a(this);
                    }
                }
            }
            return new b(this);
        }
    }

    private final Map a;
    private final Set b;
    private static final p c;

    static {
        p.c = new p();
    }

    private p() {
        this.a = new HashMap();
        this.b = new HashSet();
    }

    public h c(r r0, v1.a a0, g g0) {
        class e implements g2.a {
            final r a;
            final v1.a b;
            final g c;
            final String d;
            final p e;

            e(r r0, v1.a a0, g g0, String s) {
                this.a = r0;
                this.b = a0;
                this.c = g0;
                this.d = s;
                super();
            }

            @Override  // g2.a
            public Object a(h h0) {
                return this.b(h0);
            }

            public h b(h h0) {
                class org.love2d.android.p.e.a implements d {
                    final e a;

                    @Override  // g2.d
                    public void a(h h0) {
                        Log.d("SnapshotCoordinator", "CommitAndClose complete, closing " + e.this.d);
                        p.this.j(e.this.d);
                    }
                }

                return this.a.b(this.b, this.c).c(new org.love2d.android.p.e.a(this));
            }
        }

        String s = a0.t().Y();
        return this.l(s).k(new e(this, r0, a0, g0, s));
    }

    private d d(String s) {
        class c implements d {
            final String a;
            final p b;

            c(String s) {
                this.a = s;
                super();
            }

            @Override  // g2.d
            public void a(h h0) {
                boolean z = false;
                if(!h0.q()) {
                    z = true;
                    Exception exception0 = h0.m();
                    Log.e("SnapshotCoordinator", "Open was not a success for filename " + this.a, exception0);
                }
                else if(((p1.r.a)h0.n()).c()) {
                    z = true;
                    Log.d("SnapshotCoordinator", "Open successful: " + this.a + ", but with a conflict. Setting back to closed so it gets re-opened for resolution");
                }
                if(z) {
                    p.this.j(this.a);
                    return;
                }
                Log.d("SnapshotCoordinator", "Open successful: " + this.a);
            }
        }

        return new c(this, s);
    }

    public h e(r r0, v1.a a0) {
        class org.love2d.android.p.b implements g2.a {
            final r a;
            final v1.a b;
            final p c;

            org.love2d.android.p.b(r r0, v1.a a0) {
                this.a = r0;
                this.b = a0;
                super();
            }

            @Override  // g2.a
            public Object a(h h0) {
                return this.b(h0);
            }

            public h b(h h0) {
                class org.love2d.android.p.b.a implements d {
                    final org.love2d.android.p.b a;

                    @Override  // g2.d
                    public void a(h h0) {
                        Log.d("SnapshotCoordinator", "Closed " + org.love2d.android.p.b.this.b.t().Y());
                        String s = org.love2d.android.p.b.this.b.t().Y();
                        p.this.j(s);
                    }
                }

                return this.a.a(this.b).c(new org.love2d.android.p.b.a(this));
            }
        }

        return this.l(a0.t().Y()).k(new org.love2d.android.p.b(this, r0, a0));
    }

    public static p f() {
        return p.c;
    }

    public boolean g(String s) {
        synchronized(this) {
            return this.b.contains(s);
        }
    }

    public boolean h(String s) {
        synchronized(this) {
            return this.a.containsKey(s);
        }
    }

    public h i(r r0, String s, boolean z) {
        class org.love2d.android.p.d implements g2.a {
            final r a;
            final String b;
            final boolean c;
            final p d;

            org.love2d.android.p.d(r r0, String s, boolean z) {
                this.a = r0;
                this.b = s;
                this.c = z;
                super();
            }

            @Override  // g2.a
            public Object a(h h0) {
                return this.b(h0);
            }

            public h b(h h0) {
                return this.a.d(this.b, this.c, -1).c(p.this.d(this.b));
            }
        }

        return this.n(s).k(new org.love2d.android.p.d(this, r0, s, z));
    }

    private void j(String s) {
        synchronized(this) {
            this.b.remove(s);
            CountDownLatch countDownLatch0 = (CountDownLatch)this.a.remove(s);
            if(countDownLatch0 != null) {
                countDownLatch0.countDown();
            }
        }
    }

    private void k(String s) {
        synchronized(this) {
            this.b.add(s);
        }
    }

    private h l(String s) {
        IllegalStateException illegalStateException0;
        i i0 = new i();
        boolean z = false;
        if(!this.h(s)) {
            z = true;
            illegalStateException0 = new IllegalStateException(s + " is already closed!");
        }
        else if(this.g(s)) {
            z = true;
            illegalStateException0 = new IllegalStateException(s + " is current closing!");
        }
        if(z) {
            i0.b(illegalStateException0);
            return i0.a();
        }
        this.k(s);
        i0.c(null);
        return i0.a();
    }

    private void m(String s) {
        synchronized(this) {
            CountDownLatch countDownLatch0 = new CountDownLatch(1);
            this.a.put(s, countDownLatch0);
        }
    }

    private h n(String s) {
        IllegalStateException illegalStateException0;
        i i0 = new i();
        boolean z = false;
        if(this.h(s)) {
            z = true;
            illegalStateException0 = new IllegalStateException(s + " is already open!");
        }
        else if(this.g(s)) {
            z = true;
            illegalStateException0 = new IllegalStateException(s + " is current closing!");
        }
        if(z) {
            i0.b(illegalStateException0);
            return i0.a();
        }
        this.m(s);
        i0.c(null);
        return i0.a();
    }

    public h o(String s) {
        class org.love2d.android.p.a extends AsyncTask {
            final CountDownLatch a;
            final i b;
            final p c;

            org.love2d.android.p.a(CountDownLatch countDownLatch0, i i0) {
                this.a = countDownLatch0;
                this.b = i0;
                super();
            }

            protected Void a(Void[] arr_void) {
                k k0 = new f(p.this, this.a).d();
                this.b.c(k0);
                return null;
            }

            @Override  // android.os.AsyncTask
            protected Object doInBackground(Object[] arr_object) {
                return this.a(((Void[])arr_object));
            }
        }

        CountDownLatch countDownLatch0;
        i i0 = new i();
        synchronized(this) {
            countDownLatch0 = (CountDownLatch)this.a.get(s);
        }
        if(countDownLatch0 == null) {
            i0.c(null);
            return i0.a();
        }
        new org.love2d.android.p.a(this, countDownLatch0, i0).execute(new Void[0]);
        return i0.a();
    }
}

