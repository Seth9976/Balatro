package androidx.lifecycle;

import android.os.Bundle;
import b3.d;
import java.util.Iterator;
import java.util.Map.Entry;
import k3.f;
import k3.g;
import z.c.c;

public final class w implements c {
    private final z.c a;
    private boolean b;
    private Bundle c;
    private final d d;

    public w(z.c c0, d0 d00) {
        static final class a extends g implements j3.a {
            final d0 f;

            a(d0 d00) {
                this.f = d00;
                super(0);
            }

            @Override  // j3.a
            public Object a() {
                return this.d();
            }

            public final x d() {
                return v.b(this.f);
            }
        }

        f.e(c0, "savedStateRegistry");
        f.e(d00, "viewModelStoreOwner");
        super();
        this.a = c0;
        this.d = b3.f.a(new a(d00));
    }

    @Override  // z.c$c
    public Bundle a() {
        Bundle bundle0 = new Bundle();
        Bundle bundle1 = this.c;
        if(bundle1 != null) {
            bundle0.putAll(bundle1);
        }
        Iterator iterator0 = this.b().e().entrySet().iterator();
        if(!iterator0.hasNext()) {
            this.b = false;
            return bundle0;
        }
        Object object0 = iterator0.next();
        String s = (String)((Map.Entry)object0).getKey();
        h.d.a(((Map.Entry)object0).getValue());
        throw null;
    }

    private final x b() {
        return (x)this.d.getValue();
    }

    public final void c() {
        if(!this.b) {
            this.c = this.a.b("androidx.lifecycle.internal.SavedStateHandlesProvider");
            this.b = true;
            this.b();
        }
    }
}

