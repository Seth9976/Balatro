package androidx.loader.app;

import android.os.Bundle;
import androidx.lifecycle.d0;
import androidx.lifecycle.l;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import y.b;

public abstract class a {
    public interface androidx.loader.app.a.a {
        void a(b arg1);

        b b(int arg1, Bundle arg2);

        void c(b arg1, Object arg2);
    }

    public abstract void a(String arg1, FileDescriptor arg2, PrintWriter arg3, String[] arg4);

    public static a b(l l0) {
        return new androidx.loader.app.b(l0, ((d0)l0).l());
    }

    public abstract b c(int arg1, Bundle arg2, androidx.loader.app.a.a arg3);

    public abstract void d();
}

