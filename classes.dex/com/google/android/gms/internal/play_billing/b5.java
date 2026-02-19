package com.google.android.gms.internal.play_billing;

public enum b5 implements p1 {
    BROADCAST_ACTION_UNSPECIFIED(0),
    PURCHASES_UPDATED_ACTION(1),
    LOCAL_PURCHASES_UPDATED_ACTION(2),
    ALTERNATIVE_BILLING_ACTION(3);

    private final int e;
    private static final q1 j;

    static {
        b5.j = new z4();
    }

    private b5(int v1) {
        this.e = v1;
    }

    @Override
    public final String toString() {
        return Integer.toString(this.e);
    }
}

