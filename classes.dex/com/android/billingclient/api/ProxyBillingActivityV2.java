package com.android.billingclient.api;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import androidx.activity.ComponentActivity;
import androidx.activity.result.a;
import androidx.activity.result.c;
import androidx.activity.result.e.b;
import b.d;
import com.google.android.gms.internal.play_billing.a0;

public class ProxyBillingActivityV2 extends ComponentActivity {
    private c s;
    private c t;
    private ResultReceiver u;
    private ResultReceiver v;

    // 检测为 Lambda 实现
    final void H(a a0) [...]

    // 检测为 Lambda 实现
    final void I(a a0) [...]

    @Override  // androidx.activity.ComponentActivity
    protected final void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        this.s = this.F(new d(), (a a0) -> {
            Intent intent0 = a0.o();
            int v = a0.d(intent0, "ProxyBillingActivityV2").b();
            ResultReceiver resultReceiver0 = this.u;
            if(resultReceiver0 != null) {
                resultReceiver0.send(v, (intent0 == null ? null : intent0.getExtras()));
            }
            if(a0.s() != -1 || v != 0) {
                a0.i("ProxyBillingActivityV2", "Alternative billing only dialog finished with resultCode " + a0.s() + " and billing\'s responseCode: " + v);
            }
            this.finish();
        });
        this.t = this.F(new d(), (a a0) -> {
            Intent intent0 = a0.o();
            int v = a0.d(intent0, "ProxyBillingActivityV2").b();
            ResultReceiver resultReceiver0 = this.v;
            if(resultReceiver0 != null) {
                resultReceiver0.send(v, (intent0 == null ? null : intent0.getExtras()));
            }
            if(a0.s() != -1 || v != 0) {
                a0.i("ProxyBillingActivityV2", String.format("External offer dialog finished with resultCode: %s and billing\'s responseCode: %s", a0.s(), v));
            }
            this.finish();
        });
        if(bundle0 == null) {
            a0.h("ProxyBillingActivityV2", "Launching Play Store billing dialog");
            if(this.getIntent().hasExtra("ALTERNATIVE_BILLING_ONLY_DIALOG_INTENT")) {
                PendingIntent pendingIntent0 = (PendingIntent)this.getIntent().getParcelableExtra("ALTERNATIVE_BILLING_ONLY_DIALOG_INTENT");
                this.u = (ResultReceiver)this.getIntent().getParcelableExtra("alternative_billing_only_dialog_result_receiver");
                this.s.a(new b(pendingIntent0).a());
                return;
            }
            if(this.getIntent().hasExtra("external_payment_dialog_pending_intent")) {
                PendingIntent pendingIntent1 = (PendingIntent)this.getIntent().getParcelableExtra("external_payment_dialog_pending_intent");
                this.v = (ResultReceiver)this.getIntent().getParcelableExtra("external_payment_dialog_result_receiver");
                this.t.a(new b(pendingIntent1).a());
            }
        }
        else {
            if(bundle0.containsKey("alternative_billing_only_dialog_result_receiver")) {
                this.u = (ResultReceiver)bundle0.getParcelable("alternative_billing_only_dialog_result_receiver");
                return;
            }
            if(bundle0.containsKey("external_payment_dialog_result_receiver")) {
                this.v = (ResultReceiver)bundle0.getParcelable("external_payment_dialog_result_receiver");
            }
        }
    }

    @Override  // androidx.activity.ComponentActivity
    protected final void onSaveInstanceState(Bundle bundle0) {
        super.onSaveInstanceState(bundle0);
        ResultReceiver resultReceiver0 = this.u;
        if(resultReceiver0 != null) {
            bundle0.putParcelable("alternative_billing_only_dialog_result_receiver", resultReceiver0);
        }
        ResultReceiver resultReceiver1 = this.v;
        if(resultReceiver1 != null) {
            bundle0.putParcelable("external_payment_dialog_result_receiver", resultReceiver1);
        }
    }
}

