package d;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import c.i;

public abstract class a extends ViewGroup.MarginLayoutParams {
    public int a;

    public a(int v, int v1) {
        super(v, v1);
        this.a = 0x800013;
    }

    public a(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.a = 0;
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, i.r);
        this.a = typedArray0.getInt(i.s, 0);
        typedArray0.recycle();
    }

    public a(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        super(viewGroup$LayoutParams0);
        this.a = 0;
    }

    public a(a a0) {
        super(a0);
        this.a = a0.a;
    }
}

