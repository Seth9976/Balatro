package i;

import java.util.concurrent.Executor;

public class a extends d {
    static final class i.a.a implements Executor {
        @Override
        public void execute(Runnable runnable0) {
            a.d().c(runnable0);
        }
    }

    static final class b implements Executor {
        @Override
        public void execute(Runnable runnable0) {
            a.d().a(runnable0);
        }
    }

    private d a;
    private d b;
    private static volatile a c;
    private static final Executor d;
    private static final Executor e;

    static {
        a.d = (Runnable runnable0) -> a.d().a.c(runnable0);
        a.e = (Runnable runnable0) -> a.d().a.a(runnable0);
    }

    private a() {
        c c0 = new c();
        this.b = c0;
        this.a = c0;
    }

    // 检测为 Lambda 实现
    @Override  // i.d
    public void a(Runnable runnable0) [...]

    @Override  // i.d
    public boolean b() {
        return this.a.b();
    }

    // 检测为 Lambda 实现
    @Override  // i.d
    public void c(Runnable runnable0) [...]

    public static a d() {
        if(a.c != null) {
            return a.c;
        }
        synchronized(a.class) {
            if(a.c == null) {
                a.c = new a();
            }
            return a.c;
        }
    }
}

