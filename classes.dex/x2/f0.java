package x2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import java.io.IOException;
import jeb.synthetic.TWR;

public class f0 implements a0 {
    static class a extends SQLiteOpenHelper implements BaseColumns {
        public a(Context context0) {
            super(context0, "singular-1.db", null, 1);
        }

        @Override  // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase0) {
            sQLiteDatabase0.execSQL("CREATE TABLE events (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,value TEXT )");
        }

        @Override  // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase0, int v, int v1) {
        }
    }

    static class b {
        private final a a;

        b(a f0$a0) {
            this.a = f0$a0;
        }

        private long a(SQLiteDatabase sQLiteDatabase0) {
            long v;
            Cursor cursor0;
            try {
                try {
                    cursor0 = null;
                    cursor0 = sQLiteDatabase0.rawQuery("SELECT COUNT(_id) FROM events", null);
                    cursor0.moveToFirst();
                    v = cursor0.getLong(0);
                    f0.b.b("getCount() = %d", new Object[]{v});
                }
                catch(SQLException sQLException0) {
                    throw new IOException(sQLException0);
                }
            }
            catch(Throwable throwable0) {
                TWR.safeClose$NT(cursor0, throwable0);
                throw throwable0;
            }
            cursor0.close();
            return v;
        }

        String b() {
            long v;
            Throwable throwable1;
            SQLException sQLException1;
            Cursor cursor0;
            SQLiteDatabase sQLiteDatabase0;
            String s = null;
            try {
                sQLiteDatabase0 = this.a.getReadableDatabase();
            }
            catch(SQLException sQLException0) {
                cursor0 = null;
                sQLException1 = sQLException0;
                sQLiteDatabase0 = null;
                throw new IOException(sQLException1);
            }
            catch(Throwable throwable0) {
                cursor0 = null;
                throwable1 = throwable0;
                sQLiteDatabase0 = null;
                goto label_32;
            }
            try {
                v = this.c(sQLiteDatabase0);
                cursor0 = null;
                cursor0 = sQLiteDatabase0.query("events", new String[]{"value"}, "_id = ?", new String[]{String.valueOf(v)}, null, null, null);
            }
            catch(SQLException sQLException2) {
                cursor0 = null;
                sQLException1 = sQLException2;
                throw new IOException(sQLException1);
            }
            catch(Throwable throwable2) {
                throwable1 = throwable2;
                goto label_32;
            }
            try {
                try {
                    cursor0.moveToFirst();
                    if(cursor0.getCount() != 0) {
                        s = cursor0.getString(0);
                    }
                    f0.b.b("getHead() _id = %d, value = %s", new Object[]{v, s});
                    goto label_37;
                }
                catch(SQLException sQLException1) {
                }
                throw new IOException(sQLException1);
            }
            catch(Throwable throwable1) {
            }
        label_32:
            if(cursor0 != null) {
                cursor0.close();
            }
            if(sQLiteDatabase0 != null) {
                sQLiteDatabase0.close();
            }
            throw throwable1;
        label_37:
            cursor0.close();
            sQLiteDatabase0.close();
            return s;
        }

        private long c(SQLiteDatabase sQLiteDatabase0) {
            long v;
            Cursor cursor0;
            try {
                try {
                    cursor0 = null;
                    cursor0 = sQLiteDatabase0.rawQuery("SELECT MIN(_id) FROM events", null);
                    cursor0.moveToFirst();
                    v = cursor0.getLong(0);
                    f0.b.b("getMinId() id = %d", new Object[]{v});
                }
                catch(SQLException sQLException0) {
                    throw new IOException(sQLException0);
                }
            }
            catch(Throwable throwable0) {
                TWR.safeClose$NT(cursor0, throwable0);
                throw throwable0;
            }
            cursor0.close();
            return v;
        }

        long d(String s) {
            long v;
            SQLException sQLException1;
            SQLiteDatabase sQLiteDatabase0;
            ContentValues contentValues0 = new ContentValues();
            contentValues0.put("value", s);
            try {
                sQLiteDatabase0 = this.a.getWritableDatabase();
            }
            catch(SQLException sQLException0) {
                sQLiteDatabase0 = null;
                sQLException1 = sQLException0;
                throw new IOException(sQLException1);
            }
            try {
                try {
                    v = sQLiteDatabase0.insert("events", null, contentValues0);
                    f0.b.a("insert() row = " + v);
                    long v1 = this.a(sQLiteDatabase0);
                    if(v1 > 10000L) {
                        f0.b.b("Pruning Queue; current size = %d; max size = %d", new Object[]{v1, 10000});
                        this.f(sQLiteDatabase0);
                    }
                    goto label_20;
                }
                catch(SQLException sQLException1) {
                }
                throw new IOException(sQLException1);
            }
            catch(Throwable throwable0) {
                TWR.safeClose$NT(sQLiteDatabase0, throwable0);
                throw throwable0;
            }
        label_20:
            sQLiteDatabase0.close();
            return v;
        }

        String e() {
            try(SQLiteDatabase sQLiteDatabase0 = this.a.getWritableDatabase()) {
                return this.f(sQLiteDatabase0);
            }
        }

        private String f(SQLiteDatabase sQLiteDatabase0) {
            String s;
            Cursor cursor1;
            String[] arr_s;
            long v;
            Cursor cursor0 = null;
            try {
                v = this.c(sQLiteDatabase0);
                arr_s = new String[]{String.valueOf(v)};
                cursor1 = sQLiteDatabase0.query("events", new String[]{"value"}, "_id = ?", arr_s, null, null, null);
                goto label_7;
            }
            catch(SQLException sQLException0) {
                throw new IOException(sQLException0);
                try {
                label_7:
                    cursor1.moveToFirst();
                    if(cursor1.getCount() != 0) {
                        s = cursor1.getString(cursor1.getColumnIndex("value"));
                        sQLiteDatabase0.delete("events", "_id = ?", arr_s);
                        f0.b.b("removeHead() _id = %d", new Object[]{v});
                        goto label_22;
                    }
                    goto label_24;
                }
                catch(SQLException sQLException0) {
                }
                catch(Throwable throwable0) {
                    goto label_20;
                }
                cursor0 = cursor1;
                try {
                    throw new IOException(sQLException0);
                }
                catch(Throwable throwable0) {
                    goto label_17;
                }
            }
            catch(Throwable throwable0) {
            label_17:
                TWR.safeClose$NT(cursor0, throwable0);
                throw throwable0;
            }
        label_20:
            TWR.safeClose$NT(cursor1, throwable0);
            throw throwable0;
        label_22:
            cursor1.close();
            return s;
        label_24:
            cursor1.close();
            return null;
        }
    }

    private b a;
    private static final k0 b;

    static {
        f0.b = k0.f("f0");
    }

    public f0(Context context0) {
        this.a = new b(new a(context0.getApplicationContext()));
    }

    @Override  // x2.a0
    public void a(String s) {
        synchronized(this) {
            if(this.a.d(s) != -1L) {
                return;
            }
        }
        throw new IOException("Failed to add element = " + s);
    }

    @Override  // x2.a0
    public String b() {
        synchronized(this) {
            return this.a.b();
        }
    }

    @Override  // x2.a0
    public void remove() {
        synchronized(this) {
            this.a.e();
        }
    }
}

