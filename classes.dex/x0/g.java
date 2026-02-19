package x0;

import android.os.Bundle;
import d1.a.d;
import g1.o;

public final class g implements d {
    private final String e;
    private final boolean f;
    private final String g;
    public static final g h;

    static {
        g.h = new g(new f());
    }

    public g(f f0) {
        this.e = null;
        this.f = f0.a.booleanValue();
        this.g = f0.b;
    }

    public final Bundle a() {
        Bundle bundle0 = new Bundle();
        bundle0.putString("consumer_package", null);
        bundle0.putBoolean("force_save_dialog", this.f);
        bundle0.putString("log_session_id", this.g);
        return bundle0;
    }

    static String b(g g0) [...] // Inlined contents

    @Override
    public final boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        return object0 instanceof g ? o.a(null, null) && this.f == ((g)object0).f && o.a(this.g, ((g)object0).g) : false;
    }

    @Override
    public final int hashCode() {
        return o.b(new Object[]{null, Boolean.valueOf(this.f), this.g});
    }
}

