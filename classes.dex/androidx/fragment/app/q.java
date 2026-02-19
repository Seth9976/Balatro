package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater.Factory2;
import android.view.View.OnAttachStateChangeListener;
import android.view.View;
import android.view.ViewGroup;
import u.c;

class q implements LayoutInflater.Factory2 {
    final x a;

    q(x x0) {
        this.a = x0;
    }

    @Override  // android.view.LayoutInflater$Factory2
    public View onCreateView(View view0, String s, Context context0, AttributeSet attributeSet0) {
        class a implements View.OnAttachStateChangeListener {
            final d0 a;
            final q b;

            a(d0 d00) {
                this.a = d00;
                super();
            }

            @Override  // android.view.View$OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view0) {
                this.a.m();
                l0.n(((ViewGroup)this.a.k().I.getParent()), q.this.a).j();
            }

            @Override  // android.view.View$OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view0) {
            }
        }

        String s3;
        StringBuilder stringBuilder0;
        d0 d00;
        Fragment fragment0 = null;
        if("androidx.fragment.app.m".equals(s)) {
            return new m(context0, attributeSet0, this.a);
        }
        if(!"fragment".equals(s)) {
            return null;
        }
        String s1 = attributeSet0.getAttributeValue(null, "class");
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, c.a);
        if(s1 == null) {
            s1 = typedArray0.getString(c.b);
        }
        int v = typedArray0.getResourceId(c.c, -1);
        String s2 = typedArray0.getString(c.d);
        typedArray0.recycle();
        if(s1 != null && o.b(context0.getClassLoader(), s1)) {
            int v1 = view0 == null ? 0 : view0.getId();
            if(v1 == -1 && v == -1 && s2 == null) {
                throw new IllegalArgumentException(attributeSet0.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + s1);
            }
            if(v != -1) {
                fragment0 = this.a.g0(v);
            }
            if(fragment0 == null && s2 != null) {
                fragment0 = this.a.h0(s2);
            }
            if(fragment0 == null && v1 != -1) {
                fragment0 = this.a.g0(v1);
            }
            if(fragment0 == null) {
                fragment0 = this.a.r0().a(context0.getClassLoader(), s1);
                fragment0.o = true;
                fragment0.x = v == 0 ? v1 : v;
                fragment0.y = v1;
                fragment0.z = s2;
                fragment0.p = true;
                fragment0.t = this.a;
                fragment0.u = this.a.t0();
                fragment0.y0(this.a.t0().u(), attributeSet0, fragment0.b);
                d00 = this.a.j(fragment0);
                if(!x.G0(2)) {
                    goto label_53;
                }
                stringBuilder0 = new StringBuilder();
                stringBuilder0.append("Fragment ");
                stringBuilder0.append(fragment0);
                s3 = " has been inflated via the <fragment> tag: id=0x";
                goto label_50;
            }
            if(fragment0.p) {
                throw new IllegalArgumentException(attributeSet0.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(v) + ", tag " + s2 + ", or parent id 0x" + Integer.toHexString(v1) + " with another fragment for " + s1);
            }
            fragment0.p = true;
            fragment0.t = this.a;
            fragment0.u = this.a.t0();
            fragment0.y0(this.a.t0().u(), attributeSet0, fragment0.b);
            d00 = this.a.v(fragment0);
            if(x.G0(2)) {
                stringBuilder0 = new StringBuilder();
                stringBuilder0.append("Retained Fragment ");
                stringBuilder0.append(fragment0);
                s3 = " has been re-attached via the <fragment> tag: id=0x";
            label_50:
                stringBuilder0.append(s3);
                stringBuilder0.append(Integer.toHexString(v));
                Log.v("FragmentManager", stringBuilder0.toString());
            }
        label_53:
            v.c.g(fragment0, ((ViewGroup)view0));
            fragment0.H = (ViewGroup)view0;
            d00.m();
            d00.j();
            View view1 = fragment0.I;
            if(view1 == null) {
                throw new IllegalStateException("Fragment " + s1 + " did not create a view.");
            }
            if(v != 0) {
                view1.setId(v);
            }
            if(fragment0.I.getTag() == null) {
                fragment0.I.setTag(s2);
            }
            fragment0.I.addOnAttachStateChangeListener(new a(this, d00));
            return fragment0.I;
        }
        return null;
    }

    @Override  // android.view.LayoutInflater$Factory
    public View onCreateView(String s, Context context0, AttributeSet attributeSet0) {
        return this.onCreateView(null, s, context0, attributeSet0);
    }
}

