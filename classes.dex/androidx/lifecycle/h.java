package androidx.lifecycle;

import java.util.concurrent.atomic.AtomicReference;

public abstract class h {
    static abstract class a {
        static final int[] a;
        static final int[] b;

        static {
            int[] arr_v = new int[b.values().length];
            a.b = arr_v;
            try {
                arr_v[b.ON_CREATE.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                a.b[b.ON_STOP.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                a.b[b.ON_START.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                a.b[b.ON_PAUSE.ordinal()] = 4;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                a.b[b.ON_RESUME.ordinal()] = 5;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                a.b[b.ON_DESTROY.ordinal()] = 6;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                a.b[b.ON_ANY.ordinal()] = 7;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            int[] arr_v1 = new int[c.values().length];
            a.a = arr_v1;
            try {
                arr_v1[c.g.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                a.a[c.h.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                a.a[c.i.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                a.a[c.e.ordinal()] = 4;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                a.a[c.f.ordinal()] = 5;
            }
            catch(NoSuchFieldError unused_ex) {
            }
        }
    }

    public static enum b {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY;

        public static b c(c h$c0) {
            switch(h$c0) {
                case 1: {
                    return b.ON_DESTROY;
                }
                case 2: {
                    return b.ON_STOP;
                }
                case 3: {
                    return b.ON_PAUSE;
                }
                default: {
                    return null;
                }
            }
        }

        public c j() {
            switch(a.b[this.ordinal()]) {
                case 1: 
                case 2: {
                    return c.g;
                }
                case 3: 
                case 4: {
                    return c.h;
                }
                case 5: {
                    return c.i;
                }
                case 6: {
                    return c.e;
                }
                default: {
                    throw new IllegalArgumentException(this + " has no target state");
                }
            }
        }

        public static b k(c h$c0) {
            switch(h$c0) {
                case 1: {
                    return b.ON_START;
                }
                case 2: {
                    return b.ON_RESUME;
                }
                case 5: {
                    return b.ON_CREATE;
                }
                default: {
                    return null;
                }
            }
        }
    }

    public static enum c {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        public boolean c(c h$c0) {
            return this.compareTo(h$c0) >= 0;
        }
    }

    AtomicReference a;

    public h() {
        this.a = new AtomicReference();
    }

    public abstract void a(k arg1);

    public abstract c b();

    public abstract void c(k arg1);
}

