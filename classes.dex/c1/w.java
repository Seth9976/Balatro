package c1;

import android.os.RemoteException;
import android.util.Log;
import g1.q;
import g1.r0;
import g1.r1;
import java.util.Arrays;
import o1.a;
import o1.b;

abstract class w extends r1 {
    private final int a;

    protected w(byte[] arr_b) {
        q.a(arr_b.length == 25);
        this.a = Arrays.hashCode(arr_b);
    }

    @Override  // g1.r0
    public final int c() {
        return this.a;
    }

    protected static byte[] d(String s) [...] // 潜在的解密器

    @Override  // g1.r0
    public final a e() {
        return b.f(this.f());
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 != null && object0 instanceof r0) {
            try {
                if(((r0)object0).c() != this.a) {
                    return false;
                }
                a a0 = ((r0)object0).e();
                if(a0 == null) {
                    return false;
                }
                byte[] arr_b = (byte[])b.d(a0);
                return Arrays.equals(this.f(), arr_b);
            }
            catch(RemoteException remoteException0) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", remoteException0);
            }
        }
        return false;
    }

    abstract byte[] f();

    @Override
    public final int hashCode() {
        return this.a;
    }
}

