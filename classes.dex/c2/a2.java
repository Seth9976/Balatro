package c2;

public final class a2 {
    private int a;
    private String b;

    a2(c1 c10) {
        this.a = 9;
    }

    public final a2 a(int v) {
        this.a = 9;
        return this;
    }

    public final a2 b(String s) {
        this.b = s;
        return this;
    }

    public final i2 c() {
        return new i2(this.a, this.b, null);
    }
}

