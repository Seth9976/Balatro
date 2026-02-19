package r0;

import android.database.sqlite.SQLiteDatabase;
import j0.o;

public final class n implements b {
    public final long a;
    public final o b;

    public n(long v, o o0) {
        this.a = v;
        this.b = o0;
    }

    @Override  // r0.m0$b
    public final Object a(Object object0) {
        return m0.w0(this.a, this.b, ((SQLiteDatabase)object0));
    }
}

