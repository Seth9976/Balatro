package t;

import android.text.Editable.Factory;
import android.text.Editable;
import androidx.emoji2.text.n;

final class b extends Editable.Factory {
    private static final Object a;
    private static volatile Editable.Factory b;
    private static Class c;

    static {
        b.a = new Object();
    }

    private b() {
        try {
            b.c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, b.class.getClassLoader());
        }
        catch(Throwable unused_ex) {
        }
    }

    @Override  // android.text.Editable$Factory
    public static Editable.Factory getInstance() {
        if(b.b == null) {
            Object object0 = b.a;
            synchronized(object0) {
                if(b.b == null) {
                    b.b = new b();
                }
                return b.b;
            }
        }
        return b.b;
    }

    @Override  // android.text.Editable$Factory
    public Editable newEditable(CharSequence charSequence0) {
        Class class0 = b.c;
        return class0 != null ? n.c(class0, charSequence0) : super.newEditable(charSequence0);
    }
}

