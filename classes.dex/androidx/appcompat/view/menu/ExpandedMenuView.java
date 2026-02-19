package androidx.appcompat.view.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.widget.l0;

public final class ExpandedMenuView extends ListView implements AdapterView.OnItemClickListener, b, j {
    private e a;
    private int b;
    private static final int[] c;

    static {
        ExpandedMenuView.c = new int[]{0x10100D4, 0x1010129};
    }

    public ExpandedMenuView(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x1010074);
    }

    public ExpandedMenuView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0);
        this.setOnItemClickListener(this);
        l0 l00 = l0.s(context0, attributeSet0, ExpandedMenuView.c, v, 0);
        if(l00.p(0)) {
            this.setBackgroundDrawable(l00.f(0));
        }
        if(l00.p(1)) {
            this.setDivider(l00.f(1));
        }
        l00.t();
    }

    @Override  // androidx.appcompat.view.menu.e$b
    public boolean a(f f0) {
        return this.a.H(f0, 0);
    }

    public int getWindowAnimations() {
        return this.b;
    }

    @Override  // android.widget.ListView
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.setChildrenDrawingCacheEnabled(false);
    }

    @Override  // android.widget.AdapterView$OnItemClickListener
    public void onItemClick(AdapterView adapterView0, View view0, int v, long v1) {
        this.a(((f)this.getAdapter().getItem(v)));
    }
}

