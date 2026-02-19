package com.android.billingclient.api;

import org.json.JSONObject;

public final class a0 {
    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final c f;

    a0(JSONObject jSONObject0) {
        this.a = jSONObject0.getString("productId");
        this.b = jSONObject0.optString("title");
        this.c = jSONObject0.optString("name");
        this.d = jSONObject0.optString("description");
        this.e = jSONObject0.optString("basePlanId");
        JSONObject jSONObject1 = jSONObject0.optJSONObject("pricingPhase");
        this.f = jSONObject1 == null ? null : new c(jSONObject1);
    }
}

