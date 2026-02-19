package n2;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public abstract class n extends Enum {
    // 部分失败：枚举糖化
    // 枚举按原样呈现，而不是糖化为Java 5枚举。
    final class a extends n {
        a(String s, int v) {
            super(s, v, null);
        }
    }

    // 部分失败：枚举糖化
    // 枚举按原样呈现，而不是糖化为Java 5枚举。
    final class b extends n {
        b(String s, int v) {
            super(s, v, null);
        }
    }

    public static final enum n e;
    public static final enum n f;
    private static final n[] g;

    static {
        a n$a0 = new a("DEFAULT", 0);
        n.e = n$a0;
        b n$b0 = new b("STRING", 1);
        n.f = n$b0;
        n.g = new n[]{n$a0, n$b0};
    }

    private n(String s, int v) {
        super(s, v);
    }

    n(String s, int v, a n$a0) {
        this(s, v);
    }

    public static n valueOf(String s) {
        return (n)Enum.valueOf(n.class, s);
    }

    public static n[] values() {
        return (n[])n.g.clone();
    }
}

