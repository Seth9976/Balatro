package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.widget.ImageView;

public abstract class c {
    static abstract class a {
        static ColorStateList a(ImageView imageView0) {
            return imageView0.getImageTintList();
        }

        static PorterDuff.Mode b(ImageView imageView0) {
            return imageView0.getImageTintMode();
        }

        static void c(ImageView imageView0, ColorStateList colorStateList0) {
            imageView0.setImageTintList(colorStateList0);
        }

        static void d(ImageView imageView0, PorterDuff.Mode porterDuff$Mode0) {
            imageView0.setImageTintMode(porterDuff$Mode0);
        }
    }

    public static ColorStateList a(ImageView imageView0) {
        return a.a(imageView0);
    }

    public static PorterDuff.Mode b(ImageView imageView0) {
        return a.b(imageView0);
    }

    public static void c(ImageView imageView0, ColorStateList colorStateList0) {
        a.c(imageView0, colorStateList0);
    }

    public static void d(ImageView imageView0, PorterDuff.Mode porterDuff$Mode0) {
        a.d(imageView0, porterDuff$Mode0);
    }
}

