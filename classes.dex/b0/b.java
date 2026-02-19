package b0;

import android.os.Trace;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class b {
    private static long a;
    private static Method b;

    public static void a(String s) {
        c.a(s);
    }

    public static void b() {
        c.b();
    }

    private static void c(String s, Exception exception0) {
        if(exception0 instanceof InvocationTargetException) {
            Throwable throwable0 = exception0.getCause();
            throw throwable0 instanceof RuntimeException ? ((RuntimeException)throwable0) : new RuntimeException(throwable0);
        }
        Log.v("Trace", "Unable to call " + s + " via reflection", exception0);
    }

    public static boolean d() {
        if(b.b == null) {
            try {
                return Trace.isEnabled();
            }
            catch(NoSuchMethodError | NoClassDefFoundError unused_ex) {
            }
        }
        return b.e();
    }

    private static boolean e() {
        try {
            Class class0 = Trace.class;
            if(b.b == null) {
                b.a = class0.getField("TRACE_TAG_APP").getLong(null);
                b.b = class0.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean)b.b.invoke(null, b.a)).booleanValue();
        }
        catch(Exception exception0) {
            b.c("isTagEnabled", exception0);
            return false;
        }
    }
}

