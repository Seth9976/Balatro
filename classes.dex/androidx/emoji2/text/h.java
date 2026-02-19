package androidx.emoji2.text;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import java.util.Arrays;

final class h {
    static abstract class a {
        static int a(CharSequence charSequence0, int v, int v1) {
            boolean z;
            if(v < 0 || charSequence0.length() < v || v1 < 0) {
                return -1;
            }
            while(true) {
                z = false;
            label_3:
                if(v1 == 0) {
                    return v;
                }
                --v;
                if(v < 0) {
                    return z ? -1 : 0;
                }
                int v2 = charSequence0.charAt(v);
                if(!z) {
                    break;
                }
                if(!Character.isHighSurrogate(((char)v2))) {
                    return -1;
                }
                --v1;
            }
            if(!Character.isSurrogate(((char)v2))) {
                --v1;
                goto label_3;
            }
            if(!Character.isHighSurrogate(((char)v2))) {
                z = true;
                goto label_3;
            }
            return -1;
        }

        static int b(CharSequence charSequence0, int v, int v1) {
            boolean z;
            int v2 = charSequence0.length();
            if(v < 0 || v2 < v || v1 < 0) {
                return -1;
            }
            while(true) {
                z = false;
            label_4:
                if(v1 == 0) {
                    return v;
                }
                if(v >= v2) {
                    return z ? -1 : v2;
                }
                int v3 = charSequence0.charAt(v);
                if(!z) {
                    break;
                }
                if(!Character.isLowSurrogate(((char)v3))) {
                    return -1;
                }
                --v1;
                ++v;
            }
            if(!Character.isSurrogate(((char)v3))) {
                --v1;
                ++v;
                goto label_4;
            }
            if(!Character.isLowSurrogate(((char)v3))) {
                ++v;
                z = true;
                goto label_4;
            }
            return -1;
        }
    }

    static final class b {
        private int a;
        private final androidx.emoji2.text.m.a b;
        private androidx.emoji2.text.m.a c;
        private androidx.emoji2.text.m.a d;
        private int e;
        private int f;
        private final boolean g;
        private final int[] h;

        b(androidx.emoji2.text.m.a m$a0, boolean z, int[] arr_v) {
            this.a = 1;
            this.b = m$a0;
            this.c = m$a0;
            this.g = z;
            this.h = arr_v;
        }

        int a(int v) {
            androidx.emoji2.text.m.a m$a0 = this.c.a(v);
            int v1 = 2;
            if(this.a == 2) {
                if(m$a0 != null) {
                    this.c = m$a0;
                    ++this.f;
                }
                else if(b.f(v)) {
                    v1 = this.g();
                }
                else if(!b.d(v)) {
                    v1 = 3;
                    if(this.c.b() == null || this.f == 1 && !this.h()) {
                        v1 = this.g();
                    }
                    else {
                        this.d = this.c;
                        this.g();
                    }
                }
            }
            else if(m$a0 != null) {
                this.a = 2;
                this.c = m$a0;
                this.f = 1;
            }
            else {
                v1 = this.g();
            }
            this.e = v;
            return v1;
        }

        g b() {
            return this.c.b();
        }

        g c() {
            return this.d.b();
        }

        private static boolean d(int v) {
            return v == 0xFE0F;
        }

        // 去混淆评级： 低(20)
        boolean e() {
            return this.a == 2 && this.c.b() != null && (this.f > 1 || this.h());
        }

        private static boolean f(int v) {
            return v == 0xFE0E;
        }

        private int g() {
            this.a = 1;
            this.c = this.b;
            this.f = 0;
            return 1;
        }

        private boolean h() {
            if(this.c.b().j()) {
                return true;
            }
            if(b.d(this.e)) {
                return true;
            }
            if(this.g) {
                if(this.h == null) {
                    return true;
                }
                int v = this.c.b().b(0);
                return Arrays.binarySearch(this.h, v) < 0;
            }
            return false;
        }
    }

    private final i a;
    private final m b;
    private d c;
    private final boolean d;
    private final int[] e;

    h(m m0, i e$i0, d e$d0, boolean z, int[] arr_v) {
        this.a = e$i0;
        this.b = m0;
        this.c = e$d0;
        this.d = z;
        this.e = arr_v;
    }

    private void a(Spannable spannable0, g g0, int v, int v1) {
        spannable0.setSpan(this.a.a(g0), v, v1, 33);
    }

    private static boolean b(Editable editable0, KeyEvent keyEvent0, boolean z) {
        if(h.g(keyEvent0)) {
            return false;
        }
        int v = Selection.getSelectionStart(editable0);
        int v1 = Selection.getSelectionEnd(editable0);
        if(h.f(v, v1)) {
            return false;
        }
        androidx.emoji2.text.i[] arr_i = (androidx.emoji2.text.i[])editable0.getSpans(v, v1, androidx.emoji2.text.i.class);
        if(arr_i != null && arr_i.length > 0) {
            for(int v2 = 0; v2 < arr_i.length; ++v2) {
                androidx.emoji2.text.i i0 = arr_i[v2];
                int v3 = editable0.getSpanStart(i0);
                int v4 = editable0.getSpanEnd(i0);
                if(z && v3 == v || !z && v4 == v || v > v3 && v < v4) {
                    editable0.delete(v3, v4);
                    return true;
                }
            }
        }
        return false;
    }

    static boolean c(InputConnection inputConnection0, Editable editable0, int v, int v1, boolean z) {
        int v5;
        int v4;
        if(editable0 != null && inputConnection0 != null && v >= 0 && v1 >= 0) {
            int v2 = Selection.getSelectionStart(editable0);
            int v3 = Selection.getSelectionEnd(editable0);
            if(h.f(v2, v3)) {
                return false;
            }
            if(z) {
                v4 = a.a(editable0, v2, Math.max(v, 0));
                v5 = a.b(editable0, v3, Math.max(v1, 0));
                if(v4 == -1 || v5 == -1) {
                    return false;
                }
            }
            else {
                v4 = Math.max(v2 - v, 0);
                v5 = Math.min(v3 + v1, editable0.length());
            }
            androidx.emoji2.text.i[] arr_i = (androidx.emoji2.text.i[])editable0.getSpans(v4, v5, androidx.emoji2.text.i.class);
            if(arr_i != null && arr_i.length > 0) {
                for(int v6 = 0; v6 < arr_i.length; ++v6) {
                    androidx.emoji2.text.i i0 = arr_i[v6];
                    v4 = Math.min(editable0.getSpanStart(i0), v4);
                    v5 = Math.max(editable0.getSpanEnd(i0), v5);
                }
                int v7 = Math.min(v5, editable0.length());
                inputConnection0.beginBatchEdit();
                editable0.delete(Math.max(v4, 0), v7);
                inputConnection0.endBatchEdit();
                return true;
            }
        }
        return false;
    }

    static boolean d(Editable editable0, int v, KeyEvent keyEvent0) {
        boolean z;
        switch(v) {
            case 67: {
                z = h.b(editable0, keyEvent0, false);
                break;
            }
            case 0x70: {
                z = h.b(editable0, keyEvent0, true);
                break;
            }
            default: {
                z = false;
            }
        }
        if(z) {
            MetaKeyKeyListener.adjustMetaAfterKeypress(editable0);
            return true;
        }
        return false;
    }

    private boolean e(CharSequence charSequence0, int v, int v1, g g0) {
        if(g0.d() == 0) {
            g0.k(this.c.a(charSequence0, v, v1, g0.h()));
        }
        return g0.d() == 2;
    }

    private static boolean f(int v, int v1) {
        return v == -1 || v1 == -1 || v != v1;
    }

    private static boolean g(KeyEvent keyEvent0) {
        return !KeyEvent.metaStateHasNoModifiers(keyEvent0.getMetaState());
    }

    CharSequence h(CharSequence charSequence0, int v, int v1, int v2, boolean z) {
        CharSequence charSequence1;
        int v8;
        r r0;
        if(charSequence0 instanceof n) {
            ((n)charSequence0).a();
        }
        try {
            Class class0 = androidx.emoji2.text.i.class;
            if(charSequence0 instanceof n) {
                r0 = new r(((Spannable)charSequence0));
            }
            else if(charSequence0 instanceof Spannable) {
                r0 = new r(((Spannable)charSequence0));
            }
            else if(charSequence0 instanceof Spanned && ((Spanned)charSequence0).nextSpanTransition(v - 1, v1 + 1, class0) <= v1) {
                r0 = new r(charSequence0);
            }
            else {
                r0 = null;
            }
            if(r0 != null) {
                androidx.emoji2.text.i[] arr_i = (androidx.emoji2.text.i[])r0.getSpans(v, v1, class0);
                if(arr_i != null && arr_i.length > 0) {
                    for(int v3 = 0; v3 < arr_i.length; ++v3) {
                        androidx.emoji2.text.i i0 = arr_i[v3];
                        int v4 = r0.getSpanStart(i0);
                        int v5 = r0.getSpanEnd(i0);
                        if(v4 != v1) {
                            r0.removeSpan(i0);
                        }
                        v = Math.min(v4, v);
                        v1 = Math.max(v5, v1);
                    }
                }
            }
            if(v != v1 && v < charSequence0.length()) {
                if(v2 != 0x7FFFFFFF && r0 != null) {
                    v2 -= ((androidx.emoji2.text.i[])r0.getSpans(0, r0.length(), class0)).length;
                }
                b h$b0 = new b(this.b.f(), this.d, this.e);
                int v6 = Character.codePointAt(charSequence0, v);
                int v7 = 0;
                r r1 = r0;
            alab1:
                while(true) {
                    v8 = v;
                    while(true) {
                        if(v >= v1 || v7 >= v2) {
                            break alab1;
                        }
                        switch(h$b0.a(v6)) {
                            case 1: {
                                v8 += Character.charCount(Character.codePointAt(charSequence0, v8));
                                if(v8 < v1) {
                                    v6 = Character.codePointAt(charSequence0, v8);
                                }
                                v = v8;
                                continue;
                            }
                            case 2: {
                                v += Character.charCount(v6);
                                if(v >= v1) {
                                    continue;
                                }
                                v6 = Character.codePointAt(charSequence0, v);
                                continue;
                            }
                            case 3: {
                                break;
                            }
                            default: {
                                continue;
                            }
                        }
                        if(!z && this.e(charSequence0, v8, v, h$b0.c())) {
                            break;
                        }
                        if(r1 == null) {
                            r1 = new r(new SpannableString(charSequence0));
                        }
                        this.a(r1, h$b0.c(), v8, v);
                        ++v7;
                        break;
                    }
                }
                if(h$b0.e() && v7 < v2 && (z || !this.e(charSequence0, v8, v, h$b0.b()))) {
                    if(r1 == null) {
                        r1 = new r(charSequence0);
                    }
                    this.a(r1, h$b0.b(), v8, v);
                }
                if(r1 != null) {
                    charSequence1 = r1.b();
                    goto label_64;
                }
                goto label_67;
            }
            goto label_70;
        }
        catch(Throwable throwable0) {
            if(charSequence0 instanceof n) {
                ((n)charSequence0).d();
            }
            throw throwable0;
        }
    label_64:
        if(charSequence0 instanceof n) {
            ((n)charSequence0).d();
        }
        return charSequence1;
    label_67:
        if(charSequence0 instanceof n) {
            ((n)charSequence0).d();
        }
        return charSequence0;
    label_70:
        if(charSequence0 instanceof n) {
            ((n)charSequence0).d();
        }
        return charSequence0;
    }
}

