package a1;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import g1.q;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

public class c {
    private final Lock a;
    private final SharedPreferences b;
    private static final Lock c;
    private static c d;

    static {
        c.c = new ReentrantLock();
    }

    c(Context context0) {
        this.a = new ReentrantLock();
        this.b = context0.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public void a() {
        this.a.lock();
        try {
            this.b.edit().clear().apply();
        }
        finally {
            this.a.unlock();
        }
    }

    public static c b(Context context0) {
        c c0;
        q.i(context0);
        Lock lock0 = c.c;
        lock0.lock();
        try {
            if(c.d == null) {
                c.d = new c(context0.getApplicationContext());
            }
            c0 = c.d;
        }
        catch(Throwable throwable0) {
            c.c.unlock();
            throw throwable0;
        }
        lock0.unlock();
        return c0;
    }

    public GoogleSignInAccount c() {
        String s = this.g("defaultGoogleSignInAccount");
        if(!TextUtils.isEmpty(s)) {
            String s1 = this.g("googleSignInAccount:" + s);
            if(s1 != null) {
                try {
                    return GoogleSignInAccount.u0(s1);
                }
                catch(JSONException unused_ex) {
                }
            }
        }
        return null;
    }

    public GoogleSignInOptions d() {
        String s = this.g("defaultGoogleSignInAccount");
        if(!TextUtils.isEmpty(s)) {
            String s1 = this.g("googleSignInOptions:" + s);
            if(s1 != null) {
                try {
                    return GoogleSignInOptions.s0(s1);
                }
                catch(JSONException unused_ex) {
                }
            }
        }
        return null;
    }

    public String e() {
        return this.g("refreshToken");
    }

    public void f(GoogleSignInAccount googleSignInAccount0, GoogleSignInOptions googleSignInOptions0) {
        q.i(googleSignInAccount0);
        q.i(googleSignInOptions0);
        this.h("defaultGoogleSignInAccount", googleSignInAccount0.v0());
        q.i(googleSignInAccount0);
        q.i(googleSignInOptions0);
        String s = googleSignInAccount0.v0();
        this.h("googleSignInAccount:" + s, googleSignInAccount0.w0());
        this.h("googleSignInOptions:" + s, googleSignInOptions0.w0());
    }

    protected final String g(String s) {
        this.a.lock();
        try {
            return this.b.getString(s, null);
        }
        finally {
            this.a.unlock();
        }
    }

    protected final void h(String s, String s1) {
        this.a.lock();
        try {
            this.b.edit().putString(s, s1).apply();
        }
        finally {
            this.a.unlock();
        }
    }

    private static final String i(String s, String s1) [...] // Inlined contents
}

