package r0;

import android.database.sqlite.SQLiteDatabase;

public final class c0 implements b {
    public final long a;

    public c0(long v) {
        this.a = v;
    }

    @Override  // r0.m0$b
    public final Object a(Object object0) {
        return m0.f0(this.a, ((SQLiteDatabase)object0));
    }
}

