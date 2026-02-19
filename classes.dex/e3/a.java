package e3;

import c3.e;
import java.lang.reflect.Method;
import k3.f;
import l3.b;
import l3.c;

public class a {
    static final class e3.a.a {
        public static final e3.a.a a;
        public static final Method b;
        public static final Method c;

        static {
            boolean z;
            Method method1;
            Method method0;
            e3.a.a.a = new e3.a.a();
            Class class0 = Throwable.class;
            Method[] arr_method = class0.getMethods();
            f.d(arr_method, "throwableMethods");
            for(int v1 = 0; true; ++v1) {
                method0 = null;
                method1 = null;
                if(v1 >= arr_method.length) {
                    break;
                }
                method0 = arr_method[v1];
                if(f.a(method0.getName(), "addSuppressed")) {
                    Class[] arr_class = method0.getParameterTypes();
                    f.d(arr_class, "it.parameterTypes");
                    if(f.a(e.e(arr_class), class0)) {
                        z = true;
                    }
                }
                else {
                    z = false;
                }
                if(z) {
                    break;
                }
            }
            e3.a.a.b = method0;
            for(int v = 0; v < arr_method.length; ++v) {
                Method method2 = arr_method[v];
                if(f.a(method2.getName(), "getSuppressed")) {
                    method1 = method2;
                    break;
                }
            }
            e3.a.a.c = method1;
        }
    }

    public void a(Throwable throwable0, Throwable throwable1) {
        f.e(throwable0, "cause");
        f.e(throwable1, "exception");
        Method method0 = e3.a.a.b;
        if(method0 != null) {
            method0.invoke(throwable0, throwable1);
        }
    }

    public c b() {
        return new b();
    }
}

