package r0;

import android.database.sqlite.SQLiteDatabase;
import j0.i;
import j0.o;

public final class i0 implements b {
    public final m0 a;
    public final i b;
    public final o c;

    public i0(m0 m00, i i0, o o0) {
        this.a = m00;
        this.b = i0;
        this.c = o0;
    }

    @Override  // r0.m0$b
    public final Object a(Object object0) {
        return this.a.q0(this.b, this.c, ((SQLiteDatabase)object0));
    }
}

