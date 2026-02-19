package c2;

import java.util.Iterator;

public abstract class c2 implements Iterator {
    @Override
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}

