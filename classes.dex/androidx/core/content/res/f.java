package androidx.core.content.res;

import android.content.res.Resources.Theme;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader.TileMode;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.List;
import l.c;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

abstract class f {
    static final class a {
        final int[] a;
        final float[] b;

        a(int v, int v1) {
            this.a = new int[]{v, v1};
            this.b = new float[]{0.0f, 1.0f};
        }

        a(int v, int v1, int v2) {
            this.a = new int[]{v, v1, v2};
            this.b = new float[]{0.0f, 0.5f, 1.0f};
        }

        a(List list0, List list1) {
            int v = list0.size();
            this.a = new int[v];
            this.b = new float[v];
            for(int v1 = 0; v1 < v; ++v1) {
                this.a[v1] = (int)(((Integer)list0.get(v1)));
                this.b[v1] = (float)(((Float)list1.get(v1)));
            }
        }
    }

    private static a a(a f$a0, int v, int v1, boolean z, int v2) {
        if(f$a0 != null) {
            return f$a0;
        }
        return z ? new a(v, v2, v1) : new a(v, v1);
    }

    static Shader b(Resources resources0, XmlPullParser xmlPullParser0, AttributeSet attributeSet0, Resources.Theme resources$Theme0) {
        String s = xmlPullParser0.getName();
        if(s.equals("gradient")) {
            TypedArray typedArray0 = k.k(resources0, resources$Theme0, attributeSet0, c.A);
            float f = k.f(typedArray0, xmlPullParser0, "startX", c.J, 0.0f);
            float f1 = k.f(typedArray0, xmlPullParser0, "startY", c.K, 0.0f);
            float f2 = k.f(typedArray0, xmlPullParser0, "endX", c.L, 0.0f);
            float f3 = k.f(typedArray0, xmlPullParser0, "endY", c.M, 0.0f);
            float f4 = k.f(typedArray0, xmlPullParser0, "centerX", c.E, 0.0f);
            float f5 = k.f(typedArray0, xmlPullParser0, "centerY", c.F, 0.0f);
            int v = k.g(typedArray0, xmlPullParser0, "type", c.D, 0);
            int v1 = k.b(typedArray0, xmlPullParser0, "startColor", c.B, 0);
            boolean z = k.j(xmlPullParser0, "centerColor");
            int v2 = k.b(typedArray0, xmlPullParser0, "centerColor", c.I, 0);
            int v3 = k.b(typedArray0, xmlPullParser0, "endColor", c.C, 0);
            int v4 = k.g(typedArray0, xmlPullParser0, "tileMode", c.H, 0);
            float f6 = k.f(typedArray0, xmlPullParser0, "gradientRadius", c.G, 0.0f);
            typedArray0.recycle();
            a f$a0 = f.a(f.c(resources0, xmlPullParser0, attributeSet0, resources$Theme0), v1, v3, z, v2);
            switch(v) {
                case 1: {
                    if(f6 <= 0.0f) {
                        throw new XmlPullParserException("<gradient> tag requires \'gradientRadius\' attribute with radial type");
                    }
                    Shader.TileMode shader$TileMode1 = f.d(v4);
                    return new RadialGradient(f4, f5, f6, f$a0.a, f$a0.b, shader$TileMode1);
                }
                case 2: {
                    return new SweepGradient(f4, f5, f$a0.a, f$a0.b);
                }
                default: {
                    Shader.TileMode shader$TileMode0 = f.d(v4);
                    return new LinearGradient(f, f1, f2, f3, f$a0.a, f$a0.b, shader$TileMode0);
                }
            }
        }
        throw new XmlPullParserException(xmlPullParser0.getPositionDescription() + ": invalid gradient color tag " + s);
    }

    private static a c(Resources resources0, XmlPullParser xmlPullParser0, AttributeSet attributeSet0, Resources.Theme resources$Theme0) {
        int v = xmlPullParser0.getDepth();
        ArrayList arrayList0 = new ArrayList(20);
        ArrayList arrayList1 = new ArrayList(20);
        int v1;
        while((v1 = xmlPullParser0.next()) != 1) {
            int v2 = xmlPullParser0.getDepth();
            if(v2 < v + 1 && v1 == 3) {
                break;
            }
            if(v1 == 2 && v2 <= v + 1 && xmlPullParser0.getName().equals("item")) {
                TypedArray typedArray0 = k.k(resources0, resources$Theme0, attributeSet0, c.N);
                if(!typedArray0.hasValue(c.O) || !typedArray0.hasValue(c.P)) {
                    throw new XmlPullParserException(xmlPullParser0.getPositionDescription() + ": <item> tag requires a \'color\' attribute and a \'offset\' attribute!");
                }
                int v3 = typedArray0.getColor(c.O, 0);
                float f = typedArray0.getFloat(c.P, 0.0f);
                typedArray0.recycle();
                arrayList1.add(v3);
                arrayList0.add(f);
            }
        }
        return arrayList1.size() <= 0 ? null : new a(arrayList1, arrayList0);
    }

    private static Shader.TileMode d(int v) {
        switch(v) {
            case 1: {
                return Shader.TileMode.REPEAT;
            }
            case 2: {
                return Shader.TileMode.MIRROR;
            }
            default: {
                return Shader.TileMode.CLAMP;
            }
        }
    }
}

