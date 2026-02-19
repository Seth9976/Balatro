package m1;

import android.content.Context;

public class d {
    private c a;
    private static final d b;

    static {
        d.b = new d();
    }

    public d() {
        this.a = null;
    }

    public static c a(Context context0) {
        return d.b.b(context0);
    }

    public final c b(Context context0) {
        synchronized(this) {
            if(this.a == null) {
                if(context0.getApplicationContext() != null) {
                    context0 = context0.getApplicationContext();
                }
                this.a = new c(context0);
            }
            return this.a;
        }
    }
}

