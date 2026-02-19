package a2;

import android.os.Build.VERSION;

public abstract class g {
    public static final int a;

    static {
        g.a = Build.VERSION.SDK_INT < 0x1F ? 0 : 0x2000000;
    }
}

