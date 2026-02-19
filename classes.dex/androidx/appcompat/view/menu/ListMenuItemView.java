package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.SelectionBoundsAdjuster;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.widget.l0;
import androidx.core.view.v;
import c.e;
import c.i;

public class ListMenuItemView extends LinearLayout implements AbsListView.SelectionBoundsAdjuster, a {
    private f a;
    private ImageView b;
    private RadioButton c;
    private TextView d;
    private CheckBox e;
    private TextView f;
    private ImageView g;
    private ImageView h;
    private LinearLayout i;
    private Drawable j;
    private int k;
    private Context l;
    private boolean m;
    private Drawable n;
    private boolean o;
    private LayoutInflater p;
    private boolean q;

    public ListMenuItemView(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, c.a.o);
    }

    public ListMenuItemView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0);
        l0 l00 = l0.s(this.getContext(), attributeSet0, i.k1, v, 0);
        this.j = l00.f(i.m1);
        this.k = l00.l(i.l1, -1);
        this.m = l00.a(i.n1, false);
        this.l = context0;
        this.n = l00.f(i.o1);
        TypedArray typedArray0 = context0.getTheme().obtainStyledAttributes(null, new int[]{0x1010129}, c.a.n, 0);
        this.o = typedArray0.hasValue(0);
        l00.t();
        typedArray0.recycle();
    }

    private void a(View view0) {
        this.b(view0, -1);
    }

    @Override  // android.widget.AbsListView$SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(Rect rect0) {
        if(this.h != null && this.h.getVisibility() == 0) {
            LinearLayout.LayoutParams linearLayout$LayoutParams0 = (LinearLayout.LayoutParams)this.h.getLayoutParams();
            rect0.top += this.h.getHeight() + linearLayout$LayoutParams0.topMargin + linearLayout$LayoutParams0.bottomMargin;
        }
    }

    private void b(View view0, int v) {
        LinearLayout linearLayout0 = this.i;
        if(linearLayout0 != null) {
            linearLayout0.addView(view0, v);
            return;
        }
        this.addView(view0, v);
    }

    @Override  // androidx.appcompat.view.menu.j$a
    public boolean c() {
        return false;
    }

    @Override  // androidx.appcompat.view.menu.j$a
    public void d(f f0, int v) {
        this.a = f0;
        this.setVisibility((f0.isVisible() ? 0 : 8));
        this.setTitle(f0.h(this));
        this.setCheckable(f0.isCheckable());
        this.h(f0.z(), f0.e());
        this.setIcon(f0.getIcon());
        this.setEnabled(f0.isEnabled());
        this.setSubMenuArrowVisible(f0.hasSubMenu());
        this.setContentDescription(f0.getContentDescription());
    }

    private void e() {
        CheckBox checkBox0 = (CheckBox)this.getInflater().inflate(c.f.f, this, false);
        this.e = checkBox0;
        this.a(checkBox0);
    }

    private void f() {
        ImageView imageView0 = (ImageView)this.getInflater().inflate(c.f.g, this, false);
        this.b = imageView0;
        this.b(imageView0, 0);
    }

    private void g() {
        RadioButton radioButton0 = (RadioButton)this.getInflater().inflate(c.f.h, this, false);
        this.c = radioButton0;
        this.a(radioButton0);
    }

    private LayoutInflater getInflater() {
        if(this.p == null) {
            this.p = LayoutInflater.from(this.getContext());
        }
        return this.p;
    }

    @Override  // androidx.appcompat.view.menu.j$a
    public f getItemData() {
        return this.a;
    }

    public void h(boolean z, char c) {
        int v = !z || !this.a.z() ? 8 : 0;
        if(v == 0) {
            this.f.setText(this.a.f());
        }
        if(this.f.getVisibility() != v) {
            this.f.setVisibility(v);
        }
    }

    @Override  // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        v.J(this, this.j);
        TextView textView0 = (TextView)this.findViewById(e.A);
        this.d = textView0;
        int v = this.k;
        if(v != -1) {
            textView0.setTextAppearance(this.l, v);
        }
        this.f = (TextView)this.findViewById(e.v);
        ImageView imageView0 = (ImageView)this.findViewById(e.y);
        this.g = imageView0;
        if(imageView0 != null) {
            imageView0.setImageDrawable(this.n);
        }
        this.h = (ImageView)this.findViewById(e.l);
        this.i = (LinearLayout)this.findViewById(e.h);
    }

    @Override  // android.widget.LinearLayout
    protected void onMeasure(int v, int v1) {
        if(this.b != null && this.m) {
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = this.getLayoutParams();
            LinearLayout.LayoutParams linearLayout$LayoutParams0 = (LinearLayout.LayoutParams)this.b.getLayoutParams();
            int v2 = viewGroup$LayoutParams0.height;
            if(v2 > 0 && linearLayout$LayoutParams0.width <= 0) {
                linearLayout$LayoutParams0.width = v2;
            }
        }
        super.onMeasure(v, v1);
    }

    public void setCheckable(boolean z) {
        CheckBox checkBox0;
        RadioButton radioButton0;
        if(!z && this.c == null && this.e == null) {
            return;
        }
        if(this.a.l()) {
            if(this.c == null) {
                this.g();
            }
            radioButton0 = this.c;
            checkBox0 = this.e;
        }
        else {
            if(this.e == null) {
                this.e();
            }
            radioButton0 = this.e;
            checkBox0 = this.c;
        }
        if(z) {
            radioButton0.setChecked(this.a.isChecked());
            if(radioButton0.getVisibility() != 0) {
                radioButton0.setVisibility(0);
            }
            if(checkBox0 != null && checkBox0.getVisibility() != 8) {
                checkBox0.setVisibility(8);
            }
        }
        else {
            CheckBox checkBox1 = this.e;
            if(checkBox1 != null) {
                checkBox1.setVisibility(8);
            }
            RadioButton radioButton1 = this.c;
            if(radioButton1 != null) {
                radioButton1.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean z) {
        RadioButton radioButton0;
        if(this.a.l()) {
            if(this.c == null) {
                this.g();
            }
            radioButton0 = this.c;
        }
        else {
            if(this.e == null) {
                this.e();
            }
            radioButton0 = this.e;
        }
        radioButton0.setChecked(z);
    }

    public void setForceShowIcon(boolean z) {
        this.q = z;
        this.m = z;
    }

    public void setGroupDividerEnabled(boolean z) {
        ImageView imageView0 = this.h;
        if(imageView0 != null) {
            imageView0.setVisibility((this.o || !z ? 8 : 0));
        }
    }

    public void setIcon(Drawable drawable0) {
        boolean z = this.a.y() || this.q;
        if(!z && !this.m) {
            return;
        }
        ImageView imageView0 = this.b;
        if(imageView0 == null && drawable0 == null && !this.m) {
            return;
        }
        if(imageView0 == null) {
            this.f();
        }
        if(drawable0 == null && !this.m) {
            this.b.setVisibility(8);
            return;
        }
        ImageView imageView1 = this.b;
        if(!z) {
            drawable0 = null;
        }
        imageView1.setImageDrawable(drawable0);
        if(this.b.getVisibility() != 0) {
            this.b.setVisibility(0);
        }
    }

    private void setSubMenuArrowVisible(boolean z) {
        ImageView imageView0 = this.g;
        if(imageView0 != null) {
            imageView0.setVisibility((z ? 0 : 8));
        }
    }

    public void setTitle(CharSequence charSequence0) {
        if(charSequence0 != null) {
            this.d.setText(charSequence0);
            if(this.d.getVisibility() != 0) {
                this.d.setVisibility(0);
            }
        }
        else if(this.d.getVisibility() != 8) {
            this.d.setVisibility(8);
        }
    }
}

