package com.android.billingclient.api;

import android.os.Bundle;
import com.google.android.gms.internal.play_billing.a0;
import java.util.ArrayList;

abstract class e0 {
    static d0 a(Bundle bundle0, String s, String s1) {
        d d0 = s.j;
        if(bundle0 == null) {
            a0.i("BillingClient", String.format("%s got null owned items list", s1));
            return new d0(d0, 54);
        }
        int v = a0.b(bundle0, "BillingClient");
        String s2 = a0.e(bundle0, "BillingClient");
        a d$a0 = d.c();
        d$a0.c(v);
        d$a0.b(s2);
        d d1 = d$a0.a();
        if(v != 0) {
            a0.i("BillingClient", String.format("%s failed. Response code: %s", s1, v));
            return new d0(d1, 23);
        }
        if(bundle0.containsKey("INAPP_PURCHASE_ITEM_LIST") && bundle0.containsKey("INAPP_PURCHASE_DATA_LIST") && bundle0.containsKey("INAPP_DATA_SIGNATURE_LIST")) {
            ArrayList arrayList0 = bundle0.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
            ArrayList arrayList1 = bundle0.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
            ArrayList arrayList2 = bundle0.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
            if(arrayList0 == null) {
                a0.i("BillingClient", String.format("Bundle returned from %s contains null SKUs list.", s1));
                return new d0(d0, 56);
            }
            if(arrayList1 == null) {
                a0.i("BillingClient", String.format("Bundle returned from %s contains null purchases list.", s1));
                return new d0(d0, 57);
            }
            if(arrayList2 == null) {
                a0.i("BillingClient", String.format("Bundle returned from %s contains null signatures list.", s1));
                return new d0(d0, 58);
            }
            return new d0(s.l, 1);
        }
        a0.i("BillingClient", String.format("Bundle returned from %s doesn\'t contain required fields.", s1));
        return new d0(d0, 55);
    }
}

