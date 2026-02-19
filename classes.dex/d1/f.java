package d1;

import android.os.Looper;
import e1.d;
import e1.i;
import e1.k;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

public abstract class f {
    public interface a extends d {
    }

    public interface b extends i {
    }

    private static final Set a;

    static {
        f.a = Collections.newSetFromMap(new WeakHashMap());
    }

    public abstract com.google.android.gms.common.api.internal.b a(com.google.android.gms.common.api.internal.b arg1);

    public static Set b() {
        synchronized(f.a) {
        }
        return f.a;
    }

    public abstract Looper c();

    public boolean d(k k0) {
        throw new UnsupportedOperationException();
    }

    public void e() {
        throw new UnsupportedOperationException();
    }
}

