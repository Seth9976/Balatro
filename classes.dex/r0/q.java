package r0;

import android.database.sqlite.SQLiteDatabase;

public final class q implements b {
    public final m0 a;
    public final String b;
    public final String c;

    public q(m0 m00, String s, String s1) {
        this.a = m00;
        this.b = s;
        this.c = s1;
    }

    @Override  // r0.m0$b
    public final Object a(Object object0) {
        return this.a.t0(this.b, this.c, ((SQLiteDatabase)object0));
    }
}

