package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public class m extends e implements SubMenu {
    private e B;
    private f C;

    public m(Context context0, e e0, f f0) {
        super(context0);
        this.B = e0;
        this.C = f0;
    }

    @Override  // androidx.appcompat.view.menu.e
    public boolean B() {
        return this.B.B();
    }

    @Override  // androidx.appcompat.view.menu.e
    public boolean C() {
        return this.B.C();
    }

    @Override  // androidx.appcompat.view.menu.e
    public boolean D() {
        return this.B.D();
    }

    @Override  // androidx.appcompat.view.menu.e
    public void L(a e$a0) {
        this.B.L(e$a0);
    }

    public Menu W() {
        return this.B;
    }

    @Override  // androidx.appcompat.view.menu.e
    public boolean e(f f0) {
        return this.B.e(f0);
    }

    // 去混淆评级： 低(20)
    @Override  // androidx.appcompat.view.menu.e
    boolean g(e e0, MenuItem menuItem0) {
        return super.g(e0, menuItem0) || this.B.g(e0, menuItem0);
    }

    @Override  // android.view.SubMenu
    public MenuItem getItem() {
        return this.C;
    }

    @Override  // androidx.appcompat.view.menu.e
    public boolean j(f f0) {
        return this.B.j(f0);
    }

    @Override  // androidx.appcompat.view.menu.e, android.view.Menu
    public void setGroupDividerEnabled(boolean z) {
        this.B.setGroupDividerEnabled(z);
    }

    @Override  // android.view.SubMenu
    public SubMenu setHeaderIcon(int v) {
        return (SubMenu)super.N(v);
    }

    @Override  // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable0) {
        return (SubMenu)super.O(drawable0);
    }

    @Override  // android.view.SubMenu
    public SubMenu setHeaderTitle(int v) {
        return (SubMenu)super.Q(v);
    }

    @Override  // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence0) {
        return (SubMenu)super.R(charSequence0);
    }

    @Override  // android.view.SubMenu
    public SubMenu setHeaderView(View view0) {
        return (SubMenu)super.S(view0);
    }

    @Override  // android.view.SubMenu
    public SubMenu setIcon(int v) {
        this.C.setIcon(v);
        return this;
    }

    @Override  // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable0) {
        this.C.setIcon(drawable0);
        return this;
    }

    @Override  // androidx.appcompat.view.menu.e, android.view.Menu
    public void setQwertyMode(boolean z) {
        this.B.setQwertyMode(z);
    }

    @Override  // androidx.appcompat.view.menu.e
    public e z() {
        return this.B.z();
    }
}

