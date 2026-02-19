package u1;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;

public final class b implements Parcelable {
    public static final Parcelable.Creator CREATOR;

    static {
        b.CREATOR = new a();
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
    }
}

