package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import c.i;
import t.a;

class g {
    private final EditText a;
    private final a b;

    g(EditText editText0) {
        this.a = editText0;
        this.b = new a(editText0, false);
    }

    // 去混淆评级： 低(20)
    KeyListener a(KeyListener keyListener0) {
        return this.b(keyListener0) ? this.b.a(keyListener0) : keyListener0;
    }

    boolean b(KeyListener keyListener0) {
        return !(keyListener0 instanceof NumberKeyListener);
    }

    void c(AttributeSet attributeSet0, int v) {
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
        this.e(z);
    }

    InputConnection d(InputConnection inputConnection0, EditorInfo editorInfo0) {
        return this.b.b(inputConnection0, editorInfo0);
    }

    void e(boolean z) {
        this.b.c(z);
    }
}

