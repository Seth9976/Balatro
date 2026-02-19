package p2;

import h.d;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import n2.h;
import n2.o;
import u2.a;

public final class c {
    private final Map a;
    private final boolean b;
    private final List c;

    public c(Map map0, boolean z, List list0) {
        this.a = map0;
        this.b = z;
        this.c = list0;
    }

    static String a(Class class0) {
        String s;
        StringBuilder stringBuilder0;
        int v = class0.getModifiers();
        if(Modifier.isInterface(v)) {
            stringBuilder0 = new StringBuilder();
            s = "Interfaces can\'t be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Interface name: ";
        }
        else if(Modifier.isAbstract(v)) {
            stringBuilder0 = new StringBuilder();
            s = "Abstract classes can\'t be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Class name: ";
        }
        else {
            return null;
        }
        stringBuilder0.append(s);
        stringBuilder0.append(class0.getName());
        return stringBuilder0.toString();
    }

    public i b(a a0) {
        class l implements i {
            final String a;
            final c b;

            l(String s) {
                this.a = s;
                super();
            }

            @Override  // p2.i
            public Object a() {
                throw new h(this.a);
            }
        }


        class m implements i {
            final String a;
            final c b;

            m(String s) {
                this.a = s;
                super();
            }

            @Override  // p2.i
            public Object a() {
                throw new h(this.a);
            }
        }

        Type type0 = a0.d();
        Class class0 = a0.c();
        d.a(this.a.get(type0));
        d.a(this.a.get(class0));
        i i0 = c.e(type0, class0);
        if(i0 != null) {
            return i0;
        }
        o o0 = p2.l.b(this.c, class0);
        i i1 = c.c(class0, o0);
        if(i1 != null) {
            return i1;
        }
        i i2 = c.d(type0, class0);
        if(i2 != null) {
            return i2;
        }
        String s = c.a(class0);
        if(s != null) {
            return new l(this, s);
        }
        return o0 == o.e ? this.f(class0) : new m(this, "Unable to create instance of " + class0 + "; ReflectionAccessFilter does not permit using reflection or Unsafe. Register an InstanceCreator or a TypeAdapter for this type or adjust the access filter to allow using reflection.");
    }

    private static i c(Class class0, o o0) {
        class p implements i {
            final String a;

            p(String s) {
            }

            @Override  // p2.i
            public Object a() {
                throw new h(this.a);
            }
        }


        class q implements i {
            final String a;

            q(String s) {
            }

            @Override  // p2.i
            public Object a() {
                throw new h(this.a);
            }
        }


        class r implements i {
            final Constructor a;

            r(Constructor constructor0) {
            }

            @Override  // p2.i
            public Object a() {
                try {
                    return this.a.newInstance();
                }
                catch(InstantiationException instantiationException0) {
                    throw new RuntimeException("Failed to invoke constructor \'" + s2.a.c(this.a) + "\' with no args", instantiationException0);
                }
                catch(InvocationTargetException invocationTargetException0) {
                    throw new RuntimeException("Failed to invoke constructor \'" + s2.a.c(this.a) + "\' with no args", invocationTargetException0.getCause());
                }
                catch(IllegalAccessException illegalAccessException0) {
                    throw s2.a.e(illegalAccessException0);
                }
            }
        }

        Constructor constructor0;
        if(Modifier.isAbstract(class0.getModifiers())) {
            return null;
        }
        try {
            constructor0 = class0.getDeclaredConstructor();
        }
        catch(NoSuchMethodException unused_ex) {
            return null;
        }
        o o1 = o.e;
        if(o0 != o1 && (!p2.l.a(constructor0, null) || o0 == o.h && !Modifier.isPublic(constructor0.getModifiers()))) {
            return new p("Unable to invoke no-args constructor of " + class0 + "; constructor is not accessible and ReflectionAccessFilter does not permit making it accessible. Register an InstanceCreator or a TypeAdapter for this type, change the visibility of the constructor or adjust the access filter.");
        }
        if(o0 == o1) {
            String s = s2.a.m(constructor0);
            if(s != null) {
                return new q(s);
            }
        }
        return new r(constructor0);
    }

    private static i d(Type type0, Class class0) {
        class p2.c.a implements i {
            p2.c.a() {
                super();
            }

            @Override  // p2.i
            public Object a() {
                return new TreeSet();
            }
        }


        class b implements i {
            b() {
                super();
            }

            @Override  // p2.i
            public Object a() {
                return new LinkedHashSet();
            }
        }


        class p2.c.c implements i {
            p2.c.c() {
                super();
            }

            @Override  // p2.i
            public Object a() {
                return new ArrayDeque();
            }
        }


        class p2.c.d implements i {
            p2.c.d() {
                super();
            }

            @Override  // p2.i
            public Object a() {
                return new ArrayList();
            }
        }


        class e implements i {
            e() {
                super();
            }

            @Override  // p2.i
            public Object a() {
                return new ConcurrentSkipListMap();
            }
        }


        class f implements i {
            f() {
                super();
            }

            @Override  // p2.i
            public Object a() {
                return new ConcurrentHashMap();
            }
        }


        class g implements i {
            g() {
                super();
            }

            @Override  // p2.i
            public Object a() {
                return new TreeMap();
            }
        }


        class p2.c.h implements i {
            p2.c.h() {
                super();
            }

            @Override  // p2.i
            public Object a() {
                return new LinkedHashMap();
            }
        }


        class p2.c.i implements i {
            p2.c.i() {
                super();
            }

            @Override  // p2.i
            public Object a() {
                return new p2.h();
            }
        }

        if(Collection.class.isAssignableFrom(class0)) {
            if(SortedSet.class.isAssignableFrom(class0)) {
                return new p2.c.a();
            }
            if(Set.class.isAssignableFrom(class0)) {
                return new b();
            }
            return Queue.class.isAssignableFrom(class0) ? new p2.c.c() : new p2.c.d();
        }
        if(Map.class.isAssignableFrom(class0)) {
            if(ConcurrentNavigableMap.class.isAssignableFrom(class0)) {
                return new e();
            }
            if(ConcurrentMap.class.isAssignableFrom(class0)) {
                return new f();
            }
            if(SortedMap.class.isAssignableFrom(class0)) {
                return new g();
            }
            if(type0 instanceof ParameterizedType) {
                Class class1 = a.b(((ParameterizedType)type0).getActualTypeArguments()[0]).c();
                if(!String.class.isAssignableFrom(class1)) {
                    return new p2.c.h();
                }
            }
            return new p2.c.i();
        }
        return null;
    }

    private static i e(Type type0, Class class0) {
        class n implements i {
            final Type a;

            n(Type type0) {
            }

            @Override  // p2.i
            public Object a() {
                Type type0 = this.a;
                if(!(type0 instanceof ParameterizedType)) {
                    throw new h("Invalid EnumSet type: " + this.a.toString());
                }
                Type type1 = ((ParameterizedType)type0).getActualTypeArguments()[0];
                if(!(type1 instanceof Class)) {
                    throw new h("Invalid EnumSet type: " + this.a.toString());
                }
                return EnumSet.noneOf(((Class)type1));
            }
        }


        class p2.c.o implements i {
            final Type a;

            p2.c.o(Type type0) {
            }

            @Override  // p2.i
            public Object a() {
                Type type0 = this.a;
                if(!(type0 instanceof ParameterizedType)) {
                    throw new h("Invalid EnumMap type: " + this.a.toString());
                }
                Type type1 = ((ParameterizedType)type0).getActualTypeArguments()[0];
                if(!(type1 instanceof Class)) {
                    throw new h("Invalid EnumMap type: " + this.a.toString());
                }
                return new EnumMap(((Class)type1));
            }
        }

        if(EnumSet.class.isAssignableFrom(class0)) {
            return new n(type0);
        }
        return class0 == EnumMap.class ? new p2.c.o(type0) : null;
    }

    private i f(Class class0) {
        class j implements i {
            final Class a;
            final c b;

            j(Class class0) {
                this.a = class0;
                super();
            }

            @Override  // p2.i
            public Object a() {
                try {
                    return p2.n.a.d(this.a);
                }
                catch(Exception exception0) {
                    throw new RuntimeException("Unable to create instance of " + this.a + ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem.", exception0);
                }
            }
        }


        class k implements i {
            final String a;
            final c b;

            k(String s) {
                this.a = s;
                super();
            }

            @Override  // p2.i
            public Object a() {
                throw new h(this.a);
            }
        }

        return this.b ? new j(this, class0) : new k(this, "Unable to create instance of " + class0 + "; usage of JDK Unsafe is disabled. Registering an InstanceCreator or a TypeAdapter for this type, adding a no-args constructor, or enabling usage of JDK Unsafe may fix this problem.");
    }

    @Override
    public String toString() {
        return this.a.toString();
    }
}

