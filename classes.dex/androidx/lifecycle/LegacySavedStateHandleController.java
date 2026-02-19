package androidx.lifecycle;

import z.c;
import z.e;

abstract class LegacySavedStateHandleController {
    static final class a implements z.c.a {
        @Override  // z.c$a
        public void a(e e0) {
            if(!(e0 instanceof d0)) {
                throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner");
            }
            c0 c00 = ((d0)e0).l();
            c c0 = e0.d();
            for(Object object0: c00.c()) {
                LegacySavedStateHandleController.a(c00.b(((String)object0)), c0, e0.o());
            }
            if(!c00.c().isEmpty()) {
                c0.i(a.class);
            }
        }
    }

    static void a(y y0, c c0, h h0) {
        SavedStateHandleController savedStateHandleController0 = (SavedStateHandleController)y0.c("androidx.lifecycle.savedstate.vm.tag");
        if(savedStateHandleController0 != null && !savedStateHandleController0.i()) {
            savedStateHandleController0.h(c0, h0);
            LegacySavedStateHandleController.b(c0, h0);
        }
    }

    private static void b(c c0, h h0) {
        androidx.lifecycle.h.c h$c0 = h0.b();
        if(h$c0 != androidx.lifecycle.h.c.f && !h$c0.c(androidx.lifecycle.h.c.h)) {
            h0.a(new j() {
                @Override  // androidx.lifecycle.j
                public void d(l l0, b h$b0) {
                    if(h$b0 == b.ON_START) {
                        h0.c(this);
                        c0.i(a.class);
                    }
                }
            });
            return;
        }
        c0.i(a.class);
    }
}

