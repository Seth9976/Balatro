package x2;

import java.io.IOException;
import java.util.HashMap;
import java.util.InvalidPropertiesFormatException;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

abstract class h extends l0 implements a {
    private static final k0 e;

    static {
        h.e = k0.f("h");
    }

    public h(String s, long v) {
        this.g("__TYPE__", s);
        this.g("__TIMESTAMP__", String.valueOf(v));
    }

    @Override  // x2.a
    public boolean a(i0 i00) {
        if(!((String)this.l().get("k")).equalsIgnoreCase("sdid") && i00.p() != null && i00.p().k.b()) {
            this.putAll(new m0().j(i00.p()));
        }
        return n0.g(i00, this.m(), this.l(), this.f(), this.c());
    }

    @Override  // x2.a
    public long f() {
        String s = (String)this.get("__TIMESTAMP__");
        return p0.V(s) ? -1L : Long.parseLong(s);
    }

    void i(Map map0) {
        if(map0 == null) {
            return;
        }
        this.putAll(map0);
    }

    public static h j(String s) {
        h h0;
        if(s == null) {
            throw new NullPointerException("api string cannot be null");
        }
        Map map0 = h.k(s);
        String s1 = (String)map0.get("__TYPE__");
        String s2 = (String)map0.get("__TIMESTAMP__");
        long v = p0.V(s2) ? -1L : Long.parseLong(s2);
        int v1 = p0.p(i0.t().n(), s2);
        if(v1 > 3) {
            map0.put("rc", String.valueOf(v1));
        }
        if("EVENT".equalsIgnoreCase(s1)) {
            h0 = new g(v);
        }
        else {
            if("SESSION_START".equalsIgnoreCase(s1)) {
                h0 = new f(v);
                h0.i(map0);
                return h0;
            }
            if("GDPR_CONSENT".equalsIgnoreCase(s1)) {
                h0 = new c(v);
                h0.i(map0);
                return h0;
            }
            if("GDPR_UNDER_13".equalsIgnoreCase(s1)) {
                h0 = new d(v);
            }
            else if("CUSTOM_USER_ID".equalsIgnoreCase(s1)) {
                h0 = new b(v);
            }
            else {
                throw new InvalidPropertiesFormatException(String.format("Unknown type = %s", s1));
            }
        }
        h0.i(map0);
        return h0;
    }

    private static Map k(String s) {
        try {
            JSONObject jSONObject0 = new JSONObject(s);
            Map map0 = new HashMap();
            Iterator iterator0 = jSONObject0.keys();
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                map0.put(((String)object0), ((String)jSONObject0.get(((String)object0))));
            }
            return map0;
        }
        catch(JSONException jSONException0) {
            throw new IOException(jSONException0);
        }
    }

    Map l() {
        Map map0 = new HashMap(this);
        ((HashMap)map0).remove("__TYPE__");
        ((HashMap)map0).remove("__TIMESTAMP__");
        return map0;
    }

    public String m() {
        return "https://sdk-api-v1.singular.net/api/v1" + this.d();
    }

    public boolean n() {
        try {
            String s = (String)this.get("e");
            if(s != null) {
                return new JSONObject(s).getBoolean("is_admon_revenue");
            }
        }
        catch(Throwable throwable0) {
            h.e.a("Not an admon event: " + throwable0.getMessage());
        }
        return false;
    }

    public String o() {
        return new JSONObject(this).toString();
    }
}

