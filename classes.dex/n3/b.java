package n3;

import c3.v;
import java.util.NoSuchElementException;

public final class b extends v {
    private final int e;
    private final int f;
    private boolean g;
    private int h;

    public b(int v, int v1, int v2) {
        this.e = v2;
        this.f = v1;
        boolean z = v2 <= 0 ? v >= v1 : v <= v1;
        this.g = z;
        if(!z) {
            v = v1;
        }
        this.h = v;
    }

    @Override  // c3.v
    public int b() {
        int v = this.h;
        if(v == this.f) {
            if(!this.g) {
                throw new NoSuchElementException();
            }
            this.g = false;
            return v;
        }
        this.h = this.e + v;
        return v;
    }

    @Override
    public boolean hasNext() {
        return this.g;
    }
}

