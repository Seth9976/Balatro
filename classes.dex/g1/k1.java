package g1;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.StrictMode.VmPolicy.Builder;
import android.os.StrictMode.VmPolicy;
import android.os.StrictMode;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

final class k1 implements ServiceConnection, o1 {
    private final Map a;
    private int b;
    private boolean c;
    private IBinder d;
    private final i1 e;
    private ComponentName f;
    final n1 g;

    public k1(n1 n10, i1 i10) {
        this.g = n10;
        super();
        this.e = i10;
        this.a = new HashMap();
        this.b = 2;
    }

    public final int a() {
        return this.b;
    }

    public final ComponentName b() {
        return this.f;
    }

    public final IBinder c() {
        return this.d;
    }

    public final void d(ServiceConnection serviceConnection0, ServiceConnection serviceConnection1, String s) {
        this.a.put(serviceConnection0, serviceConnection1);
    }

    public final void e(String s, Executor executor0) {
        this.b = 3;
        StrictMode.VmPolicy strictMode$VmPolicy0 = StrictMode.getVmPolicy();
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder(strictMode$VmPolicy0).permitUnsafeIntentLaunch().build());
        try {
            boolean z = this.g.j.c(this.g.g, s, this.e.b(this.g.g), this, 0x1081, executor0);
            this.c = z;
            if(z) {
                Message message0 = this.g.h.obtainMessage(1, this.e);
                this.g.h.sendMessageDelayed(message0, this.g.l);
            }
            else {
                try {
                    this.b = 2;
                    this.g.j.b(this.g.g, this);
                }
                catch(IllegalArgumentException unused_ex) {
                }
            }
        }
        finally {
            StrictMode.setVmPolicy(strictMode$VmPolicy0);
        }
    }

    public final void f(ServiceConnection serviceConnection0, String s) {
        this.a.remove(serviceConnection0);
    }

    public final void g(String s) {
        this.g.h.removeMessages(1, this.e);
        this.g.j.b(this.g.g, this);
        this.c = false;
        this.b = 2;
    }

    public final boolean h(ServiceConnection serviceConnection0) {
        return this.a.containsKey(serviceConnection0);
    }

    public final boolean i() {
        return this.a.isEmpty();
    }

    public final boolean j() {
        return this.c;
    }

    @Override  // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName0) {
        this.onServiceDisconnected(componentName0);
    }

    @Override  // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName0, IBinder iBinder0) {
        synchronized(this.g.f) {
            this.g.h.removeMessages(1, this.e);
            this.d = iBinder0;
            this.f = componentName0;
            for(Object object0: this.a.values()) {
                ((ServiceConnection)object0).onServiceConnected(componentName0, iBinder0);
            }
            this.b = 1;
        }
    }

    @Override  // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName0) {
        synchronized(this.g.f) {
            this.g.h.removeMessages(1, this.e);
            this.d = null;
            this.f = componentName0;
            for(Object object0: this.a.values()) {
                ((ServiceConnection)object0).onServiceDisconnected(componentName0);
            }
            this.b = 2;
        }
    }
}

