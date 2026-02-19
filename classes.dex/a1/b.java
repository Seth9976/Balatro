package a1;

public class b {
    private int a;

    public b() {
        this.a = 1;
    }

    public b a(Object object0) {
        this.a = this.a * 0x1F + (object0 == null ? 0 : object0.hashCode());
        return this;
    }

    public int b() {
        return this.a;
    }

    public final b c(boolean z) {
        this.a = this.a * 0x1F + ((int)z);
        return this;
    }
}

