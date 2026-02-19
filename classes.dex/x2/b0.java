package x2;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import java.util.HashMap;
import jeb.synthetic.TWR;
import y2.e;

public class b0 {
    public void a(Context context0, e e0) {
        Cursor cursor0;
        String s1;
        if(context0 == null) {
            e0.a(null);
            return;
        }
        String s = i0.t().B().c;
        if(p0.V(s)) {
            e0.a(null);
            return;
        }
        try {
            if(context0.getPackageManager().resolveContentProvider("com.facebook.katana.provider.InstallReferrerProvider", 0) == null) {
                if(context0.getPackageManager().resolveContentProvider("com.instagram.contentprovider.InstallReferrerProvider", 0) == null) {
                    e0.a(null);
                    return;
                }
                s1 = String.format("content://%s/%s", "com.instagram.contentprovider.InstallReferrerProvider", s);
            }
            else {
                s1 = String.format("content://%s/%s", "com.facebook.katana.provider.InstallReferrerProvider", s);
            }
            Uri uri0 = Uri.parse(s1);
            cursor0 = context0.getContentResolver().query(uri0, new String[]{"install_referrer", "is_ct", "actual_timestamp"}, null, null, null);
        }
        catch(Exception unused_ex) {
            cursor0 = null;
            goto label_44;
        }
        catch(Throwable throwable0) {
            TWR.safeClose$NT(null, throwable0);
            throw throwable0;
        }
        if(cursor0 == null) {
            try {
                e0.a(null);
                return;
            label_25:
                if(cursor0.moveToFirst()) {
                    int v = cursor0.getColumnIndex("install_referrer");
                    int v1 = cursor0.getColumnIndex("actual_timestamp");
                    int v2 = cursor0.getColumnIndex("is_ct");
                    int v3 = -1;
                    String s2 = v == -1 || cursor0.getType(v) != 3 ? null : cursor0.getString(v);
                    int v4 = v1 == -1 || cursor0.getType(v1) != 3 ? -1 : Integer.parseInt(cursor0.getString(v1));
                    if(v2 != -1 && cursor0.getType(v2) == 3) {
                        v3 = Integer.parseInt(cursor0.getString(v2));
                    }
                    HashMap hashMap0 = new HashMap();
                    hashMap0.put("facebook_install_referrer", s2);
                    hashMap0.put("facebook_actual_timestamp", v4);
                    hashMap0.put("facebook_is_ct", v3);
                    e0.a(hashMap0);
                    goto label_39;
                }
                goto label_41;
            }
            catch(Exception unused_ex) {
                goto label_44;
            }
            catch(Throwable throwable0) {
                goto label_49;
            }
        }
        goto label_25;
    label_39:
        cursor0.close();
        return;
        try {
            try {
            label_41:
                cursor0.close();
                e0.a(null);
                goto label_51;
            }
            catch(Exception unused_ex) {
            }
        label_44:
            e0.a(null);
            if(cursor0 != null) {
                goto label_46;
            }
            return;
        }
        catch(Throwable throwable0) {
            goto label_49;
        }
    label_46:
        cursor0.close();
        return;
    label_49:
        TWR.safeClose$NT(cursor0, throwable0);
        throw throwable0;
    label_51:
        cursor0.close();
    }
}

