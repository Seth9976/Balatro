package com.google.android.gms.internal.play_billing;

enum a {
    RESPONSE_CODE_UNSPECIFIED(-999),
    SERVICE_TIMEOUT(-3),
    FEATURE_NOT_SUPPORTED(-2),
    SERVICE_DISCONNECTED(-1),
    OK(0),
    USER_CANCELED(1),
    SERVICE_UNAVAILABLE(2),
    BILLING_UNAVAILABLE(3),
    ITEM_UNAVAILABLE(4),
    DEVELOPER_ERROR(5),
    ERROR(6),
    ITEM_ALREADY_OWNED(7),
    ITEM_NOT_OWNED(8),
    EXPIRED_OFFER_TOKEN(11),
    NETWORK_ERROR(12);

    private final int e;
    private static final m u;

    static {
        l l0 = new l();
        a[] arr_a = (a[])a.v.clone();
        for(int v = 0; v < arr_a.length; ++v) {
            a a0 = arr_a[v];
            l0.a(a0.e, a0);
        }
        a.u = l0.b();
    }

    private a(int v1) {
        this.e = v1;
    }

    static a c(int v) {
        Integer integer0 = v;
        return a.u.containsKey(integer0) ? ((a)a.u.get(integer0)) : a.f;
    }
}

