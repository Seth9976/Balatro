package u2;

import java.lang.reflect.Type;
import java.util.Objects;
import p2.b;

public class a {
    private final Class a;
    private final Type b;
    private final int c;

    private a(Type type0) {
        Objects.requireNonNull(type0);
        Type type1 = b.b(type0);
        this.b = type1;
        this.a = b.k(type1);
        this.c = type1.hashCode();
    }

    public static a a(Class class0) {
        return new a(class0);
    }

    public static a b(Type type0) {
        return new a(type0);
    }

    public final Class c() {
        return this.a;
    }

    public final Type d() {
        return this.b;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof a && b.f(this.b, ((a)object0).b);
    }

    @Override
    public final int hashCode() {
        return this.c;
    }

    @Override
    public final String toString() {
        return b.t(this.b);
    }
}

