package p2;

import java.lang.reflect.Type;

public abstract class k {
    // 去混淆评级： 低(20)
    public static boolean a(Type type0) {
        return type0 instanceof Class && ((Class)type0).isPrimitive();
    }

    public static Class b(Class class0) {
        if(class0 == Integer.TYPE) {
            return Integer.class;
        }
        if(class0 == Float.TYPE) {
            return Float.class;
        }
        if(class0 == Byte.TYPE) {
            return Byte.class;
        }
        if(class0 == Double.TYPE) {
            return Double.class;
        }
        if(class0 == Long.TYPE) {
            return Long.class;
        }
        if(class0 == Character.TYPE) {
            return Character.class;
        }
        if(class0 == Boolean.TYPE) {
            return Boolean.class;
        }
        if(class0 == Short.TYPE) {
            return Short.class;
        }
        return class0 == Void.TYPE ? Void.class : class0;
    }
}

