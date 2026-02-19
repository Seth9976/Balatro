package t3;

import b3.c;
import java.util.List;
import r3.v;

public abstract class i {
    private static final boolean a;

    static {
    }

    private static final j a(Throwable throwable0, String s) {
        if(i.a) {
            return new j(throwable0, s);
        }
        if(throwable0 != null) {
            throw throwable0;
        }
        i.d();
        throw new c();
    }

    static j b(Throwable throwable0, String s, int v, Object object0) {
        if((v & 1) != 0) {
            throwable0 = null;
        }
        if((v & 2) != 0) {
            s = null;
        }
        return i.a(throwable0, s);
    }

    public static final boolean c(v v0) {
        return v0.d() instanceof j;
    }

    public static final Void d() {
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. \'kotlinx-coroutines-android\' and ensure it has the same version as \'kotlinx-coroutines-core\'");
    }

    public static final v e(g g0, List list0) {
        try {
            return g0.createDispatcher(list0);
        }
        catch(Throwable throwable0) {
            return i.a(throwable0, g0.hintOnError());
        }
    }
}

