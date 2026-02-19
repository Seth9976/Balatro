package a2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.a;

public abstract class f extends a {
    // 去混淆评级： 中等(60)
    public static Intent e(Context context0, BroadcastReceiver broadcastReceiver0, IntentFilter intentFilter0) {
        return context0.registerReceiver(broadcastReceiver0, intentFilter0, 2);
    }
}

