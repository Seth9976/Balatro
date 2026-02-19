package g2;

import java.util.ArrayDeque;
import java.util.Queue;
import jeb.synthetic.FIN;

final class y {
    private final Object a;
    private Queue b;
    private boolean c;

    y() {
        this.a = new Object();
    }

    public final void a(x x0) {
        synchronized(this.a) {
            if(this.b == null) {
                this.b = new ArrayDeque();
            }
            this.b.add(x0);
        }
    }

    public final void b(h h0) {
        x x0;
        int v;
        synchronized(this.a) {
            if(this.b != null && !this.c) {
                this.c = true;
                while(true) {
                    Object object1 = this.a;
                    synchronized(object1) {
                        v = FIN.finallyOpen$NT();
                        x0 = (x)this.b.poll();
                        if(x0 == null) {
                            break;
                        }
                        FIN.finallyCodeBegin$NT(v);
                    }
                    FIN.finallyCodeEnd$NT(v);
                    x0.a(h0);
                }
                this.c = false;
                FIN.finallyExec$NT(v);
            }
        }
    }
}

