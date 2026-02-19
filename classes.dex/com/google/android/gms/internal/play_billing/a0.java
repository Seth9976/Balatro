package com.google.android.gms.internal.play_billing;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.d.a;
import com.android.billingclient.api.d;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;

public abstract class a0 {
    public static final int a;

    static {
        a0.a = Runtime.getRuntime().availableProcessors();
    }

    public static int a(Intent intent0, String s) {
        if(intent0 == null) {
            a0.i("ProxyBillingActivity", "Got null intent!");
            return 0;
        }
        return a0.k(intent0.getExtras(), "ProxyBillingActivity");
    }

    public static int b(Bundle bundle0, String s) {
        String s1;
        if(bundle0 == null) {
            s1 = "Unexpected null bundle received!";
        }
        else {
            Object object0 = bundle0.get("RESPONSE_CODE");
            if(object0 == null) {
                a0.h(s, "getResponseCodeFromBundle() got null response code, assuming OK");
                return 0;
            }
            if(object0 instanceof Integer) {
                return (int)(((Integer)object0));
            }
            s1 = "Unexpected type for bundle response code: " + object0.getClass().getName();
        }
        a0.i(s, s1);
        return 6;
    }

    public static Bundle c(boolean z, boolean z1, boolean z2, boolean z3, String s) {
        Bundle bundle0 = new Bundle();
        bundle0.putString("playBillingLibraryVersion", s);
        if(z && z2) {
            bundle0.putBoolean("enablePendingPurchases", true);
        }
        if(z1 && z3) {
            bundle0.putBoolean("enablePendingPurchaseForSubscriptions", true);
        }
        return bundle0;
    }

    public static d d(Intent intent0, String s) {
        if(intent0 == null) {
            a0.i("BillingHelper", "Got null intent!");
            a d$a0 = d.c();
            d$a0.c(6);
            d$a0.b("An internal error occurred.");
            return d$a0.a();
        }
        a d$a1 = d.c();
        d$a1.c(a0.b(intent0.getExtras(), s));
        d$a1.b(a0.e(intent0.getExtras(), s));
        return d$a1.a();
    }

    public static String e(Bundle bundle0, String s) {
        if(bundle0 == null) {
            a0.i(s, "Unexpected null bundle received!");
            return "";
        }
        Object object0 = bundle0.get("DEBUG_MESSAGE");
        if(object0 == null) {
            a0.h(s, "getDebugMessageFromBundle() got null response code, assuming OK");
            return "";
        }
        if(object0 instanceof String) {
            return (String)object0;
        }
        a0.i(s, "Unexpected type for debug message: " + object0.getClass().getName());
        return "";
    }

    public static String f(int v) {
        return com.google.android.gms.internal.play_billing.a.c(v).toString();
    }

    public static List g(Bundle bundle0) {
        ArrayList arrayList0 = bundle0.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
        ArrayList arrayList1 = bundle0.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
        List list0 = new ArrayList();
        if(arrayList0 != null && arrayList1 != null) {
            a0.h("BillingHelper", "Found purchase list of " + arrayList0.size() + " items");
            for(int v = 0; v < arrayList0.size() && v < arrayList1.size(); ++v) {
                Purchase purchase0 = a0.l(((String)arrayList0.get(v)), ((String)arrayList1.get(v)));
                if(purchase0 != null) {
                    list0.add(purchase0);
                }
            }
            return list0;
        }
        Purchase purchase1 = a0.l(bundle0.getString("INAPP_PURCHASE_DATA"), bundle0.getString("INAPP_DATA_SIGNATURE"));
        if(purchase1 == null) {
            a0.h("BillingHelper", "Couldn\'t find single purchase data as well.");
            return null;
        }
        list0.add(purchase1);
        return list0;
    }

    public static void h(String s, String s1) {
        if(Log.isLoggable(s, 2)) {
            if(!s1.isEmpty()) {
                for(int v = 40000; !s1.isEmpty() && v > 0; v -= v1) {
                    int v1 = Math.min(s1.length(), Math.min(4000, v));
                    Log.v(s, s1.substring(0, v1));
                    s1 = s1.substring(v1);
                }
                return;
            }
            Log.v(s, s1);
        }
    }

    public static void i(String s, String s1) {
        if(Log.isLoggable(s, 5)) {
            Log.w(s, s1);
        }
    }

    public static void j(String s, String s1, Throwable throwable0) {
        if(Log.isLoggable(s, 5)) {
            Log.w(s, s1, throwable0);
        }
    }

    private static int k(Bundle bundle0, String s) {
        if(bundle0 == null) {
            a0.i(s, "Unexpected null bundle received!");
            return 0;
        }
        return bundle0.getInt("IN_APP_MESSAGE_RESPONSE_CODE", 0);
    }

    private static Purchase l(String s, String s1) {
        if(s != null && s1 != null) {
            try {
                return new Purchase(s, s1);
            }
            catch(JSONException jSONException0) {
                a0.i("BillingHelper", "Got JSONException while parsing purchase data: " + jSONException0.toString());
                return null;
            }
        }
        a0.h("BillingHelper", "Received a null purchase data.");
        return null;
    }
}

