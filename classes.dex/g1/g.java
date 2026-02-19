package g1;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import c1.c;
import com.google.android.gms.common.api.Scope;
import h1.a;

public class g extends a {
    public static final Parcelable.Creator CREATOR;
    final int e;
    final int f;
    final int g;
    String h;
    IBinder i;
    Scope[] j;
    Bundle k;
    Account l;
    c[] m;
    c[] n;
    final boolean o;
    final int p;
    boolean q;
    private final String r;
    static final Scope[] s;
    static final c[] t;

    static {
        g.CREATOR = new h1();
        g.s = new Scope[0];
        g.t = new c[0];
    }

    g(int v, int v1, int v2, String s, IBinder iBinder0, Scope[] arr_scope, Bundle bundle0, Account account0, c[] arr_c, c[] arr_c1, boolean z, int v3, boolean z1, String s1) {
        if(arr_scope == null) {
            arr_scope = g.s;
        }
        if(bundle0 == null) {
            bundle0 = new Bundle();
        }
        if(arr_c == null) {
            arr_c = g.t;
        }
        if(arr_c1 == null) {
            arr_c1 = g.t;
        }
        this.e = v;
        this.f = v1;
        this.g = v2;
        this.h = "com.google.android.gms".equals(s) ? "com.google.android.gms" : s;
        if(v < 2) {
            this.l = iBinder0 == null ? null : g1.a.f(g1.k.a.d(iBinder0));
        }
        else {
            this.i = iBinder0;
            this.l = account0;
        }
        this.j = arr_scope;
        this.k = bundle0;
        this.m = arr_c;
        this.n = arr_c1;
        this.o = z;
        this.p = v3;
        this.q = z1;
        this.r = s1;
    }

    public final String a() {
        return this.r;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        h1.a(this, parcel0, v);
    }
}

