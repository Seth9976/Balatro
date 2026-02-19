package k;

import java.util.ConcurrentModificationException;
import java.util.Map;

public class g {
    int[] e;
    Object[] f;
    int g;
    static Object[] h;
    static int i;
    static Object[] j;
    static int k;

    public g() {
        this.e = c.a;
        this.f = c.c;
        this.g = 0;
    }

    public g(int v) {
        if(v == 0) {
            this.e = c.a;
            this.f = c.c;
        }
        else {
            this.a(v);
        }
        this.g = 0;
    }

    private void a(int v) {
        switch(v) {
            case 4: {
                Class class0 = g.class;
                synchronized(class0) {
                    Object[] arr_object = g.h;
                    if(arr_object != null) {
                        this.f = arr_object;
                        g.h = (Object[])arr_object[0];
                        this.e = (int[])arr_object[1];
                        arr_object[1] = null;
                        arr_object[0] = null;
                        --g.i;
                        return;
                    }
                }
                break;
            }
            case 8: {
                Class class1 = g.class;
                synchronized(class1) {
                    Object[] arr_object1 = g.j;
                    if(arr_object1 != null) {
                        this.f = arr_object1;
                        g.j = (Object[])arr_object1[0];
                        this.e = (int[])arr_object1[1];
                        arr_object1[1] = null;
                        arr_object1[0] = null;
                        --g.k;
                        return;
                    }
                }
            }
        }
        this.e = new int[v];
        this.f = new Object[v << 1];
    }

    private static int b(int[] arr_v, int v, int v1) {
        try {
            return c.a(arr_v, v, v1);
        }
        catch(ArrayIndexOutOfBoundsException unused_ex) {
            throw new ConcurrentModificationException();
        }
    }

    public void c(int v) {
        int v1 = this.g;
        int[] arr_v = this.e;
        if(arr_v.length < v) {
            Object[] arr_object = this.f;
            this.a(v);
            if(this.g > 0) {
                System.arraycopy(arr_v, 0, this.e, 0, v1);
                System.arraycopy(arr_object, 0, this.f, 0, v1 << 1);
            }
            g.d(arr_v, arr_object, v1);
        }
        if(this.g != v1) {
            throw new ConcurrentModificationException();
        }
    }

    public void clear() {
        int v = this.g;
        if(v > 0) {
            int[] arr_v = this.e;
            Object[] arr_object = this.f;
            this.e = c.a;
            this.f = c.c;
            this.g = 0;
            g.d(arr_v, arr_object, v);
        }
        if(this.g > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object object0) {
        return this.f(object0) >= 0;
    }

    public boolean containsValue(Object object0) {
        return this.h(object0) >= 0;
    }

    private static void d(int[] arr_v, Object[] arr_object, int v) {
        switch(arr_v.length) {
            case 4: {
                Class class0 = g.class;
                synchronized(class0) {
                    if(g.i < 10) {
                        arr_object[0] = g.h;
                        arr_object[1] = arr_v;
                        for(int v2 = (v << 1) - 1; v2 >= 2; --v2) {
                            arr_object[v2] = null;
                        }
                        g.h = arr_object;
                        ++g.i;
                    }
                }
                return;
            }
            case 8: {
                Class class1 = g.class;
                synchronized(class1) {
                    if(g.k < 10) {
                        arr_object[0] = g.j;
                        arr_object[1] = arr_v;
                        for(int v4 = (v << 1) - 1; v4 >= 2; --v4) {
                            arr_object[v4] = null;
                        }
                        g.j = arr_object;
                        ++g.k;
                    }
                }
            }
        }
    }

    int e(Object object0, int v) {
        int v1 = this.g;
        if(v1 == 0) {
            return -1;
        }
        int v2 = g.b(this.e, v1, v);
        if(v2 < 0) {
            return v2;
        }
        if(object0.equals(this.f[v2 << 1])) {
            return v2;
        }
        int v3;
        for(v3 = v2 + 1; v3 < v1 && this.e[v3] == v; ++v3) {
            if(object0.equals(this.f[v3 << 1])) {
                return v3;
            }
        }
        for(int v4 = v2 - 1; v4 >= 0 && this.e[v4] == v; --v4) {
            if(object0.equals(this.f[v4 << 1])) {
                return v4;
            }
        }
        return ~v3;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 instanceof g) {
            g g0 = (g)object0;
            if(this.size() != g0.size()) {
                return false;
            }
            try {
                for(int v = 0; true; ++v) {
                    if(v >= this.g) {
                        return true;
                    }
                    Object object1 = this.i(v);
                    Object object2 = this.l(v);
                    Object object3 = g0.get(object1);
                    if(object2 != null) {
                        if(object2.equals(object3)) {
                            continue;
                        }
                        break;
                    }
                    else if(object3 != null || !g0.containsKey(object1)) {
                        return false;
                    }
                }
            }
            catch(NullPointerException | ClassCastException unused_ex) {
            }
            return false;
        }
        if(object0 instanceof Map) {
            Map map0 = (Map)object0;
            if(this.size() != map0.size()) {
                return false;
            }
            try {
                for(int v1 = 0; v1 < this.g; ++v1) {
                    Object object4 = this.i(v1);
                    Object object5 = this.l(v1);
                    Object object6 = map0.get(object4);
                    if(object5 == null) {
                        if(object6 != null || !map0.containsKey(object4)) {
                            return false;
                        }
                    }
                    else if(!object5.equals(object6)) {
                        return false;
                    }
                }
                return true;
            }
            catch(NullPointerException | ClassCastException unused_ex) {
            }
        }
        return false;
    }

    public int f(Object object0) {
        return object0 == null ? this.g() : this.e(object0, object0.hashCode());
    }

    int g() {
        int v = this.g;
        if(v == 0) {
            return -1;
        }
        int v1 = g.b(this.e, v, 0);
        if(v1 < 0) {
            return v1;
        }
        if(this.f[v1 << 1] == null) {
            return v1;
        }
        int v2;
        for(v2 = v1 + 1; v2 < v && this.e[v2] == 0; ++v2) {
            if(this.f[v2 << 1] == null) {
                return v2;
            }
        }
        for(int v3 = v1 - 1; v3 >= 0 && this.e[v3] == 0; --v3) {
            if(this.f[v3 << 1] == null) {
                return v3;
            }
        }
        return ~v2;
    }

    public Object get(Object object0) {
        return this.getOrDefault(object0, null);
    }

    public Object getOrDefault(Object object0, Object object1) {
        int v = this.f(object0);
        return v < 0 ? object1 : this.f[(v << 1) + 1];
    }

    int h(Object object0) {
        int v = this.g * 2;
        Object[] arr_object = this.f;
        if(object0 == null) {
            for(int v1 = 1; v1 < v; v1 += 2) {
                if(arr_object[v1] == null) {
                    return v1 >> 1;
                }
            }
            return -1;
        }
        for(int v2 = 1; v2 < v; v2 += 2) {
            if(object0.equals(arr_object[v2])) {
                return v2 >> 1;
            }
        }
        return -1;
    }

    @Override
    public int hashCode() {
        int[] arr_v = this.e;
        Object[] arr_object = this.f;
        int v = this.g;
        int v2 = 0;
        int v3 = 0;
        for(int v1 = 1; v2 < v; v1 += 2) {
            Object object0 = arr_object[v1];
            v3 += (object0 == null ? 0 : object0.hashCode()) ^ arr_v[v2];
            ++v2;
        }
        return v3;
    }

    public Object i(int v) {
        return this.f[v << 1];
    }

    public boolean isEmpty() {
        return this.g <= 0;
    }

    public Object j(int v) {
        Object[] arr_object = this.f;
        Object object0 = arr_object[(v << 1) + 1];
        int v1 = this.g;
        int v2 = 0;
        if(v1 <= 1) {
            g.d(this.e, arr_object, v1);
            this.e = c.a;
            this.f = c.c;
        }
        else {
            int[] arr_v = this.e;
            int v3 = 8;
            if(arr_v.length <= 8 || v1 >= arr_v.length / 3) {
                if(v < v1 - 1) {
                    int v5 = v1 - 1 - v;
                    System.arraycopy(arr_v, v + 1, arr_v, v, v5);
                    System.arraycopy(this.f, v + 1 << 1, this.f, v << 1, v5 << 1);
                }
                Object[] arr_object1 = this.f;
                int v6 = v1 - 1 << 1;
                arr_object1[v6] = null;
                arr_object1[v6 + 1] = null;
            }
            else {
                if(v1 > 8) {
                    v3 = v1 + (v1 >> 1);
                }
                this.a(v3);
                if(v1 != this.g) {
                    throw new ConcurrentModificationException();
                }
                if(v > 0) {
                    System.arraycopy(arr_v, 0, this.e, 0, v);
                    System.arraycopy(arr_object, 0, this.f, 0, v << 1);
                }
                if(v < v1 - 1) {
                    int v4 = v1 - 1 - v;
                    System.arraycopy(arr_v, v + 1, this.e, v, v4);
                    System.arraycopy(arr_object, v + 1 << 1, this.f, v << 1, v4 << 1);
                }
            }
            v2 = v1 - 1;
        }
        if(v1 != this.g) {
            throw new ConcurrentModificationException();
        }
        this.g = v2;
        return object0;
    }

    public Object k(int v, Object object0) {
        int v1 = (v << 1) + 1;
        Object[] arr_object = this.f;
        Object object1 = arr_object[v1];
        arr_object[v1] = object0;
        return object1;
    }

    public Object l(int v) {
        return this.f[(v << 1) + 1];
    }

    public Object put(Object object0, Object object1) {
        int v2;
        int v1;
        int v = this.g;
        if(object0 == null) {
            v1 = this.g();
            v2 = 0;
        }
        else {
            int v3 = object0.hashCode();
            v2 = v3;
            v1 = this.e(object0, v3);
        }
        if(v1 >= 0) {
            int v4 = (v1 << 1) + 1;
            Object[] arr_object = this.f;
            Object object2 = arr_object[v4];
            arr_object[v4] = object1;
            return object2;
        }
        int v5 = 8;
        int[] arr_v = this.e;
        if(v >= arr_v.length) {
            if(v >= 8) {
                v5 = (v >> 1) + v;
            }
            else if(v < 4) {
                v5 = 4;
            }
            Object[] arr_object1 = this.f;
            this.a(v5);
            if(v != this.g) {
                throw new ConcurrentModificationException();
            }
            int[] arr_v1 = this.e;
            if(arr_v1.length > 0) {
                System.arraycopy(arr_v, 0, arr_v1, 0, arr_v.length);
                System.arraycopy(arr_object1, 0, this.f, 0, arr_object1.length);
            }
            g.d(arr_v, arr_object1, v);
        }
        if(~v1 < v) {
            System.arraycopy(this.e, ~v1, this.e, -v1, v - ~v1);
            System.arraycopy(this.f, ~v1 << 1, this.f, -v1 << 1, this.g - ~v1 << 1);
        }
        int v6 = this.g;
        if(v == v6) {
            int[] arr_v2 = this.e;
            if(~v1 < arr_v2.length) {
                arr_v2[~v1] = v2;
                Object[] arr_object2 = this.f;
                arr_object2[~v1 << 1] = object0;
                arr_object2[(~v1 << 1) + 1] = object1;
                this.g = v6 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public Object putIfAbsent(Object object0, Object object1) {
        Object object2 = this.get(object0);
        return object2 == null ? this.put(object0, object1) : object2;
    }

    public Object remove(Object object0) {
        int v = this.f(object0);
        return v < 0 ? null : this.j(v);
    }

    public boolean remove(Object object0, Object object1) {
        int v = this.f(object0);
        if(v >= 0) {
            Object object2 = this.l(v);
            if(object1 == object2 || object1 != null && object1.equals(object2)) {
                this.j(v);
                return true;
            }
        }
        return false;
    }

    public Object replace(Object object0, Object object1) {
        int v = this.f(object0);
        return v < 0 ? null : this.k(v, object1);
    }

    public boolean replace(Object object0, Object object1, Object object2) {
        int v = this.f(object0);
        if(v >= 0) {
            Object object3 = this.l(v);
            if(object3 == object1 || object1 != null && object1.equals(object3)) {
                this.k(v, object2);
                return true;
            }
        }
        return false;
    }

    public int size() {
        return this.g;
    }

    @Override
    public String toString() {
        if(this.isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder0 = new StringBuilder(this.g * 28);
        stringBuilder0.append('{');
        for(int v = 0; v < this.g; ++v) {
            if(v > 0) {
                stringBuilder0.append(", ");
            }
            Object object0 = this.i(v);
            if(object0 == this) {
                stringBuilder0.append("(this Map)");
            }
            else {
                stringBuilder0.append(object0);
            }
            stringBuilder0.append('=');
            Object object1 = this.l(v);
            if(object1 == this) {
                stringBuilder0.append("(this Map)");
            }
            else {
                stringBuilder0.append(object1);
            }
        }
        stringBuilder0.append('}');
        return stringBuilder0.toString();
    }
}

