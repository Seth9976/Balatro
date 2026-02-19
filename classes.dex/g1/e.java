package g1;

import android.accounts.Account;
import android.view.View;
import h.d;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import k.b;

public final class e {
    public static final class a {
        private Account a;
        private b b;
        private String c;
        private String d;
        private final e2.a e;

        public a() {
            this.e = e2.a.n;
        }

        public e a() {
            return new e(this.a, this.b, null, 0, null, this.c, this.d, this.e, false);
        }

        public a b(String s) {
            this.c = s;
            return this;
        }

        public final a c(Collection collection0) {
            if(this.b == null) {
                this.b = new b();
            }
            this.b.addAll(collection0);
            return this;
        }

        public final a d(Account account0) {
            this.a = account0;
            return this;
        }

        public final a e(String s) {
            this.d = s;
            return this;
        }
    }

    private final Account a;
    private final Set b;
    private final Set c;
    private final Map d;
    private final int e;
    private final View f;
    private final String g;
    private final String h;
    private final e2.a i;
    private Integer j;

    public e(Account account0, Set set0, Map map0, int v, View view0, String s, String s1, e2.a a0, boolean z) {
        this.a = account0;
        Set set1 = set0 == null ? Collections.emptySet() : Collections.unmodifiableSet(set0);
        this.b = set1;
        if(map0 == null) {
            map0 = Collections.emptyMap();
        }
        this.d = map0;
        this.f = view0;
        this.e = v;
        this.g = s;
        this.h = s1;
        if(a0 == null) {
            a0 = e2.a.n;
        }
        this.i = a0;
        HashSet hashSet0 = new HashSet(set1);
        Iterator iterator0 = map0.values().iterator();
        if(!iterator0.hasNext()) {
            this.c = Collections.unmodifiableSet(hashSet0);
            return;
        }
        Object object0 = iterator0.next();
        d.a(object0);
        throw null;
    }

    public Account a() {
        return this.a;
    }

    public String b() {
        return this.a == null ? null : this.a.name;
    }

    public Account c() {
        return this.a == null ? new Account("<<default account>>", "com.google") : this.a;
    }

    public Set d() {
        return this.c;
    }

    public Set e(d1.a a0) {
        d.a(this.d.get(a0));
        return this.b;
    }

    public int f() {
        return this.e;
    }

    public String g() {
        return this.g;
    }

    public Set h() {
        return this.b;
    }

    public View i() {
        return this.f;
    }

    public final e2.a j() {
        return this.i;
    }

    public final Integer k() {
        return this.j;
    }

    public final String l() {
        return this.h;
    }

    public final void m(Integer integer0) {
        this.j = integer0;
    }
}

