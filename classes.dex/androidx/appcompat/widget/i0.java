package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources.Theme;
import android.content.res.Resources;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class i0 extends ContextWrapper {
    private final Resources a;
    private final Resources.Theme b;
    private static final Object c;
    private static ArrayList d;

    static {
        i0.c = new Object();
    }

    private i0(Context context0) {
        super(context0);
        this.a = new k0(this, context0.getResources());
        this.b = null;
    }

    // 去混淆评级： 中等(60)
    private static boolean a(Context context0) {
        return !(context0 instanceof i0) && !(context0.getResources() instanceof k0) && !(context0.getResources() instanceof u0) && false;
    }

    public static Context b(Context context0) {
        if(i0.a(context0)) {
            Object object0 = i0.c;
            synchronized(object0) {
                ArrayList arrayList0 = i0.d;
                if(arrayList0 == null) {
                    i0.d = new ArrayList();
                }
                else {
                    for(int v1 = arrayList0.size() - 1; v1 >= 0; --v1) {
                        WeakReference weakReference0 = (WeakReference)i0.d.get(v1);
                        if(weakReference0 == null || weakReference0.get() == null) {
                            i0.d.remove(v1);
                        }
                    }
                    for(int v2 = i0.d.size() - 1; v2 >= 0; --v2) {
                        WeakReference weakReference1 = (WeakReference)i0.d.get(v2);
                        Context context1 = weakReference1 == null ? null : ((i0)weakReference1.get());
                        if(context1 != null && ((ContextWrapper)context1).getBaseContext() == context0) {
                            return context1;
                        }
                    }
                }
                Context context2 = new i0(context0);
                i0.d.add(new WeakReference(context2));
                return context2;
            }
        }
        return context0;
    }

    @Override  // android.content.ContextWrapper
    public AssetManager getAssets() {
        return this.a.getAssets();
    }

    @Override  // android.content.ContextWrapper
    public Resources getResources() {
        return this.a;
    }

    @Override  // android.content.ContextWrapper
    public Resources.Theme getTheme() {
        return this.b == null ? super.getTheme() : this.b;
    }

    @Override  // android.content.ContextWrapper
    public void setTheme(int v) {
        Resources.Theme resources$Theme0 = this.b;
        if(resources$Theme0 == null) {
            super.setTheme(v);
            return;
        }
        resources$Theme0.applyStyle(v, true);
    }
}

