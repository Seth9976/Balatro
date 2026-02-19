package com.google.android.gms.auth.api.signin.internal;

import a1.p;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import androidx.fragment.app.j;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.api.Status;

public class SignInHubActivity extends j {
    private int A;
    private Intent B;
    private static boolean C;
    private boolean x;
    private SignInConfiguration y;
    private boolean z;

    static {
    }

    public SignInHubActivity() {
        this.x = false;
    }

    private final void Z() {
        this.N().c(0, null, new a(this, null));
        SignInHubActivity.C = false;
    }

    private final void a0(int v) {
        Status status0 = new Status(v);
        Intent intent0 = new Intent();
        intent0.putExtra("googleSignInStatus", status0);
        this.setResult(0, intent0);
        this.finish();
        SignInHubActivity.C = false;
    }

    private final void b0(String s) {
        Intent intent0 = new Intent(s);
        intent0.setPackage((s.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN") ? "com.google.android.gms" : "com.playstack.balatro.android"));
        intent0.putExtra("config", this.y);
        try {
            this.startActivityForResult(intent0, 0xA002);
        }
        catch(ActivityNotFoundException unused_ex) {
            this.x = true;
            Log.w("AuthSignInClient", "Could not launch sign in Intent. Google Play Service is probably being updated...");
            this.a0(17);
        }
    }

    @Override  // android.app.Activity
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent0) {
        return true;
    }

    @Override  // androidx.activity.ComponentActivity
    protected final void onActivityResult(int v, int v1, Intent intent0) {
        if(!this.x) {
            this.setResult(0);
            if(v == 0xA002) {
                if(intent0 != null) {
                    SignInAccount signInAccount0 = (SignInAccount)intent0.getParcelableExtra("signInAccount");
                    if(signInAccount0 != null && signInAccount0.j0() != null) {
                        GoogleSignInAccount googleSignInAccount0 = signInAccount0.j0();
                        p p0 = p.b(this);
                        GoogleSignInOptions googleSignInOptions0 = this.y.j0();
                        googleSignInAccount0.getClass();
                        p0.d(googleSignInOptions0, googleSignInAccount0);
                        intent0.removeExtra("signInAccount");
                        intent0.putExtra("googleSignInAccount", googleSignInAccount0);
                        this.z = true;
                        this.A = v1;
                        this.B = intent0;
                        this.Z();
                        return;
                    }
                    if(intent0.hasExtra("errorCode")) {
                        int v2 = intent0.getIntExtra("errorCode", 8);
                        if(v2 == 13) {
                            v2 = 0x30D5;
                        }
                        this.a0(v2);
                        return;
                    }
                }
                this.a0(8);
            }
        }
    }

    @Override  // androidx.fragment.app.j
    protected final void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        this.finish();
        Intent intent0 = this.getIntent();
        String s = intent0.getAction();
        s.getClass();
        if("com.google.android.gms.auth.NO_IMPL".equals(s)) {
            this.a0(12500);
            return;
        }
        if(!s.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN") && !s.equals("com.google.android.gms.auth.APPAUTH_SIGN_IN")) {
            Log.e("AuthSignInClient", "Unknown action: " + intent0.getAction());
            this.finish();
            return;
        }
        Bundle bundle1 = intent0.getBundleExtra("config");
        bundle1.getClass();
        SignInConfiguration signInConfiguration0 = (SignInConfiguration)bundle1.getParcelable("config");
        if(signInConfiguration0 == null) {
            Log.e("AuthSignInClient", "Activity started with invalid configuration.");
            this.setResult(0);
            this.finish();
            return;
        }
        this.y = signInConfiguration0;
        if(bundle0 == null) {
            if(SignInHubActivity.C) {
                this.setResult(0);
                this.a0(0x30D6);
                return;
            }
            SignInHubActivity.C = true;
            this.b0(s);
            return;
        }
        boolean z = bundle0.getBoolean("signingInGoogleApiClients");
        this.z = z;
        if(z) {
            this.A = bundle0.getInt("signInResultCode");
            Intent intent1 = (Intent)bundle0.getParcelable("signInResultData");
            intent1.getClass();
            this.B = intent1;
            this.Z();
        }
    }

    @Override  // androidx.fragment.app.j
    public final void onDestroy() {
        super.onDestroy();
        SignInHubActivity.C = false;
    }

    @Override  // androidx.activity.ComponentActivity
    protected final void onSaveInstanceState(Bundle bundle0) {
        super.onSaveInstanceState(bundle0);
        bundle0.putBoolean("signingInGoogleApiClients", this.z);
        if(this.z) {
            bundle0.putInt("signInResultCode", this.A);
            bundle0.putParcelable("signInResultData", this.B);
        }
    }
}

