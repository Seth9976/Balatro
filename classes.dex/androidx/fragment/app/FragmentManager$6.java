package androidx.fragment.app;

import android.os.Bundle;
import androidx.lifecycle.h.b;
import androidx.lifecycle.h;
import androidx.lifecycle.j;
import androidx.lifecycle.l;

class FragmentManager.6 implements j {
    final String a;
    final h b;
    final x c;

    @Override  // androidx.lifecycle.j
    public void d(l l0, b h$b0) {
        if(h$b0 == b.ON_START && ((Bundle)this.c.k.get(this.a)) != null) {
            throw null;
        }
        if(h$b0 == b.ON_DESTROY) {
            this.b.c(this);
            this.c.l.remove(this.a);
        }
    }
}

