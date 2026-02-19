package e0;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import java.util.List;

class b extends a {
    static abstract class e0.b.a {
    }

    final class e0.b.b implements ServiceConnection {
        private final c a;
        final b b;

        private e0.b.b(c c0) {
            if(c0 == null) {
                throw new RuntimeException("Please specify a listener to know when setup is done.");
            }
            this.a = c0;
        }

        e0.b.b(c c0, e0.b.a b$a0) {
            this(c0);
        }

        @Override  // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName0, IBinder iBinder0) {
            f0.a.a("InstallReferrerClient", "Install Referrer service connected.");
            v0.a a0 = v0.a.a.a(iBinder0);
            b.this.c = a0;
            b.this.a = 2;
            this.a.a(0);
        }

        @Override  // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName0) {
            f0.a.b("InstallReferrerClient", "Install Referrer service disconnected.");
            b.this.c = null;
            b.this.a = 0;
            this.a.b();
        }
    }

    private int a;
    private final Context b;
    private v0.a c;
    private ServiceConnection d;

    public b(Context context0) {
        this.a = 0;
        this.b = context0.getApplicationContext();
    }

    @Override  // e0.a
    public void a() {
        this.a = 3;
        if(this.d != null) {
            f0.a.a("InstallReferrerClient", "Unbinding from service.");
            this.b.unbindService(this.d);
            this.d = null;
        }
        this.c = null;
    }

    @Override  // e0.a
    public d b() {
        if(this.c()) {
            Bundle bundle0 = new Bundle();
            bundle0.putString("package_name", "com.playstack.balatro.android");
            try {
                return new d(this.c.o(bundle0));
            }
            catch(RemoteException remoteException0) {
                f0.a.b("InstallReferrerClient", "RemoteException getting install referrer information");
                this.a = 0;
                throw remoteException0;
            }
        }
        throw new IllegalStateException("Service not connected. Please start a connection before using the service.");
    }

    @Override  // e0.a
    public boolean c() {
        return this.a == 2 && this.c != null && this.d != null;
    }

    @Override  // e0.a
    public void e(c c0) {
        if(this.c()) {
            f0.a.a("InstallReferrerClient", "Service connection is valid. No need to re-initialize.");
            c0.a(0);
            return;
        }
        int v = this.a;
        if(v == 1) {
            f0.a.b("InstallReferrerClient", "Client is already in the process of connecting to the service.");
            c0.a(3);
            return;
        }
        if(v == 3) {
            f0.a.b("InstallReferrerClient", "Client was already closed and can\'t be reused. Please create another instance.");
            c0.a(3);
            return;
        }
        f0.a.a("InstallReferrerClient", "Starting install referrer service setup.");
        Intent intent0 = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
        intent0.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
        List list0 = this.b.getPackageManager().queryIntentServices(intent0, 0);
        if(list0 != null && !list0.isEmpty()) {
            ServiceInfo serviceInfo0 = ((ResolveInfo)list0.get(0)).serviceInfo;
            if(serviceInfo0 != null) {
                if("com.android.vending".equals(serviceInfo0.packageName) && serviceInfo0.name != null && this.h()) {
                    Intent intent1 = new Intent(intent0);
                    e0.b.b b$b0 = new e0.b.b(this, c0, null);
                    this.d = b$b0;
                    try {
                        if(this.b.bindService(intent1, b$b0, 1)) {
                            goto label_30;
                        }
                        goto label_32;
                    }
                    catch(SecurityException unused_ex) {
                        f0.a.b("InstallReferrerClient", "No permission to connect to service.");
                        this.a = 0;
                        c0.a(4);
                        return;
                    }
                label_30:
                    f0.a.a("InstallReferrerClient", "Service was bonded successfully.");
                    return;
                label_32:
                    f0.a.b("InstallReferrerClient", "Connection to service is blocked.");
                    this.a = 0;
                    c0.a(1);
                    return;
                }
                f0.a.b("InstallReferrerClient", "Play Store missing or incompatible. Version 8.3.73 or later required.");
                this.a = 0;
                c0.a(2);
                return;
            }
        }
        this.a = 0;
        f0.a.a("InstallReferrerClient", "Install Referrer service unavailable on device.");
        c0.a(2);
    }

    private boolean h() {
        PackageManager packageManager0 = this.b.getPackageManager();
        try {
            if(packageManager0.getPackageInfo("com.android.vending", 0x80).versionCode >= 80837300) {
                return true;
            }
        }
        catch(PackageManager.NameNotFoundException unused_ex) {
        }
        return false;
    }
}

