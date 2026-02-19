package i2;

import h2.b;
import java.util.Iterator;

public abstract class d {
    public static boolean a(Iterator iterator0, Iterator iterator1) {
        while(iterator0.hasNext()) {
            if(!iterator1.hasNext()) {
                return false;
            }
            Object object0 = iterator0.next();
            Object object1 = iterator1.next();
            if(!b.a(object0, object1)) {
                return false;
            }
            if(false) {
                break;
            }
        }
        return !iterator1.hasNext();
    }
}

