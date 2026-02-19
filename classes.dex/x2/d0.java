package x2;

import java.util.Objects;
import n2.d;
import org.json.JSONObject;

public class d0 {
    static class a {
        private boolean a;
        private boolean b;
        private static final k0 c;

        static {
            a.c = k0.f("d0");
        }

        a() {
            this.a = false;
            this.b = false;
        }

        public boolean a() {
            return this.a;
        }

        public boolean b() {
            return this.b;
        }

        @Override
        public boolean equals(Object object0) {
            if(this == object0) {
                return true;
            }
            if(object0 == null) {
                return false;
            }
            return this.getClass() == object0.getClass() ? this.a == ((a)object0).a && this.b == ((a)object0).b : false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(new Object[]{Boolean.valueOf(this.a), Boolean.valueOf(this.b)});
        }
    }

    private a a;
    private static final k0 b;

    static {
        d0.b = k0.f("d0");
    }

    private d0() {
        this.a = new a();
    }

    public static d0 a() {
        return new d0();
    }

    public static d0 b(JSONObject jSONObject0) {
        try {
            return (d0)new d().h(jSONObject0.toString(), d0.class);
        }
        catch(Throwable throwable0) {
            String s = p0.h(throwable0);
            d0.b.c(s);
            return new d0();
        }
    }

    public boolean c() {
        return this.a.b();
    }

    public boolean d() {
        return this.a.a();
    }

    public JSONObject e() {
        d d0 = new d();
        try {
            return new JSONObject(d0.q(this));
        }
        catch(Throwable throwable0) {
            String s = p0.h(throwable0);
            d0.b.c(s);
            return new JSONObject();
        }
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 == null) {
            return false;
        }
        return this.getClass() == object0.getClass() ? this.a.equals(((d0)object0).a) : false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(new Object[]{this.a});
    }
}

