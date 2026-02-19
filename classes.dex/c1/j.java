package c1;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri.Builder;
import android.net.Uri;
import android.text.TextUtils;
import l1.e;
import m1.d;

public class j {
    public static final int a;
    private static final j b;

    static {
        j.a = l.a;
        j.b = new j();
    }

    public Intent a(Context context0, int v, String s) {
        switch(v) {
            case 1: 
            case 2: {
                if(context0 != null && e.d(context0)) {
                    Intent intent0 = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
                    intent0.setPackage("com.google.android.wearable.app");
                    return intent0;
                }
                StringBuilder stringBuilder0 = new StringBuilder();
                stringBuilder0.append("gcore_");
                stringBuilder0.append(j.a);
                stringBuilder0.append("-");
                if(!TextUtils.isEmpty(s)) {
                    stringBuilder0.append(s);
                }
                stringBuilder0.append("-");
                if(context0 != null) {
                    stringBuilder0.append("com.playstack.balatro.android");
                }
                stringBuilder0.append("-");
                if(context0 != null) {
                    try {
                        stringBuilder0.append(d.a(context0).c("com.playstack.balatro.android", 0).versionCode);
                    }
                    catch(PackageManager.NameNotFoundException unused_ex) {
                    }
                }
                String s1 = stringBuilder0.toString();
                Intent intent1 = new Intent("android.intent.action.VIEW");
                Uri.Builder uri$Builder0 = Uri.parse("market://details").buildUpon().appendQueryParameter("id", "com.google.android.gms");
                if(!TextUtils.isEmpty(s1)) {
                    uri$Builder0.appendQueryParameter("pcampaignid", s1);
                }
                intent1.setData(uri$Builder0.build());
                intent1.setPackage("com.android.vending");
                intent1.addFlags(0x80000);
                return intent1;
            }
            case 3: {
                Uri uri0 = Uri.fromParts("package", "com.google.android.gms", null);
                Intent intent2 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent2.setData(uri0);
                return intent2;
            }
            default: {
                return null;
            }
        }
    }

    public PendingIntent b(Context context0, int v, int v1) {
        return this.c(context0, v, v1, null);
    }

    public PendingIntent c(Context context0, int v, int v1, String s) {
        Intent intent0 = this.a(context0, v, s);
        return intent0 == null ? null : PendingIntent.getActivity(context0, v1, intent0, b2.d.a | 0x8000000);
    }

    public String d(int v) {
        return l.a(v);
    }

    public static j e() {
        return j.b;
    }

    public int f(Context context0) {
        return this.g(context0, j.a);
    }

    public int g(Context context0, int v) {
        int v1 = l.d(context0, v);
        return l.e(context0, v1) ? 18 : v1;
    }

    public boolean h(Context context0, String s) {
        return l.h(context0, s);
    }

    public boolean i(int v) {
        return l.g(v);
    }
}

