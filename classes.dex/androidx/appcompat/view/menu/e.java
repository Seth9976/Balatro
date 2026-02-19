package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyCharacterMap.KeyData;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import m.a;

public class e implements a {
    public interface androidx.appcompat.view.menu.e.a {
        boolean a(e arg1, MenuItem arg2);

        void b(e arg1);
    }

    public interface b {
        boolean a(f arg1);
    }

    private static final int[] A;
    private final Context a;
    private final Resources b;
    private boolean c;
    private boolean d;
    private androidx.appcompat.view.menu.e.a e;
    private ArrayList f;
    private ArrayList g;
    private boolean h;
    private ArrayList i;
    private ArrayList j;
    private boolean k;
    private int l;
    private ContextMenu.ContextMenuInfo m;
    CharSequence n;
    Drawable o;
    View p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private ArrayList v;
    private CopyOnWriteArrayList w;
    private f x;
    private boolean y;
    private boolean z;

    static {
        e.A = new int[]{1, 4, 5, 3, 2, 0};
    }

    public e(Context context0) {
        this.l = 0;
        this.q = false;
        this.r = false;
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = new ArrayList();
        this.w = new CopyOnWriteArrayList();
        this.y = false;
        this.a = context0;
        this.b = context0.getResources();
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.h = true;
        this.i = new ArrayList();
        this.j = new ArrayList();
        this.k = true;
        this.T(true);
    }

    public ArrayList A() {
        if(!this.h) {
            return this.g;
        }
        this.g.clear();
        int v = this.f.size();
        for(int v1 = 0; v1 < v; ++v1) {
            f f0 = (f)this.f.get(v1);
            if(f0.isVisible()) {
                this.g.add(f0);
            }
        }
        this.h = false;
        this.k = true;
        return this.g;
    }

    public boolean B() {
        return this.y;
    }

    boolean C() {
        return this.c;
    }

    public boolean D() {
        return this.d;
    }

    void E(f f0) {
        this.k = true;
        this.G(true);
    }

    void F(f f0) {
        this.h = true;
        this.G(true);
    }

    public void G(boolean z) {
        if(!this.q) {
            if(z) {
                this.h = true;
                this.k = true;
            }
            this.h(z);
            return;
        }
        this.r = true;
        if(z) {
            this.s = true;
        }
    }

    public boolean H(MenuItem menuItem0, int v) {
        return this.I(menuItem0, null, v);
    }

    public boolean I(MenuItem menuItem0, i i0, int v) {
        if(((f)menuItem0) != null && ((f)menuItem0).isEnabled()) {
            boolean z = ((f)menuItem0).j();
            if(((f)menuItem0).i()) {
                z |= ((f)menuItem0).expandActionView();
                if(!z) {
                    return z;
                }
            }
            else if(((f)menuItem0).hasSubMenu()) {
                if((v & 4) == 0) {
                    this.d(false);
                }
                if(!((f)menuItem0).hasSubMenu()) {
                    ((f)menuItem0).w(new m(this.s(), this, ((f)menuItem0)));
                }
                z |= this.i(((m)((f)menuItem0).getSubMenu()), i0);
                if(z) {
                    return z;
                }
            }
            else if((v & 1) != 0) {
                return z;
            }
            this.d(true);
            return z;
        }
        return false;
    }

    private void J(int v, boolean z) {
        if(v >= 0 && v < this.f.size()) {
            this.f.remove(v);
            if(z) {
                this.G(true);
            }
        }
    }

    public void K(i i0) {
        for(Object object0: this.w) {
            WeakReference weakReference0 = (WeakReference)object0;
            i i1 = (i)weakReference0.get();
            if(i1 == null || i1 == i0) {
                this.w.remove(weakReference0);
            }
        }
    }

    public void L(androidx.appcompat.view.menu.e.a e$a0) {
        this.e = e$a0;
    }

    void M(MenuItem menuItem0) {
        int v = menuItem0.getGroupId();
        int v1 = this.f.size();
        this.V();
        for(int v2 = 0; v2 < v1; ++v2) {
            f f0 = (f)this.f.get(v2);
            if(f0.getGroupId() == v && f0.l() && f0.isCheckable()) {
                f0.r(f0 == menuItem0);
            }
        }
        this.U();
    }

    protected e N(int v) {
        this.P(0, null, v, null, null);
        return this;
    }

    protected e O(Drawable drawable0) {
        this.P(0, null, 0, drawable0, null);
        return this;
    }

    private void P(int v, CharSequence charSequence0, int v1, Drawable drawable0, View view0) {
        Resources resources0 = this.y();
        if(view0 == null) {
            if(v > 0) {
                this.n = resources0.getText(v);
            }
            else if(charSequence0 != null) {
                this.n = charSequence0;
            }
            if(v1 > 0) {
                this.o = androidx.core.content.a.c(this.s(), v1);
            }
            else if(drawable0 != null) {
                this.o = drawable0;
            }
            this.p = null;
        }
        else {
            this.p = view0;
            this.n = null;
            this.o = null;
        }
        this.G(false);
    }

    protected e Q(int v) {
        this.P(v, null, 0, null, null);
        return this;
    }

    protected e R(CharSequence charSequence0) {
        this.P(0, charSequence0, 0, null, null);
        return this;
    }

    protected e S(View view0) {
        this.P(0, null, 0, null, view0);
        return this;
    }

    private void T(boolean z) {
        this.d = z && this.b.getConfiguration().keyboard != 1 && x.b(ViewConfiguration.get(this.a), this.a);
    }

    public void U() {
        this.q = false;
        if(this.r) {
            this.r = false;
            this.G(this.s);
        }
    }

    public void V() {
        if(!this.q) {
            this.q = true;
            this.r = false;
            this.s = false;
        }
    }

    protected MenuItem a(int v, int v1, int v2, CharSequence charSequence0) {
        int v3 = e.x(v2);
        MenuItem menuItem0 = this.f(v, v1, v2, v3, charSequence0, this.l);
        ContextMenu.ContextMenuInfo contextMenu$ContextMenuInfo0 = this.m;
        if(contextMenu$ContextMenuInfo0 != null) {
            ((f)menuItem0).u(contextMenu$ContextMenuInfo0);
        }
        this.f.add(e.m(this.f, v3), menuItem0);
        this.G(true);
        return menuItem0;
    }

    @Override  // android.view.Menu
    public MenuItem add(int v) {
        return this.a(0, 0, 0, this.b.getString(v));
    }

    @Override  // android.view.Menu
    public MenuItem add(int v, int v1, int v2, int v3) {
        return this.a(v, v1, v2, this.b.getString(v3));
    }

    @Override  // android.view.Menu
    public MenuItem add(int v, int v1, int v2, CharSequence charSequence0) {
        return this.a(v, v1, v2, charSequence0);
    }

    @Override  // android.view.Menu
    public MenuItem add(CharSequence charSequence0) {
        return this.a(0, 0, 0, charSequence0);
    }

    @Override  // android.view.Menu
    public int addIntentOptions(int v, int v1, int v2, ComponentName componentName0, Intent[] arr_intent, Intent intent0, int v3, MenuItem[] arr_menuItem) {
        PackageManager packageManager0 = this.a.getPackageManager();
        List list0 = packageManager0.queryIntentActivityOptions(componentName0, arr_intent, intent0, 0);
        int v5 = list0 == null ? 0 : list0.size();
        if((v3 & 1) == 0) {
            this.removeGroup(v);
        }
        for(int v4 = 0; v4 < v5; ++v4) {
            ResolveInfo resolveInfo0 = (ResolveInfo)list0.get(v4);
            Intent intent1 = new Intent((resolveInfo0.specificIndex >= 0 ? arr_intent[resolveInfo0.specificIndex] : intent0));
            intent1.setComponent(new ComponentName(resolveInfo0.activityInfo.applicationInfo.packageName, resolveInfo0.activityInfo.name));
            MenuItem menuItem0 = this.add(v, v1, v2, resolveInfo0.loadLabel(packageManager0)).setIcon(resolveInfo0.loadIcon(packageManager0)).setIntent(intent1);
            if(arr_menuItem != null) {
                int v6 = resolveInfo0.specificIndex;
                if(v6 >= 0) {
                    arr_menuItem[v6] = menuItem0;
                }
            }
        }
        return v5;
    }

    @Override  // android.view.Menu
    public SubMenu addSubMenu(int v) {
        return this.addSubMenu(0, 0, 0, this.b.getString(v));
    }

    @Override  // android.view.Menu
    public SubMenu addSubMenu(int v, int v1, int v2, int v3) {
        return this.addSubMenu(v, v1, v2, this.b.getString(v3));
    }

    @Override  // android.view.Menu
    public SubMenu addSubMenu(int v, int v1, int v2, CharSequence charSequence0) {
        f f0 = (f)this.a(v, v1, v2, charSequence0);
        SubMenu subMenu0 = new m(this.a, this, f0);
        f0.w(((m)subMenu0));
        return subMenu0;
    }

    @Override  // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence0) {
        return this.addSubMenu(0, 0, 0, charSequence0);
    }

    public void b(i i0, Context context0) {
        this.w.add(new WeakReference(i0));
        i0.d(context0, this);
        this.k = true;
    }

    public void c() {
        androidx.appcompat.view.menu.e.a e$a0 = this.e;
        if(e$a0 != null) {
            e$a0.b(this);
        }
    }

    @Override  // android.view.Menu
    public void clear() {
        f f0 = this.x;
        if(f0 != null) {
            this.e(f0);
        }
        this.f.clear();
        this.G(true);
    }

    public void clearHeader() {
        this.o = null;
        this.n = null;
        this.p = null;
        this.G(false);
    }

    @Override  // android.view.Menu
    public void close() {
        this.d(true);
    }

    public final void d(boolean z) {
        if(this.u) {
            return;
        }
        this.u = true;
        for(Object object0: this.w) {
            WeakReference weakReference0 = (WeakReference)object0;
            i i0 = (i)weakReference0.get();
            if(i0 == null) {
                this.w.remove(weakReference0);
            }
            else {
                i0.a(this, z);
            }
        }
        this.u = false;
    }

    public boolean e(f f0) {
        boolean z = false;
        if(!this.w.isEmpty() && this.x == f0) {
            this.V();
            for(Object object0: this.w) {
                WeakReference weakReference0 = (WeakReference)object0;
                i i0 = (i)weakReference0.get();
                if(i0 == null) {
                    this.w.remove(weakReference0);
                }
                else {
                    z = i0.e(this, f0);
                    if(z) {
                        break;
                    }
                }
            }
            this.U();
            if(z) {
                this.x = null;
            }
        }
        return z;
    }

    private f f(int v, int v1, int v2, int v3, CharSequence charSequence0, int v4) {
        return new f(this, v, v1, v2, v3, charSequence0, v4);
    }

    @Override  // android.view.Menu
    public MenuItem findItem(int v) {
        int v1 = this.size();
        for(int v2 = 0; v2 < v1; ++v2) {
            MenuItem menuItem0 = (f)this.f.get(v2);
            if(((f)menuItem0).getItemId() == v) {
                return menuItem0;
            }
            if(((f)menuItem0).hasSubMenu()) {
                MenuItem menuItem1 = ((f)menuItem0).getSubMenu().findItem(v);
                if(menuItem1 != null) {
                    return menuItem1;
                }
            }
        }
        return null;
    }

    boolean g(e e0, MenuItem menuItem0) {
        return this.e != null && this.e.a(e0, menuItem0);
    }

    @Override  // android.view.Menu
    public MenuItem getItem(int v) {
        return (MenuItem)this.f.get(v);
    }

    private void h(boolean z) {
        if(this.w.isEmpty()) {
            return;
        }
        this.V();
        for(Object object0: this.w) {
            WeakReference weakReference0 = (WeakReference)object0;
            i i0 = (i)weakReference0.get();
            if(i0 == null) {
                this.w.remove(weakReference0);
            }
            else {
                i0.k(z);
            }
        }
        this.U();
    }

    @Override  // android.view.Menu
    public boolean hasVisibleItems() {
        if(this.z) {
            return true;
        }
        int v = this.size();
        for(int v1 = 0; v1 < v; ++v1) {
            if(((f)this.f.get(v1)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    private boolean i(m m0, i i0) {
        boolean z = false;
        if(this.w.isEmpty()) {
            return false;
        }
        if(i0 != null) {
            z = i0.j(m0);
        }
        for(Object object0: this.w) {
            WeakReference weakReference0 = (WeakReference)object0;
            i i1 = (i)weakReference0.get();
            if(i1 == null) {
                this.w.remove(weakReference0);
            }
            else if(!z) {
                z = i1.j(m0);
            }
        }
        return z;
    }

    @Override  // android.view.Menu
    public boolean isShortcutKey(int v, KeyEvent keyEvent0) {
        return this.o(v, keyEvent0) != null;
    }

    public boolean j(f f0) {
        boolean z = false;
        if(this.w.isEmpty()) {
            return false;
        }
        this.V();
        for(Object object0: this.w) {
            WeakReference weakReference0 = (WeakReference)object0;
            i i0 = (i)weakReference0.get();
            if(i0 == null) {
                this.w.remove(weakReference0);
            }
            else {
                z = i0.h(this, f0);
                if(z) {
                    break;
                }
            }
        }
        this.U();
        if(z) {
            this.x = f0;
        }
        return z;
    }

    public int k(int v) {
        return this.l(v, 0);
    }

    public int l(int v, int v1) {
        int v2 = this.size();
        if(v1 < 0) {
            v1 = 0;
        }
        while(v1 < v2) {
            if(((f)this.f.get(v1)).getGroupId() == v) {
                return v1;
            }
            ++v1;
        }
        return -1;
    }

    private static int m(ArrayList arrayList0, int v) {
        for(int v1 = arrayList0.size() - 1; v1 >= 0; --v1) {
            if(((f)arrayList0.get(v1)).d() <= v) {
                return v1 + 1;
            }
        }
        return 0;
    }

    public int n(int v) {
        int v1 = this.size();
        for(int v2 = 0; v2 < v1; ++v2) {
            if(((f)this.f.get(v2)).getItemId() == v) {
                return v2;
            }
        }
        return -1;
    }

    f o(int v, KeyEvent keyEvent0) {
        ArrayList arrayList0 = this.v;
        arrayList0.clear();
        this.p(arrayList0, v, keyEvent0);
        if(arrayList0.isEmpty()) {
            return null;
        }
        int v1 = keyEvent0.getMetaState();
        KeyCharacterMap.KeyData keyCharacterMap$KeyData0 = new KeyCharacterMap.KeyData();
        keyEvent0.getKeyData(keyCharacterMap$KeyData0);
        int v2 = arrayList0.size();
        if(v2 == 1) {
            return (f)arrayList0.get(0);
        }
        boolean z = this.C();
        for(int v3 = 0; v3 < v2; ++v3) {
            f f0 = (f)arrayList0.get(v3);
            int v4 = z ? f0.getAlphabeticShortcut() : f0.getNumericShortcut();
            if(v4 == keyCharacterMap$KeyData0.meta[0] && (v1 & 2) == 0 || v4 == keyCharacterMap$KeyData0.meta[2] && (v1 & 2) != 0 || z && v4 == 8 && v == 67) {
                return f0;
            }
        }
        return null;
    }

    void p(List list0, int v, KeyEvent keyEvent0) {
        boolean z = this.C();
        int v1 = keyEvent0.getModifiers();
        KeyCharacterMap.KeyData keyCharacterMap$KeyData0 = new KeyCharacterMap.KeyData();
        if(!keyEvent0.getKeyData(keyCharacterMap$KeyData0) && v != 67) {
            return;
        }
        int v2 = this.f.size();
        for(int v3 = 0; v3 < v2; ++v3) {
            f f0 = (f)this.f.get(v3);
            if(f0.hasSubMenu()) {
                ((e)f0.getSubMenu()).p(list0, v, keyEvent0);
            }
            int v4 = z ? f0.getAlphabeticShortcut() : f0.getNumericShortcut();
            if((v1 & 0x1100F) == ((z ? f0.getAlphabeticModifiers() : f0.getNumericModifiers()) & 0x1100F) && v4 != 0 && ((v4 == keyCharacterMap$KeyData0.meta[0] || v4 == keyCharacterMap$KeyData0.meta[2] || z && v4 == 8 && v == 67) && f0.isEnabled())) {
                list0.add(f0);
            }
        }
    }

    @Override  // android.view.Menu
    public boolean performIdentifierAction(int v, int v1) {
        return this.H(this.findItem(v), v1);
    }

    @Override  // android.view.Menu
    public boolean performShortcut(int v, KeyEvent keyEvent0, int v1) {
        f f0 = this.o(v, keyEvent0);
        boolean z = f0 == null ? false : this.H(f0, v1);
        if((v1 & 2) != 0) {
            this.d(true);
        }
        return z;
    }

    public void q() {
        ArrayList arrayList0 = this.A();
        if(!this.k) {
            return;
        }
        boolean z = false;
        for(Object object0: this.w) {
            WeakReference weakReference0 = (WeakReference)object0;
            i i0 = (i)weakReference0.get();
            if(i0 == null) {
                this.w.remove(weakReference0);
            }
            else {
                z |= i0.c();
            }
        }
        if(z) {
            this.i.clear();
            this.j.clear();
            int v = arrayList0.size();
            for(int v1 = 0; v1 < v; ++v1) {
                f f0 = (f)arrayList0.get(v1);
                (f0.k() ? this.i : this.j).add(f0);
            }
        }
        else {
            this.i.clear();
            this.j.clear();
            this.j.addAll(this.A());
        }
        this.k = false;
    }

    public ArrayList r() {
        this.q();
        return this.i;
    }

    @Override  // android.view.Menu
    public void removeGroup(int v) {
        int v1 = this.k(v);
        if(v1 >= 0) {
            int v2 = this.f.size();
            for(int v3 = 0; v3 < v2 - v1 && ((f)this.f.get(v1)).getGroupId() == v; ++v3) {
                this.J(v1, false);
            }
            this.G(true);
        }
    }

    @Override  // android.view.Menu
    public void removeItem(int v) {
        this.J(this.n(v), true);
    }

    public Context s() {
        return this.a;
    }

    @Override  // android.view.Menu
    public void setGroupCheckable(int v, boolean z, boolean z1) {
        int v1 = this.f.size();
        for(int v2 = 0; v2 < v1; ++v2) {
            f f0 = (f)this.f.get(v2);
            if(f0.getGroupId() == v) {
                f0.s(z1);
                f0.setCheckable(z);
            }
        }
    }

    @Override  // android.view.Menu
    public void setGroupDividerEnabled(boolean z) {
        this.y = z;
    }

    @Override  // android.view.Menu
    public void setGroupEnabled(int v, boolean z) {
        int v1 = this.f.size();
        for(int v2 = 0; v2 < v1; ++v2) {
            f f0 = (f)this.f.get(v2);
            if(f0.getGroupId() == v) {
                f0.setEnabled(z);
            }
        }
    }

    @Override  // android.view.Menu
    public void setGroupVisible(int v, boolean z) {
        int v1 = this.f.size();
        boolean z1 = false;
        for(int v2 = 0; v2 < v1; ++v2) {
            f f0 = (f)this.f.get(v2);
            if(f0.getGroupId() == v && f0.x(z)) {
                z1 = true;
            }
        }
        if(z1) {
            this.G(true);
        }
    }

    @Override  // android.view.Menu
    public void setQwertyMode(boolean z) {
        this.c = z;
        this.G(false);
    }

    @Override  // android.view.Menu
    public int size() {
        return this.f.size();
    }

    public f t() {
        return this.x;
    }

    public CharSequence u() {
        return this.n;
    }

    public ArrayList v() {
        this.q();
        return this.j;
    }

    boolean w() {
        return this.t;
    }

    private static int x(int v) {
        int v1 = (0xFFFF0000 & v) >> 16;
        if(v1 >= 0) {
            int[] arr_v = e.A;
            if(v1 < arr_v.length) {
                return v & 0xFFFF | arr_v[v1] << 16;
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    Resources y() {
        return this.b;
    }

    public e z() {
        return this;
    }
}

