package com.google.android.gms.internal.drive;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

class g2 extends AbstractSet {
    private final x1 e;

    private g2(x1 x10) {
        this.e = x10;
        super();
    }

    g2(x1 x10, y1 y10) {
        this(x10);
    }

    @Override
    public boolean add(Object object0) {
        if(!this.contains(((Map.Entry)object0))) {
            Comparable comparable0 = (Comparable)((Map.Entry)object0).getKey();
            Object object1 = ((Map.Entry)object0).getValue();
            this.e.d(comparable0, object1);
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        this.e.clear();
    }

    @Override
    public boolean contains(Object object0) {
        Object object1 = ((Map.Entry)object0).getKey();
        Object object2 = this.e.get(object1);
        Object object3 = ((Map.Entry)object0).getValue();
        return object2 == object3 || object2 != null && object2.equals(object3);
    }

    @Override
    public Iterator iterator() {
        return new f2(this.e, null);
    }

    @Override
    public boolean remove(Object object0) {
        if(this.contains(((Map.Entry)object0))) {
            Object object1 = ((Map.Entry)object0).getKey();
            this.e.remove(object1);
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return this.e.size();
    }
}

