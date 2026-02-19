package v2;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

public class c implements Closeable, Flushable {
    private final Writer e;
    private int[] f;
    private int g;
    private String h;
    private String i;
    private boolean j;
    private boolean k;
    private String l;
    private boolean m;
    private static final Pattern n;
    private static final String[] o;
    private static final String[] p;

    static {
        c.n = Pattern.compile("-?(?:0|[1-9][0-9]*)(?:\\.[0-9]+)?(?:[eE][-+]?[0-9]+)?");
        c.o = new String[0x80];
        for(int v = 0; v <= 0x1F; ++v) {
            c.o[v] = "\\u001f";
        }
        c.o[34] = "\\\"";
        c.o[92] = "\\\\";
        c.o[9] = "\\t";
        c.o[8] = "\\b";
        c.o[10] = "\\n";
        c.o[13] = "\\r";
        c.o[12] = "\\f";
        String[] arr_s = (String[])c.o.clone();
        c.p = arr_s;
        arr_s[60] = "\\u003c";
        arr_s[62] = "\\u003e";
        arr_s[38] = "\\u0026";
        arr_s[61] = "\\u003d";
        arr_s[39] = "\\u0027";
    }

    public c(Writer writer0) {
        this.f = new int[0x20];
        this.g = 0;
        this.r(6);
        this.i = ":";
        this.m = true;
        Objects.requireNonNull(writer0, "out == null");
        this.e = writer0;
    }

    private void A(String s) {
        String s2;
        String[] arr_s = this.k ? c.p : c.o;
        this.e.write(34);
        int v = s.length();
        int v1 = 0;
        int v2 = 0;
        while(v1 < v) {
            int v3 = s.charAt(v1);
            if(v3 < 0x80) {
                String s1 = arr_s[v3];
                if(s1 != null) {
                    s2 = s1;
                    goto label_17;
                }
            }
            else {
                switch(v3) {
                    case 0x2028: {
                        s2 = "\\u2028";
                        break;
                    }
                    case 0x2029: {
                        s2 = "\\u2029";
                        break;
                    }
                    default: {
                        goto label_21;
                    }
                }
            label_17:
                if(v2 < v1) {
                    this.e.write(s, v2, v1 - v2);
                }
                this.e.write(s2);
                v2 = v1 + 1;
            }
        label_21:
            ++v1;
        }
        if(v2 < v) {
            this.e.write(s, v2, v - v2);
        }
        this.e.write(34);
    }

    public c B(double f) {
        this.J();
        if(!this.j && (Double.isNaN(f) || Double.isInfinite(f))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + f);
        }
        this.b();
        this.e.append(Double.toString(f));
        return this;
    }

    public c D(long v) {
        this.J();
        this.b();
        this.e.write(Long.toString(v));
        return this;
    }

    public c E(Boolean boolean0) {
        if(boolean0 == null) {
            return this.n();
        }
        this.J();
        this.b();
        this.e.write((boolean0.booleanValue() ? "true" : "false"));
        return this;
    }

    public c F(Number number0) {
        if(number0 == null) {
            return this.n();
        }
        this.J();
        String s = number0.toString();
        if(!s.equals("-Infinity") && !s.equals("Infinity") && !s.equals("NaN")) {
            Class class0 = number0.getClass();
            if(!c.k(class0) && !c.n.matcher(s).matches()) {
                throw new IllegalArgumentException("String created by " + class0 + " is not a valid JSON number: " + s);
            }
        }
        else if(!this.j) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + s);
        }
        this.b();
        this.e.append(s);
        return this;
    }

    public c G(String s) {
        if(s == null) {
            return this.n();
        }
        this.J();
        this.b();
        this.A(s);
        return this;
    }

    public c I(boolean z) {
        this.J();
        this.b();
        this.e.write((z ? "true" : "false"));
        return this;
    }

    private void J() {
        if(this.l != null) {
            this.a();
            this.A(this.l);
            this.l = null;
        }
    }

    private void a() {
        int v = this.q();
        if(v == 5) {
            this.e.write(44);
        }
        else if(v == 3) {
        }
        else {
            throw new IllegalStateException("Nesting problem.");
        }
        this.m();
        this.t(4);
    }

    private void b() {
        switch(this.q()) {
            case 1: {
                this.t(2);
                this.m();
                return;
            }
            case 2: {
                this.e.append(',');
                this.m();
                return;
            }
            case 4: {
                this.e.append(this.i);
                this.t(5);
                return;
            }
            case 6: {
                break;
            }
            case 7: {
                if(!this.j) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
            }
            default: {
                throw new IllegalStateException("Nesting problem.");
            }
        }
        this.t(7);
    }

    public c c() {
        this.J();
        return this.p(1, '[');
    }

    @Override
    public void close() {
        this.e.close();
        if(this.g > 1 || this.g == 1 && this.f[0] != 7) {
            throw new IOException("Incomplete document");
        }
        this.g = 0;
    }

    public c d() {
        this.J();
        return this.p(3, '{');
    }

    private c e(int v, int v1, char c) {
        int v2 = this.q();
        if(v2 != v1 && v2 != v) {
            throw new IllegalStateException("Nesting problem.");
        }
        if(this.l != null) {
            throw new IllegalStateException("Dangling name: " + this.l);
        }
        --this.g;
        if(v2 == v1) {
            this.m();
        }
        this.e.write(((int)c));
        return this;
    }

    public c f() {
        return this.e(1, 2, ']');
    }

    @Override
    public void flush() {
        if(this.g == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.e.flush();
    }

    public c g() {
        return this.e(3, 5, '}');
    }

    public final boolean h() {
        return this.m;
    }

    public final boolean i() {
        return this.k;
    }

    public boolean j() {
        return this.j;
    }

    private static boolean k(Class class0) {
        return class0 == Integer.class || class0 == Long.class || class0 == Double.class || class0 == Float.class || class0 == Byte.class || class0 == Short.class || class0 == BigDecimal.class || class0 == BigInteger.class || class0 == AtomicInteger.class || class0 == AtomicLong.class;
    }

    public c l(String s) {
        Objects.requireNonNull(s, "name == null");
        if(this.l != null) {
            throw new IllegalStateException();
        }
        if(this.g == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.l = s;
        return this;
    }

    private void m() {
        if(this.h == null) {
            return;
        }
        this.e.write(10);
        int v = this.g;
        for(int v1 = 1; v1 < v; ++v1) {
            this.e.write(this.h);
        }
    }

    public c n() {
        if(this.l != null) {
            if(this.m) {
                this.J();
                this.b();
                this.e.write("null");
                return this;
            }
            this.l = null;
            return this;
        }
        this.b();
        this.e.write("null");
        return this;
    }

    private c p(int v, char c) {
        this.b();
        this.r(v);
        this.e.write(((int)c));
        return this;
    }

    private int q() {
        int v = this.g;
        if(v == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.f[v - 1];
    }

    private void r(int v) {
        int v1 = this.g;
        int[] arr_v = this.f;
        if(v1 == arr_v.length) {
            this.f = Arrays.copyOf(arr_v, v1 * 2);
        }
        int v2 = this.g;
        this.g = v2 + 1;
        this.f[v2] = v;
    }

    private void t(int v) {
        this.f[this.g - 1] = v;
    }

    public final void u(boolean z) {
        this.k = z;
    }

    public final void v(String s) {
        String s1;
        if(s.length() == 0) {
            this.h = null;
            s1 = ":";
        }
        else {
            this.h = s;
            s1 = ": ";
        }
        this.i = s1;
    }

    public final void w(boolean z) {
        this.j = z;
    }

    public final void y(boolean z) {
        this.m = z;
    }
}

