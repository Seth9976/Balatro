package g1;

import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Scope;
import d1.a.f;
import d1.f.a;
import d1.f.b;
import e1.i;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

public abstract class h extends d implements f {
    private final e F;
    private final Set G;
    private final Account H;

    protected h(Context context0, Looper looper0, int v, e e0, a f$a0, b f$b0) {
        this(context0, looper0, v, e0, f$a0, f$b0);
    }

    protected h(Context context0, Looper looper0, int v, e e0, e1.d d0, i i0) {
        this(context0, looper0, g1.i.a(context0), c1.i.l(), v, e0, ((e1.d)q.i(d0)), ((i)q.i(i0)));
    }

    protected h(Context context0, Looper looper0, g1.i i0, c1.i i1, int v, e e0, e1.d d0, i i2) {
        super(context0, looper0, i0, i1, v, (d0 == null ? null : new e0(d0)), (i2 == null ? null : new f0(i2)), e0.l());
        this.F = e0;
        this.H = e0.a();
        this.G = this.j0(e0.d());
    }

    @Override  // g1.d
    protected final Set B() {
        return this.G;
    }

    // 去混淆评级： 低(20)
    @Override  // d1.a$f
    public Set g() {
        return this.k() ? this.G : Collections.emptySet();
    }

    protected final e h0() {
        return this.F;
    }

    protected Set i0(Set set0) [...] // Inlined contents

    private final Set j0(Set set0) {
        for(Object object0: set0) {
            if(!set0.contains(((Scope)object0))) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
            if(false) {
                break;
            }
        }
        return set0;
    }

    @Override  // g1.d
    public final Account t() {
        return this.H;
    }

    @Override  // g1.d
    protected Executor v() {
        return null;
    }
}

