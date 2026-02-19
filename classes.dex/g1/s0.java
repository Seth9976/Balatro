package g1;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import b2.b;
import b2.c;

public abstract class s0 extends b implements l {
    public s0() {
        super("com.google.android.gms.common.internal.IGmsCallbacks");
    }

    @Override  // b2.b
    protected final boolean a(int v, Parcel parcel0, Parcel parcel1, int v1) {
        switch(v) {
            case 1: {
                int v2 = parcel0.readInt();
                IBinder iBinder0 = parcel0.readStrongBinder();
                Bundle bundle0 = (Bundle)c.a(parcel0, Bundle.CREATOR);
                c.b(parcel0);
                this.V(v2, iBinder0, bundle0);
                break;
            }
            case 2: {
                int v3 = parcel0.readInt();
                Bundle bundle1 = (Bundle)c.a(parcel0, Bundle.CREATOR);
                c.b(parcel0);
                this.j(v3, bundle1);
                break;
            }
            case 3: {
                int v4 = parcel0.readInt();
                IBinder iBinder1 = parcel0.readStrongBinder();
                e1 e10 = (e1)c.a(parcel0, e1.CREATOR);
                c.b(parcel0);
                this.v(v4, iBinder1, e10);
                break;
            }
            default: {
                return false;
            }
        }
        parcel1.writeNoException();
        return true;
    }
}

