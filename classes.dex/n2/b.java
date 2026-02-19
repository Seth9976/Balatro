package n2;

import java.lang.reflect.Field;
import java.util.Locale;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public abstract class b extends Enum implements c {
    // 部分失败：枚举糖化
    // 枚举按原样呈现，而不是糖化为Java 5枚举。
    final class a extends b {
        a(String s, int v) {
            super(s, v, null);
        }

        @Override  // n2.c
        public String c(Field field0) {
            return field0.getName();
        }
    }

    // 部分失败：枚举糖化
    // 枚举按原样呈现，而不是糖化为Java 5枚举。
    final class n2.b.b extends b {
        n2.b.b(String s, int v) {
            super(s, v, null);
        }

        @Override  // n2.c
        public String c(Field field0) {
            return b.k(field0.getName());
        }
    }

    // 部分失败：枚举糖化
    // 枚举按原样呈现，而不是糖化为Java 5枚举。
    final class n2.b.c extends b {
        n2.b.c(String s, int v) {
            super(s, v, null);
        }

        @Override  // n2.c
        public String c(Field field0) {
            return b.k(b.j(field0.getName(), ' '));
        }
    }

    // 部分失败：枚举糖化
    // 枚举按原样呈现，而不是糖化为Java 5枚举。
    final class d extends b {
        d(String s, int v) {
            super(s, v, null);
        }

        @Override  // n2.c
        public String c(Field field0) {
            return b.j(field0.getName(), '_').toUpperCase(Locale.ENGLISH);
        }
    }

    // 部分失败：枚举糖化
    // 枚举按原样呈现，而不是糖化为Java 5枚举。
    final class e extends b {
        e(String s, int v) {
            super(s, v, null);
        }

        @Override  // n2.c
        public String c(Field field0) {
            return b.j(field0.getName(), '_').toLowerCase(Locale.ENGLISH);
        }
    }

    // 部分失败：枚举糖化
    // 枚举按原样呈现，而不是糖化为Java 5枚举。
    final class f extends b {
        f(String s, int v) {
            super(s, v, null);
        }

        @Override  // n2.c
        public String c(Field field0) {
            return b.j(field0.getName(), '-').toLowerCase(Locale.ENGLISH);
        }
    }

    // 部分失败：枚举糖化
    // 枚举按原样呈现，而不是糖化为Java 5枚举。
    final class g extends b {
        g(String s, int v) {
            super(s, v, null);
        }

        @Override  // n2.c
        public String c(Field field0) {
            return b.j(field0.getName(), '.').toLowerCase(Locale.ENGLISH);
        }
    }

    public static final enum b e;
    public static final enum b f;
    public static final enum b g;
    public static final enum b h;
    public static final enum b i;
    public static final enum b j;
    public static final enum b k;
    private static final b[] l;

    static {
        a b$a0 = new a("IDENTITY", 0);
        b.e = b$a0;
        n2.b.b b$b0 = new n2.b.b("UPPER_CAMEL_CASE", 1);
        b.f = b$b0;
        n2.b.c b$c0 = new n2.b.c("UPPER_CAMEL_CASE_WITH_SPACES", 2);
        b.g = b$c0;
        d b$d0 = new d("UPPER_CASE_WITH_UNDERSCORES", 3);
        b.h = b$d0;
        e b$e0 = new e("LOWER_CASE_WITH_UNDERSCORES", 4);
        b.i = b$e0;
        f b$f0 = new f("LOWER_CASE_WITH_DASHES", 5);
        b.j = b$f0;
        g b$g0 = new g("LOWER_CASE_WITH_DOTS", 6);
        b.k = b$g0;
        b.l = new b[]{b$a0, b$b0, b$c0, b$d0, b$e0, b$f0, b$g0};
    }

    private b(String s, int v) {
        super(s, v);
    }

    b(String s, int v, a b$a0) {
        this(s, v);
    }

    static String j(String s, char c) {
        StringBuilder stringBuilder0 = new StringBuilder();
        int v = s.length();
        for(int v1 = 0; v1 < v; ++v1) {
            int v2 = s.charAt(v1);
            if(Character.isUpperCase(((char)v2)) && stringBuilder0.length() != 0) {
                stringBuilder0.append(c);
            }
            stringBuilder0.append(((char)v2));
        }
        return stringBuilder0.toString();
    }

    static String k(String s) {
        int v = s.length();
        for(int v1 = 0; v1 < v; ++v1) {
            int v2 = s.charAt(v1);
            if(Character.isLetter(((char)v2))) {
                if(Character.isUpperCase(((char)v2))) {
                    return s;
                }
                int v3 = Character.toUpperCase(((char)v2));
                return v1 == 0 ? ((char)v3) + s.substring(1) : s.substring(0, v1) + ((char)v3) + s.substring(v1 + 1);
            }
        }
        return s;
    }

    public static b valueOf(String s) {
        return (b)Enum.valueOf(b.class, s);
    }

    public static b[] values() {
        return (b[])b.l.clone();
    }
}

