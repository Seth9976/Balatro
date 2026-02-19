package androidx.core.provider;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.core.graphics.i;
import androidx.core.util.c;

public abstract class g {
    public static class a {
        private final int a;
        private final b[] b;

        public a(int v, b[] arr_g$b) {
            this.a = v;
            this.b = arr_g$b;
        }

        static a a(int v, b[] arr_g$b) {
            return new a(v, arr_g$b);
        }

        public b[] b() {
            return this.b;
        }

        public int c() {
            return this.a;
        }
    }

    public static class b {
        private final Uri a;
        private final int b;
        private final int c;
        private final boolean d;
        private final int e;

        public b(Uri uri0, int v, int v1, boolean z, int v2) {
            this.a = (Uri)c.d(uri0);
            this.b = v;
            this.c = v1;
            this.d = z;
            this.e = v2;
        }

        static b a(Uri uri0, int v, int v1, boolean z, int v2) {
            return new b(uri0, v, v1, z, v2);
        }

        public int b() {
            return this.e;
        }

        public int c() {
            return this.b;
        }

        public Uri d() {
            return this.a;
        }

        public int e() {
            return this.c;
        }

        public boolean f() {
            return this.d;
        }
    }

    public static abstract class androidx.core.provider.g.c {
        public abstract void a(int arg1);

        public abstract void b(Typeface arg1);
    }

    public static Typeface a(Context context0, CancellationSignal cancellationSignal0, b[] arr_g$b) {
        return i.b(context0, cancellationSignal0, arr_g$b, 0);
    }

    public static a b(Context context0, CancellationSignal cancellationSignal0, e e0) {
        return d.e(context0, e0, cancellationSignal0);
    }

    public static Typeface c(Context context0, e e0, int v, boolean z, int v1, Handler handler0, androidx.core.provider.g.c g$c0) {
        androidx.core.provider.a a0 = new androidx.core.provider.a(g$c0, handler0);
        return z ? f.e(context0, e0, a0, v, v1) : f.d(context0, e0, v, null, a0);
    }
}

