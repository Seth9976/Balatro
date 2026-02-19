package com.google.android.gms.auth.api.signin.internal;

import a1.b;
import a1.w;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import g1.q;
import h1.a;
import h1.c;

public final class SignInConfiguration extends a implements ReflectedParcelable {
    public static final Parcelable.Creator CREATOR;
    private final String e;
    private final GoogleSignInOptions f;

    static {
        SignInConfiguration.CREATOR = new w();
    }

    public SignInConfiguration(String s, GoogleSignInOptions googleSignInOptions0) {
        this.e = q.f(s);
        this.f = googleSignInOptions0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(!(object0 instanceof SignInConfiguration)) {
            return false;
        }
        if(this.e.equals(((SignInConfiguration)object0).e)) {
            GoogleSignInOptions googleSignInOptions0 = ((SignInConfiguration)object0).f;
            return this.f == null ? googleSignInOptions0 == null : this.f.equals(googleSignInOptions0);
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return new b().a(this.e).a(this.f).b();
    }

    public final GoogleSignInOptions j0() {
        return this.f;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = c.a(parcel0);
        c.n(parcel0, 2, this.e, false);
        c.m(parcel0, 5, this.f, v, false);
        c.b(parcel0, v1);
    }
}

