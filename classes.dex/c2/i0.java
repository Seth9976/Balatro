package c2;

import android.app.Application;
import android.content.Context;
import com.google.android.gms.games.internal.v2.appshortcuts.e;
import java.util.concurrent.atomic.AtomicReference;
import q1.q;

public final class i0 {
    private final Application a;
    private final k b;
    private final q c;
    private final e d;
    private static final AtomicReference e;
    private static boolean f;

    static {
        i0.e = new AtomicReference();
        i0.f = false;
    }

    private i0(Application application0, k k0, q q0, e e0) {
        this.a = application0;
        this.b = k0;
        this.c = q0;
        this.d = e0;
    }

    public static Application a() {
        i0.b();
        return ((i0)i0.e.get()).a;
    }

    public static void b() {
        g1.q.l(i0.f, "PlayGamesSdk has not been initialized. Ensure that PlayGamesSdk.initialize() has been called.");
    }

    public static void c(Context context0) {
        g1.q.a(context0 != null);
        AtomicReference atomicReference0 = i0.e;
        if(atomicReference0.get() == null) {
            synchronized(atomicReference0) {
                if(atomicReference0.get() == null) {
                    Context context1 = context0.getApplicationContext();
                    Application application0 = context1 == null ? ((Application)context0) : ((Application)context1);
                    i0 i00 = new i0(application0, k.a(application0), q.b(application0), e.b(context0));
                    atomicReference0.set(i00);
                    i00.d.a();
                    i00.b.c();
                    i00.c.g();
                }
            }
        }
        i0.f = true;
    }
}

