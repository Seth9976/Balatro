package y2;

import android.content.Context;
import e0.c;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import x2.k0;
import x2.p0;

public class d {
    private static final k0 a;
    private static Map b;

    static {
        d.a = k0.f("d");
    }

    public void d(Context context0, e e0) {
        class a implements c {
            final e0.a a;
            final e b;
            final Context c;
            final d d;

            a(e0.a a0, e e0, Context context0) {
                this.a = a0;
                this.b = e0;
                this.c = context0;
                super();
            }

            @Override  // e0.c
            public void a(int v) {
                class y2.d.a.a implements Runnable {
                    final int e;
                    final a f;

                    y2.d.a.a(int v) {
                        this.e = v;
                        super();
                    }

                    @Override
                    public void run() {
                        switch(this.e) {
                            case 0: {
                                try {
                                    a.this.f(a.this.a);
                                }
                                catch(Throwable unused_ex) {
                                    d.a.c("google onInstallReferrerSetupFinished: failed to get referrer value");
                                }
                                break;
                            }
                            case 1: {
                                d.a.a("google onInstallReferrerSetupFinished: SERVICE_UNAVAILABLE");
                                a.this.e(a.this.c);
                                break;
                            }
                            case 2: {
                                d.a.a("google onInstallReferrerSetupFinished: FEATURE_NOT_SUPPORTED");
                                a.this.e(a.this.c);
                                break;
                            }
                            case 3: {
                                d.a.c("google onInstallReferrerSetupFinished: DEVELOPER_ERROR");
                                a.this.e(a.this.c);
                                break;
                            }
                            default: {
                                d.a.b("Unexpected response code of install referrer response %d", new Object[]{this.e});
                                a.this.e(a.this.c);
                            }
                        }
                        a.this.b.a(d.b);
                        if(a.this.a.c()) {
                            a.this.a.a();
                        }
                    }
                }

                d.a.a("google onInstallReferrerSetupFinished: responseCode=" + v);
                Executors.newSingleThreadExecutor().execute(new y2.d.a.a(this, v));
            }

            @Override  // e0.c
            public void b() {
                this.a.a();
            }

            private void e(Context context0) {
                String s = p0.t(context0);
                if(s != null) {
                    d.e(s, "intent", -1L, -1L, null, -1L, -1L);
                }
            }

            private void f(e0.a a0) {
                long v1;
                long v;
                String s;
                e0.d d0 = a0.b();
                if(this.g(d0)) {
                    s = d0.d();
                    v = d0.f();
                    v1 = d0.b();
                }
                else {
                    s = null;
                    v = -1L;
                    v1 = -1L;
                }
                d.e(d0.c(), "service", d0.e(), d0.a(), s, v, v1);
            }

            private boolean g(e0.d d0) {
                try {
                    if(d0.getClass().getMethod("getInstallVersion", new Class[0]) != null) {
                        return true;
                    }
                }
                catch(Throwable unused_ex) {
                }
                return false;
            }
        }

        try {
            e0.a a0 = e0.a.d(context0).a();
            a0.e(new a(this, a0, e0, context0));
        }
        catch(Throwable unused_ex) {
            d.a.c("google: failed to get referrer value");
        }
    }

    private static void e(String s, String s1, long v, long v1, String s2, long v2, long v3) {
        HashMap hashMap0 = new HashMap();
        d.b = hashMap0;
        hashMap0.put("referrer", s);
        d.b.put("referrer_source", s1);
        d.b.put("clickTimestampSeconds", v);
        d.b.put("installBeginTimestampSeconds", v1);
        d.b.put("current_device_time", 0x19C748F9325L);
        d.b.put("installVersion", s2);
        d.b.put("clickTimestampServerSeconds", v2);
        d.b.put("installBeginTimestampServerSeconds", v3);
    }
}

