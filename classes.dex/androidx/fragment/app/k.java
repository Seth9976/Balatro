package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import androidx.core.view.t;

abstract class k {
    static class a {
        public final Animation a;
        public final Animator b;

        a(Animator animator0) {
            this.a = null;
            this.b = animator0;
            if(animator0 == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }

        a(Animation animation0) {
            this.a = animation0;
            this.b = null;
            if(animation0 == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }
    }

    static class b extends AnimationSet implements Runnable {
        private final ViewGroup e;
        private final View f;
        private boolean g;
        private boolean h;
        private boolean i;

        b(Animation animation0, ViewGroup viewGroup0, View view0) {
            super(false);
            this.i = true;
            this.e = viewGroup0;
            this.f = view0;
            this.addAnimation(animation0);
            viewGroup0.post(this);
        }

        @Override  // android.view.animation.AnimationSet
        public boolean getTransformation(long v, Transformation transformation0) {
            this.i = true;
            if(this.g) {
                return !this.h;
            }
            if(!super.getTransformation(v, transformation0)) {
                this.g = true;
                t.a(this.e, this);
            }
            return true;
        }

        @Override  // android.view.animation.Animation
        public boolean getTransformation(long v, Transformation transformation0, float f) {
            this.i = true;
            if(this.g) {
                return !this.h;
            }
            if(!super.getTransformation(v, transformation0, f)) {
                this.g = true;
                t.a(this.e, this);
            }
            return true;
        }

        @Override
        public void run() {
            if(!this.g && this.i) {
                this.i = false;
                this.e.post(this);
                return;
            }
            this.e.endViewTransition(this.f);
            this.h = true;
        }
    }

    private static int a(Fragment fragment0, boolean z, boolean z1) {
        if(z1) {
            return z ? fragment0.I() : fragment0.J();
        }
        return z ? fragment0.u() : fragment0.x();
    }

    static a b(Context context0, Fragment fragment0, boolean z, boolean z1) {
        int v = fragment0.E();
        int v1 = k.a(fragment0, z, z1);
        boolean z2 = false;
        fragment0.s1(0, 0, 0, 0);
        if(fragment0.H != null && fragment0.H.getTag(u.b.c) != null) {
            fragment0.H.setTag(u.b.c, null);
        }
        if(fragment0.H != null && fragment0.H.getLayoutTransition() != null) {
            return null;
        }
        if(v1 == 0 && v != 0) {
            v1 = k.d(context0, v, z);
        }
        if(v1 == 0) {
            return null;
        }
        else {
            boolean z3 = "anim".equals(context0.getResources().getResourceTypeName(v1));
            if(z3) {
                try {
                    Animation animation0 = AnimationUtils.loadAnimation(context0, v1);
                    if(animation0 != null) {
                        return new a(animation0);
                    }
                    z2 = true;
                    goto label_20;
                }
                catch(Resources.NotFoundException resources$NotFoundException0) {
                }
                catch(RuntimeException unused_ex) {
                    goto label_20;
                }
                throw resources$NotFoundException0;
            }
        label_20:
            if(!z2) {
                try {
                    Animator animator0 = AnimatorInflater.loadAnimator(context0, v1);
                    return animator0 == null ? null : new a(animator0);
                }
                catch(RuntimeException runtimeException0) {
                }
            }
        }
        if(z3) {
            throw runtimeException0;
        }
        Animation animation1 = AnimationUtils.loadAnimation(context0, v1);
        return animation1 == null ? null : new a(animation1);
    }

    private static int c(Context context0, int v) {
        TypedArray typedArray0 = context0.obtainStyledAttributes(0x1030001, new int[]{v});
        int v1 = typedArray0.getResourceId(0, -1);
        typedArray0.recycle();
        return v1;
    }

    private static int d(Context context0, int v, boolean z) {
        switch(v) {
            case 0x1001: {
                return z ? u.a.e : u.a.f;
            }
            case 0x1003: {
                return z ? u.a.c : u.a.d;
            }
            case 4100: {
                return z ? k.c(context0, 0x10100B8) : k.c(context0, 0x10100B9);
            }
            case 0x2002: {
                return z ? u.a.a : u.a.b;
            }
            case 0x2005: {
                return z ? k.c(context0, 0x10100BA) : k.c(context0, 0x10100BB);
            }
            default: {
                return -1;
            }
        }
    }
}

