package a1;

import android.os.Parcel;
import z1.c;

public abstract class q extends c implements r {
    public q() {
        super("com.google.android.gms.auth.api.signin.internal.IRevocationService");
    }

    @Override  // z1.c
    protected final boolean a(int v, Parcel parcel0, Parcel parcel1, int v1) {
        switch(v) {
            case 1: {
                this.L();
                return true;
            }
            case 2: {
                this.r();
                return true;
            }
            default: {
                return false;
            }
        }
    }
}

