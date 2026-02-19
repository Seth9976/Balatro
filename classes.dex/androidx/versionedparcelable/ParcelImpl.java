package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;

public class ParcelImpl implements Parcelable {
    static final class a implements Parcelable.Creator {
        public ParcelImpl a(Parcel parcel0) {
            return new ParcelImpl(parcel0);
        }

        public ParcelImpl[] b(int v) {
            return new ParcelImpl[v];
        }

        @Override  // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel0) {
            return this.a(parcel0);
        }

        @Override  // android.os.Parcelable$Creator
        public Object[] newArray(int v) {
            return this.b(v);
        }
    }

    public static final Parcelable.Creator CREATOR;
    private final c0.a e;

    static {
        ParcelImpl.CREATOR = new a();
    }

    protected ParcelImpl(Parcel parcel0) {
        this.e = new b(parcel0).u();
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        new b(parcel0).L(this.e);
    }
}

