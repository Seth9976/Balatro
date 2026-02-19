package androidx.emoji2.text;

import android.os.Build.VERSION;
import android.text.Spannable;
import android.text.SpannableString;
import java.util.stream.IntStream;

class r implements Spannable {
    static abstract class a {
        static IntStream a(CharSequence charSequence0) {
            return charSequence0.chars();
        }

        static IntStream b(CharSequence charSequence0) {
            return charSequence0.codePoints();
        }
    }

    static class b {
        boolean a(CharSequence charSequence0) {
            return false;
        }
    }

    static class c extends b {
        @Override  // androidx.emoji2.text.r$b
        boolean a(CharSequence charSequence0) {
            return s.a(charSequence0);
        }
    }

    private boolean e;
    private Spannable f;

    r(Spannable spannable0) {
        this.e = false;
        this.f = spannable0;
    }

    r(CharSequence charSequence0) {
        this.e = false;
        this.f = new SpannableString(charSequence0);
    }

    private void a() {
        Spannable spannable0 = this.f;
        if(!this.e && r.c().a(spannable0)) {
            this.f = new SpannableString(spannable0);
        }
        this.e = true;
    }

    Spannable b() {
        return this.f;
    }

    static b c() {
        return Build.VERSION.SDK_INT < 28 ? new b() : new c();
    }

    @Override
    public char charAt(int v) {
        return this.f.charAt(v);
    }

    @Override
    public IntStream chars() {
        return a.a(this.f);
    }

    @Override
    public IntStream codePoints() {
        return a.b(this.f);
    }

    @Override  // android.text.Spanned
    public int getSpanEnd(Object object0) {
        return this.f.getSpanEnd(object0);
    }

    @Override  // android.text.Spanned
    public int getSpanFlags(Object object0) {
        return this.f.getSpanFlags(object0);
    }

    @Override  // android.text.Spanned
    public int getSpanStart(Object object0) {
        return this.f.getSpanStart(object0);
    }

    @Override  // android.text.Spanned
    public Object[] getSpans(int v, int v1, Class class0) {
        return this.f.getSpans(v, v1, class0);
    }

    @Override
    public int length() {
        return this.f.length();
    }

    @Override  // android.text.Spanned
    public int nextSpanTransition(int v, int v1, Class class0) {
        return this.f.nextSpanTransition(v, v1, class0);
    }

    @Override  // android.text.Spannable
    public void removeSpan(Object object0) {
        this.a();
        this.f.removeSpan(object0);
    }

    @Override  // android.text.Spannable
    public void setSpan(Object object0, int v, int v1, int v2) {
        this.a();
        this.f.setSpan(object0, v, v1, v2);
    }

    @Override
    public CharSequence subSequence(int v, int v1) {
        return this.f.subSequence(v, v1);
    }

    @Override
    public String toString() {
        return this.f.toString();
    }
}

