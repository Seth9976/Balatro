package a;

import android.content.Context;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public final class a {
    private final Set a;
    private volatile Context b;

    public a() {
        this.a = new CopyOnWriteArraySet();
    }

    public void a(b b0) {
        if(this.b != null) {
            b0.a(this.b);
        }
        this.a.add(b0);
    }

    public void b() {
        this.b = null;
    }

    public void c(Context context0) {
        this.b = context0;
        for(Object object0: this.a) {
            ((b)object0).a(context0);
        }
    }
}

