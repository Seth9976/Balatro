package y;

import android.content.Context;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class b {
    public interface a {
        void a(b arg1, Object arg2);
    }

    private int a;
    private a b;
    private Context c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;

    public b(Context context0) {
        this.d = false;
        this.e = false;
        this.f = true;
        this.g = false;
        this.h = false;
        this.c = context0.getApplicationContext();
    }

    public void a() {
        this.e = true;
    }

    public boolean b() {
        return this.l();
    }

    public void c() {
        this.h = false;
    }

    public String d(Object object0) {
        String s;
        StringBuilder stringBuilder0 = new StringBuilder(0x40);
        if(object0 == null) {
            s = "null";
        }
        else {
            Class class0 = object0.getClass();
            stringBuilder0.append(class0.getSimpleName());
            stringBuilder0.append("{");
            stringBuilder0.append(Integer.toHexString(System.identityHashCode(class0)));
            s = "}";
        }
        stringBuilder0.append(s);
        return stringBuilder0.toString();
    }

    public void e() {
    }

    public void f(Object object0) {
        a b$a0 = this.b;
        if(b$a0 != null) {
            b$a0.a(this, object0);
        }
    }

    public void g(String s, FileDescriptor fileDescriptor0, PrintWriter printWriter0, String[] arr_s) {
        printWriter0.print(s);
        printWriter0.print("mId=");
        printWriter0.print(this.a);
        printWriter0.print(" mListener=");
        printWriter0.println(this.b);
        if(this.d || this.g || this.h) {
            printWriter0.print(s);
            printWriter0.print("mStarted=");
            printWriter0.print(this.d);
            printWriter0.print(" mContentChanged=");
            printWriter0.print(this.g);
            printWriter0.print(" mProcessingChange=");
            printWriter0.println(this.h);
        }
        if(this.e || this.f) {
            printWriter0.print(s);
            printWriter0.print("mAbandoned=");
            printWriter0.print(this.e);
            printWriter0.print(" mReset=");
            printWriter0.println(this.f);
        }
    }

    public void h() {
        this.n();
    }

    public boolean i() {
        return this.e;
    }

    public boolean j() {
        return this.d;
    }

    protected void k() {
    }

    protected abstract boolean l();

    public void m() {
        if(this.d) {
            this.h();
            return;
        }
        this.g = true;
    }

    protected void n() {
    }

    protected void o() {
    }

    protected abstract void p();

    protected void q() {
    }

    public void r(int v, a b$a0) {
        if(this.b != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.b = b$a0;
        this.a = v;
    }

    public void s() {
        this.f = true;
        this.d = false;
        this.e = false;
        this.g = false;
        this.h = false;
    }

    public void t() {
        if(this.h) {
            this.m();
        }
    }

    @Override
    public String toString() {
        Class class0 = this.getClass();
        return class0.getSimpleName() + "{" + Integer.toHexString(System.identityHashCode(class0)) + " id=" + this.a + "}";
    }

    public final void u() {
        this.d = true;
        this.f = false;
        this.e = false;
        this.p();
    }

    public void v() {
        this.d = false;
    }

    public void w(a b$a0) {
        a b$a1 = this.b;
        if(b$a1 == null) {
            throw new IllegalStateException("No listener register");
        }
        if(b$a1 != b$a0) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        this.b = null;
    }
}

