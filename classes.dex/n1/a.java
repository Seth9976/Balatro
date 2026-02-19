package n1;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.DriveId;
import h1.c;

public class a extends h1.a {
    public static final Parcelable.Creator CREATOR;
    private final ParcelFileDescriptor e;
    final int f;
    private final int g;
    private final DriveId h;
    private final boolean i;
    private final String j;

    static {
        a.CREATOR = new b();
    }

    public a(ParcelFileDescriptor parcelFileDescriptor0, int v, int v1, DriveId driveId0, boolean z, String s) {
        this.e = parcelFileDescriptor0;
        this.f = v;
        this.g = v1;
        this.h = driveId0;
        this.i = z;
        this.j = s;
    }

    public ParcelFileDescriptor j0() {
        return this.e;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = c.a(parcel0);
        c.m(parcel0, 2, this.e, v, false);
        c.i(parcel0, 3, this.f);
        c.i(parcel0, 4, this.g);
        c.m(parcel0, 5, this.h, v, false);
        c.c(parcel0, 7, this.i);
        c.n(parcel0, 8, this.j, false);
        c.b(parcel0, v1);
    }
}

