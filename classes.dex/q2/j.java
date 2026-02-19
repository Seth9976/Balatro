package q2;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import n2.h;
import n2.k;
import n2.m;
import n2.o;
import n2.r;
import n2.s;
import p2.i;
import p2.l;
import v2.a;

public final class j implements s {
    public static abstract class b extends r {
        final Map a;

        b(Map map0) {
            this.a = map0;
        }

        @Override  // n2.r
        public Object b(a a0) {
            if(a0.E() == v2.b.m) {
                a0.y();
                return null;
            }
            Object object0 = this.e();
            try {
                a0.b();
                while(a0.l()) {
                    String s = a0.v();
                    c j$c0 = (c)this.a.get(s);
                    if(j$c0 != null && j$c0.e) {
                        this.g(object0, a0, j$c0);
                    }
                    else {
                        a0.Q();
                    }
                }
            }
            catch(IllegalStateException illegalStateException0) {
                throw new m(illegalStateException0);
            }
            catch(IllegalAccessException illegalAccessException0) {
                throw s2.a.e(illegalAccessException0);
            }
            a0.g();
            return this.f(object0);
        }

        @Override  // n2.r
        public void d(v2.c c0, Object object0) {
            if(object0 == null) {
                c0.n();
                return;
            }
            c0.d();
            try {
                for(Object object1: this.a.values()) {
                    ((c)object1).c(c0, object0);
                }
            }
            catch(IllegalAccessException illegalAccessException0) {
                throw s2.a.e(illegalAccessException0);
            }
            c0.g();
        }

        abstract Object e();

        abstract Object f(Object arg1);

        abstract void g(Object arg1, a arg2, c arg3);
    }

    static abstract class c {
        final String a;
        final Field b;
        final String c;
        final boolean d;
        final boolean e;

        protected c(String s, Field field0, boolean z, boolean z1) {
            this.a = s;
            this.b = field0;
            this.c = field0.getName();
            this.d = z;
            this.e = z1;
        }

        abstract void a(a arg1, int arg2, Object[] arg3);

        abstract void b(a arg1, Object arg2);

        abstract void c(v2.c arg1, Object arg2);
    }

    static final class d extends b {
        private final i b;

        d(i i0, Map map0) {
            super(map0);
            this.b = i0;
        }

        @Override  // q2.j$b
        Object e() {
            return this.b.a();
        }

        @Override  // q2.j$b
        Object f(Object object0) {
            return object0;
        }

        @Override  // q2.j$b
        void g(Object object0, a a0, c j$c0) {
            j$c0.b(a0, object0);
        }
    }

    static final class e extends b {
        private final Constructor b;
        private final Object[] c;
        private final Map d;
        static final Map e;

        static {
            e.e = e.j();
        }

        e(Class class0, Map map0, boolean z) {
            super(map0);
            this.d = new HashMap();
            Constructor constructor0 = s2.a.i(class0);
            this.b = constructor0;
            if(z) {
                j.c(null, constructor0);
            }
            else {
                s2.a.l(constructor0);
            }
            String[] arr_s = s2.a.j(class0);
            for(int v1 = 0; v1 < arr_s.length; ++v1) {
                this.d.put(arr_s[v1], v1);
            }
            Class[] arr_class = this.b.getParameterTypes();
            this.c = new Object[arr_class.length];
            for(int v = 0; v < arr_class.length; ++v) {
                this.c[v] = e.e.get(arr_class[v]);
            }
        }

        @Override  // q2.j$b
        Object e() {
            return this.h();
        }

        @Override  // q2.j$b
        Object f(Object object0) {
            return this.i(((Object[])object0));
        }

        @Override  // q2.j$b
        void g(Object object0, a a0, c j$c0) {
            this.k(((Object[])object0), a0, j$c0);
        }

        Object[] h() {
            return (Object[])this.c.clone();
        }

        Object i(Object[] arr_object) {
            try {
                return this.b.newInstance(arr_object);
            }
            catch(IllegalAccessException illegalAccessException0) {
                throw s2.a.e(illegalAccessException0);
            }
            catch(InstantiationException | IllegalArgumentException instantiationException0) {
                throw new RuntimeException("Failed to invoke constructor \'" + s2.a.c(this.b) + "\' with args " + Arrays.toString(arr_object), instantiationException0);
            }
            catch(InvocationTargetException invocationTargetException0) {
                throw new RuntimeException("Failed to invoke constructor \'" + s2.a.c(this.b) + "\' with args " + Arrays.toString(arr_object), invocationTargetException0.getCause());
            }
        }

        private static Map j() {
            Map map0 = new HashMap();
            map0.put(Byte.TYPE, ((byte)0));
            map0.put(Short.TYPE, ((short)0));
            map0.put(Integer.TYPE, 0);
            map0.put(Long.TYPE, 0L);
            map0.put(Float.TYPE, 0.0f);
            map0.put(Double.TYPE, 0.0);
            map0.put(Character.TYPE, Character.valueOf('\u0000'));
            map0.put(Boolean.TYPE, Boolean.FALSE);
            return map0;
        }

        void k(Object[] arr_object, a a0, c j$c0) {
            Integer integer0 = (Integer)this.d.get(j$c0.c);
            if(integer0 == null) {
                throw new IllegalStateException("Could not find the index in the constructor \'" + s2.a.c(this.b) + "\' for field with name \'" + j$c0.c + "\', unable to determine which argument in the constructor the field corresponds to. This is unexpected behavior, as we expect the RecordComponents to have the same names as the fields in the Java class, and that the order of the RecordComponents is the same as the order of the canonical constructor parameters.");
            }
            j$c0.a(a0, ((int)integer0), arr_object);
        }
    }

    private final p2.c e;
    private final n2.c f;
    private final p2.d g;
    private final q2.e h;
    private final List i;

    public j(p2.c c0, n2.c c1, p2.d d0, q2.e e0, List list0) {
        this.e = c0;
        this.f = c1;
        this.g = d0;
        this.h = e0;
        this.i = list0;
    }

    @Override  // n2.s
    public r a(n2.d d0, u2.a a0) {
        Class class0 = a0.c();
        if(!Object.class.isAssignableFrom(class0)) {
            return null;
        }
        o o0 = l.b(this.i, class0);
        if(o0 == o.h) {
            throw new h("ReflectionAccessFilter does not permit using reflection for " + class0 + ". Register a TypeAdapter for this type or adjust the access filter.");
        }
        boolean z = o0 == o.g;
        return s2.a.k(class0) ? new e(class0, this.e(d0, a0, class0, z, true), z) : new d(this.e.b(a0), this.e(d0, a0, class0, z, false));
    }

    private static void c(Object object0, AccessibleObject accessibleObject0) {
        if(Modifier.isStatic(((Member)accessibleObject0).getModifiers())) {
            object0 = null;
        }
        if(!l.a(accessibleObject0, object0)) {
            throw new h(s2.a.g(accessibleObject0, true) + " is not accessible and ReflectionAccessFilter does not permit making it accessible. Register a TypeAdapter for the declaring type, adjust the access filter or increase the visibility of the element and its declaring type.");
        }
    }

    private c d(n2.d d0, Field field0, Method method0, String s, u2.a a0, boolean z, boolean z1, boolean z2) {
        class q2.j.a extends c {
            final boolean f;
            final Method g;
            final boolean h;
            final r i;
            final n2.d j;
            final u2.a k;
            final boolean l;
            final boolean m;
            final j n;

            q2.j.a(String s, Field field0, boolean z, boolean z1, boolean z2, Method method0, boolean z3, r r0, n2.d d0, u2.a a0, boolean z4, boolean z5) {
                this.f = z2;
                this.g = method0;
                this.h = z3;
                this.i = r0;
                this.j = d0;
                this.k = a0;
                this.l = z4;
                this.m = z5;
                super(s, field0, z, z1);
            }

            @Override  // q2.j$c
            void a(a a0, int v, Object[] arr_object) {
                Object object0 = this.i.b(a0);
                if(object0 == null && this.l) {
                    throw new k("null is not allowed as value for record component \'" + this.c + "\' of primitive type; at path " + a0.i());
                }
                arr_object[v] = object0;
            }

            @Override  // q2.j$c
            void b(a a0, Object object0) {
                Object object1 = this.i.b(a0);
                if(object1 != null || !this.l) {
                    if(this.f) {
                        j.c(object0, this.b);
                        this.b.set(object0, object1);
                        return;
                    }
                    if(this.m) {
                        throw new h("Cannot set value of \'static final\' " + s2.a.g(this.b, false));
                    }
                    this.b.set(object0, object1);
                }
            }

            @Override  // q2.j$c
            void c(v2.c c0, Object object0) {
                Object object1;
                if(!this.d) {
                    return;
                }
                if(this.f) {
                    Method method0 = this.g;
                    if(method0 == null) {
                        method0 = this.b;
                    }
                    j.c(object0, method0);
                }
                Method method1 = this.g;
                if(method1 == null) {
                    object1 = this.b.get(object0);
                }
                else {
                    try {
                        object1 = method1.invoke(object0);
                    }
                    catch(InvocationTargetException invocationTargetException0) {
                        throw new h("Accessor " + s2.a.g(this.g, false) + " threw exception", invocationTargetException0.getCause());
                    }
                }
                if(object1 == object0) {
                    return;
                }
                c0.l(this.a);
                r r0 = this.h ? this.i : new q2.l(this.j, this.i, this.k.d());
                r0.d(c0, object1);
            }
        }

        boolean z3 = p2.k.a(a0.c());
        int v = field0.getModifiers();
        boolean z4 = Modifier.isStatic(v) && Modifier.isFinal(v);
        o2.b b0 = (o2.b)field0.getAnnotation(o2.b.class);
        r r0 = b0 == null ? null : this.h.b(this.e, d0, a0, b0);
        boolean z5 = r0 != null;
        if(r0 == null) {
            r0 = d0.l(a0);
        }
        return new q2.j.a(this, s, field0, z, z1, z2, method0, z5, r0, d0, a0, z3, z4);
    }

    private Map e(n2.d d0, u2.a a0, Class class0, boolean z, boolean z1) {
        int v3;
        int v2;
        boolean z6;
        Method method0;
        Map map0 = new LinkedHashMap();
        if(class0.isInterface()) {
            return map0;
        }
        u2.a a1 = a0;
        boolean z2 = z;
        for(Class class1 = class0; class1 != Object.class; class1 = a1.c()) {
            Field[] arr_field = class1.getDeclaredFields();
            if(class1 != class0 && arr_field.length > 0) {
                o o0 = l.b(this.i, class1);
                if(o0 == o.h) {
                    throw new h("ReflectionAccessFilter does not permit using reflection for " + class1 + " (supertype of " + class0 + "). Register a TypeAdapter for this type or adjust the access filter.");
                }
                z2 = o0 == o.g;
            }
            boolean z3 = z2;
            int v = arr_field.length;
            int v1 = 0;
            while(v1 < v) {
                c j$c0 = null;
                Field field0 = arr_field[v1];
                boolean z4 = this.g(field0, true);
                boolean z5 = this.g(field0, false);
                if(z4 || z5) {
                    if(!z1) {
                        z6 = z5;
                        method0 = null;
                    }
                    else if(Modifier.isStatic(field0.getModifiers())) {
                        method0 = null;
                        z6 = false;
                    }
                    else {
                        Method method1 = s2.a.h(class1, field0);
                        if(!z3) {
                            s2.a.l(method1);
                        }
                        if(method1.getAnnotation(o2.c.class) != null && field0.getAnnotation(o2.c.class) == null) {
                            throw new h("@SerializedName on " + s2.a.g(method1, false) + " is not supported");
                        }
                        z6 = z5;
                        method0 = method1;
                    }
                    if(!z3 && method0 == null) {
                        s2.a.l(field0);
                    }
                    Type type0 = p2.b.o(a1.d(), class1, field0.getGenericType());
                    List list0 = this.f(field0);
                    int v4 = list0.size();
                    int v5 = false;
                    while(v5 < v4) {
                        Object object0 = list0.get(v5);
                        boolean z7 = v5 == 0 ? z4 : false;
                        c j$c1 = (c)map0.put(((String)object0), this.d(d0, field0, method0, ((String)object0), u2.a.b(type0), z7, z6, z3));
                        if(j$c0 == null) {
                            j$c0 = j$c1;
                        }
                        ++v5;
                        z4 = z7;
                    }
                    v2 = v1;
                    v3 = v;
                    if(j$c0 != null) {
                        throw new IllegalArgumentException("Class " + class0.getName() + " declares multiple JSON fields named \'" + j$c0.a + "\'; conflict is caused by fields " + s2.a.f(j$c0.b) + " and " + s2.a.f(field0));
                    }
                }
                else {
                    v2 = v1;
                    v3 = v;
                }
                v1 = v2 + 1;
                v = v3;
            }
            a1 = u2.a.b(p2.b.o(a1.d(), class1, class1.getGenericSuperclass()));
        }
        return map0;
    }

    private List f(Field field0) {
        o2.c c0 = (o2.c)field0.getAnnotation(o2.c.class);
        if(c0 == null) {
            return Collections.singletonList(this.f.c(field0));
        }
        String s = c0.value();
        String[] arr_s = c0.alternate();
        if(arr_s.length == 0) {
            return Collections.singletonList(s);
        }
        List list0 = new ArrayList(arr_s.length + 1);
        list0.add(s);
        Collections.addAll(list0, arr_s);
        return list0;
    }

    private boolean g(Field field0, boolean z) {
        Class class0 = field0.getType();
        return !this.g.d(class0, z) && !this.g.i(field0, z);
    }
}

