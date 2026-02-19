package z0;

import com.google.android.gms.common.api.Scope;
import java.util.Comparator;

public final class b implements Comparator {
    public static final b a;

    static {
        b.a = new b();
    }

    @Override
    public final int compare(Object object0, Object object1) {
        return ((Scope)object0).j0().compareTo(((Scope)object1).j0());
    }
}

