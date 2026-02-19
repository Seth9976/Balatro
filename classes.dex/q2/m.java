package q2;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import n2.r;
import v2.b;
import v2.c;

public abstract class m {
    static abstract class a0 {
        static final int[] a;

        static {
            int[] arr_v = new int[b.values().length];
            a0.a = arr_v;
            try {
                arr_v[b.k.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                a0.a[b.j.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                a0.a[b.l.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                a0.a[b.e.ordinal()] = 4;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                a0.a[b.g.ordinal()] = 5;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                a0.a[b.m.ordinal()] = 6;
            }
            catch(NoSuchFieldError unused_ex) {
            }
        }
    }

    class a extends r {
        a() {
            super();
        }

        @Override  // n2.r
        public Object b(v2.a a0) {
            return this.e(a0);
        }

        @Override  // n2.r
        public void d(c c0, Object object0) {
            this.f(c0, ((AtomicIntegerArray)object0));
        }

        public AtomicIntegerArray e(v2.a a0) {
            ArrayList arrayList0 = new ArrayList();
            a0.a();
            while(a0.l()) {
                try {
                    arrayList0.add(a0.t());
                }
                catch(NumberFormatException numberFormatException0) {
                    throw new n2.m(numberFormatException0);
                }
            }
            a0.f();
            int v = arrayList0.size();
            AtomicIntegerArray atomicIntegerArray0 = new AtomicIntegerArray(v);
            for(int v1 = 0; v1 < v; ++v1) {
                atomicIntegerArray0.set(v1, ((int)(((Integer)arrayList0.get(v1)))));
            }
            return atomicIntegerArray0;
        }

        public void f(c c0, AtomicIntegerArray atomicIntegerArray0) {
            c0.c();
            int v = atomicIntegerArray0.length();
            for(int v1 = 0; v1 < v; ++v1) {
                c0.D(((long)atomicIntegerArray0.get(v1)));
            }
            c0.f();
        }
    }

    class b0 extends r {
        b0() {
            super();
        }

        @Override  // n2.r
        public Object b(v2.a a0) {
            return this.e(a0);
        }

        @Override  // n2.r
        public void d(c c0, Object object0) {
            this.f(c0, ((Boolean)object0));
        }

        public Boolean e(v2.a a0) {
            b b0 = a0.E();
            if(b0 == b.m) {
                a0.y();
                return null;
            }
            return b0 == b.j ? Boolean.valueOf(Boolean.parseBoolean(a0.B())) : Boolean.valueOf(a0.q());
        }

        public void f(c c0, Boolean boolean0) {
            c0.E(boolean0);
        }
    }

    class q2.m.b extends r {
        q2.m.b() {
            super();
        }

        @Override  // n2.r
        public Object b(v2.a a0) {
            return this.e(a0);
        }

        @Override  // n2.r
        public void d(c c0, Object object0) {
            this.f(c0, ((Number)object0));
        }

        public Number e(v2.a a0) {
            if(a0.E() == b.m) {
                a0.y();
                return null;
            }
            try {
                return a0.u();
            }
            catch(NumberFormatException numberFormatException0) {
                throw new n2.m(numberFormatException0);
            }
        }

        public void f(c c0, Number number0) {
            if(number0 == null) {
                c0.n();
                return;
            }
            c0.D(number0.longValue());
        }
    }

    class c0 extends r {
        c0() {
            super();
        }

        @Override  // n2.r
        public Object b(v2.a a0) {
            return this.e(a0);
        }

        @Override  // n2.r
        public void d(c c0, Object object0) {
            this.f(c0, ((Boolean)object0));
        }

        public Boolean e(v2.a a0) {
            if(a0.E() == b.m) {
                a0.y();
                return null;
            }
            return Boolean.valueOf(a0.B());
        }

        public void f(c c0, Boolean boolean0) {
            c0.G((boolean0 == null ? "null" : boolean0.toString()));
        }
    }

    class q2.m.c extends r {
        q2.m.c() {
            super();
        }

        @Override  // n2.r
        public Object b(v2.a a0) {
            return this.e(a0);
        }

        @Override  // n2.r
        public void d(c c0, Object object0) {
            this.f(c0, ((Number)object0));
        }

        public Number e(v2.a a0) {
            if(a0.E() == b.m) {
                a0.y();
                return null;
            }
            return (float)a0.r();
        }

        public void f(c c0, Number number0) {
            if(number0 == null) {
                c0.n();
                return;
            }
            if(!(number0 instanceof Float)) {
                number0 = number0.floatValue();
            }
            c0.F(number0);
        }
    }

    class d0 extends r {
        d0() {
            super();
        }

        @Override  // n2.r
        public Object b(v2.a a0) {
            return this.e(a0);
        }

        @Override  // n2.r
        public void d(c c0, Object object0) {
            this.f(c0, ((Number)object0));
        }

        public Number e(v2.a a0) {
            int v;
            if(a0.E() == b.m) {
                a0.y();
                return null;
            }
            try {
                v = a0.t();
            }
            catch(NumberFormatException numberFormatException0) {
                throw new n2.m(numberFormatException0);
            }
            if(v > 0xFF || v < 0xFFFFFF80) {
                throw new n2.m("Lossy conversion from " + v + " to byte; at path " + a0.k());
            }
            return (byte)v;
        }

        public void f(c c0, Number number0) {
            if(number0 == null) {
                c0.n();
                return;
            }
            c0.D(((long)number0.byteValue()));
        }
    }

    class d extends r {
        d() {
            super();
        }

        @Override  // n2.r
        public Object b(v2.a a0) {
            return this.e(a0);
        }

        @Override  // n2.r
        public void d(c c0, Object object0) {
            this.f(c0, ((Number)object0));
        }

        public Number e(v2.a a0) {
            if(a0.E() == b.m) {
                a0.y();
                return null;
            }
            return a0.r();
        }

        public void f(c c0, Number number0) {
            if(number0 == null) {
                c0.n();
                return;
            }
            c0.B(number0.doubleValue());
        }
    }

    class e0 extends r {
        e0() {
            super();
        }

        @Override  // n2.r
        public Object b(v2.a a0) {
            return this.e(a0);
        }

        @Override  // n2.r
        public void d(c c0, Object object0) {
            this.f(c0, ((Number)object0));
        }

        public Number e(v2.a a0) {
            int v;
            if(a0.E() == b.m) {
                a0.y();
                return null;
            }
            try {
                v = a0.t();
            }
            catch(NumberFormatException numberFormatException0) {
                throw new n2.m(numberFormatException0);
            }
            if(v > 0xFFFF || v < 0xFFFF8000) {
                throw new n2.m("Lossy conversion from " + v + " to short; at path " + a0.k());
            }
            return (short)v;
        }

        public void f(c c0, Number number0) {
            if(number0 == null) {
                c0.n();
                return;
            }
            c0.D(((long)number0.shortValue()));
        }
    }

    class e extends r {
        e() {
            super();
        }

        @Override  // n2.r
        public Object b(v2.a a0) {
            return this.e(a0);
        }

        @Override  // n2.r
        public void d(c c0, Object object0) {
            this.f(c0, ((Character)object0));
        }

        public Character e(v2.a a0) {
            if(a0.E() == b.m) {
                a0.y();
                return null;
            }
            String s = a0.B();
            if(s.length() != 1) {
                throw new n2.m("Expecting character, got: " + s + "; at " + a0.k());
            }
            return Character.valueOf(s.charAt(0));
        }

        public void f(c c0, Character character0) {
            c0.G((character0 == null ? null : String.valueOf(character0)));
        }
    }

    class f0 extends r {
        f0() {
            super();
        }

        @Override  // n2.r
        public Object b(v2.a a0) {
            return this.e(a0);
        }

        @Override  // n2.r
        public void d(c c0, Object object0) {
            this.f(c0, ((Number)object0));
        }

        public Number e(v2.a a0) {
            if(a0.E() == b.m) {
                a0.y();
                return null;
            }
            try {
                return a0.t();
            }
            catch(NumberFormatException numberFormatException0) {
                throw new n2.m(numberFormatException0);
            }
        }

        public void f(c c0, Number number0) {
            if(number0 == null) {
                c0.n();
                return;
            }
            c0.D(((long)number0.intValue()));
        }
    }

    class f extends r {
        f() {
            super();
        }

        @Override  // n2.r
        public Object b(v2.a a0) {
            return this.e(a0);
        }

        @Override  // n2.r
        public void d(c c0, Object object0) {
            this.f(c0, ((String)object0));
        }

        public String e(v2.a a0) {
            b b0 = a0.E();
            if(b0 == b.m) {
                a0.y();
                return null;
            }
            return b0 == b.l ? Boolean.toString(a0.q()) : a0.B();
        }

        public void f(c c0, String s) {
            c0.G(s);
        }
    }

    class g0 extends r {
        g0() {
            super();
        }

        @Override  // n2.r
        public Object b(v2.a a0) {
            return this.e(a0);
        }

        @Override  // n2.r
        public void d(c c0, Object object0) {
            this.f(c0, ((AtomicInteger)object0));
        }

        public AtomicInteger e(v2.a a0) {
            try {
                return new AtomicInteger(a0.t());
            }
            catch(NumberFormatException numberFormatException0) {
                throw new n2.m(numberFormatException0);
            }
        }

        public void f(c c0, AtomicInteger atomicInteger0) {
            c0.D(((long)atomicInteger0.get()));
        }
    }

    class g extends r {
        g() {
            super();
        }

        @Override  // n2.r
        public Object b(v2.a a0) {
            return this.e(a0);
        }

        @Override  // n2.r
        public void d(c c0, Object object0) {
            this.f(c0, ((BigDecimal)object0));
        }

        public BigDecimal e(v2.a a0) {
            if(a0.E() == b.m) {
                a0.y();
                return null;
            }
            String s = a0.B();
            try {
                return new BigDecimal(s);
            }
            catch(NumberFormatException numberFormatException0) {
                throw new n2.m("Failed parsing \'" + s + "\' as BigDecimal; at path " + a0.k(), numberFormatException0);
            }
        }

        public void f(c c0, BigDecimal bigDecimal0) {
            c0.F(bigDecimal0);
        }
    }

    class h0 extends r {
        h0() {
            super();
        }

        @Override  // n2.r
        public Object b(v2.a a0) {
            return this.e(a0);
        }

        @Override  // n2.r
        public void d(c c0, Object object0) {
            this.f(c0, ((AtomicBoolean)object0));
        }

        public AtomicBoolean e(v2.a a0) {
            return new AtomicBoolean(a0.q());
        }

        public void f(c c0, AtomicBoolean atomicBoolean0) {
            c0.I(atomicBoolean0.get());
        }
    }

    class h extends r {
        h() {
            super();
        }

        @Override  // n2.r
        public Object b(v2.a a0) {
            return this.e(a0);
        }

        @Override  // n2.r
        public void d(c c0, Object object0) {
            this.f(c0, ((BigInteger)object0));
        }

        public BigInteger e(v2.a a0) {
            if(a0.E() == b.m) {
                a0.y();
                return null;
            }
            String s = a0.B();
            try {
                return new BigInteger(s);
            }
            catch(NumberFormatException numberFormatException0) {
                throw new n2.m("Failed parsing \'" + s + "\' as BigInteger; at path " + a0.k(), numberFormatException0);
            }
        }

        public void f(c c0, BigInteger bigInteger0) {
            c0.F(bigInteger0);
        }
    }

    static final class i0 extends r {
        private final Map a;
        private final Map b;
        private final Map c;

        public i0(Class class0) {
            class q2.m.i0.a implements PrivilegedAction {
                final Class a;
                final i0 b;

                q2.m.i0.a(Class class0) {
                    this.a = class0;
                    super();
                }

                public Field[] a() {
                    Field[] arr_field = this.a.getDeclaredFields();
                    ArrayList arrayList0 = new ArrayList(arr_field.length);
                    for(int v = 0; v < arr_field.length; ++v) {
                        Field field0 = arr_field[v];
                        if(field0.isEnumConstant()) {
                            arrayList0.add(field0);
                        }
                    }
                    Field[] arr_field1 = (Field[])arrayList0.toArray(new Field[0]);
                    AccessibleObject.setAccessible(arr_field1, true);
                    return arr_field1;
                }

                @Override
                public Object run() {
                    return this.a();
                }
            }

            this.a = new HashMap();
            this.b = new HashMap();
            this.c = new HashMap();
            try {
                Field[] arr_field = (Field[])AccessController.doPrivileged(new q2.m.i0.a(this, class0));
                for(int v = 0; v < arr_field.length; ++v) {
                    Field field0 = arr_field[v];
                    Enum enum0 = (Enum)field0.get(null);
                    String s = enum0.name();
                    String s1 = enum0.toString();
                    o2.c c0 = (o2.c)field0.getAnnotation(o2.c.class);
                    if(c0 != null) {
                        s = c0.value();
                        String[] arr_s = c0.alternate();
                        for(int v1 = 0; v1 < arr_s.length; ++v1) {
                            this.a.put(arr_s[v1], enum0);
                        }
                    }
                    this.a.put(s, enum0);
                    this.b.put(s1, enum0);
                    this.c.put(enum0, s);
                }
            }
            catch(IllegalAccessException illegalAccessException0) {
                throw new AssertionError(illegalAccessException0);
            }
        }

        @Override  // n2.r
        public Object b(v2.a a0) {
            return this.e(a0);
        }

        @Override  // n2.r
        public void d(c c0, Object object0) {
            this.f(c0, ((Enum)object0));
        }

        public Enum e(v2.a a0) {
            if(a0.E() == b.m) {
                a0.y();
                return null;
            }
            String s = a0.B();
            Enum enum0 = (Enum)this.a.get(s);
            return enum0 == null ? ((Enum)this.b.get(s)) : enum0;
        }

        public void f(c c0, Enum enum0) {
            c0.G((enum0 == null ? null : ((String)this.c.get(enum0))));
        }
    }

    class i extends r {
        i() {
            super();
        }

        @Override  // n2.r
        public Object b(v2.a a0) {
            return this.e(a0);
        }

        @Override  // n2.r
        public void d(c c0, Object object0) {
            this.f(c0, ((p2.g)object0));
        }

        public p2.g e(v2.a a0) {
            if(a0.E() == b.m) {
                a0.y();
                return null;
            }
            return new p2.g(a0.B());
        }

        public void f(c c0, p2.g g0) {
            c0.F(g0);
        }
    }

    class j extends r {
        j() {
            super();
        }

        @Override  // n2.r
        public Object b(v2.a a0) {
            return this.e(a0);
        }

        @Override  // n2.r
        public void d(c c0, Object object0) {
            this.f(c0, ((StringBuilder)object0));
        }

        public StringBuilder e(v2.a a0) {
            if(a0.E() == b.m) {
                a0.y();
                return null;
            }
            return new StringBuilder(a0.B());
        }

        public void f(c c0, StringBuilder stringBuilder0) {
            c0.G((stringBuilder0 == null ? null : stringBuilder0.toString()));
        }
    }

    class k extends r {
        k() {
            super();
        }

        @Override  // n2.r
        public Object b(v2.a a0) {
            return this.e(a0);
        }

        @Override  // n2.r
        public void d(c c0, Object object0) {
            this.f(c0, ((Class)object0));
        }

        public Class e(v2.a a0) {
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }

        public void f(c c0, Class class0) {
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + class0.getName() + ". Forgot to register a type adapter?");
        }
    }

    class l extends r {
        l() {
            super();
        }

        @Override  // n2.r
        public Object b(v2.a a0) {
            return this.e(a0);
        }

        @Override  // n2.r
        public void d(c c0, Object object0) {
            this.f(c0, ((StringBuffer)object0));
        }

        public StringBuffer e(v2.a a0) {
            if(a0.E() == b.m) {
                a0.y();
                return null;
            }
            return new StringBuffer(a0.B());
        }

        public void f(c c0, StringBuffer stringBuffer0) {
            c0.G((stringBuffer0 == null ? null : stringBuffer0.toString()));
        }
    }

    class q2.m.m extends r {
        q2.m.m() {
            super();
        }

        @Override  // n2.r
        public Object b(v2.a a0) {
            return this.e(a0);
        }

        @Override  // n2.r
        public void d(c c0, Object object0) {
            this.f(c0, ((URL)object0));
        }

        public URL e(v2.a a0) {
            if(a0.E() == b.m) {
                a0.y();
                return null;
            }
            String s = a0.B();
            return "null".equals(s) ? null : new URL(s);
        }

        public void f(c c0, URL uRL0) {
            c0.G((uRL0 == null ? null : uRL0.toExternalForm()));
        }
    }

    class n extends r {
        n() {
            super();
        }

        @Override  // n2.r
        public Object b(v2.a a0) {
            return this.e(a0);
        }

        @Override  // n2.r
        public void d(c c0, Object object0) {
            this.f(c0, ((URI)object0));
        }

        public URI e(v2.a a0) {
            if(a0.E() == b.m) {
                a0.y();
                return null;
            }
            try {
                String s = a0.B();
                return "null".equals(s) ? null : new URI(s);
            }
            catch(URISyntaxException uRISyntaxException0) {
                throw new n2.h(uRISyntaxException0);
            }
        }

        public void f(c c0, URI uRI0) {
            c0.G((uRI0 == null ? null : uRI0.toASCIIString()));
        }
    }

    class o extends r {
        o() {
            super();
        }

        @Override  // n2.r
        public Object b(v2.a a0) {
            return this.e(a0);
        }

        @Override  // n2.r
        public void d(c c0, Object object0) {
            this.f(c0, ((InetAddress)object0));
        }

        public InetAddress e(v2.a a0) {
            if(a0.E() == b.m) {
                a0.y();
                return null;
            }
            return InetAddress.getByName(a0.B());
        }

        public void f(c c0, InetAddress inetAddress0) {
            c0.G((inetAddress0 == null ? null : inetAddress0.getHostAddress()));
        }
    }

    class p extends r {
        p() {
            super();
        }

        @Override  // n2.r
        public Object b(v2.a a0) {
            return this.e(a0);
        }

        @Override  // n2.r
        public void d(c c0, Object object0) {
            this.f(c0, ((UUID)object0));
        }

        public UUID e(v2.a a0) {
            if(a0.E() == b.m) {
                a0.y();
                return null;
            }
            String s = a0.B();
            try {
                return UUID.fromString(s);
            }
            catch(IllegalArgumentException illegalArgumentException0) {
                throw new n2.m("Failed parsing \'" + s + "\' as UUID; at path " + a0.k(), illegalArgumentException0);
            }
        }

        public void f(c c0, UUID uUID0) {
            c0.G((uUID0 == null ? null : uUID0.toString()));
        }
    }

    class q extends r {
        q() {
            super();
        }

        @Override  // n2.r
        public Object b(v2.a a0) {
            return this.e(a0);
        }

        @Override  // n2.r
        public void d(c c0, Object object0) {
            this.f(c0, ((Currency)object0));
        }

        public Currency e(v2.a a0) {
            String s = a0.B();
            try {
                return Currency.getInstance(s);
            }
            catch(IllegalArgumentException illegalArgumentException0) {
                throw new n2.m("Failed parsing \'" + s + "\' as Currency; at path " + a0.k(), illegalArgumentException0);
            }
        }

        public void f(c c0, Currency currency0) {
            c0.G(currency0.getCurrencyCode());
        }
    }

    class q2.m.r extends r {
        q2.m.r() {
            super();
        }

        @Override  // n2.r
        public Object b(v2.a a0) {
            return this.e(a0);
        }

        @Override  // n2.r
        public void d(c c0, Object object0) {
            this.f(c0, ((Calendar)object0));
        }

        public Calendar e(v2.a a0) {
            if(a0.E() == b.m) {
                a0.y();
                return null;
            }
            a0.b();
            int v = 0;
            int v1 = 0;
            int v2 = 0;
            int v3 = 0;
            int v4 = 0;
            int v5 = 0;
            while(a0.E() != b.h) {
                String s = a0.v();
                int v6 = a0.t();
                if("year".equals(s)) {
                    v = v6;
                }
                else if("month".equals(s)) {
                    v1 = v6;
                }
                else if("dayOfMonth".equals(s)) {
                    v2 = v6;
                }
                else if("hourOfDay".equals(s)) {
                    v3 = v6;
                }
                else if("minute".equals(s)) {
                    v4 = v6;
                }
                else if("second".equals(s)) {
                    v5 = v6;
                }
            }
            a0.g();
            return new GregorianCalendar(v, v1, v2, v3, v4, v5);
        }

        public void f(c c0, Calendar calendar0) {
            if(calendar0 == null) {
                c0.n();
                return;
            }
            c0.d();
            c0.l("year");
            c0.D(((long)calendar0.get(1)));
            c0.l("month");
            c0.D(((long)calendar0.get(2)));
            c0.l("dayOfMonth");
            c0.D(((long)calendar0.get(5)));
            c0.l("hourOfDay");
            c0.D(((long)calendar0.get(11)));
            c0.l("minute");
            c0.D(((long)calendar0.get(12)));
            c0.l("second");
            c0.D(((long)calendar0.get(13)));
            c0.g();
        }
    }

    class s extends r {
        s() {
            super();
        }

        @Override  // n2.r
        public Object b(v2.a a0) {
            return this.e(a0);
        }

        @Override  // n2.r
        public void d(c c0, Object object0) {
            this.f(c0, ((Locale)object0));
        }

        public Locale e(v2.a a0) {
            String s = null;
            if(a0.E() == b.m) {
                a0.y();
                return null;
            }
            StringTokenizer stringTokenizer0 = new StringTokenizer(a0.B(), "_");
            String s1 = stringTokenizer0.hasMoreElements() ? stringTokenizer0.nextToken() : null;
            String s2 = stringTokenizer0.hasMoreElements() ? stringTokenizer0.nextToken() : null;
            if(stringTokenizer0.hasMoreElements()) {
                s = stringTokenizer0.nextToken();
            }
            if(s2 == null && s == null) {
                return new Locale(s1);
            }
            return s == null ? new Locale(s1, s2) : new Locale(s1, s2, s);
        }

        public void f(c c0, Locale locale0) {
            c0.G((locale0 == null ? null : locale0.toString()));
        }
    }

    class t extends r {
        t() {
            super();
        }

        @Override  // n2.r
        public Object b(v2.a a0) {
            return this.e(a0);
        }

        @Override  // n2.r
        public void d(c c0, Object object0) {
            this.h(c0, ((n2.g)object0));
        }

        public n2.g e(v2.a a0) {
            b b0 = a0.E();
            n2.g g0 = this.g(a0, b0);
            if(g0 == null) {
                return this.f(a0, b0);
            }
            ArrayDeque arrayDeque0 = new ArrayDeque();
            while(true) {
                if(a0.l()) {
                    String s = g0 instanceof n2.j ? a0.v() : null;
                    b b1 = a0.E();
                    n2.g g1 = this.g(a0, b1);
                    boolean z = g1 != null;
                    if(g1 == null) {
                        g1 = this.f(a0, b1);
                    }
                    if(g0 instanceof n2.f) {
                        ((n2.f)g0).t(g1);
                    }
                    else {
                        ((n2.j)g0).t(s, g1);
                    }
                    if(!z) {
                        continue;
                    }
                    arrayDeque0.addLast(g0);
                    g0 = g1;
                }
                else {
                    if(g0 instanceof n2.f) {
                        a0.f();
                    }
                    else {
                        a0.g();
                    }
                    if(arrayDeque0.isEmpty()) {
                        break;
                    }
                    g0 = (n2.g)arrayDeque0.removeLast();
                }
            }
            return g0;
        }

        private n2.g f(v2.a a0, b b0) {
            switch(b0) {
                case 1: {
                    return new n2.l(new p2.g(a0.B()));
                }
                case 2: {
                    return new n2.l(a0.B());
                }
                case 3: {
                    return new n2.l(Boolean.valueOf(a0.q()));
                }
                case 6: {
                    a0.y();
                    return n2.i.e;
                }
                default: {
                    throw new IllegalStateException("Unexpected token: " + b0);
                }
            }
        }

        private n2.g g(v2.a a0, b b0) {
            switch(b0) {
                case 4: {
                    a0.a();
                    return new n2.f();
                }
                case 5: {
                    a0.b();
                    return new n2.j();
                }
                default: {
                    return null;
                }
            }
        }

        // 去混淆评级： 低(40)
        public void h(c c0, n2.g g0) {
            if(g0 != null) {
                throw new IllegalArgumentException("Couldn\'t write " + g0.getClass());
            }
            c0.n();
        }
    }

    class u implements n2.s {
        u() {
            super();
        }

        @Override  // n2.s
        public r a(n2.d d0, u2.a a0) {
            Class class0 = a0.c();
            if(Enum.class.isAssignableFrom(class0) && class0 != Enum.class) {
                if(!class0.isEnum()) {
                    class0 = class0.getSuperclass();
                }
                return new i0(class0);
            }
            return null;
        }
    }

    class v extends r {
        v() {
            super();
        }

        @Override  // n2.r
        public Object b(v2.a a0) {
            return this.e(a0);
        }

        @Override  // n2.r
        public void d(c c0, Object object0) {
            this.f(c0, ((BitSet)object0));
        }

        public BitSet e(v2.a a0) {
            BitSet bitSet0 = new BitSet();
            a0.a();
            b b0 = a0.E();
            int v = 0;
            while(b0 != b.f) {
                boolean z = true;
                switch(b0) {
                    case 1: 
                    case 2: {
                        int v1 = a0.t();
                        if(v1 == 0) {
                            z = false;
                        }
                        else if(v1 != 1) {
                            throw new n2.m("Invalid bitset value " + v1 + ", expected 0 or 1; at path " + a0.k());
                        }
                        break;
                    }
                    case 3: {
                        z = a0.q();
                        break;
                    }
                    default: {
                        throw new n2.m("Invalid bitset value type: " + b0 + "; at path " + a0.i());
                    }
                }
                if(z) {
                    bitSet0.set(v);
                }
                ++v;
                b0 = a0.E();
            }
            a0.f();
            return bitSet0;
        }

        public void f(c c0, BitSet bitSet0) {
            c0.c();
            int v = bitSet0.length();
            for(int v1 = 0; v1 < v; ++v1) {
                c0.D(((long)bitSet0.get(v1)));
            }
            c0.f();
        }
    }

    public static final r A;
    public static final r B;
    public static final n2.s C;
    public static final r D;
    public static final n2.s E;
    public static final r F;
    public static final n2.s G;
    public static final r H;
    public static final n2.s I;
    public static final r J;
    public static final n2.s K;
    public static final r L;
    public static final n2.s M;
    public static final r N;
    public static final n2.s O;
    public static final r P;
    public static final n2.s Q;
    public static final r R;
    public static final n2.s S;
    public static final r T;
    public static final n2.s U;
    public static final r V;
    public static final n2.s W;
    public static final n2.s X;
    public static final r a;
    public static final n2.s b;
    public static final r c;
    public static final n2.s d;
    public static final r e;
    public static final r f;
    public static final n2.s g;
    public static final r h;
    public static final n2.s i;
    public static final r j;
    public static final n2.s k;
    public static final r l;
    public static final n2.s m;
    public static final r n;
    public static final n2.s o;
    public static final r p;
    public static final n2.s q;
    public static final r r;
    public static final n2.s s;
    public static final r t;
    public static final r u;
    public static final r v;
    public static final r w;
    public static final n2.s x;
    public static final r y;
    public static final r z;

    static {
        r r0 = new k().a();
        m.a = r0;
        m.b = m.b(Class.class, r0);
        r r1 = new v().a();
        m.c = r1;
        m.d = m.b(BitSet.class, r1);
        b0 m$b00 = new b0();
        m.e = m$b00;
        m.f = new c0();
        m.g = m.a(Boolean.TYPE, Boolean.class, m$b00);
        d0 m$d00 = new d0();
        m.h = m$d00;
        m.i = m.a(Byte.TYPE, Byte.class, m$d00);
        e0 m$e00 = new e0();
        m.j = m$e00;
        m.k = m.a(Short.TYPE, Short.class, m$e00);
        f0 m$f00 = new f0();
        m.l = m$f00;
        m.m = m.a(Integer.TYPE, Integer.class, m$f00);
        r r2 = new g0().a();
        m.n = r2;
        m.o = m.b(AtomicInteger.class, r2);
        r r3 = new h0().a();
        m.p = r3;
        m.q = m.b(AtomicBoolean.class, r3);
        r r4 = new a().a();
        m.r = r4;
        m.s = m.b(AtomicIntegerArray.class, r4);
        m.t = new q2.m.b();
        m.u = new q2.m.c();
        m.v = new d();
        e m$e0 = new e();
        m.w = m$e0;
        m.x = m.a(Character.TYPE, Character.class, m$e0);
        f m$f0 = new f();
        m.y = m$f0;
        m.z = new g();
        m.A = new h();
        m.B = new i();
        m.C = m.b(String.class, m$f0);
        j m$j0 = new j();
        m.D = m$j0;
        m.E = m.b(StringBuilder.class, m$j0);
        l m$l0 = new l();
        m.F = m$l0;
        m.G = m.b(StringBuffer.class, m$l0);
        q2.m.m m$m0 = new q2.m.m();
        m.H = m$m0;
        m.I = m.b(URL.class, m$m0);
        n m$n0 = new n();
        m.J = m$n0;
        m.K = m.b(URI.class, m$n0);
        o m$o0 = new o();
        m.L = m$o0;
        m.M = m.d(InetAddress.class, m$o0);
        p m$p0 = new p();
        m.N = m$p0;
        m.O = m.b(UUID.class, m$p0);
        r r5 = new q().a();
        m.P = r5;
        m.Q = m.b(Currency.class, r5);
        q2.m.r m$r0 = new q2.m.r();
        m.R = m$r0;
        m.S = m.c(Calendar.class, GregorianCalendar.class, m$r0);
        s m$s0 = new s();
        m.T = m$s0;
        m.U = m.b(Locale.class, m$s0);
        t m$t0 = new t();
        m.V = m$t0;
        m.W = m.d(n2.g.class, m$t0);
        m.X = new u();
    }

    public static n2.s a(Class class0, Class class1, r r0) {
        class x implements n2.s {
            final Class e;
            final Class f;
            final r g;

            x(Class class0, Class class1, r r0) {
                this.f = class1;
                this.g = r0;
                super();
            }

            @Override  // n2.s
            public r a(n2.d d0, u2.a a0) {
                Class class0 = a0.c();
                return class0 == this.e || class0 == this.f ? this.g : null;
            }

            @Override
            public String toString() {
                return "Factory[type=" + this.f.getName() + "+" + this.e.getName() + ",adapter=" + this.g + "]";
            }
        }

        return new x(class0, class1, r0);
    }

    public static n2.s b(Class class0, r r0) {
        class w implements n2.s {
            final Class e;
            final r f;

            w(Class class0, r r0) {
                this.f = r0;
                super();
            }

            @Override  // n2.s
            public r a(n2.d d0, u2.a a0) {
                return a0.c() == this.e ? this.f : null;
            }

            @Override
            public String toString() {
                return "Factory[type=" + this.e.getName() + ",adapter=" + this.f + "]";
            }
        }

        return new w(class0, r0);
    }

    public static n2.s c(Class class0, Class class1, r r0) {
        class y implements n2.s {
            final Class e;
            final Class f;
            final r g;

            y(Class class0, Class class1, r r0) {
                this.f = class1;
                this.g = r0;
                super();
            }

            @Override  // n2.s
            public r a(n2.d d0, u2.a a0) {
                Class class0 = a0.c();
                return class0 == this.e || class0 == this.f ? this.g : null;
            }

            @Override
            public String toString() {
                return "Factory[type=" + this.e.getName() + "+" + this.f.getName() + ",adapter=" + this.g + "]";
            }
        }

        return new y(class0, class1, r0);
    }

    public static n2.s d(Class class0, r r0) {
        class z implements n2.s {
            final Class e;
            final r f;

            z(Class class0, r r0) {
                this.f = r0;
                super();
            }

            @Override  // n2.s
            public r a(n2.d d0, u2.a a0) {
                class q2.m.z.a extends r {
                    final Class a;
                    final z b;

                    q2.m.z.a(Class class0) {
                        this.a = class0;
                        super();
                    }

                    @Override  // n2.r
                    public Object b(v2.a a0) {
                        Object object0 = z.this.f.b(a0);
                        if(object0 != null && !this.a.isInstance(object0)) {
                            throw new n2.m("Expected a " + this.a.getName() + " but was " + object0.getClass().getName() + "; at path " + a0.k());
                        }
                        return object0;
                    }

                    @Override  // n2.r
                    public void d(c c0, Object object0) {
                        z.this.f.d(c0, object0);
                    }
                }

                Class class0 = a0.c();
                return !this.e.isAssignableFrom(class0) ? null : new q2.m.z.a(this, class0);
            }

            @Override
            public String toString() {
                return "Factory[typeHierarchy=" + this.e.getName() + ",adapter=" + this.f + "]";
            }
        }

        return new z(class0, r0);
    }
}

