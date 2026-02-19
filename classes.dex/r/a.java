package r;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.os.Parcelable;

public abstract class a implements Parcelable {
    static final class r.a.a extends a {
        r.a.a() {
            super(null);
        }
    }

    static final class b implements Parcelable.ClassLoaderCreator {
        public a a(Parcel parcel0) {
            return this.b(parcel0, null);
        }

        public a b(Parcel parcel0, ClassLoader classLoader0) {
            if(parcel0.readParcelable(classLoader0) != null) {
                throw new IllegalStateException("superState must be null");
            }
            return a.f;
        }

        public a[] c(int v) {
            return new a[v];
        }

        @Override  // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel0) {
            return this.a(parcel0);
        }

        @Override  // android.os.Parcelable$ClassLoaderCreator
        public Object createFromParcel(Parcel parcel0, ClassLoader classLoader0) {
            return this.b(parcel0, classLoader0);
        }

        @Override  // android.os.Parcelable$Creator
        public Object[] newArray(int v) {
            return this.c(v);
        }
    }

    public static final Parcelable.Creator CREATOR;
    private final Parcelable e;
    public static final a f;

    static {
        a.f = new r.a.a();
        a.CREATOR = new b();
    }

    private a() {
        this.e = null;
    }

    protected a(Parcel parcel0, ClassLoader classLoader0) {
        Parcelable parcelable0 = parcel0.readParcelable(classLoader0);
        if(parcelable0 == null) {
            parcelable0 = a.f;
        }
        this.e = parcelable0;
    }

    protected a(Parcelable parcelable0) {
        if(parcelable0 == null) {
            throw new IllegalArgumentException("superState must not be null");
        }
        if(parcelable0 == a.f) {
            parcelable0 = null;
        }
        this.e = parcelable0;
    }

    a(r.a.a a$a0) {
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final Parcelable o() {
        return this.e;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeParcelable(this.e, v);
    }
}

