package q1;

import android.os.Parcel;
import c2.d;
import c2.r;

public abstract class g extends r implements h {
    public g() {
        super("com.google.android.gms.games.internal.IGamesClient");
    }

    @Override  // c2.r
    protected final boolean a(int v, Parcel parcel0, Parcel parcel1, int v1) {
        if(v == 1001) {
            d d0 = this.b();
            parcel1.writeNoException();
            parcel1.writeInt(1);
            d0.writeToParcel(parcel1, 1);
            return true;
        }
        return false;
    }
}

