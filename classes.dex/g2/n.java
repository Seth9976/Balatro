package g2;

final class n implements Runnable {
    final h e;
    final o f;

    n(o o0, h h0) {
        this.f = o0;
        this.e = h0;
        super();
    }

    @Override
    public final void run() {
        h h0;
        try {
            h0 = (h)this.f.b.a(this.e);
        }
        catch(g g0) {
            if(g0.getCause() instanceof Exception) {
                this.f.c.r(((Exception)g0.getCause()));
                return;
            }
            this.f.c.r(g0);
            return;
        }
        catch(Exception exception0) {
            this.f.c.r(exception0);
            return;
        }
        if(h0 == null) {
            NullPointerException nullPointerException0 = new NullPointerException("Continuation returned null");
            this.f.d(nullPointerException0);
            return;
        }
        h0.h(j.b, this.f);
        h0.f(j.b, this.f);
        h0.a(j.b, this.f);
    }
}

