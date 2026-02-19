package androidx.core.os;

import android.os.LocaleList;
import java.util.Locale;

final class l implements f {
    private final LocaleList a;

    l(Object object0) {
        this.a = (LocaleList)object0;
    }

    @Override  // androidx.core.os.f
    public Object a() {
        return this.a;
    }

    @Override
    public boolean equals(Object object0) {
        Object object1 = ((f)object0).a();
        return this.a.equals(object1);
    }

    @Override  // androidx.core.os.f
    public Locale get(int v) {
        return this.a.get(v);
    }

    @Override
    public int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public String toString() {
        return this.a.toString();
    }
}

