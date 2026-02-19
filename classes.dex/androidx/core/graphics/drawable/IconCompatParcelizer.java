package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
import androidx.versionedparcelable.a;

public class IconCompatParcelizer {
    public static IconCompat read(a a0) {
        IconCompat iconCompat0 = new IconCompat();
        iconCompat0.a = a0.p(iconCompat0.a, 1);
        iconCompat0.c = a0.j(iconCompat0.c, 2);
        iconCompat0.d = a0.r(iconCompat0.d, 3);
        iconCompat0.e = a0.p(iconCompat0.e, 4);
        iconCompat0.f = a0.p(iconCompat0.f, 5);
        iconCompat0.g = (ColorStateList)a0.r(iconCompat0.g, 6);
        iconCompat0.i = a0.t(iconCompat0.i, 7);
        iconCompat0.j = a0.t(iconCompat0.j, 8);
        iconCompat0.h();
        return iconCompat0;
    }

    public static void write(IconCompat iconCompat0, a a0) {
        iconCompat0.i(false);
        int v = iconCompat0.a;
        if(-1 != v) {
            a0.F(v, 1);
        }
        byte[] arr_b = iconCompat0.c;
        if(arr_b != null) {
            a0.B(arr_b, 2);
        }
        Parcelable parcelable0 = iconCompat0.d;
        if(parcelable0 != null) {
            a0.H(parcelable0, 3);
        }
        int v1 = iconCompat0.e;
        if(v1 != 0) {
            a0.F(v1, 4);
        }
        int v2 = iconCompat0.f;
        if(v2 != 0) {
            a0.F(v2, 5);
        }
        ColorStateList colorStateList0 = iconCompat0.g;
        if(colorStateList0 != null) {
            a0.H(colorStateList0, 6);
        }
        String s = iconCompat0.i;
        if(s != null) {
            a0.J(s, 7);
        }
        String s1 = iconCompat0.j;
        if(s1 != null) {
            a0.J(s1, 8);
        }
    }
}

