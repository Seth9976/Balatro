package androidx.activity;

import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.h.b;
import androidx.lifecycle.h.c;
import androidx.lifecycle.h;
import androidx.lifecycle.j;
import androidx.lifecycle.l;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Objects;

public final class OnBackPressedDispatcher {
    class LifecycleOnBackPressedCancellable implements a, j {
        private final h a;
        private final androidx.activity.h b;
        private a c;
        final OnBackPressedDispatcher d;

        LifecycleOnBackPressedCancellable(h h0, androidx.activity.h h1) {
            this.a = h0;
            this.b = h1;
            h0.a(this);
        }

        @Override  // androidx.activity.a
        public void cancel() {
            this.a.c(this);
            this.b.e(this);
            a a0 = this.c;
            if(a0 != null) {
                a0.cancel();
                this.c = null;
            }
        }

        @Override  // androidx.lifecycle.j
        public void d(l l0, b h$b0) {
            if(h$b0 == b.ON_START) {
                this.c = OnBackPressedDispatcher.this.c(this.b);
                return;
            }
            if(h$b0 == b.ON_STOP) {
                a a0 = this.c;
                if(a0 != null) {
                    a0.cancel();
                }
            }
            else if(h$b0 == b.ON_DESTROY) {
                this.cancel();
            }
        }
    }

    static abstract class androidx.activity.OnBackPressedDispatcher.a {
        static OnBackInvokedCallback a(Runnable runnable0) {
            Objects.requireNonNull(runnable0);
            return new k(runnable0);
        }

        static void b(Object object0, int v, Object object1) {
            ((OnBackInvokedDispatcher)object0).registerOnBackInvokedCallback(v, ((OnBackInvokedCallback)object1));
        }

        static void c(Object object0, Object object1) {
            ((OnBackInvokedDispatcher)object0).unregisterOnBackInvokedCallback(((OnBackInvokedCallback)object1));
        }
    }

    class androidx.activity.OnBackPressedDispatcher.b implements a {
        private final androidx.activity.h a;
        final OnBackPressedDispatcher b;

        androidx.activity.OnBackPressedDispatcher.b(androidx.activity.h h0) {
            this.a = h0;
        }

        @Override  // androidx.activity.a
        public void cancel() {
            OnBackPressedDispatcher.this.b.remove(this.a);
            this.a.e(this);
            this.a.g(null);
            OnBackPressedDispatcher.this.h();
        }
    }

    private final Runnable a;
    final ArrayDeque b;
    private androidx.core.util.a c;
    private OnBackInvokedCallback d;
    private OnBackInvokedDispatcher e;
    private boolean f;

    public OnBackPressedDispatcher(Runnable runnable0) {
        this.b = new ArrayDeque();
        this.f = false;
        this.a = runnable0;
        this.c = (Boolean boolean0) -> this.h();
        this.d = androidx.activity.OnBackPressedDispatcher.a.a(() -> {
            Iterator iterator0 = this.b.descendingIterator();
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                androidx.activity.h h0 = (androidx.activity.h)object0;
                if(h0.c()) {
                    h0.b();
                    return;
                }
                if(false) {
                    break;
                }
            }
            Runnable runnable0 = this.a;
            if(runnable0 != null) {
                runnable0.run();
            }
        });
    }

    public void b(l l0, androidx.activity.h h0) {
        h h1 = l0.o();
        if(h1.b() == c.e) {
            return;
        }
        h0.a(new LifecycleOnBackPressedCancellable(this, h1, h0));
        this.h();
        h0.g(this.c);
    }

    a c(androidx.activity.h h0) {
        this.b.add(h0);
        a a0 = new androidx.activity.OnBackPressedDispatcher.b(this, h0);
        h0.a(a0);
        this.h();
        h0.g(this.c);
        return a0;
    }

    public boolean d() {
        Iterator iterator0 = this.b.descendingIterator();
        while(iterator0.hasNext()) {
            Object object0 = iterator0.next();
            if(((androidx.activity.h)object0).c()) {
                return true;
            }
            if(false) {
                break;
            }
        }
        return false;
    }

    // 检测为 Lambda 实现
    private void e(Boolean boolean0) [...]

    // 检测为 Lambda 实现
    public void f() [...]

    public void g(OnBackInvokedDispatcher onBackInvokedDispatcher0) {
        this.e = onBackInvokedDispatcher0;
        this.h();
    }

    void h() {
        boolean z = this.d();
        OnBackInvokedDispatcher onBackInvokedDispatcher0 = this.e;
        if(onBackInvokedDispatcher0 != null) {
            if(z && !this.f) {
                androidx.activity.OnBackPressedDispatcher.a.b(onBackInvokedDispatcher0, 0, this.d);
                this.f = true;
                return;
            }
            if(!z && this.f) {
                androidx.activity.OnBackPressedDispatcher.a.c(onBackInvokedDispatcher0, this.d);
                this.f = false;
            }
        }
    }
}

