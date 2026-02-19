package androidx.core.provider;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Typeface;
import androidx.core.graphics.i;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import k.g;

abstract class f {
    static final class e {
        final Typeface a;
        final int b;

        e(int v) {
            this.a = null;
            this.b = v;
        }

        e(Typeface typeface0) {
            this.a = typeface0;
            this.b = 0;
        }

        boolean a() {
            return this.b == 0;
        }
    }

    static final k.e a;
    private static final ExecutorService b;
    static final Object c;
    static final g d;

    static {
        f.a = new k.e(16);
        f.b = h.a("fonts-androidx", 10, 10000);
        f.c = new Object();
        f.d = new g();
    }

    private static String a(androidx.core.provider.e e0, int v) {
        return e0.d() + "-" + v;
    }

    private static int b(a g$a0) {
        int v = 1;
        switch(g$a0.c()) {
            case 0: {
                b[] arr_g$b = g$a0.b();
                if(arr_g$b != null && arr_g$b.length != 0) {
                    v = 0;
                    for(int v1 = 0; v1 < arr_g$b.length; ++v1) {
                        int v2 = arr_g$b[v1].b();
                        if(v2 != 0) {
                            return v2 < 0 ? -3 : v2;
                        }
                    }
                }
                return v;
            }
            case 1: {
                return -2;
            }
            default: {
                return -3;
            }
        }
    }

    static e c(String s, Context context0, androidx.core.provider.e e0, int v) {
        a g$a0;
        k.e e1 = f.a;
        Typeface typeface0 = (Typeface)e1.c(s);
        if(typeface0 != null) {
            return new e(typeface0);
        }
        try {
            g$a0 = d.e(context0, e0, null);
        }
        catch(PackageManager.NameNotFoundException unused_ex) {
            return new e(-1);
        }
        int v1 = f.b(g$a0);
        if(v1 != 0) {
            return new e(v1);
        }
        Typeface typeface1 = i.b(context0, null, g$a0.b(), v);
        if(typeface1 != null) {
            e1.d(s, typeface1);
            return new e(typeface1);
        }
        return new e(-3);
    }

    static Typeface d(Context context0, androidx.core.provider.e e0, int v, Executor executor0, androidx.core.provider.a a0) {
        class androidx.core.provider.f.b implements androidx.core.util.a {
            final androidx.core.provider.a a;

            androidx.core.provider.f.b(androidx.core.provider.a a0) {
            }

            public void a(e f$e0) {
                if(f$e0 == null) {
                    f$e0 = new e(-3);
                }
                this.a.b(f$e0);
            }

            @Override  // androidx.core.util.a
            public void accept(Object object0) {
                this.a(((e)object0));
            }
        }


        class c implements Callable {
            final String a;
            final Context b;
            final androidx.core.provider.e c;
            final int d;

            c(String s, Context context0, androidx.core.provider.e e0, int v) {
                this.b = context0;
                this.c = e0;
                this.d = v;
                super();
            }

            public e a() {
                try {
                    return f.c(this.a, this.b, this.c, this.d);
                }
                catch(Throwable unused_ex) {
                    return new e(-3);
                }
            }

            @Override
            public Object call() {
                return this.a();
            }
        }


        class androidx.core.provider.f.d implements androidx.core.util.a {
            final String a;

            androidx.core.provider.f.d(String s) {
            }

            public void a(e f$e0) {
                ArrayList arrayList0;
                synchronized(f.c) {
                    g g0 = f.d;
                    arrayList0 = (ArrayList)g0.get(this.a);
                    if(arrayList0 == null) {
                        return;
                    }
                    g0.remove(this.a);
                }
                for(int v1 = 0; v1 < arrayList0.size(); ++v1) {
                    ((androidx.core.util.a)arrayList0.get(v1)).accept(f$e0);
                }
            }

            @Override  // androidx.core.util.a
            public void accept(Object object0) {
                this.a(((e)object0));
            }
        }

        String s = f.a(e0, v);
        Typeface typeface0 = (Typeface)f.a.c(s);
        if(typeface0 != null) {
            a0.b(new e(typeface0));
            return typeface0;
        }
        androidx.core.provider.f.b f$b0 = new androidx.core.provider.f.b(a0);
        synchronized(f.c) {
            g g0 = f.d;
            ArrayList arrayList0 = (ArrayList)g0.get(s);
            if(arrayList0 != null) {
                arrayList0.add(f$b0);
                return null;
            }
            ArrayList arrayList1 = new ArrayList();
            arrayList1.add(f$b0);
            g0.put(s, arrayList1);
        }
        c f$c0 = new c(s, context0, e0, v);
        if(executor0 == null) {
            executor0 = f.b;
        }
        h.b(executor0, f$c0, new androidx.core.provider.f.d(s));
        return null;
    }

    static Typeface e(Context context0, androidx.core.provider.e e0, androidx.core.provider.a a0, int v, int v1) {
        class androidx.core.provider.f.a implements Callable {
            final String a;
            final Context b;
            final androidx.core.provider.e c;
            final int d;

            androidx.core.provider.f.a(String s, Context context0, androidx.core.provider.e e0, int v) {
                this.b = context0;
                this.c = e0;
                this.d = v;
                super();
            }

            public e a() {
                return f.c(this.a, this.b, this.c, this.d);
            }

            @Override
            public Object call() {
                return this.a();
            }
        }

        String s = f.a(e0, v);
        Typeface typeface0 = (Typeface)f.a.c(s);
        if(typeface0 != null) {
            a0.b(new e(typeface0));
            return typeface0;
        }
        if(v1 == -1) {
            e f$e0 = f.c(s, context0, e0, v);
            a0.b(f$e0);
            return f$e0.a;
        }
        androidx.core.provider.f.a f$a0 = new androidx.core.provider.f.a(s, context0, e0, v);
        try {
            e f$e1 = (e)h.c(f.b, f$a0, v1);
            a0.b(f$e1);
            return f$e1.a;
        }
        catch(InterruptedException unused_ex) {
            a0.b(new e(-3));
            return null;
        }
    }
}

