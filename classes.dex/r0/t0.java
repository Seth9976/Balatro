package r0;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.Arrays;
import java.util.List;

final class t0 extends SQLiteOpenHelper {
    public interface a {
        void a(SQLiteDatabase arg1);
    }

    private final int e;
    private boolean f;
    private static final String g;
    static int h;
    private static final a i;
    private static final a j;
    private static final a k;
    private static final a l;
    private static final a m;
    private static final List n;

    static {
        t0.g = "INSERT INTO global_log_event_state VALUES (" + System.currentTimeMillis() + ")";
        t0.h = 5;
        o0 o00 = (SQLiteDatabase sQLiteDatabase0) -> {
            sQLiteDatabase0.execSQL("CREATE TABLE events (_id INTEGER PRIMARY KEY, context_id INTEGER NOT NULL, transport_name TEXT NOT NULL, timestamp_ms INTEGER NOT NULL, uptime_ms INTEGER NOT NULL, payload BLOB NOT NULL, code INTEGER, num_attempts INTEGER NOT NULL,FOREIGN KEY (context_id) REFERENCES transport_contexts(_id) ON DELETE CASCADE)");
            sQLiteDatabase0.execSQL("CREATE TABLE event_metadata (_id INTEGER PRIMARY KEY, event_id INTEGER NOT NULL, name TEXT NOT NULL, value TEXT NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE)");
            sQLiteDatabase0.execSQL("CREATE TABLE transport_contexts (_id INTEGER PRIMARY KEY, backend_name TEXT NOT NULL, priority INTEGER NOT NULL, next_request_ms INTEGER NOT NULL)");
            sQLiteDatabase0.execSQL("CREATE INDEX events_backend_id on events(context_id)");
            sQLiteDatabase0.execSQL("CREATE UNIQUE INDEX contexts_backend_priority on transport_contexts(backend_name, priority)");
        };
        t0.i = o00;
        p0 p00 = (SQLiteDatabase sQLiteDatabase0) -> {
            sQLiteDatabase0.execSQL("ALTER TABLE transport_contexts ADD COLUMN extras BLOB");
            sQLiteDatabase0.execSQL("CREATE UNIQUE INDEX contexts_backend_priority_extras on transport_contexts(backend_name, priority, extras)");
            sQLiteDatabase0.execSQL("DROP INDEX contexts_backend_priority");
        };
        t0.j = p00;
        q0 q00 = (SQLiteDatabase sQLiteDatabase0) -> sQLiteDatabase0.execSQL("ALTER TABLE events ADD COLUMN payload_encoding TEXT");
        t0.k = q00;
        r0 r00 = (SQLiteDatabase sQLiteDatabase0) -> {
            sQLiteDatabase0.execSQL("ALTER TABLE events ADD COLUMN inline BOOLEAN NOT NULL DEFAULT 1");
            sQLiteDatabase0.execSQL("DROP TABLE IF EXISTS event_payloads");
            sQLiteDatabase0.execSQL("CREATE TABLE event_payloads (sequence_num INTEGER NOT NULL, event_id INTEGER NOT NULL, bytes BLOB NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE,PRIMARY KEY (sequence_num, event_id))");
        };
        t0.l = r00;
        s0 s00 = (SQLiteDatabase sQLiteDatabase0) -> {
            sQLiteDatabase0.execSQL("DROP TABLE IF EXISTS log_event_dropped");
            sQLiteDatabase0.execSQL("DROP TABLE IF EXISTS global_log_event_state");
            sQLiteDatabase0.execSQL("CREATE TABLE log_event_dropped (log_source VARCHAR(45) NOT NULL,reason INTEGER NOT NULL,events_dropped_count BIGINT NOT NULL,PRIMARY KEY(log_source, reason))");
            sQLiteDatabase0.execSQL("CREATE TABLE global_log_event_state (last_metrics_upload_ms BIGINT PRIMARY KEY)");
            sQLiteDatabase0.execSQL("INSERT INTO global_log_event_state VALUES (1771482071189)");
        };
        t0.m = s00;
        t0.n = Arrays.asList(new a[]{o00, p00, q00, r00, s00});
    }

    t0(Context context0, String s, int v) {
        super(context0, s, null, v);
        this.f = false;
        this.e = v;
    }

    private void f(SQLiteDatabase sQLiteDatabase0) {
        if(!this.f) {
            this.onConfigure(sQLiteDatabase0);
        }
    }

    // 检测为 Lambda 实现
    private static void g(SQLiteDatabase sQLiteDatabase0) [...]

    // 检测为 Lambda 实现
    private static void h(SQLiteDatabase sQLiteDatabase0) [...]

    // 检测为 Lambda 实现
    private static void i(SQLiteDatabase sQLiteDatabase0) [...]

    // 检测为 Lambda 实现
    private static void j(SQLiteDatabase sQLiteDatabase0) [...]

    // 检测为 Lambda 实现
    private static void k(SQLiteDatabase sQLiteDatabase0) [...]

    private void l(SQLiteDatabase sQLiteDatabase0, int v) {
        this.f(sQLiteDatabase0);
        this.m(sQLiteDatabase0, 0, v);
    }

    private void m(SQLiteDatabase sQLiteDatabase0, int v, int v1) {
        List list0 = t0.n;
        if(v1 > list0.size()) {
            throw new IllegalArgumentException("Migration from " + v + " to " + v1 + " was requested, but cannot be performed. Only " + list0.size() + " migrations are provided");
        }
        while(v < v1) {
            ((a)t0.n.get(v)).a(sQLiteDatabase0);
            ++v;
        }
    }

    @Override  // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(SQLiteDatabase sQLiteDatabase0) {
        this.f = true;
        sQLiteDatabase0.rawQuery("PRAGMA busy_timeout=0;", new String[0]).close();
        sQLiteDatabase0.setForeignKeyConstraintsEnabled(true);
    }

    @Override  // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase0) {
        this.l(sQLiteDatabase0, this.e);
    }

    @Override  // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase0, int v, int v1) {
        sQLiteDatabase0.execSQL("DROP TABLE events");
        sQLiteDatabase0.execSQL("DROP TABLE event_metadata");
        sQLiteDatabase0.execSQL("DROP TABLE transport_contexts");
        sQLiteDatabase0.execSQL("DROP TABLE IF EXISTS event_payloads");
        sQLiteDatabase0.execSQL("DROP TABLE IF EXISTS log_event_dropped");
        sQLiteDatabase0.execSQL("DROP TABLE IF EXISTS global_log_event_state");
        this.l(sQLiteDatabase0, v1);
    }

    @Override  // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase0) {
        this.f(sQLiteDatabase0);
    }

    @Override  // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase0, int v, int v1) {
        this.f(sQLiteDatabase0);
        this.m(sQLiteDatabase0, v, v1);
    }
}

