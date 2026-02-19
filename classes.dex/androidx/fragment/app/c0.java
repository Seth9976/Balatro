package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import androidx.lifecycle.h.c;

final class c0 implements Parcelable {
    class a implements Parcelable.Creator {
        a() {
            super();
        }

        public c0 a(Parcel parcel0) {
            return new c0(parcel0);
        }

        public c0[] b(int v) {
            return new c0[v];
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
    final String e;
    final String f;
    final boolean g;
    final int h;
    final int i;
    final String j;
    final boolean k;
    final boolean l;
    final boolean m;
    final Bundle n;
    final boolean o;
    final int p;
    Bundle q;

    static {
        c0.CREATOR = new a();
    }

    c0(Parcel parcel0) {
        this.e = parcel0.readString();
        this.f = parcel0.readString();
        boolean z = true;
        this.g = parcel0.readInt() != 0;
        this.h = parcel0.readInt();
        this.i = parcel0.readInt();
        this.j = parcel0.readString();
        this.k = parcel0.readInt() != 0;
        this.l = parcel0.readInt() != 0;
        this.m = parcel0.readInt() != 0;
        this.n = parcel0.readBundle();
        if(parcel0.readInt() == 0) {
            z = false;
        }
        this.o = z;
        this.q = parcel0.readBundle();
        this.p = parcel0.readInt();
    }

    c0(Fragment fragment0) {
        this.e = fragment0.getClass().getName();
        this.f = fragment0.f;
        this.g = fragment0.o;
        this.h = fragment0.x;
        this.i = fragment0.y;
        this.j = fragment0.z;
        this.k = fragment0.C;
        this.l = fragment0.m;
        this.m = fragment0.B;
        this.n = fragment0.g;
        this.o = fragment0.A;
        this.p = fragment0.S.ordinal();
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    Fragment o(o o0, ClassLoader classLoader0) {
        Fragment fragment0 = o0.a(classLoader0, this.e);
        Bundle bundle0 = this.n;
        if(bundle0 != null) {
            bundle0.setClassLoader(classLoader0);
        }
        fragment0.t1(this.n);
        fragment0.f = this.f;
        fragment0.o = this.g;
        fragment0.q = true;
        fragment0.x = this.h;
        fragment0.y = this.i;
        fragment0.z = this.j;
        fragment0.C = this.k;
        fragment0.m = this.l;
        fragment0.B = this.m;
        fragment0.A = this.o;
        c[] arr_h$c = c.values();
        fragment0.S = arr_h$c[this.p];
        fragment0.b = this.q == null ? new Bundle() : this.q;
        return fragment0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder(0x80);
        stringBuilder0.append("FragmentState{");
        stringBuilder0.append(this.e);
        stringBuilder0.append(" (");
        stringBuilder0.append(this.f);
        stringBuilder0.append(")}:");
        if(this.g) {
            stringBuilder0.append(" fromLayout");
        }
        if(this.i != 0) {
            stringBuilder0.append(" id=0x");
            stringBuilder0.append(Integer.toHexString(this.i));
        }
        if(this.j != null && !this.j.isEmpty()) {
            stringBuilder0.append(" tag=");
            stringBuilder0.append(this.j);
        }
        if(this.k) {
            stringBuilder0.append(" retainInstance");
        }
        if(this.l) {
            stringBuilder0.append(" removing");
        }
        if(this.m) {
            stringBuilder0.append(" detached");
        }
        if(this.o) {
            stringBuilder0.append(" hidden");
        }
        return stringBuilder0.toString();
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.e);
        parcel0.writeString(this.f);
        parcel0.writeInt(((int)this.g));
        parcel0.writeInt(this.h);
        parcel0.writeInt(this.i);
        parcel0.writeString(this.j);
        parcel0.writeInt(((int)this.k));
        parcel0.writeInt(((int)this.l));
        parcel0.writeInt(((int)this.m));
        parcel0.writeBundle(this.n);
        parcel0.writeInt(((int)this.o));
        parcel0.writeBundle(this.q);
        parcel0.writeInt(this.p);
    }
}

