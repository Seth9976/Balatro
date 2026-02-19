package t3;

import java.util.concurrent.atomic.AtomicReferenceArray;
import n3.f;

public final class k {
    private volatile AtomicReferenceArray array;

    public k(int v) {
        this.array = new AtomicReferenceArray(v);
    }

    public final int a() {
        return this.array.length();
    }

    public final Object b(int v) {
        AtomicReferenceArray atomicReferenceArray0 = this.array;
        return v >= atomicReferenceArray0.length() ? null : atomicReferenceArray0.get(v);
    }

    public final void c(int v, Object object0) {
        AtomicReferenceArray atomicReferenceArray0 = this.array;
        int v1 = atomicReferenceArray0.length();
        if(v < v1) {
            atomicReferenceArray0.set(v, object0);
            return;
        }
        AtomicReferenceArray atomicReferenceArray1 = new AtomicReferenceArray(f.a(v + 1, v1 * 2));
        for(int v2 = 0; v2 < v1; ++v2) {
            atomicReferenceArray1.set(v2, atomicReferenceArray0.get(v2));
        }
        atomicReferenceArray1.set(v, object0);
        this.array = atomicReferenceArray1;
    }
}

