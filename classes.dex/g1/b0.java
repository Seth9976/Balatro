package g1;

import android.app.Activity;
import android.content.Intent;

final class b0 extends d0 {
    final Intent a;
    final Activity b;
    final int c;

    b0(Intent intent0, Activity activity0, int v) {
        this.a = intent0;
        this.b = activity0;
        this.c = v;
        super();
    }

    @Override  // g1.d0
    public final void a() {
        Intent intent0 = this.a;
        if(intent0 != null) {
            this.b.startActivityForResult(intent0, this.c);
        }
    }
}

