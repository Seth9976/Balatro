package x2;

import android.content.Context;
import android.content.pm.InstallSourceInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.webkit.WebSettings;
import java.util.Locale;

class t {
    String A;
    String B;
    String C;
    String D;
    String E;
    String F;
    String G;
    String H;
    String I;
    String J;
    String K;
    String L;
    String M;
    String N;
    String O;
    long P;
    long Q;
    String R;
    String S;
    private static final k0 T;
    String a;
    String b;
    String c;
    String d;
    String e;
    boolean f;
    boolean g;
    String h;
    boolean i;
    boolean j;
    e0 k;
    String l;
    String m;
    String n;
    String o;
    String p;
    String q;
    String r;
    String s;
    String t;
    String u;
    String v;
    String w;
    String x;
    String y;
    Locale z;

    static {
        t.T = k0.f("t");
    }

    t(Context context0, boolean z, Boolean boolean0) {
        this.o(context0);
        this.t(context0);
        Resources resources0 = context0.getResources();
        DisplayMetrics displayMetrics0 = resources0.getDisplayMetrics();
        Configuration configuration0 = resources0.getConfiguration();
        Locale locale0 = p0.B(configuration0);
        this.z = locale0;
        this.A = locale0.getLanguage();
        this.B = this.z.getCountry();
        int v = configuration0.screenLayout;
        this.C = this.l(v);
        this.D = this.k(v);
        this.y = this.d(v);
        this.E = this.j(displayMetrics0);
        this.F = this.g(displayMetrics0);
        this.G = this.f(displayMetrics0);
        this.f = p0.X();
        if(!boolean0.booleanValue()) {
            if(this.f) {
                this.g = p0.a0(context0);
                this.b = p0.D(context0);
            }
            if(p0.V(this.b)) {
                this.b = p0.E(context0);
            }
            this.a = p0.q(context0);
            this.s(p0.z());
        }
        if(z) {
            this.d = z.f(context0);
        }
        boolean z1 = p0.P(context0);
        this.i = z1;
        if(z1) {
            this.j = p0.Q(context0);
            this.h = p0.o(context0);
        }
        e0 e00 = new e0();
        this.k = e00;
        e00.d(context0);
        this.e = p0.r(context0);
        this.L = this.h(context0);
        this.q(context0.getSharedPreferences("singular-pref-session", 0).getString("fcm_device_token_key", ""));
        this.r(context0.getSharedPreferences("singular-pref-session", 0).getString("gcm_device_token_key", ""));
        this.i(context0);
        this.p(context0.getSharedPreferences("singular-pref-session", 0).getString("custom_user_id", ""));
        this.S = this.e(context0);
        this.n();
    }

    // 去混淆评级： 低(30)
    private String a() [...] // 潜在的解密器

    private String b(Context context0) {
        try {
            PackageManager packageManager0 = context0.getPackageManager();
            return packageManager0.getApplicationLabel(packageManager0.getApplicationInfo("com.playstack.balatro.android", 0x80)).toString();
        }
        catch(Throwable unused_ex) {
            return "unknown";
        }
    }

    private String c(Context context0) {
        try {
            PackageInfo packageInfo0 = context0.getPackageManager().getPackageInfo("com.playstack.balatro.android", 0);
            return TextUtils.isEmpty(packageInfo0.versionName) ? "unknown" : packageInfo0.versionName;
        }
        catch(Throwable unused_ex) {
            return "unknown";
        }
    }

    private String d(int v) {
        switch(v & 15) {
            case 1: 
            case 2: {
                return "phone";
            }
            case 3: 
            case 4: {
                return "tablet";
            }
            default: {
                return null;
            }
        }
    }

    private String e(Context context0) {
        if(TextUtils.isEmpty("Dalvik/2.1.0 (Linux; U; Android 13; Pixel 4a Build/TQ3A.230805.001.S2)")) {
            try {
                Class.forName("android.os.AsyncTask");
                return WebSettings.getDefaultUserAgent(context0);
            }
            catch(VerifyError | Throwable unused_ex) {
            }
        }
        return "Dalvik/2.1.0 (Linux; U; Android 13; Pixel 4a Build/TQ3A.230805.001.S2)";
    }

    private String f(DisplayMetrics displayMetrics0) {
        return String.valueOf(displayMetrics0.heightPixels);
    }

    private String g(DisplayMetrics displayMetrics0) {
        return String.valueOf(displayMetrics0.widthPixels);
    }

    private String h(Context context0) {
        String s;
        try {
            PackageManager packageManager0 = context0.getPackageManager();
            if(Build.VERSION.SDK_INT < 30) {
                s = packageManager0.getInstallerPackageName("com.playstack.balatro.android");
                this.L = s;
                return this.L;
            }
            InstallSourceInfo installSourceInfo0 = packageManager0.getInstallSourceInfo("com.playstack.balatro.android");
            if(installSourceInfo0 != null) {
                s = installSourceInfo0.getInitiatingPackageName();
                this.L = s;
                return this.L;
            }
            return this.L;
        }
        catch(Throwable unused_ex) {
            return null;
        }
    }

    private void i(Context context0) {
        try {
            PackageInfo packageInfo0 = context0.getPackageManager().getPackageInfo("com.playstack.balatro.android", 0);
            this.P = packageInfo0.firstInstallTime;
            this.Q = packageInfo0.lastUpdateTime;
        }
        catch(PackageManager.NameNotFoundException runtimeException0) {
            t.T.d("getInstallDates failed", runtimeException0);
        }
        catch(RuntimeException unused_ex) {
        }
    }

    private String j(DisplayMetrics displayMetrics0) {
        int v = displayMetrics0.densityDpi;
        if(v == 0) {
            return null;
        }
        if(v < 140) {
            return "low";
        }
        return v <= 200 ? "medium" : "high";
    }

    private String k(int v) {
        switch(v & 0x30) {
            case 16: {
                return "normal";
            }
            case 0x20: {
                return "long";
            }
            default: {
                return null;
            }
        }
    }

    private String l(int v) {
        switch(v & 15) {
            case 1: {
                return "small";
            }
            case 2: {
                return "normal";
            }
            case 3: {
                return "large";
            }
            case 4: {
                return "xlarge";
            }
            default: {
                return null;
            }
        }
    }

    // 去混淆评级： 低(30)
    public boolean m() {
        return !p0.V(this.M) && !p0.V(this.N) && !p0.V(this.O);
    }

    void n() {
        k0 k00 = t.T;
        if(!k00.i()) {
            return;
        }
        k00.a("DeviceInfo ----> ");
        k00.b("\t imei : %s", new Object[]{this.c});
        k00.b("\t andi : %s", new Object[]{this.a});
        k00.b("\t asid : %s", new Object[]{this.e});
        k00.b("\t aifa : %s", new Object[]{this.b});
        k00.b("\t sdid : %s", new Object[]{(this.k == null ? "" : this.k.c())});
        k00.b("\t isGooglePlayServicesAvailable : %b", new Object[]{Boolean.valueOf(this.f)});
        k00.b("\t isLimitedTrackingEnabled : %b", new Object[]{Boolean.valueOf(this.g)});
        k00.b("\t appVersion : %s", new Object[]{this.m});
        k00.b("\t sdkVersion : %s", new Object[]{this.v});
        k00.b("\t packageName : %s", new Object[]{this.p});
        k00.b("\t appName : %s", new Object[]{this.s});
        k00.b("\t preloadCampaign : %s", new Object[]{this.M});
        k00.b("\t preloadGroup : %s", new Object[]{this.N});
        k00.b("\t preloadSource : %s", new Object[]{this.O});
        k00.b("\t installSource : %s", new Object[]{this.L});
        k00.b("\t abi : %s", new Object[]{this.l});
        k00.b("\t deviceBrand : %s", new Object[]{this.n});
        k00.b("\t deviceBuild : %s", new Object[]{this.o});
        k00.b("\t deviceManufacturer : %s", new Object[]{this.q});
        k00.b("\t deviceModel : %s", new Object[]{this.r});
        k00.b("\t platform : %s", new Object[]{this.t});
        k00.b("\t buildProduct : %s", new Object[]{this.u});
        k00.b("\t osVersion : %s", new Object[]{this.w});
        k00.b("\t apiLevel : %s", new Object[]{this.x});
        k00.b("\t hardwareName : %s", new Object[]{this.H});
        k00.b("\t locale : %s", new Object[]{this.z});
        k00.b("\t language : %s", new Object[]{this.A});
        k00.b("\t country : %s", new Object[]{this.B});
        k00.b("\t screenSize : %s", new Object[]{this.C});
        k00.b("\t screenFormat : %s", new Object[]{this.D});
        k00.b("\t screenDensity : %s", new Object[]{this.E});
        k00.b("\t displayWidth : %s", new Object[]{this.F});
        k00.b("\t displayHeight : %s", new Object[]{this.G});
        k00.b("\t gcmProcessId : %s", new Object[]{this.I});
        k00.b("\t gcmRegId : %s", new Object[]{this.J});
        k00.b("\t fcmRegId : %s", new Object[]{this.K});
        k00.b("\t firstInstallTime : %d", new Object[]{this.P});
        k00.b("\t lastUpdateTime : %d", new Object[]{this.Q});
        k00.b("\t deviceType : %s", new Object[]{this.y});
        k00.b("\t customUserId : %s", new Object[]{this.R});
        k00.b("\t deviceUserAgent: %s", new Object[]{this.S});
    }

    private void o(Context context0) {
        this.l = "arm64-v8a";
        this.n = Build.BRAND;
        this.o = Build.DEVICE;
        this.p = "com.playstack.balatro.android";
        this.q = Build.MANUFACTURER;
        this.r = Build.MODEL;
        this.t = "Android";
        this.u = Build.PRODUCT;
        this.w = Build.VERSION.RELEASE;
        this.H = Build.DISPLAY;
        this.v = "Singular/v12.5.6";
        this.s = this.b(context0);
        this.m = this.c(context0);
        this.x = "33";
    }

    void p(String s) {
        this.R = s;
    }

    void q(String s) {
        this.K = s;
    }

    void r(String s) {
        this.J = s;
    }

    void s(String s) {
        this.c = s;
    }

    private void t(Context context0) {
        try {
            Bundle bundle0 = context0.getPackageManager().getApplicationInfo("com.playstack.balatro.android", 0x80).metaData;
            this.M = bundle0.getString("SINGULAR_PRELOAD_CAMPAIGN");
            this.N = bundle0.getString("SINGULAR_PRELOAD_GROUP");
            this.O = bundle0.getString("SINGULAR_PRELOAD_SOURCE");
        }
        catch(Throwable throwable0) {
            t.T.d("error in setPreloadCampaign()", throwable0);
        }
    }
}

