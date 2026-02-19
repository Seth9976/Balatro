package a1;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.a;
import com.google.android.gms.auth.api.signin.b;
import l1.i;

public final class v extends q {
    private final Context a;

    public v(Context context0) {
        this.a = context0;
    }

    @Override  // a1.r
    public final void L() {
        this.d();
        c c0 = c.b(this.a);
        GoogleSignInAccount googleSignInAccount0 = c0.c();
        GoogleSignInOptions googleSignInOptions0 = googleSignInAccount0 == null ? GoogleSignInOptions.p : c0.d();
        b b0 = a.a(this.a, googleSignInOptions0);
        if(googleSignInAccount0 != null) {
            b0.u();
            return;
        }
        b0.v();
    }

    private final void d() {
        int v = Binder.getCallingUid();
        if(!i.a(this.a, v)) {
            throw new SecurityException("Calling UID " + Binder.getCallingUid() + " is not Google Play services.");
        }
    }

    @Override  // a1.r
    public final void r() {
        this.d();
        p.b(this.a).c();
    }
}

