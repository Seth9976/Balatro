package s1;

import android.content.Intent;
import android.os.Parcel;
import c2.m0;
import c2.r;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.internal.v2.appshortcuts.f;

public abstract class v extends r implements w {
    public v() {
        super("com.google.android.gms.games.internal.v2.appshortcuts.IAppShortcutsServiceCallback");
    }

    @Override  // c2.r
    protected final boolean a(int v, Parcel parcel0, Parcel parcel1, int v1) {
        switch(v) {
            case 1: {
                Status status0 = (Status)m0.a(parcel0, Status.CREATOR);
                m0.b(parcel0);
                this.k(status0);
                return true;
            }
            case 2: {
                f f0 = (f)m0.a(parcel0, f.CREATOR);
                m0.b(parcel0);
                this.M(f0);
                return true;
            }
            case 3: {
                Intent intent0 = (Intent)m0.a(parcel0, Intent.CREATOR);
                m0.b(parcel0);
                this.l(intent0);
                return true;
            }
            default: {
                return false;
            }
        }
    }
}

