package com.google.android.gms.internal.play_billing;

final class j2 implements p2 {
    private final p2[] a;

    j2(p2[] arr_p2) {
        this.a = arr_p2;
    }

    @Override  // com.google.android.gms.internal.play_billing.p2
    public final o2 a(Class class0) {
        for(int v = 0; v < 2; ++v) {
            p2 p20 = this.a[v];
            if(p20.b(class0)) {
                return p20.a(class0);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: " + class0.getName());
    }

    @Override  // com.google.android.gms.internal.play_billing.p2
    public final boolean b(Class class0) {
        for(int v = 0; v < 2; ++v) {
            if(this.a[v].b(class0)) {
                return true;
            }
        }
        return false;
    }
}

