package c1;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import g1.o;
import h1.c;

public final class a extends h1.a {
    public static final Parcelable.Creator CREATOR;
    final int e;
    private final int f;
    private final PendingIntent g;
    private final String h;
    public static final a i;

    static {
        a.i = new a(0);
        a.CREATOR = new q();
    }

    public a(int v) {
        this(v, null, null);
    }

    a(int v, int v1, PendingIntent pendingIntent0, String s) {
        this.e = v;
        this.f = v1;
        this.g = pendingIntent0;
        this.h = s;
    }

    public a(int v, PendingIntent pendingIntent0) {
        this(v, pendingIntent0, null);
    }

    public a(int v, PendingIntent pendingIntent0, String s) {
        this(1, v, pendingIntent0, s);
    }

    @Override
    public boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        return object0 instanceof a ? this.f == ((a)object0).f && o.a(this.g, ((a)object0).g) && o.a(this.h, ((a)object0).h) : false;
    }

    @Override
    public int hashCode() {
        return o.b(new Object[]{this.f, this.g, this.h});
    }

    public int j0() {
        return this.f;
    }

    public String k0() {
        return this.h;
    }

    public PendingIntent l0() {
        return this.g;
    }

    public boolean m0() {
        return this.f != 0 && this.g != null;
    }

    public boolean n0() {
        return this.f == 0;
    }

    static String o0(int v) {
        switch(v) {
            case -1: {
                return "UNKNOWN";
            }
            case 0: {
                return "SUCCESS";
            }
            case 1: {
                return "SERVICE_MISSING";
            }
            case 2: {
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            }
            case 3: {
                return "SERVICE_DISABLED";
            }
            case 4: {
                return "SIGN_IN_REQUIRED";
            }
            case 5: {
                return "INVALID_ACCOUNT";
            }
            case 6: {
                return "RESOLUTION_REQUIRED";
            }
            case 7: {
                return "NETWORK_ERROR";
            }
            case 8: {
                return "INTERNAL_ERROR";
            }
            case 9: {
                return "SERVICE_INVALID";
            }
            case 10: {
                return "DEVELOPER_ERROR";
            }
            case 11: {
                return "LICENSE_CHECK_FAILED";
            }
            case 13: {
                return "CANCELED";
            }
            case 14: {
                return "TIMEOUT";
            }
            case 15: {
                return "INTERRUPTED";
            }
            case 16: {
                return "API_UNAVAILABLE";
            }
            case 17: {
                return "SIGN_IN_FAILED";
            }
            case 18: {
                return "SERVICE_UPDATING";
            }
            case 19: {
                return "SERVICE_MISSING_PERMISSION";
            }
            case 20: {
                return "RESTRICTED_PROFILE";
            }
            case 21: {
                return "API_VERSION_UPDATE_REQUIRED";
            }
            case 22: {
                return "RESOLUTION_ACTIVITY_NOT_FOUND";
            }
            case 23: {
                return "API_DISABLED";
            }
            case 24: {
                return "API_DISABLED_FOR_CONNECTION";
            }
            case 99: {
                return "UNFINISHED";
            }
            case 1500: {
                return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
            }
            default: {
                return "UNKNOWN_ERROR_CODE(" + v + ")";
            }
        }
    }

    @Override
    public String toString() {
        g1.o.a o$a0 = o.c(this);
        o$a0.a("statusCode", a.o0(this.f));
        o$a0.a("resolution", this.g);
        o$a0.a("message", this.h);
        return o$a0.toString();
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = c.a(parcel0);
        c.i(parcel0, 1, this.e);
        c.i(parcel0, 2, this.j0());
        c.m(parcel0, 3, this.l0(), v, false);
        c.n(parcel0, 4, this.k0(), false);
        c.b(parcel0, v1);
    }
}

