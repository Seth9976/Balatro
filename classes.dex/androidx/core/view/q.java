package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;

public class q {
    private int a;
    private int b;

    public q(ViewGroup viewGroup0) {
    }

    public int a() {
        return this.a | this.b;
    }

    public void b(View view0, View view1, int v) {
        this.c(view0, view1, v, 0);
    }

    public void c(View view0, View view1, int v, int v1) {
        if(v1 == 1) {
            this.b = v;
            return;
        }
        this.a = v;
    }

    public void d(View view0, int v) {
        if(v == 1) {
            this.b = 0;
            return;
        }
        this.a = 0;
    }
}

