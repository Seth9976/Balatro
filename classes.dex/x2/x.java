package x2;

import android.content.Context;

public abstract class x {
    static abstract class a {
        public abstract void a(int arg1, String arg2, String arg3);
    }

    private static final k0 a;

    static {
        x.a = k0.f("x");
    }

    public static void a(Context context0, a x$a0) {
        try {
            new y(context0, x$a0).b();
        }
        catch(Throwable throwable0) {
            x.a.d("Error occurred while trying to run license check", throwable0);
        }
    }
}

