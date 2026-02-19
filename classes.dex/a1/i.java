package a1;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Scope;
import d1.f.a;
import d1.f.b;
import g1.e;
import g1.h;

public final class i extends h {
    private final GoogleSignInOptions I;

    public i(Context context0, Looper looper0, e e0, GoogleSignInOptions googleSignInOptions0, a f$a0, b f$b0) {
        super(context0, looper0, 91, e0, f$a0, f$b0);
        com.google.android.gms.auth.api.signin.GoogleSignInOptions.a googleSignInOptions$a0 = googleSignInOptions0 == null ? new com.google.android.gms.auth.api.signin.GoogleSignInOptions.a() : new com.google.android.gms.auth.api.signin.GoogleSignInOptions.a(googleSignInOptions0);
        googleSignInOptions$a0.e("yNHyFInUaJ-gK53wdzJb9g");
        if(!e0.d().isEmpty()) {
            for(Object object0: e0.d()) {
                googleSignInOptions$a0.d(((Scope)object0), new Scope[0]);
            }
        }
        this.I = googleSignInOptions$a0.a();
    }

    @Override  // g1.d
    protected final String D() {
        return "com.google.android.gms.auth.api.signin.internal.ISignInService";
    }

    @Override  // g1.d
    protected final String E() {
        return "com.google.android.gms.auth.api.signin.service.START";
    }

    public final GoogleSignInOptions k0() {
        return this.I;
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
        IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
        return iInterface0 instanceof u ? ((u)iInterface0) : new u(iBinder0);
    }
}

