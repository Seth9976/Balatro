package u1;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class a implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        return new b();
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new b[v];
    }
}

