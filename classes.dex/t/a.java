package t;

import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;

public final class a {
    static class t.a.a extends b {
        private final EditText a;
        private final g b;

        t.a.a(EditText editText0, boolean z) {
            this.a = editText0;
            g g0 = new g(editText0, z);
            this.b = g0;
            editText0.addTextChangedListener(g0);
            editText0.setEditableFactory(t.b.getInstance());
        }

        @Override  // t.a$b
        KeyListener a(KeyListener keyListener0) {
            if(keyListener0 instanceof e) {
                return keyListener0;
            }
            if(keyListener0 == null) {
                return null;
            }
            return keyListener0 instanceof NumberKeyListener ? keyListener0 : new e(keyListener0);
        }

        @Override  // t.a$b
        InputConnection b(InputConnection inputConnection0, EditorInfo editorInfo0) {
            return inputConnection0 instanceof c ? inputConnection0 : new c(this.a, inputConnection0, editorInfo0);
        }

        @Override  // t.a$b
        void c(boolean z) {
            this.b.c(z);
        }
    }

    static abstract class b {
        abstract KeyListener a(KeyListener arg1);

        abstract InputConnection b(InputConnection arg1, EditorInfo arg2);

        abstract void c(boolean arg1);
    }

    private final b a;
    private int b;
    private int c;

    public a(EditText editText0, boolean z) {
        this.b = 0x7FFFFFFF;
        this.c = 0;
        androidx.core.util.c.e(editText0, "editText cannot be null");
        this.a = new t.a.a(editText0, z);
    }

    public KeyListener a(KeyListener keyListener0) {
        return this.a.a(keyListener0);
    }

    public InputConnection b(InputConnection inputConnection0, EditorInfo editorInfo0) {
        return inputConnection0 == null ? null : this.a.b(inputConnection0, editorInfo0);
    }

    public void c(boolean z) {
        this.a.c(z);
    }
}

