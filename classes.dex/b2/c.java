package b2;

import android.os.BadParcelableException;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;

public abstract class c {
    private static final ClassLoader a;

    static {
        c.a = c.class.getClassLoader();
    }

    public static Parcelable a(Parcel parcel0, Parcelable.Creator parcelable$Creator0) {
        return parcel0.readInt() == 0 ? null : ((Parcelable)parcelable$Creator0.createFromParcel(parcel0));
    }

    public static void b(Parcel parcel0) {
        int v = parcel0.dataAvail();
        if(v > 0) {
            throw new BadParcelableException("Parcel data not fully consumed, unread size: " + v);
        }
    }

    public static void c(Parcel parcel0, IInterface iInterface0) {
        parcel0.writeStrongBinder((iInterface0 == null ? null : iInterface0.asBinder()));
    }
}

