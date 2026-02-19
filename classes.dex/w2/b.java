package w2;

import android.net.Uri;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import x2.p0;

public class b {
    public final String a;
    public final String b;
    public String c;
    public Uri d;
    public String e;
    public String f;
    public boolean g;
    public Map h;
    public long i;
    public boolean j;
    public int k;
    public Uri l;
    public long m;
    public boolean n;
    public List o;
    public List p;
    public String q;
    public Boolean r;
    public Boolean s;
    public String t;

    public b(String s, String s1) {
        this.g = false;
        this.h = new HashMap();
        this.i = 60L;
        this.j = false;
        this.k = 6;
        this.n = false;
        this.o = new ArrayList();
        this.p = new ArrayList();
        this.r = null;
        this.s = Boolean.FALSE;
        if(p0.V(s)) {
            throw new IllegalArgumentException("apiKey can not be null or empty");
        }
        if(p0.V(s1)) {
            throw new IllegalArgumentException("secret can not be null or empty");
        }
        this.a = s;
        this.b = s1;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append("apiKey=\'");
        stringBuilder0.append(this.a);
        stringBuilder0.append('\'');
        stringBuilder0.append(", secret=\'");
        stringBuilder0.append(this.b);
        stringBuilder0.append('\'');
        if(this.d != null) {
            stringBuilder0.append(", openUri=");
            stringBuilder0.append(this.d);
        }
        stringBuilder0.append(", logging=\'");
        stringBuilder0.append(this.j);
        stringBuilder0.append('\'');
        stringBuilder0.append(", logLevel=\'");
        stringBuilder0.append(this.k);
        stringBuilder0.append('\'');
        return stringBuilder0.toString();
    }
}

