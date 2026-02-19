package f2;

import a1.c;
import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import d1.f.b;
import e2.e;
import g1.d.d;
import g1.h;
import g1.m0;
import g1.q;

public class a extends h implements e {
    private final boolean I;
    private final g1.e J;
    private final Bundle K;
    private final Integer L;
    public static final int M;

    public a(Context context0, Looper looper0, boolean z, g1.e e0, Bundle bundle0, d1.f.a f$a0, b f$b0) {
        super(context0, looper0, 44, e0, f$a0, f$b0);
        this.I = true;
        this.J = e0;
        this.K = bundle0;
        this.L = e0.k();
    }

    @Override  // g1.d
    protected final String D() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override  // g1.d
    protected final String E() {
        return "com.google.android.gms.signin.service.START";
    }

    @Override  // e2.e
    public final void f(f f0) {
        q.j(f0, "Expecting a valid ISignInCallbacks");
        try {
            Account account0 = this.J.c();
            GoogleSignInAccount googleSignInAccount0 = "<<default account>>".equals(account0.name) ? c.b(this.x()).c() : null;
            m0 m00 = new m0(account0, ((int)(((Integer)q.i(this.L)))), googleSignInAccount0);
            ((g)this.C()).W(new j(1, m00), f0);
        }
        catch(RemoteException remoteException0) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                f0.m(new l(1, new c1.a(8, null), null));
            }
            catch(RemoteException unused_ex) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", remoteException0);
            }
        }
    }

    @Override  // g1.d, d1.a$f
    public final boolean k() {
        return this.I;
    }

    public static Bundle k0(g1.e e0) {
        Integer integer0 = e0.k();
        Bundle bundle0 = new Bundle();
        bundle0.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", e0.a());
        if(integer0 != null) {
            bundle0.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", ((int)integer0));
        }
        bundle0.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", false);
        bundle0.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", false);
        bundle0.putString("com.google.android.gms.signin.internal.serverClientId", null);
        bundle0.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
        bundle0.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", false);
        bundle0.putString("com.google.android.gms.signin.internal.hostedDomain", null);
        bundle0.putString("com.google.android.gms.signin.internal.logSessionId", null);
        bundle0.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", false);
        return bundle0;
    }

    @Override  // e2.e
    public final void l() {
        this.n(new d(this));
    }

    @Override  // g1.d, d1.a$f
    public final int o() {
        return 12451000;
    }

    @Override  // g1.d
    protected final IInterface r(IBinder iBinder0) {
        if(iBinder0 == null) {
            return null;
        }
        IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return iInterface0 instanceof g ? ((g)iInterface0) : new g(iBinder0);
    }

    @Override  // g1.d
    protected final Bundle z() {
        if(!"com.playstack.balatro.android".equals(this.J.g())) {
            this.K.putString("com.google.android.gms.signin.internal.realClientPackageName", this.J.g());
        }
        return this.K;
    }
}

