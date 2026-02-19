package f0;

import android.util.Log;

public abstract class a {
    public static void a(String s, String s1) {
        if(Log.isLoggable(s, 2)) {
            Log.v(s, s1);
        }
    }

    public static void b(String s, String s1) {
        if(Log.isLoggable(s, 5)) {
            Log.w(s, s1);
        }
    }
}

