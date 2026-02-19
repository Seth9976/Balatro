package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import g1.q;
import h1.a;
import h1.c;

public class SignInAccount extends a implements ReflectedParcelable {
    public static final Parcelable.Creator CREATOR;
    final String e;
    private final GoogleSignInAccount f;
    final String g;

    static {
        SignInAccount.CREATOR = new g();
    }

    SignInAccount(String s, GoogleSignInAccount googleSignInAccount0, String s1) {
        this.f = googleSignInAccount0;
        this.e = q.g(s, "8.3 and 8.4 SDKs require non-null email");
        this.g = q.g(s1, "8.3 and 8.4 SDKs require non-null userId");
    }

    public final GoogleSignInAccount j0() {
        return this.f;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = c.a(parcel0);
        c.n(parcel0, 4, this.e, false);
        c.m(parcel0, 7, this.f, v, false);
        c.n(parcel0, 8, this.g, false);
        c.b(parcel0, v1);
    }
}

