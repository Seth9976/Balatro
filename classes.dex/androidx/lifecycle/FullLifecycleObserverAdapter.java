package androidx.lifecycle;

class FullLifecycleObserverAdapter implements j {
    static abstract class a {
        static final int[] a;

        static {
            int[] arr_v = new int[b.values().length];
            a.a = arr_v;
            try {
                arr_v[b.ON_CREATE.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                a.a[b.ON_START.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                a.a[b.ON_RESUME.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                a.a[b.ON_PAUSE.ordinal()] = 4;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                a.a[b.ON_STOP.ordinal()] = 5;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                a.a[b.ON_DESTROY.ordinal()] = 6;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                a.a[b.ON_ANY.ordinal()] = 7;
            }
            catch(NoSuchFieldError unused_ex) {
            }
        }
    }

    private final e a;
    private final j b;

    FullLifecycleObserverAdapter(e e0, j j0) {
        this.a = e0;
        this.b = j0;
    }

    @Override  // androidx.lifecycle.j
    public void d(l l0, b h$b0) {
        switch(h$b0) {
            case 1: {
                this.a.c(l0);
                break;
            }
            case 2: {
                this.a.g(l0);
                break;
            }
            case 3: {
                this.a.a(l0);
                break;
            }
            case 4: {
                this.a.e(l0);
                break;
            }
            case 5: {
                this.a.f(l0);
                break;
            }
            case 6: {
                this.a.b(l0);
                break;
            }
            case 7: {
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
            }
        }
        j j0 = this.b;
        if(j0 != null) {
            j0.d(l0, h$b0);
        }
    }
}

