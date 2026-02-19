package n2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import p2.d;

public final class e {
    private d a;
    private n b;
    private c c;
    private final Map d;
    private final List e;
    private final List f;
    private boolean g;
    private String h;
    private int i;
    private int j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private q r;
    private q s;
    private final LinkedList t;

    public e() {
        this.a = d.k;
        this.b = n.e;
        this.c = b.e;
        this.d = new HashMap();
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = false;
        this.h = n2.d.z;
        this.i = 2;
        this.j = 2;
        this.k = false;
        this.l = false;
        this.m = true;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = true;
        this.r = n2.d.B;
        this.s = n2.d.C;
        this.t = new LinkedList();
    }

    private void a(String s, int v, int v1, List list0) {
        s s3;
        s s2;
        boolean z = t2.d.a;
        s s1 = null;
        if(s != null && !s.trim().isEmpty()) {
            s2 = q2.d.b.b.b(s);
            if(z) {
                s1 = t2.d.c.b(s);
                s3 = t2.d.b.b(s);
            }
            else {
                s3 = null;
            }
            goto label_19;
        }
        else if(v != 2 && v1 != 2) {
            s s4 = q2.d.b.b.a(v, v1);
            if(z) {
                s1 = t2.d.c.a(v, v1);
                s2 = s4;
                s3 = t2.d.b.a(v, v1);
            }
            else {
                s2 = s4;
                s3 = null;
            }
        label_19:
            list0.add(s2);
            if(z) {
                list0.add(s1);
                list0.add(s3);
            }
        }
    }

    public n2.d b() {
        ArrayList arrayList0 = new ArrayList(this.e.size() + this.f.size() + 3);
        arrayList0.addAll(this.e);
        Collections.reverse(arrayList0);
        ArrayList arrayList1 = new ArrayList(this.f);
        Collections.reverse(arrayList1);
        arrayList0.addAll(arrayList1);
        this.a(this.h, this.i, this.j, arrayList0);
        return new n2.d(this.a, this.c, new HashMap(this.d), this.g, this.k, this.o, this.m, this.n, this.p, this.l, this.q, this.b, this.h, this.i, this.j, new ArrayList(this.e), new ArrayList(this.f), arrayList0, this.r, this.s, new ArrayList(this.t));
    }

    public e c(q q0) {
        Objects.requireNonNull(q0);
        this.r = q0;
        return this;
    }
}

