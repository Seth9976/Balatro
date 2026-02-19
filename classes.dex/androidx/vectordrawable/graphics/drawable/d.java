package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import androidx.core.content.res.k;
import androidx.core.graphics.h.b;
import androidx.core.graphics.h;
import java.io.IOException;
import java.util.ArrayList;
import jeb.synthetic.TWR;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public abstract class d {
    static class a implements TypeEvaluator {
        private b[] a;

        public b[] a(float f, b[] arr_h$b, b[] arr_h$b1) {
            if(!h.b(arr_h$b, arr_h$b1)) {
                throw new IllegalArgumentException("Can\'t interpolate between two incompatible pathData");
            }
            if(!h.b(this.a, arr_h$b)) {
                this.a = h.f(arr_h$b);
            }
            for(int v = 0; v < arr_h$b.length; ++v) {
                this.a[v].d(arr_h$b[v], arr_h$b1[v], f);
            }
            return this.a;
        }

        @Override  // android.animation.TypeEvaluator
        public Object evaluate(float f, Object object0, Object object1) {
            return this.a(f, ((b[])object0), ((b[])object1));
        }
    }

    private static Animator a(Context context0, Resources resources0, Resources.Theme resources$Theme0, XmlPullParser xmlPullParser0, float f) {
        return d.b(context0, resources0, resources$Theme0, xmlPullParser0, Xml.asAttributeSet(xmlPullParser0), null, 0, f);
    }

    private static Animator b(Context context0, Resources resources0, Resources.Theme resources$Theme0, XmlPullParser xmlPullParser0, AttributeSet attributeSet0, AnimatorSet animatorSet0, int v, float f) {
        int v3;
        int v1 = xmlPullParser0.getDepth();
        Animator animator0 = null;
        ArrayList arrayList0 = null;
        while(true) {
            int v2 = xmlPullParser0.next();
            v3 = 0;
            if(v2 == 3 && xmlPullParser0.getDepth() <= v1 || v2 == 1) {
                break;
            }
            if(v2 == 2) {
                String s = xmlPullParser0.getName();
                if(s.equals("objectAnimator")) {
                    animator0 = d.n(context0, resources0, resources$Theme0, attributeSet0, f, xmlPullParser0);
                }
                else if(s.equals("animator")) {
                    animator0 = d.l(context0, resources0, resources$Theme0, attributeSet0, null, f, xmlPullParser0);
                }
                else if(s.equals("set")) {
                    AnimatorSet animatorSet1 = new AnimatorSet();
                    TypedArray typedArray0 = k.k(resources0, resources$Theme0, attributeSet0, androidx.vectordrawable.graphics.drawable.a.h);
                    d.b(context0, resources0, resources$Theme0, xmlPullParser0, attributeSet0, animatorSet1, k.g(typedArray0, xmlPullParser0, "ordering", 0, 0), f);
                    typedArray0.recycle();
                    animator0 = animatorSet1;
                }
                else {
                    if(!s.equals("propertyValuesHolder")) {
                        throw new RuntimeException("Unknown animator name: " + xmlPullParser0.getName());
                    }
                    PropertyValuesHolder[] arr_propertyValuesHolder = d.p(context0, resources0, resources$Theme0, xmlPullParser0, Xml.asAttributeSet(xmlPullParser0));
                    if(arr_propertyValuesHolder != null && animator0 instanceof ValueAnimator) {
                        ((ValueAnimator)animator0).setValues(arr_propertyValuesHolder);
                    }
                    v3 = 1;
                }
                if(animatorSet0 != null && v3 == 0) {
                    if(arrayList0 == null) {
                        arrayList0 = new ArrayList();
                    }
                    arrayList0.add(animator0);
                }
            }
        }
        if(animatorSet0 != null && arrayList0 != null) {
            Animator[] arr_animator = new Animator[arrayList0.size()];
            for(Object object0: arrayList0) {
                arr_animator[v3] = (Animator)object0;
                ++v3;
            }
            if(v == 0) {
                animatorSet0.playTogether(arr_animator);
                return animator0;
            }
            animatorSet0.playSequentially(arr_animator);
        }
        return animator0;
    }

    private static Keyframe c(Keyframe keyframe0, float f) {
        if(keyframe0.getType() == Float.TYPE) {
            return Keyframe.ofFloat(f);
        }
        return keyframe0.getType() == Integer.TYPE ? Keyframe.ofInt(f) : Keyframe.ofObject(f);
    }

    private static void d(Keyframe[] arr_keyframe, float f, int v, int v1) {
        float f1 = f / ((float)(v1 - v + 2));
        while(v <= v1) {
            arr_keyframe[v].setFraction(arr_keyframe[v - 1].getFraction() + f1);
            ++v;
        }
    }

    private static PropertyValuesHolder e(TypedArray typedArray0, int v, int v1, int v2, String s) {
        int v7;
        int v6;
        int v5;
        PropertyValuesHolder propertyValuesHolder1;
        TypedValue typedValue0 = typedArray0.peekValue(v1);
        int v3 = typedValue0 == null ? typedValue0.type : 0;
        TypedValue typedValue1 = typedArray0.peekValue(v2);
        int v4 = typedValue1 == null ? typedValue1.type : 0;
        if(v == 4) {
            v = (typedValue0 == null || !d.h(v3)) && (typedValue1 == null || !d.h(v4)) ? 0 : 3;
        }
        PropertyValuesHolder propertyValuesHolder0 = null;
        if(v == 2) {
            String s1 = typedArray0.getString(v1);
            String s2 = typedArray0.getString(v2);
            b[] arr_h$b = h.d(s1);
            b[] arr_h$b1 = h.d(s2);
            if(arr_h$b != null || arr_h$b1 != null) {
                if(arr_h$b != null) {
                    a d$a0 = new a();
                    if(arr_h$b1 != null) {
                        if(!h.b(arr_h$b, arr_h$b1)) {
                            throw new InflateException(" Can\'t morph from " + s1 + " to " + s2);
                        }
                        return PropertyValuesHolder.ofObject(s, d$a0, new Object[]{arr_h$b, arr_h$b1});
                    }
                    return PropertyValuesHolder.ofObject(s, d$a0, new Object[]{arr_h$b});
                }
                return arr_h$b1 == null ? null : PropertyValuesHolder.ofObject(s, new a(), new Object[]{arr_h$b1});
            }
        }
        else {
            e e0 = v == 3 ? e.a() : null;
            if(v == 0) {
                if(typedValue0 == null) {
                    propertyValuesHolder1 = PropertyValuesHolder.ofFloat(s, new float[]{(v4 == 5 ? typedArray0.getDimension(v2, 0.0f) : typedArray0.getFloat(v2, 0.0f))});
                }
                else {
                    float f = v3 == 5 ? typedArray0.getDimension(v1, 0.0f) : typedArray0.getFloat(v1, 0.0f);
                    propertyValuesHolder1 = typedValue1 == null ? PropertyValuesHolder.ofFloat(s, new float[]{f}) : PropertyValuesHolder.ofFloat(s, new float[]{f, (v4 == 5 ? typedArray0.getDimension(v2, 0.0f) : typedArray0.getFloat(v2, 0.0f))});
                }
                propertyValuesHolder0 = propertyValuesHolder1;
            }
            else if(typedValue0 != null) {
                if(v3 == 5) {
                    v5 = (int)typedArray0.getDimension(v1, 0.0f);
                }
                else {
                    v5 = d.h(v3) ? typedArray0.getColor(v1, 0) : typedArray0.getInt(v1, 0);
                }
                if(typedValue1 == null) {
                    propertyValuesHolder0 = PropertyValuesHolder.ofInt(s, new int[]{v5});
                }
                else {
                    if(v4 == 5) {
                        v6 = (int)typedArray0.getDimension(v2, 0.0f);
                    }
                    else {
                        v6 = d.h(v4) ? typedArray0.getColor(v2, 0) : typedArray0.getInt(v2, 0);
                    }
                    propertyValuesHolder0 = PropertyValuesHolder.ofInt(s, new int[]{v5, v6});
                }
            }
            else if(typedValue1 != null) {
                if(v4 == 5) {
                    v7 = (int)typedArray0.getDimension(v2, 0.0f);
                }
                else {
                    v7 = d.h(v4) ? typedArray0.getColor(v2, 0) : typedArray0.getInt(v2, 0);
                }
                propertyValuesHolder0 = PropertyValuesHolder.ofInt(s, new int[]{v7});
            }
            if(propertyValuesHolder0 != null && e0 != null) {
                propertyValuesHolder0.setEvaluator(e0);
            }
        }
        return propertyValuesHolder0;
    }

    private static int f(TypedArray typedArray0, int v, int v1) {
        TypedValue typedValue0 = typedArray0.peekValue(v);
        int v2 = typedValue0 == null ? typedValue0.type : 0;
        TypedValue typedValue1 = typedArray0.peekValue(v1);
        if(typedValue1 == null) {
            return typedValue0 != null && d.h(v2) ? 3 : 0;
        }
        return (typedValue0 == null || !d.h(v2)) && !d.h(typedValue1.type) ? 0 : 3;
    }

    private static int g(Resources resources0, Resources.Theme resources$Theme0, AttributeSet attributeSet0, XmlPullParser xmlPullParser0) {
        TypedArray typedArray0 = k.k(resources0, resources$Theme0, attributeSet0, androidx.vectordrawable.graphics.drawable.a.j);
        int v = 0;
        TypedValue typedValue0 = k.l(typedArray0, xmlPullParser0, "value", 0);
        if(typedValue0 != null && d.h(typedValue0.type)) {
            v = 3;
        }
        typedArray0.recycle();
        return v;
    }

    private static boolean h(int v) {
        return v >= 28 && v <= 0x1F;
    }

    public static Animator i(Context context0, int v) {
        return Build.VERSION.SDK_INT < 24 ? d.j(context0, context0.getResources(), context0.getTheme(), v) : AnimatorInflater.loadAnimator(context0, v);
    }

    public static Animator j(Context context0, Resources resources0, Resources.Theme resources$Theme0, int v) {
        return d.k(context0, resources0, resources$Theme0, v, 1.0f);
    }

    public static Animator k(Context context0, Resources resources0, Resources.Theme resources$Theme0, int v, float f) {
        Animator animator0;
        XmlResourceParser xmlResourceParser0;
        try {
            try {
                xmlResourceParser0 = null;
                xmlResourceParser0 = resources0.getAnimation(v);
                animator0 = d.a(context0, resources0, resources$Theme0, xmlResourceParser0, f);
            }
            catch(XmlPullParserException xmlPullParserException0) {
                Resources.NotFoundException resources$NotFoundException0 = new Resources.NotFoundException("Can\'t load animation resource ID #0x" + Integer.toHexString(v));
                resources$NotFoundException0.initCause(xmlPullParserException0);
                throw resources$NotFoundException0;
            }
            catch(IOException iOException0) {
                Resources.NotFoundException resources$NotFoundException1 = new Resources.NotFoundException("Can\'t load animation resource ID #0x" + Integer.toHexString(v));
                resources$NotFoundException1.initCause(iOException0);
                throw resources$NotFoundException1;
            }
        }
        catch(Throwable throwable0) {
            TWR.safeClose$NT(xmlResourceParser0, throwable0);
            throw throwable0;
        }
        if(xmlResourceParser0 != null) {
            xmlResourceParser0.close();
        }
        return animator0;
    }

    private static ValueAnimator l(Context context0, Resources resources0, Resources.Theme resources$Theme0, AttributeSet attributeSet0, ValueAnimator valueAnimator0, float f, XmlPullParser xmlPullParser0) {
        TypedArray typedArray0 = k.k(resources0, resources$Theme0, attributeSet0, androidx.vectordrawable.graphics.drawable.a.g);
        TypedArray typedArray1 = k.k(resources0, resources$Theme0, attributeSet0, androidx.vectordrawable.graphics.drawable.a.k);
        if(valueAnimator0 == null) {
            valueAnimator0 = new ValueAnimator();
        }
        d.q(valueAnimator0, typedArray0, typedArray1, f, xmlPullParser0);
        int v = k.h(typedArray0, xmlPullParser0, "interpolator", 0, 0);
        if(v > 0) {
            valueAnimator0.setInterpolator(c.a(context0, v));
        }
        typedArray0.recycle();
        if(typedArray1 != null) {
            typedArray1.recycle();
        }
        return valueAnimator0;
    }

    private static Keyframe m(Context context0, Resources resources0, Resources.Theme resources$Theme0, AttributeSet attributeSet0, int v, XmlPullParser xmlPullParser0) {
        Keyframe keyframe0;
        TypedArray typedArray0 = k.k(resources0, resources$Theme0, attributeSet0, androidx.vectordrawable.graphics.drawable.a.j);
        float f = k.f(typedArray0, xmlPullParser0, "fraction", 3, -1.0f);
        TypedValue typedValue0 = k.l(typedArray0, xmlPullParser0, "value", 0);
        if(v == 4) {
            v = typedValue0 == null || !d.h(typedValue0.type) ? 0 : 3;
        }
        if(typedValue0 == null) {
            keyframe0 = v == 0 ? Keyframe.ofFloat(f) : Keyframe.ofInt(f);
        }
        else {
            switch(v) {
                case 0: {
                    keyframe0 = Keyframe.ofFloat(f, k.f(typedArray0, xmlPullParser0, "value", 0, 0.0f));
                    break;
                }
                case 1: 
                case 3: {
                    keyframe0 = Keyframe.ofInt(f, k.g(typedArray0, xmlPullParser0, "value", 0, 0));
                    break;
                }
                default: {
                    keyframe0 = null;
                }
            }
        }
        int v1 = k.h(typedArray0, xmlPullParser0, "interpolator", 1, 0);
        if(v1 > 0) {
            keyframe0.setInterpolator(c.a(context0, v1));
        }
        typedArray0.recycle();
        return keyframe0;
    }

    private static ObjectAnimator n(Context context0, Resources resources0, Resources.Theme resources$Theme0, AttributeSet attributeSet0, float f, XmlPullParser xmlPullParser0) {
        ObjectAnimator objectAnimator0 = new ObjectAnimator();
        d.l(context0, resources0, resources$Theme0, attributeSet0, objectAnimator0, f, xmlPullParser0);
        return objectAnimator0;
    }

    private static PropertyValuesHolder o(Context context0, Resources resources0, Resources.Theme resources$Theme0, XmlPullParser xmlPullParser0, String s, int v) {
        PropertyValuesHolder propertyValuesHolder0 = null;
        ArrayList arrayList0 = null;
    alab1:
        while(true) {
            switch(xmlPullParser0.next()) {
                case 1: 
                case 3: {
                    break alab1;
                }
                default: {
                    if(!xmlPullParser0.getName().equals("keyframe")) {
                        break;
                    }
                    if(v == 4) {
                        v = d.g(resources0, resources$Theme0, Xml.asAttributeSet(xmlPullParser0), xmlPullParser0);
                    }
                    Keyframe keyframe0 = d.m(context0, resources0, resources$Theme0, Xml.asAttributeSet(xmlPullParser0), v, xmlPullParser0);
                    if(keyframe0 != null) {
                        if(arrayList0 == null) {
                            arrayList0 = new ArrayList();
                        }
                        arrayList0.add(keyframe0);
                    }
                    xmlPullParser0.next();
                }
            }
        }
        if(arrayList0 != null) {
            int v1 = arrayList0.size();
            if(v1 > 0) {
                Keyframe keyframe1 = (Keyframe)arrayList0.get(0);
                Keyframe keyframe2 = (Keyframe)arrayList0.get(v1 - 1);
                float f = keyframe2.getFraction();
                if(Float.compare(f, 1.0f) < 0) {
                    if(f < 0.0f) {
                        keyframe2.setFraction(1.0f);
                    }
                    else {
                        arrayList0.add(arrayList0.size(), d.c(keyframe2, 1.0f));
                        ++v1;
                    }
                }
                float f1 = keyframe1.getFraction();
                if(f1 != 0.0f) {
                    if(f1 < 0.0f) {
                        keyframe1.setFraction(0.0f);
                    }
                    else {
                        arrayList0.add(0, d.c(keyframe1, 0.0f));
                        ++v1;
                    }
                }
                Keyframe[] arr_keyframe = new Keyframe[v1];
                arrayList0.toArray(arr_keyframe);
                for(int v2 = 0; v2 < v1; ++v2) {
                    Keyframe keyframe3 = arr_keyframe[v2];
                    if(keyframe3.getFraction() < 0.0f) {
                        if(v2 == 0) {
                            keyframe3.setFraction(0.0f);
                        }
                        else if(v2 == v1 - 1) {
                            keyframe3.setFraction(1.0f);
                        }
                        else {
                            int v3 = v2 + 1;
                            int v4 = v2;
                            while(v3 < v1 - 1 && arr_keyframe[v3].getFraction() < 0.0f) {
                                v4 = v3;
                                ++v3;
                            }
                            d.d(arr_keyframe, arr_keyframe[v4 + 1].getFraction() - arr_keyframe[v2 - 1].getFraction(), v2, v4);
                        }
                    }
                }
                propertyValuesHolder0 = PropertyValuesHolder.ofKeyframe(s, arr_keyframe);
                if(v == 3) {
                    propertyValuesHolder0.setEvaluator(e.a());
                }
            }
        }
        return propertyValuesHolder0;
    }

    private static PropertyValuesHolder[] p(Context context0, Resources resources0, Resources.Theme resources$Theme0, XmlPullParser xmlPullParser0, AttributeSet attributeSet0) {
        PropertyValuesHolder[] arr_propertyValuesHolder = null;
        ArrayList arrayList0 = null;
    alab1:
        while(true) {
            switch(xmlPullParser0.getEventType()) {
                case 2: {
                    if(xmlPullParser0.getName().equals("propertyValuesHolder")) {
                        TypedArray typedArray0 = k.k(resources0, resources$Theme0, attributeSet0, androidx.vectordrawable.graphics.drawable.a.i);
                        String s = k.i(typedArray0, xmlPullParser0, "propertyName", 3);
                        int v1 = k.g(typedArray0, xmlPullParser0, "valueType", 2, 4);
                        int v2 = v1;
                        PropertyValuesHolder propertyValuesHolder0 = d.o(context0, resources0, resources$Theme0, xmlPullParser0, s, v1);
                        if(propertyValuesHolder0 == null) {
                            propertyValuesHolder0 = d.e(typedArray0, v2, 0, 1, s);
                        }
                        if(propertyValuesHolder0 != null) {
                            if(arrayList0 == null) {
                                arrayList0 = new ArrayList();
                            }
                            arrayList0.add(propertyValuesHolder0);
                        }
                        typedArray0.recycle();
                    }
                    xmlPullParser0.next();
                    break;
                }
                case 1: 
                case 3: {
                    break alab1;
                }
                default: {
                    xmlPullParser0.next();
                    break;
                }
            }
        }
        if(arrayList0 != null) {
            int v3 = arrayList0.size();
            arr_propertyValuesHolder = new PropertyValuesHolder[v3];
            for(int v = 0; v < v3; ++v) {
                arr_propertyValuesHolder[v] = (PropertyValuesHolder)arrayList0.get(v);
            }
        }
        return arr_propertyValuesHolder;
    }

    private static void q(ValueAnimator valueAnimator0, TypedArray typedArray0, TypedArray typedArray1, float f, XmlPullParser xmlPullParser0) {
        long v = (long)k.g(typedArray0, xmlPullParser0, "duration", 1, 300);
        long v1 = (long)k.g(typedArray0, xmlPullParser0, "startOffset", 2, 0);
        int v2 = k.g(typedArray0, xmlPullParser0, "valueType", 7, 4);
        if(k.j(xmlPullParser0, "valueFrom") && k.j(xmlPullParser0, "valueTo")) {
            if(v2 == 4) {
                v2 = d.f(typedArray0, 5, 6);
            }
            PropertyValuesHolder propertyValuesHolder0 = d.e(typedArray0, v2, 5, 6, "");
            if(propertyValuesHolder0 != null) {
                valueAnimator0.setValues(new PropertyValuesHolder[]{propertyValuesHolder0});
            }
        }
        valueAnimator0.setDuration(v);
        valueAnimator0.setStartDelay(v1);
        valueAnimator0.setRepeatCount(k.g(typedArray0, xmlPullParser0, "repeatCount", 3, 0));
        valueAnimator0.setRepeatMode(k.g(typedArray0, xmlPullParser0, "repeatMode", 4, 1));
        if(typedArray1 != null) {
            d.r(valueAnimator0, typedArray1, v2, f, xmlPullParser0);
        }
    }

    private static void r(ValueAnimator valueAnimator0, TypedArray typedArray0, int v, float f, XmlPullParser xmlPullParser0) {
        String s = k.i(typedArray0, xmlPullParser0, "pathData", 1);
        if(s != null) {
            String s1 = k.i(typedArray0, xmlPullParser0, "propertyXName", 2);
            String s2 = k.i(typedArray0, xmlPullParser0, "propertyYName", 3);
            if(s1 == null && s2 == null) {
                throw new InflateException(typedArray0.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
            }
            d.s(h.e(s), ((ObjectAnimator)valueAnimator0), f * 0.5f, s1, s2);
            return;
        }
        ((ObjectAnimator)valueAnimator0).setPropertyName(k.i(typedArray0, xmlPullParser0, "propertyName", 0));
    }

    private static void s(Path path0, ObjectAnimator objectAnimator0, float f, String s, String s1) {
        PropertyValuesHolder propertyValuesHolder0;
        PathMeasure pathMeasure0 = new PathMeasure(path0, false);
        ArrayList arrayList0 = new ArrayList();
        float f1 = 0.0f;
        arrayList0.add(0.0f);
        float f2 = 0.0f;
        do {
            f2 += pathMeasure0.getLength();
            arrayList0.add(f2);
        }
        while(pathMeasure0.nextContour());
        PathMeasure pathMeasure1 = new PathMeasure(path0, false);
        int v = Math.min(100, ((int)(f2 / f)) + 1);
        float[] arr_f = new float[v];
        float[] arr_f1 = new float[v];
        float[] arr_f2 = new float[2];
        int v2 = 0;
        for(int v1 = 0; true; ++v1) {
            propertyValuesHolder0 = null;
            if(v1 >= v) {
                break;
            }
            pathMeasure1.getPosTan(f1 - ((float)(((Float)arrayList0.get(v2)))), arr_f2, null);
            arr_f[v1] = arr_f2[0];
            arr_f1[v1] = arr_f2[1];
            f1 += f2 / ((float)(v - 1));
            if(v2 + 1 < arrayList0.size() && f1 > ((float)(((Float)arrayList0.get(v2 + 1))))) {
                pathMeasure1.nextContour();
                ++v2;
            }
        }
        PropertyValuesHolder propertyValuesHolder1 = s == null ? null : PropertyValuesHolder.ofFloat(s, arr_f);
        if(s1 != null) {
            propertyValuesHolder0 = PropertyValuesHolder.ofFloat(s1, arr_f1);
        }
        if(propertyValuesHolder1 == null) {
            objectAnimator0.setValues(new PropertyValuesHolder[]{propertyValuesHolder0});
            return;
        }
        if(propertyValuesHolder0 == null) {
            objectAnimator0.setValues(new PropertyValuesHolder[]{propertyValuesHolder1});
            return;
        }
        objectAnimator0.setValues(new PropertyValuesHolder[]{propertyValuesHolder1, propertyValuesHolder0});
    }
}

