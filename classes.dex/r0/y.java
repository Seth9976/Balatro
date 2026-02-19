package r0;

import android.database.Cursor;
import j0.o;
import java.util.List;

public final class y implements b {
    public final m0 a;
    public final List b;
    public final o c;

    public y(m0 m00, List list0, o o0) {
        this.a = m00;
        this.b = list0;
        this.c = o0;
    }

    @Override  // r0.m0$b
    public final Object a(Object object0) {
        return this.a.o0(this.b, this.c, ((Cursor)object0));
    }
}

