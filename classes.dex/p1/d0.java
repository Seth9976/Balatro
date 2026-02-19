package p1;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import d1.a.d.a;
import d1.a.d;
import g1.o;
import java.util.ArrayList;
import q1.v;

public final class d0 implements a, d {
    public final boolean e;
    public final boolean f;
    public final int g;
    public final boolean h;
    public final int i;
    public final String j;
    public final ArrayList k;
    public final boolean l;
    public final boolean m;
    public final boolean n;
    public final GoogleSignInAccount o;
    public final String p;
    private final int q;
    public final int r;
    public final String s;
    public final v t;

    d0(boolean z, boolean z1, int v, boolean z2, int v1, String s, ArrayList arrayList0, boolean z3, boolean z4, boolean z5, GoogleSignInAccount googleSignInAccount0, String s1, int v2, int v3, String s2, v v4, c0 c00) {
        this.e = false;
        this.f = true;
        this.g = 17;
        this.h = false;
        this.i = v1;
        this.j = null;
        this.k = arrayList0;
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = googleSignInAccount0;
        this.p = null;
        this.q = 0;
        this.r = 9;
        this.s = s2;
        this.t = v4;
    }

    public final Bundle a() {
        Bundle bundle0 = new Bundle();
        bundle0.putBoolean("com.google.android.gms.games.key.isHeadless", false);
        bundle0.putBoolean("com.google.android.gms.games.key.showConnectingPopup", true);
        bundle0.putInt("com.google.android.gms.games.key.connectingPopupGravity", 17);
        bundle0.putBoolean("com.google.android.gms.games.key.retryingSignIn", false);
        bundle0.putInt("com.google.android.gms.games.key.sdkVariant", this.i);
        bundle0.putString("com.google.android.gms.games.key.forceResolveAccountKey", null);
        bundle0.putStringArrayList("com.google.android.gms.games.key.proxyApis", this.k);
        bundle0.putBoolean("com.google.android.gms.games.key.unauthenticated", false);
        bundle0.putBoolean("com.google.android.gms.games.key.skipPgaCheck", false);
        bundle0.putBoolean("com.google.android.gms.games.key.skipWelcomePopup", false);
        bundle0.putParcelable("com.google.android.gms.games.key.googleSignInAccount", this.o);
        bundle0.putString("com.google.android.gms.games.key.realClientPackageName", null);
        bundle0.putInt("com.google.android.gms.games.key.API_VERSION", 9);
        bundle0.putString("com.google.android.gms.games.key.gameRunToken", this.s);
        return bundle0;
    }

    public static b0 b() {
        return new b0(null);
    }

    @Override  // d1.a$d$a
    public final GoogleSignInAccount b0() {
        return this.o;
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        if(!(object0 instanceof d0)) {
            return false;
        }
        if(this.i == ((d0)object0).i && this.k.equals(((d0)object0).k)) {
            GoogleSignInAccount googleSignInAccount0 = this.o;
            if(googleSignInAccount0 == null) {
                return ((d0)object0).o == null ? TextUtils.equals(null, null) && o.a(this.s, ((d0)object0).s) : false;
            }
            return googleSignInAccount0.equals(((d0)object0).o) ? TextUtils.equals(null, null) && o.a(this.s, ((d0)object0).s) : false;
        }
        return false;
    }

    @Override
    public final int hashCode() {
        int v = (this.i + 0x1D0316BF) * 961 + this.k.hashCode();
        int v1 = 0;
        int v2 = this.o == null ? 0 : this.o.hashCode();
        String s = this.s;
        if(s != null) {
            v1 = s.hashCode();
        }
        return 279 + 0x94446F01 * v + v1 + 0xE1781 * v2;
    }
}

