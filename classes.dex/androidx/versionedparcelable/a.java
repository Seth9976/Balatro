package androidx.versionedparcelable;

import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class a {
    protected final k.a a;
    protected final k.a b;
    protected final k.a c;

    public a(k.a a0, k.a a1, k.a a2) {
        this.a = a0;
        this.b = a1;
        this.c = a2;
    }

    protected abstract void A(byte[] arg1);

    public void B(byte[] arr_b, int v) {
        this.w(v);
        this.A(arr_b);
    }

    protected abstract void C(CharSequence arg1);

    public void D(CharSequence charSequence0, int v) {
        this.w(v);
        this.C(charSequence0);
    }

    protected abstract void E(int arg1);

    public void F(int v, int v1) {
        this.w(v1);
        this.E(v);
    }

    protected abstract void G(Parcelable arg1);

    public void H(Parcelable parcelable0, int v) {
        this.w(v);
        this.G(parcelable0);
    }

    protected abstract void I(String arg1);

    public void J(String s, int v) {
        this.w(v);
        this.I(s);
    }

    protected void K(c0.a a0, a a1) {
        try {
            this.e(a0.getClass()).invoke(null, a0, a1);
        }
        catch(IllegalAccessException illegalAccessException0) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", illegalAccessException0);
        }
        catch(InvocationTargetException invocationTargetException0) {
            throw invocationTargetException0.getCause() instanceof RuntimeException ? ((RuntimeException)invocationTargetException0.getCause()) : new RuntimeException("VersionedParcel encountered InvocationTargetException", invocationTargetException0);
        }
        catch(NoSuchMethodException noSuchMethodException0) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", noSuchMethodException0);
        }
        catch(ClassNotFoundException classNotFoundException0) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", classNotFoundException0);
        }
    }

    protected void L(c0.a a0) {
        if(a0 == null) {
            this.I(null);
            return;
        }
        this.N(a0);
        a a1 = this.b();
        this.K(a0, a1);
        a1.a();
    }

    public void M(c0.a a0, int v) {
        this.w(v);
        this.L(a0);
    }

    private void N(c0.a a0) {
        Class class0;
        try {
            class0 = this.c(a0.getClass());
        }
        catch(ClassNotFoundException classNotFoundException0) {
            throw new RuntimeException(a0.getClass().getSimpleName() + " does not have a Parcelizer", classNotFoundException0);
        }
        this.I(class0.getName());
    }

    protected abstract void a();

    protected abstract a b();

    private Class c(Class class0) {
        Class class1 = (Class)this.c.get(class0.getName());
        if(class1 == null) {
            class1 = Class.forName(String.format("%s.%sParcelizer", class0.getPackage().getName(), class0.getSimpleName()), false, class0.getClassLoader());
            this.c.put(class0.getName(), class1);
        }
        return class1;
    }

    private Method d(String s) {
        Method method0 = (Method)this.a.get(s);
        if(method0 == null) {
            method0 = Class.forName(s, true, a.class.getClassLoader()).getDeclaredMethod("read", a.class);
            this.a.put(s, method0);
        }
        return method0;
    }

    private Method e(Class class0) {
        Method method0 = (Method)this.b.get(class0.getName());
        if(method0 == null) {
            method0 = this.c(class0).getDeclaredMethod("write", class0, a.class);
            this.b.put(class0.getName(), method0);
        }
        return method0;
    }

    public boolean f() [...] // Inlined contents

    protected abstract boolean g();

    public boolean h(boolean z, int v) {
        return this.m(v) ? this.g() : z;
    }

    protected abstract byte[] i();

    public byte[] j(byte[] arr_b, int v) {
        return this.m(v) ? this.i() : arr_b;
    }

    protected abstract CharSequence k();

    public CharSequence l(CharSequence charSequence0, int v) {
        return this.m(v) ? this.k() : charSequence0;
    }

    protected abstract boolean m(int arg1);

    protected c0.a n(String s, a a0) {
        try {
            return (c0.a)this.d(s).invoke(null, a0);
        }
        catch(IllegalAccessException illegalAccessException0) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", illegalAccessException0);
        }
        catch(InvocationTargetException invocationTargetException0) {
            throw invocationTargetException0.getCause() instanceof RuntimeException ? ((RuntimeException)invocationTargetException0.getCause()) : new RuntimeException("VersionedParcel encountered InvocationTargetException", invocationTargetException0);
        }
        catch(NoSuchMethodException noSuchMethodException0) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", noSuchMethodException0);
        }
        catch(ClassNotFoundException classNotFoundException0) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", classNotFoundException0);
        }
    }

    protected abstract int o();

    public int p(int v, int v1) {
        return this.m(v1) ? this.o() : v;
    }

    protected abstract Parcelable q();

    public Parcelable r(Parcelable parcelable0, int v) {
        return this.m(v) ? this.q() : parcelable0;
    }

    protected abstract String s();

    public String t(String s, int v) {
        return this.m(v) ? this.s() : s;
    }

    protected c0.a u() {
        String s = this.s();
        return s == null ? null : this.n(s, this.b());
    }

    public c0.a v(c0.a a0, int v) {
        return this.m(v) ? this.u() : a0;
    }

    protected abstract void w(int arg1);

    public void x(boolean z, boolean z1) {
    }

    protected abstract void y(boolean arg1);

    public void z(boolean z, int v) {
        this.w(v);
        this.y(z);
    }
}

