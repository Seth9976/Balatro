package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

public class d extends BaseAdapter {
    e a;
    private int b;
    private boolean c;
    private final boolean d;
    private final LayoutInflater e;
    private final int f;

    public d(e e0, LayoutInflater layoutInflater0, boolean z, int v) {
        this.b = -1;
        this.d = z;
        this.e = layoutInflater0;
        this.a = e0;
        this.f = v;
        this.a();
    }

    void a() {
        f f0 = this.a.t();
        if(f0 != null) {
            ArrayList arrayList0 = this.a.v();
            int v = arrayList0.size();
            for(int v1 = 0; v1 < v; ++v1) {
                if(((f)arrayList0.get(v1)) == f0) {
                    this.b = v1;
                    return;
                }
            }
        }
        this.b = -1;
    }

    public e b() {
        return this.a;
    }

    public f c(int v) {
        ArrayList arrayList0 = this.d ? this.a.v() : this.a.A();
        if(this.b >= 0 && v >= this.b) {
            ++v;
        }
        return (f)arrayList0.get(v);
    }

    public void d(boolean z) {
        this.c = z;
    }

    @Override  // android.widget.Adapter
    public int getCount() {
        ArrayList arrayList0 = this.d ? this.a.v() : this.a.A();
        int v = this.b;
        int v1 = arrayList0.size();
        return v >= 0 ? v1 - 1 : v1;
    }

    @Override  // android.widget.Adapter
    public Object getItem(int v) {
        return this.c(v);
    }

    @Override  // android.widget.Adapter
    public long getItemId(int v) {
        return (long)v;
    }

    @Override  // android.widget.Adapter
    public View getView(int v, View view0, ViewGroup viewGroup0) {
        if(view0 == null) {
            view0 = this.e.inflate(this.f, viewGroup0, false);
        }
        int v1 = this.c(v).getGroupId();
        int v2 = v - 1 < 0 ? v1 : this.c(v - 1).getGroupId();
        ((ListMenuItemView)view0).setGroupDividerEnabled(this.a.B() && v1 != v2);
        if(this.c) {
            ((ListMenuItemView)view0).setForceShowIcon(true);
        }
        ((a)view0).d(this.c(v), 0);
        return view0;
    }

    @Override  // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        this.a();
        super.notifyDataSetChanged();
    }
}

