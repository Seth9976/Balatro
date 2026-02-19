package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import org.xmlpull.v1.XmlPullParser;

public abstract class k {
    public static boolean a(TypedArray typedArray0, XmlPullParser xmlPullParser0, String s, int v, boolean z) {
        return k.j(xmlPullParser0, s) ? typedArray0.getBoolean(v, z) : z;
    }

    public static int b(TypedArray typedArray0, XmlPullParser xmlPullParser0, String s, int v, int v1) {
        return k.j(xmlPullParser0, s) ? typedArray0.getColor(v, v1) : v1;
    }

    public static ColorStateList c(TypedArray typedArray0, XmlPullParser xmlPullParser0, Resources.Theme resources$Theme0, String s, int v) {
        if(k.j(xmlPullParser0, s)) {
            TypedValue typedValue0 = new TypedValue();
            typedArray0.getValue(v, typedValue0);
            int v1 = typedValue0.type;
            if(v1 == 2) {
                throw new UnsupportedOperationException("Failed to resolve attribute at index " + v + ": " + typedValue0);
            }
            return v1 < 28 || v1 > 0x1F ? c.d(typedArray0.getResources(), typedArray0.getResourceId(v, 0), resources$Theme0) : k.d(typedValue0);
        }
        return null;
    }

    private static ColorStateList d(TypedValue typedValue0) {
        return ColorStateList.valueOf(typedValue0.data);
    }

    public static d e(TypedArray typedArray0, XmlPullParser xmlPullParser0, Resources.Theme resources$Theme0, String s, int v, int v1) {
        if(k.j(xmlPullParser0, s)) {
            TypedValue typedValue0 = new TypedValue();
            typedArray0.getValue(v, typedValue0);
            if(typedValue0.type >= 28 && typedValue0.type <= 0x1F) {
                return d.b(typedValue0.data);
            }
            d d0 = d.g(typedArray0.getResources(), typedArray0.getResourceId(v, 0), resources$Theme0);
            return d0 == null ? d.b(v1) : d0;
        }
        return d.b(v1);
    }

    public static float f(TypedArray typedArray0, XmlPullParser xmlPullParser0, String s, int v, float f) {
        return k.j(xmlPullParser0, s) ? typedArray0.getFloat(v, f) : f;
    }

    public static int g(TypedArray typedArray0, XmlPullParser xmlPullParser0, String s, int v, int v1) {
        return k.j(xmlPullParser0, s) ? typedArray0.getInt(v, v1) : v1;
    }

    public static int h(TypedArray typedArray0, XmlPullParser xmlPullParser0, String s, int v, int v1) {
        return k.j(xmlPullParser0, s) ? typedArray0.getResourceId(v, v1) : v1;
    }

    public static String i(TypedArray typedArray0, XmlPullParser xmlPullParser0, String s, int v) {
        return k.j(xmlPullParser0, s) ? typedArray0.getString(v) : null;
    }

    public static boolean j(XmlPullParser xmlPullParser0, String s) {
        return xmlPullParser0.getAttributeValue("http://schemas.android.com/apk/res/android", s) != null;
    }

    public static TypedArray k(Resources resources0, Resources.Theme resources$Theme0, AttributeSet attributeSet0, int[] arr_v) {
        return resources$Theme0 == null ? resources0.obtainAttributes(attributeSet0, arr_v) : resources$Theme0.obtainStyledAttributes(attributeSet0, arr_v, 0, 0);
    }

    public static TypedValue l(TypedArray typedArray0, XmlPullParser xmlPullParser0, String s, int v) {
        return k.j(xmlPullParser0, s) ? typedArray0.peekValue(v) : null;
    }
}

