package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import androidx.core.graphics.drawable.a;
import c.g;
import m.b;

public final class f implements b {
    private View A;
    private MenuItem.OnActionExpandListener B;
    private boolean C;
    private ContextMenu.ContextMenuInfo D;
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private CharSequence e;
    private CharSequence f;
    private Intent g;
    private char h;
    private int i;
    private char j;
    private int k;
    private Drawable l;
    private int m;
    e n;
    private m o;
    private Runnable p;
    private MenuItem.OnMenuItemClickListener q;
    private CharSequence r;
    private CharSequence s;
    private ColorStateList t;
    private PorterDuff.Mode u;
    private boolean v;
    private boolean w;
    private boolean x;
    private int y;
    private int z;

    f(e e0, int v, int v1, int v2, int v3, CharSequence charSequence0, int v4) {
        this.i = 0x1000;
        this.k = 0x1000;
        this.m = 0;
        this.t = null;
        this.u = null;
        this.v = false;
        this.w = false;
        this.x = false;
        this.y = 16;
        this.C = false;
        this.n = e0;
        this.a = v1;
        this.b = v;
        this.c = v2;
        this.d = v3;
        this.e = charSequence0;
        this.z = v4;
    }

    public boolean A() {
        return (this.z & 4) == 4;
    }

    public void a() {
        this.n.E(this);
    }

    private static void b(StringBuilder stringBuilder0, int v, int v1, String s) {
        if((v & v1) == v1) {
            stringBuilder0.append(s);
        }
    }

    private Drawable c(Drawable drawable0) {
        if(drawable0 != null && this.x && (this.v || this.w)) {
            drawable0 = drawable0.mutate();
            if(this.v) {
                a.n(drawable0, this.t);
            }
            if(this.w) {
                a.o(drawable0, this.u);
            }
            this.x = false;
        }
        return drawable0;
    }

    @Override  // android.view.MenuItem
    public boolean collapseActionView() {
        if((this.z & 8) == 0) {
            return false;
        }
        if(this.A == null) {
            return true;
        }
        return this.B == null || this.B.onMenuItemActionCollapse(this) ? this.n.e(this) : false;
    }

    public int d() {
        return this.d;
    }

    // 去混淆评级： 低(20)
    char e() {
        return this.n.C() ? this.j : this.h;
    }

    @Override  // android.view.MenuItem
    public boolean expandActionView() {
        if(!this.i()) {
            return false;
        }
        return this.B == null || this.B.onMenuItemActionExpand(this) ? this.n.j(this) : false;
    }

    String f() {
        int v2;
        int v = this.e();
        if(v == 0) {
            return "";
        }
        Resources resources0 = this.n.s().getResources();
        StringBuilder stringBuilder0 = new StringBuilder();
        if(ViewConfiguration.get(this.n.s()).hasPermanentMenuKey()) {
            stringBuilder0.append(resources0.getString(g.k));
        }
        int v1 = this.n.C() ? this.k : this.i;
        f.b(stringBuilder0, v1, 0x10000, resources0.getString(g.g));
        f.b(stringBuilder0, v1, 0x1000, resources0.getString(g.c));
        f.b(stringBuilder0, v1, 2, resources0.getString(g.b));
        f.b(stringBuilder0, v1, 1, resources0.getString(g.h));
        f.b(stringBuilder0, v1, 4, resources0.getString(g.j));
        f.b(stringBuilder0, v1, 8, resources0.getString(g.f));
        switch(v) {
            case 8: {
                v2 = g.d;
                break;
            }
            case 10: {
                v2 = g.e;
                break;
            }
            case 0x20: {
                v2 = g.i;
                break;
            }
            default: {
                stringBuilder0.append(((char)v));
                return stringBuilder0.toString();
            }
        }
        stringBuilder0.append(resources0.getString(v2));
        return stringBuilder0.toString();
    }

    public androidx.core.view.b g() {
        return null;
    }

    @Override  // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override  // android.view.MenuItem
    public View getActionView() {
        return this.A == null ? null : this.A;
    }

    @Override  // android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.k;
    }

    @Override  // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.j;
    }

    @Override  // android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.r;
    }

    @Override  // android.view.MenuItem
    public int getGroupId() {
        return this.b;
    }

    @Override  // android.view.MenuItem
    public Drawable getIcon() {
        Drawable drawable0 = this.l;
        if(drawable0 != null) {
            return this.c(drawable0);
        }
        if(this.m != 0) {
            Drawable drawable1 = e.a.b(this.n.s(), this.m);
            this.m = 0;
            this.l = drawable1;
            return this.c(drawable1);
        }
        return null;
    }

    @Override  // android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.t;
    }

    @Override  // android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.u;
    }

    @Override  // android.view.MenuItem
    public Intent getIntent() {
        return this.g;
    }

    @Override  // android.view.MenuItem
    public int getItemId() {
        return this.a;
    }

    @Override  // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.D;
    }

    @Override  // android.view.MenuItem
    public int getNumericModifiers() {
        return this.i;
    }

    @Override  // android.view.MenuItem
    public char getNumericShortcut() {
        return this.h;
    }

    @Override  // android.view.MenuItem
    public int getOrder() {
        return this.c;
    }

    @Override  // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.o;
    }

    @Override  // android.view.MenuItem
    public CharSequence getTitle() {
        return this.e;
    }

    @Override  // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return this.f == null ? this.e : this.f;
    }

    @Override  // android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.s;
    }

    CharSequence h(androidx.appcompat.view.menu.j.a j$a0) {
        return j$a0 == null || !j$a0.c() ? this.getTitle() : this.getTitleCondensed();
    }

    @Override  // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.o != null;
    }

    public boolean i() {
        return (this.z & 8) != 0 && this.A != null;
    }

    @Override  // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.C;
    }

    @Override  // android.view.MenuItem
    public boolean isCheckable() {
        return (this.y & 1) == 1;
    }

    @Override  // android.view.MenuItem
    public boolean isChecked() {
        return (this.y & 2) == 2;
    }

    @Override  // android.view.MenuItem
    public boolean isEnabled() {
        return (this.y & 16) != 0;
    }

    @Override  // android.view.MenuItem
    public boolean isVisible() {
        return (this.y & 8) == 0;
    }

    public boolean j() {
        if(this.q != null && this.q.onMenuItemClick(this)) {
            return true;
        }
        if(this.n.g(this.n, this)) {
            return true;
        }
        Runnable runnable0 = this.p;
        if(runnable0 != null) {
            runnable0.run();
            return true;
        }
        if(this.g != null) {
            try {
                this.n.s().startActivity(this.g);
                return true;
            }
            catch(ActivityNotFoundException activityNotFoundException0) {
                Log.e("MenuItemImpl", "Can\'t find activity to handle intent; ignoring", activityNotFoundException0);
            }
        }
        return false;
    }

    public boolean k() {
        return (this.y & 0x20) == 0x20;
    }

    public boolean l() {
        return (this.y & 4) != 0;
    }

    public boolean m() {
        return (this.z & 1) == 1;
    }

    public boolean n() {
        return (this.z & 2) == 2;
    }

    public b o(int v) {
        Context context0 = this.n.s();
        this.p(LayoutInflater.from(context0).inflate(v, new LinearLayout(context0), false));
        return this;
    }

    public b p(View view0) {
        this.A = view0;
        if(view0 != null && view0.getId() == -1) {
            int v = this.a;
            if(v > 0) {
                view0.setId(v);
            }
        }
        this.n.E(this);
        return this;
    }

    public void q(boolean z) {
        this.C = z;
        this.n.G(false);
    }

    void r(boolean z) {
        int v = this.y;
        int v1 = (z ? 2 : 0) | v & -3;
        this.y = v1;
        if(v != v1) {
            this.n.G(false);
        }
    }

    public void s(boolean z) {
        this.y = (z ? 4 : 0) | this.y & -5;
    }

    @Override  // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider0) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override  // android.view.MenuItem
    public MenuItem setActionView(int v) {
        return this.o(v);
    }

    @Override  // android.view.MenuItem
    public MenuItem setActionView(View view0) {
        return this.p(view0);
    }

    @Override  // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c) {
        if(this.j == c) {
            return this;
        }
        this.j = Character.toLowerCase(c);
        this.n.G(false);
        return this;
    }

    @Override  // m.b
    public MenuItem setAlphabeticShortcut(char c, int v) {
        if(this.j == c && this.k == v) {
            return this;
        }
        this.j = Character.toLowerCase(c);
        this.k = KeyEvent.normalizeMetaState(v);
        this.n.G(false);
        return this;
    }

    @Override  // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        int v = this.y;
        int v1 = z | v & -2;
        this.y = v1;
        if(v != v1) {
            this.n.G(false);
        }
        return this;
    }

    @Override  // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        if((this.y & 4) != 0) {
            this.n.M(this);
            return this;
        }
        this.r(z);
        return this;
    }

    @Override  // android.view.MenuItem
    public MenuItem setContentDescription(CharSequence charSequence0) {
        return this.setContentDescription(charSequence0);
    }

    @Override  // m.b
    public b setContentDescription(CharSequence charSequence0) {
        this.r = charSequence0;
        this.n.G(false);
        return this;
    }

    @Override  // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        this.y = z ? this.y | 16 : this.y & -17;
        this.n.G(false);
        return this;
    }

    @Override  // android.view.MenuItem
    public MenuItem setIcon(int v) {
        this.l = null;
        this.m = v;
        this.x = true;
        this.n.G(false);
        return this;
    }

    @Override  // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable0) {
        this.m = 0;
        this.l = drawable0;
        this.x = true;
        this.n.G(false);
        return this;
    }

    @Override  // m.b
    public MenuItem setIconTintList(ColorStateList colorStateList0) {
        this.t = colorStateList0;
        this.v = true;
        this.x = true;
        this.n.G(false);
        return this;
    }

    @Override  // m.b
    public MenuItem setIconTintMode(PorterDuff.Mode porterDuff$Mode0) {
        this.u = porterDuff$Mode0;
        this.w = true;
        this.x = true;
        this.n.G(false);
        return this;
    }

    @Override  // android.view.MenuItem
    public MenuItem setIntent(Intent intent0) {
        this.g = intent0;
        return this;
    }

    @Override  // android.view.MenuItem
    public MenuItem setNumericShortcut(char c) {
        if(this.h == c) {
            return this;
        }
        this.h = c;
        this.n.G(false);
        return this;
    }

    @Override  // m.b
    public MenuItem setNumericShortcut(char c, int v) {
        if(this.h == c && this.i == v) {
            return this;
        }
        this.h = c;
        this.i = KeyEvent.normalizeMetaState(v);
        this.n.G(false);
        return this;
    }

    @Override  // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener menuItem$OnActionExpandListener0) {
        this.B = menuItem$OnActionExpandListener0;
        return this;
    }

    @Override  // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener menuItem$OnMenuItemClickListener0) {
        this.q = menuItem$OnMenuItemClickListener0;
        return this;
    }

    @Override  // android.view.MenuItem
    public MenuItem setShortcut(char c, char c1) {
        this.h = c;
        this.j = Character.toLowerCase(c1);
        this.n.G(false);
        return this;
    }

    @Override  // android.view.MenuItem
    public MenuItem setShortcut(char c, char c1, int v, int v1) {
        this.h = c;
        this.i = KeyEvent.normalizeMetaState(v);
        this.j = Character.toLowerCase(c1);
        this.k = KeyEvent.normalizeMetaState(v1);
        this.n.G(false);
        return this;
    }

    @Override  // android.view.MenuItem
    public void setShowAsAction(int v) {
        if((v & 3) != 0 && (v & 3) != 1 && (v & 3) != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.z = v;
        this.n.E(this);
    }

    @Override  // android.view.MenuItem
    public MenuItem setShowAsActionFlags(int v) {
        return this.v(v);
    }

    @Override  // android.view.MenuItem
    public MenuItem setTitle(int v) {
        return this.setTitle(this.n.s().getString(v));
    }

    @Override  // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence0) {
        this.e = charSequence0;
        this.n.G(false);
        m m0 = this.o;
        if(m0 != null) {
            m0.setHeaderTitle(charSequence0);
        }
        return this;
    }

    @Override  // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence0) {
        this.f = charSequence0;
        this.n.G(false);
        return this;
    }

    @Override  // android.view.MenuItem
    public MenuItem setTooltipText(CharSequence charSequence0) {
        return this.setTooltipText(charSequence0);
    }

    @Override  // m.b
    public b setTooltipText(CharSequence charSequence0) {
        this.s = charSequence0;
        this.n.G(false);
        return this;
    }

    @Override  // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        if(this.x(z)) {
            this.n.F(this);
        }
        return this;
    }

    public void t(boolean z) {
        this.y = z ? this.y | 0x20 : this.y & -33;
    }

    @Override
    public String toString() {
        return this.e == null ? null : this.e.toString();
    }

    void u(ContextMenu.ContextMenuInfo contextMenu$ContextMenuInfo0) {
        this.D = contextMenu$ContextMenuInfo0;
    }

    public b v(int v) {
        this.setShowAsAction(v);
        return this;
    }

    public void w(m m0) {
        this.o = m0;
        m0.setHeaderTitle(this.getTitle());
    }

    boolean x(boolean z) {
        int v = this.y;
        int v1 = (z ? 0 : 8) | v & -9;
        this.y = v1;
        return v != v1;
    }

    public boolean y() {
        return this.n.w();
    }

    boolean z() {
        return this.n.D() && this.e() != 0;
    }
}

