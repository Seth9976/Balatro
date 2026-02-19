package g1;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri.Builder;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

public final class i1 {
    private final String a;
    private final String b;
    private final ComponentName c;
    private final int d;
    private final boolean e;
    private static final Uri f;

    static {
        i1.f = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();
    }

    public i1(String s, String s1, int v, boolean z) {
        q.f(s);
        this.a = s;
        q.f(s1);
        this.b = s1;
        this.c = null;
        this.d = 0x1081;
        this.e = z;
    }

    public final ComponentName a() {
        return this.c;
    }

    public final Intent b(Context context0) {
        Bundle bundle1;
        Intent intent0 = null;
        if(this.a != null) {
            if(this.e) {
                Bundle bundle0 = new Bundle();
                bundle0.putString("serviceActionBundleKey", this.a);
                try {
                    bundle1 = context0.getContentResolver().call(i1.f, "serviceIntentCall", null, bundle0);
                }
                catch(IllegalArgumentException illegalArgumentException0) {
                    Log.w("ConnectionStatusConfig", "Dynamic intent resolution failed: " + illegalArgumentException0.toString());
                    bundle1 = null;
                }
                if(bundle1 != null) {
                    intent0 = (Intent)bundle1.getParcelable("serviceResponseIntentKey");
                }
                if(intent0 == null) {
                    Log.w("ConnectionStatusConfig", "Dynamic lookup for intent failed for action: " + this.a);
                }
            }
            return intent0 == null ? new Intent(this.a).setPackage(this.b) : intent0;
        }
        return new Intent().setComponent(this.c);
    }

    public final String c() {
        return this.b;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof i1 ? o.a(this.a, ((i1)object0).a) && o.a(this.b, ((i1)object0).b) && o.a(this.c, ((i1)object0).c) && this.e == ((i1)object0).e : false;
    }

    @Override
    public final int hashCode() {
        return o.b(new Object[]{this.a, this.b, this.c, 0x1081, Boolean.valueOf(this.e)});
    }

    @Override
    public final String toString() {
        String s = this.a;
        if(s == null) {
            q.i(this.c);
            return this.c.flattenToString();
        }
        return s;
    }
}

