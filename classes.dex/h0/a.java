package h0;

final class a extends c {
    private final Integer a;
    private final Object b;
    private final d c;

    a(Integer integer0, Object object0, d d0) {
        this.a = integer0;
        if(object0 == null) {
            throw new NullPointerException("Null payload");
        }
        this.b = object0;
        if(d0 == null) {
            throw new NullPointerException("Null priority");
        }
        this.c = d0;
    }

    @Override  // h0.c
    public Integer a() {
        return this.a;
    }

    @Override  // h0.c
    public Object b() {
        return this.b;
    }

    @Override  // h0.c
    public d c() {
        return this.c;
    }

    @Override
    public boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        if(object0 instanceof c) {
            Integer integer0 = this.a;
            if(integer0 != null) {
                if(integer0.equals(((c)object0).a())) {
                label_8:
                    Object object1 = ((c)object0).b();
                    if(this.b.equals(object1)) {
                        d d0 = ((c)object0).c();
                        return this.c.equals(d0);
                    }
                }
            }
            else if(((c)object0).a() == null) {
                goto label_8;
            }
            return false;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.a == null ? (0xD5009D89 ^ this.b.hashCode()) * 1000003 ^ this.c.hashCode() : ((this.a.hashCode() ^ 1000003) * 1000003 ^ this.b.hashCode()) * 1000003 ^ this.c.hashCode();
    }

    @Override
    public String toString() {
        return "Event{code=" + this.a + ", payload=" + this.b + ", priority=" + this.c + "}";
    }
}

