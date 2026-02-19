package com.google.android.gms.games.internal.v2.resolution;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.ResultReceiver;
import c2.f1;
import g1.q;

public final class GamesResolutionActivity extends Activity {
    private ResultReceiver a;
    private boolean b;

    private final void a(int v, Intent intent0) {
        Bundle bundle0;
        if(!this.b) {
            this.b = true;
            ResultReceiver resultReceiver0 = this.a;
            if(resultReceiver0 != null) {
                if(intent0 == null) {
                    bundle0 = new Bundle();
                }
                else {
                    Bundle bundle1 = new Bundle();
                    bundle1.putParcelable("resultData", intent0);
                    bundle0 = bundle1;
                }
                resultReceiver0.send(v, bundle0);
            }
        }
    }

    @Override  // android.app.Activity
    protected final void onActivityResult(int v, int v1, Intent intent0) {
        super.onActivityResult(v, v1, intent0);
        if(v == 0) {
            this.a(v1, intent0);
        }
        else {
            f1.c("ResultActivity", "Unexpected request code: " + v);
            this.a(0, intent0);
        }
        this.finish();
    }

    @Override  // android.app.Activity
    protected final void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        if(bundle0 != null) {
            this.a = (ResultReceiver)q.i(((ResultReceiver)bundle0.getParcelable("resultReceiver")));
            return;
        }
        this.a = (ResultReceiver)q.i(((ResultReceiver)this.getIntent().getParcelableExtra("resultReceiver")));
        PendingIntent pendingIntent0 = (PendingIntent)q.i(((PendingIntent)this.getIntent().getParcelableExtra("pendingIntent")));
        try {
            this.startIntentSenderForResult(pendingIntent0.getIntentSender(), 0, null, 0, 0, 0);
        }
        catch(IntentSender.SendIntentException intentSender$SendIntentException0) {
            f1.d("ResultActivity", "Failed to launch", intentSender$SendIntentException0);
            this.a(0, null);
            this.finish();
        }
    }

    @Override  // android.app.Activity
    protected final void onDestroy() {
        if(!this.isChangingConfigurations()) {
            this.a(0, null);
        }
        super.onDestroy();
    }

    @Override  // android.app.Activity
    protected final void onSaveInstanceState(Bundle bundle0) {
        super.onSaveInstanceState(bundle0);
        bundle0.putParcelable("resultReceiver", this.a);
    }
}

