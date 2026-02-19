package r0;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import j0.h;
import j0.i;
import j0.o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import m0.f;
import s0.b;

public class m0 implements c, d, b {
    static abstract class a {
    }

    interface r0.m0.b {
        Object a(Object arg1);
    }

    static class r0.m0.c {
        final String a;
        final String b;

        private r0.m0.c(String s, String s1) {
            this.a = s;
            this.b = s1;
        }

        r0.m0.c(String s, String s1, a m0$a0) {
            this(s, s1);
        }
    }

    interface r0.m0.d {
        Object a();
    }

    private final t0 e;
    private final t0.a f;
    private final t0.a g;
    private final e h;
    private final a3.a i;
    private static final h0.b j;

    static {
        m0.j = h0.b.b("proto");
    }

    m0(t0.a a0, t0.a a1, e e0, t0 t00, a3.a a2) {
        this.e = t00;
        this.f = a0;
        this.g = a1;
        this.h = e0;
        this.i = a2;
    }

    private static byte[] A0(String s) {
        return s == null ? null : Base64.decode(s, 0);
    }

    private void B0(m0.a.a a$a0, Map map0) {
        for(Object object0: map0.entrySet()) {
            a$a0.a(m0.d.c().c(((String)((Map.Entry)object0).getKey())).b(((List)((Map.Entry)object0).getValue())).a());
        }
    }

    @Override  // r0.d
    public k C(o o0, i i0) {
        n0.a.c("SQLiteEventStore", "Storing event with priority=%s, name=%s for destination %s", new Object[]{o0.d(), i0.j(), o0.b()});
        long v = (long)(((Long)this.V((SQLiteDatabase sQLiteDatabase0) -> {
            if(this.W()) {
                String s = i0.j();
                this.d(1L, m0.c.b.h, s);
                return -1L;
            }
            long v = this.M(sQLiteDatabase0, o0);
            int v1 = this.h.e();
            byte[] arr_b = i0.e().a();
            boolean z = arr_b.length <= v1;
            ContentValues contentValues0 = new ContentValues();
            contentValues0.put("context_id", v);
            contentValues0.put("transport_name", i0.j());
            contentValues0.put("timestamp_ms", i0.f());
            contentValues0.put("uptime_ms", i0.k());
            contentValues0.put("payload_encoding", i0.e().b().a());
            contentValues0.put("code", i0.d());
            contentValues0.put("num_attempts", 0);
            contentValues0.put("inline", Boolean.valueOf(z));
            contentValues0.put("payload", (z ? arr_b : new byte[0]));
            long v3 = sQLiteDatabase0.insert("events", null, contentValues0);
            if(!z) {
                int v4 = (int)Math.ceil(((double)arr_b.length) / ((double)v1));
                for(int v2 = 1; v2 <= v4; ++v2) {
                    byte[] arr_b1 = Arrays.copyOfRange(arr_b, (v2 - 1) * v1, Math.min(v2 * v1, arr_b.length));
                    ContentValues contentValues1 = new ContentValues();
                    contentValues1.put("event_id", v3);
                    contentValues1.put("sequence_num", v2);
                    contentValues1.put("bytes", arr_b1);
                    sQLiteDatabase0.insert("event_payloads", null, contentValues1);
                }
            }
            for(Object object0: i0.i().entrySet()) {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("event_id", v3);
                contentValues2.put("name", ((String)((Map.Entry)object0).getKey()));
                contentValues2.put("value", ((String)((Map.Entry)object0).getValue()));
                sQLiteDatabase0.insert("event_metadata", null, contentValues2);
            }
            return v3;
        })));
        return v >= 1L ? k.a(v, o0, i0) : null;
    }

    private byte[] C0(long v) {
        return (byte[])m0.G0(this.O().query("event_payloads", new String[]{"bytes"}, "event_id = ?", new String[]{String.valueOf(v)}, null, null, "sequence_num"), (Cursor cursor0) -> {
            ArrayList arrayList0 = new ArrayList();
            int v;
            for(v = 0; cursor0.moveToNext(); v += arr_b.length) {
                byte[] arr_b = cursor0.getBlob(0);
                arrayList0.add(arr_b);
            }
            byte[] arr_b1 = new byte[v];
            int v2 = 0;
            for(int v1 = 0; v1 < arrayList0.size(); ++v1) {
                byte[] arr_b2 = (byte[])arrayList0.get(v1);
                System.arraycopy(arr_b2, 0, arr_b1, v2, arr_b2.length);
                v2 += arr_b2.length;
            }
            return arr_b1;
        });
    }

    private Object D0(r0.m0.d m0$d0, r0.m0.b m0$b0) {
        long v = this.g.a();
        while(true) {
            try {
                return m0$d0.a();
            }
            catch(SQLiteDatabaseLockedException sQLiteDatabaseLockedException0) {
            }
            if(this.g.a() >= ((long)this.h.b()) + v) {
                break;
            }
            SystemClock.sleep(50L);
        }
        return m0$b0.a(sQLiteDatabaseLockedException0);
    }

    private static h0.b E0(String s) {
        return s == null ? m0.j : h0.b.b(s);
    }

    private static String F0(Iterable iterable0) {
        StringBuilder stringBuilder0 = new StringBuilder("(");
        Iterator iterator0 = iterable0.iterator();
        while(iterator0.hasNext()) {
            Object object0 = iterator0.next();
            stringBuilder0.append(((k)object0).c());
            if(iterator0.hasNext()) {
                stringBuilder0.append(',');
            }
        }
        stringBuilder0.append(')');
        return stringBuilder0.toString();
    }

    static Object G0(Cursor cursor0, r0.m0.b m0$b0) {
        try(cursor0) {
            return m0$b0.a(cursor0);
        }
    }

    @Override  // r0.d
    public void H(Iterable iterable0) {
        if(!iterable0.iterator().hasNext()) {
            return;
        }
        this.V((SQLiteDatabase sQLiteDatabase0) -> {
            sQLiteDatabase0.compileStatement("UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in " + m0.F0(iterable0)).execute();
            m0.G0(sQLiteDatabase0.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE num_attempts >= 16 GROUP BY transport_name", null), (Cursor cursor0) -> {
                while(cursor0.moveToNext()) {
                    int v = cursor0.getInt(0);
                    String s = cursor0.getString(1);
                    this.d(((long)v), m0.c.b.j, s);
                }
                return null;
            });
            sQLiteDatabase0.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
            return null;
        });
    }

    private m0.c.b J(int v) {
        m0.c.b c$b0 = m0.c.b.f;
        if(v == c$b0.c()) {
            return c$b0;
        }
        m0.c.b c$b1 = m0.c.b.g;
        if(v == c$b1.c()) {
            return c$b1;
        }
        m0.c.b c$b2 = m0.c.b.h;
        if(v == c$b2.c()) {
            return c$b2;
        }
        m0.c.b c$b3 = m0.c.b.i;
        if(v == c$b3.c()) {
            return c$b3;
        }
        m0.c.b c$b4 = m0.c.b.j;
        if(v == c$b4.c()) {
            return c$b4;
        }
        m0.c.b c$b5 = m0.c.b.k;
        if(v == c$b5.c()) {
            return c$b5;
        }
        m0.c.b c$b6 = m0.c.b.l;
        if(v == c$b6.c()) {
            return c$b6;
        }
        n0.a.b("SQLiteEventStore", "%n is not valid. No matched LogEventDropped-Reason found. Treated it as REASON_UNKNOWN", v);
        return c$b0;
    }

    @Override  // r0.d
    public Iterable K(o o0) {
        return (Iterable)this.V((SQLiteDatabase sQLiteDatabase0) -> {
            List list0 = this.y0(sQLiteDatabase0, o0, this.h.d());
            h0.d[] arr_d = h0.d.values();
            for(int v = 0; v < arr_d.length; ++v) {
                h0.d d0 = arr_d[v];
                if(d0 != o0.d()) {
                    int v1 = this.h.d() - list0.size();
                    if(v1 <= 0) {
                        break;
                    }
                    list0.addAll(this.y0(sQLiteDatabase0, o0.f(d0), v1));
                }
            }
            return this.X(list0, this.z0(sQLiteDatabase0, list0));
        });
    }

    private void L(SQLiteDatabase sQLiteDatabase0) {
        this.D0(() -> {
            sQLiteDatabase0.beginTransaction();
            return null;
        }, (Throwable throwable0) -> throw new s0.a("Timed out while trying to acquire the lock.", throwable0));
    }

    private long M(SQLiteDatabase sQLiteDatabase0, o o0) {
        Long long0 = this.T(sQLiteDatabase0, o0);
        if(long0 != null) {
            return (long)long0;
        }
        ContentValues contentValues0 = new ContentValues();
        contentValues0.put("backend_name", o0.b());
        contentValues0.put("priority", u0.a.a(o0.d()));
        contentValues0.put("next_request_ms", 0);
        if(o0.c() != null) {
            contentValues0.put("extras", Base64.encodeToString(o0.c(), 0));
        }
        return sQLiteDatabase0.insert("transport_contexts", null, contentValues0);
    }

    long N() {
        return this.Q() * this.R();
    }

    SQLiteDatabase O() {
        Objects.requireNonNull(this.e);
        return (SQLiteDatabase)this.D0(new w(this.e), (Throwable throwable0) -> throw new s0.a("Timed out while trying to open db.", throwable0));
    }

    private m0.b P() {
        return m0.b.b().b(m0.e.c().b(this.N()).c(e.a.f()).a()).a();
    }

    private long Q() {
        return this.O().compileStatement("PRAGMA page_count").simpleQueryForLong();
    }

    private long R() {
        return this.O().compileStatement("PRAGMA page_size").simpleQueryForLong();
    }

    private f S() {
        return (f)this.V((SQLiteDatabase sQLiteDatabase0) -> ((f)m0.G0(sQLiteDatabase0.rawQuery("SELECT last_metrics_upload_ms FROM global_log_event_state LIMIT 1", new String[0]), (Cursor cursor0) -> {
            cursor0.moveToNext();
            long v1 = cursor0.getLong(0);
            return f.c().c(v1).b(v).a();
        })));
    }

    private Long T(SQLiteDatabase sQLiteDatabase0, o o0) {
        StringBuilder stringBuilder0 = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList0 = new ArrayList(Arrays.asList(new String[]{o0.b(), String.valueOf(u0.a.a(o0.d()))}));
        if(o0.c() == null) {
            stringBuilder0.append(" and extras is null");
        }
        else {
            stringBuilder0.append(" and extras = ?");
            arrayList0.add(Base64.encodeToString(o0.c(), 0));
        }
        Object[] arr_object = arrayList0.toArray(new String[0]);
        return (Long)m0.G0(sQLiteDatabase0.query("transport_contexts", new String[]{"_id"}, stringBuilder0.toString(), ((String[])arr_object), null, null, null), (Cursor cursor0) -> (cursor0.moveToNext() ? cursor0.getLong(0) : null));
    }

    @Override  // r0.d
    public long U(o o0) {
        return (long)(((Long)m0.G0(this.O().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{o0.b(), String.valueOf(u0.a.a(o0.d()))}), (Cursor cursor0) -> // 去混淆评级： 低(20)
        (cursor0.moveToNext() ? cursor0.getLong(0) : 0L))));
    }

    Object V(r0.m0.b m0$b0) {
        SQLiteDatabase sQLiteDatabase0 = this.O();
        sQLiteDatabase0.beginTransaction();
        try {
            Object object0 = m0$b0.a(sQLiteDatabase0);
            sQLiteDatabase0.setTransactionSuccessful();
            return object0;
        }
        finally {
            sQLiteDatabase0.endTransaction();
        }
    }

    private boolean W() {
        return this.Q() * this.R() >= this.h.f();
    }

    private List X(List list0, Map map0) {
        ListIterator listIterator0 = list0.listIterator();
        while(listIterator0.hasNext()) {
            k k0 = (k)listIterator0.next();
            if(map0.containsKey(k0.c())) {
                j0.i.a i$a0 = k0.b().l();
                for(Object object0: ((Set)map0.get(k0.c()))) {
                    i$a0.c(((r0.m0.c)object0).a, ((r0.m0.c)object0).b);
                }
                listIterator0.set(k.a(k0.c(), k0.d(), i$a0.d()));
            }
        }
        return list0;
    }

    // 检测为 Lambda 实现
    private Object Y(Cursor cursor0) [...]

    // 检测为 Lambda 实现
    private Integer Z(long v, SQLiteDatabase sQLiteDatabase0) [...]

    @Override  // r0.c
    public void a() {
        this.V((SQLiteDatabase sQLiteDatabase0) -> {
            sQLiteDatabase0.compileStatement("DELETE FROM log_event_dropped").execute();
            sQLiteDatabase0.compileStatement("UPDATE global_log_event_state SET last_metrics_upload_ms=" + this.f.a()).execute();
            return null;
        });
    }

    // 检测为 Lambda 实现
    private static Object a0(SQLiteDatabase sQLiteDatabase0) [...]

    @Override  // s0.b
    public Object b(s0.b.a b$a0) {
        SQLiteDatabase sQLiteDatabase0 = this.O();
        this.L(sQLiteDatabase0);
        try {
            Object object0 = b$a0.a();
            sQLiteDatabase0.setTransactionSuccessful();
            return object0;
        }
        finally {
            sQLiteDatabase0.endTransaction();
        }
    }

    // 检测为 Lambda 实现
    private static Object b0(Throwable throwable0) [...]

    @Override  // r0.c
    public m0.a c() {
        m0.a.a a$a0 = m0.a.e();
        return (m0.a)this.V((SQLiteDatabase sQLiteDatabase0) -> ((m0.a)m0.G0(sQLiteDatabase0.rawQuery("SELECT log_source, reason, events_dropped_count FROM log_event_dropped", new String[0]), (Cursor cursor0) -> {
            while(cursor0.moveToNext()) {
                String s = cursor0.getString(0);
                m0.c.b c$b0 = this.J(cursor0.getInt(1));
                long v = cursor0.getLong(2);
                if(!map0.containsKey(s)) {
                    map0.put(s, new ArrayList());
                }
                ((List)map0.get(s)).add(m0.c.c().c(c$b0).b(v).a());
            }
            this.B0(a$a0, map0);
            a$a0.e(this.S());
            a$a0.d(this.P());
            a$a0.c(((String)this.i.get()));
            return a$a0.b();
        })));
    }

    // 检测为 Lambda 实现
    private static SQLiteDatabase c0(Throwable throwable0) [...]

    @Override
    public void close() {
        this.e.close();
    }

    @Override  // r0.c
    public void d(long v, m0.c.b c$b0, String s) {
        this.V((SQLiteDatabase sQLiteDatabase0) -> {
            if(!((Boolean)m0.G0(sQLiteDatabase0.rawQuery("SELECT 1 FROM log_event_dropped WHERE log_source = ? AND reason = ?", new String[]{s, Integer.toString(c$b0.c())}), (Cursor cursor0) -> (cursor0.getCount() <= 0 ? false : true))).booleanValue()) {
                ContentValues contentValues0 = new ContentValues();
                contentValues0.put("log_source", s);
                contentValues0.put("reason", c$b0.c());
                contentValues0.put("events_dropped_count", v);
                sQLiteDatabase0.insert("log_event_dropped", null, contentValues0);
                return null;
            }
            sQLiteDatabase0.execSQL("UPDATE log_event_dropped SET events_dropped_count = events_dropped_count + " + v + " WHERE log_source = ? AND reason = ?", new String[]{s, Integer.toString(c$b0.c())});
            return null;
        });
    }

    // 去混淆评级： 低(20)
    // 检测为 Lambda 实现
    private static Long d0(Cursor cursor0) [...]

    // 检测为 Lambda 实现
    private static f e0(long v, Cursor cursor0) [...]

    // 检测为 Lambda 实现
    private static f f0(long v, SQLiteDatabase sQLiteDatabase0) [...]

    // 检测为 Lambda 实现
    private static Long g0(Cursor cursor0) [...]

    @Override  // r0.d
    public Iterable h0() {
        return (Iterable)this.V((SQLiteDatabase sQLiteDatabase0) -> ((List)m0.G0(sQLiteDatabase0.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), (Cursor cursor0) -> {
            List list0 = new ArrayList();
            while(cursor0.moveToNext()) {
                list0.add(o.a().b(cursor0.getString(1)).d(u0.a.b(cursor0.getInt(2))).c(m0.A0(cursor0.getString(3))).a());
            }
            return list0;
        })));
    }

    // 检测为 Lambda 实现
    private Boolean i0(o o0, SQLiteDatabase sQLiteDatabase0) [...]

    // 检测为 Lambda 实现
    private static List j0(SQLiteDatabase sQLiteDatabase0) [...]

    // 检测为 Lambda 实现
    private static List k0(Cursor cursor0) [...]

    // 检测为 Lambda 实现
    private List l0(o o0, SQLiteDatabase sQLiteDatabase0) [...]

    // 检测为 Lambda 实现
    private m0.a m0(Map map0, m0.a.a a$a0, Cursor cursor0) [...]

    // 检测为 Lambda 实现
    private m0.a n0(String s, Map map0, m0.a.a a$a0, SQLiteDatabase sQLiteDatabase0) [...]

    @Override  // r0.d
    public int o() {
        return (int)(((Integer)this.V((SQLiteDatabase sQLiteDatabase0) -> {
            String[] arr_s = {String.valueOf(this.f.a() - this.h.c())};
            m0.G0(sQLiteDatabase0.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE timestamp_ms < ? GROUP BY transport_name", arr_s), (Cursor cursor0) -> {
                while(cursor0.moveToNext()) {
                    int v = cursor0.getInt(0);
                    String s = cursor0.getString(1);
                    this.d(((long)v), m0.c.b.g, s);
                }
                return null;
            });
            return sQLiteDatabase0.delete("events", "timestamp_ms < ?", arr_s);
        })));
    }

    // 检测为 Lambda 实现
    private Object o0(List list0, o o0, Cursor cursor0) [...]

    // 检测为 Lambda 实现
    private static Object p0(Map map0, Cursor cursor0) [...]

    // 检测为 Lambda 实现
    private Long q0(i i0, o o0, SQLiteDatabase sQLiteDatabase0) [...]

    // 检测为 Lambda 实现
    private static byte[] r0(Cursor cursor0) [...]

    @Override  // r0.d
    public void s(Iterable iterable0) {
        if(!iterable0.iterator().hasNext()) {
            return;
        }
        this.O().compileStatement("DELETE FROM events WHERE _id in " + m0.F0(iterable0)).execute();
    }

    // 检测为 Lambda 实现
    private Object s0(Cursor cursor0) [...]

    // 检测为 Lambda 实现
    private Object t0(String s, String s1, SQLiteDatabase sQLiteDatabase0) [...]

    // 检测为 Lambda 实现
    private static Boolean u0(Cursor cursor0) [...]

    // 检测为 Lambda 实现
    private static Object v0(String s, m0.c.b c$b0, long v, SQLiteDatabase sQLiteDatabase0) [...]

    // 检测为 Lambda 实现
    private static Object w0(long v, o o0, SQLiteDatabase sQLiteDatabase0) [...]

    @Override  // r0.d
    public void x(o o0, long v) {
        this.V((SQLiteDatabase sQLiteDatabase0) -> {
            ContentValues contentValues0 = new ContentValues();
            contentValues0.put("next_request_ms", v);
            if(sQLiteDatabase0.update("transport_contexts", contentValues0, "backend_name = ? and priority = ?", new String[]{o0.b(), String.valueOf(u0.a.a(o0.d()))}) < 1) {
                contentValues0.put("backend_name", o0.b());
                contentValues0.put("priority", u0.a.a(o0.d()));
                sQLiteDatabase0.insert("transport_contexts", null, contentValues0);
            }
            return null;
        });
    }

    // 检测为 Lambda 实现
    private Object x0(SQLiteDatabase sQLiteDatabase0) [...]

    private List y0(SQLiteDatabase sQLiteDatabase0, o o0, int v) {
        List list0 = new ArrayList();
        Long long0 = this.T(sQLiteDatabase0, o0);
        if(long0 == null) {
            return list0;
        }
        m0.G0(sQLiteDatabase0.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", "inline"}, "context_id = ?", new String[]{long0.toString()}, null, null, null, String.valueOf(v)), (Cursor cursor0) -> {
            while(cursor0.moveToNext()) {
                boolean z = false;
                long v = cursor0.getLong(0);
                if(cursor0.getInt(7) != 0) {
                    z = true;
                }
                j0.i.a i$a0 = i.a().j(cursor0.getString(1)).i(cursor0.getLong(2)).k(cursor0.getLong(3));
                i$a0.h((z ? new h(m0.E0(cursor0.getString(4)), cursor0.getBlob(5)) : new h(m0.E0(cursor0.getString(4)), this.C0(v))));
                if(!cursor0.isNull(6)) {
                    i$a0.g(cursor0.getInt(6));
                }
                list0.add(k.a(v, o0, i$a0.d()));
            }
            return null;
        });
        return list0;
    }

    @Override  // r0.d
    public boolean z(o o0) {
        return ((Boolean)this.V((SQLiteDatabase sQLiteDatabase0) -> {
            Long long0 = this.T(sQLiteDatabase0, o0);
            return long0 == null ? false : ((Boolean)m0.G0(this.O().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{long0.toString()}), new z()));
        })).booleanValue();
    }

    private Map z0(SQLiteDatabase sQLiteDatabase0, List list0) {
        Map map0 = new HashMap();
        StringBuilder stringBuilder0 = new StringBuilder("event_id IN (");
        for(int v = 0; v < list0.size(); ++v) {
            stringBuilder0.append(((k)list0.get(v)).c());
            if(v < list0.size() - 1) {
                stringBuilder0.append(',');
            }
        }
        stringBuilder0.append(')');
        m0.G0(sQLiteDatabase0.query("event_metadata", new String[]{"event_id", "name", "value"}, stringBuilder0.toString(), null, null, null, null), (Cursor cursor0) -> {
            while(cursor0.moveToNext()) {
                long v = cursor0.getLong(0);
                Set set0 = (Set)map0.get(v);
                if(set0 == null) {
                    set0 = new HashSet();
                    map0.put(v, set0);
                }
                set0.add(new r0.m0.c(cursor0.getString(1), cursor0.getString(2), null));
            }
            return null;
        });
        return map0;
    }
}

