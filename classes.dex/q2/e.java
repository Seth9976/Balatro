package q2;

import n2.d;
import n2.r;
import n2.s;
import o2.b;
import p2.c;
import u2.a;

public final class e implements s {
    private final c e;

    public e(c c0) {
        this.e = c0;
    }

    @Override  // n2.s
    public r a(d d0, a a0) {
        b b0 = (b)a0.c().getAnnotation(b.class);
        return b0 == null ? null : this.b(this.e, d0, a0, b0);
    }

    r b(c c0, d d0, a a0, b b0) {
        r r0;
        Object object0 = c0.b(a.a(b0.value())).a();
        boolean z = b0.nullSafe();
        if(object0 instanceof r) {
            r0 = (r)object0;
            return r0 == null || !z ? r0 : r0.a();
        }
        if(!(object0 instanceof s)) {
            throw new IllegalArgumentException("Invalid attempt to bind an instance of " + object0.getClass().getName() + " as a @JsonAdapter for " + a0.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
        }
        r0 = ((s)object0).a(d0, a0);
        return r0 == null || !z ? r0 : r0.a();
    }
}

