package x2;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.provider.Settings.Secure;
import android.provider.Settings.SettingNotFoundException;
import g2.f;
import g2.h;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import w2.c;

public abstract class p0 {
    private static final k0 a;
    private static double b;
    private static int c;
    private static String d;
    private static String e;
    private static String f;

    static {
        p0.a = k0.f("p0");
        p0.d = null;
        p0.e = null;
        p0.f = null;
    }

    public static Set A() {
        Set set0 = new HashSet();
        set0.add("");
        set0.add("9774d56d682e549c");
        set0.add("unknown");
        set0.add("000000000000000");
        set0.add("Android");
        set0.add("DEFACE");
        set0.add("00000000-0000-0000-0000-000000000000");
        set0.add("0000-0000");
        return set0;
    }

    static Locale B(Configuration configuration0) {
        Locale locale0 = c0.d(configuration0);
        return locale0 == null ? c0.c(configuration0) : locale0;
    }

    static NetworkInfo C(Context context0) {
        return ((ConnectivityManager)context0.getSystemService("connectivity")).getActiveNetworkInfo();
    }

    public static String D(Context context0) {
        try {
            String s = (String)c0.f(p0.n(context0), "getId", null, new Object[0]);
            if(!p0.Y(s)) {
                return s;
            }
        }
        catch(Throwable unused_ex) {
        }
        return null;
    }

    public static String E(Context context0) {
        try {
            String s = u.a(context0);
            if(!p0.Y(s)) {
                return s;
            }
        }
        catch(Throwable unused_ex) {
        }
        return null;
    }

    static String F() {
        String s = i0.t().p().v;
        String s1 = p0.d;
        if(s1 != null) {
            return p0.e == null ? s : String.format("%s-%s/%s", s, s1, p0.e);
        }
        return s;
    }

    static UUID G(Context context0) {
        SharedPreferences sharedPreferences0 = context0.getSharedPreferences("pref-singular-id", 0);
        String s = sharedPreferences0.getString("singular-id", null);
        return s == null ? p0.e(sharedPreferences0) : UUID.fromString(s);
    }

    public static String H(Throwable throwable0) {
        StringWriter stringWriter0 = new StringWriter();
        throwable0.printStackTrace(new PrintWriter(stringWriter0));
        return stringWriter0.toString();
    }

    static String[] I() {
        return c0.e();
    }

    public static String J() {
        return p0.d;
    }

    static boolean K(c c0) {
        i0.t().B().getClass();
        return false;
    }

    static void L(Uri uri0) {
        String s = p0.f(uri0);
        if(s != null) {
            p0.K(new c(s, p0.g(uri0), false, uri0));
        }
    }

    public static long M(Context context0) {
        long v = p0.s(context0);
        try {
            SharedPreferences.Editor sharedPreferences$Editor0 = context0.getSharedPreferences("batch_send_id", 0).edit();
            sharedPreferences$Editor0.putLong("sendId", v + 1L);
            sharedPreferences$Editor0.commit();
        }
        catch(Throwable throwable0) {
            String s = p0.h(throwable0);
            p0.a.c(s);
        }
        return v + 1L;
    }

    private static long N(SharedPreferences sharedPreferences0, long v) {
        SharedPreferences.Editor sharedPreferences$Editor0 = sharedPreferences0.edit();
        sharedPreferences$Editor0.putLong("admon-event-index", v + 1L);
        sharedPreferences$Editor0.commit();
        return v + 1L;
    }

    private static long O(SharedPreferences sharedPreferences0, long v) {
        SharedPreferences.Editor sharedPreferences$Editor0 = sharedPreferences0.edit();
        sharedPreferences$Editor0.putLong("event-index", v + 1L);
        sharedPreferences$Editor0.commit();
        return v + 1L;
    }

    static boolean P(Context context0) {
        try {
            Settings.Secure.getInt(context0.getContentResolver(), "limit_ad_tracking");
            return true;
        }
        catch(Settings.SettingNotFoundException unused_ex) {
            return false;
        }
    }

    static boolean Q(Context context0) {
        try {
            if(Settings.Secure.getInt(context0.getContentResolver(), "limit_ad_tracking") != 0) {
                return true;
            }
        }
        catch(Settings.SettingNotFoundException unused_ex) {
        }
        return false;
    }

    static boolean R(Context context0) {
        NetworkInfo networkInfo0 = p0.C(context0);
        return networkInfo0 != null && networkInfo0.isConnected();
    }

    static boolean S(Context context0) {
        NetworkInfo networkInfo0 = p0.C(context0);
        return networkInfo0 != null && networkInfo0.isConnected() && networkInfo0.getType() == 0;
    }

    static boolean T(Context context0) {
        NetworkInfo networkInfo0 = p0.C(context0);
        return networkInfo0 != null && networkInfo0.isConnected() && networkInfo0.getType() == 1;
    }

    static boolean U(Uri uri0) {
        if(uri0 != null && i0.t() != null && i0.t().B() != null && i0.t().B().p != null && i0.t().B().p.size() != 0) {
            if(uri0.getScheme() == null) {
                uri0 = Uri.parse(("https://" + uri0.toString()));
            }
            return p0.d0(uri0, i0.t().B().p);
        }
        return false;
    }

    public static boolean V(String s) {
        return s == null || s.trim().length() == 0;
    }

    static boolean W(Context context0) {
        if(context0.getSharedPreferences("singular-first-install", 0).getBoolean("wasOpenedAfterInstall", false)) {
            return false;
        }
        p0.h0(context0);
        return true;
    }

    static boolean X() {
        return c0.a("com.google.android.gms.ads.identifier.AdvertisingIdClient") != null;
    }

    public static boolean Y(String s) {
        if(p0.V(s)) {
            return false;
        }
        Matcher matcher0 = Pattern.compile("^[0-]+$").matcher(s);
        return p0.A().contains(s) || matcher0.matches();
    }

    public static boolean Z(Context context0, String s) {
        return context0.getSharedPreferences("singular-licensing-api", 0).getBoolean(s, false);
    }

    public static boolean a0(Context context0) {
        try {
            return ((Boolean)c0.f(p0.n(context0), "isLimitAdTrackingEnabled", null, new Object[0])).booleanValue();
        }
        catch(Throwable unused_ex) {
            return false;
        }
    }

    static boolean b0() {
        return i0.t().B().n;
    }

    static boolean c() {
        i0.t().B().n = false;
        return false;
    }

    // 去混淆评级： 低(20)
    static boolean c0(Uri uri0) {
        return p0.U(uri0) || uri0.getHost() == null || uri0.getHost().endsWith("sng.link") ? p0.f(uri0) == null : false;
    }

    static String d(byte[] arr_b) {
        char[] arr_c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] arr_c1 = new char[arr_b.length * 2];
        for(int v = 0; v < arr_b.length; ++v) {
            int v1 = arr_b[v] & 0xFF;
            arr_c1[v * 2] = arr_c[v1 >>> 4];
            arr_c1[v * 2 + 1] = arr_c[v1 & 15];
        }
        return new String(arr_c1);
    }

    private static boolean d0(Uri uri0, List list0) {
        for(Object object0: list0) {
            if(uri0.getHost() != null && uri0.getHost().equals(((String)object0))) {
                return true;
            }
            if(false) {
                break;
            }
        }
        return false;
    }

    private static UUID e(SharedPreferences sharedPreferences0) {
        UUID uUID0 = UUID.randomUUID();
        SharedPreferences.Editor sharedPreferences$Editor0 = sharedPreferences0.edit();
        sharedPreferences$Editor0.putString("singular-id", uUID0.toString());
        sharedPreferences$Editor0.commit();
        return uUID0;
    }

    // 去混淆评级： 低(20)
    static double e0(long v) {
        return ((double)(1771482090537L - v)) * 0.001;
    }

    static String f(Uri uri0) {
        if(uri0 == null) {
            return null;
        }
        if(!p0.U(uri0) && uri0.getHost() != null && !uri0.getHost().endsWith("sng.link")) {
            return null;
        }
        String s = uri0.getQueryParameter("_android_dl");
        return s == null ? uri0.getQueryParameter("_dl") : s;
    }

    public static void f0(Context context0, String s) {
        context0.getSharedPreferences("pref_retry_count", 0).edit().remove("rc-" + s).commit();
    }

    static String g(Uri uri0) {
        return uri0.getQueryParameter("_p");
    }

    static Uri g0(Uri uri0) {
        try {
            URL uRL0 = new URL(uri0.toString());
            HttpURLConnection httpURLConnection0 = uRL0.getProtocol().equalsIgnoreCase("https") ? n0.d(uRL0) : n0.c(uRL0);
            httpURLConnection0.setInstanceFollowRedirects(false);
            httpURLConnection0.connect();
            String s = httpURLConnection0.getHeaderField("Location");
            return s == null ? null : Uri.parse(s);
        }
        catch(IOException unused_ex) {
            return null;
        }
    }

    public static String h(Throwable throwable0) {
        return "Exception: \n" + throwable0.getMessage() + "\nStack trace: \n" + p0.H(throwable0);
    }

    private static void h0(Context context0) {
        SharedPreferences.Editor sharedPreferences$Editor0 = context0.getSharedPreferences("singular-first-install", 0).edit();
        sharedPreferences$Editor0.putBoolean("wasOpenedAfterInstall", true);
        sharedPreferences$Editor0.commit();
    }

    static String i(long v) {
        return new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z").format(v);
    }

    public static void i0(Context context0, String s) {
        SharedPreferences.Editor sharedPreferences$Editor0 = context0.getSharedPreferences("singular-licensing-api", 0).edit();
        sharedPreferences$Editor0.putBoolean(s, true);
        sharedPreferences$Editor0.commit();
    }

    private static String j(String s) [...] // Inlined contents

    public static void j0(String s, Context context0, int v) {
        try {
            SharedPreferences.Editor sharedPreferences$Editor0 = context0.getSharedPreferences("pref_retry_count", 0).edit();
            sharedPreferences$Editor0.putInt("rc-" + s, v);
            sharedPreferences$Editor0.commit();
        }
        catch(Throwable throwable0) {
            String s1 = p0.h(throwable0);
            p0.a.c(s1);
        }
    }

    public static int k() [...] // 潜在的解密器

    public static void k0(String s) {
        p0.f = s;
    }

    public static double l() [...] // 潜在的解密器

    static String l0(String s, String s1) {
        try {
            MessageDigest messageDigest0 = MessageDigest.getInstance("SHA-1");
            messageDigest0.update(s1.getBytes("UTF-8"));
            messageDigest0.update(s.getBytes("UTF-8"));
            return p0.d(messageDigest0.digest());
        }
        catch(Throwable throwable0) {
            p0.a.d("error in sha1Hash()", throwable0);
            return null;
        }
    }

    static long m(Context context0) {
        SharedPreferences sharedPreferences0 = context0.getSharedPreferences("pref-admon-event-index", 0);
        return p0.N(sharedPreferences0, sharedPreferences0.getLong("admon-event-index", -1L));
    }

    static boolean m0(Uri uri0) {
        if(uri0 == null) {
            return false;
        }
        if(uri0.getScheme() == null) {
            uri0 = Uri.parse(("https://" + uri0.toString()));
        }
        return uri0.getHost() != null;
    }

    private static Object n(Context context0) {
        return c0.h("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", new Class[]{Context.class}, new Object[]{context0});
    }

    static String o(Context context0) {
        try {
            return Settings.Secure.getString(context0.getContentResolver(), "advertising_id");
        }
        catch(Throwable unused_ex) {
            return null;
        }
    }

    public static int p(Context context0, String s) {
        int v = context0.getSharedPreferences("pref_retry_count", 0).getInt("rc-" + s, 0);
        p0.j0(s, context0, v + 1);
        return v;
    }

    static String q(Context context0) {
        String s = Settings.Secure.getString(context0.getContentResolver(), "android_id");
        return p0.A().contains(s) ? "None" : s;
    }

    static String r(Context context0) {
        class a implements f {
            final BlockingQueue a;
            final long b;

            a(BlockingQueue blockingQueue0, long v) {
                this.b = v;
                super();
            }

            public void a(w0.c c0) {
                p0.c = c0.b();
                this.a.offer(c0.a());
                p0.b = p0.e0(this.b);
            }

            @Override  // g2.f
            public void e(Object object0) {
                this.a(((w0.c)object0));
            }
        }

        try {
            h h0 = w0.a.a(context0).b();
            LinkedBlockingQueue linkedBlockingQueue0 = new LinkedBlockingQueue();
            h0.g(new a(linkedBlockingQueue0, 0x19C748F8E0FL));
            String s = (String)linkedBlockingQueue0.poll(1L, TimeUnit.SECONDS);
            if(!p0.V(s)) {
                return s;
            }
        }
        catch(Throwable unused_ex) {
        }
        return null;
    }

    static long s(Context context0) {
        return context0.getSharedPreferences("batch_send_id", 0).getLong("sendId", 0L);
    }

    public static String t(Context context0) {
        return context0.getSharedPreferences("install-openUri", 0).getString("openUri", null);
    }

    static String u(Context context0) {
        if(p0.S(context0)) {
            return "wwan";
        }
        p0.T(context0);
        return "wifi";
    }

    // 去混淆评级： 低(20)
    static String v() [...] // 潜在的解密器

    public static long w() [...] // 潜在的解密器

    public static Method x(Object object0, String s, Class[] arr_class) {
        try {
            return object0.getClass().getDeclaredMethod(s, arr_class);
        }
        catch(NoSuchMethodException unused_ex) {
            p0.a.a("Method " + s + " was not found in " + (object0 == null ? null : object0.getClass().getName()));
            return null;
        }
        catch(SecurityException securityException0) {
            p0.a.b("Security violation occured ", new Object[]{securityException0});
            return null;
        }
    }

    static long y(Context context0) {
        SharedPreferences sharedPreferences0 = context0.getSharedPreferences("pref-event-index", 0);
        return p0.O(sharedPreferences0, sharedPreferences0.getLong("event-index", -1L));
    }

    public static String z() {
        return p0.f;
    }
}

