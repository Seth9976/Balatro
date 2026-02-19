package c2;

public final class s implements Runnable {
    public final c0 e;
    public final b0 f;

    public s(c0 c00, b0 b00) {
        this.e = c00;
        this.f = b00;
    }

    @Override
    public final void run() {
        this.e.g(this.f);
    }
}

