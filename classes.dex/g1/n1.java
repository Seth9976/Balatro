package g1;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import b2.e;
import java.util.HashMap;
import java.util.concurrent.Executor;
import k1.b;

final class n1 extends i {
    private final HashMap f;
    private final Context g;
    private volatile Handler h;
    private final m1 i;
    private final b j;
    private final long k;
    private final long l;
    private volatile Executor m;

    n1(Context context0, Looper looper0, Executor executor0) {
        this.f = new HashMap();
        m1 m10 = new m1(this, null);
        this.i = m10;
        this.g = context0.getApplicationContext();
        this.h = new e(looper0, m10);
        this.j = b.a();
        this.k = 5000L;
        this.l = 300000L;
        this.m = executor0;
    }

    @Override  // g1.i
    protected final void c(i1 i10, ServiceConnection serviceConnection0, String s) {
        q.j(serviceConnection0, "ServiceConnection must not be null");
        synchronized(this.f) {
            k1 k10 = (k1)this.f.get(i10);
            if(k10 != null) {
                if(!k10.h(serviceConnection0)) {
                    throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + i10.toString());
                }
                k10.f(serviceConnection0, s);
                if(k10.i()) {
                    Message message0 = this.h.obtainMessage(0, i10);
                    this.h.sendMessageDelayed(message0, this.k);
                }
                return;
            }
        }
        throw new IllegalStateException("Nonexistent connection status for service config: " + i10.toString());
    }

    @Override  // g1.i
    protected final boolean e(i1 i10, ServiceConnection serviceConnection0, String s, Executor executor0) {
        q.j(serviceConnection0, "ServiceConnection must not be null");
        synchronized(this.f) {
            k1 k10 = (k1)this.f.get(i10);
            if(executor0 == null) {
                executor0 = this.m;
            }
            if(k10 == null) {
                k10 = new k1(this, i10);
                k10.d(serviceConnection0, serviceConnection0, s);
                k10.e(s, executor0);
                this.f.put(i10, k10);
                return k10.j();
            }
            this.h.removeMessages(0, i10);
            if(!k10.h(serviceConnection0)) {
                k10.d(serviceConnection0, serviceConnection0, s);
                switch(k10.a()) {
                    case 1: {
                        serviceConnection0.onServiceConnected(k10.b(), k10.c());
                        break;
                    }
                    case 2: {
                        k10.e(s, executor0);
                    }
                }
                return k10.j();
            }
        }
        throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + i10.toString());
    }
}

