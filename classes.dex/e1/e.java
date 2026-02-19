package e1;

import android.app.Activity;
import androidx.fragment.app.j;
import g1.q;

public class e {
    private final Object a;

    public e(Activity activity0) {
        q.j(activity0, "Activity must not be null");
        this.a = activity0;
    }

    public final Activity a() {
        return (Activity)this.a;
    }

    public final j b() {
        return (j)this.a;
    }

    public final boolean c() {
        return this.a instanceof Activity;
    }

    public final boolean d() {
        return this.a instanceof j;
    }
}

