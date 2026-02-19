package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Layout;
import android.util.AttributeSet;
import c.i;

public class DialogTitle extends p {
    public DialogTitle(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
    }

    @Override  // androidx.appcompat.widget.p
    protected void onMeasure(int v, int v1) {
        super.onMeasure(v, v1);
        Layout layout0 = this.getLayout();
        if(layout0 != null) {
            int v2 = layout0.getLineCount();
            if(v2 > 0 && layout0.getEllipsisCount(v2 - 1) > 0) {
                this.setSingleLine(false);
                this.setMaxLines(2);
                TypedArray typedArray0 = this.getContext().obtainStyledAttributes(null, i.Q1, 0x1010041, 0x1030044);
                int v3 = typedArray0.getDimensionPixelSize(i.R1, 0);
                if(v3 != 0) {
                    this.setTextSize(0, ((float)v3));
                }
                typedArray0.recycle();
                super.onMeasure(v, v1);
            }
        }
    }
}

