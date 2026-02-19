package g1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class o {
    public static final class a {
        private final List a;
        private final Object b;

        a(Object object0, v0 v00) {
            q.i(object0);
            this.b = object0;
            this.a = new ArrayList();
        }

        public a a(String s, Object object0) {
            q.i(s);
            this.a.add(s + "=" + object0);
            return this;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder0 = new StringBuilder(100);
            stringBuilder0.append(this.b.getClass().getSimpleName());
            stringBuilder0.append('{');
            int v = this.a.size();
            for(int v1 = 0; v1 < v; ++v1) {
                stringBuilder0.append(((String)this.a.get(v1)));
                if(v1 < v - 1) {
                    stringBuilder0.append(", ");
                }
            }
            stringBuilder0.append('}');
            return stringBuilder0.toString();
        }
    }

    // 去混淆评级： 低(20)
    public static boolean a(Object object0, Object object1) {
        return object0 == object1 || object0 != null && object0.equals(object1);
    }

    public static int b(Object[] arr_object) {
        return Arrays.hashCode(arr_object);
    }

    public static a c(Object object0) {
        return new a(object0, null);
    }
}

