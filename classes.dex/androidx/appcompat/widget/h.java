package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.TextView;
import c.i;
import t.f;

class h {
    private final TextView a;
    private final f b;

    h(TextView textView0) {
        this.a = textView0;
        this.b = new f(textView0, false);
    }

    InputFilter[] a(InputFilter[] arr_inputFilter) {
        return this.b.a(arr_inputFilter);
    }

    void b(AttributeSet attributeSet0, int v) {
        boolean z = true;
        TypedArray typedArray0 = this.a.getContext().obtainStyledAttributes(attributeSet0, i.S, v, 0);
        try {
            if(typedArray0.hasValue(i.g0)) {
                z = typedArray0.getBoolean(i.g0, true);
            }
        }
        finally {
            typedArray0.recycle();
        }
        this.d(z);
    }

    void c(boolean z) {
        this.b.b(z);
    }

    void d(boolean z) {
        this.b.c(z);
    }
}

