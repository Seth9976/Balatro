package androidx.core.provider;

import android.util.Base64;
import androidx.core.util.c;
import java.util.List;

public final class e {
    private final String a;
    private final String b;
    private final String c;
    private final List d;
    private final int e;
    private final String f;

    public e(String s, String s1, String s2, List list0) {
        this.a = (String)c.d(s);
        this.b = (String)c.d(s1);
        this.c = (String)c.d(s2);
        this.d = (List)c.d(list0);
        this.e = 0;
        this.f = s + "-" + s1 + "-" + s2;
    }

    private String a(String s, String s1, String s2) [...] // Inlined contents

    public List b() {
        return this.d;
    }

    public int c() {
        return this.e;
    }

    String d() {
        return this.f;
    }

    public String e() {
        return this.a;
    }

    public String f() {
        return this.b;
    }

    public String g() {
        return this.c;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append("FontRequest {mProviderAuthority: " + this.a + ", mProviderPackage: " + this.b + ", mQuery: " + this.c + ", mCertificates:");
        for(int v = 0; v < this.d.size(); ++v) {
            stringBuilder0.append(" [");
            List list0 = (List)this.d.get(v);
            for(int v1 = 0; v1 < list0.size(); ++v1) {
                stringBuilder0.append(" \"");
                stringBuilder0.append(Base64.encodeToString(((byte[])list0.get(v1)), 0));
                stringBuilder0.append("\"");
            }
            stringBuilder0.append(" ]");
        }
        stringBuilder0.append("}");
        stringBuilder0.append("mCertificatesArray: " + this.e);
        return stringBuilder0.toString();
    }
}

