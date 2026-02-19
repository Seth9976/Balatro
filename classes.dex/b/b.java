package b;

import android.content.Context;
import android.content.Intent;
import b3.h;
import b3.l;
import c3.e;
import c3.q;
import c3.y;
import c3.z;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import k3.d;
import k3.f;

public final class b extends a {
    public static final class b.b.a {
        private b.b.a() {
        }

        public b.b.a(d d0) {
        }

        public final Intent a(String[] arr_s) {
            f.e(arr_s, "input");
            Intent intent0 = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", arr_s);
            f.d(intent0, "Intent(ACTION_REQUEST_PE…EXTRA_PERMISSIONS, input)");
            return intent0;
        }
    }

    public static final b.b.a a;

    static {
        b.a = new b.b.a(null);
    }

    @Override  // b.a
    public Intent a(Context context0, Object object0) {
        return this.d(context0, ((String[])object0));
    }

    @Override  // b.a
    public b.a.a b(Context context0, Object object0) {
        return this.e(context0, ((String[])object0));
    }

    @Override  // b.a
    public Object c(int v, Intent intent0) {
        return this.f(v, intent0);
    }

    public Intent d(Context context0, String[] arr_s) {
        f.e(context0, "context");
        f.e(arr_s, "input");
        return b.a.a(arr_s);
    }

    public b.a.a e(Context context0, String[] arr_s) {
        f.e(context0, "context");
        f.e(arr_s, "input");
        boolean z = true;
        if(arr_s.length == 0) {
            return new b.a.a(z.d());
        }
        for(int v1 = 0; v1 < arr_s.length; ++v1) {
            if(androidx.core.content.a.a(context0, arr_s[v1]) != 0) {
                z = false;
                break;
            }
        }
        if(z) {
            LinkedHashMap linkedHashMap0 = new LinkedHashMap(n3.f.a(y.a(arr_s.length), 16));
            for(int v = 0; v < arr_s.length; ++v) {
                h h0 = l.a(arr_s[v], Boolean.TRUE);
                linkedHashMap0.put(h0.c(), h0.d());
            }
            return new b.a.a(linkedHashMap0);
        }
        return null;
    }

    public Map f(int v, Intent intent0) {
        if(v != -1) {
            return z.d();
        }
        if(intent0 == null) {
            return z.d();
        }
        String[] arr_s = intent0.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
        int[] arr_v = intent0.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
        if(arr_v != null && arr_s != null) {
            ArrayList arrayList0 = new ArrayList(arr_v.length);
            for(int v1 = 0; v1 < arr_v.length; ++v1) {
                arrayList0.add(Boolean.valueOf(arr_v[v1] == 0));
            }
            return z.g(q.o(e.b(arr_s), arrayList0));
        }
        return z.d();
    }
}

