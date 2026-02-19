package androidx.emoji2.text;

import android.text.TextPaint;
import androidx.core.graphics.g;

class d implements androidx.emoji2.text.e.d {
    private final TextPaint a;
    private static final ThreadLocal b;

    static {
        d.b = new ThreadLocal();
    }

    d() {
        TextPaint textPaint0 = new TextPaint();
        this.a = textPaint0;
        textPaint0.setTextSize(10.0f);
    }

    @Override  // androidx.emoji2.text.e$d
    public boolean a(CharSequence charSequence0, int v, int v1, int v2) {
        StringBuilder stringBuilder0 = d.b();
        stringBuilder0.setLength(0);
        while(v < v1) {
            stringBuilder0.append(charSequence0.charAt(v));
            ++v;
        }
        return g.a(this.a, stringBuilder0.toString());
    }

    private static StringBuilder b() {
        ThreadLocal threadLocal0 = d.b;
        if(threadLocal0.get() == null) {
            threadLocal0.set(new StringBuilder());
        }
        return (StringBuilder)threadLocal0.get();
    }
}

