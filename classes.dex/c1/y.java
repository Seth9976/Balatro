package c1;

import java.lang.ref.WeakReference;

abstract class y extends w {
    private WeakReference b;
    private static final WeakReference c;

    static {
        y.c = new WeakReference(null);
    }

    y(byte[] arr_b) {
        super(arr_b);
        this.b = y.c;
    }

    protected abstract byte[] W();

    @Override  // c1.w
    final byte[] f() {
        synchronized(this) {
            byte[] arr_b = (byte[])this.b.get();
            if(arr_b == null) {
                arr_b = this.W();
                this.b = new WeakReference(arr_b);
            }
            return arr_b;
        }
    }
}

