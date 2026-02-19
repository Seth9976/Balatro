package g1;

import android.os.Bundle;
import d1.a.d;

public class w implements d {
    public static class a {
        private String a;

        a(y y0) {
        }

        public w a() {
            return new w(this.a, null);
        }
    }

    private final String e;
    public static final w f;

    static {
        w.f = w.a().a();
    }

    w(String s, z z0) {
        this.e = s;
    }

    public static a a() {
        return new a(null);
    }

    public final Bundle b() {
        Bundle bundle0 = new Bundle();
        String s = this.e;
        if(s != null) {
            bundle0.putString("api", s);
        }
        return bundle0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        return object0 instanceof w ? o.a(this.e, ((w)object0).e) : false;
    }

    @Override
    public final int hashCode() {
        return o.b(new Object[]{this.e});
    }
}

