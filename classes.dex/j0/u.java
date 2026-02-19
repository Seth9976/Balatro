package j0;

import android.content.Context;
import java.io.Closeable;
import r0.d;

abstract class u implements Closeable {
    interface a {
        u a();

        a b(Context arg1);
    }

    abstract d a();

    abstract t b();

    @Override
    public void close() {
        this.a().close();
    }
}

