package com.google.android.gms.auth.api.signin;

import a1.b;
import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import d1.a.d;
import g1.q;
import h1.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import z0.c;

@Deprecated
public class GoogleSignInOptions extends a implements ReflectedParcelable, d {
    public static final class com.google.android.gms.auth.api.signin.GoogleSignInOptions.a {
        private Set a;
        private boolean b;
        private boolean c;
        private boolean d;
        private String e;
        private Account f;
        private String g;
        private Map h;
        private String i;

        public com.google.android.gms.auth.api.signin.GoogleSignInOptions.a() {
            this.a = new HashSet();
            this.h = new HashMap();
        }

        public com.google.android.gms.auth.api.signin.GoogleSignInOptions.a(GoogleSignInOptions googleSignInOptions0) {
            this.a = new HashSet();
            this.h = new HashMap();
            q.i(googleSignInOptions0);
            this.a = new HashSet(googleSignInOptions0.f);
            this.b = googleSignInOptions0.i;
            this.c = googleSignInOptions0.j;
            this.d = googleSignInOptions0.h;
            this.e = googleSignInOptions0.k;
            this.f = googleSignInOptions0.g;
            this.g = googleSignInOptions0.l;
            this.h = GoogleSignInOptions.D0(googleSignInOptions0.m);
            this.i = googleSignInOptions0.n;
        }

        public GoogleSignInOptions a() {
            if(this.a.contains(GoogleSignInOptions.v)) {
                Scope scope0 = GoogleSignInOptions.u;
                if(this.a.contains(scope0)) {
                    this.a.remove(scope0);
                }
            }
            if(this.d && (this.f == null || !this.a.isEmpty())) {
                this.b();
            }
            return new GoogleSignInOptions(3, new ArrayList(this.a), this.f, this.d, this.b, this.c, this.e, this.g, this.h, this.i, null);
        }

        public com.google.android.gms.auth.api.signin.GoogleSignInOptions.a b() {
            this.a.add(GoogleSignInOptions.t);
            return this;
        }

        public com.google.android.gms.auth.api.signin.GoogleSignInOptions.a c() {
            this.a.add(GoogleSignInOptions.r);
            return this;
        }

        public com.google.android.gms.auth.api.signin.GoogleSignInOptions.a d(Scope scope0, Scope[] arr_scope) {
            this.a.add(scope0);
            this.a.addAll(Arrays.asList(arr_scope));
            return this;
        }

        public com.google.android.gms.auth.api.signin.GoogleSignInOptions.a e(String s) {
            this.i = s;
            return this;
        }
    }

    public static final Parcelable.Creator CREATOR;
    final int e;
    private final ArrayList f;
    private Account g;
    private boolean h;
    private final boolean i;
    private final boolean j;
    private String k;
    private String l;
    private ArrayList m;
    private String n;
    private Map o;
    public static final GoogleSignInOptions p;
    public static final GoogleSignInOptions q;
    public static final Scope r;
    public static final Scope s;
    public static final Scope t;
    public static final Scope u;
    public static final Scope v;
    private static final Comparator w;

    static {
        GoogleSignInOptions.r = new Scope("profile");
        GoogleSignInOptions.s = new Scope("email");
        GoogleSignInOptions.t = new Scope("openid");
        Scope scope0 = new Scope("https://www.googleapis.com/auth/games_lite");
        GoogleSignInOptions.u = scope0;
        GoogleSignInOptions.v = new Scope("https://www.googleapis.com/auth/games");
        com.google.android.gms.auth.api.signin.GoogleSignInOptions.a googleSignInOptions$a0 = new com.google.android.gms.auth.api.signin.GoogleSignInOptions.a();
        googleSignInOptions$a0.b();
        googleSignInOptions$a0.c();
        GoogleSignInOptions.p = googleSignInOptions$a0.a();
        com.google.android.gms.auth.api.signin.GoogleSignInOptions.a googleSignInOptions$a1 = new com.google.android.gms.auth.api.signin.GoogleSignInOptions.a();
        googleSignInOptions$a1.d(scope0, new Scope[0]);
        GoogleSignInOptions.q = googleSignInOptions$a1.a();
        GoogleSignInOptions.CREATOR = new e();
        GoogleSignInOptions.w = new com.google.android.gms.auth.api.signin.d();
    }

    GoogleSignInOptions(int v, ArrayList arrayList0, Account account0, boolean z, boolean z1, boolean z2, String s, String s1, ArrayList arrayList1, String s2) {
        this(v, arrayList0, account0, z, z1, z2, s, s1, GoogleSignInOptions.D0(arrayList1), s2);
    }

    private GoogleSignInOptions(int v, ArrayList arrayList0, Account account0, boolean z, boolean z1, boolean z2, String s, String s1, Map map0, String s2) {
        this.e = v;
        this.f = arrayList0;
        this.g = account0;
        this.h = z;
        this.i = z1;
        this.j = z2;
        this.k = s;
        this.l = s1;
        this.m = new ArrayList(map0.values());
        this.o = map0;
        this.n = s2;
    }

    GoogleSignInOptions(int v, ArrayList arrayList0, Account account0, boolean z, boolean z1, boolean z2, String s, String s1, Map map0, String s2, c c0) {
        this(3, arrayList0, account0, z, z1, z2, s, s1, map0, s2);
    }

    private static Map D0(List list0) {
        Map map0 = new HashMap();
        if(list0 != null) {
            for(Object object0: list0) {
                map0.put(((a1.a)object0).j0(), ((a1.a)object0));
            }
        }
        return map0;
    }

    @Override
    public boolean equals(Object object0) {
        if(object0 == null) {
            return false;
        }
        try {
            if(this.m.isEmpty() && ((GoogleSignInOptions)object0).m.isEmpty()) {
                int v = ((GoogleSignInOptions)object0).m0().size();
                if(this.f.size() == v) {
                    ArrayList arrayList0 = ((GoogleSignInOptions)object0).m0();
                    if(this.f.containsAll(arrayList0)) {
                        Account account0 = this.g;
                        if(account0 != null) {
                            if(account0.equals(((GoogleSignInOptions)object0).j0())) {
                            label_12:
                                if(TextUtils.isEmpty(this.k)) {
                                    return TextUtils.isEmpty(((GoogleSignInOptions)object0).n0()) ? this.j == ((GoogleSignInOptions)object0).o0() && this.h == ((GoogleSignInOptions)object0).p0() && this.i == ((GoogleSignInOptions)object0).q0() && TextUtils.equals(this.n, ((GoogleSignInOptions)object0).l0()) : false;
                                }
                                return this.k.equals(((GoogleSignInOptions)object0).n0()) ? this.j == ((GoogleSignInOptions)object0).o0() && this.h == ((GoogleSignInOptions)object0).p0() && this.i == ((GoogleSignInOptions)object0).q0() && TextUtils.equals(this.n, ((GoogleSignInOptions)object0).l0()) : false;
                            }
                        }
                        else if(((GoogleSignInOptions)object0).j0() == null) {
                            goto label_12;
                        }
                    }
                }
            }
        }
        catch(ClassCastException unused_ex) {
        }
        return false;
    }

    @Override
    public int hashCode() {
        ArrayList arrayList0 = new ArrayList();
        ArrayList arrayList1 = this.f;
        int v = arrayList1.size();
        for(int v1 = 0; v1 < v; ++v1) {
            arrayList0.add(((Scope)arrayList1.get(v1)).j0());
        }
        Collections.sort(arrayList0);
        b b0 = new b();
        b0.a(arrayList0);
        b0.a(this.g);
        b0.a(this.k);
        b0.c(this.j);
        b0.c(this.h);
        b0.c(this.i);
        b0.a(this.n);
        return b0.b();
    }

    public Account j0() {
        return this.g;
    }

    public ArrayList k0() {
        return this.m;
    }

    public String l0() {
        return this.n;
    }

    public ArrayList m0() {
        return new ArrayList(this.f);
    }

    public String n0() {
        return this.k;
    }

    public boolean o0() {
        return this.j;
    }

    public boolean p0() {
        return this.h;
    }

    public boolean q0() {
        return this.i;
    }

    public static GoogleSignInOptions s0(String s) {
        String s1 = null;
        if(TextUtils.isEmpty(s)) {
            return null;
        }
        JSONObject jSONObject0 = new JSONObject(s);
        HashSet hashSet0 = new HashSet();
        JSONArray jSONArray0 = jSONObject0.getJSONArray("scopes");
        int v = jSONArray0.length();
        for(int v1 = 0; v1 < v; ++v1) {
            hashSet0.add(new Scope(jSONArray0.getString(v1)));
        }
        String s2 = jSONObject0.has("accountName") ? jSONObject0.optString("accountName") : null;
        Account account0 = TextUtils.isEmpty(s2) ? null : new Account(s2, "com.google");
        ArrayList arrayList0 = new ArrayList(hashSet0);
        boolean z = jSONObject0.getBoolean("idTokenRequested");
        boolean z1 = jSONObject0.getBoolean("serverAuthRequested");
        boolean z2 = jSONObject0.getBoolean("forceCodeForRefreshToken");
        String s3 = jSONObject0.has("serverClientId") ? jSONObject0.optString("serverClientId") : null;
        if(jSONObject0.has("hostedDomain")) {
            s1 = jSONObject0.optString("hostedDomain");
        }
        return new GoogleSignInOptions(3, arrayList0, account0, z, z1, z2, s3, s1, new HashMap(), null);
    }

    public final String w0() {
        JSONObject jSONObject0 = new JSONObject();
        try {
            JSONArray jSONArray0 = new JSONArray();
            Collections.sort(this.f, GoogleSignInOptions.w);
            for(Object object0: this.f) {
                jSONArray0.put(((Scope)object0).j0());
            }
            jSONObject0.put("scopes", jSONArray0);
            Account account0 = this.g;
            if(account0 != null) {
                jSONObject0.put("accountName", account0.name);
            }
            jSONObject0.put("idTokenRequested", this.h);
            jSONObject0.put("forceCodeForRefreshToken", this.j);
            jSONObject0.put("serverAuthRequested", this.i);
            if(!TextUtils.isEmpty(this.k)) {
                jSONObject0.put("serverClientId", this.k);
            }
            if(!TextUtils.isEmpty(this.l)) {
                jSONObject0.put("hostedDomain", this.l);
            }
            return jSONObject0.toString();
        }
        catch(JSONException jSONException0) {
            throw new RuntimeException(jSONException0);
        }
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = h1.c.a(parcel0);
        h1.c.i(parcel0, 1, this.e);
        h1.c.r(parcel0, 2, this.m0(), false);
        h1.c.m(parcel0, 3, this.j0(), v, false);
        h1.c.c(parcel0, 4, this.p0());
        h1.c.c(parcel0, 5, this.q0());
        h1.c.c(parcel0, 6, this.o0());
        h1.c.n(parcel0, 7, this.n0(), false);
        h1.c.n(parcel0, 8, this.l, false);
        h1.c.r(parcel0, 9, this.k0(), false);
        h1.c.n(parcel0, 10, this.l0(), false);
        h1.c.b(parcel0, v1);
    }
}

