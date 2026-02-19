package j0;

import h0.b;
import java.util.Arrays;

public final class h {
    private final b a;
    private final byte[] b;

    public h(b b0, byte[] arr_b) {
        if(b0 == null) {
            throw new NullPointerException("encoding is null");
        }
        if(arr_b == null) {
            throw new NullPointerException("bytes is null");
        }
        this.a = b0;
        this.b = arr_b;
    }

    public byte[] a() {
        return this.b;
    }

    public b b() {
        return this.a;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof h)) {
            return false;
        }
        return this.a.equals(((h)object0).a) ? Arrays.equals(this.b, ((h)object0).b) : false;
    }

    @Override
    public int hashCode() {
        int v = Arrays.hashCode(this.b);
        return (this.a.hashCode() ^ 1000003) * 1000003 ^ v;
    }

    @Override
    public String toString() {
        return "EncodedPayload{encoding=" + this.a + ", bytes=[...]}";
    }
}

