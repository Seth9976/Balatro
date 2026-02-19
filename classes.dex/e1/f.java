package e1;

import android.app.Activity;
import android.content.Intent;
import com.google.android.gms.common.api.internal.LifecycleCallback;

public interface f {
    void b(String arg1, LifecycleCallback arg2);

    LifecycleCallback e(String arg1, Class arg2);

    Activity f();

    void startActivityForResult(Intent arg1, int arg2);
}

