package x2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

abstract class u {
    static abstract class a {
    }

    interface b extends IInterface {
        public static abstract class x2.u.b.a extends Binder implements b {
            static class x2.u.b.a.a implements b {
                private IBinder a;

                x2.u.b.a.a(IBinder iBinder0) {
                    this.a = iBinder0;
                }

                @Override  // android.os.IInterface
                public IBinder asBinder() {
                    return this.a;
                }

                @Override  // x2.u$b
                public String getId() {
                    Parcel parcel0 = Parcel.obtain();
                    Parcel parcel1 = Parcel.obtain();
                    try {
                        parcel0.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                        this.a.transact(1, parcel0, parcel1, 0);
                        parcel1.readException();
                        return parcel1.readString();
                    }
                    finally {
                        parcel1.recycle();
                        parcel0.recycle();
                    }
                }
            }

            public static b a(IBinder iBinder0) {
                if(iBinder0 == null) {
                    return null;
                }
                IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                return iInterface0 != null && iInterface0 instanceof b ? ((b)iInterface0) : new x2.u.b.a.a(iBinder0);
            }
        }

        String getId();
    }

    static class c implements ServiceConnection {
        boolean a;
        private final BlockingQueue b;

        private c() {
            this.a = false;
            this.b = new LinkedBlockingQueue();
        }

        c(a u$a0) {
        }

        public IBinder a() {
            if(this.a) {
                throw new IllegalStateException();
            }
            this.a = true;
            return (IBinder)this.b.take();
        }

        @Override  // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName0, IBinder iBinder0) {
            try {
                this.b.put(iBinder0);
            }
            catch(InterruptedException unused_ex) {
            }
        }

        @Override  // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName0) {
        }
    }

    private static final k0 a;

    static {
        u.a = k0.f("u");
    }

    public static String a(Context context0) {
        try {
            String s = u.b(context0);
            u.a.a("Got AIFA by querying Google Play service");
            return s;
        }
        catch(Throwable unused_ex) {
            u.a.a("Could not determine AIFA");
            return null;
        }
    }

    static String b(Context context0) {
        String s;
        c u$c0 = new c(null);
        Intent intent0 = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent0.setPackage("com.google.android.gms");
        if(context0.bindService(intent0, u$c0, 1)) {
            try {
                s = x2.u.b.a.a(u$c0.a()).getId();
            }
            catch(Throwable unused_ex) {
                context0.unbindService(u$c0);
                return "";
            }
            context0.unbindService(u$c0);
            return s;
        }
        return "";
    }
}

