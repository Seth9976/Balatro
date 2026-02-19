package androidx.emoji2.text;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Build.VERSION;
import android.util.Log;
import androidx.core.provider.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class c {
    public static class a {
        private final b a;

        public a(b c$b0) {
            if(c$b0 == null) {
                c$b0 = a.e();
            }
            this.a = c$b0;
        }

        private androidx.emoji2.text.e.c a(Context context0, e e0) {
            return e0 == null ? null : new j(context0, e0);
        }

        private List b(Signature[] arr_signature) {
            ArrayList arrayList0 = new ArrayList();
            for(int v = 0; v < arr_signature.length; ++v) {
                arrayList0.add(arr_signature[v].toByteArray());
            }
            return Collections.singletonList(arrayList0);
        }

        public androidx.emoji2.text.e.c c(Context context0) {
            return this.a(context0, this.h(context0));
        }

        private e d(ProviderInfo providerInfo0, PackageManager packageManager0) {
            return new e(providerInfo0.authority, providerInfo0.packageName, "emojicompat-emoji-font", this.b(this.a.b(packageManager0, providerInfo0.packageName)));
        }

        private static b e() {
            return Build.VERSION.SDK_INT >= 28 ? new d() : new androidx.emoji2.text.c.c();
        }

        // 去混淆评级： 低(20)
        private boolean f(ProviderInfo providerInfo0) {
            return providerInfo0 != null && (providerInfo0.applicationInfo != null && (providerInfo0.applicationInfo.flags & 1) == 1);
        }

        private ProviderInfo g(PackageManager packageManager0) {
            Intent intent0 = new Intent("androidx.content.action.LOAD_EMOJI_FONT");
            for(Object object0: this.a.c(packageManager0, intent0, 0)) {
                ProviderInfo providerInfo0 = this.a.a(((ResolveInfo)object0));
                if(this.f(providerInfo0)) {
                    return providerInfo0;
                }
                if(false) {
                    break;
                }
            }
            return null;
        }

        e h(Context context0) {
            PackageManager packageManager0 = context0.getPackageManager();
            androidx.core.util.c.e(packageManager0, "Package manager required to locate emoji font provider");
            ProviderInfo providerInfo0 = this.g(packageManager0);
            if(providerInfo0 == null) {
                return null;
            }
            try {
                return this.d(providerInfo0, packageManager0);
            }
            catch(PackageManager.NameNotFoundException packageManager$NameNotFoundException0) {
                Log.wtf("emoji2.text.DefaultEmojiConfig", packageManager$NameNotFoundException0);
                return null;
            }
        }
    }

    public static abstract class b {
        public abstract ProviderInfo a(ResolveInfo arg1);

        public Signature[] b(PackageManager packageManager0, String s) {
            return packageManager0.getPackageInfo(s, 0x40).signatures;
        }

        public abstract List c(PackageManager arg1, Intent arg2, int arg3);
    }

    public static class androidx.emoji2.text.c.c extends b {
        @Override  // androidx.emoji2.text.c$b
        public ProviderInfo a(ResolveInfo resolveInfo0) {
            return resolveInfo0.providerInfo;
        }

        @Override  // androidx.emoji2.text.c$b
        public List c(PackageManager packageManager0, Intent intent0, int v) {
            return packageManager0.queryIntentContentProviders(intent0, v);
        }
    }

    public static class d extends androidx.emoji2.text.c.c {
        @Override  // androidx.emoji2.text.c$b
        public Signature[] b(PackageManager packageManager0, String s) {
            return packageManager0.getPackageInfo(s, 0x40).signatures;
        }
    }

    public static j a(Context context0) {
        return (j)new a(null).c(context0);
    }
}

