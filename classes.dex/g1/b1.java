package g1;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import c1.a;

public final class b1 extends q0 {
    public final IBinder g;
    final d h;

    public b1(d d0, int v, IBinder iBinder0, Bundle bundle0) {
        this.h = d0;
        super(d0, v, bundle0);
        this.g = iBinder0;
    }

    @Override  // g1.q0
    protected final void f(a a0) {
        if(this.h.v != null) {
            this.h.v.d(a0);
        }
        this.h.K(a0);
    }

    @Override  // g1.q0
    protected final boolean g() {
        String s1;
        String s;
        try {
            q.i(this.g);
            s = this.g.getInterfaceDescriptor();
        }
        catch(RemoteException unused_ex) {
            s1 = "service probably died";
            Log.w("GmsClient", s1);
            return false;
        }
        if(!this.h.D().equals(s)) {
            s1 = "service descriptor mismatch: " + this.h.D() + " vs. " + s;
            Log.w("GmsClient", s1);
            return false;
        }
        IInterface iInterface0 = this.h.r(this.g);
        if(iInterface0 != null && (d.e0(this.h, 2, 4, iInterface0) || d.e0(this.h, 3, 4, iInterface0))) {
            this.h.z = null;
            Bundle bundle0 = this.h.w();
            if(this.h.u != null) {
                this.h.u.f(bundle0);
            }
            return true;
        }
        return false;
    }
}

