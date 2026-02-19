package p1;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import g1.q;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import q1.v;

public final class b0 {
    int a;
    final ArrayList b;
    GoogleSignInAccount c;
    String d;
    v e;

    static {
        new AtomicInteger(0);
    }

    b0(a0 a00) {
        this.a = 0x1110;
        this.b = new ArrayList();
        this.c = null;
        this.d = null;
        this.e = v.d;
    }

    public final b0 a(String s) {
        this.d = s;
        return this;
    }

    public final b0 b(v v0) {
        this.e = (v)q.i(v0);
        return this;
    }

    public final b0 c(GoogleSignInAccount googleSignInAccount0) {
        this.c = googleSignInAccount0;
        return this;
    }

    public final b0 d(int v) {
        this.a = 0x201113;
        return this;
    }

    public final d0 e() {
        return new d0(false, true, 17, false, this.a, null, this.b, false, false, false, this.c, null, 0, 9, this.d, this.e, null);
    }
}

