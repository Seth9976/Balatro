package androidx.lifecycle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class c0 {
    private final HashMap a;

    public c0() {
        this.a = new HashMap();
    }

    public final void a() {
        for(Object object0: this.a.values()) {
            ((y)object0).a();
        }
        this.a.clear();
    }

    final y b(String s) {
        return (y)this.a.get(s);
    }

    Set c() {
        return new HashSet(this.a.keySet());
    }

    final void d(String s, y y0) {
        y y1 = (y)this.a.put(s, y0);
        if(y1 != null) {
            y1.d();
        }
    }
}

