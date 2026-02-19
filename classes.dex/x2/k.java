package x2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashSet;
import java.util.Set;

public class k implements j {
    static class a extends SQLiteOpenHelper {
        private SQLiteDatabase e;

        public a(Context context0) {
            super(context0, "singular-batch-managerx-1.db", null, 1);
        }

        public boolean a(String s) {
            SQLiteDatabase sQLiteDatabase2;
            SQLiteDatabase sQLiteDatabase1;
            synchronized(this) {
                k.c.a("SQLiteHelper.delete key: " + s);
                if(!this.d(s)) {
                    k.c.a("SQLiteHelper.delete key does not exist - returning false ");
                    return false;
                }
                try {
                    SQLiteDatabase sQLiteDatabase0 = this.getWritableDatabase();
                    this.e = sQLiteDatabase0;
                    if(sQLiteDatabase0.delete("events", "eventKey =?", new String[]{s}) != 1) {
                        k.c.a("SQLiteHelper.delete failed ");
                        sQLiteDatabase1 = this.e;
                        if(sQLiteDatabase1 != null) {
                            goto label_15;
                        }
                        return false;
                    }
                    goto label_18;
                }
                catch(SQLException unused_ex) {
                    throw new IOException();
                }
                catch(Throwable throwable0) {
                    goto label_23;
                }
            label_15:
                sQLiteDatabase1.close();
                return false;
                try {
                    try {
                    label_18:
                        k.c.a("SQLiteHelper.delete - success ");
                        sQLiteDatabase2 = this.e;
                    }
                    catch(SQLException unused_ex) {
                        throw new IOException();
                    }
                }
                catch(Throwable throwable0) {
                label_23:
                    SQLiteDatabase sQLiteDatabase3 = this.e;
                    if(sQLiteDatabase3 != null) {
                        sQLiteDatabase3.close();
                    }
                    throw throwable0;
                }
                if(sQLiteDatabase2 != null) {
                    sQLiteDatabase2.close();
                }
                return true;
            }
        }

        public Set b() {
            SQLiteDatabase sQLiteDatabase2;
            synchronized(this) {
                k.c.a("SQLiteHelper.getAll");
                Set set0 = new HashSet();
                Cursor cursor0 = null;
                try {
                    SQLiteDatabase sQLiteDatabase0 = this.getReadableDatabase();
                    this.e = sQLiteDatabase0;
                    cursor0 = sQLiteDatabase0.rawQuery("SELECT * FROM events", null);
                    if(cursor0 != null && cursor0.getCount() != 0) {
                        cursor0.moveToFirst();
                        do {
                            set0.add(new AbstractMap.SimpleEntry(cursor0.getString(cursor0.getColumnIndex("eventKey")), cursor0.getString(cursor0.getColumnIndex("value"))));
                        }
                        while(cursor0.moveToNext());
                    }
                }
                catch(Throwable throwable0) {
                    try {
                        k.c.c("SQLiteHelper.getAll exception: " + throwable0.getMessage());
                        k.c.c(p0.h(throwable0));
                    }
                    catch(Throwable throwable1) {
                        if(cursor0 != null) {
                            cursor0.close();
                        }
                        SQLiteDatabase sQLiteDatabase1 = this.e;
                        if(sQLiteDatabase1 != null) {
                            sQLiteDatabase1.close();
                        }
                        throw throwable1;
                    }
                    if(cursor0 != null) {
                        cursor0.close();
                    }
                    sQLiteDatabase2 = this.e;
                    if(sQLiteDatabase2 != null) {
                        sQLiteDatabase2.close();
                    }
                    k.c.a("SQLiteHelper.getAll returning: " + set0.size() + " entries");
                    return set0;
                }
                if(cursor0 != null) {
                    cursor0.close();
                }
                sQLiteDatabase2 = this.e;
                if(sQLiteDatabase2 != null) {
                    sQLiteDatabase2.close();
                }
                k.c.a("SQLiteHelper.getAll returning: " + set0.size() + " entries");
                return set0;
            }
        }

        public boolean c(String s, String s1) {
            SQLiteDatabase sQLiteDatabase0;
            synchronized(this) {
                k.c.a("SQLiteHelper.insert key: " + s + " value: " + s1);
                if(this.d(s)) {
                    k.c.a("SQLiteHelper.insert key already exists - returning false ");
                    return false;
                }
                try {
                    sQLiteDatabase0 = null;
                    sQLiteDatabase0 = this.getWritableDatabase();
                    ContentValues contentValues0 = new ContentValues();
                    contentValues0.put("eventKey", s);
                    contentValues0.put("value", s1);
                    if(sQLiteDatabase0.insert("events", null, contentValues0) != -1L) {
                        k.c.a("SQLiteHelper.insert success ");
                        goto label_16;
                    }
                    goto label_19;
                }
                catch(SQLException sQLException0) {
                    throw new IOException(sQLException0);
                }
                catch(Throwable throwable0) {
                    goto label_24;
                }
            label_16:
                sQLiteDatabase0.close();
                return true;
                try {
                    try {
                    label_19:
                        k.c.a("SQLiteHelper.insert false ");
                    }
                    catch(SQLException sQLException0) {
                        throw new IOException(sQLException0);
                    }
                }
                catch(Throwable throwable0) {
                label_24:
                    if(sQLiteDatabase0 != null) {
                        sQLiteDatabase0.close();
                    }
                    throw throwable0;
                }
                sQLiteDatabase0.close();
                return false;
            }
        }

        public boolean d(String s) {
            synchronized(this) {
                k.c.a("SQLiteHelper.keyExists: key: " + s);
                Cursor cursor0 = null;
                try {
                    SQLiteDatabase sQLiteDatabase0 = this.getWritableDatabase();
                    this.e = sQLiteDatabase0;
                    cursor0 = sQLiteDatabase0.rawQuery("SELECT * FROM events WHERE eventKey= ?", new String[]{s});
                    if(cursor0 != null && cursor0.getCount() != 0) {
                        k.c.a("SQLiteHelper.keyExists: returning true ");
                        cursor0.close();
                        goto label_10;
                    }
                    goto label_18;
                }
                catch(SQLException unused_ex) {
                    throw new IOException();
                }
                catch(Throwable throwable0) {
                    goto label_22;
                }
            label_10:
                cursor0.close();
                SQLiteDatabase sQLiteDatabase1 = this.e;
                if(sQLiteDatabase1 != null) {
                    sQLiteDatabase1.close();
                }
                return true;
                try {
                    try {
                    label_18:
                        k.c.a("SQLiteHelper.keyExists: returning false ");
                    }
                    catch(SQLException unused_ex) {
                        throw new IOException();
                    }
                }
                catch(Throwable throwable0) {
                label_22:
                    if(cursor0 != null) {
                        cursor0.close();
                    }
                    SQLiteDatabase sQLiteDatabase2 = this.e;
                    if(sQLiteDatabase2 != null) {
                        sQLiteDatabase2.close();
                    }
                    throw throwable0;
                }
                if(cursor0 != null) {
                    cursor0.close();
                }
                SQLiteDatabase sQLiteDatabase3 = this.e;
                if(sQLiteDatabase3 != null) {
                    sQLiteDatabase3.close();
                }
                return false;
            }
        }

        public boolean e(String s, String s1) {
            SQLiteDatabase sQLiteDatabase1;
            SQLiteDatabase sQLiteDatabase0;
            synchronized(this) {
                k.c.a("SQLiteHelper.update key: " + s + " value: " + s1);
                if(!this.d(s)) {
                    k.c.a("SQLiteHelper.update: key does not exist - returning false ");
                    return false;
                }
                try {
                    this.e = this.getWritableDatabase();
                    ContentValues contentValues0 = new ContentValues();
                    contentValues0.put("eventKey", s);
                    contentValues0.put("value", s1);
                    if(this.e.replace("events", null, contentValues0) != -1L) {
                        k.c.a("SQLiteHelper.update - success");
                        sQLiteDatabase0 = this.e;
                        if(sQLiteDatabase0 != null) {
                            goto label_17;
                        }
                        return true;
                    }
                    goto label_20;
                }
                catch(SQLException unused_ex) {
                    throw new IOException();
                }
                catch(Throwable throwable0) {
                    goto label_25;
                }
            label_17:
                sQLiteDatabase0.close();
                return true;
                try {
                    try {
                    label_20:
                        k.c.a("SQLiteHelper.update - failed");
                        sQLiteDatabase1 = this.e;
                    }
                    catch(SQLException unused_ex) {
                        throw new IOException();
                    }
                }
                catch(Throwable throwable0) {
                label_25:
                    SQLiteDatabase sQLiteDatabase2 = this.e;
                    if(sQLiteDatabase2 != null) {
                        sQLiteDatabase2.close();
                    }
                    throw throwable0;
                }
                if(sQLiteDatabase1 != null) {
                    sQLiteDatabase1.close();
                }
                return false;
            }
        }

        @Override  // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase0) {
            sQLiteDatabase0.execSQL("CREATE TABLE events (eventKey  TEXT PRIMARY KEY NOT NULL,value TEXT )");
        }

        @Override  // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase0, int v, int v1) {
        }
    }

    private a a;
    private Context b;
    private static final k0 c;

    static {
        k.c = k0.f("k");
    }

    public k(Context context0) {
        this.a = new a(context0);
        this.b = context0;
    }

    @Override  // x2.j
    public Set a() {
        synchronized(this) {
            k.c.a("getAllEvents");
            Set set0 = this.a.b();
            k.c.a("getAllEvents: returning " + set0.size() + " events");
            return set0;
        }
    }

    @Override  // x2.j
    public boolean b(String s) {
        synchronized(this) {
            k.c.a("deleteEvent: key: " + s);
            return this.a.a(s);
        }
    }

    @Override  // x2.j
    public long c() {
        synchronized(this) {
            return p0.M(this.b);
        }
    }

    @Override  // x2.j
    public long d() {
        synchronized(this) {
            return p0.s(this.b);
        }
    }

    @Override  // x2.j
    public boolean e(String s, String s1) {
        synchronized(this) {
            k.c.a("addEvent: key: " + s + " value: " + s1);
            return this.a.c(s, s1);
        }
    }

    @Override  // x2.j
    public boolean f(String s, String s1) {
        synchronized(this) {
            k.c.a("updateEvent: key: " + s + " value: " + s1);
            return this.a.e(s, s1);
        }
    }
}

