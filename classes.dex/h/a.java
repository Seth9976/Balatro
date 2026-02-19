package h;

import android.content.Context;
import android.content.res.Configuration;

public class a {
    private Context a;

    private a(Context context0) {
        this.a = context0;
    }

    public static a a(Context context0) {
        return new a(context0);
    }

    public int b() {
        return this.a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public int c() {
        Configuration configuration0 = this.a.getResources().getConfiguration();
        int v = configuration0.screenWidthDp;
        int v1 = configuration0.screenHeightDp;
        if(configuration0.smallestScreenWidthDp <= 600 && v <= 600 && (v <= 960 || v1 <= 720) && (v <= 720 || v1 <= 960)) {
            if(v < 500 && (v <= 640 || v1 <= 480) && (v <= 480 || v1 <= 640)) {
                return v < 360 ? 2 : 3;
            }
            return 4;
        }
        return 5;
    }

    public boolean d() [...] // Inlined contents
}

