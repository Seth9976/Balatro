package com.android.billingclient.api;

import android.text.TextUtils;
import com.google.android.gms.internal.play_billing.j;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class f {
    public static final class a {
        private final int a;
        private final int b;

        a(JSONObject jSONObject0) {
            this.a = jSONObject0.getInt("commitmentPaymentsCount");
            this.b = jSONObject0.optInt("subsequentCommitmentPaymentsCount");
        }
    }

    public static final class b {
        private final String a;
        private final long b;
        private final String c;
        private final String d;
        private final String e;
        private final String f;
        private final j g;
        private final Long h;
        private final v i;
        private final z j;
        private final w k;
        private final x l;
        private final y m;

        b(JSONObject jSONObject0) {
            this.a = jSONObject0.optString("formattedPrice");
            this.b = jSONObject0.optLong("priceAmountMicros");
            this.c = jSONObject0.optString("priceCurrencyCode");
            String s = jSONObject0.optString("offerIdToken");
            y y0 = null;
            if(s.isEmpty()) {
                s = null;
            }
            this.d = s;
            String s1 = jSONObject0.optString("offerId");
            if(s1.isEmpty()) {
                s1 = null;
            }
            this.e = s1;
            String s2 = jSONObject0.optString("purchaseOptionId");
            if(s2.isEmpty()) {
                s2 = null;
            }
            this.f = s2;
            jSONObject0.optInt("offerType");
            JSONArray jSONArray0 = jSONObject0.optJSONArray("offerTags");
            ArrayList arrayList0 = new ArrayList();
            if(jSONArray0 != null) {
                for(int v = 0; v < jSONArray0.length(); ++v) {
                    arrayList0.add(jSONArray0.getString(v));
                }
            }
            this.g = j.u(arrayList0);
            this.h = jSONObject0.has("fullPriceMicros") ? jSONObject0.optLong("fullPriceMicros") : null;
            JSONObject jSONObject1 = jSONObject0.optJSONObject("discountDisplayInfo");
            this.i = jSONObject1 == null ? null : new v(jSONObject1);
            JSONObject jSONObject2 = jSONObject0.optJSONObject("validTimeWindow");
            this.j = jSONObject2 == null ? null : new z(jSONObject2);
            JSONObject jSONObject3 = jSONObject0.optJSONObject("limitedQuantityInfo");
            this.k = jSONObject3 == null ? null : new w(jSONObject3);
            JSONObject jSONObject4 = jSONObject0.optJSONObject("preorderDetails");
            this.l = jSONObject4 == null ? null : new x(jSONObject4);
            JSONObject jSONObject5 = jSONObject0.optJSONObject("rentalDetails");
            if(jSONObject5 != null) {
                y0 = new y(jSONObject5);
            }
            this.m = y0;
        }

        public String a() {
            return this.a;
        }

        public long b() {
            return this.b;
        }

        public String c() {
            return this.c;
        }

        public final String d() {
            return this.d;
        }
    }

    public static final class c {
        private final String a;
        private final long b;
        private final String c;
        private final String d;
        private final int e;
        private final int f;

        c(JSONObject jSONObject0) {
            this.d = jSONObject0.optString("billingPeriod");
            this.c = jSONObject0.optString("priceCurrencyCode");
            this.a = jSONObject0.optString("formattedPrice");
            this.b = jSONObject0.optLong("priceAmountMicros");
            this.f = jSONObject0.optInt("recurrenceMode");
            this.e = jSONObject0.optInt("billingCycleCount");
        }
    }

    public static class d {
        private final List a;

        d(JSONArray jSONArray0) {
            ArrayList arrayList0 = new ArrayList();
            if(jSONArray0 != null) {
                for(int v = 0; v < jSONArray0.length(); ++v) {
                    JSONObject jSONObject0 = jSONArray0.optJSONObject(v);
                    if(jSONObject0 != null) {
                        arrayList0.add(new c(jSONObject0));
                    }
                }
            }
            this.a = arrayList0;
        }
    }

    public static final class e {
        private final String a;
        private final String b;
        private final String c;
        private final d d;
        private final List e;
        private final a f;
        private final a0 g;

        e(JSONObject jSONObject0) {
            this.a = jSONObject0.optString("basePlanId");
            String s = jSONObject0.optString("offerId");
            a0 a00 = null;
            if(s.isEmpty()) {
                s = null;
            }
            this.b = s;
            this.c = jSONObject0.getString("offerIdToken");
            this.d = new d(jSONObject0.getJSONArray("pricingPhases"));
            JSONObject jSONObject1 = jSONObject0.optJSONObject("installmentPlanDetails");
            this.f = jSONObject1 == null ? null : new a(jSONObject1);
            JSONObject jSONObject2 = jSONObject0.optJSONObject("transitionPlanDetails");
            if(jSONObject2 != null) {
                a00 = new a0(jSONObject2);
            }
            this.g = a00;
            ArrayList arrayList0 = new ArrayList();
            JSONArray jSONArray0 = jSONObject0.optJSONArray("offerTags");
            if(jSONArray0 != null) {
                for(int v = 0; v < jSONArray0.length(); ++v) {
                    arrayList0.add(jSONArray0.getString(v));
                }
            }
            this.e = arrayList0;
        }
    }

    private final String a;
    private final JSONObject b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final String j;
    private final String k;
    private final List l;
    private final List m;

    f(String s) {
        this.a = s;
        JSONObject jSONObject0 = new JSONObject(s);
        this.b = jSONObject0;
        String s1 = jSONObject0.optString("productId");
        this.c = s1;
        String s2 = jSONObject0.optString("type");
        this.d = s2;
        if(TextUtils.isEmpty(s1)) {
            throw new IllegalArgumentException("Product id cannot be empty.");
        }
        if(TextUtils.isEmpty(s2)) {
            throw new IllegalArgumentException("Product type cannot be empty.");
        }
        this.e = jSONObject0.optString("title");
        this.f = jSONObject0.optString("name");
        this.g = jSONObject0.optString("description");
        this.i = jSONObject0.optString("packageDisplayName");
        this.j = jSONObject0.optString("iconUrl");
        this.h = jSONObject0.optString("skuDetailsToken");
        this.k = jSONObject0.optString("serializedDocid");
        JSONArray jSONArray0 = jSONObject0.optJSONArray("subscriptionOfferDetails");
        if(jSONArray0 == null) {
            this.l = s2.equals("subs") || s2.equals("play_pass_subs") ? new ArrayList() : null;
        }
        else {
            ArrayList arrayList0 = new ArrayList();
            for(int v1 = 0; v1 < jSONArray0.length(); ++v1) {
                arrayList0.add(new e(jSONArray0.getJSONObject(v1)));
            }
            this.l = arrayList0;
        }
        JSONObject jSONObject1 = this.b.optJSONObject("oneTimePurchaseOfferDetails");
        JSONArray jSONArray1 = this.b.optJSONArray("oneTimePurchaseOfferDetailsList");
        ArrayList arrayList1 = new ArrayList();
        if(jSONArray1 != null) {
            for(int v = 0; v < jSONArray1.length(); ++v) {
                arrayList1.add(new b(jSONArray1.getJSONObject(v)));
            }
            this.m = arrayList1;
            return;
        }
        if(jSONObject1 != null) {
            arrayList1.add(new b(jSONObject1));
            this.m = arrayList1;
            return;
        }
        this.m = null;
    }

    public b a() {
        return this.m == null || this.m.isEmpty() ? null : ((b)this.m.get(0));
    }

    public String b() {
        return this.c;
    }

    public String c() {
        return this.d;
    }

    public List d() {
        return this.l;
    }

    public final String e() {
        return this.b.optString("packageName");
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof f ? TextUtils.equals(this.a, ((f)object0).a) : false;
    }

    final String f() {
        return this.h;
    }

    public String g() {
        return this.k;
    }

    @Override
    public int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public String toString() {
        return "ProductDetails{jsonString=\'" + this.a + "\', parsedJson=" + this.b.toString() + ", productId=\'" + this.c + "\', productType=\'" + this.d + "\', title=\'" + this.e + "\', productDetailsToken=\'" + this.h + "\', subscriptionOfferDetails=" + this.l + "}";
    }
}

