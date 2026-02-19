package i0;

import java.util.List;

final class d extends j {
    private final List a;

    d(List list0) {
        if(list0 == null) {
            throw new NullPointerException("Null logRequests");
        }
        this.a = list0;
    }

    @Override  // i0.j
    public List c() {
        return this.a;
    }

    @Override
    public boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        if(object0 instanceof j) {
            List list0 = ((j)object0).c();
            return this.a.equals(list0);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.a.hashCode() ^ 1000003;
    }

    @Override
    public String toString() {
        return "BatchedLogRequest{logRequests=" + this.a + "}";
    }
}

