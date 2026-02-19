package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.core.content.res.h.e;
import androidx.core.content.res.h;
import e.a;

public class l0 {
    private final Context a;
    private final TypedArray b;
    private TypedValue c;

    private l0(Context context0, TypedArray typedArray0) {
        this.a = context0;
        this.b = typedArray0;
    }

    public boolean a(int v, boolean z) {
        return this.b.getBoolean(v, z);
    }

    public int b(int v, int v1) {
        return this.b.getColor(v, v1);
    }

    public ColorStateList c(int v) {
        if(this.b.hasValue(v)) {
            int v1 = this.b.getResourceId(v, 0);
            if(v1 != 0) {
                ColorStateList colorStateList0 = a.a(this.a, v1);
                return colorStateList0 == null ? this.b.getColorStateList(v) : colorStateList0;
            }
        }
        return this.b.getColorStateList(v);
    }

    public int d(int v, int v1) {
        return this.b.getDimensionPixelOffset(v, v1);
    }

    public int e(int v, int v1) {
        return this.b.getDimensionPixelSize(v, v1);
    }

    public Drawable f(int v) {
        if(this.b.hasValue(v)) {
            int v1 = this.b.getResourceId(v, 0);
            return v1 == 0 ? this.b.getDrawable(v) : a.b(this.a, v1);
        }
        return this.b.getDrawable(v);
    }

    public float g(int v, float f) {
        return this.b.getFloat(v, f);
    }

    public Typeface h(int v, int v1, e h$e0) {
        int v2 = this.b.getResourceId(v, 0);
        if(v2 == 0) {
            return null;
        }
        if(this.c == null) {
            this.c = new TypedValue();
        }
        return h.f(this.a, v2, this.c, v1, h$e0);
    }

    public int i(int v, int v1) {
        return this.b.getInt(v, v1);
    }

    public int j(int v, int v1) {
        return this.b.getInteger(v, v1);
    }

    public int k(int v, int v1) {
        return this.b.getLayoutDimension(v, v1);
    }

    public int l(int v, int v1) {
        return this.b.getResourceId(v, v1);
    }

    public String m(int v) {
        return this.b.getString(v);
    }

    public CharSequence n(int v) {
        return this.b.getText(v);
    }

    public TypedArray o() {
        return this.b;
    }

    public boolean p(int v) {
        return this.b.hasValue(v);
    }

    public static l0 q(Context context0, int v, int[] arr_v) {
        return new l0(context0, context0.obtainStyledAttributes(v, arr_v));
    }

    public static l0 r(Context context0, AttributeSet attributeSet0, int[] arr_v) {
        return new l0(context0, context0.obtainStyledAttributes(attributeSet0, arr_v));
    }

    public static l0 s(Context context0, AttributeSet attributeSet0, int[] arr_v, int v, int v1) {
        return new l0(context0, context0.obtainStyledAttributes(attributeSet0, arr_v, v, v1));
    }

    public void t() {
        this.b.recycle();
    }
}

