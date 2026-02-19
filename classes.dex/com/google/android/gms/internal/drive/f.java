package com.google.android.gms.internal.drive;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

abstract class f extends AbstractList implements n0 {
    private boolean e;

    f() {
        this.e = true;
    }

    @Override
    public boolean add(Object object0) {
        this.e();
        return super.add(object0);
    }

    @Override
    public abstract boolean addAll(int arg1, Collection arg2);

    @Override
    public abstract boolean addAll(Collection arg1);

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
        if(v != ((List)object0).size()) {
            return false;
        }
        for(int v1 = 0; v1 < v; ++v1) {
            if(!this.get(v1).equals(((List)object0).get(v1))) {
                return false;
            }
        }
        return true;
    }

    @Override  // com.google.android.gms.internal.drive.n0
    public boolean h() {
        return this.e;
    }

    @Override
    public int hashCode() {
        int v = this.size();
        int v1 = 1;
        for(int v2 = 0; v2 < v; ++v2) {
            v1 = v1 * 0x1F + this.get(v2).hashCode();
        }
        return v1;
    }

    @Override  // com.google.android.gms.internal.drive.n0
    public final void l() {
        this.e = false;
    }

    @Override
    public boolean remove(Object object0) {
        this.e();
        return super.remove(object0);
    }

    @Override
    public boolean removeAll(Collection collection0) {
        this.e();
        return super.removeAll(collection0);
    }

    @Override
    public boolean retainAll(Collection collection0) {
        this.e();
        return super.retainAll(collection0);
    }
}

