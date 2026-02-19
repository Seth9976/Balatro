package q1;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import c1.a;
import c2.b;
import c2.f1;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.PlayerEntity;
import e1.i;
import g1.e;
import g1.h;
import g1.q;
import java.util.Set;
import p1.d0;
import p1.f;
import p1.l;
import p1.m;
import p1.v;
import v1.g;

public final class d extends h {
    private final b I;
    private final String J;
    private PlayerEntity K;
    private final j L;
    private boolean M;
    private final long N;
    private final d0 O;
    private final k P;

    public d(Context context0, Looper looper0, e e0, d0 d00, e1.d d0, i i0, k k0) {
        super(context0, looper0, 1, e0, d0, i0);
        this.I = new w(this);
        this.M = false;
        this.J = e0.g();
        this.P = (k)q.i(k0);
        j j0 = j.d(this, e0.f());
        this.L = j0;
        this.N = (long)this.hashCode();
        this.O = d00;
        if(e0.i() == null && !(context0 instanceof Activity)) {
            return;
        }
        j0.f(e0.i());
    }

    @Override  // g1.d
    protected final String D() {
        return "com.google.android.gms.games.internal.IGamesService";
    }

    @Override  // g1.d
    protected final String E() {
        return "com.google.android.gms.games.service.START";
    }

    @Override  // g1.d
    public final void J(IInterface iInterface0) {
        q1.i i0 = (q1.i)iInterface0;
        super.J(i0);
        if(this.M) {
            this.L.g();
            this.M = false;
        }
        try {
            i0.X(new x(new c2.d(this.L.e())), this.N);
        }
        catch(RemoteException remoteException0) {
            d.p0(remoteException0);
        }
    }

    @Override  // g1.d
    public final void K(a a0) {
        super.K(a0);
        this.M = false;
    }

    @Override  // g1.d
    protected final void M(int v, IBinder iBinder0, Bundle bundle0, int v1) {
        if(v == 0) {
            v = 0;
            if(bundle0 != null) {
                bundle0.setClassLoader(d.class.getClassLoader());
                this.M = bundle0.getBoolean("show_welcome_popup");
                this.K = (PlayerEntity)bundle0.getParcelable("com.google.android.gms.games.current_player");
                GameEntity gameEntity0 = (GameEntity)bundle0.getParcelable("com.google.android.gms.games.current_game");
            }
        }
        super.M(v, iBinder0, bundle0, v1);
    }

    @Override  // g1.d
    public final boolean N() {
        return true;
    }

    @Override  // g1.d
    public final boolean Q() {
        return true;
    }

    @Override  // g1.h
    public final Set g() {
        return this.B();
    }

    @Override  // g1.d, d1.a$f
    public final void h(g1.d.e d$e0) {
        try {
            y y0 = new y(d$e0);
            this.I.a();
            try {
                ((q1.i)this.C()).a0(new z(y0));
            }
            catch(SecurityException unused_ex) {
                y0.b(f.b(4));
            }
        }
        catch(RemoteException unused_ex) {
            d$e0.a();
        }
    }

    @Override  // g1.d, d1.a$f
    public final void i() {
        this.M = false;
        if(this.c()) {
            try {
                this.I.a();
                ((q1.i)this.C()).f0(this.N);
            }
            catch(RemoteException unused_ex) {
                f1.g("GamesGmsClientImpl", "Failed to notify client disconnect.");
            }
        }
        super.i();
    }

    @Override  // g1.d, d1.a$f
    public final boolean k() {
        return !this.O.t.b();
    }

    public final void k0(g2.i i0, String s, boolean z, int v) {
        try {
            ((q1.i)this.C()).W(new c(i0), s, z, v);
        }
        catch(SecurityException securityException0) {
            p1.h.b(i0, securityException0);
        }
    }

    public final void l0(g2.i i0, String s, String s1, g g0, v1.b b0) {
        q.l(!b0.u(), "SnapshotContents already closed");
        BitmapTeleporter bitmapTeleporter0 = g0.a();
        if(bitmapTeleporter0 != null) {
            bitmapTeleporter0.j0(this.x().getCacheDir());
        }
        n1.a a0 = b0.a();
        b0.b();
        try {
            ((q1.i)this.C()).Y(new c(i0), s, s1, ((v1.h)g0), a0);
        }
        catch(SecurityException securityException0) {
            p1.h.b(i0, securityException0);
        }
    }

    final void m0(IBinder iBinder0, Bundle bundle0) {
        if(!this.c() || this.O.t.d() && this.P.c()) {
            return;
        }
        try {
            ((q1.i)this.C()).Z(iBinder0, bundle0);
            this.P.b();
        }
        catch(RemoteException remoteException0) {
            d.p0(remoteException0);
        }
    }

    @Override  // g1.d, d1.a$f
    public final void n(g1.d.c d$c0) {
        this.K = null;
        super.n(d$c0);
    }

    public final void n0(q1.q q0) {
        q0.e(this.L);
    }

    @Override  // g1.d, d1.a$f
    public final int o() {
        return 12451000;
    }

    public final void o0(g2.i i0, String s) {
        a0 a00 = i0 == null ? null : new a0(i0);
        try {
            ((q1.i)this.C()).b0(a00, s, this.L.c(), this.L.b());
        }
        catch(SecurityException securityException0) {
            p1.h.b(i0, securityException0);
        }
    }

    private static void p0(RemoteException remoteException0) {
        f1.h("GamesGmsClientImpl", "service died", remoteException0);
    }

    public final l q0() {
        this.q();
        synchronized(this) {
            if(this.K == null) {
                m m0 = new m(((q1.i)this.C()).d0());
                try {
                    if(m0.getCount() > 0) {
                        this.K = new PlayerEntity(m0.n(0));
                    }
                }
                finally {
                    m0.e();
                }
            }
            return this.K;
        }
    }

    @Override  // g1.d
    protected final IInterface r(IBinder iBinder0) {
        if(iBinder0 == null) {
            return null;
        }
        IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.games.internal.IGamesService");
        return iInterface0 instanceof q1.i ? ((q1.i)iInterface0) : new q1.i(iBinder0);
    }

    final void r0() {
        if(this.c()) {
            try {
                ((q1.i)this.C()).e0();
            }
            catch(RemoteException remoteException0) {
                d.p0(remoteException0);
            }
        }
    }

    public final void s0(g2.i i0, v1.a a0, g g0) {
        v1.b b0 = a0.Z();
        q.l(!b0.u(), "Snapshot already closed");
        BitmapTeleporter bitmapTeleporter0 = g0.a();
        if(bitmapTeleporter0 != null) {
            bitmapTeleporter0.j0(this.x().getCacheDir());
        }
        n1.a a1 = b0.a();
        b0.b();
        try {
            ((q1.i)this.C()).g0(new b0(i0), a0.t().f0(), ((v1.h)g0), a1);
        }
        catch(SecurityException securityException0) {
            p1.h.b(i0, securityException0);
        }
    }

    @Override  // g1.d
    public final c1.c[] u() {
        return v.h;
    }

    @Override  // g1.d
    public final Bundle w() {
        return null;
    }

    @Override  // g1.d
    protected final Bundle z() {
        String s = this.x().getResources().getConfiguration().locale.toString();
        Bundle bundle0 = this.O.a();
        bundle0.putString("com.google.android.gms.games.key.gamePackageName", this.J);
        bundle0.putString("com.google.android.gms.games.key.desiredLocale", s);
        bundle0.putParcelable("com.google.android.gms.games.key.popupWindowToken", new BinderWrapper(this.L.c()));
        if(!bundle0.containsKey("com.google.android.gms.games.key.API_VERSION")) {
            bundle0.putInt("com.google.android.gms.games.key.API_VERSION", 9);
        }
        bundle0.putBundle("com.google.android.gms.games.key.signInOptions", f2.a.k0(this.h0()));
        return bundle0;
    }
}

