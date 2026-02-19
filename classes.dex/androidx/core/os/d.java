package androidx.core.os;

import android.os.Build.VERSION;
import android.os.LocaleList;
import java.util.Locale;

public final class d {
    static abstract class a {
        static LocaleList a(Locale[] arr_locale) {
            return new LocaleList(arr_locale);
        }

        static LocaleList b() {
            return LocaleList.getAdjustedDefault();
        }

        static LocaleList c() {
            return LocaleList.getDefault();
        }
    }

    private final f a;
    private static final d b;

    static {
        d.b = d.a(new Locale[0]);
    }

    private d(f f0) {
        this.a = f0;
    }

    public static d a(Locale[] arr_locale) {
        return Build.VERSION.SDK_INT < 24 ? new d(new e(arr_locale)) : d.d(a.a(arr_locale));
    }

    static Locale b(String s) {
        if(s.contains("-")) {
            String[] arr_s = s.split("-", -1);
            if(arr_s.length > 2) {
                return new Locale(arr_s[0], arr_s[1], arr_s[2]);
            }
            if(arr_s.length > 1) {
                return new Locale(arr_s[0], arr_s[1]);
            }
            if(arr_s.length != 1) {
                throw new IllegalArgumentException("Can not parse language tag: [" + s + "]");
            }
            return new Locale(arr_s[0]);
        }
        if(s.contains("_")) {
            String[] arr_s1 = s.split("_", -1);
            if(arr_s1.length > 2) {
                return new Locale(arr_s1[0], arr_s1[1], arr_s1[2]);
            }
            if(arr_s1.length > 1) {
                return new Locale(arr_s1[0], arr_s1[1]);
            }
            if(arr_s1.length != 1) {
                throw new IllegalArgumentException("Can not parse language tag: [" + s + "]");
            }
            return new Locale(arr_s1[0]);
        }
        return new Locale(s);
    }

    public Locale c(int v) {
        return this.a.get(v);
    }

    public static d d(LocaleList localeList0) {
        return new d(new l(localeList0));
    }

    // 去混淆评级： 低(20)
    @Override
    public boolean equals(Object object0) {
        return object0 instanceof d && this.a.equals(((d)object0).a);
    }

    @Override
    public int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public String toString() {
        return this.a.toString();
    }
}

