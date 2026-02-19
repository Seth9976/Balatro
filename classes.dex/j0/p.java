package j0;

import h0.b;
import h0.e;
import h0.f;
import h0.g;
import java.util.Set;

final class p implements g {
    private final Set a;
    private final o b;
    private final s c;

    p(Set set0, o o0, s s0) {
        this.a = set0;
        this.b = o0;
        this.c = s0;
    }

    @Override  // h0.g
    public f a(String s, Class class0, b b0, e e0) {
        if(!this.a.contains(b0)) {
            throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", b0, this.a));
        }
        return new r(this.b, s, b0, e0, this.c);
    }
}

