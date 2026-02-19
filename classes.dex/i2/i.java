package i2;

import java.util.Iterator;

public abstract class i implements Iterator {
    @Override
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}

