package androidx.core.app;

import android.app.Notification.BigTextStyle;
import android.app.Notification.BubbleMetadata;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;

public abstract class f {
    public static class a {
        final Bundle a;
        private IconCompat b;
        private final g0[] c;
        private final g0[] d;
        private boolean e;
        boolean f;
        private final int g;
        private final boolean h;
        public int i;
        public CharSequence j;
        public PendingIntent k;
        private boolean l;

        public a(int v, CharSequence charSequence0, PendingIntent pendingIntent0) {
            this((v == 0 ? null : IconCompat.b(null, "", v)), charSequence0, pendingIntent0);
        }

        public a(IconCompat iconCompat0, CharSequence charSequence0, PendingIntent pendingIntent0) {
            this(iconCompat0, charSequence0, pendingIntent0, new Bundle(), null, null, true, 0, true, false, false);
        }

        a(IconCompat iconCompat0, CharSequence charSequence0, PendingIntent pendingIntent0, Bundle bundle0, g0[] arr_g0, g0[] arr_g01, boolean z, int v, boolean z1, boolean z2, boolean z3) {
            this.f = true;
            this.b = iconCompat0;
            if(iconCompat0 != null && iconCompat0.e() == 2) {
                this.i = iconCompat0.c();
            }
            this.j = d.d(charSequence0);
            this.k = pendingIntent0;
            if(bundle0 == null) {
                bundle0 = new Bundle();
            }
            this.a = bundle0;
            this.c = arr_g0;
            this.d = arr_g01;
            this.e = z;
            this.g = v;
            this.f = z1;
            this.h = z2;
            this.l = z3;
        }

        public PendingIntent a() {
            return this.k;
        }

        public boolean b() {
            return this.e;
        }

        public Bundle c() {
            return this.a;
        }

        public IconCompat d() {
            if(this.b == null) {
                int v = this.i;
                if(v != 0) {
                    this.b = IconCompat.b(null, "", v);
                }
            }
            return this.b;
        }

        public g0[] e() {
            return this.c;
        }

        public int f() {
            return this.g;
        }

        public boolean g() {
            return this.f;
        }

        public CharSequence h() {
            return this.j;
        }

        public boolean i() {
            return this.l;
        }

        public boolean j() {
            return this.h;
        }
    }

    public static class b extends e {
        private CharSequence e;

        @Override  // androidx.core.app.f$e
        public void a(Bundle bundle0) {
            super.a(bundle0);
        }

        @Override  // androidx.core.app.f$e
        public void b(androidx.core.app.e e0) {
            Notification.BigTextStyle notification$BigTextStyle0 = new Notification.BigTextStyle(e0.a()).setBigContentTitle(this.b).bigText(this.e);
            if(this.d) {
                notification$BigTextStyle0.setSummaryText(this.c);
            }
        }

        @Override  // androidx.core.app.f$e
        protected String c() {
            return "androidx.core.app.NotificationCompat$BigTextStyle";
        }

        public b h(CharSequence charSequence0) {
            this.e = d.d(charSequence0);
            return this;
        }
    }

    public static abstract class c {
        public static Notification.BubbleMetadata a(c f$c0) [...] // Inlined contents
    }

    public static class d {
        boolean A;
        boolean B;
        String C;
        Bundle D;
        int E;
        int F;
        Notification G;
        RemoteViews H;
        RemoteViews I;
        RemoteViews J;
        String K;
        int L;
        String M;
        long N;
        int O;
        int P;
        boolean Q;
        Notification R;
        boolean S;
        Icon T;
        public ArrayList U;
        public Context a;
        public ArrayList b;
        public ArrayList c;
        ArrayList d;
        CharSequence e;
        CharSequence f;
        PendingIntent g;
        PendingIntent h;
        RemoteViews i;
        Bitmap j;
        CharSequence k;
        int l;
        int m;
        boolean n;
        boolean o;
        e p;
        CharSequence q;
        CharSequence r;
        CharSequence[] s;
        int t;
        int u;
        boolean v;
        String w;
        boolean x;
        String y;
        boolean z;

        public d(Context context0) {
            this(context0, null);
        }

        public d(Context context0, String s) {
            this.b = new ArrayList();
            this.c = new ArrayList();
            this.d = new ArrayList();
            this.n = true;
            this.z = false;
            this.E = 0;
            this.F = 0;
            this.L = 0;
            this.O = 0;
            this.P = 0;
            Notification notification0 = new Notification();
            this.R = notification0;
            this.a = context0;
            this.K = s;
            notification0.when = System.currentTimeMillis();
            this.R.audioStreamType = -1;
            this.m = 0;
            this.U = new ArrayList();
            this.Q = true;
        }

        public d a(int v, CharSequence charSequence0, PendingIntent pendingIntent0) {
            this.b.add(new a(v, charSequence0, pendingIntent0));
            return this;
        }

        public Notification b() {
            return new z(this).c();
        }

        public Bundle c() {
            if(this.D == null) {
                this.D = new Bundle();
            }
            return this.D;
        }

        protected static CharSequence d(CharSequence charSequence0) {
            if(charSequence0 == null) {
                return null;
            }
            return charSequence0.length() <= 0x1400 ? charSequence0 : charSequence0.subSequence(0, 0x1400);
        }

        public d e(boolean z) {
            this.j(16, z);
            return this;
        }

        public d f(String s) {
            this.K = s;
            return this;
        }

        public d g(PendingIntent pendingIntent0) {
            this.g = pendingIntent0;
            return this;
        }

        public d h(CharSequence charSequence0) {
            this.f = d.d(charSequence0);
            return this;
        }

        public d i(CharSequence charSequence0) {
            this.e = d.d(charSequence0);
            return this;
        }

        private void j(int v, boolean z) {
            int v1;
            Notification notification0;
            if(z) {
                notification0 = this.R;
                v1 = v | notification0.flags;
            }
            else {
                notification0 = this.R;
                v1 = ~v & notification0.flags;
            }
            notification0.flags = v1;
        }

        public d k(boolean z) {
            this.z = z;
            return this;
        }

        public d l(int v) {
            this.m = v;
            return this;
        }

        public d m(int v) {
            this.R.icon = v;
            return this;
        }

        public d n(e f$e0) {
            if(this.p != f$e0) {
                this.p = f$e0;
                if(f$e0 != null) {
                    f$e0.g(this);
                }
            }
            return this;
        }

        public d o(CharSequence charSequence0) {
            Notification notification0 = this.R;
            notification0.tickerText = d.d(charSequence0);
            return this;
        }

        public d p(long v) {
            this.R.when = v;
            return this;
        }
    }

    public static abstract class e {
        protected d a;
        CharSequence b;
        CharSequence c;
        boolean d;

        public e() {
            this.d = false;
        }

        public void a(Bundle bundle0) {
            if(this.d) {
                bundle0.putCharSequence("android.summaryText", this.c);
            }
            CharSequence charSequence0 = this.b;
            if(charSequence0 != null) {
                bundle0.putCharSequence("android.title.big", charSequence0);
            }
            String s = this.c();
            if(s != null) {
                bundle0.putString("androidx.core.app.extra.COMPAT_TEMPLATE", s);
            }
        }

        public abstract void b(androidx.core.app.e arg1);

        protected abstract String c();

        public RemoteViews d(androidx.core.app.e e0) [...] // Inlined contents

        public RemoteViews e(androidx.core.app.e e0) [...] // Inlined contents

        public RemoteViews f(androidx.core.app.e e0) [...] // Inlined contents

        public void g(d f$d0) {
            if(this.a != f$d0) {
                this.a = f$d0;
                if(f$d0 != null) {
                    f$d0.n(this);
                }
            }
        }
    }

    public static Bundle a(Notification notification0) {
        return notification0.extras;
    }
}

