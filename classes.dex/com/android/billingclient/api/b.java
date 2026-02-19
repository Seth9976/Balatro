package com.android.billingclient.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.internal.play_billing.a0;
import com.google.android.gms.internal.play_billing.e6;
import com.google.android.gms.internal.play_billing.g5;
import com.google.android.gms.internal.play_billing.h5;
import com.google.android.gms.internal.play_billing.j;
import com.google.android.gms.internal.play_billing.n4;
import com.google.android.gms.internal.play_billing.o;
import com.google.android.gms.internal.play_billing.r4;
import d0.c;
import d0.d;
import d0.m;
import d0.q;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;

class b extends a {
    private boolean A;
    private ExecutorService B;
    private volatile int a;
    private final String b;
    private final Handler c;
    private volatile g0 d;
    private Context e;
    private r f;
    private volatile e6 g;
    private volatile p h;
    private boolean i;
    private boolean j;
    private int k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean y;
    private e z;

    b(String s, Context context0, r r0, ExecutorService executorService0) {
        this.a = 0;
        this.c = new Handler(Looper.getMainLooper());
        this.k = 0;
        this.b = "7.0.0";
        this.e = context0.getApplicationContext();
        g5 g50 = h5.E();
        g50.q("7.0.0");
        g50.p("com.playstack.balatro.android");
        this.f = new t(this.e, ((h5)g50.j()));
        this.e.getPackageName();
    }

    b(String s, e e0, Context context0, d d0, m m0, r r0, ExecutorService executorService0) {
        this.a = 0;
        this.c = new Handler(Looper.getMainLooper());
        this.k = 0;
        this.b = "7.0.0";
        this.g(context0, d0, e0, null, "7.0.0", null);
    }

    b(String s, e e0, Context context0, q q0, r r0, ExecutorService executorService0) {
        this.a = 0;
        this.c = new Handler(Looper.getMainLooper());
        this.k = 0;
        this.b = "7.0.0";
        this.e = context0.getApplicationContext();
        g5 g50 = h5.E();
        g50.q("7.0.0");
        g50.p("com.playstack.balatro.android");
        this.f = new t(this.e, ((h5)g50.j()));
        a0.i("BillingClient", "Billing client should have a valid listener but the provided is null.");
        this.d = new g0(this.e, null, null, null, null, this.f);
        this.z = e0;
        this.e.getPackageName();
    }

    // 检测为 Lambda 实现
    final void B(c c0) [...]

    static d0.t D(b b0, String s, int v) {
        Purchase purchase0;
        Bundle bundle1;
        a0.h("BillingClient", "Querying owned items, item type: " + s);
        ArrayList arrayList0 = new ArrayList();
        Bundle bundle0 = a0.c(b0.n, b0.v, b0.z.a(), b0.z.b(), b0.b);
        String s1 = null;
        do {
            try {
                bundle1 = b0.n ? b0.g.x((b0.v ? 19 : 9), "com.playstack.balatro.android", s, s1, bundle0) : b0.g.u(3, "com.playstack.balatro.android", s, s1);
            }
            catch(Exception exception0) {
                b0.M(com.android.billingclient.api.q.a(52, 9, s.m));
                a0.j("BillingClient", "Got exception trying to get purchasesm try to reconnect", exception0);
                return new d0.t(s.m, null);
            }
            d0 d00 = e0.a(bundle1, "BillingClient", "getPurchase()");
            com.android.billingclient.api.d d0 = d00.a();
            if(d0 != s.l) {
                b0.M(com.android.billingclient.api.q.a(d00.b(), 9, d0));
                return new d0.t(d0, null);
            }
            ArrayList arrayList1 = bundle1.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
            ArrayList arrayList2 = bundle1.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
            ArrayList arrayList3 = bundle1.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
            boolean z = false;
            for(int v1 = 0; v1 < arrayList2.size(); ++v1) {
                String s2 = (String)arrayList2.get(v1);
                String s3 = (String)arrayList3.get(v1);
                a0.h("BillingClient", "Sku is owned: " + ((String)arrayList1.get(v1)));
                try {
                    purchase0 = new Purchase(s2, s3);
                }
                catch(JSONException jSONException0) {
                    a0.j("BillingClient", "Got an exception trying to decode the purchase!", jSONException0);
                    b0.M(com.android.billingclient.api.q.a(51, 9, s.j));
                    return new d0.t(s.j, null);
                }
                if(TextUtils.isEmpty(purchase0.d())) {
                    a0.i("BillingClient", "BUG: empty/null token!");
                    z = true;
                }
                arrayList0.add(purchase0);
            }
            if(z) {
                b0.M(com.android.billingclient.api.q.a(26, 9, s.j));
            }
            s1 = bundle1.getString("INAPP_CONTINUATION_TOKEN");
            a0.h("BillingClient", "Continuation token: " + s1);
        }
        while(!TextUtils.isEmpty(s1));
        return new d0.t(s.l, arrayList0);
    }

    static void E(b b0, int v, int v1, com.android.billingclient.api.d d0) {
        b0.M(com.android.billingclient.api.q.a(v, v1, d0));
    }

    static void F(b b0, int v) {
        b0.N(com.android.billingclient.api.q.c(6));
    }

    private final Handler G() {
        return Looper.myLooper() == null ? this.c : new Handler(Looper.myLooper());
    }

    private final com.android.billingclient.api.d H(com.android.billingclient.api.d d0) {
        if(Thread.interrupted()) {
            return d0;
        }
        h0 h00 = () -> {
            if(this.d.d() != null) {
                this.d.d().a(d0, null);
                return;
            }
            a0.i("BillingClient", "No valid listener is set in BroadcastManager");
        };
        this.c.post(h00);
        return d0;
    }

    private final com.android.billingclient.api.d I() {
        return this.a == 0 || this.a == 3 ? s.m : s.j;
    }

    // 去混淆评级： 低(30)
    private final String J(g g0) {
        return "com.playstack.balatro.android";
    }

    private static String K() [...] // 潜在的解密器

    private final Future L(Callable callable0, long v, Runnable runnable0, Handler handler0) {
        Future future0;
        if(this.B == null) {
            l l0 = new l(this);
            this.B = Executors.newFixedThreadPool(a0.a, l0);
        }
        try {
            future0 = this.B.submit(callable0);
        }
        catch(Exception exception0) {
            a0.j("BillingClient", "Async task throws exception!", exception0);
            return null;
        }
        handler0.postDelayed(new d0.d0(future0, runnable0), ((long)(((double)v) * 0.95)));
        return future0;
    }

    private final void M(n4 n40) {
        this.f.b(n40, this.k);
    }

    private final void N(r4 r40) {
        this.f.a(r40, this.k);
    }

    private final void O(String s, c c0) {
        int v;
        com.android.billingclient.api.d d0;
        if(!this.a()) {
            d0 = s.m;
            v = 2;
        }
        else if(TextUtils.isEmpty(s)) {
            a0.i("BillingClient", "Please provide a valid product type.");
            d0 = s.g;
            v = 50;
        }
        else if(this.L(new com.android.billingclient.api.m(this, s, c0), 30000L, () -> {
            this.M(com.android.billingclient.api.q.a(24, 9, s.n));
            c0.a(s.n, j.v());
        }, this.G()) == null) {
            d0 = this.I();
            v = 25;
        }
        else {
            return;
        }
        this.M(com.android.billingclient.api.q.a(v, 9, d0));
        c0.a(d0, j.v());
    }

    // 去混淆评级： 低(20)
    private final boolean P() {
        return this.v && this.z.b();
    }

    static Context Q(b b0) {
        return b0.e;
    }

    // 检测为 Lambda 实现
    final Bundle R(int v, String s, String s1, com.android.billingclient.api.c c0, Bundle bundle0) [...]

    // 检测为 Lambda 实现
    final Bundle S(String s, String s1) [...]

    final Object Y(g g0, d0.b b0) {
        f f0;
        ArrayList arrayList5;
        int v9;
        int v8;
        Bundle bundle2;
        String s1;
        ArrayList arrayList0 = new ArrayList();
        String s = g0.c();
        j j0 = g0.b();
        int v = j0.size();
        int v1 = 0;
    alab1:
        while(true) {
            if(v1 >= v) {
                s1 = "";
                v9 = 0;
                break;
            }
            ArrayList arrayList1 = new ArrayList(j0.subList(v1, (v1 + 20 <= v ? v1 + 20 : v)));
            ArrayList arrayList2 = new ArrayList();
            int v2 = arrayList1.size();
            for(int v3 = 0; v3 < v2; ++v3) {
                arrayList2.add(((com.android.billingclient.api.g.b)arrayList1.get(v3)).b());
            }
            Bundle bundle0 = new Bundle();
            bundle0.putStringArrayList("ITEM_ID_LIST", arrayList2);
            bundle0.putString("playBillingLibraryVersion", this.b);
            try {
                e6 e60 = this.g;
                int v4 = this.w ? 20 : 17;
                boolean z = this.P();
                this.J(g0);
                this.J(g0);
                this.J(g0);
                Bundle bundle1 = new Bundle();
                bundle1.putString("playBillingLibraryVersion", this.b);
                bundle1.putBoolean("enablePendingPurchases", true);
                bundle1.putString("SKU_DETAILS_RESPONSE_FORMAT", "PRODUCT_DETAILS");
                if(z) {
                    bundle1.putBoolean("enablePendingPurchaseForSubscriptions", true);
                }
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                int v5 = arrayList1.size();
                int v7 = 0;
                boolean z1 = false;
                for(int v6 = 0; v6 < v5; ++v6) {
                    com.android.billingclient.api.g.b g$b0 = (com.android.billingclient.api.g.b)arrayList1.get(v6);
                    arrayList3.add(null);
                    v7 |= !TextUtils.isEmpty(null);
                    if(g$b0.c().equals("first_party")) {
                        com.google.android.gms.internal.play_billing.b.c(null, "Serialized DocId is required for constructing ExtraParams to query ProductDetails for all first party products.");
                        arrayList4.add(null);
                        z1 = true;
                    }
                }
                if(v7 != 0) {
                    bundle1.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList3);
                }
                if(!arrayList4.isEmpty()) {
                    bundle1.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList4);
                }
                if(z1 && !TextUtils.isEmpty(null)) {
                    bundle1.putString("accountName", null);
                }
                s1 = "Item is unavailable for purchase.";
                bundle2 = e60.q(v4, "com.playstack.balatro.android", s, bundle0, bundle1);
            }
            catch(Exception exception0) {
                a0.j("BillingClient", "queryProductDetailsAsync got a remote exception (try to reconnect).", exception0);
                this.M(com.android.billingclient.api.q.a(43, 7, s.j));
                s1 = "An internal error occurred.";
                v9 = 6;
                break alab1;
            }
            if(bundle2 == null) {
                a0.i("BillingClient", "queryProductDetailsAsync got empty product details response.");
                v8 = 44;
            }
            else {
                if(!bundle2.containsKey("DETAILS_LIST")) {
                    v9 = a0.b(bundle2, "BillingClient");
                    s1 = a0.e(bundle2, "BillingClient");
                    if(v9 != 0) {
                        a0.i("BillingClient", "getSkuDetails() failed for queryProductDetailsAsync. Response code: " + v9);
                        this.M(com.android.billingclient.api.q.a(23, 7, s.a(v9, s1)));
                        break;
                    }
                    a0.i("BillingClient", "getSkuDetails() returned a bundle with neither an error nor a product detail list for queryProductDetailsAsync.");
                    this.M(com.android.billingclient.api.q.a(45, 7, s.a(6, s1)));
                    v9 = 6;
                    break;
                }
                arrayList5 = bundle2.getStringArrayList("DETAILS_LIST");
                if(arrayList5 == null) {
                    a0.i("BillingClient", "queryProductDetailsAsync got null response list");
                    v8 = 46;
                }
                else {
                    goto label_81;
                }
            }
            this.M(com.android.billingclient.api.q.a(v8, 7, s.C));
            v9 = 4;
            break;
        label_81:
            for(int v10 = 0; v10 < arrayList5.size(); ++v10) {
                String s2 = (String)arrayList5.get(v10);
                try {
                    f0 = new f(s2);
                }
                catch(JSONException jSONException0) {
                    a0.j("BillingClient", "Got a JSON exception trying to decode ProductDetails. \n Exception: ", jSONException0);
                    s1 = "Error trying to decode SkuDetails.";
                    this.M(com.android.billingclient.api.q.a(0x2F, 7, s.a(6, "Error trying to decode SkuDetails.")));
                    v9 = 6;
                    break alab1;
                }
                a0.h("BillingClient", "Got product details: " + f0.toString());
                arrayList0.add(f0);
            }
            v1 += 20;
        }
        b0.a(s.a(v9, s1), arrayList0);
        return null;
    }

    static Future Z(b b0, Callable callable0, long v, Runnable runnable0, Handler handler0) {
        return b0.L(callable0, 30000L, runnable0, handler0);
    }

    @Override  // com.android.billingclient.api.a
    public final boolean a() {
        return this.a == 2 && this.g != null && this.h != null;
    }

    @Override  // com.android.billingclient.api.a
    public final com.android.billingclient.api.d b(Activity activity0, com.android.billingclient.api.c c0) {
        int v2;
        Future future0;
        int v1;
        boolean z5;
        String s3;
        String s2;
        if(this.d != null && this.d.d() != null) {
            if(!this.a()) {
                this.M(com.android.billingclient.api.q.a(2, 2, s.m));
                this.H(s.m);
                return s.m;
            }
            ArrayList arrayList0 = c0.g();
            List list0 = c0.h();
            h.d.a(o.a(arrayList0, null));
            com.android.billingclient.api.c.b c$b0 = (com.android.billingclient.api.c.b)o.a(list0, null);
            String s = c$b0.b().b();
            String s1 = c$b0.b().c();
            if(s1.equals("subs") && !this.i) {
                a0.i("BillingClient", "Current client doesn\'t support subscriptions.");
                this.M(com.android.billingclient.api.q.a(9, 2, s.o));
                this.H(s.o);
                return s.o;
            }
            if(c0.q() && !this.l) {
                a0.i("BillingClient", "Current client doesn\'t support extra params for buy intent.");
                this.M(com.android.billingclient.api.q.a(18, 2, s.h));
                this.H(s.h);
                return s.h;
            }
            if(arrayList0.size() > 1 && !this.s) {
                a0.i("BillingClient", "Current client doesn\'t support multi-item purchases.");
                this.M(com.android.billingclient.api.q.a(19, 2, s.t));
                this.H(s.t);
                return s.t;
            }
            if(!list0.isEmpty() && !this.t) {
                a0.i("BillingClient", "Current client doesn\'t support purchases with ProductDetails.");
                this.M(com.android.billingclient.api.q.a(20, 2, s.v));
                this.H(s.v);
                return s.v;
            }
            if(this.l) {
                boolean z = this.n;
                boolean z1 = this.v;
                boolean z2 = this.z.a();
                boolean z3 = this.z.b();
                boolean z4 = this.A;
                Bundle bundle0 = new Bundle();
                bundle0.putString("playBillingLibraryVersion", this.b);
                if(c0.b() != 0) {
                    bundle0.putInt("prorationMode", c0.b());
                }
                if(!TextUtils.isEmpty(c0.c())) {
                    bundle0.putString("accountId", c0.c());
                }
                if(!TextUtils.isEmpty(c0.d())) {
                    bundle0.putString("obfuscatedProfileId", c0.d());
                }
                if(c0.p()) {
                    bundle0.putBoolean("isOfferPersonalizedByDeveloper", true);
                }
                if(!TextUtils.isEmpty(null)) {
                    bundle0.putStringArrayList("skusToReplace", new ArrayList(Arrays.asList(new String[]{0})));
                }
                if(!TextUtils.isEmpty(c0.e())) {
                    bundle0.putString("oldSkuPurchaseToken", c0.e());
                }
                if(!TextUtils.isEmpty(null)) {
                    bundle0.putString("oldSkuPurchaseId", null);
                }
                if(!TextUtils.isEmpty(c0.f())) {
                    bundle0.putString("originalExternalTransactionId", c0.f());
                }
                if(!TextUtils.isEmpty(null)) {
                    bundle0.putString("paymentsPurchaseParams", null);
                }
                if(z && z2) {
                    bundle0.putBoolean("enablePendingPurchases", true);
                }
                if(z1 && z3) {
                    bundle0.putBoolean("enablePendingPurchaseForSubscriptions", true);
                }
                if(z4) {
                    bundle0.putBoolean("enableAlternativeBilling", true);
                }
                if(arrayList0.isEmpty()) {
                    ArrayList arrayList4 = new ArrayList(list0.size() - 1);
                    ArrayList arrayList5 = new ArrayList(list0.size() - 1);
                    ArrayList arrayList6 = new ArrayList();
                    ArrayList arrayList7 = new ArrayList();
                    s3 = s1;
                    ArrayList arrayList8 = new ArrayList();
                    s2 = s;
                    for(int v = 0; v < list0.size(); ++v) {
                        com.android.billingclient.api.c.b c$b1 = (com.android.billingclient.api.c.b)list0.get(v);
                        f f0 = c$b1.b();
                        if(!f0.f().isEmpty()) {
                            arrayList6.add(f0.f());
                        }
                        arrayList7.add(c$b1.c());
                        if(!TextUtils.isEmpty(f0.g())) {
                            arrayList8.add(f0.g());
                        }
                        if(v > 0) {
                            arrayList4.add(((com.android.billingclient.api.c.b)list0.get(v)).b().b());
                            arrayList5.add(((com.android.billingclient.api.c.b)list0.get(v)).b().c());
                        }
                    }
                    bundle0.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList7);
                    if(!arrayList6.isEmpty()) {
                        bundle0.putStringArrayList("skuDetailsTokens", arrayList6);
                    }
                    if(!arrayList8.isEmpty()) {
                        bundle0.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList8);
                    }
                    if(!arrayList4.isEmpty()) {
                        bundle0.putStringArrayList("additionalSkus", arrayList4);
                        bundle0.putStringArrayList("additionalSkuTypes", arrayList5);
                    }
                }
                else {
                    ArrayList arrayList1 = new ArrayList();
                    new ArrayList();
                    new ArrayList();
                    new ArrayList();
                    new ArrayList();
                    Iterator iterator0 = arrayList0.iterator();
                    if(!iterator0.hasNext()) {
                        if(!arrayList1.isEmpty()) {
                            bundle0.putStringArrayList("skuDetailsTokens", arrayList1);
                        }
                        if(arrayList0.size() > 1) {
                            ArrayList arrayList2 = new ArrayList(arrayList0.size() - 1);
                            ArrayList arrayList3 = new ArrayList(arrayList0.size() - 1);
                            if(1 >= arrayList0.size()) {
                                bundle0.putStringArrayList("additionalSkus", arrayList2);
                                bundle0.putStringArrayList("additionalSkuTypes", arrayList3);
                                s2 = s;
                                s3 = s1;
                                goto label_117;
                            }
                            h.d.a(arrayList0.get(1));
                            throw null;
                        }
                        s2 = s;
                        s3 = s1;
                        goto label_117;
                    }
                    Object object0 = iterator0.next();
                    h.d.a(object0);
                    throw null;
                }
            label_117:
                if(bundle0.containsKey("SKU_OFFER_ID_TOKEN_LIST") && !this.q) {
                    this.M(com.android.billingclient.api.q.a(21, 2, s.u));
                    this.H(s.u);
                    return s.u;
                }
                if(TextUtils.isEmpty(c$b0.b().e())) {
                    z5 = false;
                }
                else {
                    bundle0.putString("skuPackageName", c$b0.b().e());
                    z5 = true;
                }
                if(!TextUtils.isEmpty(null)) {
                    bundle0.putString("accountName", null);
                }
                Intent intent0 = activity0.getIntent();
                if(intent0 == null) {
                    a0.i("BillingClient", "Activity\'s intent is null.");
                }
                else if(!TextUtils.isEmpty(intent0.getStringExtra("PROXY_PACKAGE"))) {
                    String s4 = intent0.getStringExtra("PROXY_PACKAGE");
                    bundle0.putString("proxyPackage", s4);
                    try {
                        bundle0.putString("proxyPackageVersion", this.e.getPackageManager().getPackageInfo(s4, 0).versionName);
                    }
                    catch(PackageManager.NameNotFoundException unused_ex) {
                        bundle0.putString("proxyPackageVersion", "package not found");
                    }
                }
                if(this.t && !list0.isEmpty()) {
                    v1 = 17;
                }
                else if(!this.r || !z5) {
                    v1 = this.n ? 9 : 6;
                }
                else {
                    v1 = 15;
                }
                future0 = this.L(() -> this.g.C(v1, "com.playstack.balatro.android", s2, s3, null, bundle0), 5000L, null, this.c);
                v2 = 78;
            }
            else {
                future0 = this.L(() -> this.g.B(3, "com.playstack.balatro.android", s, s1, null), 5000L, null, this.c);
                v2 = 80;
            }
            try {
                if(future0 == null) {
                    this.M(com.android.billingclient.api.q.a(25, 2, s.m));
                    this.H(s.m);
                    return s.m;
                }
                Bundle bundle1 = (Bundle)future0.get(5000L, TimeUnit.MILLISECONDS);
                int v3 = a0.b(bundle1, "BillingClient");
                String s5 = a0.e(bundle1, "BillingClient");
                if(v3 != 0) {
                    a0.i("BillingClient", "Unable to buy item, Error response code: " + v3);
                    com.android.billingclient.api.d d0 = s.a(v3, s5);
                    if(bundle1 != null) {
                        v2 = 23;
                    }
                    this.M(com.android.billingclient.api.q.a(v2, 2, d0));
                    this.H(d0);
                    return d0;
                }
                Intent intent1 = new Intent(activity0, ProxyBillingActivity.class);
                intent1.putExtra("BUY_INTENT", ((PendingIntent)bundle1.getParcelable("BUY_INTENT")));
                activity0.startActivity(intent1);
                return s.l;
            }
            catch(TimeoutException | CancellationException timeoutException0) {
                a0.j("BillingClient", "Time out while launching billing flow. Try to reconnect", timeoutException0);
                this.M(com.android.billingclient.api.q.a(4, 2, s.n));
                this.H(s.n);
                return s.n;
            }
            catch(Exception exception0) {
                a0.j("BillingClient", "Exception while launching billing flow. Try to reconnect", exception0);
                this.M(com.android.billingclient.api.q.a(5, 2, s.m));
                this.H(s.m);
                return s.m;
            }
        }
        this.M(com.android.billingclient.api.q.a(12, 2, s.F));
        return s.F;
    }

    @Override  // com.android.billingclient.api.a
    public final void d(g g0, d0.b b0) {
        ArrayList arrayList0;
        com.android.billingclient.api.d d0;
        if(!this.a()) {
            d0 = s.m;
            this.M(com.android.billingclient.api.q.a(2, 7, d0));
            arrayList0 = new ArrayList();
        }
        else if(!this.t) {
            a0.i("BillingClient", "Querying product details is not supported.");
            d0 = s.v;
            this.M(com.android.billingclient.api.q.a(20, 7, d0));
            arrayList0 = new ArrayList();
        }
        else if(this.L(new i(this, g0, b0), 30000L, () -> {
            this.M(com.android.billingclient.api.q.a(24, 7, s.n));
            ArrayList arrayList0 = new ArrayList();
            b0.a(s.n, arrayList0);
        }, this.G()) == null) {
            d0 = this.I();
            this.M(com.android.billingclient.api.q.a(25, 7, d0));
            arrayList0 = new ArrayList();
        }
        else {
            return;
        }
        b0.a(d0, arrayList0);
    }

    @Override  // com.android.billingclient.api.a
    public final void e(d0.e e0, c c0) {
        this.O(e0.b(), c0);
    }

    @Override  // com.android.billingclient.api.a
    public final void f(d0.a a0) {
        int v = 1;
        if(this.a()) {
            a0.h("BillingClient", "Service connection is valid. No need to re-initialize.");
            this.N(com.android.billingclient.api.q.c(6));
            a0.b(s.l);
            return;
        }
        switch(this.a) {
            case 1: {
                a0.i("BillingClient", "Client is already in the process of connecting to billing service.");
                this.M(com.android.billingclient.api.q.a(37, 6, s.d));
                a0.b(s.d);
                return;
            }
            case 3: {
                a0.i("BillingClient", "Client was already closed and can\'t be reused. Please create another instance.");
                this.M(com.android.billingclient.api.q.a(38, 6, s.m));
                a0.b(s.m);
                return;
            }
            default: {
                this.a = 1;
                a0.h("BillingClient", "Starting in-app billing setup.");
                this.h = new p(this, a0, null);
                Intent intent0 = new Intent("com.android.vending.billing.InAppBillingService.BIND");
                intent0.setPackage("com.android.vending");
                List list0 = this.e.getPackageManager().queryIntentServices(intent0, 0);
                if(list0 == null || list0.isEmpty()) {
                    v = 41;
                }
                else {
                    ServiceInfo serviceInfo0 = ((ResolveInfo)list0.get(0)).serviceInfo;
                    if(serviceInfo0 != null) {
                        String s = serviceInfo0.packageName;
                        String s1 = serviceInfo0.name;
                        if(!"com.android.vending".equals(s) || s1 == null) {
                            a0.i("BillingClient", "The device doesn\'t have valid Play Store.");
                            v = 40;
                        }
                        else {
                            ComponentName componentName0 = new ComponentName(s, s1);
                            Intent intent1 = new Intent(intent0);
                            intent1.setComponent(componentName0);
                            intent1.putExtra("playBillingLibraryVersion", this.b);
                            if(this.e.bindService(intent1, this.h, 1)) {
                                a0.h("BillingClient", "Service was bonded successfully.");
                                return;
                            }
                            a0.i("BillingClient", "Connection to Billing service is blocked.");
                            v = 39;
                        }
                    }
                }
                this.a = 0;
                a0.h("BillingClient", "Billing service unavailable on device.");
                this.M(com.android.billingclient.api.q.a(v, 6, s.c));
                a0.b(s.c);
            }
        }
    }

    private void g(Context context0, d d0, e e0, m m0, String s, r r0) {
        this.e = context0.getApplicationContext();
        g5 g50 = h5.E();
        g50.q(s);
        g50.p("com.playstack.balatro.android");
        if(r0 == null) {
            r0 = new t(this.e, ((h5)g50.j()));
        }
        this.f = r0;
        if(d0 == null) {
            a0.i("BillingClient", "Billing client should have a valid listener but the provided is null.");
        }
        this.d = new g0(this.e, d0, null, m0, null, this.f);
        this.z = e0;
        this.A = m0 != null;
        this.e.getPackageName();
    }

    // 检测为 Lambda 实现
    final void y(com.android.billingclient.api.d d0) [...]

    // 检测为 Lambda 实现
    final void z(d0.b b0) [...]
}

