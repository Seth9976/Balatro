package com.google.android.gms.internal.play_billing;

import java.util.Set;

public abstract class n extends g implements Set {
    private transient j f;

    @Override
    public final boolean equals(Object object0) {
        if(object0 != this) {
            if(object0 instanceof Set) {
                Set set0 = (Set)object0;
                try {
                    if(this.size() == set0.size() && this.containsAll(set0)) {
                        return true;
                    }
                }
                catch(NullPointerException | ClassCastException unused_ex) {
                }
            }
            return false;
        }
        return true;
    }

    @Override
    public final int hashCode() {
        return v.a(this);
    }

    @Override  // com.google.android.gms.internal.play_billing.g
    public j p() {
        j j0 = this.f;
        if(j0 == null) {
            j0 = this.s();
            this.f = j0;
        }
        return j0;
    }

    j s() {
        Object[] arr_object = this.toArray();
        return j.t(arr_object, arr_object.length);
    }
}

