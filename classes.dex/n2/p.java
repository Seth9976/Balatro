package n2;

import java.math.BigDecimal;
import p2.g;
import v2.d;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public abstract class p extends Enum implements q {
    // 部分失败：枚举糖化
    // 枚举按原样呈现，而不是糖化为Java 5枚举。
    final class a extends p {
        a(String s, int v) {
            super(s, v, null);
        }

        @Override  // n2.q
        public Number c(v2.a a0) {
            return this.j(a0);
        }

        public Double j(v2.a a0) {
            return a0.r();
        }
    }

    // 部分失败：枚举糖化
    // 枚举按原样呈现，而不是糖化为Java 5枚举。
    final class b extends p {
        b(String s, int v) {
            super(s, v, null);
        }

        @Override  // n2.q
        public Number c(v2.a a0) {
            return new g(a0.B());
        }
    }

    // 部分失败：枚举糖化
    // 枚举按原样呈现，而不是糖化为Java 5枚举。
    final class c extends p {
        c(String s, int v) {
            super(s, v, null);
        }

        @Override  // n2.q
        public Number c(v2.a a0) {
            String s = a0.B();
            try {
                return Long.parseLong(s);
            }
            catch(NumberFormatException unused_ex) {
                try {
                    Number number0 = Double.valueOf(s);
                    if((((Double)number0).isInfinite() || ((Double)number0).isNaN()) && !a0.m()) {
                        throw new d("JSON forbids NaN and infinities: " + number0 + "; at path " + a0.k());
                    }
                    return number0;
                }
                catch(NumberFormatException numberFormatException0) {
                    throw new k("Cannot parse " + s + "; at path " + a0.k(), numberFormatException0);
                }
            }
        }
    }

    // 部分失败：枚举糖化
    // 枚举按原样呈现，而不是糖化为Java 5枚举。
    final class n2.p.d extends p {
        n2.p.d(String s, int v) {
            super(s, v, null);
        }

        @Override  // n2.q
        public Number c(v2.a a0) {
            return this.j(a0);
        }

        public BigDecimal j(v2.a a0) {
            String s = a0.B();
            try {
                return new BigDecimal(s);
            }
            catch(NumberFormatException numberFormatException0) {
                throw new k("Cannot parse " + s + "; at path " + a0.k(), numberFormatException0);
            }
        }
    }

    public static final enum p e;
    public static final enum p f;
    public static final enum p g;
    public static final enum p h;
    private static final p[] i;

    static {
        a p$a0 = new a("DOUBLE", 0);
        p.e = p$a0;
        b p$b0 = new b("LAZILY_PARSED_NUMBER", 1);
        p.f = p$b0;
        c p$c0 = new c("LONG_OR_DOUBLE", 2);
        p.g = p$c0;
        n2.p.d p$d0 = new n2.p.d("BIG_DECIMAL", 3);
        p.h = p$d0;
        p.i = new p[]{p$a0, p$b0, p$c0, p$d0};
    }

    private p(String s, int v) {
        super(s, v);
    }

    p(String s, int v, a p$a0) {
        this(s, v);
    }

    public static p valueOf(String s) {
        return (p)Enum.valueOf(p.class, s);
    }

    public static p[] values() {
        return (p[])p.i.clone();
    }
}

