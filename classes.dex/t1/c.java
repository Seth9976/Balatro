package t1;

import android.content.Intent;

public final class c {
    private final boolean a;
    private final Intent b;

    private c(boolean z, Intent intent0) {
        this.a = z;
        this.b = intent0;
    }

    public final Intent a() {
        return this.b;
    }

    public static c b(Intent intent0) {
        return new c(false, intent0);
    }

    public static c c(Intent intent0) {
        return new c(true, intent0);
    }

    public final boolean d() {
        return this.a;
    }
}

