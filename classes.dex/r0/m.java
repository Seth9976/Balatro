package r0;

import android.database.sqlite.SQLiteDatabase;

public final class m implements b {
    public final String a;
    public final m0.c.b b;
    public final long c;

    public m(String s, m0.c.b c$b0, long v) {
        this.a = s;
        this.b = c$b0;
        this.c = v;
    }

    @Override  // r0.m0$b
    public final Object a(Object object0) {
        return m0.v0(this.a, this.b, this.c, ((SQLiteDatabase)object0));
    }
}

