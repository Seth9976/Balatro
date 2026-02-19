package b;

import android.content.Context;
import android.content.Intent;
import k3.d;
import k3.f;

public final class c extends a {
    public static final class b.c.a {
        private b.c.a() {
        }

        public b.c.a(d d0) {
        }
    }

    public static final b.c.a a;

    static {
        c.a = new b.c.a(null);
    }

    @Override  // b.a
    public Intent a(Context context0, Object object0) {
        return this.d(context0, ((Intent)object0));
    }

    @Override  // b.a
    public Object c(int v, Intent intent0) {
        return this.e(v, intent0);
    }

    public Intent d(Context context0, Intent intent0) {
        f.e(context0, "context");
        f.e(intent0, "input");
        return intent0;
    }

    public androidx.activity.result.a e(int v, Intent intent0) {
        return new androidx.activity.result.a(v, intent0);
    }
}

