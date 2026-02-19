package androidx.core.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import h.d;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class j {
    private final Runnable a;
    private final CopyOnWriteArrayList b;
    private final Map c;

    public j(Runnable runnable0) {
        this.b = new CopyOnWriteArrayList();
        this.c = new HashMap();
        this.a = runnable0;
    }

    public void a(l l0) {
        this.b.add(l0);
        this.a.run();
    }

    public void b(Menu menu0, MenuInflater menuInflater0) {
        for(Object object0: this.b) {
            ((l)object0).a(menu0, menuInflater0);
        }
    }

    public void c(Menu menu0) {
        for(Object object0: this.b) {
            ((l)object0).d(menu0);
        }
    }

    public boolean d(MenuItem menuItem0) {
        for(Object object0: this.b) {
            if(((l)object0).c(menuItem0)) {
                return true;
            }
            if(false) {
                break;
            }
        }
        return false;
    }

    public void e(Menu menu0) {
        for(Object object0: this.b) {
            ((l)object0).b(menu0);
        }
    }

    public void f(l l0) {
        this.b.remove(l0);
        d.a(this.c.remove(l0));
        this.a.run();
    }
}

