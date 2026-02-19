package androidx.emoji2.text;

import a0.a;
import android.content.Context;
import androidx.lifecycle.ProcessLifecycleInitializer;
import androidx.lifecycle.l;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

public class EmojiCompatInitializer implements a {
    static class androidx.emoji2.text.EmojiCompatInitializer.a extends c {
        protected androidx.emoji2.text.EmojiCompatInitializer.a(Context context0) {
            super(new b(context0));
            this.b(1);
        }
    }

    static class b implements g {
        private final Context a;

        b(Context context0) {
            this.a = context0.getApplicationContext();
        }

        @Override  // androidx.emoji2.text.e$g
        public void a(h e$h0) {
            ThreadPoolExecutor threadPoolExecutor0 = androidx.emoji2.text.b.b("EmojiCompatInitializer");
            threadPoolExecutor0.execute(() -> this.c(e$h0, threadPoolExecutor0));
        }

        void c(h e$h0, ThreadPoolExecutor threadPoolExecutor0) {
            class androidx.emoji2.text.EmojiCompatInitializer.b.a extends h {
                final h a;
                final ThreadPoolExecutor b;
                final b c;

                androidx.emoji2.text.EmojiCompatInitializer.b.a(h e$h0, ThreadPoolExecutor threadPoolExecutor0) {
                    this.a = e$h0;
                    this.b = threadPoolExecutor0;
                    super();
                }

                @Override  // androidx.emoji2.text.e$h
                public void a(Throwable throwable0) {
                    try {
                        this.a.a(throwable0);
                    }
                    finally {
                        this.b.shutdown();
                    }
                }

                @Override  // androidx.emoji2.text.e$h
                public void b(m m0) {
                    try {
                        this.a.b(m0);
                    }
                    finally {
                        this.b.shutdown();
                    }
                }
            }

            try {
                j j0 = androidx.emoji2.text.c.a(this.a);
                if(j0 == null) {
                    throw new RuntimeException("EmojiCompat font provider not available on this device.");
                }
                j0.c(threadPoolExecutor0);
                j0.a().a(new androidx.emoji2.text.EmojiCompatInitializer.b.a(this, e$h0, threadPoolExecutor0));
            }
            catch(Throwable throwable0) {
                e$h0.a(throwable0);
                threadPoolExecutor0.shutdown();
            }
        }

        // 检测为 Lambda 实现
        private void d(h e$h0, ThreadPoolExecutor threadPoolExecutor0) [...]
    }

    static class androidx.emoji2.text.EmojiCompatInitializer.c implements Runnable {
        @Override
        public void run() {
            try {
                androidx.core.os.m.a("EmojiCompat.EmojiCompatInitializer.run");
            }
            finally {
                androidx.core.os.m.b();
            }
        }
    }

    @Override  // a0.a
    public List a() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    @Override  // a0.a
    public Object b(Context context0) {
        return this.c(context0);
    }

    public Boolean c(Context context0) {
        e.g(new androidx.emoji2.text.EmojiCompatInitializer.a(context0));
        this.d(context0);
        return true;
    }

    void d(Context context0) {
        androidx.lifecycle.h h0 = ((l)androidx.startup.a.e(context0).f(ProcessLifecycleInitializer.class)).o();
        h0.a(new androidx.lifecycle.c() {
            final EmojiCompatInitializer b;

            @Override  // androidx.lifecycle.e
            public void a(l l0) {
                EmojiCompatInitializer.this.e();
                h0.c(this);
            }

            @Override  // androidx.lifecycle.e
            public void b(l l0) {
            }

            @Override  // androidx.lifecycle.e
            public void c(l l0) {
            }

            @Override  // androidx.lifecycle.e
            public void e(l l0) {
            }

            @Override  // androidx.lifecycle.e
            public void f(l l0) {
            }

            @Override  // androidx.lifecycle.e
            public void g(l l0) {
            }
        });
    }

    void e() {
        androidx.emoji2.text.b.d().postDelayed(new androidx.emoji2.text.EmojiCompatInitializer.c(), 500L);
    }
}

