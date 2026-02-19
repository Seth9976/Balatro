package androidx.core.app;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.core.view.f.a;
import androidx.core.view.f;
import androidx.lifecycle.l;
import androidx.lifecycle.m;
import androidx.lifecycle.u;
import k.g;

public abstract class c extends Activity implements a, l {
    private g a;
    private m b;

    public c() {
        this.a = new g();
        this.b = new m(this);
    }

    @Override  // android.app.Activity
    public boolean dispatchKeyEvent(KeyEvent keyEvent0) {
        View view0 = this.getWindow().getDecorView();
        return view0 == null || !f.d(view0, keyEvent0) ? f.e(this, view0, this, keyEvent0) : true;
    }

    @Override  // android.app.Activity
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent0) {
        View view0 = this.getWindow().getDecorView();
        return view0 == null || !f.d(view0, keyEvent0) ? super.dispatchKeyShortcutEvent(keyEvent0) : true;
    }

    @Override  // androidx.core.view.f$a
    public boolean i(KeyEvent keyEvent0) {
        return super.dispatchKeyEvent(keyEvent0);
    }

    @Override  // android.app.Activity
    protected void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        u.g(this);
    }

    @Override  // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle0) {
        this.b.j(androidx.lifecycle.h.c.g);
        super.onSaveInstanceState(bundle0);
    }

    protected final boolean s(String[] arr_s) {
        return !c.t(arr_s);
    }

    private static boolean t(String[] arr_s) {
        if(arr_s != null && arr_s.length > 0) {
            String s = arr_s[0];
            s.hashCode();
            switch(s) {
                case "--autofill": {
                    return Build.VERSION.SDK_INT >= 26;
                }
                case "--contentcapture": {
                    return Build.VERSION.SDK_INT >= 29;
                }
                case "--dump-dumpable": {
                    return true;
                }
                case "--list-dumpables": {
                    return true;
                }
                case "--translation": {
                    return Build.VERSION.SDK_INT >= 0x1F;
                }
                default: {
                    return false;
                }
            }
        }
        return false;
    }
}

