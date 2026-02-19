package r0;

import android.database.sqlite.SQLiteDatabase;

public final class j0 implements b {
    public final m0 a;
    public final long b;

    public j0(m0 m00, long v) {
        this.a = m00;
        this.b = v;
    }

    @Override  // r0.m0$b
    public final Object a(Object object0) {
        return this.a.Z(this.b, ((SQLiteDatabase)object0));
    }
}

