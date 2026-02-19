package x2;

import org.json.JSONException;
import org.json.JSONObject;

public class b extends h {
    public class a implements x2.a.a {
        final b a;

        @Override  // x2.a$a
        public boolean a(i0 i00, int v, String s) {
            if(v != 200) {
                return false;
            }
            try {
                return !new JSONObject(s).optString("status", "").equalsIgnoreCase("ok") ? false : true;
            }
            catch(JSONException jSONException0) {
                b.f.d("error in handle()", jSONException0);
                return false;
            }
        }
    }

    private static final k0 f;

    static {
        b.f = k0.f("b");
    }

    public b(long v) {
        super("CUSTOM_USER_ID", v);
    }

    @Override  // x2.h
    public boolean a(i0 i00) {
        return super.a(i00);
    }

    @Override  // x2.a
    public x2.a.a c() {
        return new a(this);
    }

    @Override  // x2.a
    public String d() {
        return "/set_device_for_custom_id";
    }

    @Override  // x2.h
    public long f() {
        return super.f();
    }

    @Override  // x2.h
    public String m() {
        return super.m();
    }

    @Override  // x2.h
    public boolean n() {
        return super.n();
    }

    @Override  // x2.h
    public String o() {
        return super.o();
    }
}

