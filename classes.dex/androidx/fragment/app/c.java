package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import java.util.List;

class c implements Parcelable {
    class a implements Parcelable.Creator {
        a() {
            super();
        }

        public c a(Parcel parcel0) {
            return new c(parcel0);
        }

        public c[] b(int v) {
            return new c[v];
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
    final List e;
    final List f;

    static {
        c.CREATOR = new a();
    }

    c(Parcel parcel0) {
        this.e = parcel0.createStringArrayList();
        this.f = parcel0.createTypedArrayList(b.CREATOR);
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeStringList(this.e);
        parcel0.writeTypedList(this.f);
    }
}

