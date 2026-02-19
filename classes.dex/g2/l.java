package g2;

final class l implements Runnable {
    final h e;
    final m f;

    l(m m0, h h0) {
        this.f = m0;
        this.e = h0;
        super();
    }

    @Override
    public final void run() {
        Object object0;
        if(this.e.o()) {
            this.f.c.t();
            return;
        }
        try {
            object0 = this.f.b.a(this.e);
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
        this.f.c.s(object0);
    }
}

