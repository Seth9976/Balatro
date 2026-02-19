package l3;

import java.util.Random;
import k3.f;

public final class b extends a {
    private final l3.b.a g;

    public b() {
        public static final class l3.b.a extends ThreadLocal {
            protected Random a() {
                return new Random();
            }

            @Override
            public Object initialValue() {
                return this.a();
            }
        }

        this.g = new l3.b.a();
    }

    @Override  // l3.a
    public Random c() {
        Object object0 = this.g.get();
        f.d(object0, "implStorage.get()");
        return (Random)object0;
    }
}

