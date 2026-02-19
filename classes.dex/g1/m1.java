package g1;

import android.content.ComponentName;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.Log;
import java.util.HashMap;

final class m1 implements Handler.Callback {
    final n1 a;

    m1(n1 n10, l1 l10) {
        this.a = n10;
        super();
    }

    @Override  // android.os.Handler$Callback
    public final boolean handleMessage(Message message0) {
        switch(message0.what) {
            case 0: {
                HashMap hashMap0 = this.a.f;
                synchronized(hashMap0) {
                    i1 i10 = (i1)message0.obj;
                    k1 k10 = (k1)this.a.f.get(i10);
                    if(k10 != null && k10.i()) {
                        if(k10.j()) {
                            k10.g("GmsClientSupervisor");
                        }
                        this.a.f.remove(i10);
                    }
                    return true;
                }
            }
            case 1: {
                HashMap hashMap1 = this.a.f;
                synchronized(hashMap1) {
                    i1 i11 = (i1)message0.obj;
                    k1 k11 = (k1)this.a.f.get(i11);
                    if(k11 != null && k11.a() == 3) {
                        Log.e("GmsClientSupervisor", "Timeout waiting for ServiceConnection callback " + i11, new Exception());
                        ComponentName componentName0 = k11.b() == null ? i11.a() : k11.b();
                        if(componentName0 == null) {
                            String s = i11.c();
                            q.i(s);
                            componentName0 = new ComponentName(s, "unknown");
                        }
                        k11.onServiceDisconnected(componentName0);
                    }
                    return true;
                }
            }
            default: {
                return false;
            }
        }
    }
}

