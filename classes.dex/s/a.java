package s;

import java.nio.ByteBuffer;

public final class a extends c {
    public a f(int v, ByteBuffer byteBuffer0) {
        this.g(v, byteBuffer0);
        return this;
    }

    public void g(int v, ByteBuffer byteBuffer0) {
        this.c(v, byteBuffer0);
    }

    public int h(int v) {
        int v1 = this.b(16);
        return v1 == 0 ? 0 : this.b.getInt(this.d(v1) + v * 4);
    }

    public int i() {
        int v = this.b(16);
        return v == 0 ? 0 : this.e(v);
    }

    public boolean j() {
        int v = this.b(6);
        return v != 0 && this.b.get(v + this.a) != 0;
    }

    public short k() {
        int v = this.b(14);
        return v == 0 ? 0 : this.b.getShort(v + this.a);
    }

    public int l() {
        int v = this.b(4);
        return v == 0 ? 0 : this.b.getInt(v + this.a);
    }

    public short m() {
        int v = this.b(8);
        return v == 0 ? 0 : this.b.getShort(v + this.a);
    }

    public short n() {
        int v = this.b(12);
        return v == 0 ? 0 : this.b.getShort(v + this.a);
    }
}

