package com.google.android.gms.games.internal.v2.appshortcuts;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.PersistableBundle;
import c1.c;
import c2.k1;
import c2.w1;
import c2.z1;
import com.google.android.gms.common.api.internal.d;
import java.util.List;
import p1.v;
import s1.s;
import s1.u;
import s1.x;

public final class PlayGamesAppShortcutsActivity extends Activity {
    private Intent a;

    // 检测为 Lambda 实现
    public static void a(PlayGamesAppShortcutsActivity playGamesAppShortcutsActivity0) [...]

    @Override  // android.app.Activity
    protected final void onActivityResult(int v, int v1, Intent intent0) {
        super.onActivityResult(v, v1, intent0);
        if(v != 1005000000) {
            return;
        }
        if(v1 != -1) {
            this.finish();
            return;
        }
        new k1(Looper.getMainLooper()).postDelayed(() -> {
            this.startActivityForResult(this.a, 1005000001);
            this.finish();
            System.exit(0);
        }, 50L);
    }

    @Override  // android.app.Activity
    protected final void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        if(Build.VERSION.SDK_INT < 25) {
            this.finish();
            return;
        }
        s s0 = u.a(this, PlayGamesAppShortcutsActivity.class);
        if(s0 == null) {
            this.finish();
            return;
        }
        String s1 = s0.b();
        if(s1 == null || s1.isEmpty()) {
            Intent intent0 = new Intent("android.intent.action.MAIN").addCategory("android.intent.category.LAUNCHER").setPackage("com.playstack.balatro.android");
            List list0 = this.getPackageManager().queryIntentActivities(intent0, 0xC2200);
            w1 w10 = new w1();
            for(Object object0: list0) {
                ResolveInfo resolveInfo0 = (ResolveInfo)object0;
                ActivityInfo activityInfo0 = resolveInfo0.activityInfo;
                if(activityInfo0 != null) {
                    int v = this.getPackageManager().getComponentEnabledSetting(new ComponentName(activityInfo0.packageName, activityInfo0.name));
                    if(v != 0) {
                        if(v == 1) {
                            goto label_24;
                        }
                        continue;
                    }
                    else if(!activityInfo0.enabled) {
                        continue;
                    }
                label_24:
                    if(resolveInfo0.activityInfo.exported) {
                        w10.a(resolveInfo0);
                    }
                }
            }
            s1 = null;
            z1 z10 = w10.b();
            int v1 = z10.size();
            int v2 = 0;
            while(v2 < v1) {
                ActivityInfo activityInfo1 = ((ResolveInfo)z10.get(v2)).activityInfo;
                ++v2;
                if(activityInfo1 != null) {
                    s1 = activityInfo1.name;
                    break;
                }
            }
        }
        Intent intent1 = s1 == null || s1.isEmpty() ? null : new Intent().setComponent(new ComponentName("com.playstack.balatro.android", s1)).setPackage("com.playstack.balatro.android").addFlags(0x14008000);
        if(intent1 == null) {
            this.finish();
            return;
        }
        this.a = intent1;
        p p0 = new p(this);
        Intent intent2 = this.getIntent();
        h h0 = new h(intent2.getStringExtra("com.google.android.gms.games.EXTRA_APP_SHORTCUT_ID"), ((PersistableBundle)intent2.getParcelableExtra("com.google.android.gms.games.EXTRA_APP_SHORTCUT_EXTRAS")), null, Boolean.TRUE);
        p0.g(d.a().e(6745).d(new c[]{v.g}).c(false).b(new k(p0, s0, h0)).a()).b(this, new x(this));
    }
}

