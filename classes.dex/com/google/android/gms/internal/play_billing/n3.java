package com.google.android.gms.internal.play_billing;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

final class n3 extends AbstractSet {
    final p3 e;

    n3(p3 p30, m3 m30) {
        this.e = p30;
        super();
    }

    @Override
    public final boolean add(Object object0) {
        if(!this.contains(((Map.Entry)object0))) {
            Comparable comparable0 = (Comparable)((Map.Entry)object0).getKey();
            Object object1 = ((Map.Entry)object0).getValue();
            this.e.e(comparable0, object1);
            return true;
        }
        return false;
    }

    @Override
    public final void clear() {
        this.e.clear();
    }

    @Override
    public final boolean contains(Object object0) {
        Object object1 = ((Map.Entry)object0).getKey();
        Object object2 = this.e.get(object1);
        Object object3 = ((Map.Entry)object0).getValue();
        return object2 == object3 || object2 != null && object2.equals(object3);
    }

    @Override
    public final Iterator iterator() {
        return new l3(this.e, null);
    }

    @Override
    public final boolean remove(Object object0) {
        if(this.contains(((Map.Entry)object0))) {
            Object object1 = ((Map.Entry)object0).getKey();
            this.e.remove(object1);
            return true;
        }
        return false;
    }

    @Override
    public final int size() {
        return this.e.size();
    }
}

