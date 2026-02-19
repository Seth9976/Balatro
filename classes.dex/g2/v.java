package g2;

final class v implements Runnable {
    final h e;
    final w f;

    v(w w0, h h0) {
        this.f = w0;
        this.e = h0;
        super();
    }

    @Override
    public final void run() {
        synchronized(this.f.b) {
            w w0 = this.f;
            if(w0.c != null) {
                w0.c.e(this.e.n());
            }
        }
    }
}

