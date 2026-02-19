package com.google.android.gms.internal.play_billing;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Set;

public final class l2 extends LinkedHashMap {
    private boolean e;
    private static final l2 f;

    static {
        l2 l20 = new l2();
        l2.f = l20;
        l20.e = false;
    }

    private l2() {
        this.e = true;
    }

    private l2(Map map0) {
        super(map0);
        this.e = true;
    }

    public static l2 a() {
        return l2.f;
    }

    // 去混淆评级： 低(20)
    public final l2 c() {
        return this.isEmpty() ? new l2() : new l2(this);
    }

    @Override
    public final void clear() {
        this.j();
        super.clear();
    }

    public final void d() {
        this.e = false;
    }

    // 去混淆评级： 低(20)
    @Override
    public final Set entrySet() {
        return this.isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 instanceof Map) {
            if(this == ((Map)object0)) {
                return true;
            }
            if(this.size() == ((Map)object0).size()) {
                for(Object object1: this.entrySet()) {
                    if(!((Map)object0).containsKey(((Map.Entry)object1).getKey())) {
                        return false;
                    }
                    Object object2 = ((Map.Entry)object1).getValue();
                    Object object3 = ((Map)object0).get(((Map.Entry)object1).getKey());
                    if((!(object2 instanceof byte[]) || !(object3 instanceof byte[]) ? object2.equals(object3) : Arrays.equals(((byte[])object2), ((byte[])object3)))) {
                        continue;
                    }
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public final void f(l2 l20) {
        this.j();
        if(!l20.isEmpty()) {
            this.putAll(l20);
        }
    }

    public final boolean g() {
        return this.e;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        for(Object object0: this.entrySet()) {
            int v1 = l2.i(((Map.Entry)object0).getKey());
            v += l2.i(((Map.Entry)object0).getValue()) ^ v1;
        }
        return v;
    }

    private static int i(Object object0) {
        if(object0 instanceof byte[]) {
            int v = ((byte[])object0).length;
            int v1 = v1.b(v, ((byte[])object0), 0, v);
            return v1 == 0 ? 1 : v1;
        }
        if(object0 instanceof p1) {
            throw new UnsupportedOperationException();
        }
        return object0.hashCode();
    }

    private final void j() {
        if(!this.e) {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public final Object put(Object object0, Object object1) {
        this.j();
        object0.getClass();
        object1.getClass();
        return super.put(object0, object1);
    }

    @Override
    public final void putAll(Map map0) {
        this.j();
        for(Object object0: map0.keySet()) {
            object0.getClass();
            map0.get(object0).getClass();
        }
        super.putAll(map0);
    }

    @Override
    public final Object remove(Object object0) {
        this.j();
        return super.remove(object0);
    }
}

