package y2;

import android.content.Context;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import x2.c0;
import x2.k0;

public class f implements InvocationHandler {
    static abstract class a {
        static final int[] a;

        static {
            int[] arr_v = new int[b.values().length];
            a.a = arr_v;
            try {
                arr_v[b.f.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                a.a[b.g.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                a.a[b.h.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
        }
    }

    static enum b {
        STATUS_OK(0),
        STATUS_FEATURE_NOT_SUPPORTED(1),
        STATUS_SERVICE_UNAVAILABLE(2);

        private int e;

        private b(int v1) {
            this.e = v1;
        }
    }

    private Context a;
    private Object b;
    private String c;
    private final e d;
    private static final k0 e;

    static {
        f.e = k0.f("f");
    }

    public f(Context context0, String s, e e0) {
        this.a = context0;
        this.d = e0;
        this.c = s;
    }

    private void a() {
        try {
            Object object0 = this.b;
            if(object0 == null) {
                return;
            }
            c0.f(object0, "endConnection", null, new Object[0]);
        }
        catch(Exception exception0) {
            f.e.e("closeReferrerClient %s", new Object[]{exception0.getMessage()});
        }
        this.b = null;
    }

    private Object b(Context context0) {
        try {
            return c0.f(c0.h((this.c + ".InstallReferrerClient"), "newBuilder", new Class[]{Context.class}, new Object[]{context0}), "build", null, new Object[0]);
        }
        catch(Throwable throwable0) {
            f.e.e("could not create install referrer client %s", new Object[]{throwable0.getMessage()});
            return null;
        }
    }

    private Object c(Class class0) {
        try {
            return Proxy.newProxyInstance(class0.getClassLoader(), new Class[]{class0}, this);
        }
        catch(Exception exception0) {
            f.e.e("InstallReferrer proxy exception %s", new Object[]{exception0.getMessage()});
            return null;
        }
    }

    private long d(Object object0) {
        if(object0 == null) {
            return -1L;
        }
        try {
            return (long)(((Long)c0.f(object0, "getInstallBeginTimestampSeconds", null, new Object[0])));
        }
        catch(Exception exception0) {
            f.e.e("getInstallBeginTimestampSeconds error %s", new Object[]{exception0.getMessage()});
            return -1L;
        }
    }

    private Object e() {
        Object object0 = this.b;
        if(object0 == null) {
            return null;
        }
        try {
            return c0.f(object0, "getInstallReferrer", null, new Object[0]);
        }
        catch(Exception exception0) {
            f.e.e("getInstallReferrer error %s", new Object[]{exception0.getMessage()});
            return null;
        }
    }

    private Class f() {
        try {
            return Class.forName((this.c + ".InstallReferrerStateListener"));
        }
        catch(Exception exception0) {
            f.e.e("getInstallReferrerStateListenerClass %s", new Object[]{exception0.getMessage()});
            return null;
        }
    }

    private long g(Object object0) {
        if(object0 == null) {
            return -1L;
        }
        try {
            return (long)(((Long)c0.f(object0, "getReferrerClickTimestampSeconds", null, new Object[0])));
        }
        catch(Exception exception0) {
            f.e.e("getReferrerClickTimestampSeconds error %s", new Object[]{exception0.getMessage()});
            return -1L;
        }
    }

    private String h(Object object0) {
        if(object0 == null) {
            return null;
        }
        try {
            return (String)c0.f(object0, "getInstallReferrer", null, new Object[0]);
        }
        catch(Exception exception0) {
            f.e.e("getStringInstallReferrer error %s", new Object[]{exception0.getMessage()});
            return null;
        }
    }

    private void i(int v) {
        switch(b.values()[v]) {
            case 1: {
                try {
                    Object object0 = this.e();
                    HashMap hashMap0 = new HashMap();
                    hashMap0.put("referral_url", this.h(object0));
                    hashMap0.put("click_time", this.g(object0));
                    hashMap0.put("install_time", this.d(object0));
                    this.d.a(hashMap0);
                }
                catch(Exception exception0) {
                    f.e.e("Couldn\'t get install referrer %s", new Object[]{exception0.getMessage()});
                }
                return;
            }
            case 2: {
                f.e.a("STATUS_FEATURE_NOT_SUPPORTED");
                break;
            }
            case 3: {
                f.e.a("STATUS_SERVICE_UNAVAILABLE");
                break;
            }
            default: {
                f.e.b("Unexpected response code of install referrer response %d", new Object[]{v});
                break;
            }
        }
        this.d.a(null);
    }

    @Override
    public Object invoke(Object object0, Method method0, Object[] arr_object) {
        try {
            if(method0 == null) {
                f.e.c("InstallReferrer invoke method null");
                return null;
            }
            String s = method0.getName();
            if(s == null) {
                f.e.c("InstallReferrer invoke method name null");
                return null;
            }
            if(s.equals("onInstallReferrerSetupFinished")) {
                if(arr_object != null && arr_object.length == 1) {
                    Object object1 = arr_object[0];
                    if(!(object1 instanceof Integer)) {
                        f.e.c("onInstallReferrerSetupFinished invalid arg");
                        return null;
                    }
                    if(((Integer)object1) == null) {
                        f.e.c("InstallReferrer invoke onInstallReferrerSetupFinished responseCode arg is null");
                        return null;
                    }
                    this.i(((int)(((Integer)object1))));
                    return null;
                }
                f.e.c("onInstallReferrerSetupFinished invalid args");
                return null;
            }
            if(s.equals("onInstallReferrerServiceDisconnected")) {
                f.e.a("onInstallReferrerServiceDisconnected");
                this.a();
                return null;
            }
        }
        catch(Throwable throwable0) {
            f.e.e("invoke error %s", new Object[]{throwable0.getMessage()});
        }
        return null;
    }

    public void j() {
        Context context0 = this.a;
        if(context0 == null) {
            f.e.c("context can not be null");
        }
        else {
            Object object0 = this.b(context0);
            this.b = object0;
            if(object0 != null) {
                Class class0 = this.f();
                if(class0 != null) {
                    Object object1 = this.c(class0);
                    if(object1 != null) {
                        this.k(class0, object1);
                        return;
                    }
                }
            }
        }
        this.d.a(null);
    }

    private void k(Class class0, Object object0) {
        try {
            c0.f(this.b, "startConnection", new Class[]{class0}, new Object[]{object0});
        }
        catch(Exception exception0) {
            f.e.e("startConnection error %s", new Object[]{exception0.getMessage()});
        }
    }
}

