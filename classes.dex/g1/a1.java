package g1;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;

public final class a1 implements ServiceConnection {
    private final int a;
    final d b;

    public a1(d d0, int v) {
        this.b = d0;
        super();
        this.a = v;
    }

    @Override  // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName0, IBinder iBinder0) {
        d d0 = this.b;
        if(iBinder0 == null) {
            d.b0(d0, 16);
            return;
        }
        synchronized(d0.n) {
            d d1 = this.b;
            IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            m m0 = iInterface0 == null || !(iInterface0 instanceof m) ? new t0(iBinder0) : ((m)iInterface0);
            d1.o = m0;
        }
        this.b.c0(0, null, this.a);
    }

    @Override  // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName0) {
        synchronized(this.b.n) {
            this.b.o = null;
        }
        Message message0 = this.b.l.obtainMessage(6, this.a, 1);
        this.b.l.sendMessage(message0);
    }
}

