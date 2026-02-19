package w2;

import android.content.Context;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import x2.h0;
import x2.i0;
import x2.k0;
import x2.p0;

public abstract class a {
    private static final k0 a;
    private static i0 b;
    private static boolean c;
    private static Context d;
    private static Boolean e;

    static {
        a.a = k0.f("a");
        a.c = false;
        a.d = null;
        a.e = Boolean.FALSE;
    }

    public static boolean a(String s, String s1, double f) {
        return a.f(s, new Object[]{"pcc", s1, "r", f, "is_revenue_event", Boolean.TRUE});
    }

    public static boolean b(String s, String s1, double f, Object object0) {
        return a.c(s, s1, f, object0, null);
    }

    public static boolean c(String s, String s1, double f, Object object0, Map map0) {
        if(object0 != null && object0.getClass().getName().equals("com.android.billingclient.api.Purchase")) {
            try {
                Class class0 = object0.getClass();
                Object object1 = a.h(object0);
                String s2 = (String)class0.getDeclaredMethod("getOriginalJson").invoke(object0);
                String s3 = (String)class0.getDeclaredMethod("getSignature").invoke(object0);
                if(map0 != null) {
                    try {
                        JSONObject jSONObject0 = new JSONObject(map0);
                        jSONObject0.put("pcc", s1);
                        jSONObject0.put("r", f);
                        jSONObject0.put("is_revenue_event", true);
                        jSONObject0.put("receipt", s2);
                        jSONObject0.put("receipt_signature", s3);
                        jSONObject0.put("pk", object1);
                        return a.g(s, jSONObject0);
                    }
                    catch(JSONException jSONException0) {
                        String s4 = p0.h(jSONException0);
                        a.a.c(s4);
                    }
                }
                return a.f(s, new Object[]{"pcc", s1, "r", f, "pk", object1, "receipt", s2, "receipt_signature", s3, "is_revenue_event", Boolean.TRUE});
            }
            catch(Throwable throwable0) {
                a.a.d("customRevenue has encountered an unexpected exception. Please verify that the \'purchase\' object is of type \'com.android.billingclient.api.Purchase\'", throwable0);
            }
        }
        return a.d(s, s1, f, map0);
    }

    public static boolean d(String s, String s1, double f, Map map0) {
        if(map0 != null) {
            try {
                JSONObject jSONObject0 = new JSONObject(map0);
                jSONObject0.put("pcc", s1);
                jSONObject0.put("r", f);
                jSONObject0.put("is_revenue_event", true);
                return a.g(s, jSONObject0);
            }
            catch(JSONException jSONException0) {
                String s2 = p0.h(jSONException0);
                a.a.c(s2);
            }
        }
        return a.a(s, s1, f);
    }

    public static boolean e(String s) {
        try {
            if(!a.j()) {
                return false;
            }
            if(p0.V(s)) {
                a.a.c("Event name can not be null or empty");
                return false;
            }
            return a.b.L(s);
        }
        catch(RuntimeException runtimeException0) {
            a.k(runtimeException0);
            String s1 = p0.h(runtimeException0);
            a.a.c(s1);
            return false;
        }
    }

    public static boolean f(String s, Object[] arr_object) {
        try {
            if(!a.j()) {
                return false;
            }
            if(p0.V(s)) {
                a.a.c("Event name can not be null or empty");
                return false;
            }
            if(arr_object.length % 2 != 0) {
                a.a.c("Extra arguments must be in even numbers.");
                return false;
            }
            try {
                JSONObject jSONObject0 = new JSONObject();
                for(int v = 0; v < arr_object.length; v += 2) {
                    jSONObject0.put(((String)arr_object[v]), arr_object[v + 1]);
                }
                return a.g(s, jSONObject0);
            }
            catch(JSONException jSONException0) {
                a.a.d("error in serializing extra args", jSONException0);
                return false;
            }
        }
        catch(RuntimeException runtimeException0) {
            a.k(runtimeException0);
            a.a.d("Exception", runtimeException0);
            return false;
        }
    }

    public static boolean g(String s, JSONObject jSONObject0) {
        try {
            if(!a.j()) {
                return false;
            }
            if(p0.V(s)) {
                a.a.c("Event name can not be null or empty");
                return false;
            }
            return a.b.M(s, (jSONObject0 == null ? null : jSONObject0.toString()));
        }
        catch(RuntimeException runtimeException0) {
            a.k(runtimeException0);
            a.a.d("Exception", runtimeException0);
            return false;
        }
    }

    private static Object h(Object object0) {
        Method method0 = p0.x(object0, "getProducts", new Class[0]);
        if(method0 != null) {
            return new JSONArray(method0.invoke(object0).toString());
        }
        Method method1 = p0.x(object0, "getSku", new Class[0]);
        if(method1 != null) {
            return (String)method1.invoke(object0);
        }
        Method method2 = p0.x(object0, "getSkus", new Class[0]);
        return method2 != null ? new JSONArray(method2.invoke(object0).toString()) : null;
    }

    public static boolean i(Context context0, b b0) {
        boolean z = false;
        if(context0 != null && b0 != null) {
            try {
                if(a.b != null) {
                    z = true;
                }
                a.c = z;
                i0 i00 = i0.u(context0, b0);
                a.b = i00;
                if(a.c) {
                    i00.Y();
                }
                a.d = context0.getApplicationContext();
                a.e = b0.s;
                return a.j();
            }
            catch(IOException iOException0) {
                a.a.a("Failed to init() Singular SDK");
                String s = p0.h(iOException0);
                a.a.c(s);
                a.b = null;
                return a.j();
            }
            catch(RuntimeException runtimeException0) {
                a.k(runtimeException0);
                String s1 = p0.h(runtimeException0);
                a.a.c(s1);
                return a.j();
            }
        }
        return false;
    }

    private static boolean j() {
        if(a.b == null) {
            a.a.c("Singular not initialized. You must call Singular.init() ");
            return false;
        }
        return true;
    }

    private static void k(Throwable throwable0) {
        try {
            h0.e(a.d, a.e).h(throwable0);
        }
        catch(RuntimeException unused_ex) {
        }
    }

    public static boolean l(String s, double f, Object object0) {
        return a.b("__iap__", s, f, object0);
    }
}

