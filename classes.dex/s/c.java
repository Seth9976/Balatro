package s;

import java.nio.ByteBuffer;

public abstract class c {
    protected int a;
    protected ByteBuffer b;
    private int c;
    private int d;
    d e;

    public c() {
        this.e = d.a();
    }

    protected int a(int v) {
        return v + this.b.getInt(v);
    }

    protected int b(int v) {
        return v >= this.d ? 0 : this.b.getShort(this.c + v);
    }

    protected void c(int v, ByteBuffer byteBuffer0) {
        int v2;
        this.b = byteBuffer0;
        if(byteBuffer0 == null) {
            v2 = 0;
            this.a = 0;
            this.c = 0;
        }
        else {
            this.a = v;
            int v1 = v - byteBuffer0.getInt(v);
            this.c = v1;
            v2 = this.b.getShort(v1);
        }
        this.d = v2;
    }

    protected int d(int v) {
        int v1 = v + this.a;
        return v1 + this.b.getInt(v1) + 4;
    }

    protected int e(int v) {
        int v1 = v + this.a;
        int v2 = this.b.getInt(v1);
        return this.b.getInt(v1 + v2);
    }
}

