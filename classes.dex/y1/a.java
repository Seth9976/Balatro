package y1;

import android.os.IBinder;
import android.os.IInterface;

public abstract class a implements IInterface {
    private final IBinder a;
    private final String b;

    protected a(IBinder iBinder0, String s) {
        this.a = iBinder0;
        this.b = s;
    }

    @Override  // android.os.IInterface
    public final IBinder asBinder() {
        return this.a;
    }
}

