package g0;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;

public abstract class c {
    static {
    }

    public static Parcelable a(Parcel parcel0, Parcelable.Creator parcelable$Creator0) {
        return parcel0.readInt() == 0 ? null : ((Parcelable)parcelable$Creator0.createFromParcel(parcel0));
    }

    public static void b(Parcel parcel0, Parcelable parcelable0) {
        parcel0.writeInt(1);
        parcelable0.writeToParcel(parcel0, 0);
    }
}

