package x1;

import android.content.Context;
import c1.j;
import g2.h;
import g2.k;
import w0.b;

public final class r implements b {
    private final b a;
    private final b b;

    public r(Context context0) {
        this.a = new p(context0, j.e());
        this.b = l.d(context0);
    }

    // 检测为 Lambda 实现
    public static h a(r r0, h h0) [...]

    @Override  // w0.b
    public final h b() {
        return this.a.b().k((h h0) -> {
            if(!h0.q() && !h0.o()) {
                Exception exception0 = h0.m();
                if(exception0 instanceof d1.b) {
                    switch(((d1.b)exception0).b()) {
                        case 15: {
                            return k.a(new Exception("The operation to get app set ID timed out. Please try again later."));
                        }
                        case 43000: {
                            return k.a(new Exception("Failed to get app set ID due to an internal error. Please try again later."));
                        }
                        case 17: 
                        case 43001: 
                        case 43002: 
                        case 43003: {
                            return this.b.b();
                        }
                        default: {
                            return h0;
                        }
                    }
                }
            }
            return h0;
        });
    }
}

