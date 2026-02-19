package kotlinx.coroutines.scheduling;

import java.util.concurrent.atomic.AtomicReferenceArray;

public abstract class n {
    public static boolean a(AtomicReferenceArray atomicReferenceArray0, int v, Object object0, Object object1) {
        do {
            if(atomicReferenceArray0.compareAndSet(v, object0, object1)) {
                return true;
            }
        }
        while(atomicReferenceArray0.get(v) == object0);
        return false;
    }
}

