package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class ActivityChooserView.InnerLayout extends LinearLayout {
    private static final int[] a;

    static {
        ActivityChooserView.InnerLayout.a = new int[]{0x10100D4};
    }

    public ActivityChooserView.InnerLayout(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        l0 l00 = l0.r(context0, attributeSet0, ActivityChooserView.InnerLayout.a);
        this.setBackgroundDrawable(l00.f(0));
        l00.t();
    }
}

