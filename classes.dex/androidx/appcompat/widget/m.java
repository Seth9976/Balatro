package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.core.widget.f;
import c.i;

class m extends PopupWindow {
    private boolean a;
    private static final boolean b;

    static {
        m.b = false;
    }

    public m(Context context0, AttributeSet attributeSet0, int v, int v1) {
        super(context0, attributeSet0, v, v1);
        this.a(context0, attributeSet0, v, v1);
    }

    private void a(Context context0, AttributeSet attributeSet0, int v, int v1) {
        l0 l00 = l0.s(context0, attributeSet0, i.p1, v, v1);
        if(l00.p(i.r1)) {
            this.b(l00.a(i.r1, false));
        }
        this.setBackgroundDrawable(l00.f(i.q1));
        l00.t();
    }

    private void b(boolean z) {
        if(m.b) {
            this.a = z;
            return;
        }
        f.a(this, z);
    }

    @Override  // android.widget.PopupWindow
    public void showAsDropDown(View view0, int v, int v1) {
        if(m.b && this.a) {
            v1 -= view0.getHeight();
        }
        super.showAsDropDown(view0, v, v1);
    }

    @Override  // android.widget.PopupWindow
    public void showAsDropDown(View view0, int v, int v1, int v2) {
        if(m.b && this.a) {
            v1 -= view0.getHeight();
        }
        super.showAsDropDown(view0, v, v1, v2);
    }

    @Override  // android.widget.PopupWindow
    public void update(View view0, int v, int v1, int v2, int v3) {
        if(m.b && this.a) {
            v1 -= view0.getHeight();
        }
        super.update(view0, v, v1, v2, v3);
    }
}

