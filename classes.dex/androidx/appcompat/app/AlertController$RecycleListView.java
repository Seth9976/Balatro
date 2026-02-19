package androidx.appcompat.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ListView;
import c.i;

public class AlertController.RecycleListView extends ListView {
    private final int a;
    private final int b;

    public AlertController.RecycleListView(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, i.t1);
        this.b = typedArray0.getDimensionPixelOffset(i.u1, -1);
        this.a = typedArray0.getDimensionPixelOffset(i.v1, -1);
    }
}

