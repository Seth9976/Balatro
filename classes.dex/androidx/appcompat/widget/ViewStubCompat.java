package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.view.ViewParent;
import c.i;
import java.lang.ref.WeakReference;

public final class ViewStubCompat extends View {
    public interface a {
    }

    private int a;
    private int b;
    private WeakReference c;
    private LayoutInflater d;

    public ViewStubCompat(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0);
    }

    public ViewStubCompat(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.a = 0;
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, i.J2, v, 0);
        this.b = typedArray0.getResourceId(i.M2, -1);
        this.a = typedArray0.getResourceId(i.L2, 0);
        this.setId(typedArray0.getResourceId(i.K2, -1));
        typedArray0.recycle();
        this.setVisibility(8);
        this.setWillNotDraw(true);
    }

    public View a() {
        ViewParent viewParent0 = this.getParent();
        if(!(viewParent0 instanceof ViewGroup)) {
            throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        }
        if(this.a == 0) {
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
        View view0 = (this.d == null ? LayoutInflater.from(this.getContext()) : this.d).inflate(this.a, ((ViewGroup)viewParent0), false);
        int v = this.b;
        if(v != -1) {
            view0.setId(v);
        }
        int v1 = ((ViewGroup)viewParent0).indexOfChild(this);
        ((ViewGroup)viewParent0).removeViewInLayout(this);
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = this.getLayoutParams();
        if(viewGroup$LayoutParams0 == null) {
            ((ViewGroup)viewParent0).addView(view0, v1);
        }
        else {
            ((ViewGroup)viewParent0).addView(view0, v1, viewGroup$LayoutParams0);
        }
        this.c = new WeakReference(view0);
        return view0;
    }

    @Override  // android.view.View
    protected void dispatchDraw(Canvas canvas0) {
    }

    @Override  // android.view.View
    public void draw(Canvas canvas0) {
    }

    public int getInflatedId() {
        return this.b;
    }

    public LayoutInflater getLayoutInflater() {
        return this.d;
    }

    public int getLayoutResource() {
        return this.a;
    }

    @Override  // android.view.View
    protected void onMeasure(int v, int v1) {
        this.setMeasuredDimension(0, 0);
    }

    public void setInflatedId(int v) {
        this.b = v;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater0) {
        this.d = layoutInflater0;
    }

    public void setLayoutResource(int v) {
        this.a = v;
    }

    public void setOnInflateListener(a viewStubCompat$a0) {
    }

    @Override  // android.view.View
    public void setVisibility(int v) {
        WeakReference weakReference0 = this.c;
        if(weakReference0 != null) {
            View view0 = (View)weakReference0.get();
            if(view0 == null) {
                throw new IllegalStateException("setVisibility called on un-referenced view");
            }
            view0.setVisibility(v);
            return;
        }
        super.setVisibility(v);
        if(v == 0 || v == 4) {
            this.a();
        }
    }
}

