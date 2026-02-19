package androidx.loader.app;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.lifecycle.a0;
import androidx.lifecycle.c0;
import androidx.lifecycle.l;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import k.h;

class b extends a {
    public static class androidx.loader.app.b.a extends p implements y.b.a {
        private final int l;
        private final Bundle m;
        private final y.b n;
        private l o;
        private androidx.loader.app.b.b p;
        private y.b q;

        androidx.loader.app.b.a(int v, Bundle bundle0, y.b b0, y.b b1) {
            this.l = v;
            this.m = bundle0;
            this.n = b0;
            this.q = b1;
            b0.r(v, this);
        }

        @Override  // y.b$a
        public void a(y.b b0, Object object0) {
            if(b.c) {
                Log.v("LoaderManager", "onLoadComplete: " + this);
            }
            if(Looper.myLooper() == Looper.getMainLooper()) {
                this.n(object0);
                return;
            }
            if(b.c) {
                Log.w("LoaderManager", "onLoadComplete was incorrectly called on a background thread");
            }
            this.l(object0);
        }

        @Override  // androidx.lifecycle.LiveData
        protected void j() {
            if(b.c) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            this.n.u();
        }

        @Override  // androidx.lifecycle.LiveData
        protected void k() {
            if(b.c) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.n.v();
        }

        @Override  // androidx.lifecycle.LiveData
        public void m(q q0) {
            super.m(q0);
            this.o = null;
            this.p = null;
        }

        @Override  // androidx.lifecycle.p
        public void n(Object object0) {
            super.n(object0);
            y.b b0 = this.q;
            if(b0 != null) {
                b0.s();
                this.q = null;
            }
        }

        y.b o(boolean z) {
            if(b.c) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.n.b();
            this.n.a();
            androidx.loader.app.b.b b$b0 = this.p;
            if(b$b0 != null) {
                this.m(b$b0);
                if(z) {
                    b$b0.d();
                }
            }
            this.n.w(this);
            if(b$b0 != null && !b$b0.c() || z) {
                this.n.s();
                return this.q;
            }
            return this.n;
        }

        public void p(String s, FileDescriptor fileDescriptor0, PrintWriter printWriter0, String[] arr_s) {
            printWriter0.print(s);
            printWriter0.print("mId=");
            printWriter0.print(this.l);
            printWriter0.print(" mArgs=");
            printWriter0.println(this.m);
            printWriter0.print(s);
            printWriter0.print("mLoader=");
            printWriter0.println(this.n);
            this.n.g(s + "  ", fileDescriptor0, printWriter0, arr_s);
            if(this.p != null) {
                printWriter0.print(s);
                printWriter0.print("mCallbacks=");
                printWriter0.println(this.p);
                this.p.b(s + "  ", printWriter0);
            }
            printWriter0.print(s);
            printWriter0.print("mData=");
            printWriter0.println(this.q().d(this.f()));
            printWriter0.print(s);
            printWriter0.print("mStarted=");
            printWriter0.println(this.g());
        }

        y.b q() {
            return this.n;
        }

        void r() {
            l l0 = this.o;
            androidx.loader.app.b.b b$b0 = this.p;
            if(l0 != null && b$b0 != null) {
                super.m(b$b0);
                this.h(l0, b$b0);
            }
        }

        y.b s(l l0, androidx.loader.app.a.a a$a0) {
            androidx.loader.app.b.b b$b0 = new androidx.loader.app.b.b(this.n, a$a0);
            this.h(l0, b$b0);
            androidx.loader.app.b.b b$b1 = this.p;
            if(b$b1 != null) {
                this.m(b$b1);
            }
            this.o = l0;
            this.p = b$b0;
            return this.n;
        }

        @Override
        public String toString() {
            Class class0 = this.n.getClass();
            return "LoaderInfo{" + Integer.toHexString(System.identityHashCode(this)) + " #" + this.l + " : " + class0.getSimpleName() + "{" + Integer.toHexString(System.identityHashCode(class0)) + "}}";
        }
    }

    static class androidx.loader.app.b.b implements q {
        private final y.b a;
        private final androidx.loader.app.a.a b;
        private boolean c;

        androidx.loader.app.b.b(y.b b0, androidx.loader.app.a.a a$a0) {
            this.c = false;
            this.a = b0;
            this.b = a$a0;
        }

        @Override  // androidx.lifecycle.q
        public void a(Object object0) {
            if(b.c) {
                Log.v("LoaderManager", "  onLoadFinished in " + this.a + ": " + this.a.d(object0));
            }
            this.c = true;
            this.b.c(this.a, object0);
        }

        public void b(String s, PrintWriter printWriter0) {
            printWriter0.print(s);
            printWriter0.print("mDeliveredData=");
            printWriter0.println(this.c);
        }

        boolean c() {
            return this.c;
        }

        void d() {
            if(this.c) {
                if(b.c) {
                    Log.v("LoaderManager", "  Resetting: " + this.a);
                }
                this.b.a(this.a);
            }
        }

        @Override
        public String toString() {
            return this.b.toString();
        }
    }

    static class c extends y {
        static final class androidx.loader.app.b.c.a implements androidx.lifecycle.z.b {
            @Override  // androidx.lifecycle.z$b
            public y a(Class class0) {
                return new c();
            }

            @Override  // androidx.lifecycle.z$b
            public y b(Class class0, x.a a0) {
                return a0.b(this, class0, a0);
            }
        }

        private h d;
        private boolean e;
        private static final androidx.lifecycle.z.b f;

        static {
            c.f = new androidx.loader.app.b.c.a();
        }

        c() {
            this.d = new h();
            this.e = false;
        }

        @Override  // androidx.lifecycle.y
        protected void d() {
            super.d();
            int v = this.d.l();
            for(int v1 = 0; v1 < v; ++v1) {
                ((androidx.loader.app.b.a)this.d.m(v1)).o(true);
            }
            this.d.c();
        }

        public void e(String s, FileDescriptor fileDescriptor0, PrintWriter printWriter0, String[] arr_s) {
            if(this.d.l() > 0) {
                printWriter0.print(s);
                printWriter0.println("Loaders:");
                for(int v = 0; v < this.d.l(); ++v) {
                    androidx.loader.app.b.a b$a0 = (androidx.loader.app.b.a)this.d.m(v);
                    printWriter0.print(s);
                    printWriter0.print("  #");
                    printWriter0.print(this.d.j(v));
                    printWriter0.print(": ");
                    printWriter0.println(b$a0.toString());
                    b$a0.p(s + "    ", fileDescriptor0, printWriter0, arr_s);
                }
            }
        }

        void f() {
            this.e = false;
        }

        static c g(c0 c00) {
            return (c)new z(c00, c.f).a(c.class);
        }

        androidx.loader.app.b.a h(int v) {
            return (androidx.loader.app.b.a)this.d.g(v);
        }

        boolean i() {
            return this.e;
        }

        void j() {
            int v = this.d.l();
            for(int v1 = 0; v1 < v; ++v1) {
                ((androidx.loader.app.b.a)this.d.m(v1)).r();
            }
        }

        void k(int v, androidx.loader.app.b.a b$a0) {
            this.d.k(v, b$a0);
        }

        void l() {
            this.e = true;
        }
    }

    private final l a;
    private final c b;
    static boolean c;

    static {
    }

    b(l l0, c0 c00) {
        this.a = l0;
        this.b = c.g(c00);
    }

    @Override  // androidx.loader.app.a
    public void a(String s, FileDescriptor fileDescriptor0, PrintWriter printWriter0, String[] arr_s) {
        this.b.e(s, fileDescriptor0, printWriter0, arr_s);
    }

    @Override  // androidx.loader.app.a
    public y.b c(int v, Bundle bundle0, androidx.loader.app.a.a a$a0) {
        if(this.b.i()) {
            throw new IllegalStateException("Called while creating a loader");
        }
        if(Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("initLoader must be called on the main thread");
        }
        androidx.loader.app.b.a b$a0 = this.b.h(v);
        if(b.c) {
            Log.v("LoaderManager", "initLoader in " + this + ": args=" + bundle0);
        }
        if(b$a0 == null) {
            return this.e(v, bundle0, a$a0, null);
        }
        if(b.c) {
            Log.v("LoaderManager", "  Re-using existing loader " + b$a0);
        }
        return b$a0.s(this.a, a$a0);
    }

    @Override  // androidx.loader.app.a
    public void d() {
        this.b.j();
    }

    private y.b e(int v, Bundle bundle0, androidx.loader.app.a.a a$a0, y.b b0) {
        try {
            this.b.l();
            y.b b1 = a$a0.b(v, bundle0);
            if(b1 != null) {
                if(b1.getClass().isMemberClass() && !Modifier.isStatic(b1.getClass().getModifiers())) {
                    throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + b1);
                }
                androidx.loader.app.b.a b$a0 = new androidx.loader.app.b.a(v, bundle0, b1, b0);
                if(b.c) {
                    Log.v("LoaderManager", "  Created new loader " + b$a0);
                }
                this.b.k(v, b$a0);
                return b$a0.s(this.a, a$a0);
            }
        }
        finally {
            this.b.f();
        }
        throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
    }

    @Override
    public String toString() {
        Class class0 = this.a.getClass();
        return "LoaderManager{" + Integer.toHexString(System.identityHashCode(this)) + " in " + class0.getSimpleName() + "{" + Integer.toHexString(System.identityHashCode(class0)) + "}}";
    }
}

