package m2;

import java.io.OutputStream;

final class b extends OutputStream {
    private long e;

    b() {
        this.e = 0L;
    }

    long a() {
        return this.e;
    }

    @Override
    public void write(int v) {
        ++this.e;
    }

    @Override
    public void write(byte[] arr_b) {
        this.e += (long)arr_b.length;
    }

    @Override
    public void write(byte[] arr_b, int v, int v1) {
        if(v < 0 || v > arr_b.length || v1 < 0 || (v + v1 > arr_b.length || v + v1 < 0)) {
            throw new IndexOutOfBoundsException();
        }
        this.e += (long)v1;
    }
}

