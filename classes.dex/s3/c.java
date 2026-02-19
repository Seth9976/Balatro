package s3;

import android.os.Build.VERSION;
import android.os.Handler.Callback;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import b3.i;
import b3.j;

public abstract class c {
    public static final b a;
    private static volatile Choreographer choreographer;

    static {
        Object object1;
        Object object0 = null;
        try {
            object1 = i.a(new a(c.a(Looper.getMainLooper(), true), null, 2, null));
        }
        catch(Throwable throwable0) {
            object1 = i.a(j.a(throwable0));
        }
        if(!i.b(object1)) {
            object0 = object1;
        }
        c.a = (b)object0;
    }

    public static final Handler a(Looper looper0, boolean z) {
        if(z) {
            Class class0 = Looper.class;
            Class class1 = Handler.class;
            if(Build.VERSION.SDK_INT >= 28) {
                Handler handler0 = Handler.createAsync(looper0);
                if(handler0 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.os.Handler");
                }
                return handler0;
            }
            try {
                return (Handler)class1.getDeclaredConstructor(class0, Handler.Callback.class, Boolean.TYPE).newInstance(looper0, null, Boolean.TRUE);
            }
            catch(NoSuchMethodException unused_ex) {
                return new Handler(looper0);
            }
        }
        return new Handler(looper0);
    }
}

