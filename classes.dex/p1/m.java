package p1;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.b;
import f1.a;

public class m extends a {
    public m(DataHolder dataHolder0) {
        super(dataHolder0);
    }

    @Override  // f1.b
    public final Object get(int v) {
        return this.n(v);
    }

    public l n(int v) {
        return new b(this.e, v, null);
    }
}

