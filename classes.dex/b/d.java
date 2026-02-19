package b;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.e;
import k3.f;

public final class d extends a {
    public static final class b.d.a {
        private b.d.a() {
        }

        public b.d.a(k3.d d0) {
        }
    }

    public static final b.d.a a;

    static {
        d.a = new b.d.a(null);
    }

    @Override  // b.a
    public Intent a(Context context0, Object object0) {
        return this.d(context0, ((e)object0));
    }

    @Override  // b.a
    public Object c(int v, Intent intent0) {
        return this.e(v, intent0);
    }

    public Intent d(Context context0, e e0) {
        f.e(context0, "context");
        f.e(e0, "input");
        Intent intent0 = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", e0);
        f.d(intent0, "Intent(ACTION_INTENT_SEN…NT_SENDER_REQUEST, input)");
        return intent0;
    }

    public androidx.activity.result.a e(int v, Intent intent0) {
        return new androidx.activity.result.a(v, intent0);
    }
}

