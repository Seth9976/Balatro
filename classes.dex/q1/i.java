package q1;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import c2.a;
import c2.m0;
import com.google.android.gms.common.data.DataHolder;

public final class i extends a {
    i(IBinder iBinder0) {
        super(iBinder0, "com.google.android.gms.games.internal.IGamesService");
    }

    public final void W(f f0, String s, boolean z, int v) {
        Parcel parcel0 = this.a();
        m0.d(parcel0, f0);
        parcel0.writeString(s);
        parcel0.writeInt(((int)z));
        parcel0.writeInt(v);
        this.f(15001, parcel0);
    }

    public final void X(h h0, long v) {
        Parcel parcel0 = this.a();
        m0.d(parcel0, h0);
        parcel0.writeLong(v);
        this.f(15501, parcel0);
    }

    public final void Y(f f0, String s, String s1, v1.h h0, n1.a a0) {
        Parcel parcel0 = this.a();
        m0.d(parcel0, f0);
        parcel0.writeString(s);
        parcel0.writeString(s1);
        m0.c(parcel0, h0);
        m0.c(parcel0, a0);
        this.f(0x2F01, parcel0);
    }

    public final void Z(IBinder iBinder0, Bundle bundle0) {
        Parcel parcel0 = this.a();
        parcel0.writeStrongBinder(iBinder0);
        m0.c(parcel0, bundle0);
        this.f(5005, parcel0);
    }

    public final void a0(f f0) {
        Parcel parcel0 = this.a();
        m0.d(parcel0, f0);
        this.f(5002, parcel0);
    }

    public final void b0(f f0, String s, IBinder iBinder0, Bundle bundle0) {
        Parcel parcel0 = this.a();
        m0.d(parcel0, f0);
        parcel0.writeString(s);
        parcel0.writeStrongBinder(iBinder0);
        m0.c(parcel0, bundle0);
        this.f(5024, parcel0);
    }

    public final Intent c0() {
        Parcel parcel0 = this.d(9005, this.a());
        Intent intent0 = (Intent)m0.a(parcel0, Intent.CREATOR);
        parcel0.recycle();
        return intent0;
    }

    public final DataHolder d0() {
        Parcel parcel0 = this.d(5013, this.a());
        DataHolder dataHolder0 = (DataHolder)m0.a(parcel0, DataHolder.CREATOR);
        parcel0.recycle();
        return dataHolder0;
    }

    public final void e0() {
        this.f(5006, this.a());
    }

    public final void f0(long v) {
        Parcel parcel0 = this.a();
        parcel0.writeLong(v);
        this.f(5001, parcel0);
    }

    public final void g0(f f0, String s, v1.h h0, n1.a a0) {
        Parcel parcel0 = this.a();
        m0.d(parcel0, f0);
        parcel0.writeString(s);
        m0.c(parcel0, h0);
        m0.c(parcel0, a0);
        this.f(12007, parcel0);
    }

    public final void h0(n1.a a0) {
        Parcel parcel0 = this.a();
        m0.c(parcel0, a0);
        this.f(0x2EF3, parcel0);
    }
}

