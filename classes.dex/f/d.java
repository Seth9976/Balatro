package f;

import android.content.res.Resources.Theme;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;

public abstract class d extends b {
    static abstract class a extends f.b.d {
        int[][] J;

        a(a d$a0, d d0, Resources resources0) {
            super(d$a0, d0, resources0);
            if(d$a0 != null) {
                this.J = d$a0.J;
                return;
            }
            this.J = new int[this.f()][];
        }

        int A(int[] arr_v) {
            int[][] arr2_v = this.J;
            int v = this.h();
            for(int v1 = 0; v1 < v; ++v1) {
                if(StateSet.stateSetMatches(arr2_v[v1], arr_v)) {
                    return v1;
                }
            }
            return -1;
        }

        @Override  // f.b$d
        public void o(int v, int v1) {
            super.o(v, v1);
            int[][] arr2_v = new int[v1][];
            System.arraycopy(this.J, 0, arr2_v, 0, v);
            this.J = arr2_v;
        }

        @Override  // f.b$d
        abstract void r();

        int z(int[] arr_v, Drawable drawable0) {
            int v = this.a(drawable0);
            this.J[v] = arr_v;
            return v;
        }
    }

    private a m;
    private boolean n;

    d(a d$a0) {
        if(d$a0 != null) {
            this.h(d$a0);
        }
    }

    @Override  // f.b
    public void applyTheme(Resources.Theme resources$Theme0) {
        super.applyTheme(resources$Theme0);
        this.onStateChange(this.getState());
    }

    @Override  // f.b
    void h(f.b.d b$d0) {
        super.h(b$d0);
        if(b$d0 instanceof a) {
            this.m = (a)b$d0;
        }
    }

    int[] j(AttributeSet attributeSet0) {
        int v = attributeSet0.getAttributeCount();
        int[] arr_v = new int[v];
        int v2 = 0;
        for(int v1 = 0; v1 < v; ++v1) {
            int v3 = attributeSet0.getAttributeNameResource(v1);
            if(v3 != 0 && v3 != 0x10100D0 && v3 != 0x1010199) {
                if(!attributeSet0.getAttributeBooleanValue(v1, false)) {
                    v3 = -v3;
                }
                arr_v[v2] = v3;
                ++v2;
            }
        }
        return StateSet.trimStateSet(arr_v, v2);
    }

    @Override  // f.b
    public Drawable mutate() {
        if(!this.n && super.mutate() == this) {
            this.m.r();
            this.n = true;
        }
        return this;
    }

    @Override  // android.graphics.drawable.Drawable
    protected abstract boolean onStateChange(int[] arg1);
}

