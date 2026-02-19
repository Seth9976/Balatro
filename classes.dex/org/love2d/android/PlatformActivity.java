package org.love2d.android;

import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.d;
import com.android.billingclient.api.f;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import d0.e;
import g2.h;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import np.dcc.protect.EntryPoint;
import p1.a;
import p1.g;
import p1.i;
import p1.l;
import p1.q;
import p1.r;
import w2.b;

public class PlatformActivity extends GameActivity {
    public interface k {
        void a(boolean arg1);
    }

    private static final String PREFS_NAME = "GameSavePrefs";
    private static final int RC_ACHIEVEMENT_UI = 9678;
    private static final String TAG = "PlatformActivity";
    private a _achievementsClient;
    private com.android.billingclient.api.a _billingClient;
    private g _gamesSignInClient;
    private GoogleSignInAccount _googleSignInAccount;
    private boolean _isAuthenticated;
    private boolean _isBillingClientConnected;
    private i _leaderboardsClient;
    private String _playerId;
    private q _playersClient;
    private SharedPreferences _preferences;
    private Map _productDetailsMap;
    private r _snapshotsClient;

    static {
        EntryPoint.stub(0x1F);
    }

    public PlatformActivity() {
        this._isAuthenticated = false;
        this._playerId = null;
        this._productDetailsMap = new HashMap();
        this._isBillingClientConnected = false;
    }

    public void checkProductOwnership(String s) {
        this.performBillingOperation((boolean z) -> {
            if(z) {
                this._billingClient.e(e.a().b("inapp").a(), (d d0, List list0) -> {
                    boolean z = false;
                    if(d0.b() == 0) {
                        for(Object object0: list0) {
                            if(((Purchase)object0).b().contains(s) && ((Purchase)object0).c() == 1) {
                                z = true;
                                break;
                            }
                        }
                    }
                    else {
                        Log.e("Billing", "Error querying purchases: " + d0.a());
                    }
                    this.nativeOnOwnershipChecked(s, z);
                });
                return;
            }
            this.nativeOnOwnershipChecked(s, false);
        });
    }

    public void ensureBillingConnected(Runnable runnable0) {
        class c implements d0.a {
            final Runnable a;
            final PlatformActivity b;

            c(Runnable runnable0) {
                this.a = runnable0;
                super();
            }

            @Override  // d0.a
            public void a() {
                Log.d("Billing", "Billing client disconnected");
            }

            @Override  // d0.a
            public void b(d d0) {
                if(d0.b() == 0) {
                    Log.d("Billing", "Billing client connected");
                    this.a.run();
                    return;
                }
                Log.e("Billing", "Billing client connection failed: " + d0.b());
            }
        }

        if(this._billingClient.a()) {
            runnable0.run();
            return;
        }
        this._billingClient.f(new c(this, runnable0));
    }

    public static void g(d d0, List list0) {
    }

    private void initializeSingular() {
        b b0 = new b("playstack_85cf9e52", "575ab76240560def16c4caaacc2bf1ac");
        w2.a.i(GameActivity.context, b0);
    }

    public boolean isInternetAvailable() {
        ConnectivityManager connectivityManager0 = (ConnectivityManager)GameActivity.context.getSystemService("connectivity");
        if(connectivityManager0 != null) {
            NetworkInfo networkInfo0 = connectivityManager0.getActiveNetworkInfo();
            return networkInfo0 != null && networkInfo0.isConnected();
        }
        return false;
    }

    // 检测为 Lambda 实现
    private void lambda$checkProductOwnership$7(String s, d d0, List list0) [...]

    // 检测为 Lambda 实现
    private void lambda$checkProductOwnership$8(String s, boolean z) [...]

    // 检测为 Lambda 实现
    private void lambda$launchBillingFlow$5(d d0, List list0) [...]

    // 检测为 Lambda 实现
    private void lambda$launchBillingFlow$6(String s, boolean z) [...]

    // 检测为 Lambda 实现
    private void lambda$performBillingOperation$2(k platformActivity$k0) [...]

    // 检测为 Lambda 实现
    private void lambda$platformInitialize$0(h h0) [...]

    // 检测为 Lambda 实现
    private void lambda$platformInitialize$1(h h0) [...]

    private static void lambda$queryPurchases$3(d d0, List list0) {
    }

    // 检测为 Lambda 实现
    private void lambda$queryPurchases$4(boolean z) [...]

    public void launchBillingFlow(String s) {
        this.performBillingOperation((boolean z) -> if(z) {
            com.android.billingclient.api.g g0 = com.android.billingclient.api.g.a().b(i2.c.x(com.android.billingclient.api.g.b.a().b(s).c("inapp").a())).a();
            this._billingClient.d(g0, (d d0, List list0) -> {
                String s;
                if(d0.b() == 0) {
                    if(!list0.isEmpty()) {
                        f f0 = (f)list0.get(0);
                        com.android.billingclient.api.f.b f$b0 = f0.a();
                        this._productDetailsMap.put(f0.b(), f0);
                        if(f$b0 != null) {
                            Log.d("PurchaseInfo", "User paid: " + f$b0.a() + " in " + f$b0.c());
                        }
                        i2.c c0 = i2.c.x(com.android.billingclient.api.c.b.a().b(f0).a());
                        com.android.billingclient.api.c c1 = com.android.billingclient.api.c.a().b(c0).a();
                        this._billingClient.b(this, c1);
                        return;
                    }
                    s = "No product details found for the given product ID";
                }
                else {
                    s = "Error querying product details: " + d0.a();
                }
                Log.e("Billing", s);
            });
        });
    }

    private byte[] loadFileFromLocalStorage(String s) {
        File file0 = new File(GameActivity.context.getFilesDir(), s);
        if(!file0.exists()) {
            return null;
        }
        try(FileInputStream fileInputStream0 = new FileInputStream(file0)) {
            byte[] arr_b = new byte[((int)file0.length())];
            fileInputStream0.read(arr_b);
            return arr_b;
        }
        catch(IOException iOException0) {
            Log.e("PlatformActivity", "Error loading file: " + iOException0.getMessage());
            return null;
        }
    }

    public void loadSaveGame(String s) {
        class org.love2d.android.PlatformActivity.g implements g2.e {
            final byte[] a;
            final String b;
            final PlatformActivity c;

            org.love2d.android.PlatformActivity.g(byte[] arr_b, String s) {
                this.a = arr_b;
                this.b = s;
                super();
            }

            @Override  // g2.e
            public void d(Exception exception0) {
                Log.e("PlatformActivity", "Error opening snapshot: ", exception0);
                byte[] arr_b = this.a;
                if(arr_b != null) {
                    PlatformActivity.this.nativeOnLoadGameComplete(this.b, 4, "Loaded from local storage (cloud error)", arr_b, null, null);
                    return;
                }
                PlatformActivity.this.nativeOnLoadGameComplete(this.b, 6, "No local file, remote error: " + exception0.getMessage(), null, null, null);
            }
        }


        class org.love2d.android.PlatformActivity.h implements g2.f {
            final long a;
            final byte[] b;
            final String c;
            final PlatformActivity d;

            static {
            }

            org.love2d.android.PlatformActivity.h(long v, byte[] arr_b, String s) {
                this.a = v;
                this.b = arr_b;
                this.c = s;
                super();
            }

            public void a(p1.r.a r$a0) {
                class org.love2d.android.PlatformActivity.h.a implements g2.e {
                    final org.love2d.android.PlatformActivity.h a;

                    @Override  // g2.e
                    public void d(Exception exception0) {
                        Log.e("PlatformActivity", "There was a problem discarding the snapshot: ", exception0);
                    }
                }

                try {
                    if(r$a0.c()) {
                        p1.r.b r$b0 = r$a0.a();
                        String s = r$b0.a();
                        byte[] arr_b = r$b0.d().Z().a0();
                        byte[] arr_b1 = r$b0.b().Z().a0();
                        if(this.a > 0L) {
                            byte[] arr_b2 = this.b;
                            if(arr_b2 != null) {
                                PlatformActivity.this.nativeOnLoadGameComplete(this.c, 3, "Load conflict", arr_b2, arr_b, s);
                                return;
                            }
                        }
                        PlatformActivity.this.nativeOnLoadGameComplete(this.c, 3, "Load conflict", arr_b1, arr_b, s);
                        return;
                    }
                    v1.a a0 = (v1.a)r$a0.b();
                    byte[] arr_b3 = a0.Z().a0();
                    if(this.a > 0L) {
                        byte[] arr_b4 = this.b;
                        if(arr_b4 == null) {
                            PlatformActivity.this.nativeOnLoadGameComplete(this.c, 0, "Loaded from cloud", arr_b3, null, null);
                        }
                        else {
                            PlatformActivity.this.nativeOnLoadGameComplete(this.c, 3, "Local was dirty, cloud exists, conflict", arr_b4, arr_b3, null);
                        }
                    }
                    else {
                        byte[] arr_b5 = this.b;
                        if(arr_b5 == null) {
                            PlatformActivity.this.nativeOnLoadGameComplete(this.c, 0, "Loaded from cloud", arr_b3, null, null);
                        }
                        else {
                            PlatformActivity.this.nativeOnLoadGameComplete(this.c, 3, "Local was not dirty, cloud exists, conflicting anyway", arr_b5, arr_b3, null);
                        }
                    }
                    p.f().e(PlatformActivity.this._snapshotsClient, a0).e(new org.love2d.android.PlatformActivity.h.a(this));
                }
                catch(Exception exception0) {
                    Log.e("PlatformActivity", "Error while reading snapshot: ", exception0);
                    byte[] arr_b6 = this.b;
                    if(arr_b6 != null) {
                        PlatformActivity.this.nativeOnLoadGameComplete(this.c, 1, "Loaded from local storage (cloud read error)", arr_b6, null, null);
                        return;
                    }
                    PlatformActivity.this.nativeOnLoadGameComplete(this.c, 2, "Error reading snapshot: " + exception0.getMessage(), null, null, null);
                }
            }

            @Override  // g2.f
            public void e(Object object0) {
                this.a(((p1.r.a)object0));
            }
        }

        String s1 = this.normalizePath(s);
        byte[] arr_b = this.loadFileFromLocalStorage(s1);
        long v = this._preferences.getLong(s1 + ".dirtycount", 0L);
        if(this._snapshotsClient != null) {
            this.waitForClosedAndOpen(s1, false).g(new org.love2d.android.PlatformActivity.h(this, v, arr_b, s)).e(new org.love2d.android.PlatformActivity.g(this, arr_b, s));
            return;
        }
        if(arr_b != null) {
            this.nativeOnLoadGameComplete(s, 0, "Loaded from local storage (offline)", arr_b, null, null);
            return;
        }
        this.nativeOnLoadGameComplete(s, 6, "SnapshotsClient is null and no local data", null, null, null);
    }

    private native void nativeOnLoadGameComplete(String arg1, int arg2, String arg3, byte[] arg4, byte[] arg5, String arg6) {
    }

    private native void nativeOnOwnershipChecked(String arg1, boolean arg2) {
    }

    private native void nativeOnPurchaseFinished(String arg1, boolean arg2) {
    }

    private native void nativeOnSaveGameComplete(String arg1, int arg2, String arg3, byte[] arg4, byte[] arg5, String arg6) {
    }

    private String normalizePath(String s) {
        return s.replace('\\', '-').replace('/', '-');
    }

    @Override  // android.app.Activity
    protected void onActivityResult(int v, int v1, Intent intent0) {
        super.onActivityResult(v, v1, intent0);
        Log.d("PlatformActivity", "Request Code: " + v);
        Log.d("PlatformActivity", "Result Code: " + v1);
        if(intent0 == null) {
            Log.d("PlatformActivity", "Intent Data: null");
        }
        else {
            Log.d("PlatformActivity", "Intent Data: " + intent0.toString());
            Bundle bundle0 = intent0.getExtras();
            if(bundle0 != null) {
                for(Object object0: bundle0.keySet()) {
                    Log.d("PlatformActivity", "Extra - " + ((String)object0) + ": " + bundle0.get(((String)object0)));
                }
            }
        }
    }

    @Override  // org.love2d.android.GameActivity
    protected native void onCreate(Bundle arg1) {
        class org.love2d.android.PlatformActivity.b implements d0.d {
            final PlatformActivity a;

            @Override  // d0.d
            public void a(d d0, List list0) {
                if(d0.b() == 0 && list0 != null) {
                    for(Object object0: list0) {
                        Purchase purchase0 = (Purchase)object0;
                        for(Object object1: purchase0.b()) {
                            f f0 = (f)PlatformActivity.this._productDetailsMap.get(((String)object1));
                            if(f0 != null) {
                                com.android.billingclient.api.f.b f$b0 = f0.a();
                                if(f$b0 != null) {
                                    double f1 = ((double)f$b0.b()) / 1000000.0;
                                    String s = f$b0.c();
                                    Log.d("PurchaseInfo", "User paid: " + f1 + " in " + s);
                                    w2.a.l(s, f1, purchase0);
                                }
                            }
                            PlatformActivity.this.nativeOnPurchaseFinished(((String)object1), true);
                        }
                    }
                    return;
                }
                if(d0.b() == 1) {
                    Log.w("PlatformActivity", "User canceled billing flow");
                    return;
                }
                Log.e("PlatformActivity", "Error during billing billing flow. Response code: " + d0.b());
            }
        }

    }

    @Override  // org.love2d.android.GameActivity
    protected void onDestroy() {
        super.onDestroy();
        System.exit(0);
    }

    @Override  // org.love2d.android.GameActivity
    protected void onNewIntent(Intent intent0) {
    }

    @Override  // org.love2d.android.GameActivity
    protected void onPause() {
        super.onPause();
    }

    @Override  // org.love2d.android.GameActivity
    public void onResume() {
        super.onResume();
    }

    @Override  // org.libsdl.app.SDLActivity
    protected void onStart() {
        super.onStart();
    }

    public void performBillingOperation(k platformActivity$k0) {
        this.ensureBillingConnected(() -> {
            boolean z;
            if(this._billingClient.a()) {
                z = true;
            }
            else {
                Log.e("Billing", "Billing operation failed: Client not connected");
                z = false;
            }
            platformActivity$k0.a(z);
        });
    }

    public void platformInitialize() {
        if(!this._isAuthenticated) {
            this._gamesSignInClient.a().c((h h0) -> {
                boolean z = h0.q() && ((p1.b)h0.n()).a();
                this._isAuthenticated = z;
                if(z) {
                    this._playersClient.a().c((h h0) -> {
                        if(h0.q()) {
                            this._playerId = ((l)h0.n()).X();
                            Log.w("PlatformActivity", "AUTHENTICATED! Player ID is " + this._playerId);
                            return;
                        }
                        Log.w("PlatformActivity", "Could not retrieve player ID!");
                        this._isAuthenticated = false;
                    });
                    return;
                }
                Log.w("PlatformActivity", "Player did or could not authenticate.");
            });
        }
    }

    public boolean platformIsSignedIn() {
        return com.google.android.gms.auth.api.signin.a.b(this) != null;
    }

    public void queryPurchases() {
        this.performBillingOperation((boolean z) -> if(z) {
            this._billingClient.e(e.a().b("inapp").a(), new org.love2d.android.i());
        });
    }

    public void resolveSaveGame(String s, byte[] arr_b, String s1) {
        class org.love2d.android.PlatformActivity.i implements g2.e {
            final PlatformActivity a;

            @Override  // g2.e
            public void d(Exception exception0) {
                Log.e("PlatformActivity", "Error opening snapshot: ", exception0);
            }
        }


        class j implements g2.f {
            final String a;
            final byte[] b;
            final String c;
            final String d;
            final PlatformActivity e;

            static {
            }

            j(String s, byte[] arr_b, String s1, String s2) {
                this.a = s;
                this.b = arr_b;
                this.c = s1;
                this.d = s2;
                super();
            }

            public void a(p1.r.a r$a0) {
                class org.love2d.android.PlatformActivity.j.a implements g2.a {
                    final p1.r.a a;
                    final j b;

                    static {
                    }

                    org.love2d.android.PlatformActivity.j.a(p1.r.a r$a0) {
                        this.a = r$a0;
                        super();
                    }

                    @Override  // g2.a
                    public Object a(h h0) {
                        return this.b(h0);
                    }

                    public p1.r.a b(h h0) {
                        if(h0.q()) {
                            if(((p1.r.a)h0.n()).c()) {
                                this.a.a().d().Z().a0();
                                Log.w("PlatformActivity", "Conflict occurred during conflict resolution for file " + j.this.c);
                                return (p1.r.a)h0.n();
                            }
                            Log.i("PlatformActivity", "Conflict resolved for file " + j.this.c);
                            SharedPreferences.Editor sharedPreferences$Editor0 = PlatformActivity.this._preferences.edit();
                            sharedPreferences$Editor0.putLong(j.this.d, 0L);
                            sharedPreferences$Editor0.apply();
                        }
                        return (p1.r.a)h0.n();
                    }
                }


                class org.love2d.android.PlatformActivity.j.b implements g2.d {
                    final j a;

                    @Override  // g2.d
                    public void a(h h0) {
                        if(h0.q()) {
                            SharedPreferences.Editor sharedPreferences$Editor0 = PlatformActivity.this._preferences.edit();
                            sharedPreferences$Editor0.putLong(j.this.d, 0L);
                            sharedPreferences$Editor0.apply();
                            return;
                        }
                        Exception exception0 = h0.m();
                        Log.d("PlatformActivity", "Failed to save saved game data: " + (exception0 == null ? "UNKNOWN" : exception0.getMessage()));
                    }
                }

                try {
                    if(r$a0.c()) {
                        p1.r.b r$b0 = r$a0.a();
                        String s = r$b0.a();
                        Log.i("PlatformActivity", "Resolving conflict id " + s + ", resolution started with conflict id " + this.a);
                        v1.b b0 = r$b0.c();
                        b0.G(this.b);
                        v1.g g0 = new v1.g.a().a();
                        String s1 = r$b0.d().t().f0();
                        PlatformActivity.this._snapshotsClient.c(s, s1, g0, b0).i(new org.love2d.android.PlatformActivity.j.a(this, r$a0));
                        return;
                    }
                    v1.a a0 = (v1.a)r$a0.b();
                    a0.Z().G(this.b);
                    v1.g g1 = new v1.g.a().b(this.c).a();
                    p.f().c(PlatformActivity.this._snapshotsClient, a0, g1).c(new org.love2d.android.PlatformActivity.j.b(this));
                }
                catch(Exception exception0) {
                    Log.e("PlatformActivity", "Error while reading snapshot: ", exception0);
                }
            }

            @Override  // g2.f
            public void e(Object object0) {
                this.a(((p1.r.a)object0));
            }
        }

        String s2 = this.normalizePath(s);
        if(this.saveFileToLocalStorage(s2, arr_b)) {
            SharedPreferences.Editor sharedPreferences$Editor0 = this._preferences.edit();
            sharedPreferences$Editor0.putLong(s2 + ".dirtycount", this._preferences.getLong(s2 + ".dirtycount", 0L) + 1L);
            sharedPreferences$Editor0.apply();
        }
        if(this._snapshotsClient != null) {
            this.waitForClosedAndOpen(s2, true).g(new j(this, s1, arr_b, s, s2 + ".dirtycount")).e(new org.love2d.android.PlatformActivity.i(this));
        }
    }

    private boolean saveFileToLocalStorage(String s, byte[] arr_b) {
        File file0 = new File(GameActivity.context.getFilesDir(), s);
        try(FileOutputStream fileOutputStream0 = new FileOutputStream(file0)) {
            fileOutputStream0.write(arr_b);
            return true;
        }
        catch(IOException iOException0) {
            Log.e("PlatformActivity", "Error saving file: " + iOException0.getMessage());
            return false;
        }
    }

    public void showAchievements() {
        class org.love2d.android.PlatformActivity.a implements g2.f {
            final PlatformActivity a;

            public void a(Intent intent0) {
                PlatformActivity.this.startActivityForResult(intent0, 9678);
            }

            @Override  // g2.f
            public void e(Object object0) {
                this.a(((Intent)object0));
            }
        }

        a a0 = this._achievementsClient;
        if(a0 != null) {
            a0.b().g(new org.love2d.android.PlatformActivity.a(this));
        }
    }

    public void singularEventNoArgs(String s) {
        w2.a.e(s);
    }

    public void singularEventWithArgs(String s, String[] arr_s, String[] arr_s1, boolean[] arr_z, long[] arr_v) {
        HashMap hashMap0 = new HashMap();
        int v1 = 0;
        int v2 = 0;
        int v3 = 0;
        for(int v = 0; v < arr_s.length; ++v) {
            String s1 = arr_s[v];
            if(v1 < arr_s1.length) {
                hashMap0.put(s1, arr_s1[v1]);
                ++v1;
            }
            else if(v2 < arr_z.length) {
                hashMap0.put(s1, Boolean.valueOf(arr_z[v2]));
                ++v2;
            }
            else if(v3 < arr_v.length) {
                hashMap0.put(s1, ((long)arr_v[v3]));
                ++v3;
            }
        }
        w2.a.f(s, new Object[]{hashMap0});
    }

    public void unlockAchievement(String s) {
        a a0 = this._achievementsClient;
        if(a0 != null) {
            a0.a(s);
        }
    }

    private h waitForClosedAndOpen(String s, boolean z) {
        class org.love2d.android.PlatformActivity.d implements g2.a {
            final String a;
            final boolean b;
            final PlatformActivity c;

            org.love2d.android.PlatformActivity.d(String s, boolean z) {
                this.a = s;
                this.b = z;
                super();
            }

            @Override  // g2.a
            public Object a(h h0) {
                return this.b(h0);
            }

            public h b(h h0) {
                class org.love2d.android.PlatformActivity.d.a implements g2.a {
                    final org.love2d.android.PlatformActivity.d a;

                    @Override  // g2.a
                    public Object a(h h0) {
                        return this.b(h0);
                    }

                    public p1.r.a b(h h0) {
                        if(!h0.q()) {
                            if(!(h0.m() instanceof d1.b) || ((d1.b)h0.m()).b() != 26570) {
                                Log.e("PlatformActivity", "Task exception: " + h0.m().getMessage());
                            }
                            throw new org.love2d.android.q("Failed to open snapshot", h0.m(), org.love2d.android.q.a.f);
                        }
                        return (p1.r.a)h0.n();
                    }
                }

                if(!h0.q()) {
                    throw new org.love2d.android.q("Failed to wait for snapshot to close", h0.m(), org.love2d.android.q.a.e);
                }
                return p.f().i(PlatformActivity.this._snapshotsClient, this.a, this.b).i(new org.love2d.android.PlatformActivity.d.a(this));
            }
        }

        return p.f().o(s).k(new org.love2d.android.PlatformActivity.d(this, s, z));
    }

    public void writeSaveGame(String s, byte[] arr_b, String s1) {
        class org.love2d.android.PlatformActivity.e implements g2.e {
            final String a;
            final byte[] b;
            final PlatformActivity c;

            org.love2d.android.PlatformActivity.e(String s, byte[] arr_b) {
                this.a = s;
                this.b = arr_b;
                super();
            }

            @Override  // g2.e
            public void d(Exception exception0) {
                Log.e("PlatformActivity", "Error opening snapshot: ", exception0);
                PlatformActivity.this.nativeOnSaveGameComplete(this.a, 2, "Error opening snapshot: " + exception0.getMessage(), this.b, null, null);
            }
        }


        class org.love2d.android.PlatformActivity.f implements g2.f {
            final String a;
            final byte[] b;
            final String c;
            final String d;
            final PlatformActivity e;

            static {
            }

            org.love2d.android.PlatformActivity.f(String s, byte[] arr_b, String s1, String s2) {
                this.a = s;
                this.b = arr_b;
                this.c = s1;
                this.d = s2;
                super();
            }

            public void a(p1.r.a r$a0) {
                class org.love2d.android.PlatformActivity.f.a implements g2.d {
                    final org.love2d.android.PlatformActivity.f a;

                    @Override  // g2.d
                    public void a(h h0) {
                        if(h0.q()) {
                            SharedPreferences.Editor sharedPreferences$Editor0 = PlatformActivity.this._preferences.edit();
                            sharedPreferences$Editor0.putLong(org.love2d.android.PlatformActivity.f.this.d, 0L);
                            sharedPreferences$Editor0.apply();
                            PlatformActivity.this.nativeOnSaveGameComplete(org.love2d.android.PlatformActivity.f.this.a, 0, "", org.love2d.android.PlatformActivity.f.this.b, null, null);
                            return;
                        }
                        Exception exception0 = h0.m();
                        String s = "UNKNOWN";
                        PlatformActivity.this.nativeOnSaveGameComplete(org.love2d.android.PlatformActivity.f.this.a, 2, "Failed to save: " + (exception0 == null ? "UNKNOWN" : exception0.getMessage()), org.love2d.android.PlatformActivity.f.this.b, null, null);
                        StringBuilder stringBuilder0 = new StringBuilder();
                        stringBuilder0.append("Failed to save saved game data: ");
                        if(exception0 != null) {
                            s = exception0.getMessage();
                        }
                        stringBuilder0.append(s);
                        Log.d("PlatformActivity", stringBuilder0.toString());
                    }
                }

                try {
                    if(r$a0.c()) {
                        p1.r.b r$b0 = r$a0.a();
                        byte[] arr_b = r$b0.b().Z().a0();
                        byte[] arr_b1 = r$b0.d().Z().a0();
                        PlatformActivity.this.nativeOnSaveGameComplete(this.a, 3, "Save conflict", arr_b, arr_b1, r$b0.a());
                        return;
                    }
                    v1.a a0 = (v1.a)r$a0.b();
                    a0.Z().G(this.b);
                    v1.g g0 = new v1.g.a().b(this.c).a();
                    p.f().c(PlatformActivity.this._snapshotsClient, a0, g0).c(new org.love2d.android.PlatformActivity.f.a(this));
                }
                catch(Exception exception0) {
                    Log.e("PlatformActivity", "Error while reading snapshot: ", exception0);
                    PlatformActivity.this.nativeOnSaveGameComplete(this.a, 2, "Error writing snapshot: " + exception0.getMessage(), this.b, null, null);
                }
            }

            @Override  // g2.f
            public void e(Object object0) {
                this.a(((p1.r.a)object0));
            }
        }

        String s2 = this.normalizePath(s);
        if(this.saveFileToLocalStorage(s2, arr_b)) {
            SharedPreferences.Editor sharedPreferences$Editor0 = this._preferences.edit();
            sharedPreferences$Editor0.putLong(s2 + ".dirtycount", this._preferences.getLong(s2 + ".dirtycount", 0L) + 1L);
            sharedPreferences$Editor0.apply();
        }
        if(this._snapshotsClient != null) {
            this.waitForClosedAndOpen(s2, true).g(new org.love2d.android.PlatformActivity.f(this, s, arr_b, s1, s2 + ".dirtycount")).e(new org.love2d.android.PlatformActivity.e(this, s, arr_b));
            return;
        }
        this.nativeOnSaveGameComplete(s, 4, "SnapshotsClient is null", arr_b, null, null);
    }
}

