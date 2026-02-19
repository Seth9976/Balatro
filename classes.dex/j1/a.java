package j1;

import android.util.Log;
import g1.j;
import java.util.Locale;

public class a {
    private final String a;
    private final String b;
    private final j c;
    private final int d;

    public a(String s, String[] arr_s) {
        String s1;
        if(arr_s.length == 0) {
            s1 = "";
        }
        else {
            StringBuilder stringBuilder0 = new StringBuilder();
            stringBuilder0.append('[');
            for(int v = 0; v < arr_s.length; ++v) {
                String s2 = arr_s[v];
                if(stringBuilder0.length() > 1) {
                    stringBuilder0.append(",");
                }
                stringBuilder0.append(s2);
            }
            stringBuilder0.append("] ");
            s1 = stringBuilder0.toString();
        }
        super();
        this.b = s1;
        this.a = s;
        this.c = new j(s);
        int v1;
        for(v1 = 2; v1 <= 7 && !Log.isLoggable(this.a, v1); ++v1) {
        }
        this.d = v1;
    }

    public void a(String s, Object[] arr_object) {
        if(this.d(3)) {
            String s1 = this.c(s, arr_object);
            Log.d(this.a, s1);
        }
    }

    public void b(String s, Object[] arr_object) {
        String s1 = this.c(s, arr_object);
        Log.e(this.a, s1);
    }

    protected String c(String s, Object[] arr_object) {
        if(arr_object != null && arr_object.length > 0) {
            s = String.format(Locale.US, s, arr_object);
        }
        return this.b + s;
    }

    public boolean d(int v) {
        return this.d <= v;
    }
}

