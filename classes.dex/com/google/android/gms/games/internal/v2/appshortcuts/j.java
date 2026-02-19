package com.google.android.gms.games.internal.v2.appshortcuts;

import g2.i;
import java.util.List;
import s1.s;

public final class j implements e1.j {
    public final p a;
    public final s b;
    public final List c;
    public final List d;

    public j(p p0, s s0, List list0, List list1) {
        this.a = p0;
        this.b = s0;
        this.c = list0;
        this.d = list1;
    }

    @Override  // e1.j
    public final void a(Object object0, Object object1) {
        ((r)((q)object0).C()).W(new m(this.a, ((i)object1)), this.b, this.c, this.d);
    }
}

