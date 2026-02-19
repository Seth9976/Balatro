package a1;

import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public final class p {
    final c a;
    GoogleSignInAccount b;
    GoogleSignInOptions c;
    private static p d;

    static {
    }

    private p(Context context0) {
        c c0 = c.b(context0);
        this.a = c0;
        this.b = c0.c();
        this.c = c0.d();
    }

    public final GoogleSignInAccount a() {
        synchronized(this) {
        }
        return this.b;
    }

    public static p b(Context context0) {
        synchronized(p.class) {
            return p.e(context0.getApplicationContext());
        }
    }

    public final void c() {
        synchronized(this) {
            this.a.a();
            this.b = null;
            this.c = null;
        }
    }

    public final void d(GoogleSignInOptions googleSignInOptions0, GoogleSignInAccount googleSignInAccount0) {
        synchronized(this) {
            this.a.f(googleSignInAccount0, googleSignInOptions0);
            this.b = googleSignInAccount0;
            this.c = googleSignInOptions0;
        }
    }

    private static p e(Context context0) {
        synchronized(p.class) {
            p p0 = p.d;
            if(p0 != null) {
                return p0;
            }
            p p1 = new p(context0);
            p.d = p1;
            return p1;
        }
    }
}

