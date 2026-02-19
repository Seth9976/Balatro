package androidx.lifecycle;

import h.d;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class n {
    private static Map a;
    private static Map b;

    static {
        n.a = new HashMap();
        n.b = new HashMap();
    }

    private static f a(Constructor constructor0, Object object0) {
        try {
            d.a(constructor0.newInstance(object0));
            return null;
        }
        catch(IllegalAccessException illegalAccessException0) {
            throw new RuntimeException(illegalAccessException0);
        }
        catch(InstantiationException instantiationException0) {
            throw new RuntimeException(instantiationException0);
        }
        catch(InvocationTargetException invocationTargetException0) {
            throw new RuntimeException(invocationTargetException0);
        }
    }

    private static Constructor b(Class class0) {
        try {
            Package package0 = class0.getPackage();
            String s = class0.getCanonicalName();
            String s1 = package0 == null ? "" : package0.getName();
            if(!s1.isEmpty()) {
                s = s.substring(s1.length() + 1);
            }
            String s2 = n.c(s);
            if(!s1.isEmpty()) {
                s2 = s1 + "." + s2;
            }
            Constructor constructor0 = Class.forName(s2).getDeclaredConstructor(class0);
            if(!constructor0.isAccessible()) {
                constructor0.setAccessible(true);
            }
            return constructor0;
        }
        catch(ClassNotFoundException unused_ex) {
            return null;
        }
        catch(NoSuchMethodException noSuchMethodException0) {
            throw new RuntimeException(noSuchMethodException0);
        }
    }

    public static String c(String s) {
        return s.replace(".", "_") + "_LifecycleAdapter";
    }

    private static int d(Class class0) {
        Integer integer0 = (Integer)n.a.get(class0);
        if(integer0 != null) {
            return (int)integer0;
        }
        int v = n.g(class0);
        n.a.put(class0, v);
        return v;
    }

    private static boolean e(Class class0) {
        return class0 != null && k.class.isAssignableFrom(class0);
    }

    static j f(Object object0) {
        if(object0 instanceof j && object0 instanceof e) {
            return new FullLifecycleObserverAdapter(((e)object0), ((j)object0));
        }
        if(object0 instanceof e) {
            return new FullLifecycleObserverAdapter(((e)object0), null);
        }
        if(object0 instanceof j) {
            return (j)object0;
        }
        Class class0 = object0.getClass();
        if(n.d(class0) == 2) {
            List list0 = (List)n.b.get(class0);
            if(list0.size() == 1) {
                n.a(((Constructor)list0.get(0)), object0);
                return new SingleGeneratedAdapterObserver(null);
            }
            f[] arr_f = new f[list0.size()];
            for(int v = 0; v < list0.size(); ++v) {
                n.a(((Constructor)list0.get(v)), object0);
                arr_f[v] = null;
            }
            return new CompositeGeneratedAdaptersObserver(arr_f);
        }
        return new ReflectiveGenericLifecycleObserver(object0);
    }

    private static int g(Class class0) {
        ArrayList arrayList0;
        if(class0.getCanonicalName() == null) {
            return 1;
        }
        Constructor constructor0 = n.b(class0);
        if(constructor0 != null) {
            n.b.put(class0, Collections.singletonList(constructor0));
            return 2;
        }
        if(a.c.d(class0)) {
            return 1;
        }
        Class class1 = class0.getSuperclass();
        if(n.e(class1)) {
            if(n.d(class1) == 1) {
                return 1;
            }
            arrayList0 = new ArrayList(((Collection)n.b.get(class1)));
        }
        else {
            arrayList0 = null;
        }
        Class[] arr_class = class0.getInterfaces();
        for(int v = 0; v < arr_class.length; ++v) {
            Class class2 = arr_class[v];
            if(n.e(class2)) {
                if(n.d(class2) == 1) {
                    return 1;
                }
                if(arrayList0 == null) {
                    arrayList0 = new ArrayList();
                }
                arrayList0.addAll(((Collection)n.b.get(class2)));
            }
        }
        if(arrayList0 != null) {
            n.b.put(class0, arrayList0);
            return 2;
        }
        return 1;
    }
}

