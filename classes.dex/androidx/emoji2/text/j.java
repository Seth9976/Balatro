package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.os.Handler;
import androidx.core.graphics.p;
import androidx.core.os.m;
import androidx.core.provider.e;
import androidx.core.provider.g.b;
import androidx.core.provider.g;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

public class j extends c {
    public static class a {
        public Typeface a(Context context0, b g$b0) {
            return g.a(context0, null, new b[]{g$b0});
        }

        public androidx.core.provider.g.a b(Context context0, e e0) {
            return g.b(context0, null, e0);
        }

        public void c(Context context0, ContentObserver contentObserver0) {
            context0.getContentResolver().unregisterContentObserver(contentObserver0);
        }
    }

    static class androidx.emoji2.text.j.b implements androidx.emoji2.text.e.g {
        private final Context a;
        private final e b;
        private final a c;
        private final Object d;
        private Handler e;
        private Executor f;
        private ThreadPoolExecutor g;
        h h;
        private ContentObserver i;
        private Runnable j;

        androidx.emoji2.text.j.b(Context context0, e e0, a j$a0) {
            this.d = new Object();
            androidx.core.util.c.e(context0, "Context cannot be null");
            androidx.core.util.c.e(e0, "FontRequest cannot be null");
            this.a = context0.getApplicationContext();
            this.b = e0;
            this.c = j$a0;
        }

        @Override  // androidx.emoji2.text.e$g
        public void a(h e$h0) {
            androidx.core.util.c.e(e$h0, "LoaderCallback cannot be null");
            synchronized(this.d) {
                this.h = e$h0;
            }
            this.d();
        }

        private void b() {
            synchronized(this.d) {
                this.h = null;
                ContentObserver contentObserver0 = this.i;
                if(contentObserver0 != null) {
                    this.c.c(this.a, contentObserver0);
                    this.i = null;
                }
                Handler handler0 = this.e;
                if(handler0 != null) {
                    handler0.removeCallbacks(this.j);
                }
                this.e = null;
                ThreadPoolExecutor threadPoolExecutor0 = this.g;
                if(threadPoolExecutor0 != null) {
                    threadPoolExecutor0.shutdown();
                }
                this.f = null;
                this.g = null;
            }
        }

        // 检测为 Lambda 实现
        void c() [...]

        void d() {
            synchronized(this.d) {
                if(this.h == null) {
                    return;
                }
                if(this.f == null) {
                    ThreadPoolExecutor threadPoolExecutor0 = androidx.emoji2.text.b.b("emojiCompat");
                    this.g = threadPoolExecutor0;
                    this.f = threadPoolExecutor0;
                }
                this.f.execute(() -> {
                    synchronized(this.d) {
                        if(this.h == null) {
                            return;
                        }
                    }
                    try {
                        b g$b0 = this.e();
                        int v = g$b0.b();
                        if(v != 0) {
                            throw new RuntimeException("fetchFonts result is not OK. (" + v + ")");
                        }
                        try {
                            m.a("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                            Typeface typeface0 = this.c.a(this.a, g$b0);
                            ByteBuffer byteBuffer0 = p.f(this.a, null, g$b0.d());
                            if(byteBuffer0 != null && typeface0 != null) {
                                androidx.emoji2.text.m m0 = androidx.emoji2.text.m.b(typeface0, byteBuffer0);
                                synchronized(this.d) {
                                    h e$h0 = this.h;
                                    if(e$h0 != null) {
                                        e$h0.b(m0);
                                    }
                                }
                                this.b();
                                return;
                            }
                        }
                        finally {
                            m.b();
                        }
                        throw new RuntimeException("Unable to open file.");
                    }
                    catch(Throwable throwable0) {
                        synchronized(this.d) {
                            h e$h1 = this.h;
                            if(e$h1 != null) {
                                e$h1.a(throwable0);
                            }
                        }
                        this.b();
                    }
                });
            }
        }

        private b e() {
            androidx.core.provider.g.a g$a0;
            try {
                g$a0 = this.c.b(this.a, this.b);
            }
            catch(PackageManager.NameNotFoundException packageManager$NameNotFoundException0) {
                throw new RuntimeException("provider not found", packageManager$NameNotFoundException0);
            }
            if(g$a0.c() != 0) {
                throw new RuntimeException("fetchFonts failed (" + g$a0.c() + ")");
            }
            b[] arr_g$b = g$a0.b();
            if(arr_g$b == null || arr_g$b.length == 0) {
                throw new RuntimeException("fetchFonts failed (empty result)");
            }
            return arr_g$b[0];
        }

        public void f(Executor executor0) {
            synchronized(this.d) {
                this.f = executor0;
            }
        }
    }

    private static final a j;

    static {
        j.j = new a();
    }

    public j(Context context0, e e0) {
        super(new androidx.emoji2.text.j.b(context0, e0, j.j));
    }

    public j c(Executor executor0) {
        ((androidx.emoji2.text.j.b)this.a()).f(executor0);
        return this;
    }
}

