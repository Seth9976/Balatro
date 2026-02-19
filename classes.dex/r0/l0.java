package r0;

import android.database.sqlite.SQLiteDatabase;
import j0.o;

public final class l0 implements b {
    public final m0 a;
    public final o b;

    public l0(m0 m00, o o0) {
        this.a = m00;
        this.b = o0;
    }

    @Override  // r0.m0$b
    public final Object a(Object object0) {
        return this.a.i0(this.b, ((SQLiteDatabase)object0));
    }
}

