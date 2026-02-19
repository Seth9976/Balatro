package s;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class b extends c {
    public b f(int v, ByteBuffer byteBuffer0) {
        this.g(v, byteBuffer0);
        return this;
    }

    public void g(int v, ByteBuffer byteBuffer0) {
        this.c(v, byteBuffer0);
    }

    public static b h(ByteBuffer byteBuffer0) {
        return b.i(byteBuffer0, new b());
    }

    public static b i(ByteBuffer byteBuffer0, b b0) {
        byteBuffer0.order(ByteOrder.LITTLE_ENDIAN);
        return b0.f(byteBuffer0.getInt(byteBuffer0.position()) + byteBuffer0.position(), byteBuffer0);
    }

    public a j(a a0, int v) {
        int v1 = this.b(6);
        return v1 == 0 ? null : a0.f(this.a(this.d(v1) + v * 4), this.b);
    }

    public int k() {
        int v = this.b(6);
        return v == 0 ? 0 : this.e(v);
    }

    public int l() {
        int v = this.b(4);
        return v == 0 ? 0 : this.b.getInt(v + this.a);
    }
}

