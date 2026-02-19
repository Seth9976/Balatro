package g1;

import android.content.Intent;
import e1.f;

final class c0 extends d0 {
    final Intent a;
    final f b;

    c0(Intent intent0, f f0, int v) {
        this.a = intent0;
        this.b = f0;
        super();
    }

    @Override  // g1.d0
    public final void a() {
        Intent intent0 = this.a;
        if(intent0 != null) {
            this.b.startActivityForResult(intent0, 2);
        }
    }
}

