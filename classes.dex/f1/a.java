package f1;

import com.google.android.gms.common.data.DataHolder;
import java.util.Iterator;

public abstract class a implements b {
    protected final DataHolder e;

    protected a(DataHolder dataHolder0) {
        this.e = dataHolder0;
    }

    @Override
    public final void close() {
        this.e();
    }

    @Override  // d1.i
    public void e() {
        DataHolder dataHolder0 = this.e;
        if(dataHolder0 != null) {
            dataHolder0.close();
        }
    }

    @Override  // f1.b
    public int getCount() {
        return this.e == null ? 0 : this.e.getCount();
    }

    @Override
    public Iterator iterator() {
        return new c(this);
    }
}

