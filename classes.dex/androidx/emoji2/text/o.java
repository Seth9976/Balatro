package androidx.emoji2.text;

import android.graphics.Canvas;
import android.graphics.Paint.Style;
import android.graphics.Paint;
import android.text.TextPaint;

public final class o extends i {
    private static Paint f;

    public o(g g0) {
        super(g0);
    }

    private static Paint c() {
        if(o.f == null) {
            TextPaint textPaint0 = new TextPaint();
            o.f = textPaint0;
            textPaint0.setColor(e.b().c());
            o.f.setStyle(Paint.Style.FILL);
        }
        return o.f;
    }

    @Override  // android.text.style.ReplacementSpan
    public void draw(Canvas canvas0, CharSequence charSequence0, int v, int v1, float f, int v2, int v3, int v4, Paint paint0) {
        if(e.b().i()) {
            canvas0.drawRect(f, ((float)v2), f + ((float)this.b()), ((float)v4), o.c());
        }
        this.a().a(canvas0, f, ((float)v3), paint0);
    }
}

