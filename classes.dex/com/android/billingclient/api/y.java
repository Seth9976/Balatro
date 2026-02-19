package com.android.billingclient.api;

import org.json.JSONObject;

public final class y {
    private final String a;
    private final String b;

    y(JSONObject jSONObject0) {
        this.a = jSONObject0.getString("rentalPeriod");
        String s = jSONObject0.optString("rentalExpirationPeriod");
        if(s.isEmpty()) {
            s = null;
        }
        this.b = s;
    }
}

