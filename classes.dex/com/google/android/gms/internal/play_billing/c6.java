package com.google.android.gms.internal.play_billing;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

public final class c6 extends f6 implements e6 {
    c6(IBinder iBinder0) {
        super(iBinder0, "com.android.vending.billing.IInAppBillingService");
    }

    @Override  // com.google.android.gms.internal.play_billing.e6
    public final Bundle B(int v, String s, String s1, String s2, String s3) {
        Parcel parcel0 = this.a();
        parcel0.writeInt(3);
        parcel0.writeString(s);
        parcel0.writeString(s1);
        parcel0.writeString(s2);
        parcel0.writeString(null);
        Parcel parcel1 = this.d(3, parcel0);
        Bundle bundle0 = (Bundle)h6.a(parcel1, Bundle.CREATOR);
        parcel1.recycle();
        return bundle0;
    }

    @Override  // com.google.android.gms.internal.play_billing.e6
    public final Bundle C(int v, String s, String s1, String s2, String s3, Bundle bundle0) {
        Parcel parcel0 = this.a();
        parcel0.writeInt(v);
        parcel0.writeString(s);
        parcel0.writeString(s1);
        parcel0.writeString(s2);
        parcel0.writeString(null);
        h6.b(parcel0, bundle0);
        Parcel parcel1 = this.d(8, parcel0);
        Bundle bundle1 = (Bundle)h6.a(parcel1, Bundle.CREATOR);
        parcel1.recycle();
        return bundle1;
    }

    @Override  // com.google.android.gms.internal.play_billing.e6
    public final int E(int v, String s, String s1) {
        Parcel parcel0 = this.a();
        parcel0.writeInt(v);
        parcel0.writeString(s);
        parcel0.writeString(s1);
        Parcel parcel1 = this.d(1, parcel0);
        int v1 = parcel1.readInt();
        parcel1.recycle();
        return v1;
    }

    @Override  // com.google.android.gms.internal.play_billing.e6
    public final Bundle q(int v, String s, String s1, Bundle bundle0, Bundle bundle1) {
        Parcel parcel0 = this.a();
        parcel0.writeInt(v);
        parcel0.writeString(s);
        parcel0.writeString(s1);
        h6.b(parcel0, bundle0);
        h6.b(parcel0, bundle1);
        Parcel parcel1 = this.d(901, parcel0);
        Bundle bundle2 = (Bundle)h6.a(parcel1, Bundle.CREATOR);
        parcel1.recycle();
        return bundle2;
    }

    @Override  // com.google.android.gms.internal.play_billing.e6
    public final int t(int v, String s, String s1, Bundle bundle0) {
        Parcel parcel0 = this.a();
        parcel0.writeInt(v);
        parcel0.writeString(s);
        parcel0.writeString(s1);
        h6.b(parcel0, bundle0);
        Parcel parcel1 = this.d(10, parcel0);
        int v1 = parcel1.readInt();
        parcel1.recycle();
        return v1;
    }

    @Override  // com.google.android.gms.internal.play_billing.e6
    public final Bundle u(int v, String s, String s1, String s2) {
        Parcel parcel0 = this.a();
        parcel0.writeInt(3);
        parcel0.writeString(s);
        parcel0.writeString(s1);
        parcel0.writeString(s2);
        Parcel parcel1 = this.d(4, parcel0);
        Bundle bundle0 = (Bundle)h6.a(parcel1, Bundle.CREATOR);
        parcel1.recycle();
        return bundle0;
    }

    @Override  // com.google.android.gms.internal.play_billing.e6
    public final Bundle x(int v, String s, String s1, String s2, Bundle bundle0) {
        Parcel parcel0 = this.a();
        parcel0.writeInt(v);
        parcel0.writeString(s);
        parcel0.writeString(s1);
        parcel0.writeString(s2);
        h6.b(parcel0, bundle0);
        Parcel parcel1 = this.d(11, parcel0);
        Bundle bundle1 = (Bundle)h6.a(parcel1, Bundle.CREATOR);
        parcel1.recycle();
        return bundle1;
    }
}

