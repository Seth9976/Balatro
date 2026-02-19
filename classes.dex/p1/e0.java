package p1;

import com.google.android.gms.common.data.DataHolder;
import f1.d;

public abstract class e0 extends d {
    public e0(DataHolder dataHolder0, int v) {
        super(dataHolder0, v);
    }

    // 去混淆评级： 低(20)
    protected final String g0(String s, String s1) {
        return !this.H(s) || this.K(s) ? null : this.C(s);
    }

    // 去混淆评级： 低(20)
    protected final int h0(String s, int v) {
        return !this.H(s) || this.K(s) ? v : this.x(s);
    }
}

