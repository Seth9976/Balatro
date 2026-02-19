package k3;

import o3.a;

public class i {
    public a a(Class class0) {
        return new b(class0);
    }

    public String b(e e0) {
        String s = e0.getClass().getGenericInterfaces()[0].toString();
        return s.startsWith("kotlin.jvm.functions.") ? s.substring(21) : s;
    }

    public String c(g g0) {
        return this.b(g0);
    }
}

