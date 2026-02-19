package c3;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import k3.f;

final class t implements Serializable, Map {
    public static final t e;

    static {
        t.e = new t();
    }

    public boolean a(Void void0) {
        f.e(void0, "value");
        return false;
    }

    public Void b(Object object0) [...] // Inlined contents

    public Set c() {
        return u.e;
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean containsKey(Object object0) {
        return false;
    }

    @Override
    public final boolean containsValue(Object object0) {
        return object0 instanceof Void ? this.a(((Void)object0)) : false;
    }

    public Set d() {
        return u.e;
    }

    public int e() [...] // Inlined contents

    @Override
    public final Set entrySet() {
        return this.c();
    }

    // 去混淆评级： 低(20)
    @Override
    public boolean equals(Object object0) {
        return object0 instanceof Map && ((Map)object0).isEmpty();
    }

    public Collection f() {
        return s.e;
    }

    public Void g(Object object0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public Object get(Object object0) {
        return null;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public final Set keySet() {
        return this.d();
    }

    @Override
    public Object put(Object object0, Object object1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public void putAll(Map map0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public Object remove(Object object0) {
        return this.g(object0);
    }

    @Override
    public final int size() {
        return 0;
    }

    @Override
    public String toString() {
        return "{}";
    }

    @Override
    public final Collection values() {
        return this.f();
    }
}

