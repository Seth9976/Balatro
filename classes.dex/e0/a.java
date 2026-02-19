package e0;

import android.content.Context;

public abstract class a {
    static abstract class e0.a.a {
    }

    public static final class b {
        private final Context a;

        private b(Context context0) {
            this.a = context0;
        }

        b(Context context0, e0.a.a a$a0) {
            this(context0);
        }

        public a a() {
            Context context0 = this.a;
            if(context0 == null) {
                throw new IllegalArgumentException("Please provide a valid Context.");
            }
            return new e0.b(context0);
        }
    }

    public abstract void a();

    public abstract d b();

    public abstract boolean c();

    public static b d(Context context0) {
        return new b(context0, null);
    }

    public abstract void e(c arg1);
}

