package androidx.core.app;

import android.app.Notification.Action.Builder;
import android.app.Notification.Action;
import android.app.Notification.Builder;
import android.app.Notification;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k.b;

class z implements e {
    private final Context a;
    private final Notification.Builder b;
    private final d c;
    private RemoteViews d;
    private RemoteViews e;
    private final List f;
    private final Bundle g;
    private int h;
    private RemoteViews i;

    z(d f$d0) {
        this.f = new ArrayList();
        this.g = new Bundle();
        this.c = f$d0;
        this.a = f$d0.a;
        this.b = Build.VERSION.SDK_INT < 26 ? new Notification.Builder(f$d0.a) : g.a(f$d0.a, f$d0.K);
        Notification notification0 = f$d0.R;
        this.b.setWhen(notification0.when).setSmallIcon(notification0.icon, notification0.iconLevel).setContent(notification0.contentView).setTicker(notification0.tickerText, f$d0.i).setVibrate(notification0.vibrate).setLights(notification0.ledARGB, notification0.ledOnMS, notification0.ledOffMS).setOngoing((notification0.flags & 2) != 0).setOnlyAlertOnce((notification0.flags & 8) != 0).setAutoCancel((notification0.flags & 16) != 0).setDefaults(notification0.defaults).setContentTitle(f$d0.e).setContentText(f$d0.f).setContentInfo(f$d0.k).setContentIntent(f$d0.g).setDeleteIntent(notification0.deleteIntent).setFullScreenIntent(f$d0.h, (notification0.flags & 0x80) != 0).setLargeIcon(f$d0.j).setNumber(f$d0.l).setProgress(f$d0.t, f$d0.u, f$d0.v);
        this.b.setSubText(f$d0.q).setUsesChronometer(f$d0.o).setPriority(f$d0.m);
        for(Object object0: f$d0.b) {
            this.b(((a)object0));
        }
        Bundle bundle0 = f$d0.D;
        if(bundle0 != null) {
            this.g.putAll(bundle0);
        }
        int v = Build.VERSION.SDK_INT;
        this.d = f$d0.H;
        this.e = f$d0.I;
        this.b.setShowWhen(f$d0.n);
        this.b.setLocalOnly(f$d0.z).setGroup(f$d0.w).setGroupSummary(f$d0.x).setSortKey(f$d0.y);
        this.h = f$d0.O;
        this.b.setCategory(f$d0.C).setColor(f$d0.E).setVisibility(f$d0.F).setPublicVersion(f$d0.G).setSound(notification0.sound, notification0.audioAttributes);
        List list0 = v < 28 ? z.e(z.f(f$d0.c), f$d0.U) : f$d0.U;
        if(list0 != null && !list0.isEmpty()) {
            for(Object object1: list0) {
                this.b.addPerson(((String)object1));
            }
        }
        this.i = f$d0.J;
        if(f$d0.d.size() > 0) {
            Bundle bundle1 = f$d0.c().getBundle("android.car.EXTENSIONS");
            if(bundle1 == null) {
                bundle1 = new Bundle();
            }
            Bundle bundle2 = new Bundle(bundle1);
            Bundle bundle3 = new Bundle();
            for(int v1 = 0; v1 < f$d0.d.size(); ++v1) {
                bundle3.putBundle(Integer.toString(v1), a0.a(((a)f$d0.d.get(v1))));
            }
            bundle1.putBundle("invisible_actions", bundle3);
            bundle2.putBundle("invisible_actions", bundle3);
            f$d0.c().putBundle("android.car.EXTENSIONS", bundle1);
            this.g.putBundle("android.car.EXTENSIONS", bundle2);
        }
        int v2 = Build.VERSION.SDK_INT;
        Icon icon0 = f$d0.T;
        if(icon0 != null) {
            this.b.setSmallIcon(icon0);
        }
        if(v2 >= 24) {
            this.b.setExtras(f$d0.D).setRemoteInputHistory(f$d0.s);
            RemoteViews remoteViews0 = f$d0.H;
            if(remoteViews0 != null) {
                this.b.setCustomContentView(remoteViews0);
            }
            RemoteViews remoteViews1 = f$d0.I;
            if(remoteViews1 != null) {
                this.b.setCustomBigContentView(remoteViews1);
            }
            RemoteViews remoteViews2 = f$d0.J;
            if(remoteViews2 != null) {
                this.b.setCustomHeadsUpContentView(remoteViews2);
            }
        }
        if(v2 >= 26) {
            this.b.setBadgeIconType(f$d0.L).setSettingsText(f$d0.r).setShortcutId(f$d0.M).setTimeoutAfter(f$d0.N).setGroupAlertBehavior(f$d0.O);
            if(f$d0.B) {
                this.b.setColorized(f$d0.A);
            }
            if(!TextUtils.isEmpty(f$d0.K)) {
                this.b.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if(v2 >= 28) {
            Iterator iterator2 = f$d0.c.iterator();
            if(iterator2.hasNext()) {
                Object object2 = iterator2.next();
                h.d.a(object2);
                throw null;
            }
        }
        if(v2 >= 29) {
            this.b.setAllowSystemGeneratedContextualActions(f$d0.Q);
            this.b.setBubbleMetadata(null);
        }
        if(v2 >= 0x1F) {
            int v3 = f$d0.P;
            if(v3 != 0) {
                this.b.setForegroundServiceBehavior(v3);
            }
        }
        if(f$d0.S) {
            this.h = this.c.x ? 2 : 1;
            this.b.setVibrate(null);
            this.b.setSound(null);
            int v4 = notification0.defaults & -4;
            notification0.defaults = v4;
            this.b.setDefaults(v4);
            if(v2 >= 26) {
                if(TextUtils.isEmpty(this.c.w)) {
                    this.b.setGroup("silent");
                }
                this.b.setGroupAlertBehavior(this.h);
            }
        }
    }

    @Override  // androidx.core.app.e
    public Notification.Builder a() {
        return this.b;
    }

    private void b(a f$a0) {
        IconCompat iconCompat0 = f$a0.d();
        Notification.Action.Builder notification$Action$Builder0 = new Notification.Action.Builder((iconCompat0 == null ? null : iconCompat0.j()), f$a0.h(), f$a0.a());
        if(f$a0.e() != null) {
            RemoteInput[] arr_remoteInput = g0.b(f$a0.e());
            for(int v = 0; v < arr_remoteInput.length; ++v) {
                notification$Action$Builder0.addRemoteInput(arr_remoteInput[v]);
            }
        }
        Bundle bundle0 = f$a0.c() == null ? new Bundle() : new Bundle(f$a0.c());
        bundle0.putBoolean("android.support.allowGeneratedReplies", f$a0.b());
        int v1 = Build.VERSION.SDK_INT;
        if(v1 >= 24) {
            notification$Action$Builder0.setAllowGeneratedReplies(f$a0.b());
        }
        bundle0.putInt("android.support.action.semanticAction", f$a0.f());
        if(v1 >= 28) {
            notification$Action$Builder0.setSemanticAction(f$a0.f());
        }
        if(v1 >= 29) {
            notification$Action$Builder0.setContextual(f$a0.j());
        }
        if(v1 >= 0x1F) {
            notification$Action$Builder0.setAuthenticationRequired(f$a0.i());
        }
        bundle0.putBoolean("android.support.action.showsUserInterface", f$a0.g());
        notification$Action$Builder0.addExtras(bundle0);
        Notification.Action notification$Action0 = notification$Action$Builder0.build();
        this.b.addAction(notification$Action0);
    }

    public Notification c() {
        androidx.core.app.f.e f$e0 = this.c.p;
        if(f$e0 != null) {
            f$e0.b(this);
        }
        Notification notification0 = this.d();
        RemoteViews remoteViews0 = this.c.H;
        if(remoteViews0 != null) {
            notification0.contentView = remoteViews0;
        }
        if(f$e0 != null) {
            Bundle bundle0 = f.a(notification0);
            if(bundle0 != null) {
                f$e0.a(bundle0);
            }
        }
        return notification0;
    }

    protected Notification d() {
        int v = Build.VERSION.SDK_INT;
        if(v >= 26) {
            return this.b.build();
        }
        if(v >= 24) {
            Notification notification0 = this.b.build();
            if(this.h != 0) {
                if(notification0.getGroup() != null && (notification0.flags & 0x200) != 0 && this.h == 2) {
                    this.g(notification0);
                }
                if(notification0.getGroup() != null && (notification0.flags & 0x200) == 0 && this.h == 1) {
                    this.g(notification0);
                }
            }
            return notification0;
        }
        this.b.setExtras(this.g);
        Notification notification1 = this.b.build();
        RemoteViews remoteViews0 = this.d;
        if(remoteViews0 != null) {
            notification1.contentView = remoteViews0;
        }
        RemoteViews remoteViews1 = this.e;
        if(remoteViews1 != null) {
            notification1.bigContentView = remoteViews1;
        }
        RemoteViews remoteViews2 = this.i;
        if(remoteViews2 != null) {
            notification1.headsUpContentView = remoteViews2;
        }
        if(this.h != 0) {
            if(notification1.getGroup() != null && (notification1.flags & 0x200) != 0 && this.h == 2) {
                this.g(notification1);
            }
            if(notification1.getGroup() != null && (notification1.flags & 0x200) == 0 && this.h == 1) {
                this.g(notification1);
            }
        }
        return notification1;
    }

    private static List e(List list0, List list1) {
        if(list0 == null) {
            return list1;
        }
        if(list1 == null) {
            return list0;
        }
        b b0 = new b(list0.size() + list1.size());
        b0.addAll(list0);
        b0.addAll(list1);
        return new ArrayList(b0);
    }

    private static List f(List list0) {
        if(list0 == null) {
            return null;
        }
        List list1 = new ArrayList(list0.size());
        Iterator iterator0 = list0.iterator();
        if(!iterator0.hasNext()) {
            return list1;
        }
        Object object0 = iterator0.next();
        h.d.a(object0);
        throw null;
    }

    private void g(Notification notification0) {
        notification0.sound = null;
        notification0.vibrate = null;
        notification0.defaults &= -4;
    }
}

