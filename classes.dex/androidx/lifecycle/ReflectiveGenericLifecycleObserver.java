package androidx.lifecycle;

@Deprecated
class ReflectiveGenericLifecycleObserver implements j {
    private final Object a;
    private final a b;

    ReflectiveGenericLifecycleObserver(Object object0) {
        this.a = object0;
        this.b = androidx.lifecycle.a.c.c(object0.getClass());
    }

    @Override  // androidx.lifecycle.j
    public void d(l l0, b h$b0) {
        this.b.a(l0, h$b0, this.a);
    }
}

