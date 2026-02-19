package g1;

import android.app.PendingIntent;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import b2.e;
import c1.a;

final class x0 extends e {
    final d b;

    public x0(d d0, Looper looper0) {
        this.b = d0;
        super(looper0);
    }

    private static final void a(Message message0) {
        y0 y00 = (y0)message0.obj;
        y00.b();
        y00.e();
    }

    private static final boolean b(Message message0) {
        return message0.what == 1 || message0.what == 2 || message0.what == 7;
    }

    @Override  // android.os.Handler
    public final void handleMessage(Message message0) {
        if(this.b.C.get() != message0.arg1) {
            if(x0.b(message0)) {
                x0.a(message0);
            }
            return;
        }
        if(message0.what != 1 && message0.what != 4 && message0.what != 7 && message0.what != 5 || this.b.a()) {
            PendingIntent pendingIntent0 = null;
            switch(message0.what) {
                case 2: {
                    if(!this.b.c()) {
                        x0.a(message0);
                        return;
                    }
                    break;
                }
                case 3: {
                    Object object0 = message0.obj;
                    if(object0 instanceof PendingIntent) {
                        pendingIntent0 = (PendingIntent)object0;
                    }
                    a a3 = new a(message0.arg2, pendingIntent0);
                    this.b.p.b(a3);
                    this.b.K(a3);
                    return;
                }
                case 4: {
                    a a0 = new a(message0.arg2);
                    this.b.z = a0;
                    if(d.f0(this.b)) {
                        d d0 = this.b;
                        if(!d0.A) {
                            d.Z(d0, 3, null);
                            return;
                        }
                    }
                    a a1 = this.b.z == null ? new a(8) : this.b.z;
                    this.b.p.b(a1);
                    this.b.K(a1);
                    return;
                }
                case 5: {
                    a a2 = this.b.z == null ? new a(8) : this.b.z;
                    this.b.p.b(a2);
                    this.b.K(a2);
                    return;
                }
                case 6: {
                    d.Z(this.b, 5, null);
                    d d1 = this.b;
                    if(d1.u != null) {
                        d1.u.a(message0.arg2);
                    }
                    this.b.L(message0.arg2);
                    d.e0(this.b, 5, 1, null);
                    return;
                }
            }
            if(x0.b(message0)) {
                ((y0)message0.obj).c();
                return;
            }
            Log.wtf("GmsClient", "Don\'t know how to handle message: " + message0.what, new Exception());
            return;
        }
        x0.a(message0);
    }
}

