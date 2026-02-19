package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.lifecycle.h.c;
import java.util.ArrayList;

final class b implements Parcelable {
    class a implements Parcelable.Creator {
        a() {
            super();
        }

        public b a(Parcel parcel0) {
            return new b(parcel0);
        }

        public b[] b(int v) {
            return new b[v];
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
    final int[] e;
    final ArrayList f;
    final int[] g;
    final int[] h;
    final int i;
    final String j;
    final int k;
    final int l;
    final CharSequence m;
    final int n;
    final CharSequence o;
    final ArrayList p;
    final ArrayList q;
    final boolean r;

    static {
        b.CREATOR = new a();
    }

    b(Parcel parcel0) {
        this.e = parcel0.createIntArray();
        this.f = parcel0.createStringArrayList();
        this.g = parcel0.createIntArray();
        this.h = parcel0.createIntArray();
        this.i = parcel0.readInt();
        this.j = parcel0.readString();
        this.k = parcel0.readInt();
        this.l = parcel0.readInt();
        this.m = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel0);
        this.n = parcel0.readInt();
        this.o = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel0);
        this.p = parcel0.createStringArrayList();
        this.q = parcel0.createStringArrayList();
        this.r = parcel0.readInt() != 0;
    }

    b(androidx.fragment.app.a a0) {
        int v = a0.c.size();
        this.e = new int[v * 6];
        if(!a0.i) {
            throw new IllegalStateException("Not on back stack");
        }
        this.f = new ArrayList(v);
        this.g = new int[v];
        this.h = new int[v];
        int v1 = 0;
        for(int v2 = 0; v1 < v; v2 += 6) {
            androidx.fragment.app.f0.a f0$a0 = (androidx.fragment.app.f0.a)a0.c.get(v1);
            this.e[v2] = f0$a0.a;
            this.f.add((f0$a0.b == null ? null : f0$a0.b.f));
            this.e[v2 + 1] = f0$a0.c;
            this.e[v2 + 2] = f0$a0.d;
            this.e[v2 + 3] = f0$a0.e;
            this.e[v2 + 4] = f0$a0.f;
            this.e[v2 + 5] = f0$a0.g;
            this.g[v1] = f0$a0.h.ordinal();
            this.h[v1] = f0$a0.i.ordinal();
            ++v1;
        }
        this.i = a0.h;
        this.j = a0.k;
        this.k = a0.v;
        this.l = a0.l;
        this.m = a0.m;
        this.n = a0.n;
        this.o = a0.o;
        this.p = a0.p;
        this.q = a0.q;
        this.r = a0.r;
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private void o(androidx.fragment.app.a a0) {
        int v1 = 0;
        for(int v = 0; true; v += 6) {
            boolean z = true;
            if(v >= this.e.length) {
                break;
            }
            androidx.fragment.app.f0.a f0$a0 = new androidx.fragment.app.f0.a();
            f0$a0.a = this.e[v];
            if(x.G0(2)) {
                Log.v("FragmentManager", "Instantiate " + a0 + " op #" + v1 + " base fragment #" + this.e[v + 1]);
            }
            c[] arr_h$c = c.values();
            f0$a0.h = arr_h$c[this.g[v1]];
            c[] arr_h$c1 = c.values();
            f0$a0.i = arr_h$c1[this.h[v1]];
            int[] arr_v = this.e;
            if(arr_v[v + 1] == 0) {
                z = false;
            }
            f0$a0.c = z;
            int v2 = arr_v[v + 2];
            f0$a0.d = v2;
            int v3 = arr_v[v + 3];
            f0$a0.e = v3;
            int v4 = arr_v[v + 4];
            f0$a0.f = v4;
            int v5 = arr_v[v + 5];
            f0$a0.g = v5;
            a0.d = v2;
            a0.e = v3;
            a0.f = v4;
            a0.g = v5;
            a0.e(f0$a0);
            ++v1;
        }
        a0.h = this.i;
        a0.k = this.j;
        a0.i = true;
        a0.l = this.l;
        a0.m = this.m;
        a0.n = this.n;
        a0.o = this.o;
        a0.p = this.p;
        a0.q = this.q;
        a0.r = this.r;
    }

    public androidx.fragment.app.a s(x x0) {
        androidx.fragment.app.a a0 = new androidx.fragment.app.a(x0);
        this.o(a0);
        a0.v = this.k;
        for(int v = 0; v < this.f.size(); ++v) {
            String s = (String)this.f.get(v);
            if(s != null) {
                androidx.fragment.app.f0.a f0$a0 = (androidx.fragment.app.f0.a)a0.c.get(v);
                f0$a0.b = x0.e0(s);
            }
        }
        a0.n(1);
        return a0;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeIntArray(this.e);
        parcel0.writeStringList(this.f);
        parcel0.writeIntArray(this.g);
        parcel0.writeIntArray(this.h);
        parcel0.writeInt(this.i);
        parcel0.writeString(this.j);
        parcel0.writeInt(this.k);
        parcel0.writeInt(this.l);
        TextUtils.writeToParcel(this.m, parcel0, 0);
        parcel0.writeInt(this.n);
        TextUtils.writeToParcel(this.o, parcel0, 0);
        parcel0.writeStringList(this.p);
        parcel0.writeStringList(this.q);
        parcel0.writeInt(((int)this.r));
    }
}

