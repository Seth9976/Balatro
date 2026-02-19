package n2;

import java.util.ArrayList;
import java.util.Iterator;

public final class f extends g implements Iterable {
    private final ArrayList e;

    public f() {
        this.e = new ArrayList();
    }

    // 去混淆评级： 低(20)
    @Override
    public boolean equals(Object object0) {
        return object0 == this || object0 instanceof f && ((f)object0).e.equals(this.e);
    }

    @Override
    public int hashCode() {
        return this.e.hashCode();
    }

    @Override
    public Iterator iterator() {
        return this.e.iterator();
    }

    public void t(g g0) {
        if(g0 == null) {
            g0 = i.e;
        }
        this.e.add(g0);
    }
}

