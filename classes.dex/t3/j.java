package t3;

import b3.c;
import d3.e;
import r3.v;

final class j extends v implements r3.j {
    private final Throwable f;
    private final String g;

    public j(Throwable throwable0, String s) {
        this.f = throwable0;
        this.g = s;
    }

    @Override  // r3.c
    public void a(e e0, Runnable runnable0) {
        this.f(e0, runnable0);
    }

    @Override  // r3.c
    public boolean b(e e0) {
        this.g();
        throw new c();
    }

    @Override  // r3.v
    public v d() {
        return this;
    }

    public Void f(e e0, Runnable runnable0) {
        this.g();
        throw new c();
    }

    private final Void g() {
        if(this.f != null) {
            throw new IllegalStateException("Module with the Main dispatcher had failed to initialize" + (this.g == null || ". " + this.g == null ? "" : ". " + this.g), this.f);
        }
        i.d();
        throw new c();
    }

    @Override  // r3.c
    public String toString() {
        return "Dispatchers.Main[missing" + (this.f == null ? "" : ", cause=" + this.f) + ']';
    }
}

