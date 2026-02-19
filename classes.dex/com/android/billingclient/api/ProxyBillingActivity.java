package com.android.billingclient.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.google.android.gms.internal.play_billing.a0;

public class ProxyBillingActivity extends Activity {
    private ResultReceiver a;
    private ResultReceiver b;
    private boolean c;
    private boolean d;

    private Intent a(String s) {
        Intent intent0 = new Intent("com.android.vending.billing.ALTERNATIVE_BILLING");
        intent0.setPackage("com.playstack.balatro.android");
        intent0.putExtra("ALTERNATIVE_BILLING_USER_CHOICE_DATA", s);
        return intent0;
    }

    private Intent b() {
        Intent intent0 = new Intent("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED");
        intent0.setPackage("com.playstack.balatro.android");
        return intent0;
    }

    @Override  // android.app.Activity
    protected void onActivityResult(int v, int v1, Intent intent0) {
        Intent intent1;
        super.onActivityResult(v, v1, intent0);
        Bundle bundle0 = null;
        if(v == 100 || v == 110) {
            int v3 = a0.d(intent0, "ProxyBillingActivity").b();
            if(v1 != -1) {
                a0.i("ProxyBillingActivity", "Activity finished with resultCode " + v1 + " and billing\'s responseCode: " + v3);
            }
            else if(v3 != 0) {
                a0.i("ProxyBillingActivity", "Activity finished with resultCode " + -1 + " and billing\'s responseCode: " + v3);
            }
            else {
                v3 = 0;
            }
            ResultReceiver resultReceiver1 = this.a;
            if(resultReceiver1 == null) {
                if(intent0 == null) {
                    intent1 = this.b();
                }
                else {
                    if(intent0.getExtras() == null) {
                        intent1 = this.b();
                        a0.i("ProxyBillingActivity", "Got null bundle!");
                        intent1.putExtra("RESPONSE_CODE", 6);
                        intent1.putExtra("DEBUG_MESSAGE", "An internal error occurred.");
                        a d$a0 = d.c();
                        d$a0.c(6);
                        d$a0.b("An internal error occurred.");
                        intent1.putExtra("FAILURE_LOGGING_PAYLOAD", q.a(22, 2, d$a0.a()).e());
                    }
                    else {
                        String s = intent0.getExtras().getString("ALTERNATIVE_BILLING_USER_CHOICE_DATA");
                        if(s == null) {
                            intent1 = this.b();
                            intent1.putExtras(intent0.getExtras());
                        }
                        else {
                            intent1 = this.a(s);
                        }
                    }
                    intent1.putExtra("INTENT_SOURCE", "LAUNCH_BILLING_FLOW");
                }
                if(v == 110) {
                    intent1.putExtra("IS_FIRST_PARTY_PURCHASE", true);
                }
                this.sendBroadcast(intent1);
            }
            else {
                if(intent0 != null) {
                    bundle0 = intent0.getExtras();
                }
                resultReceiver1.send(v3, bundle0);
            }
        }
        else if(v == 101) {
            int v2 = a0.a(intent0, "ProxyBillingActivity");
            ResultReceiver resultReceiver0 = this.b;
            if(resultReceiver0 != null) {
                if(intent0 != null) {
                    bundle0 = intent0.getExtras();
                }
                resultReceiver0.send(v2, bundle0);
            }
        }
        else {
            a0.i("ProxyBillingActivity", "Got onActivityResult with wrong requestCode: " + v + "; skipping...");
        }
        this.c = false;
        this.finish();
    }

    @Override  // android.app.Activity
    protected void onCreate(Bundle bundle0) {
        int v;
        PendingIntent pendingIntent0;
        super.onCreate(bundle0);
        if(bundle0 == null) {
            a0.h("ProxyBillingActivity", "Launching Play Store billing flow");
            if(this.getIntent().hasExtra("BUY_INTENT")) {
                pendingIntent0 = (PendingIntent)this.getIntent().getParcelableExtra("BUY_INTENT");
                if(!this.getIntent().hasExtra("IS_FLOW_FROM_FIRST_PARTY_CLIENT") || !this.getIntent().getBooleanExtra("IS_FLOW_FROM_FIRST_PARTY_CLIENT", false)) {
                    v = 100;
                }
                else {
                    this.d = true;
                    v = 110;
                }
            }
            else if(this.getIntent().hasExtra("SUBS_MANAGEMENT_INTENT")) {
                pendingIntent0 = (PendingIntent)this.getIntent().getParcelableExtra("SUBS_MANAGEMENT_INTENT");
                this.a = (ResultReceiver)this.getIntent().getParcelableExtra("result_receiver");
                v = 100;
            }
            else if(this.getIntent().hasExtra("IN_APP_MESSAGE_INTENT")) {
                pendingIntent0 = (PendingIntent)this.getIntent().getParcelableExtra("IN_APP_MESSAGE_INTENT");
                this.b = (ResultReceiver)this.getIntent().getParcelableExtra("in_app_message_result_receiver");
                v = 101;
            }
            else {
                v = 100;
                pendingIntent0 = null;
            }
            try {
                this.c = true;
                this.startIntentSenderForResult(pendingIntent0.getIntentSender(), v, new Intent(), 0, 0, 0);
            }
            catch(IntentSender.SendIntentException intentSender$SendIntentException0) {
                a0.j("ProxyBillingActivity", "Got exception while trying to start a purchase flow.", intentSender$SendIntentException0);
                ResultReceiver resultReceiver0 = this.a;
                if(resultReceiver0 == null) {
                    ResultReceiver resultReceiver1 = this.b;
                    if(resultReceiver1 == null) {
                        Intent intent0 = this.b();
                        if(this.d) {
                            intent0.putExtra("IS_FIRST_PARTY_PURCHASE", true);
                        }
                        intent0.putExtra("RESPONSE_CODE", 6);
                        intent0.putExtra("DEBUG_MESSAGE", "An internal error occurred.");
                        this.sendBroadcast(intent0);
                    }
                    else {
                        resultReceiver1.send(0, null);
                    }
                }
                else {
                    resultReceiver0.send(6, null);
                }
                this.c = false;
                this.finish();
            }
            return;
        }
        a0.h("ProxyBillingActivity", "Launching Play Store billing flow from savedInstanceState");
        this.c = bundle0.getBoolean("send_cancelled_broadcast_if_finished", false);
        if(bundle0.containsKey("result_receiver")) {
            this.a = (ResultReceiver)bundle0.getParcelable("result_receiver");
        }
        else if(bundle0.containsKey("in_app_message_result_receiver")) {
            this.b = (ResultReceiver)bundle0.getParcelable("in_app_message_result_receiver");
        }
        this.d = bundle0.getBoolean("IS_FLOW_FROM_FIRST_PARTY_CLIENT", false);
    }

    @Override  // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if(this.isFinishing() && this.c) {
            Intent intent0 = this.b();
            intent0.putExtra("RESPONSE_CODE", 1);
            intent0.putExtra("DEBUG_MESSAGE", "Billing dialog closed.");
            this.sendBroadcast(intent0);
        }
    }

    @Override  // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle0) {
        super.onSaveInstanceState(bundle0);
        ResultReceiver resultReceiver0 = this.a;
        if(resultReceiver0 != null) {
            bundle0.putParcelable("result_receiver", resultReceiver0);
        }
        ResultReceiver resultReceiver1 = this.b;
        if(resultReceiver1 != null) {
            bundle0.putParcelable("in_app_message_result_receiver", resultReceiver1);
        }
        bundle0.putBoolean("send_cancelled_broadcast_if_finished", this.c);
        bundle0.putBoolean("IS_FLOW_FROM_FIRST_PARTY_CLIENT", this.d);
    }
}

