package d1;

import c1.c;

public final class l extends UnsupportedOperationException {
    private final c e;

    public l(c c0) {
        this.e = c0;
    }

    @Override
    public String getMessage() {
        return "Missing " + this.e;
    }
}

