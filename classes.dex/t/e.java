package t;

import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;

final class e implements KeyListener {
    public static class a {
        public boolean a(Editable editable0, int v, KeyEvent keyEvent0) {
            return androidx.emoji2.text.e.f(editable0, v, keyEvent0);
        }
    }

    private final KeyListener a;
    private final a b;

    e(KeyListener keyListener0) {
        this(keyListener0, new a());
    }

    e(KeyListener keyListener0, a e$a0) {
        this.a = keyListener0;
        this.b = e$a0;
    }

    @Override  // android.text.method.KeyListener
    public void clearMetaKeyState(View view0, Editable editable0, int v) {
        this.a.clearMetaKeyState(view0, editable0, v);
    }

    @Override  // android.text.method.KeyListener
    public int getInputType() {
        return this.a.getInputType();
    }

    // 去混淆评级： 低(20)
    @Override  // android.text.method.KeyListener
    public boolean onKeyDown(View view0, Editable editable0, int v, KeyEvent keyEvent0) {
        return this.b.a(editable0, v, keyEvent0) || this.a.onKeyDown(view0, editable0, v, keyEvent0);
    }

    @Override  // android.text.method.KeyListener
    public boolean onKeyOther(View view0, Editable editable0, KeyEvent keyEvent0) {
        return this.a.onKeyOther(view0, editable0, keyEvent0);
    }

    @Override  // android.text.method.KeyListener
    public boolean onKeyUp(View view0, Editable editable0, int v, KeyEvent keyEvent0) {
        return this.a.onKeyUp(view0, editable0, v, keyEvent0);
    }
}

