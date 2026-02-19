package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;

class b extends a {
    private final SparseIntArray d;
    private final Parcel e;
    private final int f;
    private final int g;
    private final String h;
    private int i;
    private int j;
    private int k;

    b(Parcel parcel0) {
        this(parcel0, parcel0.dataPosition(), parcel0.dataSize(), "", new k.a(), new k.a(), new k.a());
    }

    private b(Parcel parcel0, int v, int v1, String s, k.a a0, k.a a1, k.a a2) {
        super(a0, a1, a2);
        this.d = new SparseIntArray();
        this.i = -1;
        this.k = -1;
        this.e = parcel0;
        this.f = v;
        this.g = v1;
        this.j = v;
        this.h = s;
    }

    @Override  // androidx.versionedparcelable.a
    public void A(byte[] arr_b) {
        if(arr_b != null) {
            this.e.writeInt(arr_b.length);
            this.e.writeByteArray(arr_b);
            return;
        }
        this.e.writeInt(-1);
    }

    @Override  // androidx.versionedparcelable.a
    protected void C(CharSequence charSequence0) {
        TextUtils.writeToParcel(charSequence0, this.e, 0);
    }

    @Override  // androidx.versionedparcelable.a
    public void E(int v) {
        this.e.writeInt(v);
    }

    @Override  // androidx.versionedparcelable.a
    public void G(Parcelable parcelable0) {
        this.e.writeParcelable(parcelable0, 0);
    }

    @Override  // androidx.versionedparcelable.a
    public void I(String s) {
        this.e.writeString(s);
    }

    @Override  // androidx.versionedparcelable.a
    public void a() {
        int v = this.i;
        if(v >= 0) {
            int v1 = this.d.get(v);
            int v2 = this.e.dataPosition();
            this.e.setDataPosition(v1);
            this.e.writeInt(v2 - v1);
            this.e.setDataPosition(v2);
        }
    }

    @Override  // androidx.versionedparcelable.a
    protected a b() {
        int v = this.e.dataPosition();
        return new b(this.e, v, (this.j == this.f ? this.g : this.j), this.h + "  ", this.a, this.b, this.c);
    }

    @Override  // androidx.versionedparcelable.a
    public boolean g() {
        return this.e.readInt() != 0;
    }

    @Override  // androidx.versionedparcelable.a
    public byte[] i() {
        int v = this.e.readInt();
        if(v < 0) {
            return null;
        }
        byte[] arr_b = new byte[v];
        this.e.readByteArray(arr_b);
        return arr_b;
    }

    @Override  // androidx.versionedparcelable.a
    protected CharSequence k() {
        return (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.e);
    }

    @Override  // androidx.versionedparcelable.a
    public boolean m(int v) {
        boolean z;
        while(this.j < this.g) {
            int v1 = this.k;
            if(v1 == v) {
                return true;
            }
            if(String.valueOf(v1).compareTo(String.valueOf(v)) > 0) {
                return false;
            }
            z = true;
            this.e.setDataPosition(this.j);
            int v2 = this.e.readInt();
            this.k = this.e.readInt();
            this.j += v2;
        }
        return this.k == v ? z : false;
    }

    @Override  // androidx.versionedparcelable.a
    public int o() {
        return this.e.readInt();
    }

    @Override  // androidx.versionedparcelable.a
    public Parcelable q() {
        ClassLoader classLoader0 = this.getClass().getClassLoader();
        return this.e.readParcelable(classLoader0);
    }

    @Override  // androidx.versionedparcelable.a
    public String s() {
        return this.e.readString();
    }

    @Override  // androidx.versionedparcelable.a
    public void w(int v) {
        this.a();
        this.i = v;
        int v1 = this.e.dataPosition();
        this.d.put(v, v1);
        this.E(0);
        this.E(v);
    }

    @Override  // androidx.versionedparcelable.a
    public void y(boolean z) {
        this.e.writeInt(((int)z));
    }
}

