package t3;

import b3.b;
import c3.j;
import c3.n;
import c3.q;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import k3.f;
import q3.l;
import q3.m;

public final class a {
    public static final a a;

    static {
        a.a = new a();
    }

    private final Object a(String s, ClassLoader classLoader0, Class class0) {
        Class class1 = Class.forName(s, false, classLoader0);
        if(!class0.isAssignableFrom(class1)) {
            throw new IllegalArgumentException(("Expected service of class " + class0 + ", but found " + class1).toString());
        }
        return class0.cast(class1.getDeclaredConstructor().newInstance());
    }

    private final List b(Class class0, ClassLoader classLoader0) {
        try {
            return this.d(class0, classLoader0);
        }
        catch(Throwable unused_ex) {
            return q.k(ServiceLoader.load(class0, classLoader0));
        }
    }

    // 去混淆评级： 低(30)
    public final List c() {
        return this.b(g.class, g.class.getClassLoader());
    }

    public final List d(Class class0, ClassLoader classLoader0) {
        ArrayList arrayList0 = Collections.list(classLoader0.getResources(f.j("META-INF/services/", class0.getName())));
        f.d(arrayList0, "list(this)");
        ArrayList arrayList1 = new ArrayList();
        for(Object object0: arrayList0) {
            n.g(arrayList1, a.a.e(((URL)object0)));
        }
        Set set0 = q.n(arrayList1);
        if(!set0.isEmpty() == 0) {
            throw new IllegalArgumentException("No providers were loaded with FastServiceLoader");
        }
        List list0 = new ArrayList(j.f(set0, 10));
        for(Object object1: set0) {
            list0.add(a.a.a(((String)object1), classLoader0, class0));
        }
        return list0;
    }

    private final List e(URL uRL0) {
        List list1;
        List list0;
        String s = uRL0.toString();
        if(l.e(s, "jar", false, 2, null)) {
            String s1 = m.x(m.s(s, "jar:file:", null, 2, null), '!', null, 2, null);
            String s2 = m.s(s, "!/", null, 2, null);
            JarFile jarFile0 = new JarFile(s1, false);
            try {
                BufferedReader bufferedReader0 = new BufferedReader(new InputStreamReader(jarFile0.getInputStream(new ZipEntry(s2)), "UTF-8"));
                try {
                    list0 = a.a.f(bufferedReader0);
                }
                catch(Throwable throwable1) {
                    h3.a.a(bufferedReader0, throwable1);
                    throw throwable1;
                }
                h3.a.a(bufferedReader0, null);
            }
            catch(Throwable throwable0) {
                try {
                    jarFile0.close();
                }
                catch(Throwable throwable2) {
                    b.a(throwable0, throwable2);
                    throw throwable0;
                }
                throw throwable0;
            }
            jarFile0.close();
            return list0;
        }
        BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(uRL0.openStream()));
        try {
            list1 = a.a.f(bufferedReader1);
        }
        catch(Throwable throwable3) {
            h3.a.a(bufferedReader1, throwable3);
            throw throwable3;
        }
        h3.a.a(bufferedReader1, null);
        return list1;
    }

    private final List f(BufferedReader bufferedReader0) {
        String s1;
        LinkedHashSet linkedHashSet0 = new LinkedHashSet();
        while(true) {
            String s = bufferedReader0.readLine();
            if(s == null) {
                return q.k(linkedHashSet0);
            }
            boolean z = true;
            s1 = m.z(m.y(s, "#", null, 2, null)).toString();
            for(int v = 0; v < s1.length(); ++v) {
                int v1 = s1.charAt(v);
                if(v1 != 46 && !Character.isJavaIdentifierPart(((char)v1))) {
                    z = false;
                    break;
                }
            }
            if(!z) {
                break;
            }
            if(s1.length() > 0) {
                linkedHashSet0.add(s1);
            }
        }
        throw new IllegalArgumentException(("Illegal service provider class name: " + s1).toString());
    }
}

