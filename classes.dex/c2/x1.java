package c2;

final class x1 extends r1 {
    private final z1 g;

    x1(z1 z10, int v) {
        super(z10.size(), v);
        this.g = z10;
    }

    @Override  // c2.r1
    protected final Object b(int v) {
        return this.g.get(v);
    }
}

