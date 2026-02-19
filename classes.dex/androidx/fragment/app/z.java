package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import java.util.ArrayList;

final class z implements Parcelable {
    class a implements Parcelable.Creator {
        a() {
            super();
        }

        public z a(Parcel parcel0) {
            return new z(parcel0);
        }

        public z[] b(int v) {
            return new z[v];
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
    ArrayList e;
    ArrayList f;
    b[] g;
    int h;
    String i;
    ArrayList j;
    ArrayList k;
    ArrayList l;

    static {
        z.CREATOR = new a();
    }

    public z() {
        this.i = null;
        this.j = new ArrayList();
        this.k = new ArrayList();
    }

    public z(Parcel parcel0) {
        this.i = null;
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.e = parcel0.createStringArrayList();
        this.f = parcel0.createStringArrayList();
        this.g = (b[])parcel0.createTypedArray(b.CREATOR);
        this.h = parcel0.readInt();
        this.i = parcel0.readString();
        this.j = parcel0.createStringArrayList();
        this.k = parcel0.createTypedArrayList(c.CREATOR);
        this.l = parcel0.createTypedArrayList(k.CREATOR);
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeStringList(this.e);
        parcel0.writeStringList(this.f);
        parcel0.writeTypedArray(this.g, v);
        parcel0.writeInt(this.h);
        parcel0.writeString(this.i);
        parcel0.writeStringList(this.j);
        parcel0.writeTypedList(this.k);
        parcel0.writeTypedList(this.l);
    }
}

