package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;

public class l extends ImageView {
    private final e a;
    private final k b;
    private boolean c;

    public l(Context context0) {
        this(context0, null);
    }

    public l(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0);
    }

    public l(Context context0, AttributeSet attributeSet0, int v) {
        super(i0.b(context0), attributeSet0, v);
        this.c = false;
        h0.a(this, this.getContext());
        e e0 = new e(this);
        this.a = e0;
        e0.e(attributeSet0, v);
        k k0 = new k(this);
        this.b = k0;
        k0.g(attributeSet0, v);
    }

    @Override  // android.widget.ImageView
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        e e0 = this.a;
        if(e0 != null) {
            e0.b();
        }
        k k0 = this.b;
        if(k0 != null) {
            k0.c();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.a == null ? null : this.a.c();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return this.a == null ? null : this.a.d();
    }

    public ColorStateList getSupportImageTintList() {
        return this.b == null ? null : this.b.d();
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        return this.b == null ? null : this.b.e();
    }

    // 去混淆评级： 低(20)
    @Override  // android.widget.ImageView
    public boolean hasOverlappingRendering() {
        return this.b.f() && super.hasOverlappingRendering();
    }

    @Override  // android.view.View
    public void setBackgroundDrawable(Drawable drawable0) {
        super.setBackgroundDrawable(drawable0);
        e e0 = this.a;
        if(e0 != null) {
            e0.f(drawable0);
        }
    }

    @Override  // android.view.View
    public void setBackgroundResource(int v) {
        super.setBackgroundResource(v);
        e e0 = this.a;
        if(e0 != null) {
            e0.g(v);
        }
    }

    @Override  // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap0) {
        super.setImageBitmap(bitmap0);
        k k0 = this.b;
        if(k0 != null) {
            k0.c();
        }
    }

    @Override  // android.widget.ImageView
    public void setImageDrawable(Drawable drawable0) {
        k k0 = this.b;
        if(k0 != null && drawable0 != null && !this.c) {
            k0.h(drawable0);
        }
        super.setImageDrawable(drawable0);
        k k1 = this.b;
        if(k1 != null) {
            k1.c();
            if(!this.c) {
                this.b.b();
            }
        }
    }

    @Override  // android.widget.ImageView
    public void setImageLevel(int v) {
        super.setImageLevel(v);
        this.c = true;
    }

    @Override  // android.widget.ImageView
    public void setImageResource(int v) {
        k k0 = this.b;
        if(k0 != null) {
            k0.i(v);
        }
    }

    @Override  // android.widget.ImageView
    public void setImageURI(Uri uri0) {
        super.setImageURI(uri0);
        k k0 = this.b;
        if(k0 != null) {
            k0.c();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList0) {
        e e0 = this.a;
        if(e0 != null) {
            e0.i(colorStateList0);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode porterDuff$Mode0) {
        e e0 = this.a;
        if(e0 != null) {
            e0.j(porterDuff$Mode0);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList0) {
        k k0 = this.b;
        if(k0 != null) {
            k0.j(colorStateList0);
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode porterDuff$Mode0) {
        k k0 = this.b;
        if(k0 != null) {
            k0.k(porterDuff$Mode0);
        }
    }
}

