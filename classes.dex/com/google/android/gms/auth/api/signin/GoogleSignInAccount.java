package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import g1.q;
import h1.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import l1.c;
import l1.d;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import z0.b;

@Deprecated
public class GoogleSignInAccount extends a implements ReflectedParcelable {
    public static final Parcelable.Creator CREATOR;
    final int e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final Uri j;
    private String k;
    private final long l;
    private final String m;
    final List n;
    private final String o;
    private final String p;
    private final Set q;
    public static final c r;

    static {
        GoogleSignInAccount.CREATOR = new com.google.android.gms.auth.api.signin.c();
        GoogleSignInAccount.r = d.b();
    }

    GoogleSignInAccount(int v, String s, String s1, String s2, String s3, Uri uri0, String s4, long v1, String s5, List list0, String s6, String s7) {
        this.q = new HashSet();
        this.e = v;
        this.f = s;
        this.g = s1;
        this.h = s2;
        this.i = s3;
        this.j = uri0;
        this.k = s4;
        this.l = v1;
        this.m = s5;
        this.n = list0;
        this.o = s6;
        this.p = s7;
    }

    @Override
    public boolean equals(Object object0) {
        if(object0 == null) {
            return false;
        }
        if(object0 == this) {
            return true;
        }
        return object0 instanceof GoogleSignInAccount ? ((GoogleSignInAccount)object0).m.equals(this.m) && ((GoogleSignInAccount)object0).r0().equals(this.r0()) : false;
    }

    @Override
    public int hashCode() {
        int v = this.r0().hashCode();
        return (this.m.hashCode() + 0x20F) * 0x1F + v;
    }

    public static GoogleSignInAccount j0() {
        return GoogleSignInAccount.x0(new Account("<<default account>>", "com.google"), new HashSet());
    }

    public String k() {
        return this.i;
    }

    public Account k0() {
        return this.h == null ? null : new Account(this.h, "com.google");
    }

    public String l0() {
        return this.h;
    }

    public String m0() {
        return this.p;
    }

    public String n0() {
        return this.o;
    }

    public String o0() {
        return this.f;
    }

    public String p0() {
        return this.g;
    }

    public Uri q0() {
        return this.j;
    }

    public Set r0() {
        Set set0 = new HashSet(this.n);
        set0.addAll(this.q);
        return set0;
    }

    public String s0() {
        return this.k;
    }

    public static GoogleSignInAccount t0(String s, String s1, String s2, String s3, String s4, String s5, Uri uri0, Long long0, String s6, Set set0) {
        return new GoogleSignInAccount(3, s, s1, s2, s3, uri0, null, ((long)long0), q.f(s6), new ArrayList(((Collection)q.i(set0))), s4, s5);
    }

    public static GoogleSignInAccount u0(String s) {
        String s1 = null;
        if(TextUtils.isEmpty(s)) {
            return null;
        }
        JSONObject jSONObject0 = new JSONObject(s);
        String s2 = jSONObject0.optString("photoUrl");
        Uri uri0 = TextUtils.isEmpty(s2) ? null : Uri.parse(s2);
        long v = Long.parseLong(jSONObject0.getString("expirationTime"));
        HashSet hashSet0 = new HashSet();
        JSONArray jSONArray0 = jSONObject0.getJSONArray("grantedScopes");
        int v1 = jSONArray0.length();
        for(int v2 = 0; v2 < v1; ++v2) {
            hashSet0.add(new Scope(jSONArray0.getString(v2)));
        }
        GoogleSignInAccount googleSignInAccount0 = GoogleSignInAccount.t0(jSONObject0.optString("id"), (jSONObject0.has("tokenId") ? jSONObject0.optString("tokenId") : null), (jSONObject0.has("email") ? jSONObject0.optString("email") : null), (jSONObject0.has("displayName") ? jSONObject0.optString("displayName") : null), (jSONObject0.has("givenName") ? jSONObject0.optString("givenName") : null), (jSONObject0.has("familyName") ? jSONObject0.optString("familyName") : null), uri0, v, jSONObject0.getString("obfuscatedIdentifier"), hashSet0);
        if(jSONObject0.has("serverAuthCode")) {
            s1 = jSONObject0.optString("serverAuthCode");
        }
        googleSignInAccount0.k = s1;
        return googleSignInAccount0;
    }

    public final String v0() {
        return this.m;
    }

    public final String w0() {
        JSONObject jSONObject0 = new JSONObject();
        try {
            if(this.o0() != null) {
                jSONObject0.put("id", this.o0());
            }
            if(this.p0() != null) {
                jSONObject0.put("tokenId", this.p0());
            }
            if(this.l0() != null) {
                jSONObject0.put("email", this.l0());
            }
            if(this.k() != null) {
                jSONObject0.put("displayName", this.k());
            }
            if(this.n0() != null) {
                jSONObject0.put("givenName", this.n0());
            }
            if(this.m0() != null) {
                jSONObject0.put("familyName", this.m0());
            }
            Uri uri0 = this.q0();
            if(uri0 != null) {
                jSONObject0.put("photoUrl", uri0.toString());
            }
            if(this.s0() != null) {
                jSONObject0.put("serverAuthCode", this.s0());
            }
            jSONObject0.put("expirationTime", this.l);
            jSONObject0.put("obfuscatedIdentifier", this.m);
            JSONArray jSONArray0 = new JSONArray();
            Scope[] arr_scope = (Scope[])this.n.toArray(new Scope[this.n.size()]);
            Arrays.sort(arr_scope, b.a);
            for(int v = 0; v < arr_scope.length; ++v) {
                jSONArray0.put(arr_scope[v].j0());
            }
            jSONObject0.put("grantedScopes", jSONArray0);
        }
        catch(JSONException jSONException0) {
            throw new RuntimeException(jSONException0);
        }
        jSONObject0.remove("serverAuthCode");
        return jSONObject0.toString();
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = h1.c.a(parcel0);
        h1.c.i(parcel0, 1, this.e);
        h1.c.n(parcel0, 2, this.o0(), false);
        h1.c.n(parcel0, 3, this.p0(), false);
        h1.c.n(parcel0, 4, this.l0(), false);
        h1.c.n(parcel0, 5, this.k(), false);
        h1.c.m(parcel0, 6, this.q0(), v, false);
        h1.c.n(parcel0, 7, this.s0(), false);
        h1.c.k(parcel0, 8, this.l);
        h1.c.n(parcel0, 9, this.m, false);
        h1.c.r(parcel0, 10, this.n, false);
        h1.c.n(parcel0, 11, this.n0(), false);
        h1.c.n(parcel0, 12, this.m0(), false);
        h1.c.b(parcel0, v1);
    }

    private static GoogleSignInAccount x0(Account account0, Set set0) {
        return GoogleSignInAccount.t0(null, null, account0.name, null, null, null, null, 0L, account0.name, set0);
    }
}

