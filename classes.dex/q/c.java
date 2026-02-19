package q;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class c extends a {
    private int i;
    private int j;
    private LayoutInflater k;

    public c(Context context0, int v, Cursor cursor0, boolean z) {
        super(context0, cursor0, z);
        this.j = v;
        this.i = v;
        this.k = (LayoutInflater)context0.getSystemService("layout_inflater");
    }

    @Override  // q.a
    public View g(Context context0, Cursor cursor0, ViewGroup viewGroup0) {
        return this.k.inflate(this.j, viewGroup0, false);
    }

    @Override  // q.a
    public View h(Context context0, Cursor cursor0, ViewGroup viewGroup0) {
        return this.k.inflate(this.i, viewGroup0, false);
    }
}

