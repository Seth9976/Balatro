package androidx.core.os;

import android.os.Build.VERSION;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.Method;

public abstract class m {
    static abstract class a {
        static void a(String s) {
            Trace.beginSection(s);
        }

        static void b() {
            Trace.endSection();
        }
    }

    private static long a;
    private static Method b;
    private static Method c;
    private static Method d;
    private static Method e;

    static {
        Class class0 = String.class;
        Class class1 = Trace.class;
        if(Build.VERSION.SDK_INT < 29) {
            try {
                m.a = class1.getField("TRACE_TAG_APP").getLong(null);
                Class[] arr_class = new Class[1];
                Class class2 = Long.TYPE;
                arr_class[0] = class2;
                m.b = class1.getMethod("isTagEnabled", arr_class);
                Class[] arr_class1 = new Class[3];
                arr_class1[0] = class2;
                arr_class1[1] = class0;
                Class class3 = Integer.TYPE;
                arr_class1[2] = class3;
                m.c = class1.getMethod("asyncTraceBegin", arr_class1);
                m.d = class1.getMethod("asyncTraceEnd", class2, class0, class3);
                m.e = class1.getMethod("traceCounter", class2, class0, class3);
            }
            catch(Exception exception0) {
                Log.i("TraceCompat", "Unable to initialize via reflection.", exception0);
            }
        }
    }

    public static void a(String s) {
        a.a(s);
    }

    public static void b() {
        a.b();
    }
}

