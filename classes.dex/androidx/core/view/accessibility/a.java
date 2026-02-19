package androidx.core.view.accessibility;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

public final class a extends ClickableSpan {
    private final int a;
    private final u b;
    private final int c;

    public a(int v, u u0, int v1) {
        this.a = v;
        this.b = u0;
        this.c = v1;
    }

    @Override  // android.text.style.ClickableSpan
    public void onClick(View view0) {
        Bundle bundle0 = new Bundle();
        bundle0.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.a);
        this.b.F(this.c, bundle0);
    }
}

