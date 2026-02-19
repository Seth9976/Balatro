package androidx.lifecycle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;

final class a {
    static class androidx.lifecycle.a.a {
        final Map a;
        final Map b;

        androidx.lifecycle.a.a(Map map0) {
            this.b = map0;
            this.a = new HashMap();
            for(Object object0: map0.entrySet()) {
                b h$b0 = (b)((Map.Entry)object0).getValue();
                List list0 = (List)this.a.get(h$b0);
                if(list0 == null) {
                    list0 = new ArrayList();
                    this.a.put(h$b0, list0);
                }
                list0.add(((androidx.lifecycle.a.b)((Map.Entry)object0).getKey()));
            }
        }

        void a(l l0, b h$b0, Object object0) {
            androidx.lifecycle.a.a.b(((List)this.a.get(h$b0)), l0, h$b0, object0);
            androidx.lifecycle.a.a.b(((List)this.a.get(b.ON_ANY)), l0, h$b0, object0);
        }

        private static void b(List list0, l l0, b h$b0, Object object0) {
            if(list0 != null) {
                for(int v = list0.size() - 1; v >= 0; --v) {
                    ((androidx.lifecycle.a.b)list0.get(v)).a(l0, h$b0, object0);
                }
            }
        }
    }

    static final class androidx.lifecycle.a.b {
        final int a;
        final Method b;

        androidx.lifecycle.a.b(int v, Method method0) {
            this.a = v;
            this.b = method0;
            method0.setAccessible(true);
        }

        void a(l l0, b h$b0, Object object0) {
            try {
                switch(this.a) {
                    case 0: {
                        this.b.invoke(object0);
                        return;
                    }
                    case 1: {
                        this.b.invoke(object0, l0);
                        return;
                    }
                    case 2: {
                        this.b.invoke(object0, l0, h$b0);
                    }
                }
            }
            catch(InvocationTargetException invocationTargetException0) {
                throw new RuntimeException("Failed to call observer method", invocationTargetException0.getCause());
            }
            catch(IllegalAccessException illegalAccessException0) {
                throw new RuntimeException(illegalAccessException0);
            }
        }

        @Override
        public boolean equals(Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof androidx.lifecycle.a.b ? this.a == ((androidx.lifecycle.a.b)object0).a && this.b.getName().equals(((androidx.lifecycle.a.b)object0).b.getName()) : false;
        }

        @Override
        public int hashCode() {
            int v = this.b.getName().hashCode();
            return this.a * 0x1F + v;
        }
    }

    private final Map a;
    private final Map b;
    static a c;

    static {
        a.c = new a();
    }

    a() {
        this.a = new HashMap();
        this.b = new HashMap();
    }

    private androidx.lifecycle.a.a a(Class class0, Method[] arr_method) {
        int v2;
        Class class1 = class0.getSuperclass();
        HashMap hashMap0 = new HashMap();
        if(class1 != null) {
            androidx.lifecycle.a.a a$a0 = this.c(class1);
            if(a$a0 != null) {
                hashMap0.putAll(a$a0.b);
            }
        }
        Class[] arr_class = class0.getInterfaces();
        for(int v = 0; v < arr_class.length; ++v) {
            for(Object object0: this.c(arr_class[v]).b.entrySet()) {
                this.e(hashMap0, ((androidx.lifecycle.a.b)((Map.Entry)object0).getKey()), ((b)((Map.Entry)object0).getValue()), class0);
            }
        }
        if(arr_method == null) {
            arr_method = this.b(class0);
        }
        boolean z = false;
        for(int v1 = 0; v1 < arr_method.length; ++v1) {
            Method method0 = arr_method[v1];
            r r0 = (r)method0.getAnnotation(r.class);
            if(r0 != null) {
                Class[] arr_class1 = method0.getParameterTypes();
                if(arr_class1.length > 0) {
                    if(!arr_class1[0].isAssignableFrom(l.class)) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    v2 = 1;
                }
                else {
                    v2 = 0;
                }
                b h$b0 = r0.value();
                if(arr_class1.length > 1) {
                    if(!arr_class1[1].isAssignableFrom(b.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if(h$b0 != b.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    v2 = 2;
                }
                if(arr_class1.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                this.e(hashMap0, new androidx.lifecycle.a.b(v2, method0), h$b0, class0);
                z = true;
            }
        }
        androidx.lifecycle.a.a a$a1 = new androidx.lifecycle.a.a(hashMap0);
        this.a.put(class0, a$a1);
        this.b.put(class0, Boolean.valueOf(z));
        return a$a1;
    }

    private Method[] b(Class class0) {
        try {
            return class0.getDeclaredMethods();
        }
        catch(NoClassDefFoundError noClassDefFoundError0) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", noClassDefFoundError0);
        }
    }

    androidx.lifecycle.a.a c(Class class0) {
        androidx.lifecycle.a.a a$a0 = (androidx.lifecycle.a.a)this.a.get(class0);
        return a$a0 == null ? this.a(class0, null) : a$a0;
    }

    boolean d(Class class0) {
        Boolean boolean0 = (Boolean)this.b.get(class0);
        if(boolean0 != null) {
            return boolean0.booleanValue();
        }
        Method[] arr_method = this.b(class0);
        for(int v = 0; v < arr_method.length; ++v) {
            if(((r)arr_method[v].getAnnotation(r.class)) != null) {
                this.a(class0, arr_method);
                return true;
            }
        }
        this.b.put(class0, Boolean.FALSE);
        return false;
    }

    private void e(Map map0, androidx.lifecycle.a.b a$b0, b h$b0, Class class0) {
        b h$b1 = (b)map0.get(a$b0);
        if(h$b1 != null && h$b0 != h$b1) {
            throw new IllegalArgumentException("Method " + a$b0.b.getName() + " in " + class0.getName() + " already declared with different @OnLifecycleEvent value: previous value " + h$b1 + ", new value " + h$b0);
        }
        if(h$b1 == null) {
            map0.put(a$b0, h$b0);
        }
    }
}

