package g1;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import h1.b;
import h1.c;

public final class h1 implements Parcelable.Creator {
    static void a(g g0, Parcel parcel0, int v) {
        int v1 = c.a(parcel0);
        c.i(parcel0, 1, g0.e);
        c.i(parcel0, 2, g0.f);
        c.i(parcel0, 3, g0.g);
        c.n(parcel0, 4, g0.h, false);
        c.h(parcel0, 5, g0.i, false);
        c.q(parcel0, 6, g0.j, v, false);
        c.f(parcel0, 7, g0.k, false);
        c.m(parcel0, 8, g0.l, v, false);
        c.q(parcel0, 10, g0.m, v, false);
        c.q(parcel0, 11, g0.n, v, false);
        c.c(parcel0, 12, g0.o);
        c.i(parcel0, 13, g0.p);
        c.c(parcel0, 14, g0.q);
        c.n(parcel0, 15, g0.a(), false);
        c.b(parcel0, v1);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = b.v(parcel0);
        Bundle bundle0 = new Bundle();
        Scope[] arr_scope = g.s;
        Bundle bundle1 = bundle0;
        c1.c[] arr_c = g.t;
        c1.c[] arr_c1 = arr_c;
        String s = null;
        IBinder iBinder0 = null;
        Account account0 = null;
        String s1 = null;
        int v1 = 0;
        int v2 = 0;
        int v3 = 0;
        boolean z = false;
        int v4 = 0;
        boolean z1 = false;
        while(parcel0.dataPosition() < v) {
            int v5 = b.o(parcel0);
            switch(((char)v5)) {
                case 1: {
                    v1 = b.q(parcel0, v5);
                    break;
                }
                case 2: {
                    v2 = b.q(parcel0, v5);
                    break;
                }
                case 3: {
                    v3 = b.q(parcel0, v5);
                    break;
                }
                case 4: {
                    s = b.e(parcel0, v5);
                    break;
                }
                case 5: {
                    iBinder0 = b.p(parcel0, v5);
                    break;
                }
                case 6: {
                    arr_scope = (Scope[])b.h(parcel0, v5, Scope.CREATOR);
                    break;
                }
                case 7: {
                    bundle1 = b.b(parcel0, v5);
                    break;
                }
                case 8: {
                    account0 = (Account)b.d(parcel0, v5, Account.CREATOR);
                    break;
                }
                case 10: {
                    arr_c = (c1.c[])b.h(parcel0, v5, c1.c.CREATOR);
                    break;
                }
                case 11: {
                    arr_c1 = (c1.c[])b.h(parcel0, v5, c1.c.CREATOR);
                    break;
                }
                case 12: {
                    z = b.l(parcel0, v5);
                    break;
                }
                case 13: {
                    v4 = b.q(parcel0, v5);
                    break;
                }
                case 14: {
                    z1 = b.l(parcel0, v5);
                    break;
                }
                case 15: {
                    s1 = b.e(parcel0, v5);
                    break;
                }
                default: {
                    b.u(parcel0, v5);
                }
            }
        }
        b.j(parcel0, v);
        return new g(v1, v2, v3, s, iBinder0, arr_scope, bundle1, account0, arr_c, arr_c1, z, v4, z1, s1);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new g[v];
    }
}

