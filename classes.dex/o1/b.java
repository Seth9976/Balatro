package o1;

import android.os.IBinder;
import g1.q;
import java.lang.reflect.Field;

public final class b extends a {
    private final Object a;

    private b(Object object0) {
        this.a = object0;
    }

    public static Object d(o1.a a0) {
        if(a0 instanceof b) {
            return ((b)a0).a;
        }
        IBinder iBinder0 = a0.asBinder();
        Field[] arr_field = iBinder0.getClass().getDeclaredFields();
        Field field0 = null;
        int v1 = 0;
        for(int v = 0; v < arr_field.length; ++v) {
            Field field1 = arr_field[v];
            if(!field1.isSynthetic()) {
                ++v1;
                field0 = field1;
            }
        }
        if(v1 != 1) {
            throw new IllegalArgumentException("Unexpected number of IObjectWrapper declared fields: " + arr_field.length);
        }
        q.i(field0);
        if(!field0.isAccessible()) {
            field0.setAccessible(true);
            try {
                return field0.get(iBinder0);
            }
            catch(NullPointerException nullPointerException0) {
                throw new IllegalArgumentException("Binder object is null.", nullPointerException0);
            }
            catch(IllegalAccessException illegalAccessException0) {
                throw new IllegalArgumentException("Could not access the field in remoteBinder.", illegalAccessException0);
            }
        }
        throw new IllegalArgumentException("IObjectWrapper declared field not private!");
    }

    public static o1.a f(Object object0) {
        return new b(object0);
    }
}

