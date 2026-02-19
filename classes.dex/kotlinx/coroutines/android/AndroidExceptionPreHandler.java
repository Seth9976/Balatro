package kotlinx.coroutines.android;

import android.os.Build.VERSION;
import d3.a;
import d3.e;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import r3.d;

public final class AndroidExceptionPreHandler extends a implements d {
    private volatile Object _preHandler;

    public AndroidExceptionPreHandler() {
        super(d.c);
        this._preHandler = this;
    }

    @Override  // r3.d
    public void handleException(e e0, Throwable throwable0) {
        if(26 <= Build.VERSION.SDK_INT && Build.VERSION.SDK_INT < 28) {
            Method method0 = this.preHandler();
            Thread.UncaughtExceptionHandler thread$UncaughtExceptionHandler0 = null;
            Object object0 = method0 == null ? null : method0.invoke(null);
            if(object0 instanceof Thread.UncaughtExceptionHandler) {
                thread$UncaughtExceptionHandler0 = (Thread.UncaughtExceptionHandler)object0;
            }
            if(thread$UncaughtExceptionHandler0 != null) {
                thread$UncaughtExceptionHandler0.uncaughtException(Thread.currentThread(), throwable0);
            }
        }
    }

    private final Method preHandler() {
        Method method0;
        Object object0 = this._preHandler;
        if(object0 != this) {
            return (Method)object0;
        }
        try {
            method0 = null;
            Method method1 = Thread.class.getDeclaredMethod("getUncaughtExceptionPreHandler");
            if(Modifier.isPublic(method1.getModifiers()) && Modifier.isStatic(method1.getModifiers())) {
                method0 = method1;
            }
        }
        catch(Throwable unused_ex) {
        }
        this._preHandler = method0;
        return method0;
    }
}

