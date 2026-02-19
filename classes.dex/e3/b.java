package e3;

import k3.f;
import q3.m;

public abstract class b {
    public static final a a;

    static {
        a a0;
        int v = b.a();
        Class class0 = a.class;
        if(v < 0x10008 && v >= 0x10000) {
        label_21:
            if(v < 0x10007 && v >= 0x10000) {
                a0 = new a();
            }
            else {
                try {
                    Object object2 = f3.a.class.newInstance();
                    f.d(object2, "forName(\"kotlin.internal…entations\").newInstance()");
                    if(object2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                    else {
                        try {
                            a0 = (a)object2;
                            b.a = a0;
                            return;
                        }
                        catch(ClassCastException classCastException2) {
                        }
                    }
                    if(f.a(object2.getClass().getClassLoader(), class0.getClassLoader())) {
                        throw classCastException2;
                    }
                    goto label_31;
                }
                catch(ClassNotFoundException unused_ex) {
                    try {
                    label_31:
                        Object object3 = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
                        f.d(object3, "forName(\"kotlin.internal…entations\").newInstance()");
                        if(object3 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                        }
                        else {
                            try {
                                a0 = (a)object3;
                                b.a = a0;
                                return;
                            }
                            catch(ClassCastException classCastException3) {
                            }
                        }
                        if(f.a(object3.getClass().getClassLoader(), class0.getClassLoader())) {
                            throw classCastException3;
                        }
                    }
                    catch(ClassNotFoundException unused_ex) {
                    }
                    a0 = new a();
                    b.a = a0;
                    return;
                }
            }
        }
        else {
            try {
                Object object0 = g3.a.class.newInstance();
                f.d(object0, "forName(\"kotlin.internal…entations\").newInstance()");
                if(object0 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                }
                else {
                    try {
                        a0 = (a)object0;
                        b.a = a0;
                        return;
                    }
                    catch(ClassCastException classCastException0) {
                    }
                }
                if(f.a(object0.getClass().getClassLoader(), class0.getClassLoader())) {
                    throw classCastException0;
                }
                goto label_12;
            }
            catch(ClassNotFoundException unused_ex) {
                try {
                label_12:
                    Object object1 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
                    f.d(object1, "forName(\"kotlin.internal…entations\").newInstance()");
                    if(object1 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                    else {
                        try {
                            a0 = (a)object1;
                            b.a = a0;
                            return;
                        }
                        catch(ClassCastException classCastException1) {
                        }
                    }
                    if(f.a(object1.getClass().getClassLoader(), class0.getClassLoader())) {
                        throw classCastException1;
                    }
                }
                catch(ClassNotFoundException unused_ex) {
                }
                goto label_21;
            }
        }
        b.a = a0;
    }

    // 去混淆评级： 低(33)
    private static final int a() {
        int v = m.k("0.9", '.', 0, false, 6, null);
        if(v < 0) {
            try {
                return Integer.parseInt("0.9") * 0x10000;
            }
            catch(NumberFormatException unused_ex) {
                return 0x10006;
            }
        }
        boolean z = m.k("0.9", '.', v + 1, false, 4, null) >= 0;
        f.d("0", "this as java.lang.String…ing(startIndex, endIndex)");
        f.d("9", "this as java.lang.String…ing(startIndex, endIndex)");
        return 9;
    }
}

