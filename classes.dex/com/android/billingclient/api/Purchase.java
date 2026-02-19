package com.android.billingclient.api;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class Purchase {
    private final String a;
    private final String b;
    private final JSONObject c;

    public Purchase(String s, String s1) {
        this.a = s;
        this.b = s1;
        this.c = new JSONObject(s);
    }

    public String a() {
        return this.a;
    }

    public List b() {
        return this.f();
    }

    public int c() {
        return this.c.optInt("purchaseState", 1) == 4 ? 2 : 1;
    }

    public String d() {
        String s = this.c.optString("purchaseToken");
        return this.c.optString("token", s);
    }

    public String e() {
        return this.b;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof Purchase)) {
            return false;
        }
        String s = ((Purchase)object0).a();
        if(TextUtils.equals(this.a, s)) {
            String s1 = ((Purchase)object0).e();
            return TextUtils.equals(this.b, s1);
        }
        return false;
    }

    private final ArrayList f() {
        ArrayList arrayList0 = new ArrayList();
        if(this.c.has("productIds")) {
            JSONArray jSONArray0 = this.c.optJSONArray("productIds");
            if(jSONArray0 != null) {
                for(int v = 0; v < jSONArray0.length(); ++v) {
                    arrayList0.add(jSONArray0.optString(v));
                }
                return arrayList0;
            }
        }
        else if(this.c.has("productId")) {
            arrayList0.add(this.c.optString("productId"));
        }
        return arrayList0;
    }

    @Override
    public int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public String toString() {
        return "Purchase. Json: " + this.a;
    }
}

