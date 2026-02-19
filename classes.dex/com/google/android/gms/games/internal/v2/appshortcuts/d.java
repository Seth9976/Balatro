package com.google.android.gms.games.internal.v2.appshortcuts;

import android.content.Context;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import c1.c;
import c2.f2;
import c2.w1;
import c2.z1;
import g2.h;
import g2.k;
import java.util.List;
import p1.v;
import s1.s;
import s1.u;

final class d extends e {
    private final Context a;

    public d(Context context0) {
        super(null);
        this.a = context0.getApplicationContext();
    }

    @Override  // com.google.android.gms.games.internal.v2.appshortcuts.e
    public final void a() {
        new Thread(() -> {
            h h0;
            ShortcutManager shortcutManager0 = s1.h.a(this.a.getSystemService(ShortcutManager.class));
            if(shortcutManager0 == null) {
                return;
            }
            s s0 = u.a(this.a, PlayGamesAppShortcutsActivity.class);
            z1 z10 = d.g(shortcutManager0.getDynamicShortcuts());
            z1 z11 = d.g(shortcutManager0.getPinnedShortcuts());
            if(s0 == null || s0.a() <= 0) {
                h0 = k.b(d.e(z10, z11));
            }
            else {
                p p0 = new p(this.a);
                h0 = p0.g(com.google.android.gms.common.api.internal.d.a().e(6744).d(new c[]{v.g}).c(false).b(new j(p0, s0, z10, z11)).a()).j(f2.a(), (h h0) -> // 去混淆评级： 低(20)
                (h0.q() ? ((f)h0.n()) : d.e(z10, z11)));
            }
            h0.h(f2.a(), new s1.f(shortcutManager0));
        }, "initialize-shortcuts").start();
    }

    // 去混淆评级： 低(20)
    // 检测为 Lambda 实现
    static f c(z1 z10, z1 z11, h h0) [...]

    // 检测为 Lambda 实现
    public static void d(d d0) [...]

    private static f e(z1 z10, z1 z11) {
        return new f(d.f(z10), z1.r(), d.f(z11), z1.r());
    }

    private static z1 f(z1 z10) {
        w1 w10 = new w1();
        int v = z10.size();
        for(int v1 = 0; v1 < v; ++v1) {
            String s = ((com.google.android.gms.games.internal.v2.appshortcuts.h)z10.get(v1)).a();
            if(s != null) {
                w10.a(s);
            }
        }
        return w10.b();
    }

    private static z1 g(List list0) {
        w1 w10 = new w1();
        for(Object object0: list0) {
            ShortcutInfo shortcutInfo0 = (ShortcutInfo)object0;
            if(!shortcutInfo0.isImmutable() && shortcutInfo0.getId().startsWith("PLAY_GAMES_SERVICES_")) {
                w10.a(new com.google.android.gms.games.internal.v2.appshortcuts.h(shortcutInfo0.getId(), shortcutInfo0.getExtras(), Boolean.valueOf(shortcutInfo0.isPinned()), Boolean.valueOf(shortcutInfo0.isEnabled())));
            }
        }
        return w10.b();
    }
}

