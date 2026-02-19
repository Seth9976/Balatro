package androidx.core.app;

import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;

abstract class a0 {
    private static final Object a;
    private static final Object b;

    static {
        a0.a = new Object();
        a0.b = new Object();
    }

    static Bundle a(a f$a0) {
        Bundle bundle0 = new Bundle();
        IconCompat iconCompat0 = f$a0.d();
        bundle0.putInt("icon", (iconCompat0 == null ? 0 : iconCompat0.c()));
        bundle0.putCharSequence("title", f$a0.h());
        bundle0.putParcelable("actionIntent", f$a0.a());
        Bundle bundle1 = f$a0.c() == null ? new Bundle() : new Bundle(f$a0.c());
        bundle1.putBoolean("android.support.allowGeneratedReplies", f$a0.b());
        bundle0.putBundle("extras", bundle1);
        bundle0.putParcelableArray("remoteInputs", a0.c(f$a0.e()));
        bundle0.putBoolean("showsUserInterface", f$a0.g());
        bundle0.putInt("semanticAction", f$a0.f());
        return bundle0;
    }

    private static Bundle b(g0 g00) {
        new Bundle();
        throw null;
    }

    private static Bundle[] c(g0[] arr_g0) {
        if(arr_g0 == null) {
            return null;
        }
        Bundle[] arr_bundle = new Bundle[arr_g0.length];
        for(int v = 0; v < arr_g0.length; ++v) {
            g0 g00 = arr_g0[v];
            arr_bundle[v] = a0.b(null);
        }
        return arr_bundle;
    }
}

