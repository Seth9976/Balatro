package n2;

import java.util.Set;
import p2.h;

public final class j extends g {
    private final h e;

    public j() {
        this.e = new h(false);
    }

    // 去混淆评级： 低(20)
    @Override
    public boolean equals(Object object0) {
        return object0 == this || object0 instanceof j && ((j)object0).e.equals(this.e);
    }

    @Override
    public int hashCode() {
        return this.e.hashCode();
    }

    public void t(String s, g g0) {
        h h0 = this.e;
        if(g0 == null) {
            g0 = i.e;
        }
        h0.put(s, g0);
    }

    public Set u() {
        return this.e.entrySet();
    }
}

