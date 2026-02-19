package v1;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.BitmapTeleporter;
import g1.q;
import h1.c;
import q1.r;

public final class h extends r implements g {
    public static final Parcelable.Creator CREATOR;
    private final String e;
    private final Long f;
    private final Uri g;
    private BitmapTeleporter h;
    private final Long i;

    static {
        h.CREATOR = new m();
    }

    h(String s, Long long0, BitmapTeleporter bitmapTeleporter0, Uri uri0, Long long1) {
        this.e = s;
        this.f = long0;
        this.h = bitmapTeleporter0;
        this.g = uri0;
        this.i = long1;
        q.l(bitmapTeleporter0 == null || uri0 == null, "Cannot set both a URI and an image");
    }

    @Override  // v1.g
    public final BitmapTeleporter a() {
        return this.h;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = c.a(parcel0);
        c.n(parcel0, 1, this.e, false);
        c.l(parcel0, 2, this.f, false);
        c.m(parcel0, 4, this.g, v, false);
        c.m(parcel0, 5, this.h, v, false);
        c.l(parcel0, 6, this.i, false);
        c.b(parcel0, v1);
    }
}

