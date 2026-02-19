package g1;

import android.util.Log;

public final class j {
    private final String a;
    private final String b;

    public j(String s) {
        this(s, null);
    }

    public j(String s, String s1) {
        q.j(s, "log tag cannot be null");
        Object[] arr_object = new Object[2];
        boolean z = false;
        arr_object[0] = s;
        arr_object[1] = 23;
        if(s.length() <= 23) {
            z = true;
        }
        q.c(z, "tag \"%s\" is longer than the %d character maximum", arr_object);
        this.a = s;
        if(s1 == null || s1.length() <= 0) {
            s1 = null;
        }
        this.b = s1;
    }

    public boolean a(int v) {
        return Log.isLoggable(this.a, v);
    }

    public void b(String s, String s1) {
        if(this.a(3)) {
            Log.d(s, this.j(s1));
        }
    }

    public void c(String s, String s1, Throwable throwable0) {
        if(this.a(3)) {
            Log.d(s, this.j(s1), throwable0);
        }
    }

    public void d(String s, String s1) {
        if(this.a(6)) {
            Log.e(s, this.j(s1));
        }
    }

    public void e(String s, String s1, Throwable throwable0) {
        if(this.a(6)) {
            Log.e(s, this.j(s1), throwable0);
        }
    }

    public void f(String s, String s1, Throwable throwable0) {
        if(this.a(4)) {
            Log.i(s, this.j(s1), throwable0);
        }
    }

    public void g(String s, String s1) {
        if(this.a(2)) {
            Log.v(s, this.j(s1));
        }
    }

    public void h(String s, String s1) {
        if(this.a(5)) {
            Log.w(s, this.j(s1));
        }
    }

    public void i(String s, String s1, Throwable throwable0) {
        if(this.a(5)) {
            Log.w(s, this.j(s1), throwable0);
        }
    }

    private final String j(String s) {
        return this.b == null ? s : this.b + s;
    }
}

