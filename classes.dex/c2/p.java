package c2;

import e1.b0;
import java.util.concurrent.atomic.AtomicReference;

public abstract class p {
    public static boolean a(AtomicReference atomicReference0, Object object0, Object object1) {
        do {
            if(b0.a(atomicReference0, object0, object1)) {
                return true;
            }
        }
        while(atomicReference0.get() == object0);
        return false;
    }
}

