package g1;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

public final class z0 extends s0 {
    private d a;
    private final int b;

    public z0(d d0, int v) {
        this.a = d0;
        this.b = v;
    }

    @Override  // g1.l
    public final void V(int v, IBinder iBinder0, Bundle bundle0) {
        q.j(this.a, "onPostInitComplete can be called only once per call to getRemoteService");
        this.a.M(v, iBinder0, bundle0, this.b);
        this.a = null;
    }

    @Override  // g1.l
    public final void j(int v, Bundle bundle0) {
        Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
    }

    @Override  // g1.l
    public final void v(int v, IBinder iBinder0, e1 e10) {
        d d0 = this.a;
        q.j(d0, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
        q.i(e10);
        d.a0(d0, e10);
        this.V(v, iBinder0, e10.e);
    }
}

