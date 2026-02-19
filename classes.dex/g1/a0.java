package g1;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.os.c;
import b1.b;
import c1.k;
import c1.n;
import java.util.Locale;
import k.g;
import l1.e;
import m1.d;

public abstract class a0 {
    private static final g a;
    private static Locale b;

    static {
        a0.a = new g();
    }

    public static String a(Context context0) {
        try {
            return d.a(context0).b("com.playstack.balatro.android").toString();
        }
        catch(PackageManager.NameNotFoundException | NullPointerException unused_ex) {
            String s = context0.getApplicationInfo().name;
            return TextUtils.isEmpty(s) ? "com.playstack.balatro.android" : s;
        }
    }

    public static String b(Context context0, int v) {
        Resources resources0 = context0.getResources();
        switch(v) {
            case 1: {
                return resources0.getString(b.d);
            }
            case 2: {
                return resources0.getString(b.j);
            }
            case 3: {
                return resources0.getString(b.a);
            }
            default: {
                return resources0.getString(0x104000A);
            }
        }
    }

    public static String c(Context context0, int v) {
        Resources resources0 = context0.getResources();
        String s = a0.a(context0);
        switch(v) {
            case 1: {
                return resources0.getString(b.e, new Object[]{s});
            }
            case 2: {
                return e.d(context0) ? resources0.getString(b.n) : resources0.getString(b.k, new Object[]{s});
            }
            case 3: {
                return resources0.getString(b.b, new Object[]{s});
            }
            case 5: {
                return a0.g(context0, "common_google_play_services_invalid_account_text", s);
            }
            case 7: {
                return a0.g(context0, "common_google_play_services_network_error_text", s);
            }
            case 9: {
                return resources0.getString(b.i, new Object[]{s});
            }
            case 16: {
                return a0.g(context0, "common_google_play_services_api_unavailable_text", s);
            }
            case 17: {
                return a0.g(context0, "common_google_play_services_sign_in_failed_text", s);
            }
            case 18: {
                return resources0.getString(b.m, new Object[]{s});
            }
            case 20: {
                return a0.g(context0, "common_google_play_services_restricted_profile_text", s);
            }
            default: {
                return resources0.getString(n.a, new Object[]{s});
            }
        }
    }

    public static String d(Context context0, int v) {
        return v == 6 || v == 19 ? a0.g(context0, "common_google_play_services_resolution_required_text", a0.a(context0)) : a0.c(context0, v);
    }

    public static String e(Context context0, int v) {
        String s = v == 6 ? a0.h(context0, "common_google_play_services_resolution_required_title") : a0.f(context0, v);
        return s == null ? context0.getResources().getString(b.h) : s;
    }

    public static String f(Context context0, int v) {
        String s;
        Resources resources0 = context0.getResources();
        switch(v) {
            case 1: {
                return resources0.getString(b.f);
            }
            case 2: {
                return resources0.getString(b.l);
            }
            case 3: {
                return resources0.getString(b.c);
            }
            case 5: {
                Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                return a0.h(context0, "common_google_play_services_invalid_account_title");
            }
            case 7: {
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return a0.h(context0, "common_google_play_services_network_error_title");
            }
            case 8: {
                s = "Internal error occurred. Please see logs for detailed information";
                break;
            }
            case 9: {
                s = "Google Play services is invalid. Cannot recover.";
                break;
            }
            case 10: {
                s = "Developer error occurred. Please see logs for detailed information";
                break;
            }
            case 11: {
                s = "The application is not licensed to the user.";
                break;
            }
            case 16: {
                s = "One of the API components you attempted to connect to is not available.";
                break;
            }
            case 17: {
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                return a0.h(context0, "common_google_play_services_sign_in_failed_title");
            }
            case 4: 
            case 6: 
            case 18: {
                return null;
            }
            case 20: {
                Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
                return a0.h(context0, "common_google_play_services_restricted_profile_title");
            }
            default: {
                s = "Unexpected error code " + v;
                break;
            }
        }
        Log.e("GoogleApiAvailability", s);
        return null;
    }

    private static String g(Context context0, String s, String s1) {
        Resources resources0 = context0.getResources();
        String s2 = a0.h(context0, s);
        if(s2 == null) {
            s2 = resources0.getString(n.a);
        }
        return String.format(resources0.getConfiguration().locale, s2, s1);
    }

    private static String h(Context context0, String s) {
        g g0 = a0.a;
        synchronized(g0) {
            Locale locale0 = c.a(context0.getResources().getConfiguration()).c(0);
            if(!locale0.equals(a0.b)) {
                g0.clear();
                a0.b = locale0;
            }
            String s1 = (String)g0.get(s);
            if(s1 != null) {
                return s1;
            }
            Resources resources0 = k.b(context0);
            if(resources0 == null) {
                return null;
            }
            int v1 = resources0.getIdentifier(s, "string", "com.google.android.gms");
            if(v1 == 0) {
                Log.w("GoogleApiAvailability", "Missing resource: " + s);
                return null;
            }
            String s2 = resources0.getString(v1);
            if(TextUtils.isEmpty(s2)) {
                Log.w("GoogleApiAvailability", "Got empty resource: " + s);
                return null;
            }
            g0.put(s, s2);
            return s2;
        }
    }
}

