package j2;

import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class c {
    static abstract class a {
    }

    public static final class b {
        private final String a;
        private Map b;

        b(String s) {
            this.b = null;
            this.a = s;
        }

        public c a() {
            return this.b == null ? new c(this.a, Collections.emptyMap(), null) : new c(this.a, Collections.unmodifiableMap(new HashMap(this.b)), null);
        }

        public b b(Annotation annotation0) {
            if(this.b == null) {
                this.b = new HashMap();
            }
            this.b.put(annotation0.annotationType(), annotation0);
            return this;
        }
    }

    private final String a;
    private final Map b;

    private c(String s, Map map0) {
        this.a = s;
        this.b = map0;
    }

    c(String s, Map map0, a c$a0) {
        this(s, map0);
    }

    public static b a(String s) {
        return new b(s);
    }

    public String b() {
        return this.a;
    }

    public Annotation c(Class class0) {
        return (Annotation)this.b.get(class0);
    }

    public static c d(String s) {
        return new c(s, Collections.emptyMap());
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof c ? this.a.equals(((c)object0).a) && this.b.equals(((c)object0).b) : false;
    }

    @Override
    public int hashCode() {
        return this.a.hashCode() * 0x1F + this.b.hashCode();
    }

    @Override
    public String toString() {
        return "FieldDescriptor{name=" + this.a + ", properties=" + this.b.values() + "}";
    }
}

