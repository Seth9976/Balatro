package androidx.appcompat.widget;

import android.os.Build.VERSION;
import android.view.View;

public abstract class p0 {
    static abstract class a {
        static void a(View view0, CharSequence charSequence0) {
            view0.setTooltipText(charSequence0);
        }
    }

    public static void a(View view0, CharSequence charSequence0) {
        if(Build.VERSION.SDK_INT >= 26) {
            a.a(view0, charSequence0);
            return;
        }
        s0.h(view0, charSequence0);
    }
}

