package y2;

import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.ResolveInfoFlags;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import x2.k0;
import x2.p0;

public class c {
    private static final k0 a;

    static {
        c.a = k0.f("c");
    }

    private boolean a(Context context0, String s, ResolveInfo resolveInfo0) {
        return s != null && context0.getPackageManager().checkPermission(s, resolveInfo0.providerInfo.packageName) == 0;
    }

    private String b(Context context0, ResolveInfo resolveInfo0) {
        String s = resolveInfo0.providerInfo.authority;
        return p0.V(s) ? null : this.g(context0, s);
    }

    public void c(Context context0, e e0) {
        if(context0 == null) {
            e0.a(null);
            return;
        }
        HashMap hashMap0 = new HashMap();
        String s = this.f(context0, "android.permission.INSTALL_PACKAGES");
        if(s != null) {
            hashMap0.put("dt_referrer", s);
            e0.a(hashMap0);
            return;
        }
        e0.a(null);
    }

    private String d(String s, String s1) {
        return String.format("content://%s/%s", s, s1);
    }

    private String e(Context context0, String s, ContentProviderClient contentProviderClient0) {
        try {
            Uri uri0 = Uri.parse(s);
            String[] arr_s = {"encrypted_data"};
            Cursor cursor0 = contentProviderClient0 == null ? context0.getContentResolver().query(uri0, arr_s, null, null, null) : contentProviderClient0.query(uri0, arr_s, "package_name=?", new String[]{"com.playstack.balatro.android"}, null);
            if(cursor0 == null) {
                c.a.b("Read content provider cursor null content uri [%s]", new Object[]{s});
                return null;
            }
            if(!cursor0.moveToFirst()) {
                c.a.b("Read content provider cursor empty content uri [%s]", new Object[]{s});
                cursor0.close();
                return null;
            }
            String s1 = cursor0.getString(0);
            c.a.a("Read Content Provider Payload is " + s1);
            cursor0.close();
            return s1;
        }
        catch(Throwable throwable0) {
            c.a.e("Exception read content provider uri [%s] error [%s]", new Object[]{s, throwable0.getMessage()});
            return null;
        }
    }

    private String f(Context context0, String s) {
        try {
            List list0 = Build.VERSION.SDK_INT < 33 ? context0.getPackageManager().queryIntentContentProviders(new Intent("com.singular.preinstall.READ_PERMISSION_SINGULAR"), 0x20000) : context0.getPackageManager().queryIntentContentProviders(new Intent("com.singular.preinstall.READ_PERMISSION_SINGULAR"), PackageManager.ResolveInfoFlags.of(0x20000L));
            ArrayList arrayList0 = new ArrayList();
            for(Object object0: list0) {
                ResolveInfo resolveInfo0 = (ResolveInfo)object0;
                if(this.a(context0, s, resolveInfo0)) {
                    String s1 = this.b(context0, resolveInfo0);
                    if(!p0.V(s1)) {
                        arrayList0.add(s1);
                    }
                }
            }
            if(!arrayList0.isEmpty()) {
                c.a.a("Payload read successfully from URI: " + arrayList0);
                return (String)arrayList0.get(0);
            }
        }
        catch(Throwable unused_ex) {
        }
        c.a.a("No payloads found in content providers.");
        return null;
    }

    private String g(Context context0, String s) {
        try {
            ContentProviderClient contentProviderClient0 = context0.getContentResolver().acquireUnstableContentProviderClient(s);
            String s1 = this.e(context0, this.d(s, "trackers"), contentProviderClient0);
            contentProviderClient0.release();
            return s1;
        }
        catch(Throwable unused_ex) {
            return null;
        }
    }
}

