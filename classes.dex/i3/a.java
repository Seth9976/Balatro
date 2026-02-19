package i3;

import k3.f;

public abstract class a {
    public static final Class a(o3.a a0) {
        f.e(a0, "<this>");
        Class class0 = ((k3.a)a0).a();
        f.c(class0, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        return class0;
    }

    public static final Class b(o3.a a0) {
        f.e(a0, "<this>");
        Class class0 = ((k3.a)a0).a();
        if(!class0.isPrimitive()) {
            f.c(class0, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
            return class0;
        }
        switch(class0.getName()) {
            case "boolean": {
                class0 = Boolean.class;
                break;
            }
            case "byte": {
                class0 = Byte.class;
                break;
            }
            case "char": {
                class0 = Character.class;
                break;
            }
            case "double": {
                class0 = Double.class;
                break;
            }
            case "float": {
                class0 = Float.class;
                break;
            }
            case "int": {
                class0 = Integer.class;
                break;
            }
            case "long": {
                class0 = Long.class;
                break;
            }
            case "short": {
                class0 = Short.class;
                break;
            }
            case "void": {
                class0 = Void.class;
            }
        }
        f.c(class0, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
        return class0;
    }
}

