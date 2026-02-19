package c1;

import a2.f;
import a2.g;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.FragmentManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.util.Log;
import android.util.TypedValue;
import android.widget.ProgressBar;
import androidx.core.app.f.d;
import androidx.fragment.app.x;
import com.google.android.gms.common.api.GoogleApiActivity;
import e1.s;
import e1.t;
import g1.a0;
import g1.d0;
import g1.q;
import l1.e;

public class i extends j {
    private String c;
    public static final int d;
    private static final Object e;
    private static final i f;

    static {
        i.e = new Object();
        i.f = new i();
        i.d = j.a;
    }

    @Override  // c1.j
    public Intent a(Context context0, int v, String s) {
        return super.a(context0, v, s);
    }

    @Override  // c1.j
    public PendingIntent b(Context context0, int v, int v1) {
        return super.b(context0, v, v1);
    }

    @Override  // c1.j
    public final String d(int v) {
        return super.d(v);
    }

    @Override  // c1.j
    public int f(Context context0) {
        return super.f(context0);
    }

    @Override  // c1.j
    public int g(Context context0, int v) {
        return super.g(context0, v);
    }

    @Override  // c1.j
    public final boolean i(int v) {
        return super.i(v);
    }

    public Dialog j(Activity activity0, int v, int v1, DialogInterface.OnCancelListener dialogInterface$OnCancelListener0) {
        return this.o(activity0, v, d0.b(activity0, this.a(activity0, v, "d"), v1), dialogInterface$OnCancelListener0, null);
    }

    // 去混淆评级： 低(20)
    public PendingIntent k(Context context0, a a0) {
        return a0.m0() ? a0.l0() : this.b(context0, a0.j0(), 0);
    }

    public static i l() {
        return i.f;
    }

    public boolean m(Activity activity0, int v, int v1, DialogInterface.OnCancelListener dialogInterface$OnCancelListener0) {
        Dialog dialog0 = this.j(activity0, v, v1, dialogInterface$OnCancelListener0);
        if(dialog0 == null) {
            return false;
        }
        this.r(activity0, dialog0, "GooglePlayServicesErrorDialog", dialogInterface$OnCancelListener0);
        return true;
    }

    public void n(Context context0, int v) {
        this.s(context0, v, null, this.c(context0, v, 0, "n"));
    }

    final Dialog o(Context context0, int v, d0 d00, DialogInterface.OnCancelListener dialogInterface$OnCancelListener0, DialogInterface.OnClickListener dialogInterface$OnClickListener0) {
        AlertDialog.Builder alertDialog$Builder0 = null;
        if(v == 0) {
            return null;
        }
        TypedValue typedValue0 = new TypedValue();
        context0.getTheme().resolveAttribute(0x1010309, typedValue0, true);
        if("Theme.Dialog.Alert".equals(context0.getResources().getResourceEntryName(typedValue0.resourceId))) {
            alertDialog$Builder0 = new AlertDialog.Builder(context0, 5);
        }
        if(alertDialog$Builder0 == null) {
            alertDialog$Builder0 = new AlertDialog.Builder(context0);
        }
        alertDialog$Builder0.setMessage(a0.c(context0, v));
        if(dialogInterface$OnCancelListener0 != null) {
            alertDialog$Builder0.setOnCancelListener(dialogInterface$OnCancelListener0);
        }
        String s = a0.b(context0, v);
        if(s != null) {
            if(d00 == null) {
                d00 = dialogInterface$OnClickListener0;
            }
            alertDialog$Builder0.setPositiveButton(s, d00);
        }
        String s1 = a0.f(context0, v);
        if(s1 != null) {
            alertDialog$Builder0.setTitle(s1);
        }
        Log.w("GoogleApiAvailability", String.format("Creating dialog for Google Play services availability issue. ConnectionResult=%s", v), new IllegalArgumentException());
        return alertDialog$Builder0.create();
    }

    public final Dialog p(Activity activity0, DialogInterface.OnCancelListener dialogInterface$OnCancelListener0) {
        ProgressBar progressBar0 = new ProgressBar(activity0, null, 0x101007A);
        progressBar0.setIndeterminate(true);
        progressBar0.setVisibility(0);
        AlertDialog.Builder alertDialog$Builder0 = new AlertDialog.Builder(activity0);
        alertDialog$Builder0.setView(progressBar0);
        alertDialog$Builder0.setMessage(a0.c(activity0, 18));
        alertDialog$Builder0.setPositiveButton("", null);
        Dialog dialog0 = alertDialog$Builder0.create();
        this.r(activity0, dialog0, "GooglePlayServicesUpdatingDialog", dialogInterface$OnCancelListener0);
        return dialog0;
    }

    public final t q(Context context0, s s0) {
        IntentFilter intentFilter0 = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter0.addDataScheme("package");
        t t0 = new t(s0);
        f.e(context0, t0, intentFilter0);
        t0.a(context0);
        if(!this.h(context0, "com.google.android.gms")) {
            s0.a();
            t0.b();
            return null;
        }
        return t0;
    }

    final void r(Activity activity0, Dialog dialog0, String s, DialogInterface.OnCancelListener dialogInterface$OnCancelListener0) {
        if(activity0 instanceof androidx.fragment.app.j) {
            x x0 = ((androidx.fragment.app.j)activity0).M();
            o.N1(dialog0, dialogInterface$OnCancelListener0).M1(x0, s);
            return;
        }
        FragmentManager fragmentManager0 = activity0.getFragmentManager();
        b.a(dialog0, dialogInterface$OnCancelListener0).show(fragmentManager0, s);
    }

    final void s(Context context0, int v, String s, PendingIntent pendingIntent0) {
        String s3;
        int v1;
        Log.w("GoogleApiAvailability", String.format("GMS core API Availability. ConnectionResult=%s, tag=%s", v, null), new IllegalArgumentException());
        if(v == 18) {
            this.t(context0);
            return;
        }
        if(pendingIntent0 == null) {
            if(v == 6) {
                Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
            }
            return;
        }
        String s1 = a0.e(context0, v);
        String s2 = a0.d(context0, v);
        Resources resources0 = context0.getResources();
        NotificationManager notificationManager0 = (NotificationManager)q.i(context0.getSystemService("notification"));
        d f$d0 = new d(context0).k(true).e(true).i(s1).n(new androidx.core.app.f.b().h(s2));
        if(e.c(context0)) {
            q.k(true);
            f$d0.m(context0.getApplicationInfo().icon).l(2);
            if(e.d(context0)) {
                f$d0.a(b1.a.a, resources0.getString(b1.b.o), pendingIntent0);
            }
            else {
                f$d0.g(pendingIntent0);
            }
        }
        else {
            f$d0.m(0x108008A).o(resources0.getString(b1.b.h)).p(System.currentTimeMillis()).g(pendingIntent0).h(s2);
        }
        q.k(true);
        synchronized(i.e) {
            s3 = this.c;
        }
        if(s3 == null) {
            s3 = "com.google.android.gms.availability";
            NotificationChannel notificationChannel0 = notificationManager0.getNotificationChannel("com.google.android.gms.availability");
            String s4 = context0.getResources().getString(b1.b.g);
            if(notificationChannel0 == null) {
                notificationManager0.createNotificationChannel(h.a("com.google.android.gms.availability", s4, 4));
            }
            else if(!s4.contentEquals(notificationChannel0.getName())) {
                notificationChannel0.setName(s4);
                notificationManager0.createNotificationChannel(notificationChannel0);
            }
        }
        f$d0.f(s3);
        Notification notification0 = f$d0.b();
        if(v == 1 || v == 2 || v == 3) {
            l.b.set(false);
            v1 = 10436;
        }
        else {
            v1 = 0x9B6D;
        }
        notificationManager0.notify(v1, notification0);
    }

    final void t(Context context0) {
        new p(this, context0).sendEmptyMessageDelayed(1, 120000L);
    }

    public final boolean u(Activity activity0, e1.f f0, int v, int v1, DialogInterface.OnCancelListener dialogInterface$OnCancelListener0) {
        Dialog dialog0 = this.o(activity0, v, d0.c(f0, this.a(activity0, v, "d"), 2), dialogInterface$OnCancelListener0, null);
        if(dialog0 == null) {
            return false;
        }
        this.r(activity0, dialog0, "GooglePlayServicesErrorDialog", dialogInterface$OnCancelListener0);
        return true;
    }

    public final boolean v(Context context0, a a0, int v) {
        if(!m1.b.a(context0)) {
            PendingIntent pendingIntent0 = this.k(context0, a0);
            if(pendingIntent0 != null) {
                this.s(context0, a0.j0(), null, PendingIntent.getActivity(context0, 0, GoogleApiActivity.a(context0, pendingIntent0, v, true), g.a | 0x8000000));
                return true;
            }
        }
        return false;
    }
}

