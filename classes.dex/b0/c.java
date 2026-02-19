package b0;

import android.os.Trace;

abstract class c {
    public static void a(String s) {
        Trace.beginSection(s);
    }

    public static void b() {
        Trace.endSection();
    }
}

