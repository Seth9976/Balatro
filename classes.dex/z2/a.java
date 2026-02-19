package z2;

import android.net.Uri;

public abstract class a {
    // 去混淆评级： 低(20)
    public static boolean a(Uri uri0) {
        return uri0 != null && uri0.isHierarchical() && uri0.isAbsolute();
    }
}

