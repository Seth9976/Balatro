package c1;

import java.util.Arrays;

final class x extends w {
    private final byte[] b;

    x(byte[] arr_b) {
        super(Arrays.copyOfRange(arr_b, 0, 25));
        this.b = arr_b;
    }

    @Override  // c1.w
    final byte[] f() {
        return this.b;
    }
}

