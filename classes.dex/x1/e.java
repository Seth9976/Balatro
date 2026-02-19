package x1;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;

public abstract class e extends b implements f {
    public e() {
        super("com.google.android.gms.appset.internal.IAppSetIdCallback");
    }

    @Override  // x1.b
    protected final boolean a(int v, Parcel parcel0, Parcel parcel1, int v1) {
        if(v == 1) {
            this.D(((Status)c.a(parcel0, Status.CREATOR)), ((w0.f)c.a(parcel0, w0.f.CREATOR)));
            return true;
        }
        return false;
    }
}

