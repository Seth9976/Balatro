package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.util.Log;
import c1.a;
import c1.i;
import com.google.android.gms.common.api.internal.c;
import g1.q;

public class GoogleApiActivity extends Activity implements DialogInterface.OnCancelListener {
    protected int a;

    public GoogleApiActivity() {
        this.a = 0;
    }

    public static Intent a(Context context0, PendingIntent pendingIntent0, int v, boolean z) {
        Intent intent0 = new Intent(context0, GoogleApiActivity.class);
        intent0.putExtra("pending_intent", pendingIntent0);
        intent0.putExtra("failing_client_id", v);
        intent0.putExtra("notify_manager", z);
        return intent0;
    }

    private final void b() {
        Bundle bundle0 = this.getIntent().getExtras();
        if(bundle0 == null) {
            Log.e("GoogleApiActivity", "Activity started without extras");
            this.finish();
            return;
        }
        PendingIntent pendingIntent0 = (PendingIntent)bundle0.get("pending_intent");
        Integer integer0 = (Integer)bundle0.get("error_code");
        if(pendingIntent0 == null && integer0 == null) {
            Log.e("GoogleApiActivity", "Activity started without resolution");
            this.finish();
            return;
        }
        if(pendingIntent0 != null) {
            try {
                this.startIntentSenderForResult(pendingIntent0.getIntentSender(), 1, null, 0, 0, 0);
                this.a = 1;
            }
            catch(ActivityNotFoundException activityNotFoundException0) {
                if(bundle0.getBoolean("notify_manager", true)) {
                    c.u(this).D(new a(22, null), this.getIntent().getIntExtra("failing_client_id", -1));
                }
                else {
                    Log.e("GoogleApiActivity", "Activity not found while launching " + pendingIntent0.toString() + ".", activityNotFoundException0);
                }
                this.a = 1;
                this.finish();
            }
            catch(IntentSender.SendIntentException intentSender$SendIntentException0) {
                Log.e("GoogleApiActivity", "Failed to launch pendingIntent", intentSender$SendIntentException0);
                this.finish();
            }
            return;
        }
        i.l().m(this, ((int)(((Integer)q.i(integer0)))), 2, this);
        this.a = 1;
    }

    @Override  // android.app.Activity
    protected final void onActivityResult(int v, int v1, Intent intent0) {
        super.onActivityResult(v, v1, intent0);
        if(v == 1) {
            boolean z = this.getIntent().getBooleanExtra("notify_manager", true);
            this.a = 0;
            this.setResult(v1, intent0);
            if(z) {
                c c0 = c.u(this);
                switch(v1) {
                    case -1: {
                        c0.E();
                        break;
                    }
                    case 0: {
                        c0.D(new a(13, null), this.getIntent().getIntExtra("failing_client_id", -1));
                    }
                }
            }
        }
        else if(v == 2) {
            this.a = 0;
            this.setResult(v1, intent0);
        }
        this.finish();
    }

    @Override  // android.content.DialogInterface$OnCancelListener
    public final void onCancel(DialogInterface dialogInterface0) {
        this.a = 0;
        this.setResult(0);
        this.finish();
    }

    @Override  // android.app.Activity
    protected final void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        this.finish();
        if(bundle0 != null) {
            this.a = bundle0.getInt("resolution");
        }
        if(this.a != 1) {
            this.b();
        }
    }

    @Override  // android.app.Activity
    protected final void onSaveInstanceState(Bundle bundle0) {
        bundle0.putInt("resolution", this.a);
        super.onSaveInstanceState(bundle0);
    }
}

