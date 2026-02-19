package q0;

import java.util.Map;
import t0.a;

final class b extends f {
    private final a a;
    private final Map b;

    b(a a0, Map map0) {
        if(a0 == null) {
            throw new NullPointerException("Null clock");
        }
        this.a = a0;
        if(map0 == null) {
            throw new NullPointerException("Null values");
        }
        this.b = map0;
    }

    @Override  // q0.f
    a e() {
        return this.a;
    }

    @Override
    public boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        if(object0 instanceof f) {
            a a0 = ((f)object0).e();
            if(this.a.equals(a0)) {
                Map map0 = ((f)object0).h();
                return this.b.equals(map0);
            }
            return false;
        }
        return false;
    }

    @Override  // q0.f
    Map h() {
        return this.b;
    }

    @Override
    public int hashCode() {
        return (this.a.hashCode() ^ 1000003) * 1000003 ^ this.b.hashCode();
    }

    @Override
    public String toString() {
        return "SchedulerConfig{clock=" + this.a + ", values=" + this.b + "}";
    }
}

