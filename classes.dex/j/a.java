package j;

import java.util.HashMap;
import java.util.Map.Entry;

public class a extends b {
    private HashMap i;

    public a() {
        this.i = new HashMap();
    }

    public boolean contains(Object object0) {
        return this.i.containsKey(object0);
    }

    @Override  // j.b
    protected c o(Object object0) {
        return (c)this.i.get(object0);
    }

    @Override  // j.b
    public Object s(Object object0, Object object1) {
        c b$c0 = this.o(object0);
        if(b$c0 != null) {
            return b$c0.f;
        }
        this.i.put(object0, this.r(object0, object1));
        return null;
    }

    @Override  // j.b
    public Object t(Object object0) {
        Object object1 = super.t(object0);
        this.i.remove(object0);
        return object1;
    }

    public Map.Entry u(Object object0) {
        return this.contains(object0) ? ((c)this.i.get(object0)).h : null;
    }
}

