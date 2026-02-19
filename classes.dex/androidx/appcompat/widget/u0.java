package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import java.io.InputStream;
import java.lang.ref.WeakReference;

public class u0 extends d0 {
    private final WeakReference b;
    private static boolean c;

    static {
    }

    public u0(Context context0, Resources resources0) {
        super(resources0);
        this.b = new WeakReference(context0);
    }

    public static boolean b() [...] // 潜在的解密器

    // 去混淆评级： 低(20)
    public static boolean c() [...] // 潜在的解密器

    @Override  // androidx.appcompat.widget.d0
    public XmlResourceParser getAnimation(int v) {
        return super.getAnimation(v);
    }

    @Override  // androidx.appcompat.widget.d0
    public boolean getBoolean(int v) {
        return super.getBoolean(v);
    }

    @Override  // androidx.appcompat.widget.d0
    public int getColor(int v) {
        return super.getColor(v);
    }

    @Override  // androidx.appcompat.widget.d0
    public ColorStateList getColorStateList(int v) {
        return super.getColorStateList(v);
    }

    @Override  // androidx.appcompat.widget.d0
    public Configuration getConfiguration() {
        return super.getConfiguration();
    }

    @Override  // androidx.appcompat.widget.d0
    public float getDimension(int v) {
        return super.getDimension(v);
    }

    @Override  // androidx.appcompat.widget.d0
    public int getDimensionPixelOffset(int v) {
        return super.getDimensionPixelOffset(v);
    }

    @Override  // androidx.appcompat.widget.d0
    public int getDimensionPixelSize(int v) {
        return super.getDimensionPixelSize(v);
    }

    @Override  // androidx.appcompat.widget.d0
    public DisplayMetrics getDisplayMetrics() {
        return super.getDisplayMetrics();
    }

    @Override  // android.content.res.Resources
    public Drawable getDrawable(int v) {
        Context context0 = (Context)this.b.get();
        return context0 == null ? this.a(v) : c0.h().s(context0, this, v);
    }

    @Override  // androidx.appcompat.widget.d0
    public Drawable getDrawable(int v, Resources.Theme resources$Theme0) {
        return super.getDrawable(v, resources$Theme0);
    }

    @Override  // androidx.appcompat.widget.d0
    public Drawable getDrawableForDensity(int v, int v1) {
        return super.getDrawableForDensity(v, v1);
    }

    @Override  // androidx.appcompat.widget.d0
    public Drawable getDrawableForDensity(int v, int v1, Resources.Theme resources$Theme0) {
        return super.getDrawableForDensity(v, v1, resources$Theme0);
    }

    @Override  // androidx.appcompat.widget.d0
    public float getFraction(int v, int v1, int v2) {
        return super.getFraction(v, v1, v2);
    }

    @Override  // androidx.appcompat.widget.d0
    public int getIdentifier(String s, String s1, String s2) {
        return super.getIdentifier(s, s1, s2);
    }

    @Override  // androidx.appcompat.widget.d0
    public int[] getIntArray(int v) {
        return super.getIntArray(v);
    }

    @Override  // androidx.appcompat.widget.d0
    public int getInteger(int v) {
        return super.getInteger(v);
    }

    @Override  // androidx.appcompat.widget.d0
    public XmlResourceParser getLayout(int v) {
        return super.getLayout(v);
    }

    @Override  // androidx.appcompat.widget.d0
    public Movie getMovie(int v) {
        return super.getMovie(v);
    }

    @Override  // androidx.appcompat.widget.d0
    public String getQuantityString(int v, int v1) {
        return super.getQuantityString(v, v1);
    }

    @Override  // androidx.appcompat.widget.d0
    public String getQuantityString(int v, int v1, Object[] arr_object) {
        return super.getQuantityString(v, v1, arr_object);
    }

    @Override  // androidx.appcompat.widget.d0
    public CharSequence getQuantityText(int v, int v1) {
        return super.getQuantityText(v, v1);
    }

    @Override  // androidx.appcompat.widget.d0
    public String getResourceEntryName(int v) {
        return super.getResourceEntryName(v);
    }

    @Override  // androidx.appcompat.widget.d0
    public String getResourceName(int v) {
        return super.getResourceName(v);
    }

    @Override  // androidx.appcompat.widget.d0
    public String getResourcePackageName(int v) {
        return super.getResourcePackageName(v);
    }

    @Override  // androidx.appcompat.widget.d0
    public String getResourceTypeName(int v) {
        return super.getResourceTypeName(v);
    }

    @Override  // androidx.appcompat.widget.d0
    public String getString(int v) {
        return super.getString(v);
    }

    @Override  // androidx.appcompat.widget.d0
    public String getString(int v, Object[] arr_object) {
        return super.getString(v, arr_object);
    }

    @Override  // androidx.appcompat.widget.d0
    public String[] getStringArray(int v) {
        return super.getStringArray(v);
    }

    @Override  // androidx.appcompat.widget.d0
    public CharSequence getText(int v) {
        return super.getText(v);
    }

    @Override  // androidx.appcompat.widget.d0
    public CharSequence getText(int v, CharSequence charSequence0) {
        return super.getText(v, charSequence0);
    }

    @Override  // androidx.appcompat.widget.d0
    public CharSequence[] getTextArray(int v) {
        return super.getTextArray(v);
    }

    @Override  // androidx.appcompat.widget.d0
    public void getValue(int v, TypedValue typedValue0, boolean z) {
        super.getValue(v, typedValue0, z);
    }

    @Override  // androidx.appcompat.widget.d0
    public void getValue(String s, TypedValue typedValue0, boolean z) {
        super.getValue(s, typedValue0, z);
    }

    @Override  // androidx.appcompat.widget.d0
    public void getValueForDensity(int v, int v1, TypedValue typedValue0, boolean z) {
        super.getValueForDensity(v, v1, typedValue0, z);
    }

    @Override  // androidx.appcompat.widget.d0
    public XmlResourceParser getXml(int v) {
        return super.getXml(v);
    }

    @Override  // androidx.appcompat.widget.d0
    public TypedArray obtainAttributes(AttributeSet attributeSet0, int[] arr_v) {
        return super.obtainAttributes(attributeSet0, arr_v);
    }

    @Override  // androidx.appcompat.widget.d0
    public TypedArray obtainTypedArray(int v) {
        return super.obtainTypedArray(v);
    }

    @Override  // androidx.appcompat.widget.d0
    public InputStream openRawResource(int v) {
        return super.openRawResource(v);
    }

    @Override  // androidx.appcompat.widget.d0
    public InputStream openRawResource(int v, TypedValue typedValue0) {
        return super.openRawResource(v, typedValue0);
    }

    @Override  // androidx.appcompat.widget.d0
    public AssetFileDescriptor openRawResourceFd(int v) {
        return super.openRawResourceFd(v);
    }

    @Override  // androidx.appcompat.widget.d0
    public void parseBundleExtra(String s, AttributeSet attributeSet0, Bundle bundle0) {
        super.parseBundleExtra(s, attributeSet0, bundle0);
    }

    @Override  // androidx.appcompat.widget.d0
    public void parseBundleExtras(XmlResourceParser xmlResourceParser0, Bundle bundle0) {
        super.parseBundleExtras(xmlResourceParser0, bundle0);
    }

    @Override  // androidx.appcompat.widget.d0
    public void updateConfiguration(Configuration configuration0, DisplayMetrics displayMetrics0) {
        super.updateConfiguration(configuration0, displayMetrics0);
    }
}

