package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class b implements i {
    protected Context a;
    protected Context b;
    protected e c;
    protected LayoutInflater d;
    protected LayoutInflater e;
    private a f;
    private int g;
    private int h;
    protected j i;

    public b(Context context0, int v, int v1) {
        this.a = context0;
        this.d = LayoutInflater.from(context0);
        this.g = v;
        this.h = v1;
    }

    @Override  // androidx.appcompat.view.menu.i
    public void a(e e0, boolean z) {
        a i$a0 = this.f;
        if(i$a0 != null) {
            i$a0.a(e0, z);
        }
    }

    protected void b(View view0, int v) {
        ViewGroup viewGroup0 = (ViewGroup)view0.getParent();
        if(viewGroup0 != null) {
            viewGroup0.removeView(view0);
        }
        ((ViewGroup)this.i).addView(view0, v);
    }

    @Override  // androidx.appcompat.view.menu.i
    public void d(Context context0, e e0) {
        this.b = context0;
        this.e = LayoutInflater.from(context0);
        this.c = e0;
    }

    @Override  // androidx.appcompat.view.menu.i
    public boolean e(e e0, f f0) {
        return false;
    }

    public abstract void f(f arg1, androidx.appcompat.view.menu.j.a arg2);

    public androidx.appcompat.view.menu.j.a g(ViewGroup viewGroup0) {
        return (androidx.appcompat.view.menu.j.a)this.d.inflate(this.h, viewGroup0, false);
    }

    @Override  // androidx.appcompat.view.menu.i
    public boolean h(e e0, f f0) {
        return false;
    }

    @Override  // androidx.appcompat.view.menu.i
    public void i(a i$a0) {
        this.f = i$a0;
    }

    @Override  // androidx.appcompat.view.menu.i
    public boolean j(m m0) {
        a i$a0 = this.f;
        if(i$a0 != null) {
            if(m0 == null) {
                m0 = this.c;
            }
            return i$a0.b(m0);
        }
        return false;
    }

    @Override  // androidx.appcompat.view.menu.i
    public void k(boolean z) {
        ViewGroup viewGroup0 = (ViewGroup)this.i;
        if(viewGroup0 == null) {
            return;
        }
        e e0 = this.c;
        int v = 0;
        if(e0 != null) {
            e0.q();
            ArrayList arrayList0 = this.c.A();
            int v1 = arrayList0.size();
            int v3 = 0;
            for(int v2 = 0; v2 < v1; ++v2) {
                f f0 = (f)arrayList0.get(v2);
                if(this.o(v3, f0)) {
                    View view0 = viewGroup0.getChildAt(v3);
                    f f1 = view0 instanceof androidx.appcompat.view.menu.j.a ? ((androidx.appcompat.view.menu.j.a)view0).getItemData() : null;
                    View view1 = this.n(f0, view0, viewGroup0);
                    if(f0 != f1) {
                        view1.setPressed(false);
                        view1.jumpDrawablesToCurrentState();
                    }
                    if(view1 != view0) {
                        this.b(view1, v3);
                    }
                    ++v3;
                }
            }
            v = v3;
        }
        while(v < viewGroup0.getChildCount()) {
            if(!this.l(viewGroup0, v)) {
                ++v;
            }
        }
    }

    protected boolean l(ViewGroup viewGroup0, int v) {
        viewGroup0.removeViewAt(v);
        return true;
    }

    public a m() {
        return this.f;
    }

    public View n(f f0, View view0, ViewGroup viewGroup0) {
        androidx.appcompat.view.menu.j.a j$a0 = view0 instanceof androidx.appcompat.view.menu.j.a ? ((androidx.appcompat.view.menu.j.a)view0) : this.g(viewGroup0);
        this.f(f0, j$a0);
        return (View)j$a0;
    }

    public abstract boolean o(int arg1, f arg2);
}

