package x2;

import android.content.Context;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public class i {
    public interface d {
        boolean a(h arg1);
    }

    public interface e {
        void a(h arg1);
    }

    private Semaphore a;
    private Semaphore b;
    private Context c;
    private boolean d;
    private boolean e;
    private String f;
    private long g;
    private d h;
    private e i;
    private String[] j;
    private Map k;
    private j l;
    private static final k0 m;
    private static i n;

    static {
        i.m = k0.f("i");
    }

    private i(Context context0, j j0, d i$d0, e i$e0) {
        this.a = new Semaphore(1, true);
        this.b = new Semaphore(1, true);
        this.d = false;
        this.e = false;
        this.f = null;
        this.j = new String[]{"ad_platform", "ad_currency", "pcc"};
        this.k = new ConcurrentHashMap();
        this.l = j0;
        this.h = i$d0;
        this.i = i$e0;
        this.g = j0.d();
        this.d = m.l().k().d();
        this.e = m.l().k().c();
        this.c = context0;
    }

    public void r(h h0) {
        class b implements Runnable {
            final h e;
            final i f;

            b(h h0) {
                this.e = h0;
                super();
            }

            @Override
            public void run() {
                i.m.a("addToBatch api: " + this.e.o());
                if(!i.this.d || !this.e.n()) {
                    i.m.a("addToBatch: no need to batch: batching enabled: " + i.this.d + " is Admon event: " + this.e.n());
                    i.this.i.a(this.e);
                }
                else {
                    i.m.a("addToBatch: event needs to be batched");
                    try {
                        i.this.s(this.e);
                    }
                    catch(Throwable throwable0) {
                        i.m.a("addToBatch: exception: " + throwable0.getMessage());
                        if(!i.this.e) {
                            i.this.i.a(this.e);
                        }
                    }
                }
            }
        }

        String s;
        k0 k00;
        if(this.d && this.e && h0.n()) {
            try {
                h h1 = h.j(h0.o());
                this.i.a(h1);
                goto label_12;
            }
            catch(IOException iOException0) {
                k00 = i.m;
                s = "IOExceptionException";
            }
            catch(Throwable iOException0) {
                k00 = i.m;
                s = "Throwable";
            }
            k00.d(s, iOException0);
        }
        try {
        label_12:
            Executors.newSingleThreadExecutor().execute(new b(this, h0));
        }
        catch(Throwable throwable0) {
            String s1 = p0.h(throwable0);
            i.m.c(s1);
            this.x(throwable0);
        }
    }

    private void s(h h0) {
        synchronized(this) {
            try {
                this.a.acquire();
            }
            catch(InterruptedException interruptedException0) {
                String s = p0.h(interruptedException0);
                i.m.c(s);
            }
        }
        try {
            long v1 = System.currentTimeMillis();
            String s1 = this.w(h0);
            k0 k00 = i.m;
            k00.a("batchEvent: " + h0.o());
            k00.a("batchEvent: key: " + s1);
            JSONObject jSONObject0 = new JSONObject(((String)h0.get("e")));
            if(this.k.containsKey(s1)) {
                h h1 = (h)this.k.get(s1);
                JSONObject jSONObject2 = new JSONObject(((String)h1.get("e")));
                double f2 = jSONObject2.getDouble("r");
                double f3 = jSONObject0.getDouble("r");
                double f4 = jSONObject2.getDouble("ad_revenue");
                double f5 = jSONObject0.getDouble("ad_revenue");
                int v2 = jSONObject2.getInt("admon_count");
                jSONObject2.put("r", f2 + f3);
                jSONObject2.put("ad_revenue", f4 + f5);
                jSONObject2.put("admon_count", v2 + 1);
                jSONObject2.put("last_update_timestamp", v1);
                h1.g("e", jSONObject2.toString());
                k00.a("batchEvent: added to existing event: " + h1.o());
                this.a.release();
                this.l.f(s1, h1.o());
            }
            else {
                JSONObject jSONObject1 = new JSONObject(s1);
                jSONObject1.remove("send_id");
                double f = jSONObject0.getDouble("r");
                double f1 = jSONObject0.getDouble("ad_revenue");
                jSONObject1.put("r", f);
                jSONObject1.put("ad_revenue", f1);
                jSONObject1.put("admon_count", 1);
                jSONObject1.put("is_admon_revenue", jSONObject0.getBoolean("is_admon_revenue"));
                jSONObject1.put("is_revenue_event", jSONObject0.getBoolean("is_revenue_event"));
                jSONObject1.put("first_update_timestamp", v1);
                jSONObject1.put("last_update_timestamp", v1);
                h0.g("e", jSONObject1.toString());
                h0.g("event_index", "a" + p0.m(this.c));
                if(this.e) {
                    h0.g("_de", "true");
                }
                this.k.put(s1, h0);
                this.a.release();
                this.l.e(s1, h0.o());
                k00.a("batchEvent: created 1st event: " + h0.o());
            }
        }
        catch(Throwable throwable0) {
            this.a.release();
            String s2 = p0.h(throwable0);
            i.m.c(s2);
            this.x(throwable0);
            throw throwable0;
        }
    }

    public static i t() {
        return i.n;
    }

    public static void u(Context context0, j j0, d i$d0, e i$e0) {
        class a implements x2.m.d {
            final i a;

            @Override  // x2.m$d
            public void a() {
                m.l().p(i.n.f);
            }

            @Override  // x2.m$d
            public void b(boolean z) {
                m.l().p(i.this.f);
                boolean z1 = m.l().k().d();
                i.this.d = z1;
                boolean z2 = m.l().k().c();
                i.this.e = z2;
            }
        }

        i.m.a("init with persistence: " + j0.getClass().getName());
        i i0 = new i(context0, j0, i$d0, i$e0);
        i0.v();
        i0.f = m.l().o(new a(i0));
        i.n = i0;
    }

    private void v() {
        i.m.a("loadFromPersistence");
        for(Object object0: this.l.a()) {
            Map.Entry map$Entry0 = (Map.Entry)object0;
            try {
                this.k.put(map$Entry0.getKey(), h.j(((String)map$Entry0.getValue())));
            }
            catch(Throwable throwable0) {
                String s = p0.h(throwable0);
                i.m.c(s);
            }
        }
        i.m.a("loadFromPersistence: loaded " + this.k.size() + " entries");
    }

    private String w(h h0) {
        i.m.a("prepareKey for API: " + h0.o());
        JSONObject jSONObject0 = new JSONObject(((String)h0.get("e")));
        JSONObject jSONObject1 = new JSONObject();
        jSONObject1.put("send_id", this.g);
        String[] arr_s = this.j;
        for(int v = 0; v < arr_s.length; ++v) {
            String s = arr_s[v];
            String s1 = jSONObject0.getString(s);
            try {
                jSONObject1.put(s, s1);
            }
            catch(JSONException jSONException0) {
                String s2 = p0.h(jSONException0);
                i.m.c(s2);
            }
        }
        i.m.a("prepareKey result: " + jSONObject1.toString());
        return jSONObject1.toString();
    }

    private void x(Throwable throwable0) {
        try {
            h0.e(this.c, Boolean.FALSE).h(throwable0);
        }
        catch(RuntimeException unused_ex) {
        }
    }

    public void y() {
        class c implements Runnable {
            final i e;

            @Override
            public void run() {
                class x2.i.c.a implements Runnable {
                    final h e;
                    final String f;
                    final ExecutorService g;
                    final Semaphore h;
                    final c i;

                    x2.i.c.a(h h0, String s, ExecutorService executorService0, Semaphore semaphore0) {
                        this.e = h0;
                        this.f = s;
                        this.g = executorService0;
                        this.h = semaphore0;
                        super();
                    }

                    @Override
                    public void run() {
                        class x2.i.c.a.a implements Runnable {
                            final x2.i.c.a e;

                            @Override
                            public void run() {
                                try {
                                    i.this.k.remove(x2.i.c.a.this.f);
                                    i.this.l.b(x2.i.c.a.this.f);
                                }
                                catch(Throwable throwable0) {
                                    i.m.c(p0.h(throwable0));
                                    i.this.x(throwable0);
                                }
                                finally {
                                    x2.i.c.a.this.h.release();
                                }
                            }
                        }

                        if(i.this.h.a(this.e)) {
                            i.m.a("sendEvents: sending event with key: " + this.f + " is successful");
                            x2.i.c.a.a i$c$a$a0 = new x2.i.c.a.a(this);
                            this.g.execute(i$c$a$a0);
                            return;
                        }
                        i.m.a("sendEvents: sending event with key: " + this.f + " has failed");
                        this.h.release();
                    }
                }

                try {
                    i.this.b.acquire();
                    i.this.a.acquire();
                    goto label_5;
                }
                catch(Throwable throwable0) {
                    try {
                        i.m.c(p0.h(throwable0));
                    label_5:
                        long v = i.this.l.c();
                        i.this.g = v;
                        i.this.a.release();
                        i.m.a("sendEvents: total events to send " + i.this.k.size());
                        ExecutorService executorService0 = Executors.newSingleThreadExecutor();
                        String[] arr_s = (String[])i.this.k.keySet().toArray(new String[0]);
                        LinkedList linkedList0 = new LinkedList();
                        for(int v1 = 0; v1 < arr_s.length; ++v1) {
                            if(new JSONObject(arr_s[v1]).getLong("send_id") < i.this.g) {
                                linkedList0.add(arr_s[v1]);
                            }
                        }
                        String[] arr_s1 = (String[])linkedList0.toArray(new String[0]);
                        Semaphore semaphore0 = new Semaphore(0, true);
                        for(int v2 = 0; v2 < arr_s1.length; ++v2) {
                            String s = arr_s1[v2];
                            h h0 = (h)i.this.k.get(s);
                            i.m.a("sendEvents: sending event with key: " + s + " and body: " + h0.toString());
                            try {
                                Executors.newSingleThreadExecutor().execute(new x2.i.c.a(this, h0, s, executorService0, semaphore0));
                            }
                            catch(Throwable throwable2) {
                                i.m.c(p0.h(throwable2));
                                i.this.x(throwable2);
                            }
                        }
                        try {
                            semaphore0.tryAcquire(arr_s1.length, 60L, TimeUnit.SECONDS);
                        }
                        catch(Throwable throwable3) {
                            i.m.c(p0.h(throwable3));
                        }
                        finally {
                            i.this.b.release();
                        }
                        goto label_48;
                    }
                    catch(Throwable throwable1) {
                    }
                }
                try {
                    i.m.c(p0.h(throwable1));
                    i.this.x(throwable1);
                }
                catch(Throwable throwable4) {
                    i.this.a.release();
                    throw throwable4;
                }
            label_48:
                i.this.a.release();
            }
        }

        if(!this.d) {
            return;
        }
        try {
            Executors.newSingleThreadExecutor().execute(new c(this));
        }
        catch(Throwable throwable0) {
            String s = p0.h(throwable0);
            i.m.c(s);
            this.x(throwable0);
        }
    }
}

