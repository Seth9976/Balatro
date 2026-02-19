package k3;

import c3.i;
import c3.y;
import c3.z;
import j3.c;
import j3.e;
import j3.f;
import j3.g;
import j3.h;
import j3.j;
import j3.k;
import j3.l;
import j3.m;
import j3.n;
import j3.o;
import j3.p;
import j3.q;
import j3.r;
import j3.s;
import j3.t;
import j3.u;
import j3.v;
import j3.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;

public final class b implements a, o3.a {
    public static final class k3.b.a {
        private k3.b.a() {
        }

        public k3.b.a(d d0) {
        }
    }

    private final Class a;
    public static final k3.b.a b;
    private static final Map c;
    private static final HashMap d;
    private static final HashMap e;
    private static final HashMap f;
    private static final Map g;

    static {
        b.b = new k3.b.a(null);
        int v = 0;
        List list0 = i.c(new Class[]{j3.a.class, l.class, p.class, q.class, r.class, s.class, t.class, u.class, v.class, w.class, j3.b.class, c.class, j3.d.class, e.class, f.class, g.class, h.class, j3.i.class, j.class, k.class, m.class, n.class, o.class});
        ArrayList arrayList0 = new ArrayList(c3.j.f(list0, 10));
        for(Object object0: list0) {
            if(v < 0) {
                i.e();
            }
            arrayList0.add(b3.l.a(((Class)object0), v));
            ++v;
        }
        b.c = z.g(arrayList0);
        HashMap hashMap0 = new HashMap();
        hashMap0.put("boolean", "kotlin.Boolean");
        hashMap0.put("char", "kotlin.Char");
        hashMap0.put("byte", "kotlin.Byte");
        hashMap0.put("short", "kotlin.Short");
        hashMap0.put("int", "kotlin.Int");
        hashMap0.put("float", "kotlin.Float");
        hashMap0.put("long", "kotlin.Long");
        hashMap0.put("double", "kotlin.Double");
        b.d = hashMap0;
        HashMap hashMap1 = new HashMap();
        hashMap1.put("java.lang.Boolean", "kotlin.Boolean");
        hashMap1.put("java.lang.Character", "kotlin.Char");
        hashMap1.put("java.lang.Byte", "kotlin.Byte");
        hashMap1.put("java.lang.Short", "kotlin.Short");
        hashMap1.put("java.lang.Integer", "kotlin.Int");
        hashMap1.put("java.lang.Float", "kotlin.Float");
        hashMap1.put("java.lang.Long", "kotlin.Long");
        hashMap1.put("java.lang.Double", "kotlin.Double");
        b.e = hashMap1;
        HashMap hashMap2 = new HashMap();
        hashMap2.put("java.lang.Object", "kotlin.Any");
        hashMap2.put("java.lang.String", "kotlin.String");
        hashMap2.put("java.lang.CharSequence", "kotlin.CharSequence");
        hashMap2.put("java.lang.Throwable", "kotlin.Throwable");
        hashMap2.put("java.lang.Cloneable", "kotlin.Cloneable");
        hashMap2.put("java.lang.Number", "kotlin.Number");
        hashMap2.put("java.lang.Comparable", "kotlin.Comparable");
        hashMap2.put("java.lang.Enum", "kotlin.Enum");
        hashMap2.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        hashMap2.put("java.lang.Iterable", "kotlin.collections.Iterable");
        hashMap2.put("java.util.Iterator", "kotlin.collections.Iterator");
        hashMap2.put("java.util.Collection", "kotlin.collections.Collection");
        hashMap2.put("java.util.List", "kotlin.collections.List");
        hashMap2.put("java.util.Set", "kotlin.collections.Set");
        hashMap2.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        hashMap2.put("java.util.Map", "kotlin.collections.Map");
        hashMap2.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        hashMap2.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        hashMap2.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        hashMap2.putAll(hashMap0);
        hashMap2.putAll(hashMap1);
        Collection collection0 = hashMap0.values();
        k3.f.d(collection0, "primitiveFqNames.values");
        for(Object object1: collection0) {
            k3.f.d(((String)object1), "kotlinName");
            b3.h h0 = b3.l.a(("kotlin.jvm.internal." + q3.m.u(((String)object1), '.', null, 2, null) + "CompanionObject"), ((String)object1) + ".Companion");
            hashMap2.put(h0.c(), h0.d());
        }
        for(Object object2: b.c.entrySet()) {
            hashMap2.put(((Class)((Map.Entry)object2).getKey()).getName(), "kotlin.Function" + ((Number)((Map.Entry)object2).getValue()).intValue());
        }
        b.f = hashMap2;
        LinkedHashMap linkedHashMap0 = new LinkedHashMap(y.a(hashMap2.size()));
        for(Object object3: hashMap2.entrySet()) {
            linkedHashMap0.put(((Map.Entry)object3).getKey(), q3.m.u(((String)((Map.Entry)object3).getValue()), '.', null, 2, null));
        }
        b.g = linkedHashMap0;
    }

    public b(Class class0) {
        k3.f.e(class0, "jClass");
        super();
        this.a = class0;
    }

    @Override  // k3.a
    public Class a() {
        return this.a;
    }

    // 去混淆评级： 低(20)
    @Override
    public boolean equals(Object object0) {
        return object0 instanceof b && k3.f.a(i3.a.b(this), i3.a.b(((o3.a)object0)));
    }

    @Override
    public int hashCode() {
        return i3.a.b(this).hashCode();
    }

    @Override
    public String toString() {
        return this.a().toString() + " (Kotlin reflection is not available)";
    }
}

