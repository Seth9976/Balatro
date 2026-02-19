package r0;

import android.database.Cursor;
import java.util.Map;
import m0.a.a;

public final class b0 implements b {
    public final m0 a;
    public final Map b;
    public final a c;

    public b0(m0 m00, Map map0, a a$a0) {
        this.a = m00;
        this.b = map0;
        this.c = a$a0;
    }

    @Override  // r0.m0$b
    public final Object a(Object object0) {
        return this.a.m0(this.b, this.c, ((Cursor)object0));
    }
}

