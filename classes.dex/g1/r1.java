package g1;

import android.os.Parcel;
import b2.b;
import b2.c;
import o1.a;

public abstract class r1 extends b implements r0 {
    public r1() {
        super("com.google.android.gms.common.internal.ICertData");
    }

    @Override  // b2.b
    protected final boolean a(int v, Parcel parcel0, Parcel parcel1, int v1) {
        switch(v) {
            case 1: {
                a a0 = this.e();
                parcel1.writeNoException();
                c.c(parcel1, a0);
                return true;
            }
            case 2: {
                int v2 = this.c();
                parcel1.writeNoException();
                parcel1.writeInt(v2);
                return true;
            }
            default: {
                return false;
            }
        }
    }
}

