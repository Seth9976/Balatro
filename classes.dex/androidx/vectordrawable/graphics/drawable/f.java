package androidx.vectordrawable.graphics.drawable;

import android.content.res.Resources.Theme;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.a;

abstract class f extends Drawable {
    Drawable a;

    @Override  // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme resources$Theme0) {
        Drawable drawable0 = this.a;
        if(drawable0 != null) {
            a.a(drawable0, resources$Theme0);
        }
    }

    @Override  // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        Drawable drawable0 = this.a;
        if(drawable0 != null) {
            drawable0.clearColorFilter();
            return;
        }
        super.clearColorFilter();
    }

    @Override  // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        Drawable drawable0 = this.a;
        return drawable0 == null ? super.getCurrent() : drawable0.getCurrent();
    }

    @Override  // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        Drawable drawable0 = this.a;
        return drawable0 == null ? super.getMinimumHeight() : drawable0.getMinimumHeight();
    }

    @Override  // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        Drawable drawable0 = this.a;
        return drawable0 == null ? super.getMinimumWidth() : drawable0.getMinimumWidth();
    }

    @Override  // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect0) {
        Drawable drawable0 = this.a;
        return drawable0 == null ? super.getPadding(rect0) : drawable0.getPadding(rect0);
    }

    @Override  // android.graphics.drawable.Drawable
    public int[] getState() {
        Drawable drawable0 = this.a;
        return drawable0 == null ? super.getState() : drawable0.getState();
    }

    @Override  // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        Drawable drawable0 = this.a;
        return drawable0 == null ? super.getTransparentRegion() : drawable0.getTransparentRegion();
    }

    @Override  // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        Drawable drawable0 = this.a;
        if(drawable0 != null) {
            a.h(drawable0);
        }
    }

    @Override  // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int v) {
        Drawable drawable0 = this.a;
        return drawable0 == null ? super.onLevelChange(v) : drawable0.setLevel(v);
    }

    @Override  // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int v) {
        Drawable drawable0 = this.a;
        if(drawable0 != null) {
            drawable0.setChangingConfigurations(v);
            return;
        }
        super.setChangingConfigurations(v);
    }

    @Override  // android.graphics.drawable.Drawable
    public void setColorFilter(int v, PorterDuff.Mode porterDuff$Mode0) {
        Drawable drawable0 = this.a;
        if(drawable0 != null) {
            drawable0.setColorFilter(v, porterDuff$Mode0);
            return;
        }
        super.setColorFilter(v, porterDuff$Mode0);
    }

    @Override  // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        Drawable drawable0 = this.a;
        if(drawable0 != null) {
            drawable0.setFilterBitmap(z);
        }
    }

    @Override  // android.graphics.drawable.Drawable
    public void setHotspot(float f, float f1) {
        Drawable drawable0 = this.a;
        if(drawable0 != null) {
            a.j(drawable0, f, f1);
        }
    }

    @Override  // android.graphics.drawable.Drawable
    public void setHotspotBounds(int v, int v1, int v2, int v3) {
        Drawable drawable0 = this.a;
        if(drawable0 != null) {
            a.k(drawable0, v, v1, v2, v3);
        }
    }

    @Override  // android.graphics.drawable.Drawable
    public boolean setState(int[] arr_v) {
        Drawable drawable0 = this.a;
        return drawable0 == null ? super.setState(arr_v) : drawable0.setState(arr_v);
    }
}

