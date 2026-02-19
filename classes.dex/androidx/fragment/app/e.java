package androidx.fragment.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.activity.g;
import androidx.lifecycle.e0;
import androidx.lifecycle.l;
import androidx.lifecycle.q;
import z.f;

public class e extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    class a implements Runnable {
        final e e;

        @Override
        public void run() {
            e.this.g0.onDismiss(e.this.o0);
        }
    }

    class b implements DialogInterface.OnCancelListener {
        final e a;

        @Override  // android.content.DialogInterface$OnCancelListener
        public void onCancel(DialogInterface dialogInterface0) {
            if(e.this.o0 != null) {
                e.this.onCancel(e.this.o0);
            }
        }
    }

    class c implements DialogInterface.OnDismissListener {
        final e a;

        @Override  // android.content.DialogInterface$OnDismissListener
        public void onDismiss(DialogInterface dialogInterface0) {
            if(e.this.o0 != null) {
                e.this.onDismiss(e.this.o0);
            }
        }
    }

    class d implements q {
        final e a;

        @Override  // androidx.lifecycle.q
        public void a(Object object0) {
            this.b(((l)object0));
        }

        public void b(l l0) {
            if(l0 != null && e.this.k0) {
                View view0 = e.this.o1();
                if(view0.getParent() != null) {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
                if(e.this.o0 != null) {
                    if(x.G0(3)) {
                        Log.d("FragmentManager", "DialogFragment " + this + " setting the content view on " + e.this.o0);
                    }
                    e.this.o0.setContentView(view0);
                }
            }
        }
    }

    private Handler d0;
    private Runnable e0;
    private DialogInterface.OnCancelListener f0;
    private DialogInterface.OnDismissListener g0;
    private int h0;
    private int i0;
    private boolean j0;
    private boolean k0;
    private int l0;
    private boolean m0;
    private q n0;
    private Dialog o0;
    private boolean p0;
    private boolean q0;
    private boolean r0;
    private boolean s0;

    public e() {
        this.e0 = new a(this);
        this.f0 = new b(this);
        this.g0 = new c(this);
        this.h0 = 0;
        this.i0 = 0;
        this.j0 = true;
        this.k0 = true;
        this.l0 = -1;
        this.n0 = new d(this);
        this.s0 = false;
    }

    private void E1(boolean z, boolean z1, boolean z2) {
        if(this.q0) {
            return;
        }
        this.q0 = true;
        this.r0 = false;
        Dialog dialog0 = this.o0;
        if(dialog0 != null) {
            dialog0.setOnDismissListener(null);
            this.o0.dismiss();
            if(!z1) {
                if(Looper.myLooper() == this.d0.getLooper()) {
                    this.onDismiss(this.o0);
                }
                else {
                    this.d0.post(this.e0);
                }
            }
        }
        this.p0 = true;
        if(this.l0 >= 0) {
            if(z2) {
                this.G().a1(this.l0, 1);
            }
            else {
                this.G().Y0(this.l0, 1, z);
            }
            this.l0 = -1;
            return;
        }
        f0 f00 = this.G().o();
        f00.m(true);
        f00.l(this);
        if(z2) {
            f00.h();
            return;
        }
        if(z) {
            f00.g();
            return;
        }
        f00.f();
    }

    public int F1() {
        return this.i0;
    }

    public Dialog G1(Bundle bundle0) {
        if(x.G0(3)) {
            Log.d("FragmentManager", "onCreateDialog called for DialogFragment " + this);
        }
        return new g(this.n1(), this.F1());
    }

    View H1(int v) {
        return this.o0 == null ? null : this.o0.findViewById(v);
    }

    @Override  // androidx.fragment.app.Fragment
    public void I0(Bundle bundle0) {
        super.I0(bundle0);
        Dialog dialog0 = this.o0;
        if(dialog0 != null) {
            Bundle bundle1 = dialog0.onSaveInstanceState();
            bundle1.putBoolean("android:dialogShowing", false);
            bundle0.putBundle("android:savedDialogState", bundle1);
        }
        int v = this.h0;
        if(v != 0) {
            bundle0.putInt("android:style", v);
        }
        int v1 = this.i0;
        if(v1 != 0) {
            bundle0.putInt("android:theme", v1);
        }
        if(!this.j0) {
            bundle0.putBoolean("android:cancelable", false);
        }
        if(!this.k0) {
            bundle0.putBoolean("android:showsDialog", false);
        }
        int v2 = this.l0;
        if(v2 != -1) {
            bundle0.putInt("android:backStackId", v2);
        }
    }

    boolean I1() {
        return this.s0;
    }

    @Override  // androidx.fragment.app.Fragment
    public void J0() {
        super.J0();
        Dialog dialog0 = this.o0;
        if(dialog0 != null) {
            this.p0 = false;
            dialog0.show();
            View view0 = this.o0.getWindow().getDecorView();
            e0.a(view0, this);
            androidx.lifecycle.f0.a(view0, this);
            f.a(view0, this);
        }
    }

    private void J1(Bundle bundle0) {
        if(!this.k0) {
            return;
        }
        if(!this.s0) {
            try {
                this.m0 = true;
                Dialog dialog0 = this.G1(bundle0);
                this.o0 = dialog0;
                if(this.k0) {
                    this.L1(dialog0, this.h0);
                    Context context0 = this.t();
                    if(context0 instanceof Activity) {
                        this.o0.setOwnerActivity(((Activity)context0));
                    }
                    this.o0.setCancelable(this.j0);
                    this.o0.setOnCancelListener(this.f0);
                    this.o0.setOnDismissListener(this.g0);
                    this.s0 = true;
                }
                else {
                    this.o0 = null;
                }
            }
            finally {
                this.m0 = false;
            }
        }
    }

    @Override  // androidx.fragment.app.Fragment
    public void K0() {
        super.K0();
        Dialog dialog0 = this.o0;
        if(dialog0 != null) {
            dialog0.hide();
        }
    }

    public void K1(boolean z) {
        this.k0 = z;
    }

    public void L1(Dialog dialog0, int v) {
        switch(v) {
            case 1: 
            case 2: {
                break;
            }
            case 3: {
                Window window0 = dialog0.getWindow();
                if(window0 != null) {
                    window0.addFlags(24);
                }
                break;
            }
            default: {
                return;
            }
        }
        dialog0.requestWindowFeature(1);
    }

    @Override  // androidx.fragment.app.Fragment
    public void M0(Bundle bundle0) {
        super.M0(bundle0);
        if(this.o0 != null && bundle0 != null) {
            Bundle bundle1 = bundle0.getBundle("android:savedDialogState");
            if(bundle1 != null) {
                this.o0.onRestoreInstanceState(bundle1);
            }
        }
    }

    public void M1(x x0, String s) {
        this.q0 = false;
        this.r0 = true;
        f0 f00 = x0.o();
        f00.m(true);
        f00.d(this, s);
        f00.f();
    }

    @Override  // androidx.fragment.app.Fragment
    void T0(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Bundle bundle0) {
        super.T0(layoutInflater0, viewGroup0, bundle0);
        if(this.I == null && this.o0 != null && bundle0 != null) {
            Bundle bundle1 = bundle0.getBundle("android:savedDialogState");
            if(bundle1 != null) {
                this.o0.onRestoreInstanceState(bundle1);
            }
        }
    }

    @Override  // androidx.fragment.app.Fragment
    public void g0(Bundle bundle0) {
        super.g0(bundle0);
    }

    @Override  // androidx.fragment.app.Fragment
    androidx.fragment.app.l h() {
        class androidx.fragment.app.e.e extends androidx.fragment.app.l {
            final androidx.fragment.app.l a;
            final e b;

            androidx.fragment.app.e.e(androidx.fragment.app.l l0) {
                this.a = l0;
                super();
            }

            // 去混淆评级： 低(20)
            @Override  // androidx.fragment.app.l
            public View i(int v) {
                return this.a.s() ? this.a.i(v) : e.this.H1(v);
            }

            // 去混淆评级： 低(20)
            @Override  // androidx.fragment.app.l
            public boolean s() {
                return this.a.s() || e.this.I1();
            }
        }

        return new androidx.fragment.app.e.e(this, super.h());
    }

    @Override  // androidx.fragment.app.Fragment
    public void j0(Context context0) {
        super.j0(context0);
        this.U().i(this.n0);
        if(!this.r0) {
            this.q0 = false;
        }
    }

    @Override  // androidx.fragment.app.Fragment
    public void m0(Bundle bundle0) {
        super.m0(bundle0);
        this.d0 = new Handler();
        this.k0 = this.y == 0;
        if(bundle0 != null) {
            this.h0 = bundle0.getInt("android:style", 0);
            this.i0 = bundle0.getInt("android:theme", 0);
            this.j0 = bundle0.getBoolean("android:cancelable", true);
            this.k0 = bundle0.getBoolean("android:showsDialog", this.k0);
            this.l0 = bundle0.getInt("android:backStackId", -1);
        }
    }

    @Override  // android.content.DialogInterface$OnCancelListener
    public void onCancel(DialogInterface dialogInterface0) {
    }

    @Override  // android.content.DialogInterface$OnDismissListener
    public void onDismiss(DialogInterface dialogInterface0) {
        if(!this.p0) {
            if(x.G0(3)) {
                Log.d("FragmentManager", "onDismiss called for DialogFragment " + this);
            }
            this.E1(true, true, false);
        }
    }

    @Override  // androidx.fragment.app.Fragment
    public void t0() {
        super.t0();
        Dialog dialog0 = this.o0;
        if(dialog0 != null) {
            this.p0 = true;
            dialog0.setOnDismissListener(null);
            this.o0.dismiss();
            if(!this.q0) {
                this.onDismiss(this.o0);
            }
            this.o0 = null;
            this.s0 = false;
        }
    }

    @Override  // androidx.fragment.app.Fragment
    public void u0() {
        super.u0();
        if(!this.r0 && !this.q0) {
            this.q0 = true;
        }
        this.U().m(this.n0);
    }

    @Override  // androidx.fragment.app.Fragment
    public LayoutInflater v0(Bundle bundle0) {
        String s;
        StringBuilder stringBuilder0;
        LayoutInflater layoutInflater0 = super.v0(bundle0);
        if(this.k0 && !this.m0) {
            this.J1(bundle0);
            if(x.G0(2)) {
                Log.d("FragmentManager", "get layout inflater for DialogFragment " + this + " from dialog context");
            }
            return this.o0 == null ? layoutInflater0 : layoutInflater0.cloneInContext(this.o0.getContext());
        }
        if(x.G0(2)) {
            if(this.k0) {
                stringBuilder0 = new StringBuilder();
                s = "mCreatingDialog = true: ";
            }
            else {
                stringBuilder0 = new StringBuilder();
                s = "mShowsDialog = false: ";
            }
            stringBuilder0.append(s);
            stringBuilder0.append("getting layout inflater for DialogFragment " + this);
            Log.d("FragmentManager", stringBuilder0.toString());
        }
        return layoutInflater0;
    }
}

