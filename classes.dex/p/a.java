package p;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;
import androidx.core.util.c;

public abstract class a {
    static abstract class p.a.a {
        static void a(EditorInfo editorInfo0, CharSequence charSequence0, int v) {
            editorInfo0.setInitialSurroundingSubText(charSequence0, v);
        }
    }

    private static final String[] a;

    static {
        a.a = new String[0];
    }

    private static boolean a(CharSequence charSequence0, int v, int v1) {
        switch(v1) {
            case 0: {
                return Character.isLowSurrogate(charSequence0.charAt(v));
            }
            case 1: {
                return Character.isHighSurrogate(charSequence0.charAt(v));
            }
            default: {
                return false;
            }
        }
    }

    private static boolean b(int v) {
        return (v & 0xFFF) == 18 || (v & 0xFFF) == 0x81 || (v & 0xFFF) == 0xE1;
    }

    public static void c(EditorInfo editorInfo0, CharSequence charSequence0, int v) {
        c.d(charSequence0);
        if(Build.VERSION.SDK_INT >= 30) {
            p.a.a.a(editorInfo0, charSequence0, v);
            return;
        }
        int v1 = editorInfo0.initialSelStart <= editorInfo0.initialSelEnd ? editorInfo0.initialSelStart - v : editorInfo0.initialSelEnd - v;
        int v2 = editorInfo0.initialSelStart <= editorInfo0.initialSelEnd ? editorInfo0.initialSelEnd - v : editorInfo0.initialSelStart - v;
        int v3 = charSequence0.length();
        if(v >= 0 && v1 >= 0 && v2 <= v3) {
            if(a.b(editorInfo0.inputType)) {
                a.e(editorInfo0, null, 0, 0);
                return;
            }
            if(v3 <= 0x800) {
                a.e(editorInfo0, charSequence0, v1, v2);
                return;
            }
            a.f(editorInfo0, charSequence0, v1, v2);
            return;
        }
        a.e(editorInfo0, null, 0, 0);
    }

    public static void d(EditorInfo editorInfo0, CharSequence charSequence0) {
        if(Build.VERSION.SDK_INT >= 30) {
            p.a.a.a(editorInfo0, charSequence0, 0);
            return;
        }
        a.c(editorInfo0, charSequence0, 0);
    }

    private static void e(EditorInfo editorInfo0, CharSequence charSequence0, int v, int v1) {
        if(editorInfo0.extras == null) {
            editorInfo0.extras = new Bundle();
        }
        SpannableStringBuilder spannableStringBuilder0 = charSequence0 == null ? null : new SpannableStringBuilder(charSequence0);
        editorInfo0.extras.putCharSequence("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT", spannableStringBuilder0);
        editorInfo0.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD", v);
        editorInfo0.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END", v1);
    }

    private static void f(EditorInfo editorInfo0, CharSequence charSequence0, int v, int v1) {
        int v2 = v1 - v;
        int v3 = v2 <= 0x400 ? v2 : 0;
        int v4 = Math.min(charSequence0.length() - v1, 0x800 - v3 - Math.min(v, ((int)(((double)(0x800 - v3)) * 0.8))));
        int v5 = Math.min(v, 0x800 - v3 - v4);
        int v6 = v - v5;
        if(a.a(charSequence0, v6, 0)) {
            ++v6;
            --v5;
        }
        if(a.a(charSequence0, v1 + v4 - 1, 1)) {
            --v4;
        }
        a.e(editorInfo0, (v3 == v2 ? charSequence0.subSequence(v6, v5 + v3 + v4 + v6) : TextUtils.concat(new CharSequence[]{charSequence0.subSequence(v6, v6 + v5), charSequence0.subSequence(v1, v4 + v1)})), v5, v3 + v5);
    }
}

