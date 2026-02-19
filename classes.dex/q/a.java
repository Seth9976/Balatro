package q;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;

public abstract class a extends BaseAdapter implements Filterable, q.b.a {
    class q.a.a extends ContentObserver {
        final a a;

        q.a.a() {
            super(new Handler());
        }

        @Override  // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override  // android.database.ContentObserver
        public void onChange(boolean z) {
            a.this.i();
        }
    }

    class b extends DataSetObserver {
        final a a;

        @Override  // android.database.DataSetObserver
        public void onChanged() {
            a.this.a = true;
            a.this.notifyDataSetChanged();
        }

        @Override  // android.database.DataSetObserver
        public void onInvalidated() {
            a.this.a = false;
            a.this.notifyDataSetInvalidated();
        }
    }

    protected boolean a;
    protected boolean b;
    protected Cursor c;
    protected Context d;
    protected int e;
    protected q.a.a f;
    protected DataSetObserver g;
    protected q.b h;

    public a(Context context0, Cursor cursor0, boolean z) {
        this.f(context0, cursor0, (z ? 1 : 2));
    }

    @Override  // q.b$a
    public abstract CharSequence a(Cursor arg1);

    @Override  // q.b$a
    public void b(Cursor cursor0) {
        Cursor cursor1 = this.j(cursor0);
        if(cursor1 != null) {
            cursor1.close();
        }
    }

    @Override  // q.b$a
    public Cursor c() {
        return this.c;
    }

    public abstract void e(View arg1, Context arg2, Cursor arg3);

    void f(Context context0, Cursor cursor0, int v) {
        b a$b0;
        boolean z = false;
        if((v & 1) == 1) {
            v |= 2;
            this.b = true;
        }
        else {
            this.b = false;
        }
        if(cursor0 != null) {
            z = true;
        }
        this.c = cursor0;
        this.a = z;
        this.d = context0;
        this.e = z ? cursor0.getColumnIndexOrThrow("_id") : -1;
        if((v & 2) == 2) {
            this.f = new q.a.a(this);
            a$b0 = new b(this);
        }
        else {
            a$b0 = null;
            this.f = null;
        }
        this.g = a$b0;
        if(z) {
            q.a.a a$a0 = this.f;
            if(a$a0 != null) {
                cursor0.registerContentObserver(a$a0);
            }
            DataSetObserver dataSetObserver0 = this.g;
            if(dataSetObserver0 != null) {
                cursor0.registerDataSetObserver(dataSetObserver0);
            }
        }
    }

    public abstract View g(Context arg1, Cursor arg2, ViewGroup arg3);

    @Override  // android.widget.Adapter
    public int getCount() {
        if(this.a) {
            return this.c == null ? 0 : this.c.getCount();
        }
        return 0;
    }

    @Override  // android.widget.BaseAdapter
    public View getDropDownView(int v, View view0, ViewGroup viewGroup0) {
        if(this.a) {
            this.c.moveToPosition(v);
            if(view0 == null) {
                view0 = this.g(this.d, this.c, viewGroup0);
            }
            this.e(view0, this.d, this.c);
            return view0;
        }
        return null;
    }

    @Override  // android.widget.Filterable
    public Filter getFilter() {
        if(this.h == null) {
            this.h = new q.b(this);
        }
        return this.h;
    }

    @Override  // android.widget.Adapter
    public Object getItem(int v) {
        if(this.a) {
            Cursor cursor0 = this.c;
            if(cursor0 != null) {
                cursor0.moveToPosition(v);
                return this.c;
            }
        }
        return null;
    }

    // 去混淆评级： 低(20)
    @Override  // android.widget.Adapter
    public long getItemId(int v) {
        return !this.a || (this.c == null || !this.c.moveToPosition(v)) ? 0L : this.c.getLong(this.e);
    }

    @Override  // android.widget.Adapter
    public View getView(int v, View view0, ViewGroup viewGroup0) {
        if(!this.a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if(!this.c.moveToPosition(v)) {
            throw new IllegalStateException("couldn\'t move cursor to position " + v);
        }
        if(view0 == null) {
            view0 = this.h(this.d, this.c, viewGroup0);
        }
        this.e(view0, this.d, this.c);
        return view0;
    }

    public abstract View h(Context arg1, Cursor arg2, ViewGroup arg3);

    protected void i() {
        if(this.b && (this.c != null && !this.c.isClosed())) {
            this.a = this.c.requery();
        }
    }

    public Cursor j(Cursor cursor0) {
        Cursor cursor1 = this.c;
        if(cursor0 == cursor1) {
            return null;
        }
        if(cursor1 != null) {
            q.a.a a$a0 = this.f;
            if(a$a0 != null) {
                cursor1.unregisterContentObserver(a$a0);
            }
            DataSetObserver dataSetObserver0 = this.g;
            if(dataSetObserver0 != null) {
                cursor1.unregisterDataSetObserver(dataSetObserver0);
            }
        }
        this.c = cursor0;
        if(cursor0 != null) {
            q.a.a a$a1 = this.f;
            if(a$a1 != null) {
                cursor0.registerContentObserver(a$a1);
            }
            DataSetObserver dataSetObserver1 = this.g;
            if(dataSetObserver1 != null) {
                cursor0.registerDataSetObserver(dataSetObserver1);
            }
            this.e = cursor0.getColumnIndexOrThrow("_id");
            this.a = true;
            this.notifyDataSetChanged();
            return cursor1;
        }
        this.e = -1;
        this.a = false;
        this.notifyDataSetInvalidated();
        return cursor1;
    }
}

