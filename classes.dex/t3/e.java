package t3;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import r3.n;

public class e {
    private volatile Object _cur;
    private static final AtomicReferenceFieldUpdater a;

    static {
        e.a = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "_cur");
    }

    public e(boolean z) {
        this._cur = new f(8, z);
    }

    public final boolean a(Object object0) {
        while(true) {
            f f0 = (f)this._cur;
            int v = f0.a(object0);
            switch(v) {
                case 0: {
                    return true;
                label_5:
                    if(v != 2) {
                        break;
                    }
                    return false;
                }
                case 1: {
                    f f1 = f0.i();
                    n.a(e.a, this, f0, f1);
                    break;
                }
                default: {
                    goto label_5;
                }
            }
        }
    }

    public final void b() {
        while(true) {
            f f0 = (f)this._cur;
            if(f0.d()) {
                break;
            }
            f f1 = f0.i();
            n.a(e.a, this, f0, f1);
        }
    }

    public final int c() {
        return ((f)this._cur).f();
    }

    public final Object d() {
        Object object0;
        while(true) {
            f f0 = (f)this._cur;
            object0 = f0.j();
            if(object0 != f.h) {
                break;
            }
            f f1 = f0.i();
            n.a(e.a, this, f0, f1);
        }
        return object0;
    }
}

