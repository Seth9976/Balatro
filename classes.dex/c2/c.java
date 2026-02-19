package c2;

import android.os.Bundle;
import android.os.IBinder;

public final class c {
    public IBinder a;
    public final int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;

    public c(int v, IBinder iBinder0) {
        this.c = -1;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.b = v;
        this.a = null;
    }

    public final Bundle a() {
        Bundle bundle0 = new Bundle();
        bundle0.putInt("popupLocationInfo.gravity", this.b);
        bundle0.putInt("popupLocationInfo.displayId", this.c);
        bundle0.putInt("popupLocationInfo.left", this.d);
        bundle0.putInt("popupLocationInfo.top", this.e);
        bundle0.putInt("popupLocationInfo.right", this.f);
        bundle0.putInt("popupLocationInfo.bottom", this.g);
        return bundle0;
    }
}

