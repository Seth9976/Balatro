package x2;

import android.app.Application.ActivityLifecycleCallbacks;
import android.app.Application;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class j0 implements InvocationHandler {
    private final g0 a;
    private static final k0 b;

    static {
        j0.b = k0.f("j0");
    }

    j0(g0 g00) {
        this.a = g00;
        g00.u();
    }

    void a(Application application0) {
        Method method0;
        try {
            Object object0 = Proxy.newProxyInstance(Application.class.getClassLoader(), new Class[]{Application.ActivityLifecycleCallbacks.class}, this);
            Method[] arr_method = Application.class.getMethods();
            for(int v = 0; true; ++v) {
                if(v >= arr_method.length) {
                    method0 = null;
                    break;
                }
                Method method1 = arr_method[v];
                if(method1.getName().equals("registerActivityLifecycleCallbacks")) {
                    method0 = method1;
                    break;
                }
            }
            if(method0 != null) {
                method0.invoke(application0, object0);
                j0.b.a("ActivityLifecycleCallbacks registration successful, Automatic session management will work.");
                return;
            }
            j0.b.c("ActivityLifecycleCallbacks registration not available, Automatic session management will not work");
        }
        catch(Throwable throwable0) {
            j0.b.d("ActivityLifecycleCallbacks registration failed, Automatic session management will not work", throwable0);
        }
    }

    @Override
    public Object invoke(Object object0, Method method0, Object[] arr_object) {
        if("onActivityResumed".equals(method0.getName())) {
            this.a.j(0x19C748F7A4CL);
            return null;
        }
        if("onActivityPaused".equals(method0.getName())) {
            i i0 = i.t();
            if(i0 != null) {
                i0.y();
            }
            this.a.k(0x19C748F7A4DL);
        }
        return null;
    }
}

