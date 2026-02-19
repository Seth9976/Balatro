package g1;

import android.util.Log;

public abstract class y0 {
    private Object a;
    private boolean b;
    final d c;

    public y0(d d0, Object object0) {
        this.c = d0;
        super();
        this.a = object0;
        this.b = false;
    }

    protected abstract void a(Object arg1);

    protected abstract void b();

    public final void c() {
        Object object0;
        synchronized(this) {
            object0 = this.a;
            if(this.b) {
                Log.w("GmsClient", "Callback proxy " + this.toString() + " being reused. This is not safe.");
            }
        }
        if(object0 != null) {
            this.a(object0);
        }
        synchronized(this) {
            this.b = true;
        }
        this.e();
    }

    public final void d() {
        synchronized(this) {
            this.a = null;
        }
    }

    public final void e() {
        this.d();
        synchronized(this.c.r) {
            this.c.r.remove(this);
        }
    }
}

