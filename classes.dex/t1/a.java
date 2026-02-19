package t1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.ResultReceiver;
import c2.k1;
import g2.h;
import g2.i;

final class a extends ResultReceiver {
    private final i e;

    public a() {
        super(new k1(Looper.getMainLooper()));
        this.e = new i();
    }

    public final h o() {
        return this.e.a();
    }

    @Override  // android.os.ResultReceiver
    protected final void onReceiveResult(int v, Bundle bundle0) {
        Intent intent0;
        super.onReceiveResult(v, bundle0);
        Boolean boolean0 = Boolean.valueOf(v == -1);
        if(bundle0 == null) {
            intent0 = new Intent();
        }
        else {
            intent0 = (Intent)bundle0.getParcelable("resultData");
            if(intent0 == null) {
                intent0 = new Intent();
            }
        }
        c c0 = boolean0.booleanValue() ? c.c(intent0) : c.b(intent0);
        this.e.e(c0);
    }
}

