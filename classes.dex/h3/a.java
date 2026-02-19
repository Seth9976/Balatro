package h3;

import b3.b;
import java.io.Closeable;

public abstract class a {
    public static final void a(Closeable closeable0, Throwable throwable0) {
        if(closeable0 != null) {
            if(throwable0 == null) {
                closeable0.close();
                return;
            }
            try {
                closeable0.close();
            }
            catch(Throwable throwable1) {
                b.a(throwable0, throwable1);
            }
        }
    }
}

