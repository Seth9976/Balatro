package x2;

import android.content.Context;
import android.os.Build;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

abstract class z {
    private static final int[] a;

    static {
        z.a = new int[]{1008610, 1008611, 1008612, 1008613, 1008614, 1008615};
    }

    private static Class b(String s) {
        try {
            return Class.forName(s);
        }
        catch(ClassNotFoundException unused_ex) {
            return null;
        }
    }

    private static String c(Context context0) {
        try {
            Class class0 = Context.class;
            Class class1 = z.b("com.huawei.hms.ads.identifier.AdvertisingIdClient");
            if(((Boolean)class1.getMethod("isAdvertisingIdAvailable", new Class[]{class0}).invoke(null, new Object[]{context0})).booleanValue()) {
                Object object0 = class1.getMethod("getAdvertisingIdInfo", class0).invoke(null, context0);
                return (String)object0.getClass().getDeclaredMethod("getId").invoke(object0);
            }
        }
        catch(Throwable unused_ex) {
        }
        return null;
    }

    private static String d(Context context0) {
        class a implements InvocationHandler {
            final BlockingQueue a;

            a(BlockingQueue blockingQueue0) {
            }

            @Override
            public Object invoke(Object object0, Method method0, Object[] arr_object) {
                if(arr_object == null || arr_object.length <= 1) {
                    this.a.offer("");
                }
                String s = z.e(arr_object[1]);
                this.a.offer(s);
                return null;
            }
        }

        if(!z.k()) {
            return null;
        }
        try {
            LinkedBlockingQueue linkedBlockingQueue0 = new LinkedBlockingQueue();
            z.g(context0);
            Class class0 = z.b("com.bun.miitmdid.core.IIdentifierListener");
            if(class0 == null) {
                return null;
            }
            if(z.j(z.h(context0, Proxy.newProxyInstance(class0.getClassLoader(), new Class[]{class0}, new a(linkedBlockingQueue0)), class0))) {
                return null;
            }
            String s = (String)linkedBlockingQueue0.poll(1L, TimeUnit.SECONDS);
            if(!p0.V(s)) {
                return s;
            }
        }
        catch(Throwable unused_ex) {
        }
        return null;
    }

    private static String e(Object object0) {
        if(object0 == null) {
            return "";
        }
        try {
            return (String)object0.getClass().getMethod("getOAID").invoke(object0);
        }
        catch(Throwable unused_ex) {
            return "";
        }
    }

    // 去混淆评级： 低(20)
    static String f(Context context0) {
        return z.i() ? z.c(context0) : z.d(context0);
    }

    private static void g(Context context0) {
        z.b("com.bun.miitmdid.core.JLibrary").getMethod("InitEntry", Context.class).invoke(null, context0);
    }

    private static int h(Context context0, Object object0, Class class0) {
        try {
            return (int)(((Integer)z.b("com.bun.miitmdid.core.MdidSdkHelper").getMethod("InitSdk", Context.class, Boolean.TYPE, class0).invoke(null, context0, Boolean.FALSE, object0)));
        }
        catch(Throwable unused_ex) {
            return z.a[0];
        }
    }

    private static boolean i() {
        return Build.MANUFACTURER.equalsIgnoreCase("huawei") && z.b("com.huawei.hms.ads.identifier.AdvertisingIdClient") != null;
    }

    private static boolean j(int v) {
        return Arrays.asList(new int[][]{z.a}).contains(v);
    }

    private static boolean k() {
        return z.b("com.bun.miitmdid.core.MdidSdkHelper") != null;
    }
}

