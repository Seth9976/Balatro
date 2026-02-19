package kotlinx.coroutines.android;

import android.os.Looper;
import java.util.List;
import r3.v;
import s3.a;
import s3.c;
import t3.g;

public final class AndroidDispatcherFactory implements g {
    @Override  // t3.g
    public v createDispatcher(List list0) {
        Looper looper0 = Looper.getMainLooper();
        if(looper0 == null) {
            throw new IllegalStateException("The main looper is not available");
        }
        return new a(c.a(looper0, true), null, 2, null);
    }

    @Override  // t3.g
    public int getLoadPriority() {
        return 0x3FFFFFFF;
    }

    @Override  // t3.g
    public String hintOnError() {
        return "For tests Dispatchers.setMain from kotlinx-coroutines-test module can be used";
    }
}

