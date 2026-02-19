package c2;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;

public abstract class u2 extends r implements v2 {
    public u2() {
        super("com.google.android.gms.games.internal.connect.IGamesConnectCallbacks");
    }

    @Override  // c2.r
    protected final boolean a(int v, Parcel parcel0, Parcel parcel1, int v1) {
        if(v == 2) {
            Status status0 = (Status)m0.a(parcel0, Status.CREATOR);
            s2 s20 = (s2)m0.a(parcel0, s2.CREATOR);
            m0.b(parcel0);
            this.n(status0, s20);
            return true;
        }
        return false;
    }
}

