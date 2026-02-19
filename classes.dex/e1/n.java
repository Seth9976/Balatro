package e1;

import com.google.android.gms.common.api.Status;
import g1.b;
import g2.i;

public abstract class n {
    public static void a(Status status0, Object object0, i i0) {
        if(status0.o0()) {
            i0.c(object0);
            return;
        }
        i0.b(b.a(status0));
    }
}

