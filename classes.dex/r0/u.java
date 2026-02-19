package r0;

import android.database.sqlite.SQLiteDatabase;
import java.util.Map;
import m0.a.a;

public final class u implements b {
    public final m0 a;
    public final String b;
    public final Map c;
    public final a d;

    public u(m0 m00, String s, Map map0, a a$a0) {
        this.a = m00;
        this.b = s;
        this.c = map0;
        this.d = a$a0;
    }

    @Override  // r0.m0$b
    public final Object a(Object object0) {
        return this.a.n0(this.b, this.c, this.d, ((SQLiteDatabase)object0));
    }
}

