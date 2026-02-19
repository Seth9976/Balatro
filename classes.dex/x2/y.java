package x2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.RemoteException;
import com.android.vending.licensing.ILicensingService;
import java.security.SecureRandom;

public class y implements ServiceConnection {
    static abstract class a {
    }

    class b extends com.android.vending.licensing.a.a {
        final y a;

        private b() {
        }

        b(a y$a0) {
        }

        @Override  // com.android.vending.licensing.a
        public void F(int v, String s, String s1) {
            y.this.c.a(v, s, s1);
        }
    }

    private ILicensingService a;
    private final Context b;
    private final x2.x.a c;
    private Handler d;
    private final String e;
    private static final SecureRandom f;
    private static final k0 g;

    static {
        y.f = new SecureRandom();
        y.g = k0.f("x");
    }

    public y(Context context0, x2.x.a x$a0) {
        HandlerThread handlerThread0 = new HandlerThread("license_checker");
        handlerThread0.start();
        this.b = context0;
        this.e = "com.playstack.balatro.android";
        this.d = new Handler(handlerThread0.getLooper());
        this.c = x$a0;
    }

    public void b() {
        synchronized(this) {
            ILicensingService iLicensingService0 = this.a;
            if(iLicensingService0 == null) {
                k0 k00 = y.g;
                k00.h("Binding to licensing service.");
                try {
                    Intent intent0 = new Intent("com.android.vending.licensing.ILicensingService").setPackage("com.android.vending");
                    if(!this.b.bindService(intent0, this, 1)) {
                        k00.c("Could not bind to service.");
                        this.c.a(-1, "Binding failed", "");
                    }
                }
                catch(SecurityException securityException0) {
                    y.g.d("SecurityException", securityException0);
                    this.c.a(-1, String.format("Exception: %s, Message: %s", securityException0.toString(), securityException0.getMessage()), "");
                }
                y.g.h("Binding done.");
            }
            else {
                try {
                    long v1 = (long)this.c();
                    b y$b0 = new b(this, null);
                    iLicensingService0.h(v1, this.e, y$b0);
                }
                catch(RemoteException remoteException0) {
                    y.g.d("RemoteException in checkLicense call.", remoteException0);
                    this.c.a(-1, String.format("Exception: %s, Message: %s", remoteException0.toString(), remoteException0.getMessage()), "");
                }
            }
        }
    }

    private int c() {
        return y.f.nextInt();
    }

    @Override  // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName0, IBinder iBinder0) {
        synchronized(this) {
            y.g.h("onServiceConnected.");
            ILicensingService iLicensingService0 = com.android.vending.licensing.ILicensingService.a.a(iBinder0);
            this.a = iLicensingService0;
            try {
                long v1 = (long)this.c();
                b y$b0 = new b(this, null);
                iLicensingService0.h(v1, this.e, y$b0);
                y.g.h("checkLicense call done.");
            }
            catch(RemoteException remoteException0) {
                y.g.d("RemoteException in checkLicense call.", remoteException0);
                this.c.a(-1, remoteException0.toString(), "");
            }
        }
    }

    @Override  // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName0) {
        synchronized(this) {
            y.g.h("Service unexpectedly disconnected.");
            this.a = null;
        }
    }
}

