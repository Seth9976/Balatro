package com.google.android.gms.internal.play_billing;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

abstract class b0 extends AbstractList implements u1 {
    private boolean e;

    b0(boolean z) {
        this.e = z;
    }

    @Override
    public boolean add(Object object0) {
        this.e();
        return super.add(object0);
    }

    @Override
    public boolean addAll(int v, Collection collection0) {
        this.e();
        return super.addAll(v, collection0);
    }

    @Override
    public boolean addAll(Collection collection0) {
        this.e();
        return super.addAll(collection0);
    }

    @Override  // com.google.android.gms.internal.play_billing.u1
    public final void b() {
        if(this.e) {
            this.e = false;
        }
    }

    @Override  // com.google.android.gms.internal.play_billing.u1
    public final boolean c() {
        return this.e;
    }

    @Override
    public void clear() {
        this.e();
        super.clear();
    }

    protected final void e() {
        if(!this.e) {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        if(!(object0 instanceof List)) {
            return false;
        }
        if(!(object0 instanceof RandomAccess)) {
            return super.equals(object0);
        }
        int v = this.size();
        if(v == ((List)object0).size()) {
            for(int v1 = 0; v1 < v; ++v1) {
                if(!this.get(v1).equals(((List)object0).get(v1))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int v = this.size();
        int v2 = 1;
        for(int v1 = 0; v1 < v; ++v1) {
            v2 = v2 * 0x1F + this.get(v1).hashCode();
        }
        return v2;
    }

    @Override
    public abstract Object remove(int arg1);

    @Override
    public final boolean remove(Object object0) {
        this.e();
        int v = this.indexOf(object0);
        if(v == -1) {
            return false;
        }
        this.remove(v);
        return true;
    }

    @Override
    public final boolean removeAll(Collection collection0) {
        this.e();
        return super.removeAll(collection0);
    }

    @Override
    public final boolean retainAll(Collection collection0) {
        this.e();
        return super.retainAll(collection0);
    }
}

