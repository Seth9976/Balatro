package k0;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import com.google.android.datatransport.runtime.backends.TransportBackendDiscovery;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class k implements e {
    static class a {
        private final Context a;
        private Map b;

        a(Context context0) {
            this.b = null;
            this.a = context0;
        }

        private Map a(Context context0) {
            Bundle bundle0 = a.d(context0);
            if(bundle0 == null) {
                Log.w("BackendRegistry", "Could not retrieve metadata, returning empty list of transport backends.");
                return Collections.emptyMap();
            }
            Map map0 = new HashMap();
            for(Object object0: bundle0.keySet()) {
                String s = (String)object0;
                Object object1 = bundle0.get(s);
                if(object1 instanceof String && s.startsWith("backend:")) {
                    String[] arr_s = ((String)object1).split(",", -1);
                    for(int v = 0; v < arr_s.length; ++v) {
                        String s1 = arr_s[v].trim();
                        if(!s1.isEmpty()) {
                            map0.put(s1, s.substring(8));
                        }
                    }
                }
            }
            return map0;
        }

        d b(String s) {
            String s3;
            String s2;
            String s1 = (String)this.c().get(s);
            if(s1 == null) {
                return null;
            }
            try {
                return (d)Class.forName(s1).asSubclass(d.class).getDeclaredConstructor().newInstance();
            }
            catch(ClassNotFoundException classNotFoundException0) {
                s2 = String.format("Class %s is not found.", s1);
                Log.w("BackendRegistry", s2, classNotFoundException0);
                return null;
            }
            catch(IllegalAccessException classNotFoundException0) {
                s2 = String.format("Could not instantiate %s.", s1);
                Log.w("BackendRegistry", s2, classNotFoundException0);
                return null;
            }
            catch(InstantiationException classNotFoundException0) {
                s2 = String.format("Could not instantiate %s.", s1);
                Log.w("BackendRegistry", s2, classNotFoundException0);
                return null;
            }
            catch(NoSuchMethodException noSuchMethodException0) {
                s3 = String.format("Could not instantiate %s", s1);
            }
            catch(InvocationTargetException noSuchMethodException0) {
                s3 = String.format("Could not instantiate %s", s1);
            }
            Log.w("BackendRegistry", s3, noSuchMethodException0);
            return null;
        }

        private Map c() {
            if(this.b == null) {
                this.b = this.a(this.a);
            }
            return this.b;
        }

        private static Bundle d(Context context0) {
            try {
                PackageManager packageManager0 = context0.getPackageManager();
                if(packageManager0 == null) {
                    Log.w("BackendRegistry", "Context has no PackageManager.");
                    return null;
                }
                ServiceInfo serviceInfo0 = packageManager0.getServiceInfo(new ComponentName(context0, TransportBackendDiscovery.class), 0x80);
                if(serviceInfo0 == null) {
                    Log.w("BackendRegistry", "TransportBackendDiscovery has no service info.");
                    return null;
                }
                return serviceInfo0.metaData;
            }
            catch(PackageManager.NameNotFoundException unused_ex) {
                Log.w("BackendRegistry", "Application info not found.");
                return null;
            }
        }
    }

    private final a a;
    private final i b;
    private final Map c;

    k(Context context0, i i0) {
        this(new a(context0), i0);
    }

    k(a k$a0, i i0) {
        this.c = new HashMap();
        this.a = k$a0;
        this.b = i0;
    }

    @Override  // k0.e
    public m a(String s) {
        synchronized(this) {
            if(this.c.containsKey(s)) {
                return (m)this.c.get(s);
            }
            d d0 = this.a.b(s);
            if(d0 == null) {
                return null;
            }
            m m1 = d0.create(this.b.a(s));
            this.c.put(s, m1);
            return m1;
        }
    }
}

