package u0;

import android.util.SparseArray;
import h0.d;
import java.util.HashMap;

public abstract class a {
    private static SparseArray a;
    private static HashMap b;

    static {
        a.a = new SparseArray();
        HashMap hashMap0 = new HashMap();
        a.b = hashMap0;
        hashMap0.put(d.e, 0);
        a.b.put(d.f, 1);
        a.b.put(d.g, 2);
        for(Object object0: a.b.keySet()) {
            a.a.append(((int)(((Integer)a.b.get(((d)object0))))), ((d)object0));
        }
    }

    public static int a(d d0) {
        Integer integer0 = (Integer)a.b.get(d0);
        if(integer0 == null) {
            throw new IllegalStateException("PriorityMapping is missing known Priority value " + d0);
        }
        return (int)integer0;
    }

    public static d b(int v) {
        d d0 = (d)a.a.get(v);
        if(d0 == null) {
            throw new IllegalArgumentException("Unknown Priority for value " + v);
        }
        return d0;
    }
}

