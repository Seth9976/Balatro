package x2;

import java.util.HashMap;

public abstract class l0 extends HashMap {
    // 去混淆评级： 低(20)
    public String g(String s, String s1) {
        return p0.V(s1) ? null : ((String)super.put(s, s1));
    }

    @Override
    public Object put(Object object0, Object object1) {
        return this.g(((String)object0), ((String)object1));
    }
}

