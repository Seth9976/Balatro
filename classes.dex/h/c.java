package h;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff.Mode;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.widget.l0;
import androidx.appcompat.widget.u;
import androidx.core.view.k;
import c.i;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import jeb.synthetic.TWR;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class c extends MenuInflater {
    static class a implements MenuItem.OnMenuItemClickListener {
        private Object a;
        private Method b;
        private static final Class[] c;

        static {
            a.c = new Class[]{MenuItem.class};
        }

        public a(Object object0, String s) {
            this.a = object0;
            Class class0 = object0.getClass();
            try {
                this.b = class0.getMethod(s, a.c);
            }
            catch(Exception exception0) {
                InflateException inflateException0 = new InflateException("Couldn\'t resolve menu item onClick handler " + s + " in class " + class0.getName());
                inflateException0.initCause(exception0);
                throw inflateException0;
            }
        }

        @Override  // android.view.MenuItem$OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem0) {
            try {
                if(this.b.getReturnType() == Boolean.TYPE) {
                    return ((Boolean)this.b.invoke(this.a, menuItem0)).booleanValue();
                }
                this.b.invoke(this.a, menuItem0);
                return true;
            }
            catch(Exception exception0) {
                throw new RuntimeException(exception0);
            }
        }
    }

    class b {
        private CharSequence A;
        private CharSequence B;
        private ColorStateList C;
        private PorterDuff.Mode D;
        final c E;
        private Menu a;
        private int b;
        private int c;
        private int d;
        private int e;
        private boolean f;
        private boolean g;
        private boolean h;
        private int i;
        private int j;
        private CharSequence k;
        private CharSequence l;
        private int m;
        private char n;
        private int o;
        private char p;
        private int q;
        private int r;
        private boolean s;
        private boolean t;
        private boolean u;
        private int v;
        private int w;
        private String x;
        private String y;
        private String z;

        public b(Menu menu0) {
            this.C = null;
            this.D = null;
            this.a = menu0;
            this.h();
        }

        public void a() {
            this.h = true;
            this.i(this.a.add(this.b, this.i, this.j, this.k));
        }

        public SubMenu b() {
            this.h = true;
            SubMenu subMenu0 = this.a.addSubMenu(this.b, this.i, this.j, this.k);
            this.i(subMenu0.getItem());
            return subMenu0;
        }

        private char c(String s) {
            return s == null ? '\u0000' : s.charAt(0);
        }

        public boolean d() {
            return this.h;
        }

        private Object e(String s, Class[] arr_class, Object[] arr_object) {
            try {
                Constructor constructor0 = Class.forName(s, false, c.this.c.getClassLoader()).getConstructor(arr_class);
                constructor0.setAccessible(true);
                return constructor0.newInstance(arr_object);
            }
            catch(Exception exception0) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + s, exception0);
                return null;
            }
        }

        public void f(AttributeSet attributeSet0) {
            TypedArray typedArray0 = c.this.c.obtainStyledAttributes(attributeSet0, i.F0);
            this.b = typedArray0.getResourceId(i.H0, 0);
            this.c = typedArray0.getInt(i.J0, 0);
            this.d = typedArray0.getInt(i.K0, 0);
            this.e = typedArray0.getInt(i.L0, 0);
            this.f = typedArray0.getBoolean(i.I0, true);
            this.g = typedArray0.getBoolean(i.G0, true);
            typedArray0.recycle();
        }

        public void g(AttributeSet attributeSet0) {
            l0 l00 = l0.r(c.this.c, attributeSet0, i.M0);
            this.i = l00.l(i.P0, 0);
            this.j = l00.i(i.S0, this.c) & 0xFFFF0000 | l00.i(i.T0, this.d) & 0xFFFF;
            this.k = l00.n(i.U0);
            this.l = l00.n(i.V0);
            this.m = l00.l(i.N0, 0);
            this.n = this.c(l00.m(i.W0));
            this.o = l00.i(i.d1, 0x1000);
            this.p = this.c(l00.m(i.X0));
            this.q = l00.i(i.h1, 0x1000);
            boolean z = l00.p(i.Y0) ? l00.a(i.Y0, false) : this.e;
            this.r = z;
            this.s = l00.a(i.Q0, false);
            this.t = l00.a(i.R0, this.f);
            this.u = l00.a(i.O0, this.g);
            this.v = l00.i(i.i1, -1);
            this.z = l00.m(i.Z0);
            this.w = l00.l(i.a1, 0);
            this.x = l00.m(i.c1);
            String s = l00.m(i.b1);
            this.y = s;
            if(s != null && this.w == 0 && this.x == null) {
                d.a(this.e(s, c.f, c.this.b));
            }
            else if(s != null) {
                Log.w("SupportMenuInflater", "Ignoring attribute \'actionProviderClass\'. Action view already specified.");
            }
            this.A = l00.n(i.e1);
            this.B = l00.n(i.j1);
            this.D = l00.p(i.g1) ? u.d(l00.i(i.g1, -1), this.D) : null;
            this.C = l00.p(i.f1) ? l00.c(i.f1) : null;
            l00.t();
            this.h = false;
        }

        public void h() {
            this.b = 0;
            this.c = 0;
            this.d = 0;
            this.e = 0;
            this.f = true;
            this.g = true;
        }

        private void i(MenuItem menuItem0) {
            boolean z = false;
            menuItem0.setChecked(this.s).setVisible(this.t).setEnabled(this.u).setCheckable(this.r >= 1).setTitleCondensed(this.l).setIcon(this.m);
            int v = this.v;
            if(v >= 0) {
                menuItem0.setShowAsAction(v);
            }
            if(this.z != null) {
                if(c.this.c.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem0.setOnMenuItemClickListener(new a(c.this.b(), this.z));
            }
            if(this.r >= 2 && menuItem0 instanceof f) {
                ((f)menuItem0).s(true);
            }
            String s = this.x;
            if(s != null) {
                menuItem0.setActionView(((View)this.e(s, c.e, c.this.a)));
                z = true;
            }
            int v1 = this.w;
            if(v1 > 0) {
                if(z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute \'itemActionViewLayout\'. Action view already specified.");
                }
                else {
                    menuItem0.setActionView(v1);
                }
            }
            k.b(menuItem0, this.A);
            k.f(menuItem0, this.B);
            k.a(menuItem0, this.n, this.o);
            k.e(menuItem0, this.p, this.q);
            PorterDuff.Mode porterDuff$Mode0 = this.D;
            if(porterDuff$Mode0 != null) {
                k.d(menuItem0, porterDuff$Mode0);
            }
            ColorStateList colorStateList0 = this.C;
            if(colorStateList0 != null) {
                k.c(menuItem0, colorStateList0);
            }
        }
    }

    final Object[] a;
    final Object[] b;
    Context c;
    private Object d;
    static final Class[] e;
    static final Class[] f;

    static {
        Class[] arr_class = {Context.class};
        c.e = arr_class;
        c.f = arr_class;
    }

    public c(Context context0) {
        super(context0);
        this.c = context0;
        Object[] arr_object = {context0};
        this.a = arr_object;
        this.b = arr_object;
    }

    private Object a(Object object0) {
        if(object0 instanceof Activity) {
            return object0;
        }
        return object0 instanceof ContextWrapper ? this.a(((ContextWrapper)object0).getBaseContext()) : object0;
    }

    Object b() {
        if(this.d == null) {
            this.d = this.a(this.c);
        }
        return this.d;
    }

    private void c(XmlPullParser xmlPullParser0, AttributeSet attributeSet0, Menu menu0) {
        b c$b0 = new b(this, menu0);
        int v = xmlPullParser0.getEventType();
        do {
            if(v == 2) {
                String s = xmlPullParser0.getName();
                if(!s.equals("menu")) {
                    throw new RuntimeException("Expecting menu, got " + s);
                }
                v = xmlPullParser0.next();
                break;
            }
            v = xmlPullParser0.next();
        }
        while(v != 1);
        boolean z = false;
        String s1 = null;
        boolean z1 = false;
        while(!z1) {
            switch(v) {
                case 1: {
                    throw new RuntimeException("Unexpected end of document");
                }
                case 2: {
                    if(!z) {
                        String s2 = xmlPullParser0.getName();
                        if(s2.equals("group")) {
                            c$b0.f(attributeSet0);
                        }
                        else if(s2.equals("item")) {
                            c$b0.g(attributeSet0);
                        }
                        else if(s2.equals("menu")) {
                            this.c(xmlPullParser0, attributeSet0, c$b0.b());
                        }
                        else {
                            s1 = s2;
                            z = true;
                        }
                    }
                    break;
                }
                case 3: {
                    String s3 = xmlPullParser0.getName();
                    if(z && s3.equals(s1)) {
                        z = false;
                        s1 = null;
                    }
                    else if(s3.equals("group")) {
                        c$b0.h();
                    }
                    else if(!s3.equals("item")) {
                        if(s3.equals("menu")) {
                            z1 = true;
                        }
                    }
                    else if(!c$b0.d()) {
                        c$b0.a();
                    }
                }
            }
            v = xmlPullParser0.next();
        }
    }

    @Override  // android.view.MenuInflater
    public void inflate(int v, Menu menu0) {
        XmlResourceParser xmlResourceParser0;
        if(!(menu0 instanceof m.a)) {
            super.inflate(v, menu0);
            return;
        }
        try {
            try {
                xmlResourceParser0 = null;
                xmlResourceParser0 = this.c.getResources().getLayout(v);
                this.c(xmlResourceParser0, Xml.asAttributeSet(xmlResourceParser0), menu0);
            }
            catch(XmlPullParserException xmlPullParserException0) {
                throw new InflateException("Error inflating menu XML", xmlPullParserException0);
            }
            catch(IOException iOException0) {
                throw new InflateException("Error inflating menu XML", iOException0);
            }
        }
        catch(Throwable throwable0) {
            TWR.safeClose$NT(xmlResourceParser0, throwable0);
            throw throwable0;
        }
        if(xmlResourceParser0 != null) {
            xmlResourceParser0.close();
        }
    }
}

