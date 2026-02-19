package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator.AnimatorListener;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import androidx.core.content.res.k;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

public class b extends f implements Animatable {
    class a implements Drawable.Callback {
        final b a;

        @Override  // android.graphics.drawable.Drawable$Callback
        public void invalidateDrawable(Drawable drawable0) {
            b.this.invalidateSelf();
        }

        @Override  // android.graphics.drawable.Drawable$Callback
        public void scheduleDrawable(Drawable drawable0, Runnable runnable0, long v) {
            b.this.scheduleSelf(runnable0, v);
        }

        @Override  // android.graphics.drawable.Drawable$Callback
        public void unscheduleDrawable(Drawable drawable0, Runnable runnable0) {
            b.this.unscheduleSelf(runnable0);
        }
    }

    static class androidx.vectordrawable.graphics.drawable.b.b extends Drawable.ConstantState {
        int a;
        g b;
        AnimatorSet c;
        ArrayList d;
        k.a e;

        public androidx.vectordrawable.graphics.drawable.b.b(Context context0, androidx.vectordrawable.graphics.drawable.b.b b$b0, Drawable.Callback drawable$Callback0, Resources resources0) {
            if(b$b0 != null) {
                this.a = b$b0.a;
                g g0 = b$b0.b;
                if(g0 != null) {
                    Drawable.ConstantState drawable$ConstantState0 = g0.getConstantState();
                    this.b = (g)(resources0 == null ? drawable$ConstantState0.newDrawable() : drawable$ConstantState0.newDrawable(resources0));
                    g g1 = (g)this.b.mutate();
                    this.b = g1;
                    g1.setCallback(drawable$Callback0);
                    this.b.setBounds(b$b0.b.getBounds());
                    this.b.h(false);
                }
                ArrayList arrayList0 = b$b0.d;
                if(arrayList0 != null) {
                    int v1 = arrayList0.size();
                    this.d = new ArrayList(v1);
                    this.e = new k.a(v1);
                    for(int v = 0; v < v1; ++v) {
                        Animator animator0 = (Animator)b$b0.d.get(v);
                        Animator animator1 = animator0.clone();
                        String s = (String)b$b0.e.get(animator0);
                        animator1.setTarget(this.b.d(s));
                        this.d.add(animator1);
                        this.e.put(animator1, s);
                    }
                    this.a();
                }
            }
        }

        public void a() {
            if(this.c == null) {
                this.c = new AnimatorSet();
            }
            this.c.playTogether(this.d);
        }

        @Override  // android.graphics.drawable.Drawable$ConstantState
        public int getChangingConfigurations() {
            return this.a;
        }

        @Override  // android.graphics.drawable.Drawable$ConstantState
        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override  // android.graphics.drawable.Drawable$ConstantState
        public Drawable newDrawable(Resources resources0) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    static class c extends Drawable.ConstantState {
        private final Drawable.ConstantState a;

        public c(Drawable.ConstantState drawable$ConstantState0) {
            this.a = drawable$ConstantState0;
        }

        @Override  // android.graphics.drawable.Drawable$ConstantState
        public boolean canApplyTheme() {
            return this.a.canApplyTheme();
        }

        @Override  // android.graphics.drawable.Drawable$ConstantState
        public int getChangingConfigurations() {
            return this.a.getChangingConfigurations();
        }

        @Override  // android.graphics.drawable.Drawable$ConstantState
        public Drawable newDrawable() {
            Drawable drawable0 = new b();
            Drawable drawable1 = this.a.newDrawable();
            drawable0.a = drawable1;
            drawable1.setCallback(drawable0.g);
            return drawable0;
        }

        @Override  // android.graphics.drawable.Drawable$ConstantState
        public Drawable newDrawable(Resources resources0) {
            Drawable drawable0 = new b();
            Drawable drawable1 = this.a.newDrawable(resources0);
            drawable0.a = drawable1;
            drawable1.setCallback(drawable0.g);
            return drawable0;
        }

        @Override  // android.graphics.drawable.Drawable$ConstantState
        public Drawable newDrawable(Resources resources0, Resources.Theme resources$Theme0) {
            Drawable drawable0 = new b();
            Drawable drawable1 = this.a.newDrawable(resources0, resources$Theme0);
            drawable0.a = drawable1;
            drawable1.setCallback(drawable0.g);
            return drawable0;
        }
    }

    private androidx.vectordrawable.graphics.drawable.b.b b;
    private Context c;
    private ArgbEvaluator d;
    private Animator.AnimatorListener e;
    ArrayList f;
    final Drawable.Callback g;

    b() {
        this(null, null, null);
    }

    private b(Context context0) {
        this(context0, null, null);
    }

    private b(Context context0, androidx.vectordrawable.graphics.drawable.b.b b$b0, Resources resources0) {
        this.d = null;
        this.e = null;
        this.f = null;
        a b$a0 = new a(this);
        this.g = b$a0;
        this.c = context0;
        if(b$b0 != null) {
            this.b = b$b0;
            return;
        }
        this.b = new androidx.vectordrawable.graphics.drawable.b.b(context0, null, b$a0, resources0);
    }

    public static b a(Context context0, Resources resources0, XmlPullParser xmlPullParser0, AttributeSet attributeSet0, Resources.Theme resources$Theme0) {
        b b0 = new b(context0);
        b0.inflate(resources0, xmlPullParser0, attributeSet0, resources$Theme0);
        return b0;
    }

    @Override  // androidx.vectordrawable.graphics.drawable.f
    public void applyTheme(Resources.Theme resources$Theme0) {
        Drawable drawable0 = this.a;
        if(drawable0 != null) {
            androidx.core.graphics.drawable.a.a(drawable0, resources$Theme0);
        }
    }

    private void b(String s, Animator animator0) {
        animator0.setTarget(this.b.b.d(s));
        androidx.vectordrawable.graphics.drawable.b.b b$b0 = this.b;
        if(b$b0.d == null) {
            b$b0.d = new ArrayList();
            androidx.vectordrawable.graphics.drawable.b.b b$b1 = this.b;
            b$b1.e = new k.a();
        }
        this.b.d.add(animator0);
        this.b.e.put(animator0, s);
    }

    @Override  // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        return this.a == null ? false : androidx.core.graphics.drawable.a.b(this.a);
    }

    @Override  // androidx.vectordrawable.graphics.drawable.f
    public void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override  // android.graphics.drawable.Drawable
    public void draw(Canvas canvas0) {
        Drawable drawable0 = this.a;
        if(drawable0 != null) {
            drawable0.draw(canvas0);
            return;
        }
        this.b.b.draw(canvas0);
        if(this.b.c.isStarted()) {
            this.invalidateSelf();
        }
    }

    @Override  // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable0 = this.a;
        return drawable0 == null ? this.b.b.getAlpha() : androidx.core.graphics.drawable.a.c(drawable0);
    }

    @Override  // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable0 = this.a;
        return drawable0 == null ? super.getChangingConfigurations() | this.b.a : drawable0.getChangingConfigurations();
    }

    @Override  // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable0 = this.a;
        return drawable0 == null ? this.b.b.getColorFilter() : androidx.core.graphics.drawable.a.d(drawable0);
    }

    @Override  // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.a != null && Build.VERSION.SDK_INT >= 24 ? new c(this.a.getConstantState()) : null;
    }

    @Override  // androidx.vectordrawable.graphics.drawable.f
    public Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override  // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable0 = this.a;
        return drawable0 == null ? this.b.b.getIntrinsicHeight() : drawable0.getIntrinsicHeight();
    }

    @Override  // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable0 = this.a;
        return drawable0 == null ? this.b.b.getIntrinsicWidth() : drawable0.getIntrinsicWidth();
    }

    @Override  // androidx.vectordrawable.graphics.drawable.f
    public int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override  // androidx.vectordrawable.graphics.drawable.f
    public int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override  // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable0 = this.a;
        return drawable0 == null ? this.b.b.getOpacity() : drawable0.getOpacity();
    }

    @Override  // androidx.vectordrawable.graphics.drawable.f
    public boolean getPadding(Rect rect0) {
        return super.getPadding(rect0);
    }

    @Override  // androidx.vectordrawable.graphics.drawable.f
    public int[] getState() {
        return super.getState();
    }

    @Override  // androidx.vectordrawable.graphics.drawable.f
    public Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    @Override  // android.graphics.drawable.Drawable
    public void inflate(Resources resources0, XmlPullParser xmlPullParser0, AttributeSet attributeSet0) {
        this.inflate(resources0, xmlPullParser0, attributeSet0, null);
    }

    @Override  // android.graphics.drawable.Drawable
    public void inflate(Resources resources0, XmlPullParser xmlPullParser0, AttributeSet attributeSet0, Resources.Theme resources$Theme0) {
        TypedArray typedArray0;
        Drawable drawable0 = this.a;
        if(drawable0 != null) {
            androidx.core.graphics.drawable.a.f(drawable0, resources0, xmlPullParser0, attributeSet0, resources$Theme0);
            return;
        }
        int v = xmlPullParser0.getEventType();
        int v1 = xmlPullParser0.getDepth();
        while(v != 1 && (xmlPullParser0.getDepth() >= v1 + 1 || v != 3)) {
            if(v == 2) {
                String s = xmlPullParser0.getName();
                if("animated-vector".equals(s)) {
                    typedArray0 = k.k(resources0, resources$Theme0, attributeSet0, androidx.vectordrawable.graphics.drawable.a.e);
                    int v2 = typedArray0.getResourceId(0, 0);
                    if(v2 != 0) {
                        g g0 = g.b(resources0, v2, resources$Theme0);
                        g0.h(false);
                        g0.setCallback(this.g);
                        g g1 = this.b.b;
                        if(g1 != null) {
                            g1.setCallback(null);
                        }
                        this.b.b = g0;
                    }
                    typedArray0.recycle();
                }
                else if("target".equals(s)) {
                    typedArray0 = resources0.obtainAttributes(attributeSet0, androidx.vectordrawable.graphics.drawable.a.f);
                    String s1 = typedArray0.getString(0);
                    int v3 = typedArray0.getResourceId(1, 0);
                    if(v3 != 0) {
                        Context context0 = this.c;
                        if(context0 != null) {
                            this.b(s1, d.i(context0, v3));
                            goto label_33;
                        }
                        typedArray0.recycle();
                        throw new IllegalStateException("Context can\'t be null when inflating animators");
                    }
                label_33:
                    typedArray0.recycle();
                }
            }
            v = xmlPullParser0.next();
        }
        this.b.a();
    }

    @Override  // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable0 = this.a;
        return drawable0 == null ? this.b.b.isAutoMirrored() : androidx.core.graphics.drawable.a.g(drawable0);
    }

    @Override  // android.graphics.drawable.Animatable
    public boolean isRunning() {
        Drawable drawable0 = this.a;
        return drawable0 == null ? this.b.c.isRunning() : ((AnimatedVectorDrawable)drawable0).isRunning();
    }

    @Override  // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable drawable0 = this.a;
        return drawable0 == null ? this.b.b.isStateful() : drawable0.isStateful();
    }

    @Override  // androidx.vectordrawable.graphics.drawable.f
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override  // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable0 = this.a;
        if(drawable0 != null) {
            drawable0.mutate();
        }
        return this;
    }

    @Override  // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect0) {
        Drawable drawable0 = this.a;
        if(drawable0 != null) {
            drawable0.setBounds(rect0);
            return;
        }
        this.b.b.setBounds(rect0);
    }

    @Override  // androidx.vectordrawable.graphics.drawable.f
    protected boolean onLevelChange(int v) {
        Drawable drawable0 = this.a;
        return drawable0 == null ? this.b.b.setLevel(v) : drawable0.setLevel(v);
    }

    @Override  // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] arr_v) {
        Drawable drawable0 = this.a;
        return drawable0 == null ? this.b.b.setState(arr_v) : drawable0.setState(arr_v);
    }

    @Override  // android.graphics.drawable.Drawable
    public void setAlpha(int v) {
        Drawable drawable0 = this.a;
        if(drawable0 != null) {
            drawable0.setAlpha(v);
            return;
        }
        this.b.b.setAlpha(v);
    }

    @Override  // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        Drawable drawable0 = this.a;
        if(drawable0 != null) {
            androidx.core.graphics.drawable.a.i(drawable0, z);
            return;
        }
        this.b.b.setAutoMirrored(z);
    }

    @Override  // androidx.vectordrawable.graphics.drawable.f
    public void setChangingConfigurations(int v) {
        super.setChangingConfigurations(v);
    }

    @Override  // androidx.vectordrawable.graphics.drawable.f
    public void setColorFilter(int v, PorterDuff.Mode porterDuff$Mode0) {
        super.setColorFilter(v, porterDuff$Mode0);
    }

    @Override  // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter0) {
        Drawable drawable0 = this.a;
        if(drawable0 != null) {
            drawable0.setColorFilter(colorFilter0);
            return;
        }
        this.b.b.setColorFilter(colorFilter0);
    }

    @Override  // androidx.vectordrawable.graphics.drawable.f
    public void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    @Override  // androidx.vectordrawable.graphics.drawable.f
    public void setHotspot(float f, float f1) {
        super.setHotspot(f, f1);
    }

    @Override  // androidx.vectordrawable.graphics.drawable.f
    public void setHotspotBounds(int v, int v1, int v2, int v3) {
        super.setHotspotBounds(v, v1, v2, v3);
    }

    @Override  // androidx.vectordrawable.graphics.drawable.f
    public boolean setState(int[] arr_v) {
        return super.setState(arr_v);
    }

    @Override  // android.graphics.drawable.Drawable
    public void setTint(int v) {
        Drawable drawable0 = this.a;
        if(drawable0 != null) {
            androidx.core.graphics.drawable.a.m(drawable0, v);
            return;
        }
        this.b.b.setTint(v);
    }

    @Override  // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList0) {
        Drawable drawable0 = this.a;
        if(drawable0 != null) {
            androidx.core.graphics.drawable.a.n(drawable0, colorStateList0);
            return;
        }
        this.b.b.setTintList(colorStateList0);
    }

    @Override  // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode porterDuff$Mode0) {
        Drawable drawable0 = this.a;
        if(drawable0 != null) {
            androidx.core.graphics.drawable.a.o(drawable0, porterDuff$Mode0);
            return;
        }
        this.b.b.setTintMode(porterDuff$Mode0);
    }

    @Override  // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z1) {
        Drawable drawable0 = this.a;
        if(drawable0 != null) {
            return drawable0.setVisible(z, z1);
        }
        this.b.b.setVisible(z, z1);
        return super.setVisible(z, z1);
    }

    @Override  // android.graphics.drawable.Animatable
    public void start() {
        Drawable drawable0 = this.a;
        if(drawable0 != null) {
            ((AnimatedVectorDrawable)drawable0).start();
            return;
        }
        if(this.b.c.isStarted()) {
            return;
        }
        this.b.c.start();
        this.invalidateSelf();
    }

    @Override  // android.graphics.drawable.Animatable
    public void stop() {
        Drawable drawable0 = this.a;
        if(drawable0 != null) {
            ((AnimatedVectorDrawable)drawable0).stop();
            return;
        }
        this.b.c.end();
    }
}

