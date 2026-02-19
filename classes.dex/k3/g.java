package k3;

import java.io.Serializable;

public abstract class g implements Serializable, e {
    private final int e;

    public g(int v) {
        this.e = v;
    }

    @Override
    public String toString() {
        String s = h.b(this);
        f.d(s, "renderLambdaToString(this)");
        return s;
    }
}

