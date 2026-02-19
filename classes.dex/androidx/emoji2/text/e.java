package androidx.emoji2.text;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class e {
    static final class a extends b {
        private volatile h b;
        private volatile m c;

        a(e e0) {
            super(e0);
        }

        @Override  // androidx.emoji2.text.e$b
        void a() {
            class androidx.emoji2.text.e.a.a extends androidx.emoji2.text.e.h {
                final a a;

                @Override  // androidx.emoji2.text.e$h
                public void a(Throwable throwable0) {
                    a.this.a.m(throwable0);
                }

                @Override  // androidx.emoji2.text.e$h
                public void b(m m0) {
                    a.this.d(m0);
                }
            }

            try {
                androidx.emoji2.text.e.a.a e$a$a0 = new androidx.emoji2.text.e.a.a(this);
                this.a.f.a(e$a$a0);
            }
            catch(Throwable throwable0) {
                this.a.m(throwable0);
            }
        }

        @Override  // androidx.emoji2.text.e$b
        CharSequence b(CharSequence charSequence0, int v, int v1, int v2, boolean z) {
            return this.b.h(charSequence0, v, v1, v2, z);
        }

        @Override  // androidx.emoji2.text.e$b
        void c(EditorInfo editorInfo0) {
            editorInfo0.extras.putInt("android.support.text.emoji.emojiCompat_metadataVersion", this.c.e());
            editorInfo0.extras.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", this.a.g);
        }

        void d(m m0) {
            if(m0 == null) {
                IllegalArgumentException illegalArgumentException0 = new IllegalArgumentException("metadataRepo cannot be null");
                this.a.m(illegalArgumentException0);
                return;
            }
            this.c = m0;
            this.b = new h(this.c, new i(), this.a.m, this.a.h, this.a.i);
            this.a.n();
        }
    }

    static abstract class b {
        final e a;

        b(e e0) {
            this.a = e0;
        }

        abstract void a();

        abstract CharSequence b(CharSequence arg1, int arg2, int arg3, int arg4, boolean arg5);

        abstract void c(EditorInfo arg1);
    }

    public static abstract class c {
        final g a;
        boolean b;
        boolean c;
        int[] d;
        Set e;
        boolean f;
        int g;
        int h;
        d i;

        protected c(g e$g0) {
            this.g = 0xFF00FF00;
            this.h = 0;
            this.i = new androidx.emoji2.text.d();
            androidx.core.util.c.e(e$g0, "metadataLoader cannot be null.");
            this.a = e$g0;
        }

        protected final g a() {
            return this.a;
        }

        public c b(int v) {
            this.h = v;
            return this;
        }
    }

    public interface d {
        boolean a(CharSequence arg1, int arg2, int arg3, int arg4);
    }

    public static abstract class androidx.emoji2.text.e.e {
        public void a(Throwable throwable0) {
        }

        public void b() {
        }
    }

    static class f implements Runnable {
        private final List e;
        private final Throwable f;
        private final int g;

        f(androidx.emoji2.text.e.e e$e0, int v) {
            this(Arrays.asList(new androidx.emoji2.text.e.e[]{((androidx.emoji2.text.e.e)androidx.core.util.c.e(e$e0, "initCallback cannot be null"))}), v, null);
        }

        f(Collection collection0, int v) {
            this(collection0, v, null);
        }

        f(Collection collection0, int v, Throwable throwable0) {
            androidx.core.util.c.e(collection0, "initCallbacks cannot be null");
            this.e = new ArrayList(collection0);
            this.g = v;
            this.f = throwable0;
        }

        @Override
        public void run() {
            int v = this.e.size();
            int v1 = 0;
            if(this.g != 1) {
                while(v1 < v) {
                    ((androidx.emoji2.text.e.e)this.e.get(v1)).a(this.f);
                    ++v1;
                }
                return;
            }
            while(v1 < v) {
                ((androidx.emoji2.text.e.e)this.e.get(v1)).b();
                ++v1;
            }
        }
    }

    public interface g {
        void a(androidx.emoji2.text.e.h arg1);
    }

    public static abstract class androidx.emoji2.text.e.h {
        public abstract void a(Throwable arg1);

        public abstract void b(m arg1);
    }

    static class i {
        androidx.emoji2.text.i a(androidx.emoji2.text.g g0) {
            return new o(g0);
        }
    }

    private final ReadWriteLock a;
    private final Set b;
    private volatile int c;
    private final Handler d;
    private final b e;
    final g f;
    final boolean g;
    final boolean h;
    final int[] i;
    private final boolean j;
    private final int k;
    private final int l;
    private final d m;
    private static final Object n;
    private static final Object o;
    private static volatile e p;

    static {
        e.n = new Object();
        e.o = new Object();
    }

    private e(c e$c0) {
        this.a = new ReentrantReadWriteLock();
        this.c = 3;
        this.g = e$c0.b;
        this.h = e$c0.c;
        this.i = e$c0.d;
        this.j = e$c0.f;
        this.k = e$c0.g;
        this.f = e$c0.a;
        this.l = e$c0.h;
        this.m = e$c0.i;
        this.d = new Handler(Looper.getMainLooper());
        k.b b0 = new k.b();
        this.b = b0;
        if(e$c0.e != null && !e$c0.e.isEmpty()) {
            b0.addAll(e$c0.e);
        }
        this.e = new a(this);
        this.l();
    }

    public static e b() {
        synchronized(e.n) {
            e e0 = e.p;
            androidx.core.util.c.f(e0 != null, "EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK\'s manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
            return e0;
        }
    }

    public int c() {
        return this.k;
    }

    public int d() {
        this.a.readLock().lock();
        int v = this.c;
        this.a.readLock().unlock();
        return v;
    }

    public static boolean e(InputConnection inputConnection0, Editable editable0, int v, int v1, boolean z) {
        return h.c(inputConnection0, editable0, v, v1, z);
    }

    public static boolean f(Editable editable0, int v, KeyEvent keyEvent0) {
        return h.d(editable0, v, keyEvent0);
    }

    public static e g(c e$c0) {
        e e0 = e.p;
        if(e0 == null) {
            synchronized(e.n) {
                e0 = e.p;
                if(e0 == null) {
                    e0 = new e(e$c0);
                    e.p = e0;
                }
                return e0;
            }
        }
        return e0;
    }

    public static boolean h() [...] // 潜在的解密器

    public boolean i() {
        return this.j;
    }

    private boolean j() {
        return this.d() == 1;
    }

    public void k() {
        androidx.core.util.c.f(this.l == 1, "Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        if(this.j()) {
            return;
        }
        this.a.writeLock().lock();
        if(this.c == 0) {
            this.a.writeLock().unlock();
            return;
        }
        this.c = 0;
        this.a.writeLock().unlock();
        this.e.a();
    }

    private void l() {
        this.a.writeLock().lock();
        if(this.l == 0) {
            this.c = 0;
        }
        this.a.writeLock().unlock();
        if(this.d() == 0) {
            this.e.a();
        }
    }

    void m(Throwable throwable0) {
        ArrayList arrayList0 = new ArrayList();
        this.a.writeLock().lock();
        try {
            this.c = 2;
            arrayList0.addAll(this.b);
            this.b.clear();
        }
        finally {
            this.a.writeLock().unlock();
        }
        f e$f0 = new f(arrayList0, this.c, throwable0);
        this.d.post(e$f0);
    }

    void n() {
        ArrayList arrayList0 = new ArrayList();
        this.a.writeLock().lock();
        try {
            this.c = 1;
            arrayList0.addAll(this.b);
            this.b.clear();
        }
        finally {
            this.a.writeLock().unlock();
        }
        f e$f0 = new f(arrayList0, this.c);
        this.d.post(e$f0);
    }

    public CharSequence o(CharSequence charSequence0) {
        return charSequence0 == null ? this.p(null, 0, 0) : this.p(charSequence0, 0, charSequence0.length());
    }

    public CharSequence p(CharSequence charSequence0, int v, int v1) {
        return this.q(charSequence0, v, v1, 0x7FFFFFFF);
    }

    public CharSequence q(CharSequence charSequence0, int v, int v1, int v2) {
        return this.r(charSequence0, v, v1, v2, 0);
    }

    public CharSequence r(CharSequence charSequence0, int v, int v1, int v2, int v3) {
        androidx.core.util.c.f(this.j(), "Not initialized yet");
        androidx.core.util.c.c(v, "start cannot be negative");
        androidx.core.util.c.c(v1, "end cannot be negative");
        androidx.core.util.c.c(v2, "maxEmojiCount cannot be negative");
        boolean z = false;
        androidx.core.util.c.a(v <= v1, "start should be <= than end");
        if(charSequence0 == null) {
            return null;
        }
        androidx.core.util.c.a(v <= charSequence0.length(), "start should be < than charSequence length");
        androidx.core.util.c.a(v1 <= charSequence0.length(), "end should be < than charSequence length");
        if(charSequence0.length() != 0 && v != v1) {
            switch(v3) {
                case 1: {
                    return this.e.b(charSequence0, v, v1, v2, true);
                }
                case 2: {
                    break;
                }
                default: {
                    z = this.g;
                    break;
                }
            }
            return this.e.b(charSequence0, v, v1, v2, z);
        }
        return charSequence0;
    }

    public void s(androidx.emoji2.text.e.e e$e0) {
        androidx.core.util.c.e(e$e0, "initCallback cannot be null");
        this.a.writeLock().lock();
        try {
            if(this.c == 1 || this.c == 2) {
                f e$f0 = new f(e$e0, this.c);
                this.d.post(e$f0);
            }
            else {
                this.b.add(e$e0);
            }
        }
        finally {
            this.a.writeLock().unlock();
        }
    }

    public void t(androidx.emoji2.text.e.e e$e0) {
        androidx.core.util.c.e(e$e0, "initCallback cannot be null");
        this.a.writeLock().lock();
        try {
            this.b.remove(e$e0);
        }
        finally {
            this.a.writeLock().unlock();
        }
    }

    public void u(EditorInfo editorInfo0) {
        if(this.j() && editorInfo0 != null) {
            if(editorInfo0.extras == null) {
                editorInfo0.extras = new Bundle();
            }
            this.e.c(editorInfo0);
        }
    }
}

