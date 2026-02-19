package androidx.core.os;

import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.LocaleList;
import java.util.Locale;

public abstract class c {
    static abstract class a {
        static LocaleList a(Configuration configuration0) {
            return configuration0.getLocales();
        }
    }

    public static d a(Configuration configuration0) {
        return Build.VERSION.SDK_INT < 24 ? d.a(new Locale[]{configuration0.locale}) : d.d(a.a(configuration0));
    }
}

