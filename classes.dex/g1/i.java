package g1;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import java.util.concurrent.Executor;

public abstract class i {
    private static final Object a;
    private static n1 b;
    static HandlerThread c;
    private static Executor d;
    private static boolean e;

    static {
        i.a = new Object();
    }

    public static i a(Context context0) {
        synchronized(i.a) {
            if(i.b == null) {
                i.b = new n1(context0.getApplicationContext(), (i.e ? i.b().getLooper() : context0.getMainLooper()), i.d);
            }
            return i.b;
        }
    }

    public static HandlerThread b() {
        synchronized(i.a) {
            HandlerThread handlerThread0 = i.c;
            if(handlerThread0 != null) {
                return handlerThread0;
            }
            HandlerThread handlerThread1 = new HandlerThread("GoogleApiHandler", 9);
            i.c = handlerThread1;
            handlerThread1.start();
            return i.c;
        }
    }

    protected abstract void c(i1 arg1, ServiceConnection arg2, String arg3);

    public final void d(String s, String s1, int v, ServiceConnection serviceConnection0, String s2, boolean z) {
        this.c(new i1(s, s1, 0x1081, z), serviceConnection0, s2);
    }

    protected abstract boolean e(i1 arg1, ServiceConnection arg2, String arg3, Executor arg4);
}

